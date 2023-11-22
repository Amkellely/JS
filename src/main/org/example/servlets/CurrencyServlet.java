package main.org.example.servlets;

import main.org.example.util.EmailUtils;
import main.org.example.util.HTMLTableBuilder;
import main.org.example.util.XMLCurrencyParser;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import static main.org.example.util.ServletUtils.info;


@WebServlet("/currency")
public class CurrencyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        info(req, "currency -> doGet()");
        PrintWriter pw = resp.getWriter();
        try {
            String email = req.getParameter("mail");
            String usdCurrency = XMLCurrencyParser.getCurrency("840");
            EmailUtils.send(email, "Latest USD Currency", "<b>" + usdCurrency + "</b>");
            info(req, "currency -> send");
            pw.println("check your email");
        } catch (Exception e) {
            e.printStackTrace();
            pw.println("some error on server");
            info(req, "currency -> ERROR: " + e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        info(req, "currency -> doPost()");
        PrintWriter pw = resp.getWriter();
        try {
            String email = req.getParameter("mail");
            String usdCurrency = XMLCurrencyParser.getCurrency("840");
            String rubCurrency = XMLCurrencyParser.getCurrency("978");
            String euroCurrency = XMLCurrencyParser.getCurrency("643");
            String cnyCurrency = XMLCurrencyParser.getCurrency("156");
            Date date = new Date();
            HTMLTableBuilder builder = new HTMLTableBuilder("Currency", true,4,4,5,5,5);
            builder.addTableHeader("name", "code", "Value","Date");
            builder.addRowValues("USD", "840",usdCurrency, date.toString());
            builder.addRowValues("EURO", "643",euroCurrency, date.toString());
            builder.addRowValues("RUB", "978",rubCurrency, date.toString());
            builder.addRowValues("CNY", "156",cnyCurrency, date.toString());
            String table = builder.build();

            EmailUtils.send(email, "Latest Currencies", builder.build());
            info(req, "currency -> send");
            resp.setContentType("text/html");
            pw.println();
            pw.println("check your email");
        } catch (Exception e) {
            e.printStackTrace();
            pw.println("some error on server");
            info(req, "currency -> ERROR: " + e.getMessage());
        }
    }
}

package main.org.example.servlets;


import main.org.example.util.EmailUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;

@WebServlet("/registry")
public class RegistryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/reg.html");
        rd.forward(req, resp);//move forward with the same params and so on
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //getting parameter from HTML Registy form
        String name =  req.getParameter("name");
        String email = req.getParameter("email");
        String psw1 = req.getParameter("psw1");
        String psw2 = req.getParameter("psw2");

        //1st: volidation
        // TODO

        //2nd: send message with actiwate instractions


        //3rd: show some info in response
        PrintWriter pw = resp.getWriter();
        pw.println("check  ");
    }
}

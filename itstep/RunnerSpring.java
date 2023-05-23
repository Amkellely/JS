package itstep;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RunnerSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml ");

       /* TestBean testBean = context.getBean("testBean", TestBean.class);
        System.out.println(testBean);*/

        UserService userService = context.getBean("userService", UserService.class);
        System.out.println(userService);
    }
}

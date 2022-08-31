package edu.school21.cinema.servlets;

import edu.school21.cinema.config.ApplicationConfig;
import edu.school21.cinema.models.User;
import edu.school21.cinema.repositoties.UsersRepository;
import edu.school21.cinema.repositoties.UsersRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/signUp")
public class SignUp extends HttpServlet {

    private AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(edu.school21.cinema.config.ApplicationConfig.class);
    @Autowired
    private UsersRepository usersRepository;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        RequestDispatcher requestDispatcher = req.getRequestDispatcher(context.getBean("getSignUpJstPath", String.class));
        requestDispatcher.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {

        usersRepository.save(new User(req.getParameter("first_name"), req.getParameter("password"), null, null));

    }

}

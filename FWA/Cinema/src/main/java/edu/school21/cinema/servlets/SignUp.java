package edu.school21.cinema.servlets;


import edu.school21.cinema.models.User;
import edu.school21.cinema.repositoties.UsersRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/signUp")
public class SignUp extends HttpServlet {

    private AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(edu.school21.cinema.config.ApplicationConfig.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        RequestDispatcher requestDispatcher = req.getRequestDispatcher(context.getBean("getSignUpJstPath", String.class));
        requestDispatcher.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

         context.getBean("getUsersRepository", UsersRepository.class).save(new User(req.getParameter("first_name"),
                 req.getParameter("last_name"),
                 req.getParameter("phone"),
                 req.getParameter("password"),
                 req.getParameter("email")));

    }

}

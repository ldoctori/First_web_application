package edu.school21.cinema.servlets;

import com.zaxxer.hikari.HikariDataSource;
import edu.school21.cinema.models.User;
import edu.school21.cinema.repositoties.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Optional;

@WebServlet("/")
public class MainPage extends HttpServlet {

    private AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(edu.school21.cinema.config.ApplicationConfig.class);
    private UsersRepository usersRepository = context.getBean("getUsersRepository", UsersRepository.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        usersRepository.createUsersTable();
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(context.getBean("getMainPagePath", String.class));
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Optional <List <User>> optional = usersRepository.findByEmail(req.getParameter("EorFN"));
        if (optional.isPresent() == false || optional.get().isEmpty()) {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher(context.getBean("getSignInErrPath", String.class));
            requestDispatcher.forward(req, resp);
        }
        else {
            resp.getWriter().write(optional.get().get(0).getEmail());
        }

    }
}

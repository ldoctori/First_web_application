package edu.school21.cinema.repositoties;

import com.sun.xml.internal.bind.v2.model.core.ID;
import com.zaxxer.hikari.HikariDataSource;
import edu.school21.cinema.models.User;
import edu.school21.cinema.servlets.MainPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Optional;

@Component
public class UsersRepositoryImpl implements UsersRepository{


    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(HikariDataSource hikariDataSource) {
        this.jdbcTemplate = new JdbcTemplate(hikariDataSource);
    }

    @Override
    public Optional<List<User>> findByEmail(String emailOrFirstName) {
        Optional optional = Optional.ofNullable(this.jdbcTemplate.query("SELECT * FROM users WHERE email=?",
                new Object[]{emailOrFirstName}, (rs, rowNum) ->
                        new User(rs.getString("first_name"),
                                rs.getString("last_name"),
                                rs.getString("phone"),
                                rs.getString("password"),
                                rs.getString("email"),
                                rs.getLong("id"))));
            return optional;
    }

    @Override
    public void createUsersTable() throws IOException {

        InputStream inputStream = MainPage.class.getResourceAsStream("/sql/schema.sql");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line = bufferedReader.readLine();
        String sqlSchema = "";
        while (line != null) {
            sqlSchema += line;
            line = bufferedReader.readLine();
        }
        jdbcTemplate.update(sqlSchema, new Object[]{});
    }

    @Override
    public <S extends User> S save(S entity) {

        jdbcTemplate.update("INSERT INTO users (first_name, last_name, email, phone, password)"
                + " VALUES ('" + entity.getFirstName()
                                + "', '" + entity.getLastName()
                                + "', '" + entity.getEmail()
                                + "', '" + entity.getPhoneNumber()
                                + "', '" + entity.getPassword()
                                + "')", new Object[]{});
        return entity;
    }

    @Override
    public <S extends User> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<User> findById(ID id) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(ID id) {
        return false;
    }

    @Override
    public Iterable<User> findAll() {
        return null;
    }

    @Override
    public Iterable<User> findAllById(Iterable<ID> ids) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(ID id) {

    }

    @Override
    public void delete(User entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends ID> ids) {

    }

    @Override
    public void deleteAll(Iterable<? extends User> entities) {

    }

    @Override
    public void deleteAll() {

    }
}

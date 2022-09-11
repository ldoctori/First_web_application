package edu.school21.cinema.repositoties;
import com.sun.xml.internal.bind.v2.model.core.ID;
import edu.school21.cinema.models.User;
import org.springframework.data.repository.CrudRepository;

import java.io.IOException;
import java.util.List;
import java.util.Optional;


public interface UsersRepository extends CrudRepository<User, ID> {

    void createUsersTable() throws IOException;
    Optional<List<User>> findByEmail(String email);
}
package repositories;

import model.*;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface ProfessorRepository extends CrudRepository<Professor,Long> {
    List<Professor> findByLastName(String lastName);
    Professor findById(long id);
}
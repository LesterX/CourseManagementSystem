package model;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface Repository extends CrudRepository<Professor,Long> {
    List<Professor> findByLastName(String lastName);
}
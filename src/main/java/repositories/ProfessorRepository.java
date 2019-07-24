package repositories;

import model.*;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ProfessorRepository extends CrudRepository<Professor,Long> {
    
    @Override
    @Query
    public Iterable<Professor> findAll();
    
    List<Professor> findByLastName(String lastName);
    
    Professor findByUid(long uid);
}
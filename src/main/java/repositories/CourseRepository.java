package repositories;

import model.*;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course,Long> {
    List<Course> findByName(String name);
}
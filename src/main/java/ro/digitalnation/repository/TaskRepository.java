package ro.digitalnation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.digitalnation.models.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {

}

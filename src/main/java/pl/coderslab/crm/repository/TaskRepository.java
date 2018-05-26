package pl.coderslab.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.crm.entity.Task;
import pl.coderslab.crm.entity.User;
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    Task findTaskById(Long id);
}

package pl.coderslab.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.crm.entity.Priority;

import java.util.Optional;

public interface PriorityRepository extends JpaRepository<Priority, Long> {

    Priority findPriorityById(Long id);

    void deleteById(Long id);
}

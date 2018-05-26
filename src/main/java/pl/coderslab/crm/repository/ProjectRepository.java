package pl.coderslab.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.crm.entity.Project;

import java.util.Optional;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    Project findProjectById(Long id);

    void deleteById(Long id);
}

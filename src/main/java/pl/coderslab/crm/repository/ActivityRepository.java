package pl.coderslab.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.crm.entity.Activity;

import java.util.List;
import java.util.Optional;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {
    List<Activity> findAll();
    Activity findActivityById(Long id);
    void deleteById(Long id);
}

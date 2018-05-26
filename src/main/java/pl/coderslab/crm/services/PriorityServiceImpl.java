package pl.coderslab.crm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.crm.entity.Priority;
import pl.coderslab.crm.repository.PriorityRepository;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class PriorityServiceImpl implements PriorityService {

    @Autowired
    PriorityRepository priorityRepository;


    public void save(Priority priority){
        priorityRepository.save(priority);
    }

    public List<Priority> findAllPriority(){
        return priorityRepository.findAll();
    }

    public Priority findPriorityById(Long id){
        return priorityRepository.findPriorityById(id);
    }

    public void deletePriorityById(Long id){
        priorityRepository.deleteById(id);
    }
}

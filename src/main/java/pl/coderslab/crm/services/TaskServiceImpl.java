package pl.coderslab.crm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.crm.entity.Task;
import pl.coderslab.crm.repository.TaskRepository;

import java.util.List;
@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskRepository taskRepository;


    public void save(Task task){
        taskRepository.save(task);
    }

    public List<Task> findAllTask(){
        return taskRepository.findAll();
    }

    public Task findTaskById(Long id){
        return taskRepository.findTaskById(id);
    }
}

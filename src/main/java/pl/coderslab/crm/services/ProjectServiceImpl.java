package pl.coderslab.crm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.crm.entity.Project;
import pl.coderslab.crm.repository.ProjectRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    ProjectRepository projectRepository;



    public void save(Project project){
        projectRepository.save(project);
    }
    public List<Project> findAllProjects(){
        return projectRepository.findAll();
    }

    public Project findOneById(Long id) {
        return projectRepository.findProjectById(id);
    }

    public void deleteProjectById(Long id){
        projectRepository.deleteById(id);
    }
}
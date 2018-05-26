package pl.coderslab.crm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.crm.entity.Status;
import pl.coderslab.crm.repository.StatusRepository;

import java.util.List;

@Service
public class StatusServiceImpl implements StatusService {

    @Autowired
    StatusRepository statusRepository;


    public void save(Status status){
        statusRepository.save(status);
    }

    public List<Status> findAllStatus(){
        return statusRepository.findAll();
    }

    public Status findStatusById(Long id){
        return statusRepository.findStatusById(id);
    }
}


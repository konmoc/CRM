package pl.coderslab.crm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.coderslab.crm.entity.Role;
import pl.coderslab.crm.entity.User;
import pl.coderslab.crm.repository.RoleRepository;
import pl.coderslab.crm.repository.UserRepository;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;


    @Autowired
    RoleRepository roleRepository;


    public void save(User user){
        userRepository.save(user);
    }

    public List<User> findAllUser(){
        return userRepository.findAll();
    }

    public User findOneById(Long id){
        return userRepository.findUserById(id);
    }


    }





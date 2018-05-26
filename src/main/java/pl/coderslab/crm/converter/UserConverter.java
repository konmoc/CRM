package pl.coderslab.crm.converter;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.crm.entity.User;
import pl.coderslab.crm.services.UserServiceImpl;


public class UserConverter implements Converter<String, User> {

    @Autowired
    UserServiceImpl userService;

    @Override
    public User convert(String s) {
        return userService.findOneById(Long.parseLong(s));
    }
}
package pl.krzysiekwitkowicz.herokutodo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.krzysiekwitkowicz.herokutodo.dao.UserRepository;
import pl.krzysiekwitkowicz.herokutodo.model.User;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User findByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    public String findNameByLogin(String login) {
        return userRepository.findNameByLogin(login);
    }
}

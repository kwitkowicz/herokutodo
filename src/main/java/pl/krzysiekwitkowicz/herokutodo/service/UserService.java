package pl.krzysiekwitkowicz.herokutodo.service;

import pl.krzysiekwitkowicz.herokutodo.model.User;

public interface UserService {
    public User findByLogin(String login);

    public String findNameByLogin(String login);
}

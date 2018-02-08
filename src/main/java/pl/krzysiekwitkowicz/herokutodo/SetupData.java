package pl.krzysiekwitkowicz.herokutodo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import pl.krzysiekwitkowicz.herokutodo.dao.UserRepository;
import pl.krzysiekwitkowicz.herokutodo.model.User;

import javax.annotation.PostConstruct;

@Profile("dev")
@Component
public class SetupData {
    @Autowired
    BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    public void init() {
        final User user = new User();
        user.setLogin("jan");
        user.setName("Jan Nowak");
        user.setPassword(passwordEncoder.encode("123"));
        user.setRole("USER");

        userRepository.save(user);

    }
}

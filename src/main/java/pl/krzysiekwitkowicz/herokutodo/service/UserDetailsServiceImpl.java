package pl.krzysiekwitkowicz.herokutodo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.krzysiekwitkowicz.herokutodo.model.User;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserServiceImpl userService;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User user = this.userService.findByLogin(name);
        if (user == null) {
            throw new UsernameNotFoundException(("User " + name + " not found!"));
        }
        List<GrantedAuthority> grantedAuthorityList = new ArrayList<GrantedAuthority>();
        grantedAuthorityList.add(new SimpleGrantedAuthority(user.getRole()));

        UserDetails userDetails = (UserDetails) new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(), grantedAuthorityList);
        return userDetails;
    }
}

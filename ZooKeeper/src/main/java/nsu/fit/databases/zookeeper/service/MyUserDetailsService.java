package nsu.fit.databases.zookeeper.service;

import nsu.fit.databases.zookeeper.configuration.MyUserDetails;
import nsu.fit.databases.zookeeper.entity.User;
import nsu.fit.databases.zookeeper.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Optional<User> user = userRepo.findByLogin(name);
        return user.map(MyUserDetails::new)
                .orElseThrow(()->new UsernameNotFoundException(name + "There is no such user"));
    }
}

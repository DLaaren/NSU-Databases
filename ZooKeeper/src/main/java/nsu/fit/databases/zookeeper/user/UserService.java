package nsu.fit.databases.zookeeper.user;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class UserService {

    @GetMapping()
    public List<User> getUsers() {
        return List.of(
                new User(1L, "Ivan", Role.ROLE_ADMIN)
        );
    }

}

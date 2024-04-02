package nsu.fit.databases.zookeeper.service;

import nsu.fit.databases.zookeeper.entity.User;
import nsu.fit.databases.zookeeper.exception.ServerException;
import nsu.fit.databases.zookeeper.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserByIdOrThrow(Long id) {
        return userRepository.findById(id).orElseThrow(() ->
                new ServerException(HttpStatus.NOT_FOUND,
                        "User with id " + id + " does not exist")
        );
    }

    public void nonExistOrThrow(User user) {
        userRepository.findById(user.getId()).ifPresent(usr -> {
            throw new ServerException(HttpStatus.BAD_REQUEST,
                  "User with id " + usr.getId() + " already exists");
        });
    }

    public User getUserById(Long id) {
        return getUserByIdOrThrow(id);
    }

    public User addUser(User user) {
        nonExistOrThrow(user);
        return userRepository.save(user);
    }

    public User updateUser(Long id, User user) {
        nonExistOrThrow(user);
        return userRepository.save(user);
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
}

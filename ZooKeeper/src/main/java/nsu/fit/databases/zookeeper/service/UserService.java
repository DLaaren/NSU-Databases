package nsu.fit.databases.zookeeper.service;

import nsu.fit.databases.zookeeper.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> getAllUsers();

    Optional<User> getUserById(Long userId);

    User addUser(User user);

    Optional<User> updateUserById(Long userId, User user);

    void deleteUserById(Long userId);
}

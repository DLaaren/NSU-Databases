package nsu.fit.databases.zookeeper.service.impl;

import nsu.fit.databases.zookeeper.entity.User;
import nsu.fit.databases.zookeeper.repository.UserRepository;
import nsu.fit.databases.zookeeper.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(Long userId) {
        return userRepository.findById(userId);
    }

    @Override
    public User addUser(User user) {
        userRepository.save(user);
        return user;
    }

    @Override
    public Optional<User> updateUserById(Long userId, User user) {
        if (!userRepository.findById(userId).isPresent()) {
            return Optional.empty();
        }
        userRepository.save(user);
        return Optional.of(user);
    }

    @Override
    public void deleteUserById(Long userId) {
        userRepository.deleteById(userId);
    }
}

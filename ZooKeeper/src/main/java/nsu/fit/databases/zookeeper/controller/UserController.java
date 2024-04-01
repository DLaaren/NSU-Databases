package nsu.fit.databases.zookeeper.controller;

import lombok.AllArgsConstructor;
import nsu.fit.databases.zookeeper.entity.User;
import nsu.fit.databases.zookeeper.entity.User;
import nsu.fit.databases.zookeeper.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAnimals() {
        List<User> users = userService.getAllUsers();
        if (users.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.ok(users);
    }

    @GetMapping("{id}")
    public ResponseEntity<User> getAnimal(@PathVariable("id") Long userId) {
        Optional<User> user = userService.getUserById(userId);
        if (!user.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(user.get());
    }

    @PostMapping
    public ResponseEntity<User> addAnimal(@RequestBody User user) {
        User registeredAnimal = userService.addUser(user);
        return new ResponseEntity<>(registeredAnimal, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<User> updateAnimal(@PathVariable("id") Long userId,
                                               @RequestBody User user) {
        Optional<User> _user = userService.updateUserById(userId, user);
        if (!_user.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(_user.get());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteAnimal(@PathVariable("id") Long userId) {
        userService.deleteUserById(userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

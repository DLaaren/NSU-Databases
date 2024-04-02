package nsu.fit.databases.zookeeper.controller;

import lombok.AllArgsConstructor;
import nsu.fit.databases.zookeeper.dto.UserDto;
import nsu.fit.databases.zookeeper.entity.JobTitle;
import nsu.fit.databases.zookeeper.entity.User;
import nsu.fit.databases.zookeeper.service.UserService;
import org.hibernate.annotations.processing.SQL;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@AllArgsConstructor

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private UserService userService;
    private ModelMapper userMapper;

    @GetMapping("/all")
    @ResponseBody
    public List<UserDto> getUsers() {
        return userService.getAllUsers().stream().map(this::convertToDto).toList();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public UserDto getUser(@PathVariable("id") Long id) {
        return convertToDto(userService.getUserById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public UserDto addUser(@RequestBody UserDto userDto) {
        return convertToDto(userService.addUser(convertToEntity(userDto)));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public UserDto updateUser(@PathVariable("id") Long id,
                           @RequestBody UserDto userDto) {
        if (!Objects.equals(id, userDto.getId()))
        {
            // SERVET EXPEFETE
            throw new IllegalArgumentException("IDs don't match");
        }
        return convertToDto(userService.updateUser(id, convertToEntity(userDto)));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable("id") Long id) {
        userService.deleteUserById(id);
    }

    private UserDto convertToDto(User user) {
        return userMapper.map(user, UserDto.class);
    }

    private User convertToEntity(UserDto userDto) {
        System.out.println("\n\n" +  userDto.toString() + "\n\n");
        System.out.println("\n\n" + userMapper.map(userDto, User.class).toString() + "\n\n");
        return userMapper.map(userDto, User.class);
    }
}

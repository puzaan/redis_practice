package com.example.redis.controller;

import com.example.redis.doa.UserDoa;
import com.example.redis.models.User;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UserController {
private final UserDoa userDoa;

    public UserController(UserDoa userDoa) {
        this.userDoa = userDoa;
    }

    @PostMapping
    public User createUser(@RequestBody User user){
        user.setUserId(UUID.randomUUID().toString());
        return userDoa.save(user);
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable String id){
        return userDoa.get(id);
    }

    @GetMapping
    public List<User>findAll(){
        Map<Object, Object> user = userDoa.findAll();
        Collection<Object> values = user.values();
        return values.stream().map(value -> (User)values).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id){
        userDoa.deleteUser(id);
    }

    @PutMapping("/update")
    public User updateuser(@RequestBody User user){
        return userDoa.updateUser(user);
    }
}

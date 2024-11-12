package com.example.redis.controller;

import com.example.redis.doa.UserAddressImp;
import com.example.redis.models.UserAddress;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/address")
public class UserAddressController {
    private final UserAddressImp userAddressImp;

    public UserAddressController(UserAddressImp userAddressImp) {
        this.userAddressImp = userAddressImp;
    }

    @PostMapping
    public UserAddress createUserAddress(@RequestBody UserAddress userAddress){
    return userAddressImp.create(userAddress);

    }

    @GetMapping("/{id}")
    public Optional<UserAddress> getUserAddress(@PathVariable String id){
        return userAddressImp.getById(id);
    }

    @GetMapping
    public List<UserAddress> findAll(){
       return userAddressImp.getAll();
    }

    @DeleteMapping("/{id}")
    public void deleteUserAddress(@PathVariable String id){
        userAddressImp.deleteAddress(id);
    }

    @PutMapping("/update")
    public UserAddress updateUserAddress(@RequestBody UserAddress user){
        return userAddressImp.updateUser(user);
    }
}

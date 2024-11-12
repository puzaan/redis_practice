package com.example.redis.doa;

import com.example.redis.models.UserAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class userAddressImp {
    @Autowired
    private  UserAddressRepository userAddressRepository;

    private UserAddress create(UserAddress userAddress){
        userAddressRepository.save(userAddress);
        return userAddress;
    }

    private void deleteAddress(String id){
        userAddressRepository.deleteById(id);
    }

    private Optional<UserAddress> getById(String id){
        return userAddressRepository.findById(id);
    }
}

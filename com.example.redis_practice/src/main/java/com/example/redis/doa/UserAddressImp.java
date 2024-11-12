package com.example.redis.doa;

import com.example.redis.models.UserAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserAddressImp {
    private  final UserAddressRepository userAddressRepository;

    public UserAddressImp(UserAddressRepository userAddressRepository) {
        this.userAddressRepository = userAddressRepository;
    }

    public UserAddress create(UserAddress userAddress){
        userAddress.setTtl(120L);
        userAddressRepository.save(userAddress);
        return userAddress;
    }

    public void deleteAddress(String id){
        userAddressRepository.deleteById(id);
    }

    public Optional<UserAddress> getById(String id){
        return userAddressRepository.findById(id);
    }

    public List<UserAddress> getAll(){
        return (List<UserAddress>) userAddressRepository.findAll();
    }

    public UserAddress updateUser(UserAddress userAddress){
        UserAddress userAddress1 = userAddressRepository.findById(userAddress.getId()).orElseThrow(() -> new RuntimeException("Entity not found"));

        userAddress1.setAddressName(userAddress.getAddressName());
        userAddressRepository.save(userAddress1);
        return userAddress;
    }

}

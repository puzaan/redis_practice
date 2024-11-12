package com.example.redis.doa;

import com.example.redis.models.UserAddress;
import org.springframework.data.repository.CrudRepository;


public interface UserAddressRepository extends CrudRepository<UserAddress,String> {
}

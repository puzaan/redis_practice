package com.example.redis.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@RedisHash("user_address")
public class UserAddress implements Serializable {
    @Id
    private String id;
    private String addressName;
    private String userId;
}

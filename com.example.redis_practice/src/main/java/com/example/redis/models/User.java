package com.example.redis.models;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class User implements Serializable {
    private String userId;
    private String name;
    private String phone;
    private String email;
}

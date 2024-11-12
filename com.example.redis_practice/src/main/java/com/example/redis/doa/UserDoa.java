package com.example.redis.doa;

import com.example.redis.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.time.Duration;
import java.util.Map;

@Repository
public class UserDoa {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    private static final String KEY = "USER";
    public User save(User user){
        redisTemplate.opsForHash().put(KEY,user.getUserId(), user);
        redisTemplate.expire(KEY, Duration.ofMinutes(5));
        return user;
    }

    public User get(String id){
        return (User) redisTemplate.opsForHash().get(KEY,id);
    }

    public Map<Object,Object> findAll(){
        Map<Object, Object> users = redisTemplate.opsForHash().entries(KEY);

        if (!users.isEmpty()) {
            redisTemplate.expire(KEY, Duration.ofMinutes(5));
        }
        return users;

    }

    public void deleteUser(String id){
        redisTemplate.opsForHash().delete(KEY,id);
    }

    public User updateUser(User user){
        User user1= (User) redisTemplate.opsForHash().get(KEY,user.getUserId());
        if(user1!= null){
            user1.setEmail(user.getEmail());
            user1.setName(user.getName());
            user1.setPhone(user.getPhone());
            redisTemplate.opsForHash().put(KEY,user.getUserId(),user1);
            return user1;
        }else {
            throw new RuntimeException("User not found");
        }

    }


}

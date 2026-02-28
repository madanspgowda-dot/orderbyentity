package com.example.orderByname;

import org.springframework.stereotype.Service;

@Service
public class UserServices {
    private final UserRepository userrepo;

    public UserServices(UserRepository userrepo) {
        this.userrepo = userrepo;
    }
    public UserEntity saveuserdata(UserEntity userEntity){
        return userrepo.save(userEntity);
    }
}

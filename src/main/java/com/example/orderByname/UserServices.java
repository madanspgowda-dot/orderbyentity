package com.example.orderByname;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServices {
    private final UserRepository userrepo;

    public UserServices(UserRepository userrepo) {
        this.userrepo = userrepo;
    }
    public UserEntity saveuserdata(UserEntity userEntity){
        return userrepo.save(userEntity);
    }
    public List<UserEntity> datapagename(String direction){
        Sort sort;
        if(direction.equals("asc")){
           sort= Sort.by("name").ascending();
        }
        else{
           sort= Sort.by("name").descending();
        }
        return userrepo.findAll(sort);
    }
    public void deleterecoeds(Long id){
         userrepo.deleteById(id);
    }
    public UserEntity editbyid(Long id){
        return userrepo.findById(id).orElseThrow();
    }
    public void deleteallrecords(){
        userrepo.deleteAll();
    }
}

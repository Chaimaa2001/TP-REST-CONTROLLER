package com.example.tp3_controller_rest.service;

import com.example.tp3_controller_rest.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserService {
    private List<User> userList;

    public UserService()
    {
        userList=new ArrayList<>();
        User user1=new User(1,"MOHAMED","mhd@gmail.com");
        User user2=new User(2,"MOAD","moad@gmail.com");
        User user3=new User(3,"Sana","sana@gmail.com");
        User user4=new User(4,"Ahlam","Ahlam@gmail.com");
        userList.addAll(Arrays.asList(user1,user2,user3,user4));
    }
    public User getUser(Integer id)
    {
        for(User user:userList){
            if(id==user.getId()){
                return user;
            }
        }
        return null;
    }
    public void suppUser(Integer id){
        for(User user:userList){
            if(id==user.getId()){
                userList.remove(id);
            }
        }
    }
    public List<User>getUsers(){
        return userList;
    }

    public String updateUser(int id,User user){
        int i=0;
        for(User u:userList){
            if(u.getId()==id){
                userList.set(i,user);
                return String.format("L'utilisateur %s est bien modifié !",id);
            }
            else
                i++;
        }
        return String.format("L'utilisateur %s n'existe pas !",id);
    }

    public String addUser(User user){
        userList.add(user);
        return  String.format("L'utilisateur %s est bien ajouté !",user.getId());
    }
}

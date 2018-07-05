package com.forum.service;

import com.forum.entity.User;

import java.util.List;

public interface UserService {
    void save(User user) throws Exception;
    void deleteUserByName(String userName) throws Exception;
    User selectUserById(Integer id)  throws Exception;
    User selectUserByName(String userName) throws Exception;
    boolean userIsExist(String username)  throws Exception;
    void updateByIdSelective(User user) throws Exception;
    List<User> selectAllUsers() throws Exception;

}

package com.forum.mapper;

import com.forum.entity.User;

import java.util.List;

public interface UserMapper {

    void insertUser(User user)throws Exception;

    void deleteUser(String userName)throws Exception;

    User selectUserById(Integer id) throws Exception;

    User selectUserByName(String userName) throws Exception;

    void updateByIdSelective(User user);

    List<User> selectAllUsers();

}

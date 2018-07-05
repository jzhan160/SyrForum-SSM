package com.forum.service.impl;

import com.forum.entity.User;
import com.forum.mapper.UserMapper;
import com.forum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserMapper userMapper;

    @Override
    public void save(User user) throws Exception{
        userMapper.insertUser(user);
    }

    @Override
    public void deleteUserByName(String userName) throws Exception{
        userMapper.deleteUser(userName);
    }

    @Override
    public User selectUserById(Integer id) throws Exception {
        User user = userMapper.selectUserById(id);
        return user;
    }

    @Override
    public User selectUserByName(String userName) throws Exception {
        User user = userMapper.selectUserByName(userName);
        return user;
    }

    @Override
    public boolean userIsExist(String username) throws Exception {
        User user = userMapper.selectUserByName(username);
        if(user == null){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public void updateByIdSelective(User user) throws Exception {
        userMapper.updateByIdSelective(user);
    }

    @Override
    public List<User> selectAllUsers() throws Exception {
        return userMapper.selectAllUsers();
    }
}

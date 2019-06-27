package com.graph.Service.Impl;

import com.graph.DAO.DataBaseDAO;
import com.graph.Domain.User;
import com.graph.Service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private static Logger UserLoger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    DataBaseDAO dataBaseDAO;

    @Override
    public User UserLogin(String username, String password) {
            UserLoger.info("User-Sign-IN"+username);
            return dataBaseDAO.userLogin(username,password);
    }

    @Override
    public boolean userRegist(String username, String email, String password, String phone) {
        return dataBaseDAO.userRegist(username,phone,password,email);
    }

    @Override
    public User getMessage(String username) {
        return dataBaseDAO.userMessage(username);
    }

    @Override
    public boolean userChange(String username, String email, String password, String phone) {
        return dataBaseDAO.userChange(username,phone,password,email);
    }
}

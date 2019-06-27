package com.graph.Service;

import com.graph.Domain.User;

public interface UserService {
    User UserLogin(String username, String password);

    boolean userRegist(String username, String email, String password, String phone);

    User getMessage(String username);

    boolean userChange(String username, String email, String password, String phone);
}

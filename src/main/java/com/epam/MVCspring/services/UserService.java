package com.epam.MVCspring.services;

import com.epam.MVCspring.beans.User;

public interface UserService {
    User getUser(String login);
}

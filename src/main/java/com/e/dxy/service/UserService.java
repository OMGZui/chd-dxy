package com.e.dxy.service;

import com.e.dxy.domain.UserDomain;

public interface UserService {
    UserDomain getIfPresent(Integer id);
}

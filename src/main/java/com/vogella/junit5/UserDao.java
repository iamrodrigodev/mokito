package com.vogella.junit5;

public interface UserDao {
    void save(User user);

    User find(Integer id);
}


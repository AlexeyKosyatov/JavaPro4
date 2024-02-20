package ru.stepup.javapro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserService {

    private UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void create(User user) {
        userDao.create(user);
    }

    public void deleteAll() {
        userDao.deleteAll();
    }

    public List<User> selectAll() {
        return userDao.selectAll();
    }

    public User selectById(Long id) {
        return userDao.selectById(id);
    }

    public void deleteById(Long id) {
        userDao.deleteById(id);
    }
}


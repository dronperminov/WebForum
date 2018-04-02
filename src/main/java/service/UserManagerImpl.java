package service;

import java.util.List;

import dao.UserDAO;
import model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

public class UserManagerImpl implements UserManager {
    @Autowired
    private UserDAO userDAO;

    //@Override
    @Transactional
    public void insertUser(UserEntity user) {
        userDAO.insertUser(user);
    }

    @Transactional
    public void updateUser(UserEntity User) {
        userDAO.updateUser(User);
    }

    //@Override
    @Transactional
    public void deleteUser(UserEntity user) {
        userDAO.deleteUser(user);
    }

    //@Override
    @Transactional
    public UserEntity getUserById(int userId) {
        return userDAO.getUserById(userId);
    }

    //@Override
    @Transactional
    public UserEntity getUser(String login) {
        return userDAO.getUser(login);
    }

    //@Override
    @Transactional
    public List<UserEntity> getUsers() {
        return userDAO.getUsers();
    }

    @Transactional
    public List<UserEntity> getUsersByName(String name, String surname) {
        return userDAO.getUsersByName(name, surname);
    }
}

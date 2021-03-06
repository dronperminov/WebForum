package dao;

import model.UserEntity;

import java.util.List;

public interface UserDAO {
    void insertUser(UserEntity user);
    void updateUser(UserEntity user);
    void deleteUser(UserEntity user);

    UserEntity getUserById(int userId);
    UserEntity getUser(String login);

    List<UserEntity> getUsers();
    List<UserEntity> getUsersByName(String name, String surname);
}

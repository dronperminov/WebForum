package service;

import java.util.List;
import model.UserEntity;

public interface UserManager {
    void insertUser(UserEntity user);
    void updateUser(UserEntity user);

    UserEntity getUserById(int userId);
    UserEntity getUser(String login);

    List<UserEntity> getUsers();
    List<UserEntity> getUsersByName(String name, String surname);
}

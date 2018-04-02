package dao;

import java.util.List;
import model.UserEntity;

public interface UserDAO {
    void insertUser(UserEntity user);
    void updateUser(UserEntity user);

    UserEntity getUserById(int userId);
    UserEntity getUser(String login);

    List<UserEntity> getUsers();
    List<UserEntity> getUsersByName(String name, String surname);
}

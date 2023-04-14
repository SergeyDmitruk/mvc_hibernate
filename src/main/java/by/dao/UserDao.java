package by.dmitruk.dao;

import by.dmitruk.model.User;

import java.util.List;

public interface UserDao {
    public List<User> getAllUsers();
    public User getUserById(int id);
    public void deleteUserById(int id);
    public void createUser(User user);
    public void updateUser(User user, int id);
}

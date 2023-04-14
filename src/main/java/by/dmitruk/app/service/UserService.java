package by.dmitruk.app.service;

import by.dmitruk.app.model.User;


import java.util.List;


public interface UserService {
public List<User> getAllUsers();

public User getUserById(int id);

public void deleteUserById(int id);

public void createUser(User user);

public void updateUser(User user, int id);
}

package by.dmitruk.app.service;

import by.dmitruk.app.dao.UserDao;
import by.dmitruk.app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

private UserDao dao;

@Autowired
public UserServiceImpl(UserDao dao) {
    this.dao = dao;
}

@Override
@Transactional(readOnly = true)
public List<User> getAllUsers() {
    return dao.getAllUsers();
}

@Override
@Transactional(readOnly = true)
public User getUserById(int id) {
    return dao.getUserById(id);
}

@Override
@Transactional
public void deleteUserById(int id) {
    dao.deleteUserById(id);
}

@Override
@Transactional
public void createUser(User user) {
    dao.createUser(user);
}

@Override
@Transactional
public void updateUser(User user, int id) {
    dao.updateUser(user, id);
}
}

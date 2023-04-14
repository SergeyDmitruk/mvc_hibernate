package by.dmitruk.dao;

import by.dmitruk.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{
@Autowired
private EntityManager em;

    public UserDaoImpl(EntityManager em) {

    }

    public List<User> getAllUsers() {
       return em.createQuery("from User").getResultList();
    }

    public User getUserById(int id) {
        return em.find(User.class,id);
    }

    public void deleteUserById(int id) {
        em.remove(getUserById(id));

    }

    public void createUser(User user) {
em.persist(user);
    }

    public void updateUser(User userUp, int id) {
        User user = getUserById(id);
        user.setName(userUp.getName());
        user.setCity(userUp.getCity());

    }
}

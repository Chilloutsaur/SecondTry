package webApp.dao;

import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import webApp.model.User;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
@Transactional
public class UserDaoImpl implements UserDao {
    @Autowired
    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return entityManager.createQuery("select user from User user", User.class).getResultList();
    }


    @Override
    @Transactional(readOnly = true)
    public User getUserById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void deleteUser(Long id) {
        entityManager.getTransaction().begin();
        entityManager.remove(getUserById(id));
        entityManager.getTransaction().commit();
    }

    @Override
    public void addUser(User user) {
        if (user.getId() == null) {
            entityManager.getTransaction().begin();
            entityManager.merge(user);
            System.out.println(user + "Add");
            entityManager.getTransaction().commit();
        } else {
            entityManager.getTransaction().begin();
            User oldUser = getUserById(user.getId());
            oldUser.setName(user.getName());
            oldUser.setLastName(user.getLastName());
            System.out.println(oldUser + " update");
            entityManager.getTransaction().commit();
        }
    }
}

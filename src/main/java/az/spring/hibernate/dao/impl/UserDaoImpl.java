package az.spring.hibernate.dao.impl;

import az.spring.hibernate.dao.CrudDao;
import az.spring.hibernate.dao.UserDao;
import az.spring.hibernate.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public class UserDaoImpl extends AbstractSessionFactory implements UserDao{

    @Transactional
    @Override
    public void save(User user) {
        getSession().save(user);
    }

    @Transactional
    @Override
    public void update(User user) {
        getSession().update(user);
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        User user = findById(id)
                .orElseThrow(RuntimeException::new);
        getSession().delete(user);
    }

    @Transactional
    @Override
    public Optional<User> findById(Integer id) {
        return Optional.ofNullable(getSession().get(User.class,id));
    }


    @Transactional
    @Override
    public List<User> findAll() {
        return getSession().
                createQuery("select u from User u").
                list();
    }

    @Transactional
    @Override
    public List<User> findByName(String name) {
        return getSession().createQuery("select u from User u where u.name=:name")
                .setParameter("name",name).list();
    }
}

package az.spring.hibernate.dao;

import az.spring.hibernate.model.User;

import java.util.List;

public interface UserDao extends CrudDao<User,Integer> {
    List<User> findByName(String name);
}

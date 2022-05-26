package az.spring.hibernate;

import az.spring.hibernate.config.SpringHibernateConfig;
import az.spring.hibernate.dao.UserDao;
import az.spring.hibernate.model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HibernateApplication {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(SpringHibernateConfig.class);

        UserDao userDao = context.getBean(UserDao.class);
        System.out.println(userDao.findByName("Eli"));


//        System.out.println(userDao.getUserById(1002));
    }
}

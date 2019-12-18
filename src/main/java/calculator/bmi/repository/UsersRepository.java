package calculator.bmi.repository;

import calculator.bmi.model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsersRepository {

    // public static List<User> usersList = new ArrayList<>();

    @Autowired
    HibernateSessionFactoryService hsfs;


    public void addNewUser(User user) {
        Session session = hsfs.getSession();
        Transaction tx = session.beginTransaction();
        session.save(user);
        tx.commit();
        session.close();


    }

    public void updateUser(User user) {
        Session session = hsfs.getSession();
        Transaction tx = session.beginTransaction();
        session.update(user);
        tx.commit();
        session.close();


    }

    public User getUserById(int id) {
        Session session = this.hsfs.getSession();
        User user = (User) session.createQuery("FROM calculator.bmi.model.User WHERE id = " + id).uniqueResult();
        session.close();
        return user;
    }


    public static double bmiResult(double wzrost, double waga, String plec) {
        double result = 0;
        double preparedWzrost = wzrost / 100;
        if (plec.equals("M") || plec.equals("m")) {
            result = waga / (Math.pow(preparedWzrost, 2));
        } else if (plec.equals("K") || plec.equals("k")) {
            result = waga / (Math.pow(preparedWzrost, 2));
        } else {
        }
        return result;

    }


}


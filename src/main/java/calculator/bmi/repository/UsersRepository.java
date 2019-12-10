package calculator.bmi.repository;

import calculator.bmi.model.User;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UsersRepository {

    public static List<User> usersList = new ArrayList<>();


    public static void addNewUser(User user) {

        usersList.add(user);


    }


    public static List<User> getUserById(Long id) {
        List<User> result = new ArrayList<>();
        for (User user : usersList) {
            if (user.getId().equals(id)) {
                result.add(user);
            }
        }
        return result;

    }

    public static double bmiResult(double wzrost, double waga, char plec) {
        double result = 0;
        double preparedWzrost = wzrost / 100;
        if (plec == 'M') {
            result = waga / (Math.pow(preparedWzrost, 2));
        } else if (plec == 'K') {
            result = waga / (Math.pow(preparedWzrost, 2));
        } else {
        }
        return result;

    }


}


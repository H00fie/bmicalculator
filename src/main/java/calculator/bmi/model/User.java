package calculator.bmi.model;

public class User {

    private double height;
    private double weight;
    private char sex;
    private Long id;

    public User(double height, double weight, char sex, Long id) {
        this.height = height;
        this.weight = weight;
        this.sex = sex;
        this.id = id;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

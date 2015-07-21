package beans;

import java.io.Serializable;

/**
 * Created by student on 19/7/15.
 */
public class Person implements Serializable {
    private int id;
    private String name;
    private String phone;
    private Integer money;
    private Integer age;

    public Person() {
    }

    public Person(int id, String name, String phone, Integer money, Integer age) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.money = money;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", money=" + money +
                ", age=" + age +
                '}';
    }
}

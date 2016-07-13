package mySpring;

import lombok.Value;

import java.util.Date;

/**
 * Created by Evegeny on 13/07/2016.
 */
@Value
public class Person {
    private String name;
    private int age;
    private Date birthday;

    @java.beans.ConstructorProperties({"name", "age", "birthday"})
    public Person(String name, int age, Date birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }
}

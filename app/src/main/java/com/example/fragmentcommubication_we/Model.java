package com.example.fragmentcommubication_we;

import java.io.Serializable;

public class Model implements Serializable {
    String name;
    String Age;
    String percentage;
    String grade;

    public Model(String name, String age, String percentage, String grade) {
        this.name = name;
        Age = age;
        this.percentage = percentage;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return Age;
    }

    public String getPercentage() {
        return percentage;
    }

    public String getGrade() {
        return grade;
    }
}

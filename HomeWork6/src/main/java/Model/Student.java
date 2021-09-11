package Model;

import java.util.Objects;

//First task of home work
public class Student {
    private String name;
    private int age;
    private String group;

    public Student(String name, int age, String group){
        this.name = name;
        this.age = age;
        this.group = group;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && Objects.equals(name, student.name) && Objects.equals(group, student.group);
    }

    public int hashCode() {
        return (int)(31*(name == null? 0 : name.hashCode()) + age + (group == null? 0 : group.hashCode()));
    }
}

package main.java.br.com.brandao.helloworld.entity;
import lombok.Data;
import java.util.UUID;
import java.util.Date;

@Data
public class Student {
    private String name;
    private int age;
    private UUID id;
    private Date dob;

    public Student(){
        
    }
    public Student(String name, int age, UUID id, Date dob) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.dob = dob;
    }

    public String getName() {
        return name;
    }


    public int getAge() {
        return age;
    }

    public UUID getId(){
        return id;
    }

    public Date getDob(){
        return dob;
    }
}
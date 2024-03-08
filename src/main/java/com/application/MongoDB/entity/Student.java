package com.application.MongoDB.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document(collection = "student")
public class Student {

    @Id
    private String id;

    private String name;

    @Field(name = "mail")
    private String email;

    //One to one
    @DBRef // This Annotation will refere to separate collection. it will show relationship b/w two class
    private Department department;

    @DBRef // one to Many
    private List<Subject> subjects;

    @Transient //If you want the ignore the field in Database
    // then use transient, But when you will hit api then in
    // response you will get this field
    private double percentage;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public double getPercentage() {
        if(subjects != null && subjects.size() > 0) {
            int total = 0;
            // int total = subjects.stream().mapToInt(Subject::getMarksObtained).sum();
            for (Subject subject: subjects) {
                total += subject.getMarksObtained();
            }
            return total/subjects.size();
        }
        return 0.0;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }
}

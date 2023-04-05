package edu.hccs.myspring;

public class Student {
    private int id;
    private String name;
    private double gpa;
    private String email;
    private String gender;
    public Student(int id, String name, double gpa, String email, String gender) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
        this.email = email;
        this.gender = gender;

    }
    public Student() {
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
    public void setName(String first_name) {
        this.name = first_name;
    }
    public double getGpa() {
        return gpa;
    }
    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }

}

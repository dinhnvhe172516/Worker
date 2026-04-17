package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SalaryHistory {
    private String id;
    private String name;
    private int age;
    private double salary;
    private SalaryStatus status;
    private LocalDate date;
    private String workLocation;

    public SalaryHistory() {
    }

    public SalaryHistory(String id, String name, int age, double salary, SalaryStatus status, LocalDate date, String workLocation) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.status = status;
        this.date = date;
        this.workLocation = workLocation;
    }

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public SalaryStatus getStatus() {
        return status;
    }

    public void setStatus(SalaryStatus status) {
        this.status = status;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getWorkLocation() {
        return workLocation;
    }

    public void setWorkLocation(String workLocation) {
        this.workLocation = workLocation;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return String.format("%-10s%-15s%-10d%-15.0f%-15s%-20s", id, name, age, salary, status, date.format(formatter));
    }
}

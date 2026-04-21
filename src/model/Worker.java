package model;

public class Worker {
    private String id;
    private String name;
    private int age;
    private double salary;
    private String workLocation;

    /**
     * Default constructor for Worker.
     */
    public Worker() {
    }

    /**
     * Parameterized constructor for Worker.
     * 
     * @param id Worker ID.
     * @param name Worker name.
     * @param age Worker age.
     * @param salary Worker salary.
     * @param workLocation Worker work location.
     */
    public Worker(String id, String name, int age, double salary, String workLocation) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
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

    public String getWorkLocation() {
        return workLocation;
    }

    public void setWorkLocation(String workLocation) {
        this.workLocation = workLocation;
    }

    /**
     * Returns a formatted string representation of the worker.
     * 
     * @return Formatted worker info.
     */
    @Override
    public String toString() {
        return String.format("%-10s%-15s%-10d%-15.0f%-20s", id, name, age, salary, workLocation);
    }
}

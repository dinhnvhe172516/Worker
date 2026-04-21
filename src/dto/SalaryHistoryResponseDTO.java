package dto;

import model.SalaryStatus;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SalaryHistoryResponseDTO {
    private String id;
    private String name;
    private int age;
    private double salary;
    private SalaryStatus status;
    private LocalDate date;

    /**
     * Default constructor for SalaryHistoryResponseDTO.
     */
    public SalaryHistoryResponseDTO() {
    }

    /**
     * Parameterized constructor for SalaryHistoryResponseDTO.
     * 
     * @param id Worker ID.
     * @param name Worker name.
     * @param age Worker age.
     * @param salary Current salary.
     * @param status UP or DOWN.
     * @param date Date of change.
     */
    public SalaryHistoryResponseDTO(String id, String name, int age, double salary, SalaryStatus status, LocalDate date) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.status = status;
        this.date = date;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }
    public SalaryStatus getStatus() { return status; }
    public void setStatus(SalaryStatus status) { this.status = status; }
    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    /**
     * Returns a formatted string representation of the history DTO.
     * 
     * @return Formatted string.
     */
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return String.format("%-10s%-20s%-10d%-15.0f%-15s%-20s", id, name, age, salary, status, date.format(formatter));
    }
}

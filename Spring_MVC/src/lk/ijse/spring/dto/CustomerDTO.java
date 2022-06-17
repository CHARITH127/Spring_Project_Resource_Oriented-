package lk.ijse.spring.dto;

public class CustomerDTO {
    private String name;
    private String salary;

    public CustomerDTO() {
    }

    public CustomerDTO(String name, String salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "name='" + name + '\'' +
                ", salary='" + salary + '\'' +
                '}';
    }
}

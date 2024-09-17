package core.practise;

public class Employee {

    long empId;
    String name;
    int age;


    public Employee() {
    }

    public Employee(long empId, String name, int age) {
        this.empId = empId;
        this.name = name;
        this.age = age;
    }

    public long getEmpId() {
        return empId;
    }

    public void setEmpId(long empId) {
        this.empId = empId;
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

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

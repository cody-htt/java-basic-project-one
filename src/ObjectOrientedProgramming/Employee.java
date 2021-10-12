package ObjectOrientedProgramming;

public class Employee {

    private String employeeFirstName;
    private String employeeLastName;
    private String employeePosition;
    private int employeeExp;
    private double employeeSalary;

    public Employee() {

    }

    public Employee(String employeeFirstName, String employeeLastName, String employeePosition) {
        this(employeeFirstName, employeeLastName, employeePosition, 0, 0);
    }

    public Employee(
            String employeeFirstName,
            String employeeLastName,
            String employeePosition,
            int employeeExp,
            double employeeSalary) {
        this.employeeFirstName = employeeFirstName;
        this.employeeLastName = employeeLastName;
        this.employeePosition = employeePosition;
        this.employeeExp = employeeExp;
        this.employeeSalary = employeeSalary;
    }

    public String getEmployeeFirstName() {
        return employeeFirstName;
    }

    public void setEmployeeFirstName(String employeeFirstName) {
        this.employeeFirstName = employeeFirstName;
    }

    public String getEmployeeLastName() {
        return employeeLastName;
    }

    public void setEmployeeLastName(String employeeLastName) {
        this.employeeLastName = employeeLastName;
    }

    public String getEmployeePosition() {
        return employeePosition;
    }

    public void setEmployeePosition(String employeePosition) {
        this.employeePosition = employeePosition;
    }

    public int getEmployeeExp() {
        return employeeExp;
    }

    public void setEmployeeExp(int employeeExp) {
        this.employeeExp = employeeExp;
    }

    public double getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(double employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    @Override
    public String toString() {
        return getEmployeeFirstName() + " " + getEmployeeLastName()
                + " is the company " + getEmployeePosition() + " , his/her has "
                + getEmployeeExp() + " experience and earn " + getEmployeeSalary() + " $";
    }
}

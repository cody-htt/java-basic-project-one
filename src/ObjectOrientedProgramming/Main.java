package ObjectOrientedProgramming;

public class Main {

    public static void main(String[] args) {

        Employee[] companyStaffs = new Employee[5];

        companyStaffs[0] = new Employee("John", "Wick", "CEO", 10, 2500);
        companyStaffs[1] = new Employee("Vladimir", "Shatokhin", "Manager", 8, 2000);
        companyStaffs[2] = new Employee("Tung", "Huynh", "QC");
        companyStaffs[3] = new Employee("Tobi", "Nguyen", "QC");
        companyStaffs[4] = new Employee();

        companyStaffs[2].setEmployeeExp(3);
        companyStaffs[2].setEmployeeSalary(1000);

        companyStaffs[3].setEmployeeExp(3);
        companyStaffs[3].setEmployeeSalary(1000);

        companyStaffs[4].setEmployeeFirstName("Phuong");
        companyStaffs[4].setEmployeeLastName("Trinh");
        companyStaffs[4].setEmployeePosition("QC");
        companyStaffs[4].setEmployeeExp(2);
        companyStaffs[4].setEmployeeSalary(900);

        double totalMonthlySalary = 0;

        for (Employee employee : companyStaffs) {
            System.out.println(employee.toString());
            totalMonthlySalary += employee.getEmployeeSalary();
        }

        System.out.printf("The total monthly salary of the employees is %.2f $", totalMonthlySalary);

    }

}

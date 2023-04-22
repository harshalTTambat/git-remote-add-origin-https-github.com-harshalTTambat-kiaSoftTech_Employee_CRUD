package CompanyEmployee;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int id;
        String name;
        System.out.println("Welcome!!");
        EmployeeDaoInterface emp = new EmployeeDao();
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("1. Add Employee \n"+
                    "2. Show all Employee \n"+
                    "3. Show Employee by ID \n"+
                    "4. Update Employee\n"+
                    "5. Delete Employee \n"+
                    "6. Exit \n");

            System.out.println("Enter choice: ");
            int chose = sc.nextInt();
            switch (chose){
                case 1:
                    Employee employee = new Employee();
                    System.out.println("Enter Employee ID: ");
                    id = sc.nextInt();
                    employee.setId(id);

                    System.out.println("Enter name: ");
                    name = sc.next();
                    employee.setName(name);

                    System.out.println("Enter age: ");
                    int age = sc.nextInt();
                    employee.setAge(age);

                    System.out.println("Enter salary: ");
                    double salary = sc.nextDouble();
                    employee.setSalary(salary);

                    emp.createEmployee(employee);
                    break;

                case 2:
                    emp.getAllEmployee();
                    break;
                case 3:
                    System.out.println("Enter Employee ID to get details: ");
                    id = sc.nextInt();
                    emp.showEmployeeById(id);
                    break;
                case 4:
                    System.out.println("Enter id for update details: ");
                    id = sc.nextInt();
                    System.out.println("Enter new name: ");
                    name = sc.next();
                    emp.updateEmployee(id,name);
                    break;
                case 5:
                    System.out.println("Enter id for Delete employee record: ");
                    id = sc.nextInt();
                    emp.deleteEmployee(id);
                    break;
                case 6:
                    System.out.println("Thank you!!");
                    System.exit(0);
                default:
                    System.out.println("Please Enter valid choice!!!");
                    break;
            }
        }while (true);
    }
}
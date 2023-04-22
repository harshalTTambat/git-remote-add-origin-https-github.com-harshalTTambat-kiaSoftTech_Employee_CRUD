package CompanyEmployee;

public interface EmployeeDaoInterface {

    public void createEmployee(Employee emp);

    public void getAllEmployee();

    public void showEmployeeById(int id);

    public void updateEmployee(int id,String name);

    public void deleteEmployee(int id);
}

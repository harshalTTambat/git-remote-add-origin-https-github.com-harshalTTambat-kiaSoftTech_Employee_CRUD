package CompanyEmployee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmployeeDao implements EmployeeDaoInterface{

    Connection con;
    @Override
    public void createEmployee(Employee employee) {

        con = DBConnection.createDBConnection();
        String query = "insert into employee values(?,?,?,?)";

        try {
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setInt(1,employee.getId());
            pstm.setString(2,employee.getName());
            pstm.setInt(3,employee.getAge());
            pstm.setDouble(4,employee.getSalary());

            int count = pstm.executeUpdate();
            if(count != 0)
            {
                System.out.println("Employee added successfully!!");
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void getAllEmployee() {

        con = DBConnection.createDBConnection();
        String query = "select * from employee";
        System.out.println("All Employee Details: ");
        System.out.println("_________________________________________________________");
        System.out.format("%s\t\t%s\t\t\t%s\t\t\t\t%s\n", "ID","Name","Age","Salary");
        System.out.println("_________________________________________________________");

        try {
            Statement stmt = con.createStatement();
            ResultSet result = stmt.executeQuery(query);

            while (result.next())
            {
                System.out.format("%d\t\t%s\t\t\t%d\t\t\t\t%f\n",
                        result.getInt(1),
                        result.getString(2),
                        result.getInt(3),
                        result.getDouble(4));
            }
            System.out.println("_________________________________________________________");

        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void showEmployeeById(int id) {

        con = DBConnection.createDBConnection();
        String query = "select * from employee where id="+id;
        System.out.println("Employee Details: ");
        System.out.format("%s\t\t%s\t\t\t\t%s\t\t%s\n", "ID","Name","Age","Salary");
        System.out.println("_________________________________________________________");

        try {
            Statement stmt = con.createStatement();
            ResultSet result = stmt.executeQuery(query);

            while (result.next())
            {
                System.out.format("%d\t\t%s\t\t\t\t%d\t\t%f\n",
                        result.getInt(1),
                        result.getString(2),
                        result.getInt(3),
                        result.getDouble(4));
            }
            System.out.println("");

        }catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    @Override
    public void updateEmployee(int id, String name) {
        con = DBConnection.createDBConnection();
        String query = "update employee set name=? where id=?";

        try {
            PreparedStatement pstm = con.prepareStatement(query);

            pstm.setString(1,name);
            pstm.setInt(2,id);
            int count = pstm.executeUpdate();
            if(count != 0)
            {
                System.out.println("Employee details updated successfully !!");
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteEmployee(int id) {

        con = DBConnection.createDBConnection();
        String query = "delete from employee where id=?";

        try {
            PreparedStatement pstm = con.prepareStatement(query);

            pstm.setInt(1,id);
            int count = pstm.executeUpdate();
            if(count != 0)
            {
                System.out.println("EmployeeId "+id+" deleted successfully !!");
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}

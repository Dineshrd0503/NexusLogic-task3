package hosmangdb;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ViewDetails {

    private static final String URL = "jdbc:mysql://localhost:3306/hospitalmangdb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1234@";

    public static void main(String[] args) {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");


            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);


            Scanner scanner = new Scanner(System.in);
            int choice;

            do {
                System.out.println("\nSelect an option to view the data:");
                System.out.println("1. Doctors");
                System.out.println("2. Patients");
                System.out.println("3. Departments");
                System.out.println("4. Appointments");
                System.out.println("5. Treatments");
                System.out.println("6. Bills");
                System.out.println("0. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1 -> retrieveDoctors(connection);
                    case 2 -> retrievePatients(connection);
                    case 3 -> retrieveDepartments(connection);
                    case 4 -> retrieveAppointments(connection);
                    case 5 -> retrieveTreatments(connection);
                    case 6 -> retrieveBills(connection);
                    case 0 -> System.out.println("Exiting the program...");
                    default -> System.out.println("Invalid choice. Please try again.");
                }

            } while (choice != 0);

            connection.close();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void retrieveDoctors(Connection connection) throws SQLException {
        String sql = "SELECT * FROM doctors";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();

        System.out.println("\nDoctors:");
        while (resultSet.next()) {
            System.out.println("ID: " + resultSet.getInt("did"));
            System.out.println("Name: " + resultSet.getString("name"));
            System.out.println("Department: " + resultSet.getString("dept"));
            System.out.println("Post: " + resultSet.getString("post"));
            System.out.println("Salary: " + resultSet.getInt("salary"));
            System.out.println("-------------------------------");
        }
        resultSet.close();
        statement.close();
    }

    private static void retrievePatients(Connection connection) throws SQLException {
        String sql = "SELECT * FROM patients";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();

        System.out.println("\nPatients:");
        while (resultSet.next()) {
            System.out.println("ID: " + resultSet.getInt("pid"));
            System.out.println("Name: " + resultSet.getString("name"));
            System.out.println("Age: " + resultSet.getInt("age"));
            System.out.println("Gender: " + resultSet.getString("gender"));
            System.out.println("Address: " + resultSet.getString("address"));
            System.out.println("Phone Number: " + resultSet.getString("phone_number"));
            System.out.println("Ailment: " + resultSet.getString("ailment"));
            System.out.println("Department ID: " + resultSet.getInt("dept_id"));
            System.out.println("-------------------------------");
        }
        resultSet.close();
        statement.close();
    }

    private static void retrieveDepartments(Connection connection) throws SQLException {
        String sql = "SELECT * FROM departments";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();

        System.out.println("\nDepartments:");
        while (resultSet.next()) {
            System.out.println("Department ID: " + resultSet.getInt("dept_id"));
            System.out.println("Department Name: " + resultSet.getString("dept_name"));
            System.out.println("Head of Department: " + resultSet.getString("head_of_dept"));
            System.out.println("-------------------------------");
        }
        resultSet.close();
        statement.close();
    }

    private static void retrieveAppointments(Connection connection) throws SQLException {
        String sql = "SELECT * FROM appointments";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();

        System.out.println("\nAppointments:");
        while (resultSet.next()) {
            System.out.println("Appointment ID: " + resultSet.getInt("appointment_id"));
            System.out.println("Patient ID: " + resultSet.getInt("pid"));
            System.out.println("Doctor ID: " + resultSet.getInt("did"));
            System.out.println("Appointment Date: " + resultSet.getDate("appointment_date"));
            System.out.println("Status: " + resultSet.getString("status"));
            System.out.println("-------------------------------");
        }
        resultSet.close();
        statement.close();
    }

    private static void retrieveTreatments(Connection connection) throws SQLException {
        String sql = "SELECT * FROM treatments";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();

        System.out.println("\nTreatments:");
        while (resultSet.next()) {
            System.out.println("Treatment ID: " + resultSet.getInt("treatment_id"));
            System.out.println("Patient ID: " + resultSet.getInt("pid"));
            System.out.println("Treatment Details: " + resultSet.getString("treatment_details"));
            System.out.println("Treatment Date: " + resultSet.getDate("treatment_date"));
            System.out.println("Cost: " + resultSet.getDouble("cost"));
            System.out.println("-------------------------------");
        }
        resultSet.close();
        statement.close();
    }
    private static void retrieveBills(Connection connection) throws SQLException {
        String sql = "SELECT * FROM bills";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();

        System.out.println("\nBills:");
        while (resultSet.next()) {
            System.out.println("Bill ID: " + resultSet.getInt("bill_id"));
            System.out.println("Patient ID: " + resultSet.getInt("pid"));
            System.out.println("Treatment ID: " + resultSet.getInt("treatment_id"));
            System.out.println("Bill Date: " + resultSet.getDate("bill_date"));
            System.out.println("Total Amount: " + resultSet.getDouble("total_amount"));
            System.out.println("Paid Amount: " + resultSet.getDouble("paid_amount"));
            System.out.println("-------------------------------");
        }
        resultSet.close();
        statement.close();
    }
}

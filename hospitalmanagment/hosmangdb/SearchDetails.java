package hosmangdb;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SearchDetails {

    private static final String URL = "jdbc:mysql://localhost:3306/hospitalmangdb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1234@";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Scanner scanner = new Scanner(System.in);

            System.out.println("Select table to search data:");
            System.out.println("1. Doctors");
            System.out.println("2. Patients");
            System.out.println("3. Departments");
            System.out.println("4. Appointments");
            System.out.println("5. Treatments");
            System.out.println("6. Bills");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> searchDoctors(connection, scanner);
                case 2 -> searchPatients(connection, scanner);
                case 3 -> searchDepartments(connection, scanner);
                case 4 -> searchAppointments(connection, scanner);
                case 5 -> searchTreatments(connection, scanner);
                case 6 -> searchBills(connection, scanner);
                default -> System.out.println("Invalid choice.");
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void searchDoctors(Connection connection, Scanner scanner) throws SQLException {
        String sql = "SELECT * FROM doctors WHERE did = ?";
        PreparedStatement statement = connection.prepareStatement(sql);

        System.out.print("Enter Doctor ID to search: ");
        int did = scanner.nextInt();

        statement.setInt(1, did);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            System.out.println("Doctor ID: " + resultSet.getInt("did"));
            System.out.println("Name: " + resultSet.getString("name"));
            System.out.println("Department: " + resultSet.getString("dept"));
            System.out.println("Post: " + resultSet.getString("post"));
            System.out.println("Salary: " + resultSet.getInt("salary"));
        } else {
            System.out.println("No Doctor found with ID: " + did);
        }
    }

    private static void searchPatients(Connection connection, Scanner scanner) throws SQLException {
        String sql = "SELECT * FROM patients WHERE pid = ?";
        PreparedStatement statement = connection.prepareStatement(sql);

        System.out.print("Enter Patient ID to search: ");
        int pid = scanner.nextInt();

        statement.setInt(1, pid);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            System.out.println("Patient ID: " + resultSet.getInt("pid"));
            System.out.println("Name: " + resultSet.getString("name"));
            System.out.println("Age: " + resultSet.getInt("age"));
            System.out.println("Gender: " + resultSet.getString("gender"));
            System.out.println("Address: " + resultSet.getString("address"));
            System.out.println("Phone Number: " + resultSet.getString("phone_number"));
            System.out.println("Ailment: " + resultSet.getString("ailment"));
            System.out.println("Department ID: " + resultSet.getInt("dept_id"));
        } else {
            System.out.println("No Patient found with ID: " + pid);
        }

    }

    private static void searchDepartments(Connection connection, Scanner scanner) throws SQLException {
        String sql = "SELECT * FROM departments WHERE dept_id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);

        System.out.print("Enter Department ID to search: ");
        int deptId = scanner.nextInt();

        statement.setInt(1, deptId);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            System.out.println("Department ID: " + resultSet.getInt("dept_id"));
            System.out.println("Name: " + resultSet.getString("dept_name"));
            System.out.println("Head Doctor ID: " + resultSet.getInt("head_of_dept"));
        } else {
            System.out.println("No Department found with ID: " + deptId);
        }

    }

    private static void searchAppointments(Connection connection, Scanner scanner) throws SQLException {
        String sql = "SELECT * FROM appointments WHERE appointment_id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);

        System.out.print("Enter Appointment ID to search: ");
        int appointmentId = scanner.nextInt();

        statement.setInt(1, appointmentId);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            System.out.println("Appointment ID: " + resultSet.getInt("appointment_id"));
            System.out.println("Patient ID: " + resultSet.getInt("pid"));
            System.out.println("Doctor ID: " + resultSet.getInt("did"));
            System.out.println("Appointment Date: " + resultSet.getString("appointment_date"));
            System.out.println("Description: " + resultSet.getString("status"));
        } else {
            System.out.println("No Appointment found with ID: " + appointmentId);
        }

    }

    private static void searchTreatments(Connection connection, Scanner scanner) throws SQLException {
        String sql = "SELECT * FROM treatments WHERE treatment_id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);

        System.out.print("Enter Treatment ID to search: ");
        int treatmentId = scanner.nextInt();

        statement.setInt(1, treatmentId);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            System.out.println("Treatment ID: " + resultSet.getInt("treatment_id"));
            System.out.println("Patient ID: " + resultSet.getInt("pid"));
            System.out.println("Doctor ID: " + resultSet.getInt("treatment_details"));
            System.out.println("Treatment Description: " + resultSet.getString("treatment_date"));
            System.out.println("Cost: " + resultSet.getInt("cost"));
        } else {
            System.out.println("No Treatment found with ID: " + treatmentId);
        }
    }

    private static void searchBills(Connection connection, Scanner scanner) throws SQLException {
        String sql = "SELECT * FROM bills WHERE bill_id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);

        System.out.print("Enter Bill ID to search: ");
        int billId = scanner.nextInt();

        statement.setInt(1, billId);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            System.out.println("Bill ID: " + resultSet.getInt("bill_id"));
            System.out.println("Patient ID: " + resultSet.getInt("pid"));
            System.out.println("teratment id" + resultSet.getInt("treatment_id"));
            System.out.println("bill Date: " + resultSet.getString("bill_date"));
            System.out.println("total amount " + resultSet.getInt("total_amount"));
            System.out.println("paid amount " + resultSet.getInt("paid_amount"));
        } else {
            System.out.println("No Bill found with ID: " + billId);
        }
    }
}

package hosmangdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteDetails {

    private static final String URL = "jdbc:mysql://localhost:3306/hospitalmangdb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1234@";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Scanner scanner = new Scanner(System.in);

            System.out.println("Select table to delete data:");
            System.out.println("1. Doctors");
            System.out.println("2. Patients");
            System.out.println("3. Departments");
            System.out.println("4. Appointments");
            System.out.println("5. Treatments");
            System.out.println("6. Bills");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> deleteDoctors(connection, scanner);
                case 2 -> deletePatients(connection, scanner);
                case 3 -> deleteDepartments(connection, scanner);
                case 4 -> deleteAppointments(connection, scanner);
                case 5 -> deleteTreatments(connection, scanner);
                case 6 -> deleteBills(connection, scanner);
                default -> System.out.println("Invalid choice.");
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void deleteDoctors(Connection connection, Scanner scanner) throws SQLException {
        String sql = "DELETE FROM doctors WHERE did = ?";
        PreparedStatement statement = connection.prepareStatement(sql);

        System.out.print("Enter Doctor ID to delete: ");
        int did = scanner.nextInt();

        statement.setInt(1, did);

        try {
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Doctor record was deleted successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Error deleting doctor: " + e.getMessage());
        } finally {
            statement.close();
        }
    }

    private static void deletePatients(Connection connection, Scanner scanner) throws SQLException {
        String sql = "DELETE FROM patients WHERE pid = ?";
        PreparedStatement statement = connection.prepareStatement(sql);

        System.out.print("Enter Patient ID to delete: ");
        int pid = scanner.nextInt();

        statement.setInt(1, pid);

        try {
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Patient record was deleted successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Error deleting patient: " + e.getMessage());
        } finally {
            statement.close();
        }
    }

    private static void deleteDepartments(Connection connection, Scanner scanner) throws SQLException {
        String sql = "DELETE FROM departments WHERE dept_id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);

        System.out.print("Enter Department ID to delete: ");
        int deptId = scanner.nextInt();

        statement.setInt(1, deptId);

        try {
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Department record was deleted successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Error deleting department: " + e.getMessage());
        } finally {
            statement.close();
        }
    }

    private static void deleteAppointments(Connection connection, Scanner scanner) throws SQLException {
        String sql = "DELETE FROM appointments WHERE appointment_id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);

        System.out.print("Enter Appointment ID to delete: ");
        int appointmentId = scanner.nextInt();

        statement.setInt(1, appointmentId);

        try {
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Appointment record was deleted successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Error deleting appointment: " + e.getMessage());
        } finally {
            statement.close();
        }
    }

    private static void deleteTreatments(Connection connection, Scanner scanner) throws SQLException {
        String sql = "DELETE FROM treatments WHERE treatment_id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);

        System.out.print("Enter Treatment ID to delete: ");
        int treatmentId = scanner.nextInt();

        statement.setInt(1, treatmentId);

        try {
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Treatment record was deleted successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Error deleting treatment: " + e.getMessage());
        } finally {
            statement.close();
        }
    }

    private static void deleteBills(Connection connection, Scanner scanner) throws SQLException {
        String sql = "DELETE FROM bills WHERE bill_id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);

        System.out.print("Enter Bill ID to delete: ");
        int billId = scanner.nextInt();

        statement.setInt(1, billId);

        try {
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Bill record was deleted successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Error deleting bill: " + e.getMessage());
        } finally {
            statement.close();
        }
    }
}


package hosmangdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateDetails {

    private static final String URL = "jdbc:mysql://localhost:3306/hospitalmangdb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1234@";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Scanner scanner = new Scanner(System.in);

            System.out.println("Select table to update data:");
            System.out.println("1. Doctors");
            System.out.println("2. Patients");
            System.out.println("3. Departments");
            System.out.println("4. Appointments");
            System.out.println("5. Treatments");
            System.out.println("6. Bills");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1 -> updateDoctors(connection, scanner);
                case 2 -> updatePatients(connection, scanner);
                case 3 -> updateDepartments(connection, scanner);
                case 4 -> updateAppointments(connection, scanner);
                case 5 -> updateTreatments(connection, scanner);
                case 6 -> updateBills(connection, scanner);
                default -> System.out.println("Invalid choice.");
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void updateDoctors(Connection connection, Scanner scanner) throws SQLException {
        String sql = "UPDATE doctors SET name = ?, dept = ?, post = ?, salary = ? WHERE did = ?";
        PreparedStatement statement = connection.prepareStatement(sql);

        System.out.print("Enter Doctor ID to update: ");
        int did = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter new Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter new Department: ");
        String dept = scanner.nextLine();
        System.out.print("Enter new Post: ");
        String post = scanner.nextLine();
        System.out.print("Enter new Salary: ");
        int salary = scanner.nextInt();

        statement.setString(1, name);
        statement.setString(2, dept);
        statement.setString(3, post);
        statement.setInt(4, salary);
        statement.setInt(5, did);

        try {
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Doctor record was updated successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Error updating doctor: " + e.getMessage());
        } finally {
            statement.close();
        }
    }

    private static void updatePatients(Connection connection, Scanner scanner) throws SQLException {
        String sql = "UPDATE patients SET name = ?, age = ?, gender = ?, address = ?, phone_number = ?, ailment = ?, dept_id = ? WHERE pid = ?";
        PreparedStatement statement = connection.prepareStatement(sql);

        System.out.print("Enter Patient ID to update: ");
        int pid = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter new Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter new Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter new Gender: ");
        String gender = scanner.nextLine();
        System.out.print("Enter new Address: ");
        String address = scanner.nextLine();
        System.out.print("Enter new Phone Number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Enter new Ailment: ");
        String ailment = scanner.nextLine();
        System.out.print("Enter new Department ID: ");
        int deptId = scanner.nextInt();

        statement.setString(1, name);
        statement.setInt(2, age);
        statement.setString(3, gender);
        statement.setString(4, address);
        statement.setString(5, phoneNumber);
        statement.setString(6, ailment);
        statement.setInt(7, deptId);
        statement.setInt(8, pid);

        try {
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Patient record was updated successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Error updating patient: " + e.getMessage());
        } finally {
            statement.close();
        }
    }

    private static void updateDepartments(Connection connection, Scanner scanner) throws SQLException {
        String sql = "UPDATE departments SET name = ?, head_id = ? WHERE dept_id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);

        System.out.print("Enter Department ID to update: ");
        int deptId = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter new Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter new Head Doctor ID: ");
        int headId = scanner.nextInt();

        statement.setString(1, name);
        statement.setInt(2, headId);
        statement.setInt(3, deptId);

        try {
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Department record was updated successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Error updating department: " + e.getMessage());
        } finally {
            statement.close();
        }
    }

    private static void updateAppointments(Connection connection, Scanner scanner) throws SQLException {
        String sql = "UPDATE appointments SET patient_id = ?, doctor_id = ?, appointment_date = ?, description = ? WHERE appointment_id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);

        System.out.print("Enter Appointment ID to update: ");
        int appointmentId = scanner.nextInt();
        System.out.print("Enter new Patient ID: ");
        int patientId = scanner.nextInt();
        System.out.print("Enter new Doctor ID: ");
        int doctorId = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter new Appointment Date (YYYY-MM-DD): ");
        String appointmentDate = scanner.nextLine();
        System.out.print("Enter new Description: ");
        String description = scanner.nextLine();

        statement.setInt(1, patientId);
        statement.setInt(2, doctorId);
        statement.setString(3, appointmentDate);
        statement.setString(4, description);
        statement.setInt(5, appointmentId);

        try {
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Appointment record was updated successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Error updating appointment: " + e.getMessage());
        } finally {
            statement.close();
        }
    }

    private static void updateTreatments(Connection connection, Scanner scanner) throws SQLException {
        String sql = "UPDATE treatments SET patient_id = ?, doctor_id = ?, treatment_description = ?, cost = ? WHERE treatment_id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);

        System.out.print("Enter Treatment ID to update: ");
        int treatmentId = scanner.nextInt();
        System.out.print("Enter new Patient ID: ");
        int patientId = scanner.nextInt();
        System.out.print("Enter new Doctor ID: ");
        int doctorId = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter new Treatment Description: ");
        String treatmentDescription = scanner.nextLine();
        System.out.print("Enter new Cost: ");
        int cost = scanner.nextInt();

        statement.setInt(1, patientId);
        statement.setInt(2, doctorId);
        statement.setString(3, treatmentDescription);
        statement.setInt(4, cost);
        statement.setInt(5, treatmentId);

        try {
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Treatment record was updated successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Error updating treatment: " + e.getMessage());
        } finally {
            statement.close();
        }
    }

    private static void updateBills(Connection connection, Scanner scanner) throws SQLException {
        String sql = "UPDATE bills SET patient_id = ?, amount = ?, payment_date = ?, status = ? WHERE bill_id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);

        System.out.print("Enter Bill ID to update: ");
        int billId = scanner.nextInt();
        System.out.print("Enter new Patient ID: ");
        int patientId = scanner.nextInt();
        System.out.print("Enter new Amount: ");
        int amount = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter new Payment Date (YYYY-MM-DD): ");
        String paymentDate = scanner.nextLine();
        System.out.print("Enter new Status (Paid/Unpaid): ");
        String status = scanner.nextLine();

        statement.setInt(1, patientId);
        statement.setInt(2, amount);
        statement.setString(3, paymentDate);
        statement.setString(4, status);
        statement.setInt(5, billId);

        try {
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Bill record was updated successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Error updating bill: " + e.getMessage());
        } finally {
            statement.close();
        }
    }
}

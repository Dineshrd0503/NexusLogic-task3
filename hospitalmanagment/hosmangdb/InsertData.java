package hosmangdb;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertData {

    private static final String URL = "jdbc:mysql://localhost:3306/hospitalmangdb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1234@";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Scanner scanner = new Scanner(System.in);

            System.out.println("Select table to insert data:");
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
                case 1 -> insertDoctors(connection, scanner);
                case 2 -> insertPatients(connection, scanner);
                case 3 -> insertDepartments(connection, scanner);
                case 4 -> insertAppointments(connection, scanner);
                case 5 -> insertTreatments(connection, scanner);
                case 6 -> insertBills(connection, scanner);
                default -> System.out.println("Invalid choice.");
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void insertDoctors(Connection connection, Scanner scanner) throws SQLException {
        String sql = "INSERT INTO doctors (did, name, dept, post, salary) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);

        System.out.print("Enter Doctor ID: ");
        int did = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter Doctor Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Department: ");
        String dept = scanner.nextLine();
        System.out.print("Enter Post: ");
        String post = scanner.nextLine();
        System.out.print("Enter Salary: ");
        int salary = scanner.nextInt();

        statement.setInt(1, did);
        statement.setString(2, name);
        statement.setString(3, dept);
        statement.setString(4, post);
        statement.setInt(5, salary);

        try {
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new doctor was inserted successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Error inserting doctor: " + e.getMessage());
        } finally {
            statement.close();
        }
    }

    private static void insertPatients(Connection connection, Scanner scanner) throws SQLException {
        String sql = "INSERT INTO patients (pid, name, age, gender, address, phone_number, ailment, dept_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);

        System.out.print("Enter Patient ID: ");
        int pid = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter Patient Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter Gender: ");
        String gender = scanner.nextLine();
        System.out.print("Enter Address: ");
        String address = scanner.nextLine();
        System.out.print("Enter Phone Number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Enter Ailment: ");
        String ailment = scanner.nextLine();
        System.out.print("Enter Department ID: ");
        int deptId = scanner.nextInt();

        statement.setInt(1, pid);
        statement.setString(2, name);
        statement.setInt(3, age);
        statement.setString(4, gender);
        statement.setString(5, address);
        statement.setString(6, phoneNumber);
        statement.setString(7, ailment);
        statement.setInt(8, deptId);

        try {
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new patient was inserted successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Error inserting patient: " + e.getMessage());
        } finally {
            statement.close();
        }
    }

    private static void insertDepartments(Connection connection, Scanner scanner) throws SQLException {
        String sql = "INSERT INTO departments (dept_id, name, head_id) VALUES (?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);

        System.out.print("Enter Department ID: ");
        int deptId = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter Department Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Head Doctor ID: ");
        int headId = scanner.nextInt();

        statement.setInt(1, deptId);
        statement.setString(2, name);
        statement.setInt(3, headId);

        try {
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new department was inserted successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Error inserting department: " + e.getMessage());
        } finally {
            statement.close();
        }
    }

    private static void insertAppointments(Connection connection, Scanner scanner) throws SQLException {
        String sql = "INSERT INTO appointments (appointment_id, patient_id, doctor_id, appointment_date, description) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);

        System.out.print("Enter Appointment ID: ");
        int appointmentId = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter Patient ID: ");
        int patientId = scanner.nextInt();
        System.out.print("Enter Doctor ID: ");
        int doctorId = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter Appointment Date (YYYY-MM-DD): ");
        String appointmentDate = scanner.nextLine();
        System.out.print("Enter Description: ");
        String description = scanner.nextLine();

        statement.setInt(1, appointmentId);
        statement.setInt(2, patientId);
        statement.setInt(3, doctorId);
        statement.setString(4, appointmentDate);
        statement.setString(5, description);

        try {
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new appointment was inserted successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Error inserting appointment: " + e.getMessage());
        } finally {
            statement.close();
        }
    }

    private static void insertTreatments(Connection connection, Scanner scanner) throws SQLException {
        String sql = "INSERT INTO treatments (treatment_id, patient_id, doctor_id, treatment_description, cost) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);

        System.out.print("Enter Treatment ID: ");
        int treatmentId = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter Patient ID: ");
        int patientId = scanner.nextInt();
        System.out.print("Enter Doctor ID: ");
        int doctorId = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter Treatment Description: ");
        String treatmentDescription = scanner.nextLine();
        System.out.print("Enter Cost: ");
        int cost = scanner.nextInt();

        statement.setInt(1, treatmentId);
        statement.setInt(2, patientId);
        statement.setInt(3, doctorId);
        statement.setString(4, treatmentDescription);
        statement.setInt(5, cost);

        try {
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new treatment was inserted successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Error inserting treatment: " + e.getMessage());
        } finally {
            statement.close();
        }
    }

    private static void insertBills(Connection connection, Scanner scanner) throws SQLException {
        String sql = "INSERT INTO bills (bill_id, patient_id, amount, payment_date, status) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);

        System.out.print("Enter Bill ID: ");
        int billId = scanner.nextInt();
        System.out.print("Enter Patient ID: ");
        int patientId = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter Amount: ");
        int amount = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter Payment Date (YYYY-MM-DD): ");
        String paymentDate = scanner.nextLine();
        System.out.print("Enter Status (Paid/Unpaid): ");
        String status = scanner.nextLine();

        statement.setInt(1, billId);
        statement.setInt(2, patientId);
        statement.setInt(3, amount);
        statement.setString(4, paymentDate);
        statement.setString(5, status);

        try {
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new bill was inserted successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Error inserting bill: " + e.getMessage());
        } finally {
            statement.close();
        }
    }
}

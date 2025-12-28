import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class HospitalManagement {
    private DatabaseManager dbManager;
    private Scanner scanner;

    public HospitalManagement(Jdbc jdbc) {
        dbManager = new DatabaseManager(jdbc);
        scanner = new Scanner(System.in);
    }

    public void addPatient() {
        System.out.println("\n=== Добавление нового пациента ===");

        System.out.print("Введите полное имя: ");
        String fullName = scanner.nextLine();
        Patient patient = new Patient(fullName);

        try {
            int generatedId = dbManager.addPatient(patient);
            if (generatedId != -1) {
                System.out.println("Пациент успешно добавлен! ID пациента: " + generatedId);
            } else {
                System.out.println("Ошибка при добавлении пациента!");
            }
        } catch (SQLException e) {
            System.out.println("Ошибка базы данных: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void viewAllPatients() {
        System.out.println("\n=== Список всех пациентов ===");

        try {
            List<Patient> patients = dbManager.getAllPatients();

            if (patients.isEmpty()) {
                System.out.println("Пациентов не найдено.");
                return;
            }

            for (Patient patient : patients) {
                System.out.println(patient.patient_full_name);
            }

            System.out.println("\nВсего пациентов: " + patients.size());
        } catch (SQLException e) {
            System.out.println("Ошибка базы данных: " + e.getMessage());
        }
    }

    public void viewAllDoctors() {
        System.out.println("\n=== Список всех докторов ===");

        try {
            List<Doctor> doctors = dbManager.getAllDoctors();

            if (doctors.isEmpty()) {
                System.out.println("Докторов не найдено.");
                return;
            }

            for (Doctor doctor : doctors) {
                System.out.println(doctor.doctor_full_name);
            }

            System.out.println("\nВсего докторов: " + doctors.size());
        } catch (SQLException e) {
            System.out.println("Ошибка базы данных: " + e.getMessage());
        }
    }

    public void bookAppointment() {
        System.out.println("\n=== Запись на приём ===");

        try {
            List<Patient> patients = dbManager.getAllPatients();
            if (patients.isEmpty()) {
                System.out.println("Сначала добавьте пациентов!");
                return;
            }

            System.out.print("Введите ID пациента: ");
            int patientId;
            try {
                patientId = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: неверный формат ID!");
                return;
            }

            Patient patient = dbManager.getPatientById(patientId);
            if (patient == null) {
                System.out.println("Пациент с ID " + patientId + " не найден!");
                return;
            }

            System.out.println("Пациент: " + patient.patient_full_name);

            // Ввод даты и времени приёма
            System.out.print("Введите год приёма (например, 2024): ");
            int year = Integer.parseInt(scanner.nextLine());

            System.out.print("Введите месяц приёма (1-12): ");
            int month = Integer.parseInt(scanner.nextLine());

            System.out.print("Введите день приёма (1-31): ");
            int day = Integer.parseInt(scanner.nextLine());

            System.out.print("Введите час приёма (0-23): ");
            int hour = Integer.parseInt(scanner.nextLine());

            System.out.print("Введите минуту приёма (0-59): ");
            int minute = Integer.parseInt(scanner.nextLine());

            LocalDateTime dateTime = LocalDateTime.of(year, month, day, hour, minute);

            System.out.print("Введите ФИО врача: ");
            String doctorName = scanner.nextLine();

            System.out.print("Введите  специализацию: ");
            String specialization = scanner.nextLine();

            Appointment appointment = new Appointment(patientId, dateTime, doctorName, specialization);

            int generatedId = dbManager.addAppointment(appointment);
            if (generatedId != -1) {
                System.out.println("\nПриём успешно записан! ID приёма: " + generatedId);
                System.out.println(appointment);
            } else {
                System.out.println("Ошибка при записи на приём!");
            }

        } catch (SQLException e) {
            System.out.println("Ошибка базы данных: " + e.getMessage());
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: неверный формат данных!");
        }
    }

//    public void viewAllAppointments() {
//        System.out.println("\n=== Список всех приёмов ===");
//
//        try {
//            List<Appointment> appointments = dbManager.getAllAppointments();
//
//            if (appointments.isEmpty()) {
//                System.out.println("Приёмов не найдено.");
//                return;
//            }
//
//            for (Appointment appointment : appointments) {
//                System.out.println(appointment);
//
//                // Получаем информацию о пациенте
//                Patient patient = dbManager.getPatientById(appointment.patientId);
//                if (patient != null) {
//                    System.out.println("  Пациент: " + patient.patient_full_name);
//                }
//                System.out.println("---");
//            }
//
//            System.out.println("\nВсего приёмов: " + appointments.size());
//        } catch (SQLException e) {
//            System.out.println("Ошибка базы данных: " + e.getMessage());
//        }
//    }

//    public void viewPatientAppointments() {
//        System.out.println("\n=== Просмотр приёмов пациента ===");
//
//        System.out.print("Введите ID пациента: ");
//        int patientId;
//        try {
//            patientId = Integer.parseInt(scanner.nextLine());
//        } catch (NumberFormatException e) {
//            System.out.println("Ошибка: неверный формат ID!");
//            return;
//        }
//
//        try {
//            Patient patient = dbManager.getPatientById(patientId);
//            if (patient == null) {
//                System.out.println("Пациент с ID " + patientId + " не найден!");
//                return;
//            }
//
//            System.out.println("Пациент: " + patient.patient_full_name);
//
//            List<Appointment> appointments = dbManager.getAppointmentsByPatientId(patientId);
//
//            if (appointments.isEmpty()) {
//                System.out.println("У пациента нет запланированных приёмов.");
//                return;
//            }
//
//            for (Appointment appointment : appointments) {
//                System.out.println(appointment.dateTime);
//            }
//
//            System.out.println("\nВсего приёмов: " + appointments.size());
//
//        } catch (SQLException e) {
//            System.out.println("Ошибка базы данных: " + e.getMessage());
//        }
//    }


    public void displayMenu() {
        System.out.println("\n=== Система управления больницей (JDBC) ===");
        System.out.println("1. Добавить нового пациента");
        System.out.println("2. Просмотреть всех пациентов");
        System.out.println("3. Записать на приём");
        System.out.println("4. Посмотреть всех врачей");
        System.out.println("5. Выход");
        System.out.print("Выберите действие: ");
    }

    public void run() {
        System.out.println("Добро пожаловать в систему управления больницей!");

        while (true) {
            displayMenu();
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addPatient();
                    break;
                case "2":
                    viewAllPatients();
                    break;
                case "3":
                    bookAppointment();
                    break;
                case "4":
                    viewAllDoctors();
                    break;
                case "5":
                    System.out.println("Спасибо за использование системы. До свидания!");
                    dbManager.close();
                    scanner.close();
                    return;
                default:
                    System.out.println("Неверный выбор. Пожалуйста, выберите действие от 1 до 6.");
            }
        }
    }
}

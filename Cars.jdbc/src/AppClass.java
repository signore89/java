import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AppClass {

    private Connection conn;
    private final JdbcPC jdbcPC;
    private Statement stmt;
    final String queryAll = "SELECT * FROM cars";
    final String queryShowAllManufacturers = "SELECT DISTINCT car_manufacturer FROM cars ORDER BY car_manufacturer";
    final String querySpecificYearRelease = "SELECT * FROM cars WHERE year_manufacture = ? ORDER BY id_car";
    final String queryAllCarsSpecificManufacturer = "SELECT * FROM cars WHERE car_manufacturer = ? ORDER BY id_car";
    final String queryAllCarsByColor = "SELECT * FROM cars WHERE car_color = ? ORDER BY id_car";
    final String queryAllCarsByEngine = "SELECT * FROM cars WHERE engine_displacement = ? ORDER BY id_car";
    final String queryAllCarsByType = "SELECT * FROM cars WHERE type_car = ? ORDER BY id_car";

    public AppClass(JdbcPC jdbcPC){
        this.jdbcPC = jdbcPC;
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                jdbcPC.getURL(),
                jdbcPC.getParameters()
        );
    }

    public void showAllManufacturers(){
        try {
            this.conn = getConnection();
            if (conn != null) {
                stmt = conn.createStatement();
                System.out.println("Вы подключились к базе данных cars_db");
            } else {
                System.out.println("Ошибка подключения");
            }
            ResultSet rs = stmt.executeQuery(queryShowAllManufacturers);
            while (rs.next()) {
                String carManufactured = rs.getString("car_manufacturer");
                System.out.println("Производитель авто: " + carManufactured);
            }
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    public void getAll() {
        List<Car> cars = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(jdbcPC.getURL(),jdbcPC.getParameters());
             PreparedStatement pstmt = conn.prepareStatement(queryAll)){
                try (ResultSet rs = pstmt.executeQuery()){
                    while (rs.next()) {
                        Car car = new Car (
                            rs.getInt("id_car"),
                            rs.getString("car_manufacturer"),
                            rs.getString("car_name"),
                            rs.getDouble("engine_displacement"),
                            rs.getInt("year_manufacture"),
                            rs.getString("car_color"),
                            rs.getString("type_car")
                        );
                        cars.add(car);
                    }
                }
        } catch (SQLException ex) {
            System.err.println("Ошибка при получении автомобилей: " + ex.getMessage());
            ex.printStackTrace();
        }
        System.out.println(cars);
    }
    public void getCarsByYear(int year){
        List<Car> cars = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(jdbcPC.getURL(),jdbcPC.getParameters());
            PreparedStatement pstmt = conn.prepareStatement(querySpecificYearRelease)){
                pstmt.setInt(1,year);
                try (ResultSet rs = pstmt.executeQuery()){
                    while (rs.next()) {
                        Car car = new Car (
                                rs.getInt("id_car"),
                                rs.getString("car_manufacturer"),
                                rs.getString("car_name"),
                                rs.getDouble("engine_displacement"),
                                rs.getInt("year_manufacture"),
                                rs.getString("car_color"),
                                rs.getString("type_car")
                        );
                        cars.add(car);
                    }
                }
        } catch (SQLException ex) {
            System.err.println("Ошибка при получении автомобилей: " + ex.getMessage());
            ex.printStackTrace();
        }
        System.out.println(cars);
    }
    public void getCarsByManufacturer(String manufacturer){
        List<Car> cars = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(jdbcPC.getURL(),jdbcPC.getParameters());
             PreparedStatement pstmt = conn.prepareStatement(queryAllCarsSpecificManufacturer)){
            pstmt.setString(1,manufacturer);
            try (ResultSet rs = pstmt.executeQuery()){
                while (rs.next()) {
                    Car car = new Car (
                            rs.getInt("id_car"),
                            rs.getString("car_manufacturer"),
                            rs.getString("car_name"),
                            rs.getDouble("engine_displacement"),
                            rs.getInt("year_manufacture"),
                            rs.getString("car_color"),
                            rs.getString("type_car")
                    );
                    cars.add(car);
                }
            }
        } catch (SQLException ex) {
            System.err.println("Ошибка при получении автомобилей: " + ex.getMessage());
            ex.printStackTrace();
        }
        System.out.println(cars);
    }
    public void getAllCarsByColor(String color){
        List<Car> cars = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(jdbcPC.getURL(),jdbcPC.getParameters());
             PreparedStatement pstmt = conn.prepareStatement(queryAllCarsByColor)){
            pstmt.setString(1,color);
            try (ResultSet rs = pstmt.executeQuery()){
                while (rs.next()) {
                    Car car = new Car (
                            rs.getInt("id_car"),
                            rs.getString("car_manufacturer"),
                            rs.getString("car_name"),
                            rs.getDouble("engine_displacement"),
                            rs.getInt("year_manufacture"),
                            rs.getString("car_color"),
                            rs.getString("type_car")
                    );
                    cars.add(car);
                }
            }
        } catch (SQLException ex) {
            System.err.println("Ошибка при получении автомобилей: " + ex.getMessage());
            ex.printStackTrace();
        }
        System.out.println(cars);
    }
    public void getAllCarsByEngine(double engine){
        List<Car> cars = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(jdbcPC.getURL(),jdbcPC.getParameters());
             PreparedStatement pstmt = conn.prepareStatement(queryAllCarsByEngine)){
            pstmt.setDouble(1,engine);
            try (ResultSet rs = pstmt.executeQuery()){
                while (rs.next()) {
                    Car car = new Car (
                            rs.getInt("id_car"),
                            rs.getString("car_manufacturer"),
                            rs.getString("car_name"),
                            rs.getDouble("engine_displacement"),
                            rs.getInt("year_manufacture"),
                            rs.getString("car_color"),
                            rs.getString("type_car")
                    );
                    cars.add(car);
                }
            }
        } catch (SQLException ex) {
            System.err.println("Ошибка при получении автомобилей: " + ex.getMessage());
            ex.printStackTrace();
        }
        System.out.println(cars);
    }
    public void getAllCarsByType(String type){
        List<Car> cars = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(jdbcPC.getURL(),jdbcPC.getParameters());
             PreparedStatement pstmt = conn.prepareStatement(queryAllCarsByType)){
            pstmt.setString(1,type);
            try (ResultSet rs = pstmt.executeQuery()){
                while (rs.next()) {
                    Car car = new Car (
                            rs.getInt("id_car"),
                            rs.getString("car_manufacturer"),
                            rs.getString("car_name"),
                            rs.getDouble("engine_displacement"),
                            rs.getInt("year_manufacture"),
                            rs.getString("car_color"),
                            rs.getString("type_car")
                    );
                    cars.add(car);
                }
            }
        } catch (SQLException ex) {
            System.err.println("Ошибка при получении автомобилей: " + ex.getMessage());
            ex.printStackTrace();
        }
        System.out.println(cars);
    }
}




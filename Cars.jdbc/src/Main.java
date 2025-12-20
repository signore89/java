import java.sql.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    JdbcPC jdbcPC = new JdbcPC();
    AppClass app = new AppClass(jdbcPC);

    int choice;
    boolean flag = true;
    Scanner sc = new Scanner(System.in);
    while (flag) {
        choice = menu(sc);
        switch (choice){
            case 1: app.getAll();
                break;
            case 2: app.showAllManufacturers();
                break;
            case 3: app.getCarsByYear(getYearManufactured(sc));
                break;
            case 4:app.getCarsByManufacturer(getManufactured(sc));
                break;
            case 5:app.getAllCarsByColor(getColor(sc));
                break;
            case 6:app.getAllCarsByEngine(getEngine(sc));
                break;
            case 7:app.getAllCarsByType(getType(sc));
                break;
            case 8: flag = false;
                break;
        }
    }
    sc.close();
}

        public int menu(Scanner scanner)
        {
            String menu = """
            Меню:
            1. Отображение всего содержимого таблицы
            2. Показать всех производителей авто
            3. Показать все авто конкретного года выпуска\
            
            4. Показать все авто конкретного производителя
            5. Показать всех авто конкретного цвета
            6. Показать авто конкретного объёма двигателя
            7. Показать авто по типу кузова  
            8. Выход
            Сделайте свой выбор:\s""";
            System.out.println(menu);
            return scanner.nextInt();
        }

        public int getYearManufactured(Scanner scanner)
        {
            String menu = "Введите желаемый год: ";
            System.out.print(menu);
            return scanner.nextInt();
        }
        public String getManufactured(Scanner scanner)
        {
            String menu = "Введите желаемого производителя: ";
            System.out.print(menu);
            return scanner.next();
        }
        public String getColor(Scanner scanner)
        {
            String menu = "Введите желаемый цвет: ";
            System.out.print(menu);
            return scanner.next();
        }
        public double getEngine(Scanner scanner)
        {
            String menu = "Введите желаемый объём двигателя: ";
            System.out.print(menu);
            return scanner.nextDouble();
        }

        public String getType(Scanner scanner)
        {
            String menu = "Введите желаемый тип кузова: ";
            System.out.print(menu);
            return scanner.next();
        }
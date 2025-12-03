//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main(String[] args) {
    int sizeArray;
    int choice;
    boolean flag = true;
    Scanner sc = new Scanner(System.in);
    System.out.println("Введите размер массива: ");
    sizeArray = sc.nextInt();
    int[] array = new int[sizeArray];
    while (flag) {
        choice = menu(sc);
        switch (choice){
            case 1:
                array = creatArray(sc,sizeArray);
                break;
            case 2: showArray(array);
                break;
            case 3:
                System.out.println(search(sc,array));
                break;
            case 4:
                System.out.println(Arrays.toString(bubbleSort(array)));
                break;
            case 5: flag = false;
            break;
        }
    }
    sc.close();
}

public int menu(Scanner scanner)
{
    String menu = """
            Меню:
            1. Ввод элементов массива
            2. Отображение элементов массива
            3. Поиск элементов массива по значению\
            
            4. Сортировка массива
            5. Выход
            Сделайте свой выбор:\s""";
    System.out.println(menu);
    return scanner.nextInt();
}

public static int[] creatArray(Scanner scanner,int size){
    int [] array = new int[size];
    for (int i = 0; i < size; i++) {
        System.out.println("Введите число");
        array[i] = scanner.nextInt();
    }
    return array;
}
public  static void showArray(int [] array){
    System.out.println(Arrays.toString(array));
}
public static String search(Scanner scanner,int[] array){
    System.out.println("Введите искомое: \n");
    int searchNumber = scanner.nextInt();
    for (int j : array) {
        if (j == searchNumber)return Integer.toString(j);
    }
    return "Не удалось найти такого значение";
}

public static int[] bubbleSort(int[] array){
    for (int i = 0; i < array.length - 1; i++) {
        for (int j = 0; j < array.length -1 -i; j++) {
            if (array[j] > array[j +1]){
                int temp = array[j];
                array[j] = array[j + 1];
                array[j + 1] = temp;
            }
        }
    }
    return array;
}

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {

    int fieldSize;
    String fieldSizeTask = "Введите размер поля ";
    int numberCharacters;
    String numberCharactersTask = "Введите количество символов";
    Scanner sc = new Scanner(System.in);
    fieldSize = Loop(fieldSizeTask,sc);
    numberCharacters = Loop(numberCharactersTask,sc);
    sc.close();
    Build(fieldSize,numberCharacters);
}

public int Loop(String task,Scanner scanner){
    int res;
    while (true) {
        System.out.println(task);
        if (scanner.hasNextInt()) {
            res = scanner.nextInt();
            break;
        } else {
            scanner.next();
        }
    }
    return res;
}

public void Build(int size,int symbols){
    for (int i = 0; i < size; i++) {
        for (int sr = 0; sr < symbols; sr++) {
            for (int j = 0; j < size; j++) {
                char symbol = ((i + j) % 2 == 0) ? '*' : ' ';
                for (int sc = 0; sc < symbols; sc++) {
                    System.out.print(symbol + " ");
                }
            }
            System.out.println();
        }
    }
}


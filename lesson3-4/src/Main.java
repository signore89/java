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

    System.out.println(Build(fieldSize,numberCharacters));
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

public String Build(int size,int countCharacters){
    StringBuilder res = new StringBuilder();
    int rows = size * countCharacters;
    boolean flag = false;
    for(int i = 0; i < rows;i++) {
        for(int k = 0; k < size;k++){
            if (!flag){
                for (int j = 0; j < countCharacters; j++) {
                    res.append('*');
                    flag = true;
                }
            }else{
                for (int t = 0;t < countCharacters;t++){
                    res.append(' ');
                    flag = false;
                }
            }
        }
    res.append('\n');
    }
    return res.toString();
}

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    System.out.println("Введите строку");
    Scanner sc = new Scanner(System.in);
    String line = sc.nextLine();

    System.out.println("Дана строка - " + "\"" + line + "\"");
    System.out.print("Количество строчных букв - " + countingLowercaseLetters(line));
    System.out.print(", количество прописных букв - " + countingCapitalLetters(line));
}

public int countingLowercaseLetters(String line){
    int count = 0;
    for (int i = 0; i < line.length(); i++) {
        char character = line.charAt(i);
        if (Character.isLowerCase(character)){
            count++;
        }
    }
    return count;
}
public int countingCapitalLetters(String line){
    int count = 0;
    for (int i = 0; i < line.length(); i++) {
        char character = line.charAt(i);
        if (Character.isUpperCase(character)){
            count++;
        }
    }
    return count;
}

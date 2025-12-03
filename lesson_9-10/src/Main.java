//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    String regLower = "[a-z]";
    String regUpper = "[A-Z]";
    System.out.println("Введите строку");
    Scanner sc = new Scanner(System.in);
    String line = sc.nextLine();

    System.out.println("Дана строка - " + "\"" + line + "\"");
    System.out.print("Количество строчных букв - " + countingLetters(line,regLower));
    System.out.print(", количество прописных букв - " + countingLetters(line,regUpper));
    sc.close();
}

public int countingLetters(String line,String reg){
    int count = 0;
//    for (int i = 0; i < line.length(); i++) {
//        char character = line.charAt(i);
//        if (Character.isLowerCase(character)){
//            count++;
//        }
//    }
    for (int i = 0; i < line.length(); i++) {
        String character = String.valueOf(line.charAt(i));
        if (character.matches(reg)){
            count++;
        }
    }
    return count;
}

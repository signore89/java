//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    List<Integer> src = new ArrayList<>();
    src.add(1);
    src.add(2);
    src.add(3);
    src.add(4);
    src.add(5);
    src.add(6);
    List<String> src2 = new ArrayList<>();
    src2.add("Red");
    src2.add("Green");
    src2.add("Orange");


    System.out.println("Исходный список строк: " + src);
    System.out.println("Обращенный список строк: " + ReverseList.reverseList(src));

    System.out.println("++++++++++++++");

    System.out.println("Исходный список строк: " + src2);
    System.out.println("Обращенный список строк: " + ReverseList.reverseList(src2));
}

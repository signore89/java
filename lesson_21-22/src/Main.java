//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    var rainbow = new LinkedList<String>();
    rainbow.add("Красный");
    rainbow.add("Оранжевый");
    rainbow.add("Желтый");
    rainbow.add("Зеленый");
    rainbow.add("Голубой");
    rainbow.add("Синий");
    rainbow.add("Фиолетовый");
    ListIterator<String> iterator = rainbow.listIterator();
    System.out.println("Список итераторов в прямом направлении: ");

    while (iterator.hasNext()){
        int currentIndex = iterator.nextIndex();
        String currentElement = iterator.next();
        System.out.println("Индекс = " + currentIndex + ", Элемент = " + currentElement);
    }

    System.out.println("Список итераторов в обратном направлении: ");


    while (iterator.hasPrevious()){
        int currentIndex = iterator.previousIndex();
        String currentElement = iterator.previous();
        System.out.println("Индекс = " + currentIndex + ", Элемент = " + currentElement);
    }
}

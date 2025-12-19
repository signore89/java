//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    Map<String,Integer> originMap = new HashMap<>();
    originMap.put("X",1);
    originMap.put("Y",2);
    originMap.put("Z",3);

    System.out.println("Исходный Map: " + originMap);

    Map<Integer, String> swappedMap = originMap.entrySet()
            .stream()
            .collect(Collectors.toMap(
                    Map.Entry::getValue,
                    Map.Entry::getKey
            ));

    System.out.println("Простая замена: " + swappedMap);
}

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    Box3D box3D = new Box3D();
    box3D.width = 3;
    box3D.height = 4;
    box3D.depth = 2;

    String str = """
            Обьект %s {ширина = %d, высота = %d, глубина = %d}
            Обьем: %d
            """.formatted(   box3D.getClass().getSimpleName()
                            ,box3D.width
                            ,box3D.height
                            ,box3D.depth
                            ,box3D.calculateVolume()    );

    System.out.println(str);
}

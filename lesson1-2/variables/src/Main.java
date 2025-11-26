//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.ArrayList;
import java.util.Random;


void main() {
    System.out.printf("Переменная типа %-6s занимает %d Байт памяти ( %-3d бит памяти), и принимает значения в диапазоне от %d до %d",
            Byte.TYPE,Byte.BYTES,Byte.SIZE,Byte.MIN_VALUE,Byte.MAX_VALUE);
    System.out.println();
    System.out.printf("Переменная типа %-6s занимает %d Байт памяти ( %-3d бит памяти), и принимает значения в диапазоне от %d до %d",
            Short.TYPE,Short.BYTES,Short.SIZE,Short.MIN_VALUE,Short.MAX_VALUE);
    System.out.println();
    System.out.printf("Переменная типа %-6s занимает %d Байт памяти ( %-3d бит памяти), и принимает значения в диапазоне от %d до %d",
            Integer.TYPE,Integer.BYTES,Integer.SIZE,Integer.MIN_VALUE,Integer.MAX_VALUE);
    System.out.println();
    System.out.printf("Переменная типа %-6s занимает %d Байт памяти ( %-3d бит памяти), и принимает значения в диапазоне от %d до %d",
            Long.TYPE,Long.BYTES,Long.SIZE,Long.MIN_VALUE,Long.MAX_VALUE);
    System.out.println();
    System.out.println();
    System.out.printf("Переменная типа %-6s занимает %d Байт памяти ( %-3d бит памяти), и принимает значения в диапазоне от %g до %g",
            Float.TYPE,Float.BYTES,Float.SIZE,Float.MIN_VALUE,Float.MAX_VALUE);
    System.out.println();
    System.out.printf("Переменная типа %-6s занимает %d Байт памяти ( %-3d бит памяти), и принимает значения в диапазоне от %g до %g",
            Double.TYPE,Double.BYTES,Double.SIZE,Double.MIN_VALUE,Double.MAX_VALUE);
}


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    Random random = new Random();
    int min = 1;
    int max = 10;
    int [] array;
    array = new int[10];
    int number;
    for (int i = 0; i < array.length; i++){
        do
        {
            number = random.nextInt((max - min) + min);
        }while(!isCheck(array,number));

        array[i] = number;
    }
    System.out.println(Arrays.toString(array));

}

public boolean isCheck(int [] array,int number)
{
    for (int num : array)
    {
        if (num == number)
        {
            return true;
        }else{
            continue;
        }
    }
    return false;
}


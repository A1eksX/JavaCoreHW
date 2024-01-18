import javax.xml.stream.StreamFilter;
import java.util.Arrays;
import java.util.stream.Stream;

public class HW2 {
    public static void main(String[] args) {
        int[] array = new int[]{1,5,3,6,0,7,0,6,9,4,0};

        System.out.println(numberEvenElements(array));
        System.out.println(diffMaxMin(array));
        System.out.println(extremeZero(array));

    }
    /**
     * 1. Написать метод, возвращающий количество чётных элементов массива.
     *
     * countEvens([2, 1, 2, 3, 4]) → 3
     * countEvens([2, 2, 0]) → 3
     * countEvens([1, 3, 5]) → 0
     */
    public static int numberEvenElements (int[] arr){
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0){
                count++;
            }
        }
        return count;
    }
    /**
     * 2. Написать функцию, возвращающую разницу между самым большим и самым маленьким элементами переданного не пустого массива.
     */
    public static int diffMaxMin(int[] arr){
        int min = Arrays.stream(arr).min().getAsInt();
        int max = Arrays.stream(arr).max().getAsInt();
        int difference = max - min;
        return difference;
    }
    /**
     * 3. Написать функцию, возвращающую истину, если в переданном массиве есть два соседних элемента, с нулевым значением.
     */
    public static boolean extremeZero(int[]arr){
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i - 1] == 0 && arr[i + 1] == 0){
                return true;
            }
        }
        return false;
    }


}

import org.apache.commons.io.FileUtils;

import javax.imageio.IIOException;
import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Main {
    /**
     * 1. Написать функцию, создающую резервную копию всех файлов в директории(без поддиректорий)
     * во вновь созданную папку ./backup
     */
    public static void main(String[] args) {
        int[] intArray = new int[]{0, 2, 1, 3, 2, 1, 3, 0, 1};
        // 1
        backup();
        // 2
        writeInFile(intArray, "fileHW_5.2.txt");
        // 3
        addPrefics("file1 file2 file3 file4");

    }
    public static void backup(){
        File dir = new File(".");
        File newDir = new File("./backup");
        try {
            FileUtils.copyDirectory(dir, newDir);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * 2. Предположить, что числа в исходном массиве из 9 элементов имеют диапазон[0, 3], и представляют собой,
     *   например, состояния ячеек поля для игры в крестики-нолики, где 0 – это пустое поле, 1 – это поле с крестиком,
     *   2 – это поле с ноликом, 3 – резервное значение. Такое предположение позволит хранить в одном числе типа
     *   int всё поле 3х3. Записать в файл 9 значений так, чтобы они заняли три байта.
     */

    public static void writeInFile(int[] arr, String file){
        try(DataOutputStream writer = new DataOutputStream(new FileOutputStream(file))) {
            int count = 0;
            byte result = 0;
            for (int i = 0; i < arr.length; i++) {
                if (count == 3){
                    writer.writeByte(result);
                    result = 0;
                    count = 0;
                }
                result += arr[i] << (count);    // {0, 2, 1, 3, 2, 1, 3, 0, 1}
                count++;
            }
            writer.writeByte(result);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 3. Написать функцию, добавляющую префикс к каждому из набора файлов, названия которых переданы ей в качестве
     *    параметров через пробел.
     */
    public static void addPrefics(String fileNames){
        List<String> name = List.of(fileNames.split(" "));
        System.out.println(Arrays.toString(name.stream().map(x -> "##_" + x).toArray()));
//        System.out.println(name.stream().map(x -> "##_" + x).collect(Collectors.toList()));
    }
}

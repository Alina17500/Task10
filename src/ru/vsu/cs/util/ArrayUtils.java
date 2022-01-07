package ru.vsu.cs.util;

import ru.vsu.cs.volobueva.ApartmentParameters;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class ArrayUtils {
    public static int[] toPrimitive(Integer[] arr) {
        if (arr == null) {
            return null;
        }
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            // автоматическая распаковка из объекта
            result[i] = arr[i];
        }
        return result;
    }

    public static double[] toPrimitive(Double[] arr) {
        if (arr == null) {
            return null;
        }
        double[] result = new double[arr.length];
        for (int i = 0; i < arr.length; i++) {
// автоматическая распаковка из объекта
            result[i] = arr[i];
        }
        return result;
    }

    public static void writeArrayToFile(String fileName, String [][] arr2)
            throws FileNotFoundException {
        writeArrayToFile(fileName, arr2, null);
    }

    public static void writeArrayToFile(String fileName, String[][] arr2, String itemFormat)
            throws FileNotFoundException {
        try (PrintWriter out = new PrintWriter(fileName)) {
            out.println(toString(arr2, itemFormat));
        }
    }

    public static String toString(String[][] arr2, String itemFormat) {
        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < arr2.length; r++) {
            if (r > 0) {
                sb.append(System.lineSeparator());
            }
            sb.append(toString(arr2[r], itemFormat));
        }
        return sb.toString();
    }

    public static String toString(String[] arr, String itemFormat) {
        if (arr == null) {
            return null;
        }
        if (itemFormat == null || itemFormat.length() == 0) {
            itemFormat = "%s";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(String.format(Locale.ROOT, itemFormat, arr[i]));
        }
        return sb.toString();
    }

    //ListUtils для работы со строками:

    public static List<String> readLinesFromFileToList(String fileName) throws FileNotFoundException {
        List<String> lines;
        try (Scanner scanner = new Scanner(new File(fileName), "UTF-8")) {
            lines = new ArrayList<>();
            while (scanner.hasNext()) {
                lines.add(scanner.nextLine());
            }
        }
        return lines;
    }

    public static List<String []> splitList(List<String> list) {
        List<String []> flat = new ArrayList<>();

        for (String value : list) {
            String[] lines = value.split(" ");
            flat.add(lines);
        }

        return flat;
    }

    public static List<String []> readSplitListFromFile(String fileName) throws FileNotFoundException {
        return splitList(readLinesFromFileToList(fileName));
    }

    public static String[][] writeStringListToMatrix(List<String[]> list) {
        String[][] array = new String[list.size()][5];

        for (int row = 0; row < array.length; row++) {
            array[row] = list.get(row);
        }

        return array;
    }

    public static List<String[]> writeMatrixToList(String[][] array) {
        List<String[]> list = new ArrayList<>();

        for (int row = 0; row < array.length; row++) {
            list.add(row, array[row]);
        }

        return list;
    }

    //Для работы с SearchFlat и ApartmentParameters
    public static List<ApartmentParameters> makeListToApartmentParameters(List<String[]> list) {
        List<ApartmentParameters> dataBase = new ArrayList<>();

        for (String[] value : list) {
            ApartmentParameters apartmentParameters = new ApartmentParameters(value[0], Integer.parseInt(value[1]), Integer.parseInt(value[2]), Integer.parseInt(value[3]), Integer.parseInt(value[4]));
            dataBase.add(apartmentParameters);
        }

        return dataBase;
    }
}
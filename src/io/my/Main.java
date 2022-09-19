package io.my;

import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        IntStream.range(0, 100).forEach(num -> sortForEach());
    }

    private static void sortForEach() {
        int[] numberArray = Main.getRandomNumberArray();

        SortAlgorithm sortAlgorithm = new SortAlgorithm();

        int[] sortNumberArray = sortAlgorithm.mergeSort(numberArray);

        StringBuilder stringBuilder = new StringBuilder();

        IntStream.range(0, numberArray.length).forEach(index -> {
            if (index != sortNumberArray[index]) {
                System.err.println(stringBuilder);
                System.err.println("index sort is wrong!, index: " + index);
                throw new RuntimeException();
            }
            stringBuilder.append(index).append(' ');
        });

        System.out.println(stringBuilder);
    }

    private static int[] getScannerNumberArray() {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        int[] numberArray = new int[number];
        for (int index = 0; index < number; index++) {
            numberArray[index] = scanner.nextInt();
        }
        return numberArray;
    }

    private static int[] getRandomNumberArray() {
        int size = 10000000;
        int[] numberArray = new int[size];

        for (int index=0; index<size; index++) {
            numberArray[index] = index;
        }

        Random random = new Random();
        for (int index=0; index<size; index++) {
            int randomNumber = random.nextInt(size);
            int temp = numberArray[index];
            numberArray[index] = numberArray[randomNumber];
            numberArray[randomNumber] = temp;
        }
        return numberArray;
    }


}

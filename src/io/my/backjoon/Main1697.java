package io.my.backjoon;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main1697 {

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        List<Integer> input = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> input = List.of(1248, 94568);
        int sisterPosition = input.get(0);
        int brotherPosition = input.get(1);

        int index = 0;

        int divisionBrotherPosition = brotherPosition / 2;
        do {
            if (sisterPosition > brotherPosition) {
                sisterPosition--;
                index = plusIndex(sisterPosition, index);
            } else if (sisterPosition + 1 == brotherPosition) {
                sisterPosition++;
                index = plusIndex(sisterPosition, index);
            } else if (sisterPosition < divisionBrotherPosition) {
                if (sisterPosition > brotherPosition - (sisterPosition * 2)) {
                    do {
                        sisterPosition++;
                        index = plusIndex(sisterPosition, index);
                    } while (sisterPosition != divisionBrotherPosition);
                }
                sisterPosition *= 2;
                index = plusIndex(sisterPosition, index);
            } else {
                int loopSize = sisterPosition - divisionBrotherPosition;
                sisterPosition--;
                index = plusIndex(sisterPosition, index);

                for (int i = 0; i < loopSize; i++) {
                    if (sisterPosition * 2 == brotherPosition || sisterPosition * 2 + 1 == brotherPosition) {
                        sisterPosition*=2;
                        index = plusIndex(sisterPosition, index);
                        break;
                    }else if (sisterPosition > divisionBrotherPosition) {
                        sisterPosition--;
                        index = plusIndex(sisterPosition, index);
                    } else {
                        sisterPosition*=2;
                        index = plusIndex(sisterPosition, index);
                        break;
                    }
                }
            }
        } while(sisterPosition != brotherPosition);
        System.out.println(index);
    }

    private static int plusIndex(int position, Integer index) {
        System.out.println(index+ ": " + position);
        return ++index;
    }
}

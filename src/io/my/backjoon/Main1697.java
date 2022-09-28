package io.my.backjoon;

import java.util.*;
import java.util.stream.Collectors;

public class Main1697 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> input = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        System.out.println(solutionBFS(input.get(0), input.get(1)));
    }

    private static int solutionBFS(int a, int b) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(a);

        int size = 100_001;
        int[] passArray = new int[size];
        passArray[a] = 1;

        if (a == b) return 0;

        int index = 0;
        int indexCount = 1;
        int nextIndexCount = 0;
        while (!queue.isEmpty()) {
            int position = queue.poll();
            if (position + 1 < 100_001 && passArray[position + 1] == 0) {
                if (position + 1 == b) {
                    return index + 1;
                }
                nextIndexCount++;
                queue.add(position + 1);
            }
            if (position - 1 >= 0 && passArray[position - 1] == 0) {
                if (position - 1 == b) {
                    return index + 1;
                }
                nextIndexCount++;
                queue.add(position - 1);
            }
            if (position * 2 < size && passArray[position * 2] == 0) {
                if (position * 2 == b) {
                    return index + 1;
                }
                nextIndexCount++;
                queue.add(position * 2);
            }
            passArray[position] = 1;
            if (--indexCount == 0) {
                index++;
                indexCount = nextIndexCount;
                nextIndexCount = 0;
            }
        }
        return -1;
    }

    private static int solution(int sisterPosition, int brotherPosition) {
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
        return index;
    }

    private static int plusIndex(int position, Integer index) {
//        System.out.println(index+ ": " + position);
        return ++index;
    }
}

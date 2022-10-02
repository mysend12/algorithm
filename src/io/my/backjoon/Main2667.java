package io.my.backjoon;

import java.util.*;

public class Main2667 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());

        int[][] map = new int[size][size];
        int[][] passMap = new int[size][size];

        Queue<Coordinate> queue = new LinkedList<>();

        for (int index = 0; index < size; index++) {
            String line = scanner.nextLine();
            for (int lineCharIndex = 0; lineCharIndex < line.length(); lineCharIndex++) {
                map[index][lineCharIndex] = line.charAt(lineCharIndex) - '0';
            }
        }

        int[] countArray = new int[size * size / 2 + 1];

        int count = 0;
        int countIndex = 0;

        for (int i=0; i<size; i++) {
            for (int j=0; j<size; j++) {
                if (passMap[i][j] == 0) {
                    passMap[i][j] = 1;
                    if (map[i][j] == 1) queue.add(new Coordinate(j, i));

                    while (!queue.isEmpty()) {
                        count++;
                        Coordinate coordinate = queue.poll();
                        int x = coordinate.x();
                        int y = coordinate.y();

                        if (x-1 >= 0 && passMap[y][x-1] == 0 && map[y][x-1] == 1) {
                            queue.add(new Coordinate(x-1, y));
                            passMap[y][x-1] = 1;
                        }

                        if (y-1 >= 0 && passMap[y-1][x] == 0 && map[y-1][x] == 1) {
                            queue.add(new Coordinate(x, y-1));
                            passMap[y-1][x] = 1;
                        }

                        if (x+1 < size && passMap[y][x+1] == 0 && map[y][x+1] == 1) {
                            queue.add(new Coordinate(x+1, y));
                            passMap[y][x+1] = 1;
                        }

                        if (y+1 < size && passMap[y+1][x] == 0 && map[y+1][x] == 1) {
                            queue.add(new Coordinate(x, y+1));
                            passMap[y+1][x] = 1;
                        }
                    }
                    if (count != 0) {
                        countArray[countIndex++] = count;
                        count = 0;
                    }
                }
            }
        }
        System.out.println(countIndex);
        Arrays.stream(countArray).sorted().filter(c -> c != 0).forEach(System.out::println);
    }
}

record Coordinate(int x, int y) {}

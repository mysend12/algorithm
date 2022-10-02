package io.my.programmers;

import java.util.*;

public class Solution1844 {

    public static void main(String[] args) {
        int[][] maps = {
                {1,0,1,1,1},
                {1,0,1,0,1},
                {1,0,1,1,1},
                {1,1,1,0,1},
                {0,0,0,0,1}
        };
        System.out.println(solution(maps));
    }

    public static int solution(int[][] maps) {
        int width = maps[0].length - 1;
        int height = maps.length - 1;

        Queue<Coordinate> queue = new LinkedList<>();
        queue.add(new Coordinate(0, 0));

        int[][] passPosition = new int[maps.length][maps[0].length];

        int index = 1;
        int indexCount = 1;
        int nextIndexCount = 0;
        while(!queue.isEmpty()) {
            Coordinate coordinate = queue.poll();

            int x = coordinate.x();
            int y = coordinate.y();

            if (x-1 >= 0 && maps[y][x-1] == 1 && passPosition[coordinate.y()][coordinate.x() - 1] == 0) {
                queue.add(new Coordinate(x-1, y));
                nextIndexCount++;
            }
            if (y-1 >= 0 && maps[y-1][x] == 1 && passPosition[coordinate.y() - 1][coordinate.x()] == 0) {
                queue.add(new Coordinate(x, y-1));
                nextIndexCount++;
            }
            if (width >= x+1 && maps[y][x+1] == 1 && passPosition[coordinate.y()][coordinate.x() + 1] == 0) {
                if (x+1 == width && y == height) return index + 1;
                queue.add(new Coordinate(x+1, y));
                nextIndexCount++;
            }
            if (height >= y+1 && maps[y+1][x] == 1 && passPosition[coordinate.y() + 1][coordinate.x()] == 0) {
                if (x == width && y+1 == height) return index + 1;
                queue.add(new Coordinate(x, y+1));
                nextIndexCount++;
            }

            passPosition[coordinate.y()][coordinate.x()] = 1;
            if (--indexCount == 0) {
                index++;
                indexCount = nextIndexCount;
                nextIndexCount = 0;
            }

        }

        return -1;
    }
}

record Coordinate(int x, int y) {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
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
        int lastX = maps[0].length - 1;
        int lastY = maps.length - 1;

        Queue<Coordinate> queue = new LinkedList<>();
        queue.add(new Coordinate(0, 0, 1));
        Map<Coordinate, Byte> passMap = new HashMap<>();

        do {
            Coordinate coordinate = queue.poll();
            int index = coordinate.index() + 1;
            passMap.put(coordinate, (byte) 1);

            int x = coordinate.x();
            int y = coordinate.y();

            if (x-1 >= 0 && maps[y][x-1] == 1) {
                addQueue(queue, passMap, x - 1, y, index);
            }
            if (y-1 >= 0 && maps[y-1][x] == 1) {
                addQueue(queue, passMap, x, y-1, index);
            }
            if (lastX >= x+1 && maps[y][x+1] == 1) {
                if (x+1 == lastX && y == lastY) return index;
                addQueue(queue, passMap, x+1, y, index);
            }
            if (lastY >= y+1 && maps[y+1][x] == 1) {
                if (x == lastX && y+1 == lastY) return index;
                addQueue(queue, passMap, x, y+1, index);
            }
        } while(!queue.isEmpty());

        return -1;
    }

    static void addQueue(Queue<Coordinate> queue, Map<Coordinate, Byte> passMap, int x, int y, int index) {
        Coordinate coordinate = new Coordinate(x, y, index);
        if (passMap.containsKey(coordinate)) return;
        if (queue.isEmpty() || queue.stream().noneMatch(e -> e.equals(coordinate))) queue.add(coordinate);
    }

//    static class Coordinate {
//        final int x;
//        final int y;
//        final int index;
//
//        public Coordinate(int x, int y, int index) {
//            this.x = x;
//            this.y = y;
//            this.index = index;
//        }
//
//        public int x() {
//            return x;
//        }
//
//        public int y() {
//            return y;
//        }
//
//        public int index() {
//            return index;
//        }
//
//        @Override
//        public boolean equals(Object o) {
//            if (this == o) return true;
//            if (o == null || getClass() != o.getClass()) return false;
//            Coordinate that = (Coordinate) o;
//            return x == that.x && y == that.y;
//        }
//
//        @Override
//        public int hashCode() {
//            return Objects.hash(x, y);
//        }
//    }

}

record Coordinate(int x, int y, int index) {

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
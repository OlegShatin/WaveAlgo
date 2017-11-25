package com.olegshatin.algo;

import java.util.*;

/**
 * @author Oleg Shatin
 *         11-501
 */
public class WaveAlgo {


    /**
     * Generates list of positions of rectangle 2D matrix, which is the shortest way from start to goal
     * @param width of field, where is search executed
     * @param height of field, where is search executed
     * @param startPosition position, which is start for path, included into result
     * @param goalPosition position, which is finish for path, included into result
     * @param blockedPositions set of positions, that result cannot to include
     * @return shortest path, included start and goal or null if there is no way
     */
    public static List<Position> FindPath(int width, int height, Position startPosition,
                                          Position goalPosition, List<Position> blockedPositions) {
        //reverse find direction to not reversing result
        Position goal = startPosition;
        Position start = goalPosition;

        int[][] field = new int[width][height];
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                field[i][j] = 0;
            }
        }
        for (Position blocked : blockedPositions) {
            field[blocked.getX()][blocked.getY()] = Integer.MAX_VALUE;
        }
        field[start.getX()][start.getY()] = 1;

        Queue<Position> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty() && field[goal.getX()][goal.getY()] == 0) {
            Position next = queue.poll();
            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    //if neighbor is not marked
                    if (    (i == 0 || j == 0) && !(i == 0 && j == 0)
                            && next.getX() + i >= 0 && next.getX() + i < field.length
                            && next.getY() + j >= 0 && next.getY() + j < field[next.getX() + i].length
                            && field[next.getX() + i][next.getY() + j] == 0) {

                        field[next.getX() + i][next.getY() + j] = field[next.getX()][next.getY()] + 1;
                        queue.add(new Position(next.getX() + i, next.getY() + j));
                    }
                }
            }
        }

        if (field[goal.getX()][goal.getY()] > 0) {

            ArrayList<Position> positions = new ArrayList<>();
            Position current = goal;
            while (!(current.getX() == start.getX() && current.getY() == start.getY())) {
                positions.add(new Position(current.getX(), current.getY()));
                boolean interrupt = false;
                for (int i = -1; i < 2 && !interrupt; i++) {
                    for (int j = -1; j < 2 && !interrupt; j++) {
                        if ((i == 0 || j == 0) && !(i == 0 && j == 0)
                            && current.getX() + i >= 0 && current.getX() + i < field.length
                            && current.getY() + j >= 0 && current.getY() + j < field[current.getX() + i].length
                            && field[current.getX() + i][current.getY() + j]
                                                == field[current.getX()][current.getY()] - 1
                                            ) {
                            //System.out.println("second: " + (current.getX() + i) + ", " + (current.getY() + j) );
                            current = new Position(current.getX() + i, current.getY() + j);
                            interrupt = true;
                        }
                    }
                }
            }
            positions.add(start);
            return positions;
        } else {
            return null;
        }
    }
}

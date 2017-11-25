package com.olegshatin.algo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Oleg Shatin
 *         11-501
 */
public class Program {
    public static void main(String[] args) {
        int edgeSize = 15;
        List<Position> borders = new ArrayList<>();
        for (int i = 0; i < edgeSize - 2; i++) {

            borders.add(new Position(2, i));
        }
        for (int i = edgeSize - 1; i > 3; i--) {

            borders.add(new Position(7, i));
        }


        //usage
        List<Position> path = WaveAlgo.FindPath(edgeSize, edgeSize,
                new Position(0, 0), new Position(edgeSize - 1, 5),
                borders);

        char[][] matrix = new char[edgeSize][edgeSize];
        for (int i = 0; i < edgeSize; i++)
            for (int j = 0; j < edgeSize; j++)
                //empty fields
                matrix[i][j] = '-';


        for (Position border :
                borders) {
            //borders
            matrix[border.getX()][border.getY()] = 'X';
        }
        for (Position step :
                path) {
            //path steps
            matrix[step.getX()][step.getY()] = '#';
        }
        for (int i = 0; i < edgeSize; i++){
            for (int j = 0; j < edgeSize; j++) {
                System.out.print(matrix[j][i]);
            }
            System.out.println();
        }

    }
}

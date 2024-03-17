package org.tfoc;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The class containing the solution to this exercise
 */
public class Solution {

    public int orangesRotting(int[][] grid) {

        List<Point> freshPoints = getInitialFreshPoints(grid);

        int i = 0;
        if (!freshPoints.isEmpty()) {
            Set<Point> pointsWithRottenNeighbours = getPointsWithRottenNeighbours(freshPoints, grid);
            while (!pointsWithRottenNeighbours.isEmpty() && !freshPoints.isEmpty()) {
                for (Point point : pointsWithRottenNeighbours) {
                    freshPoints.remove(point);
                    grid[point.y][point.x] = 2;
                }
                pointsWithRottenNeighbours = getPointsWithRottenNeighbours(freshPoints, grid);
                i++;
            }
            if (!freshPoints.isEmpty())
                i = -1;
        }
        return i;
    }

    private List<Point> getInitialFreshPoints(int[][] grid) {

        List<Point> freshPoints = new ArrayList<>();

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == 1)
                    freshPoints.add(new Point(col, row));
            }
        }

        return freshPoints;
    }

    private Set<Point> getPointsWithRottenNeighbours(List<Point> points, int[][] grid) {

        Set<Point> pointsWithRottenNeighbours = new HashSet<>();

        for (Point point : points) {
            if ((point.x > 0 && grid[point.y][point.x - 1] == 2) ||
                    (point.x < (grid[point.y].length - 1) && grid[point.y][point.x + 1] == 2) ||
                    (point.y > 0 && grid[point.y - 1][point.x] == 2) ||
                    (point.y < (grid.length - 1) && grid[point.y + 1][point.x] == 2))
                pointsWithRottenNeighbours.add(point);

        }
        return pointsWithRottenNeighbours;
    }

}

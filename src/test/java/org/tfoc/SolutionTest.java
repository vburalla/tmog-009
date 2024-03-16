package org.tfoc;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
class SolutionTest {

    @ParameterizedTest
    @MethodSource("provideOrangeArrays")
    void testSolutions(int[][] grid, int result) {
        Solution solution = new Solution();
        assertEquals(result, solution.orangesRotting(grid));
    }

    private static Stream<Arguments> provideOrangeArrays() {
        return Stream.of(
                Arguments.of(new int[][]{{2,1,1},{1,1,0},{0,1,1}}, 4),
                Arguments.of(new int[][]{ { 2, 1, 1 },{ 0, 1, 1 },{ 1, 0, 1 } }, -1),
                Arguments.of(new int[][]{ { 0, 2 }}, 0),
                Arguments.of(new int[][]{{2,0,1,1,1,1,1,1,1,1},{1,0,1,0,0,0,0,0,0,1},{1,0,1,0,1,1,1,1,0,1},{1,0,1,0,1,0,0,1,0,1},{1,0,1,0,1,0,0,1,0,1},{1,0,1,0,1,1,0,1,0,1},{1,0,1,0,0,0,0,1,0,1},{1,0,1,1,1,1,1,1,0,1},{1,0,0,0,0,0,0,0,0,1},{1,1,1,1,1,1,1,1,1,1}}, 58)
        );
    }

}
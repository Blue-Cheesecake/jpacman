package nl.tudelft.jpacman.board;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

/**
 * Test various aspects of board.
 *
 * @author Jeroen Roosen
 */
class BoardTest {

    private static final int MAX_WIDTH = 2;
    private static final int MAX_HEIGHT = 3;

    private final Square[][] grid = {
        {mock(Square.class), mock(Square.class), mock(Square.class)},
        {mock(Square.class), mock(Square.class), mock(Square.class)},
    };
    private final Board board = new Board(grid);


    /**
     * Verify that the board is invariant.
     */
    @Test
    void testBoard() {
        final Square[][] grid = {{new BasicSquare()}};
        final Board board1 = new Board(grid);
        assertThat(board1.invariant()).isEqualTo(true);
    }

    /**
     * Verify that square is accessible to unit.
     */
    @Test
    void testIsAccessibleTo() {
        final Square square = new BasicSquare();
        final Unit unit = new BasicUnit();

        assertThat(square.isAccessibleTo(unit)).isEqualTo(true);
    }

    /**
     * Verify getting square from board.
     */
    @Test
    void testSquareAt() {
        final Square[][] grid = {{new BasicSquare(), null}};
        final Board board1 = new Board(grid);
        assertThat(board1.squareAt(0, 1)).isEqualTo(null);
    }


    /**
     * Verifies the board has the correct width.
     */
    @Test
    void verifyWidth() {
        assertThat(board.getWidth()).isEqualTo(MAX_WIDTH);
    }

    /**
     * Verifies the board has the correct height.
     */
    @Test
    void verifyHeight() {
        assertThat(board.getHeight()).isEqualTo(MAX_HEIGHT);
    }

    /**
     * Verify that squares at key positions are properly set.
     *
     * @param x Horizontal coordinate of relevant cell.
     * @param y Vertical coordinate of relevant cell.
     */
    @ParameterizedTest
    @CsvSource({
        "0, 0",
        "1, 2",
        "0, 1"
    })
    void testSquareAt(int x, int y) {
        assertThat(board.squareAt(x, y)).isEqualTo(grid[x][y]);
    }
}

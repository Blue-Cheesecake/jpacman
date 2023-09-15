package nl.tudelft.jpacman.board;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test suite to confirm that {@link Unit}s correctly (de)occupy squares.
 *
 * @author Jeroen Roosen 
 *
 */
class OccupantTest {

    /**
     * The unit under test.
     */
    private Unit unit;

    /**
     * Resets the unit under test.
     */
    @BeforeEach
    void setUp() {
        unit = new BasicUnit();
    }

    /**
     * Asserts that a unit has no square to start with.
     */
    @Test
    void noStartSquare() {
        Assertions.assertFalse(unit.hasSquare());
    }

    /**
     * Tests that the unit indeed has the target square as its base after
     * occupation.
     */
    @Test
    void testOccupy() {
        Assertions.assertFalse(unit.hasSquare());
        Square square = new BasicSquare();
        unit.occupy(square);
        Assertions.assertTrue(unit.hasSquare());
        Assertions.assertEquals(unit.getSquare(), square);
    }

    /**
     * Test that the unit indeed has the target square as its base after
     * double occupation.
     */
    @Test
    void testReoccupy() {
        Assertions.assertFalse(unit.hasSquare());
        Square square = new BasicSquare();
        unit.occupy(square);
        unit.occupy(square);
        Assertions.assertTrue(unit.hasSquare());
        Assertions.assertEquals(unit.getSquare(), square);
    }
}

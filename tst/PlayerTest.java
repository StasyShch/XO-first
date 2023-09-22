import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void getName() {
        final String inputValue = "Jan";

        final String expectedName = inputValue;// in this case, but sometimes it could be transformed somehow.

        final Player player = new Player(inputValue,Figure.O);
        final String actualValue = player.getName();

        assertEquals(expectedName,actualValue);
    }

    @Test
    public void getSymbol() {
        Figure inputFigure =Figure.O;
        String expectedValue=inputFigure.toString();

        final Player player = new Player(null,inputFigure);
        final String actualValue = player.getSymbol();

        assertEquals(expectedValue,actualValue);

        //in general these tests are used to maintain correct
        // working of exact methods, and inside these methods there no mistakes logical
    }
}
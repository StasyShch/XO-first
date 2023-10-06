import model.Figure;
import model.Player;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {

    @Test
    public void testGetName() {
        final String inputValue = "Jan";

        final String expectedName = inputValue;// in this case, but sometimes it could be transformed somehow.

        final Player player = new Player(inputValue, Figure.O);
        final String actualValue = player.getName();

        assertEquals(expectedName,actualValue);
    }

    @Test
    public void testGetSymbol() {
        Figure inputFigure =Figure.O;
       Figure expectedValue=inputFigure;

        final Player player = new Player(null,inputFigure);
        final Figure actualValue = player.getSymbol();

        assertEquals(expectedValue,actualValue);

        //in general these tests are used to maintain correct
        // working of exact methods, and inside these methods there no mistakes logical
    }
}
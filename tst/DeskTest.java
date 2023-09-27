import org.junit.Test;
import java.awt.*;
import static org.junit.Assert.assertEquals;


public class DeskTest {

    @Test
    public void testGetSize() {
        int inputValue=3;
        int expectedValue = inputValue;
        Desk desk = new Desk(inputValue);
        assertEquals(expectedValue,desk.getSize());
    }

    @Test
    public void testSetFigure() {
        Figure inputFigure = Figure.O;
        int size = 3;
        final Desk desk= new Desk(size);
        final Point inputPoint = new Point(0,0);

        desk.setFigure(inputPoint,inputFigure);
        Figure actualFigure = Figure.valueOf(desk.getFigure(inputPoint));//need to refactor Figure-String
        assertEquals(inputFigure,actualFigure);
    }
}
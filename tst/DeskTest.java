import exceptions.InvalidCoordinateException;
import exceptions.PointOccupiedException;
import org.junit.Test;
import java.awt.*;

import static org.junit.Assert.*;


public class DeskTest {

    @Test
    public void testGetSize() {
        int inputValue=3;
        int expectedValue = inputValue;
        Desk desk = new Desk(inputValue);
        assertEquals(expectedValue,desk.getSize());
    }

    @Test
    public void testSetFigure() throws Exception {
        Figure inputFigure = Figure.O;
        int size = 3;
        final Desk desk= new Desk(size);
        final Point inputPoint = new Point(0,0);

        desk.setFigure(inputPoint,inputFigure);
        Figure actualFigure = desk.getFigure(inputPoint);
        assertEquals(inputFigure,actualFigure);
    }
    @Test
    public void testGetFigureFromEmptyDeskCell() throws Exception {
        Figure inputFigure = Figure.O;
        int size = 3;
        final Desk desk= new Desk(size);
        final Point inputPoint = new Point(0,0);

        Figure actualFigure = desk.getFigure(inputPoint);
        assertNull(actualFigure);
    }

    @Test
    public void testGetFigureWhenXIsMoreThanSize() throws Exception {
        Figure inputFigure = Figure.O;
        int size = 3;
        final Desk desk= new Desk(size);
        final Point inputPoint = new Point(size+1,0);
try {
    Figure actualFigure = desk.getFigure(inputPoint);
    fail();
}
        catch (InvalidCoordinateException e){}

    }
    @Test
    public void testGetFigureWhenYIsMoreThanSize() throws Exception {
        Figure inputFigure = Figure.O;
        int size = 3;
        final Desk desk= new Desk(size);
        final Point inputPoint = new Point(0,size+1);
        try {
            Figure actualFigure = desk.getFigure(inputPoint);
            fail();
        }
        catch (InvalidCoordinateException e){}

    }

    @Test
    public void testGetFigureWhenXIsLessThanZero() throws Exception {
        Figure inputFigure = Figure.O;
        int size = 3;
        final Desk desk= new Desk(size);
        final Point inputPoint = new Point(-1,0);
        try {
            Figure actualFigure = desk.getFigure(inputPoint);
            fail();
        }
        catch (InvalidCoordinateException e){}

    }

    @Test
    public void testGetFigureWhenYIsLessThanZero() throws Exception {
        Figure inputFigure = Figure.O;
        int size = 3;
        final Desk desk= new Desk(size);
        final Point inputPoint = new Point(0,-1);
        try {
            Figure actualFigure = desk.getFigure(inputPoint);
            fail();
        }
        catch (InvalidCoordinateException e){}

    }
    @Test
    public void testGetFigureWhenYAndXIsLessThanZero() throws Exception {
        Figure inputFigure = Figure.O;
        int size = 3;
        final Desk desk= new Desk(size);
        final Point inputPoint = new Point(-1,-1);
        try {
            Figure actualFigure = desk.getFigure(inputPoint);
            fail();
        }
        catch (InvalidCoordinateException e){}

    }

    @Test
    public void testGetFigureWhenYAndXIsMoreThanSize() throws Exception {
        Figure inputFigure = Figure.O;
        int size = 3;
        final Desk desk= new Desk(size);
        final Point inputPoint = new Point(size+1,size+1);
        try {
            Figure actualFigure = desk.getFigure(inputPoint);
            fail();
        }
        catch (InvalidCoordinateException e){}

    }
}
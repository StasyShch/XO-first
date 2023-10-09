package controller;

import exceptions.InvalidCoordinateException;
import model.Desk;
import model.Figure;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class WinnerControllerTest {

    @Test
    public void testWinnerFoundInRow() throws Exception {
       int inputSize = 3;

        WinnerController winnerController= new WinnerController();
        for (int i = 0; i < inputSize; i++) {
            Desk desk = new Desk(inputSize);
            desk.setFigure(new Point(i,0), Figure.X);
            desk.setFigure(new Point(i,1), Figure.X);
            desk.setFigure(new Point(i,2), Figure.X);
            assertEquals(true,winnerController.winnerFound(desk,new Point(i,0)));
        }




    }
    @Test
    public void testWinnerFoundNoWinnerInRow() throws Exception {
        int inputSize = 3;
        WinnerController winnerController= new WinnerController();
        for (int i = 0; i < inputSize; i++) {
            Desk desk = new Desk(inputSize);
            desk.setFigure(new Point(i,0), Figure.X);
            desk.setFigure(new Point(i,1), Figure.O);
            desk.setFigure(new Point(i,2), Figure.X);
            assertEquals(false,winnerController.winnerFound(desk,new Point(i,0)));
        }
    }

    @Test
    public void testWinnerFoundInColumn() throws Exception {
        int inputSize = 3;
        WinnerController winnerController= new WinnerController();
        for (int i = 0; i < inputSize; i++) {
            Desk desk = new Desk(inputSize);
            desk.setFigure(new Point(0,i), Figure.X);
            desk.setFigure(new Point(1,i), Figure.X);
            desk.setFigure(new Point(2,i), Figure.X);
            assertEquals(true,winnerController.winnerFound(desk,new Point(0,i)));
        }
    }
    @Test
    public void testWinnerFoundNoWinnerInColumn() throws Exception {
        int inputSize = 3;
        WinnerController winnerController= new WinnerController();
        for (int i = 0; i < inputSize; i++) {
            Desk desk = new Desk(inputSize);
            desk.setFigure(new Point(0,i), Figure.X);
            desk.setFigure(new Point(1,i), Figure.O);
            desk.setFigure(new Point(2,i), Figure.X);
            assertEquals(false,winnerController.winnerFound(desk,new Point(i,0)));
        }
    }

    @Test
    public void testWinnerFoundInDiag1() throws Exception {
        int inputSize = 3;
        WinnerController winnerController= new WinnerController();
        for (int i = 0; i < inputSize; i++) {
            Desk desk = new Desk(inputSize);
            desk.setFigure(new Point(0,0), Figure.X);
            desk.setFigure(new Point(1,1), Figure.X);
            desk.setFigure(new Point(2,2), Figure.X);
            assertEquals(true,winnerController.winnerFound(desk,new Point(0,0)));
        }
    }
    @Test
    public void testWinnerFoundNoWinnerInDiag1() throws Exception {
        int inputSize = 3;
        WinnerController winnerController= new WinnerController();
        for (int i = 0; i < inputSize; i++) {
            Desk desk = new Desk(inputSize);
            desk.setFigure(new Point(0,0), Figure.X);
            desk.setFigure(new Point(1,1), Figure.O);
            desk.setFigure(new Point(2,2), Figure.X);
            assertEquals(false,winnerController.winnerFound(desk,new Point(0,0)));
        }
    }

    @Test
    public void testWinnerFoundInDiag2() throws Exception {
        int inputSize = 3;
        WinnerController winnerController= new WinnerController();
        for (int i = 0; i < inputSize; i++) {
            Desk desk = new Desk(inputSize);
            desk.setFigure(new Point(0,2), Figure.X);
            desk.setFigure(new Point(1,1), Figure.X);
            desk.setFigure(new Point(2,0), Figure.X);
            assertEquals(true,winnerController.winnerFound(desk,new Point(1,1)));
        }
    }
    @Test
    public void testWinnerFoundNoWinnerInDiag2() throws Exception {
        int inputSize = 3;
        WinnerController winnerController= new WinnerController();
        for (int i = 0; i < inputSize; i++) {
            Desk desk = new Desk(inputSize);
            desk.setFigure(new Point(0,2), Figure.X);
            desk.setFigure(new Point(1,1), Figure.O);
            desk.setFigure(new Point(2,0), Figure.X);
            assertEquals(false,winnerController.winnerFound(desk,new Point(1,1)));
        }
    }
}
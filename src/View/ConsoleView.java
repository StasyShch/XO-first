package View;

import exceptions.InvalidCoordinateException;
import model.Desk;
import model.Figure;
import model.Game;

import java.awt.*;

public class ConsoleView {
    public void show(Game game){
        Desk desk = game.getDesk();
        for (int x = 0; x < desk.getSize() ; x++) {
            printLine(desk,x);
        }

    }

    private void printLine(Desk desk,
                           int x) {
        Figure figure;
        for (int y = 0; y <desk.getSize() ; y++) {
            if(y!=0)
                System.out.print("|");
            try {
                figure =desk.getFigure(new Point(x,y));

            } catch (InvalidCoordinateException e) {
                throw new RuntimeException(e);
            }
            System.out.print(figure != null ? figure : " ");
        }
        System.out.println();
    }
    private void printSeparator(){
        System.out.println("___________");
    }

    public void move(Game game){

    }
}

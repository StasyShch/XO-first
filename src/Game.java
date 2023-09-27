import exceptions.InvalidCoordinateException;
import exceptions.PointOccupiedException;

import java.awt.*;
import java.io.IOException;

public class Game {
    Desk desk;
    Player[] players;
    View view;

    boolean winnerFound = false;
   private int stepsCounter =0;

private Point lastStepPosition;
    public Game(Desk desk,Player[] players, View view){
        this.desk=desk;
        this.players=players;
        this.view=view;
    }

    public void startGame() throws  IOException {
        while (stepsCounter < desk.getCountOfCell()) {
            for (int j = 0; j < players.length; j++) {
                makeStep(desk,players[j],view);
                view.printDesk(desk);

                if (stepsCounter >= desk.getSize() * 2 - 1 & desk.checkWin(players[j],lastStepPosition) == true) {
                    view.printWinMessage(players[j]);
                    winnerFound=true;
                    stepsCounter = desk.getCountOfCell();
                    break;
                }
                if (stepsCounter == desk.getCountOfCell()) {
                    view.printMessage();
                    break;
                }
            }
        }

    }

    public void start() throws  IOException {
        while (stepsCounter < desk.getCountOfCell()) {
            for (int j = 0; j < players.length; j++) {
                makeStep(desk,players[j],view);
                view.printDesk(desk);

                if ( desk.checkWin(players[j],lastStepPosition) == true) {
                    view.printWinMessage(players[j]);
                    winnerFound=true;
                    stepsCounter = desk.getCountOfCell();
                    break;
                }
                if (stepsCounter == desk.getCountOfCell()) {
                    view.printMessage();
                    break;
                }
            }
        }

    }



    public void makeStep (Desk desk, Player player, View view) throws  IOException {

        Point point = view.getStepCoordinate(player);
        try {
            desk.setFigure(point,player.getSymbol());
            lastStepPosition=point;
            stepsCounter++;
        } catch (InvalidCoordinateException e) {
            System.out.println("invalid coordinate, try again");
            makeStep(desk,player,view);
        } catch (PointOccupiedException e) {
            System.out.println("this place is not empty, try again");
            makeStep(desk,player,view);
        }



        }

}

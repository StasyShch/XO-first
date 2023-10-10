package model;

import controller.CurrentMoveController;
import controller.WinnerController;
import exceptions.InvalidCoordinateException;
import exceptions.PointOccupiedException;
import model.Desk;

import View.*;
import java.awt.*;
import java.io.IOException;

public class Game {
    private Desk desk;
    private static final int NUMBER_OF_PLAYERS = 2;
    private Player[] players = new Player[NUMBER_OF_PLAYERS];
    private View view;
   private boolean endOfGame = false;
   private int stepsCounter =0;

    public Game( View view) throws IOException {
        this.view=view;
    }

    public Desk getDesk(){
        return desk;
    }

    public void start() throws  IOException {
        //desk initialization
        int inputSize=view.getDeskSize();
        desk = new Desk(inputSize);
        //initialization of players
        for (int i = 0; i <players.length; i++) {
            players[i]=new Player(view.getPlayerName(), Figure.values()[i]);
        }
       // logic of the game
        while (!endOfGame) {
                for (int j = 0; j < players.length; j++) {
                    if (stepsCounter < desk.getCountOfCell()) {
                        makeStep(players[j]);
                            if (checkWin(players[j]) == true) {
                                view.printWinMessage(players[j], desk);
                                endOfGame= true;
                                break;
                             }

                    } else {
                        view.printMessage(desk);
                        endOfGame= true;
                        break;
                    }
                }
        }

    }


    private void makeStep ( Player player) throws IOException {
        view.printDesk(desk);
        Point point = view.getStepCoordinate(player);

        try {
            if(desk.getFigure(point)!=null)
            {
            throw new PointOccupiedException();
            }
            desk.setFigure(point,player.getSymbol());
            player.setLastStepCoordinate(point);
            stepsCounter++;
        } catch (InvalidCoordinateException e) {
            System.out.println("invalid coordinate, try again");
            makeStep(player);
        }
        catch (PointOccupiedException e) {
            System.out.println("place is already occupied, try again");
            makeStep(player);
        }

    }

    public boolean checkWin(Player player) {
        boolean result;

        WinnerController controller = new WinnerController();
        result = controller.winnerFound(desk,player.getLastStepCoordinate());
       return result;

    }

}

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
  private Player[] players;
   private View view;
    boolean winnerFound = false;

   private int stepsCounter =0;

    public Game( View view) throws IOException {
        this.view=view;
    }

    public void start() throws  IOException {
        desk = new Desk(view.getDeskSize());
        players = new Player[2];
        players[0] = new Player(view.getPlayerName(), Figure.X);
        players[1] = new Player(view.getPlayerName(),Figure.O);
        while (!winnerFound && stepsCounter < desk.getCountOfCell()) {
            for (int j = 0; j < players.length; j++) {
                makeStep(players[j]);
                if ( checkWin2(players[j]) == true) {
                    view.printWinMessage(players[j],desk);
                    winnerFound=true;
                    break;
                }
                if (stepsCounter == desk.getCountOfCell()) {
                    view.printMessage(desk);
                    break;
                }
            }
        }

    }



    public void makeStep ( Player player) throws IOException {
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
        int countOfSameSymbols = 0;

        int x=player.getLastStepCoordinate().x;
        int y=player.getLastStepCoordinate().y;

        for (int i = 0; i <desk.getDesk()[x].length ; i++) {
            if(desk.getDesk()[x][i]!=null &&desk.getDesk()[x][i].equals(player.getSymbol()))
                countOfSameSymbols++;
            else {
                countOfSameSymbols=0;
                break;}
        }

        if(x==y & countOfSameSymbols!=desk.getSize()){
            for (int i = 0; i <desk.getDesk().length ; i++) {
                if (desk.getDesk()[i][i]!=null&&desk.getDesk()[i][i].equals(player.getSymbol())) {
                    countOfSameSymbols++;
                }
                else {
                    countOfSameSymbols=0;
                    break;}
            }
        }


        if(x+y==desk.getSize()-1 & countOfSameSymbols!=desk.getSize()){
            for (int i = 0; i <desk.getDesk().length ; i++) {
                if(desk.getDesk()[i][desk.getSize()-1-i]!=null&&desk.getDesk()[i][desk.getSize()-1-i].equals(player.getSymbol()))
                    countOfSameSymbols++;
                else {
                    countOfSameSymbols=0;
                    break;}

            }
        }

        if(countOfSameSymbols!=desk.getSize()) {
            for (int i = 0; i < desk.getDesk().length; i++) {
                if (desk.getDesk()[i][y]!=null&&desk.getDesk()[i][y].equals(player.getSymbol()))
                    countOfSameSymbols++;
                else {
                    countOfSameSymbols = 0;
                    break;
                }
            }
        }
        return result=countOfSameSymbols==desk.getSize()?true:false;
    }

    public boolean checkWin2(Player player) {
        boolean result;


        WinnerController controller = new WinnerController();
        result = controller.winnerFound(desk,player.getLastStepCoordinate());
       return result;

    }

}

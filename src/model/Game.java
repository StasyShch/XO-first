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
    public static final int NUMBER_OF_PLAYERS = 2;
    private Player[] players;
    private int stepsCounter =0;

    public Game(Player[] players, Desk desk) throws IOException {
        this.players=players;
        this.desk=desk;
    }
    public Desk getDesk(){
        return desk;
    }
    public int getStepsCounter(){
        return stepsCounter;
    }
    public void makeStep ( Player player,Point point) throws IOException {
       // add exception when cant be trans to point
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
            makeStep(player,point);
        }
        catch (PointOccupiedException e) {
            System.out.println("place is already occupied, try again");
            makeStep(player,point);
        }

    }


}

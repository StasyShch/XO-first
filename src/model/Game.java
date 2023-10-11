package model;

import View.View;
import controller.WinnerController;
import exceptions.InvalidCoordinateException;
import exceptions.PointOccupiedException;

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
    public Player[] getPlayers(){
        return players;
    }


    public Player currentPlayer() throws IOException {//only for 2 players works
        if (desk.getStepsCounter()%2 ==0)
            return players[0];
        else return players[1];
    }
    }


package model;

import model.Figure;

import java.awt.*;

public class Player {

   private String name;
   private Figure figure;
   private  int lastStepCoordinate;

    public Player(String name, Figure figure) {
        this.name = name;
        this.figure = figure;
    }

    public String getName() {
        return name;
    }
    public int getLastStepCoordinate() {
        return lastStepCoordinate;
    }

    public Figure getSymbol() {
        return figure;
    }






}

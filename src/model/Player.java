package model;

import model.Figure;

import java.awt.*;

public class Player {

   private String name;
   private Figure figure;
   private  Point lastStepCoordinate;

    public Player(String name, Figure figure) {
        this.name = name;
        this.figure = figure;
    }

    public String getName() {
        return name;
    }
    public Point getLastStepCoordinate() {
        return lastStepCoordinate;
    }
    public void setLastStepCoordinate(Point point){
        this.lastStepCoordinate = point;
    }

    public Figure getSymbol() {
        return figure;
    }






}

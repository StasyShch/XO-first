package controller;

import model.Figure;
import model.Player;

import java.awt.*;

public class CurrentMoveController {
    Player player;
    Figure figure;
    Point currentPoint;



    public void setCurrentMovementController(Player player, Point currentPoint) {
        this.player = player;
        this.figure = player.getSymbol();
        this.currentPoint = currentPoint;
    }


}

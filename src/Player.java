import java.io.IOException;

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

    public String getSymbol() {
        return figure.toString();
    }




}

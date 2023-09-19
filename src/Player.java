import java.io.IOException;

public class Player {
    private View view;
   private String name;
   private String symbol;
   private  int lastStepCoordinate;

    public String getName() {
        return name;
    }
    public int getLastStepCoordinate() {
        return lastStepCoordinate;
    }

    public String getSymbol() {
        return symbol;
    }

    public Player(View view) throws TooMuch, IOException {
        this.name=view.getPlayersNames();
        if(view.numberOfPlayers==1){
            symbol ="X";
        }
        else symbol = "0";
    }

    public void makeStep(View view, Desk desk) throws TooMuch, IOException {

        lastStepCoordinate = view.getStepCoordinate(desk,this);

        desk.changeSymbol(lastStepCoordinate,symbol);

    }
}

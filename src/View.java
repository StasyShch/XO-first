import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class View {
    int numberOfPlayers;





    public String getPlayersNames() throws IOException, TooMuch {
        numberOfPlayers++;
        if (numberOfPlayers>2){
            throw new TooMuch("Could not create more players");
        }

        System.out.println("print name of "+ numberOfPlayers+" player");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nameOfPlayer = reader.readLine();

        return nameOfPlayer;
    }
    public int getStepCoordinate(Desk desk,Player player) throws IOException, TooMuch {
        System.out.println(player.getName()+",your symbol is "+player.getSymbol()+", choose where to put it");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String number = reader.readLine();
        int numberOfPlace=Integer.parseInt(number);
        if (numberOfPlace>desk.getCountOfCell()){
            throw new TooMuch("there is no such plase on a desk");
        }
        return numberOfPlace;
    }

    public int getDeskSize() throws IOException, TooMuch {
        System.out.println("choose size of desk");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String number = reader.readLine();
        int sizeOfDesk = Integer.parseInt(number);
        if (sizeOfDesk < 3) {
            throw new TooMuch("too small desk");
        }
        return sizeOfDesk;
    }

    public void printMessage(){
        System.out.println("Nobody won");
    }
    public void printWinMessage(Player player){
        System.out.println("Congratulations, "+player.getName()+" won!");
    }

    public void printDesk(Desk desk){
        for (int i = 0; i < desk.getDesk().length; i++) {
            System.out.println(Arrays.toString(desk.getDesk()[i]));
        }
    }

}



class TooMuch extends Exception {

    public TooMuch(String message) {
        super(message);
    }
}

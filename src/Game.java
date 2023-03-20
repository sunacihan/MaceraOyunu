import java.util.Scanner;

public class Game {
    Scanner input = new Scanner(System.in);


    void start() {
        // System.out.print("İsminizi giriniz:");
        //String playerName=input.next();
        Player player = new Player("Suna");

        player.selectChar();
        player.selectLocation();

    }
}

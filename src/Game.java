import java.util.Scanner;

public class Game {
    Scanner sc = new Scanner(System.in);
    Map myMap = new Map();

    public Game() throws WrongDirectionException {
        myMap.spawnPlayer();
        while (true){
            myMap.move(selectOption());
            myMap.showMap();
        }
    }

    private void showOptions() {
        System.out.println("Options: ");
        for (Options value : Options.values()) {
            System.out.println(value);
        }
    }

    private Options selectOption() {
        showOptions();
        String userInput = getInput();
        System.out.println();
        for (Options value : Options.values()) {
            if(value.toString().equalsIgnoreCase(userInput)){
                return value;
            }
        }
        return null;
    }

    private String getInput() {
        System.out.println("Enter direction: ");
        return sc.nextLine();
    }
}

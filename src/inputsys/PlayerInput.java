package inputsys;

import charsys.actions.Actionable;

import java.util.List;
import java.util.Scanner;

public class PlayerInput {

    private static final Scanner input = new Scanner(System.in);

    /**
     * Prompts the player to select an action from the list of actions of an RPGCharacter object.
     * @param actions RPGCharacter's actions.
     * @return Action chosen by player.
     */
    public static Actionable selectPlayerAction(List<Actionable> actions) {
        System.out.print("Select an action: ");
        int index = input.nextInt();
        return actions.get(index);
    }
}

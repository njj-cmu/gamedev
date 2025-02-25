package turnsys;

import charsys.RPGCharacter;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class TurnManager {

    // Get the turn of a character
    // End a character's turn
    // Checks if Turn Queue is empty or not

    private Queue<RPGCharacter> turnQueue;

    public TurnManager(List<RPGCharacter> participants) {
        this.turnQueue = new PriorityQueue<RPGCharacter>(new TurnComparator());
        this.turnQueue.addAll(participants);
    }

    /**
     * Gets the character object who wants to execute their next turn.
     * @return RPGCharacter object that will execute the next turn.
     */
    public RPGCharacter getNextTurn() {
        return turnQueue.poll();
    }

    /**
     * Ends the current turn of the latest RPGCharacter.
     */
    public void endTurn(RPGCharacter character) {
        // Modify turn later.
        /*
            We add a character to the end of the queue after they executed the action.
            Status effects will be added later to adjust turn order.
         */
        turnQueue.add(character);
    }

    /**
     * Checks if a turn is still available next.
     * @return True if a turn is available. False otherwise.
     */
    public boolean hasTurnLeft() {
        return !turnQueue.isEmpty();
    }
}

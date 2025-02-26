package turnsys;

import charsys.RPGCharacter;
import charsys.attrib.Attribute;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class TurnManager {

    // Get the turn of a character
    // End a character's turn
    // Checks if Turn Queue is empty or not

    private final Queue<TurnEntry> turnQueue = new PriorityQueue<>(new TurnComparator());
    /**
     * Ensures that each character can execute exactly only one action per turn!
     */
    private static final int TURN_CYCLE_INCREMENT = 1;

    public TurnManager() {}

    public TurnManager(List<RPGCharacter> participants) {
        this.addParticipants(participants);
    }

    public void addParticipants(List<RPGCharacter> participants) {
//        this.turnQueue.addAll(participants);
        for(RPGCharacter character: participants) {
            turnQueue.add(new TurnEntry(character, 0));
        }
    }

    /**
     * Gets the character object who wants to execute their next turn.
     * @return RPGCharacter object that will execute the next turn.
     */
    public RPGCharacter getNextTurn() {
        TurnEntry temp = turnQueue.peek(); // Get next character
        return (temp != null) ? temp.getCharacter() : null;
    }

    /**
     * Ends the current turn of the latest RPGCharacter.
     */
    public void endTurn(RPGCharacter character) {
        TurnEntry entry = findTurnEntry(character);
        // Modify turn later.
        /*
            We add a character to the end of the queue after they executed the action.
            Status effects will be added later to adjust turn order.
         */
        if(entry != null) {
            turnQueue.remove();
            entry.addTurnPriority(10 / character.getCharacterStat(Attribute.SPEED));
            turnQueue.offer(entry);
        }
    }

    /**
     * Checks if a turn is still available next.
     * @return True if a turn is available. False otherwise.
     */
    public boolean hasTurnLeft() {
        return !turnQueue.isEmpty();
    }

    public TurnEntry findTurnEntry(RPGCharacter character) {
        for(TurnEntry entry: this.turnQueue) {
            if(entry.getCharacter() == character) {
                return entry;
            }
        }
        return null;
    }

    public void showQueue() {
        for(TurnEntry entry: turnQueue) {
            System.out.println(entry.getCharacter().getName() + " - SPEED: " + entry.getCharacter().getCharacterStat(Attribute.SPEED));
        }
    }
}

package turnsys;

import charsys.RPGCharacter;
import charsys.attrib.Attribute;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class TurnManager {

    /**
     * Stores the queue of TurnEntry objects, where each TurnEntry object handles a particular character and monitors
     * their current turn order index. Positioning of characters in the queues is based on their SPEED attribute,
     * and their turn order index from the TurnEntry object.
     * <br><br>
     * For turn order index, see {@link TurnEntry} for more info.
     */
    private final Queue<TurnEntry> turnQueue = new PriorityQueue<>(new TurnComparator());

    /**
     * Creates a TurnManager object that handles the turn system during a formation battle of two different parties:
     * Player Party, and an Enemy Party.
     */
    public TurnManager() {}

    /**
     * Creates a TurnManager object with additional participant parameters.
     * @param participants List of RPGCharacter participants.
     */
    public TurnManager(List<RPGCharacter> participants) {
        this.addParticipants(participants);
    }

    /**
     * Adds a list of RPGCharacter participants that will participate
     * in the battle.
     * @param participants RPGCharacters to add.
     */
    public void addParticipants(List<RPGCharacter> participants) {
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
    public void endTurn() {

        // TODO: Factor status effects later (buffs, debuffs, stuns, etc.)
        // Remove the topmost TurnEntry object
        TurnEntry entry = turnQueue.remove();
        // Increase the character's round order index.
        entry.increaseRoundOrder();

        // Put back in the queue with an increased round order index.
        turnQueue.offer(entry);
    }

    /**
     * Checks if a turn is still available next.
     * @return True if a turn is available. False otherwise.
     */
    public boolean hasTurnLeft() {
        return !turnQueue.isEmpty();
    }


    private TurnEntry findTurnEntry(RPGCharacter character) {
        for(TurnEntry entry: this.turnQueue) {
            if(entry.getCharacter() == character) {
                return entry;
            }
        }
        return null;
    }

    /**
     * Debugging purposes. Shows the queue of RPGCharacters in the Turn System.
     */
    public void showQueue() {
        for(TurnEntry entry: turnQueue) {
            System.out.println(entry.getCharacter().getName() + " - SPEED: " + entry.getCharacter().getCharacterStat(Attribute.SPEED));
        }
    }
}

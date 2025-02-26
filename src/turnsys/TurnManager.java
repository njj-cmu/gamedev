package turnsys;

import charsys.RPGCharacter;
import charsys.actions.Actionable;
import charsys.attrib.Attribute;
import inputsys.PlayerInput;
import party.Party;

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
     * First party.
     */
    private final Party a;
    /**
     * Second party.
     */
    private final Party b;

    /**
     * Creates a TurnManager object that handles the turn between 2 different parties.
     * @param a First party.
     * @param b Second party.
     */
    public TurnManager(Party a, Party b) {
        this.a = a;
        this.b = b;
        addParticipants();
    }

    /**
     * Adds the list of participants from each party into the queue.
     */
    private void addParticipants() {
        // Add members from A
        for(RPGCharacter character: a.getPartyMembers()) {
            turnQueue.add(new TurnEntry(character, 0));
        }

        // Add members from B
        for(RPGCharacter character: b.getPartyMembers()) {
            turnQueue.add(new TurnEntry(character, 0));
        }
    }

    /**
     * Gets the character object who wants to execute their next turn.
     * @return RPGCharacter object that will execute the next turn.
     */
    private RPGCharacter getNextTurn() {
        TurnEntry temp = turnQueue.peek(); // Get next character
        return (temp != null) ? temp.getCharacter() : null;
    }

    /**
     * Ends the current turn of the latest RPGCharacter.
     */
    private void endTurn() {

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
    private boolean hasTurnLeft() {
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
    private void showQueue() {
        for(TurnEntry entry: turnQueue) {
            System.out.println(entry.getCharacter().getName() + " - SPEED: " + entry.getCharacter().getCharacterStat(Attribute.SPEED));
        }
    }

    public void runTurnCycle() {
        while(this.hasTurnLeft()) {
            RPGCharacter character = this.getNextTurn();

            if(character == null) break; // Safety check

            Actionable chosenAction = selectAction(character);
        }
    }

    /**
     * Initiate a prompt for the RPGCharacter to choose their turn's action.
     * @param character RPGCharacter object that wants to execute their action this turn.
     */
    private Actionable selectAction(RPGCharacter character) {
        // Display available actions
        // We can tweak this further later.
        character.displayCharacterActions();
        return PlayerInput.selectPlayerAction(character.getActions());
    }
}

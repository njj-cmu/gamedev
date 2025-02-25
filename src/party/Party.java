package party;

import charsys.RPGCharacter;
import pos.Position;

import java.util.ArrayList;
import java.util.List;

public class Party {
    private static final int MAX_ROWS = 3, MAX_COLS = 3;
    private final RPGCharacter[][] partyGrid;

    public Party() {
        this.partyGrid = new RPGCharacter[MAX_ROWS][MAX_COLS];
    }

    public RPGCharacter getCharacterAtPos(int row, int col) {
        return this.partyGrid[row][col];
    }

    public RPGCharacter getCharacterAtPos(Position position) {
        return this.partyGrid[position.getRow()][position.getCol()];
    }

    private void setCharacterAtPos(RPGCharacter character, Position pos) {
        this.partyGrid[pos.getRow()][pos.getCol()] = character;
    }

    /**
     * Checks if a character is present on the row and column.
     * @param row Row index. 0 <= row <= 2.
     * @param col Column index. 0 <= col <= 2.
     * @return True if empty, false if not.
     */
    public boolean isEmpty(int row, int col) {
        return this.partyGrid[row][col] == null;
    }

    /**
     * Automatically adds a character into the party formation using the
     * auto-positioning logic based on a character's preferred column indexes.
     * @param character RPGCharacter object to be automatically added.
     */
    public void addToPartyAuto(RPGCharacter character) {
        Position position = findOptimalPosition(character);
        if(position == null) {
            System.out.printf("No valid position for %s.\n", character.getName());
            return;
        }
        this.setCharacterAtPos(character, position);
        character.setPosition(position);
    }

    /**
     * Finds the optimal position of this character based on their preferred columns.
     * @param character Character to be placed.
     * @return Position object if a position is available. Null if party formation is full.
     */
    private Position findOptimalPosition(RPGCharacter character) {
        return this.findFirstAvailablePosition(character.getPreferredColumns());
    }

    /**
     * Finds the first available position based on the preferred columns given by the character.
     * It will iterate through the first preferred column to the least preferred column.
     * <br>
     * If no position is available, then it means that the party formation is full.
     * @param columns List of preferred columns from an RPGCharacter object.
     * @return Position object if a position is available. Null otherwise.
     */
    private Position findFirstAvailablePosition(List<Integer> columns) {
        for(int col: columns) {
            for(int row = 0; row < MAX_ROWS; row++) {
                if(isEmpty(row, col)) {
                    return new Position(row, col);
                }
            }
        }
        return null;
    }

    /**
     * Displays the name of each character in their respected positions.
     * Some cells that are empty will display [ Empty ].
     */
    public void displayParty() {
        for(int row = 0; row < MAX_ROWS; row++) {
            for(int col = 0; col < MAX_COLS; col++) {
                if(isEmpty(row, col)) {
                    System.out.print("[ Empty ]");
                }
                else {
                    System.out.printf("[ %s ]", getCharacterAtPos(row, col).getName());
                }
            }
            System.out.println();
        }
    }

    public List<RPGCharacter> getPartyMembers() {
        List<RPGCharacter> participants = new ArrayList<>();
        for(RPGCharacter[] row: partyGrid) {
            for(RPGCharacter participant: row) {
                participants.add(participant);
            }
        }

        return participants;
    }
}

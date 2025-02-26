package party;

import charsys.RPGCharacter;
import pos.Position;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Party {
    public static final int MAX_ROWS = 3, MAX_COLS = 3;
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
            for(RPGCharacter character: row) {
                if(character != null) // Safety check
                    participants.add(character);
            }
        }
        return participants;
    }

    /**
     * Gets the Position of the selected index from the party formation.
     * @param index Index.
     * @return Position object containing the row and column of the selected index.
     */
    public static Position getPositionBasedOnIndex(int index) {
        switch(index) {
            case 1:
                return new Position(0,0);
            case 2:
                return new Position(0,1);
            case 3:
                return new Position(0,2);
            case 4:
                return new Position(1,0);
            case 5:
                return new Position(1,1);
            case 6:
                return new Position(1,2);
            case 7:
                return new Position(2,0);
            case 8:
                return new Position(2,1);
            case 9:
                return new Position(2,2);
            default:
                // Invalid position
                return null;
        }
    }
}

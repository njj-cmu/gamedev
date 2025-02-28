package targetingsys;

import charsys.RPGCharacter;
import charsys.role.CharacterType;
import party.Party;
import pos.Position;

import java.util.ArrayList;
import java.util.List;

public class TargetingSystem {

    /**
     * Retrieve the list of valid targets based on a character.
     * <br><br>
     * Checks the character's type, and their current positioning.
     * @param character RPGCharacter that wants to target someone.
     * @param targetParty Receiving end of the character's actions.
     * @param reversed Flag if the party given has reversed columns, meaning
     *                 the party is an enemy party.
     *                 <br>
     *                 True if party is enemy party.
     *                 <br>
     *                 False if party is Player party.
     * @return Valid positions that can be targeted.
     */
    public List<Position> getValidTargets(RPGCharacter character, Party targetParty, boolean reversed) {
        List<Position> positions = new ArrayList<>();

        final int frontmost = TargetingSystem.getFrontMostColumn(targetParty, reversed);
        final int limit = character.hasType(CharacterType.RANGED) ? frontmost + 1 : frontmost;
        /*
            To return the valid positions, we have these:
                MELEE characters can only target the front-most columns.
                RANGED characters can target the front-most column and the next column behind it.
         */

        return positions.isEmpty() ? null : positions;
    }

    private static int getFrontMostColumn(Party party) {
        return TargetingSystem.getFrontMostColumn(party,false);
    }

    /**
     * Checks the column in which the first character of a given party grid appears.
     * @param grid Party grid to be checked.
     * @param reversed Flag if the party given is an enemy party or not.
     *                 <br>
     *                 True if party is enemy party.
     *                 <br>
     *                 False otherwise.
     * @return First index column where an RPGCharacter appears.
     */
    private static int getFrontMostColumn(Party party, boolean reversed) {
        /*
            Front-most column is different between player party and enemy party.
            In a player party, the front-most column is 2, facing the enemy party.
            On the other hand, the front-most column is 0, facing the player party.
        */

        for(int col = 0; col < Party.MAX_COLS; col++) {
            for(int row = 0; row < Party.MAX_ROWS; row++) {
                if(party.getCharacterAtPos(row,col) != null) {
                    return col;
                }
            }
        }

        /*
            In a non-reversed party grid, if there are no
         */
        return reversed ? 2 : 0;
    }
}

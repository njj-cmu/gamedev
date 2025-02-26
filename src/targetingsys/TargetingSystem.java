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
     * @return Valid positions that can be targeted.
     */
    public List<Position> getValidTargets(RPGCharacter character, Party targetParty) {
        List<Position> positions = new ArrayList<>();

        // Impose a column limit
        // This happens when selecting valid targets for a melee character.
        // They cannot target those on the backline unless the front-most enemies are eliminated.
        int colLimit;

        for(int col = 0; col < Party.MAX_COLS; col++) {
            for(int row = 0; row < Part)
        }

        for(int row = 0; row < Party.MAX_ROWS; row++) {
            // Col value is based on a character's type.

            for(; col < Party.MAX_COLS; col++) {

            }
        }

        return positions;
    }
}

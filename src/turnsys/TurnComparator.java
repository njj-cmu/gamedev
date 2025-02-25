package turnsys;

import charsys.RPGCharacter;
import charsys.attrib.Attribute;
import charsys.attrib.CharacterStats;

import java.util.Comparator;

/**
 * A comparator class that compares if one character should go first
 * based on their SPEED attribute.
 */
public class TurnComparator implements Comparator<RPGCharacter> {

    @Override
    public int compare(RPGCharacter o1, RPGCharacter o2) {
        if(o1.getCharacterStat(Attribute.SPEED) <
                o2.getCharacterStat(Attribute.SPEED)) {
            return -1;
        }
        else if(o1.getCharacterStat(Attribute.SPEED) ==
                o2.getCharacterStat(Attribute.SPEED)) {
            return 0;
        }
        return 1;
    }
}

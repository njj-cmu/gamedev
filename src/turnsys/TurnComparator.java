package turnsys;

import charsys.attrib.Attribute;

import java.util.Comparator;

/**
 * A comparator class that compares if one character should go first
 * based on their SPEED attribute.
 */
public class TurnComparator implements Comparator<TurnEntry> {

    @Override
    public int compare(TurnEntry o1, TurnEntry o2) {
        if(o1.getRoundOrder() != o2.getRoundOrder()) {
            return Integer.compare(o1.getRoundOrder(), o2.getRoundOrder());
        }

        return Integer.compare(o2.getCharacter().getCharacterStat(Attribute.SPEED),
                o1.getCharacter().getCharacterStat(Attribute.SPEED));
    }
}

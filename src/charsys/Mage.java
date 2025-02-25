package charsys;

import charsys.actions.SpellCast;
import charsys.role.CharacterRole;
import charsys.role.CharacterType;

import java.util.List;

public class Mage extends RPGCharacter {

    public Mage(String name) {
        this(name, CharacterRole.BURST);
    }

    public Mage(String name, CharacterRole primary) {
        super(name, CharacterType.RANGED, primary, List.of(2,1,0));
        this.assignDefaultActions();
    }

    public Mage(String name, CharacterRole primary, CharacterRole secondary) {
        super(name, CharacterType.RANGED, primary, secondary, List.of(2, 1, 0));
    }

    @Override
    public void assignDefaultActions() {
        this.addAction(new SpellCast());
    }
}

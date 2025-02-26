package charsys;

import charsys.actions.BuffAction;
import charsys.actions.Weaken;
import charsys.role.CharacterRole;
import charsys.role.CharacterType;

import java.util.List;

public class Cleric extends RPGCharacter {

    public Cleric(String name) {
        this(name, CharacterRole.SUPPORT, CharacterRole.HEALER);
    }

    public Cleric(String name, CharacterRole primary) {
        super(name, CharacterType.RANGED, primary, List.of(0,1,2));
        this.assignDefaultActions();
    }

    public Cleric(String name, CharacterRole primary, CharacterRole secondary) {
        super(name, CharacterType.RANGED, primary, secondary, List.of(0,1,2));
        this.assignDefaultActions();
    }

    @Override
    public void assignDefaultActions() {
        // By adding BuffAction() first, we are declaring that clerics perform buffs by default
        addAction(new BuffAction());
        // To let clerics perform the debuff action, we can implement some sort of AI system for this one.
        addAction(new Weaken());
    }
}
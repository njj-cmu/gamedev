package charsys;

import charsys.actions.Attack;
import charsys.actions.Defend;
import charsys.role.CharacterRole;
import charsys.role.CharacterType;

import java.util.List;

public class Warrior extends RPGCharacter {

    public Warrior(String name) {
        this(name, CharacterRole.FIGHTER);
    }

    public Warrior(String name, CharacterRole role) {
        super(name, CharacterType.MELEE, role, List.of(2,1,0));
        this.assignDefaultActions();
    }

    public Warrior(String name, CharacterRole primary, CharacterRole secondary) {
        super(name, CharacterType.MELEE, primary, secondary, List.of(2,1,0));
        this.assignDefaultActions();
    }

    @Override
    public void assignDefaultActions() {
        this.addAction(new Attack());
        this.addAction(new Defend());
    }
}

package charsys.actions;

import charsys.RPGCharacter;

/**
 * A spell-casting action where an RPGCharacter casts a fireball.
 */
public class Fireball implements Actionable {

    @Override
    public TargetType getTargetType() {
        return TargetType.SINGLE;
    }

    @Override
    public void performAction(RPGCharacter target) {
        System.out.printf("throws a fireball at %s!\n", target.getName());
    }

    @Override
    public String getActionName() {
        return "Fireball";
    }
}

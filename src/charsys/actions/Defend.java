package charsys.actions;

import charsys.RPGCharacter;

/**
 * A buffing action that increases the defense of a selected RPGCharacter.
 */
public class Defend implements Actionable {

    @Override
    public TargetType getTargetType() {
        return TargetType.SINGLE;
    }

    @Override
    public void performAction(RPGCharacter target) {
        System.out.printf("casted Defend on %s, increasing their defense!\n", target.getName());
    }

    @Override
    public String getActionName() {
        return "Defend";
    }
}

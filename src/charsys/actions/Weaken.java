package charsys.actions;

import charsys.RPGCharacter;

/**
 * A debuffing action that decreases the defense of a target RPGCharacter.
 */
public class Weaken implements Actionable {

    @Override
    public TargetType getTargetType() {
        return null;
    }

    @Override
    public void performAction(RPGCharacter target) {
        System.out.printf("decreases %s's defense!\n", target.getName());
    }

    @Override
    public String getActionName() {
        return "Weaken";
    }
}

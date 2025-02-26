package charsys.actions;

import charsys.RPGCharacter;

/**
 * An action that increases the attack damage to a target RPGCharacter.
 */
public class Inspire implements Actionable {
    @Override
    public TargetType getTargetType() {
        return TargetType.SINGLE;
    }

    @Override
    public void performAction(RPGCharacter target)
    {
        System.out.printf("buffed %s!\n", target.getName());
    }

    @Override
    public String getActionName() {
        return "Inspire";
    }
}

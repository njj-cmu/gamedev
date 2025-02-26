package charsys.actions;

import charsys.RPGCharacter;
import pos.Position;

/**
 * A single target attack action.
 */
public class Attack implements Actionable {

    @Override
    public TargetType getTargetType() {
        return TargetType.SINGLE;
    }

    @Override
    public void performAction(RPGCharacter target) {
        System.out.printf("attacks %s", target.getName());
    }

    public String getActionName() {
        return "Attack";
    }
}
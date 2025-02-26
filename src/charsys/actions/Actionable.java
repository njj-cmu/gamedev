package charsys.actions;

import charsys.RPGCharacter;
import pos.Position;

import java.util.List;

public interface Actionable {

    /**
     * Target type of this action.
     * <br><br>
     * See {@link TargetType} for more info of target types.
     * @return Target type.
     *
     */
    public TargetType getTargetType();

    public void performAction(RPGCharacter target);

    /**
     * String-based name of this action.
     * @return String-based action name.
     */
    public String getActionName();
}

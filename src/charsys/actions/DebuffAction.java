package charsys.actions;

public class DebuffAction implements Actionable {
    @Override
    public void performAction() {
        System.out.println("debuff an enemy!");
    }
}

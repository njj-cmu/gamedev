package charsys.actions;

public class Defend implements Actionable {
    @Override
    public void performAction() {
        System.out.println("defends against an attack!");
    }
}

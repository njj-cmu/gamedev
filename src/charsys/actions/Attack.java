package charsys.actions;

public class Attack implements Actionable {
    @Override
    public void performAction() {
        System.out.println("swing a heavy sword!");
    }
}
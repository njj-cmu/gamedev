package charsys.actions;

public class SpellCast implements Actionable {
    @Override
    public void performAction() {
        System.out.println("cast a spell!");
    }
}

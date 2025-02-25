package charsys.actions;

public interface Actionable {
    void performAction();

    interface Attacker {
        public void attack();
    }
}

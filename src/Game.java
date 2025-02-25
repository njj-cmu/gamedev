import charsys.*;
import charsys.role.CharacterRole;
import party.Party;

public class Game {
    public static void main(String[] args) {

        Party party = new Party();

        RPGCharacter hero1 = new Warrior("Leon", CharacterRole.TANK);
        RPGCharacter hero2 = new Mage("Merlin", CharacterRole.BURST);
        RPGCharacter hero3 = new Cleric("Raul", CharacterRole.SUPPORT);

        party.addToPartyAuto(hero1);
        party.addToPartyAuto(hero2);
        party.addToPartyAuto(hero3);

        party.displayParty();
    }
}
import charsys.*;
import charsys.attrib.Attribute;
import charsys.role.CharacterRole;
import party.Party;
import turnsys.TurnEntry;
import turnsys.TurnManager;

public class Game {
    public static void main(String[] args) {

        // TODO: Try to change your party formation and see what works

        Party playerParty = new Party();

        RPGCharacter hero1 = new Warrior("Leon", CharacterRole.TANK);
        RPGCharacter hero2 = new Mage("Merlin", CharacterRole.BURST);
        RPGCharacter hero3 = new Cleric("Raul", CharacterRole.SUPPORT);

        hero1.setCharacterStat(Attribute.SPEED, 5);
        hero2.setCharacterStat(Attribute.SPEED, 6);
        hero3.setCharacterStat(Attribute.SPEED, 4);

        playerParty.addToPartyAuto(hero1);
        playerParty.addToPartyAuto(hero2);
        playerParty.addToPartyAuto(hero3);

        System.out.println("Player PARTY");
        playerParty.displayParty();

        // Enemy party composition
        // TODO: Try to play around the characters

        Party enemyParty = new Party();

        RPGCharacter enemy1 = new Warrior("Johnson", CharacterRole.TANK);
        RPGCharacter enemy2 = new Archer("Miya");
        RPGCharacter enemy3 = new Mage("Albus");

        enemy1.setCharacterStat(Attribute.SPEED, 3);
        enemy2.setCharacterStat(Attribute.SPEED, 7);
        enemy3.setCharacterStat(Attribute.SPEED, 2);

        enemyParty.addToPartyAuto(enemy1);
        enemyParty.addToPartyAuto(enemy2);
        enemyParty.addToPartyAuto(enemy3);

        System.out.println("Enemy PARTY");
        enemyParty.displayParty();


        // Creating a TurnManager

        TurnManager turnManager = new TurnManager();
        turnManager.addParticipants(playerParty.getPartyMembers());
        turnManager.addParticipants(enemyParty.getPartyMembers());

        // Show Lineup of the Queue
        System.out.println("Turn Lineup!");
        turnManager.showQueue();

        // Create a breakpoint here and run the entire program using DEBUG.
        while(turnManager.hasTurnLeft()) {
            // Get next character
            RPGCharacter character = turnManager.getNextTurn();

            if(character == null) break; // Safety check in case no Character is present

            System.out.printf("%s's turn!\n", character.getName());

            // For now, let's say each character will perform their default actions
            character.performChosenAction();

            // End character's turn
            turnManager.endTurn();
        }
    }
}
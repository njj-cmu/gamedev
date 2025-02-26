import charsys.*;
import charsys.actions.Actionable;
import charsys.attrib.Attribute;
import charsys.role.CharacterRole;
import party.Party;
import pos.Position;
import turnsys.TurnManager;

import java.util.Scanner;

public class Game {

    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
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

//
//        // Create a breakpoint here and run the entire program using DEBUG.
//        while(turnManager.hasTurnLeft())
//        {
//            // Get next character
//            RPGCharacter character = turnManager.getNextTurn();
//
//            if(character == null) break; // Safety check in case no Character is present
//
//            System.out.printf("%s's turn!\n", character.getName());
//
//            // Choose action first
//            System.out.printf("CHOOSE AN ACTION FOR %s\n", character.getName());
//            character.displayCharacterActions();
//
//            System.out.print("Action index: ");
//            int index = scanner.nextInt();
//
//            Actionable action = character.chooseAction(index);
//
//            // Choose target
//            System.out.println("Choose a target from the enemy!");
//            enemyParty.displayParty();
//            System.out.print("Index [1-9]: ");
//            int targetIndex = scanner.nextInt();
//            Position position = Party.getPositionBasedOnIndex(targetIndex);
//
//            // If given position is valid between 1 and 9
//            if(position != null) {
//                RPGCharacter target = enemyParty.getCharacterAtPos(position);
//                action.performAction(target);
//            }
//
//            // End character's turn
//            turnManager.endTurn();
//        }
    }
}
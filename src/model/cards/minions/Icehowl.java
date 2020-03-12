package model.cards.minions;

import model.cards.Rarity;

/**
 *
 * A subclass of Card representing a minion card.
 *
 * **/
public class Icehowl extends Minion {

    int attack;
    int maxHP;

    public Icehowl(){
        super("Icehowl", 9, Rarity.LEGENDARY, 10, 10);
        this.attack = 10;
        this.maxHP = 10;
        this.setCurrentHP(10);
    }

}
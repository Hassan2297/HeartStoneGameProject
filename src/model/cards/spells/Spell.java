package model.cards.spells;

import model.cards.Card;
import model.cards.Rarity;
/**
 *
 *  A subclass of Card representing a spell card. No objects of type Spell can be instantiated.
 *
 * **/
public abstract class Spell extends Card {

    public Spell(String name, int manaCost, Rarity rarity) {
        super(name, manaCost, rarity);
    }
}

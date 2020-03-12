package model.cards.minions;

import model.cards.Card;
import model.cards.Rarity;

/**
 *
 * A subclass of Card representing a minion card.
 *
 * **/
public class Minion extends Card {
    private int attack;
    private int maxHP;
    private int currentHP;
    private boolean taunt;
    private boolean divine;
    private boolean sleeping;
    private boolean attacked;

    public Minion(String name, int manaCost, Rarity rarity, int attack, int maxHP, boolean taunt, boolean divine, boolean charge) {
        super(name, manaCost, rarity);
        this.attack = attack;
        this.maxHP = maxHP;
        this.taunt = taunt;
        this.divine = divine;
        this.sleeping = true;
        this.currentHP = maxHP;
    }

    public Minion(String icehowl, int i, Rarity legendary, int currentHP, int maxHP) {
        super(icehowl,i,legendary);
        this.maxHP = maxHP;
        this.currentHP = maxHP;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        if(attack >0)
            this.attack = attack;
        else
            this.attack = 0;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public void setCurrentHP(int currentHP) {
        if(currentHP <= maxHP){
            this.currentHP = currentHP;
        }
        else {
            this.currentHP = 30;
        }

    }

    public boolean isTaunt() {
        return taunt;
    }

    public void setTaunt(boolean taunt) {
        this.taunt = taunt;
    }

    public boolean isDivine() {
        return divine;
    }

    public void setDivine(boolean divine) {
        this.divine = divine;
    }

    public boolean isSleeping() {
        return sleeping;
    }

    public void setSleeping(boolean sleeping) {
        this.sleeping = sleeping;
    }

    public boolean isAttacked() {
        return attacked;
    }

    public void setAttacked(boolean attacked) {
        this.attacked = attacked;
    }
}

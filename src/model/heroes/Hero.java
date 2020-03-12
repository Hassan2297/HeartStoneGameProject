package model.heroes;

import java.io.BufferedReader;
import java.io.FileReader;
import model.cards.Card;
import model.cards.minions.Minion;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;
import model.cards.Rarity;
import model.cards.minions.Icehowl;

/**
 *
 *   A class representing a hero. No objects of type Hero can be instantiated.
 *
 * **/
public abstract class Hero {
    private String name;
    private int currentHP;
    private boolean heroPowerUsed;
    private int totalManaCrystals;
    private int currentManaCrystals;
    protected ArrayList<Card> deck;
    private ArrayList<Minion> field;
    private ArrayList<Card> hand;
    private int fatigueDamage;

    public Hero(String name) {
        this.name = name;
        this.currentHP = 30;
    }

    public String getName() {
        return name;
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public void setCurrentHP(int currentHP) {
        if(currentHP <= 30){
            this.currentHP = currentHP;
        }
        else {
            this.currentHP = 30;
        }

    }

    public boolean isHeroPowerUsed() {
        return heroPowerUsed;
    }

    public void setHeroPowerUsed(boolean heroPowerUsed) {
        this.heroPowerUsed = heroPowerUsed;
    }

    public int getTotalManaCrystals() {
        return totalManaCrystals;
    }

    public void setTotalManaCrystals(int totalManaCrystals) {
        if(totalManaCrystals <= 10 && totalManaCrystals > 0){
            this.totalManaCrystals = totalManaCrystals;
        }else{
            this.totalManaCrystals = 10;
        }

    }

    public int getCurrentManaCrystals() {
        return currentManaCrystals;
    }

    public void setCurrentManaCrystals(int currentManaCrystals) {
        if(currentManaCrystals <= 10){
            this.currentManaCrystals = currentManaCrystals;
        }
        else
        {
            this.currentManaCrystals = 10;
        }

    }

    public ArrayList<Card> getDeck() throws IOException {
        if(deck == null){
            buildDeck();
        }
        return deck;
    }

    public ArrayList<Minion> getField() {
        return field;
    }

    public void setField(ArrayList<Minion> field) {
        this.field = field;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public static final ArrayList<Minion> getAllNeutralMinions(String filePath) throws IOException{
         List<String[]> minions = new ArrayList<>();
        List<String[]> result = new ArrayList<>();
        String line = "";
        Random r = new Random();
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
            while((line = br.readLine()) != null){
                minions.add(line.split(","));
            }
        }
        ArrayList<Minion> innerDeck = new ArrayList<>();
         for(String[] single : minions){
             Rarity singleRarity = Rarity.BASIC;
            switch(single[2].charAt(0)){
                case 'b':
                    singleRarity = Rarity.BASIC;
                    break;
                case 'c':
                    singleRarity = Rarity.COMMON;
                    break;
                case 'r':
                    singleRarity = Rarity.RARE;
                    break;
                case 'e':
                    singleRarity = Rarity.EPIC;
                    break;
                case 'l':
                    singleRarity = Rarity.LEGENDARY;
                    break;
            }
            if(single[0].compareTo("Icehowl") == 0){
                innerDeck.add(
                       new Icehowl() 
                );
            }
            else
                innerDeck.add(
                        new Minion(
                                single[0],
                                Integer.parseInt(single[1]),
                                singleRarity,
                                Integer.parseInt(single[3]),
                                Integer.parseInt(single[4]),
                                single[5].compareTo("TRUE")==0? true : false,
                                single[6].compareTo("TRUE")==0? true : false,
                                single[7].compareTo("TRUE")==0? true : false
                        )
                );
         }
         return innerDeck;
    }
    public static final ArrayList<Minion> getNeutralMinions(ArrayList<Minion> minions,int count){
        ArrayList<Minion> toReturn = new ArrayList<Minion>();
        Random r = new Random();
        Hashtable<String, Integer> records = new Hashtable<String, Integer>(); 

        while(toReturn.size()<count){
            int index = r.nextInt(minions.size());
            Minion chosenOne = minions.get(index);
            if(chosenOne.getRarity() == Rarity.LEGENDARY && !records.containsKey(chosenOne.getName())){
                records.put(chosenOne.getName(), 1);
                toReturn.add(chosenOne);    
                continue;
            }
            if((chosenOne.getRarity() == Rarity.BASIC || chosenOne.getRarity() == Rarity.RARE)){
                if(!records.containsKey(chosenOne.getName())){
                    records.put(chosenOne.getName(), 1);
                    toReturn.add(chosenOne);
                    continue;
                }
                else if(records.get(chosenOne.getName())<2){
                    records.replace(chosenOne.getName(), 2);
                    toReturn.add(chosenOne);
                    continue;
                }
            } 
            if(chosenOne.getRarity() == Rarity.EPIC || chosenOne.getRarity() == Rarity.COMMON){
                toReturn.add(chosenOne);            
                continue;
            }
        
        }
        return toReturn;
    }
    
     static ArrayList<Minion>  randomizeMinion( ArrayList<Minion> deck, int n) 
    { 
        // Creating a object for Random class 
        Random r = new Random(); 
           
        // Start from the last element and swap one by one. We don't 
        // need to run for the first element that's why i > 0 
        for (int i = n-1; i > 0; i--) { 
               
            // Pick a random index from 0 to i 
            int j = r.nextInt(i); 
               
            // Swap arr[i] with the element at random index 
            Minion temp = deck.get(i); 
            deck.set(i, deck.get(j)); 
            deck.set(j, temp); 
        } 
  
        return deck;
    } 
    public void buildDeck() throws IOException{
    }
}

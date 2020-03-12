package model.heroes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import model.cards.Card;
import model.cards.Rarity;
import model.cards.minions.Minion;
import model.cards.spells.LevelUp;
import model.cards.spells.SealOfChampions;

public class Paladin extends Hero {
    public Paladin() {
        super("Uther Lightbringer");
    }
    
    
     public void buildDeck() throws IOException{
        List<String[]> minions = new ArrayList<>();
        List<String[]> result = new ArrayList<>();
        int copies = 0;
        String csvFile = "src/neutral_minions_31951.csv";
        String line = "";
        Random r = new Random();
        try(BufferedReader br = new BufferedReader(new FileReader(csvFile))){
            while((line = br.readLine()) != null){
                minions.add(line.split(","));
            }
        }
        while(result.size()<15){
            int num = r.nextInt(14);
            if(!result.contains(minions.get(num))){
                result.add(minions.get(num));
            }
            else if(copies < 2){
                copies++;
                result.add(minions.get(num));
            }
        }
        ArrayList<Card> innerDeck = new ArrayList<>();
        
        
        innerDeck.add(new SealOfChampions());
        innerDeck.add(new SealOfChampions());
        innerDeck.add(new LevelUp());
        innerDeck.add(new LevelUp());
        innerDeck.add(new Minion(
                "Tirion Fordring", 4, Rarity.LEGENDARY, 6, 6, true, true, false));

        for(String[] single : result){
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
            //String name, int manaCost, Rarity rarity, int attack, 
            //int maxHP, boolean taunt, boolean divine, boolean charge
           
            innerDeck.add(
                    new Minion(
                            single[0],
                            Integer.parseInt(single[1]),
                            singleRarity,
                            Integer.parseInt(single[3]),
                            Integer.parseInt(single[4]),
                            single[5] == "TRUE"? true : false,
                            single[6] == "TRUE"? true : false,
                            single[7] == "TRUE"? true : false
                    )
            );
        }
      deck = randomize(innerDeck,20);

    }
     
     static ArrayList<Card>  randomize( ArrayList<Card> deck, int n) 
    { 
        // Creating a object for Random class 
        Random r = new Random(); 
           
        // Start from the last element and swap one by one. We don't 
        // need to run for the first element that's why i > 0 
        for (int i = n-1; i > 0; i--) { 
               
            // Pick a random index from 0 to i 
            int j = r.nextInt(i); 
               
            // Swap arr[i] with the element at random index 
            Card temp = deck.get(i); 
            deck.set(i, deck.get(j)); 
            deck.set(j, temp); 
        } 
  
        return deck;
    } 
     
}
package com.gildedrose;

import java.util.function.BiFunction;

public class TexttestFixtureForParametrizedItems {
	static public BiFunction<Integer, Integer, Integer> calculationForConjured = (s,q) -> (s > 0)? q -2 : q - 4;
	static public BiFunction<Integer, Integer, Integer> calculationForAgedBrie = (s,q) -> (s > 0)? q +1 : q + 2;
	static public BiFunction<Integer, Integer, Integer> calculationForBackstagePasses = (s,q) -> (s <= 0)? 0 : ((s <= 5)? q + 3 : ((s <= 10)? q + 2 : q + 1));
	static public BiFunction<Integer, Integer, Integer> calculationForSulfuras = (s,q) -> 80;

	static public ParametrizedItem createItemForConjured(int sellIn, int quality){
		return new ParametrizedItem(GildedRose.CONJURED,sellIn, quality, calculationForConjured);
	}
	
	static public ParametrizedItem createItemForAgedBrie(int sellIn, int quality){
		return new ParametrizedItem(GildedRose.AGED_BRIE,sellIn, quality, calculationForAgedBrie);
	}
	
	static public ParametrizedItem createItemForBackstagePasses(int sellIn, int quality){
		return new ParametrizedItem(GildedRose.BACKSTAGE_PASSES,sellIn, quality, calculationForBackstagePasses);
	}
	
	static public ParametrizedItem createItemForSulfuras(int sellIn, int quality){
		return new ParametrizedItem(GildedRose.SULFURAS,sellIn, quality, calculationForSulfuras, true);
	}
	
	static public ParametrizedItem createNormalItem(String name, int sellIn, int quality){
		return new ParametrizedItem(name,sellIn, quality);
	} 
	
	
	static ParametrizedItem[] getTestItems(){
		ParametrizedItem[] items = new ParametrizedItem[] {
				createNormalItem("+5 Dexterity Vest", 10, 20),
				createItemForAgedBrie(2, 0),
				createNormalItem("Elixir of the Mongoose", 5, 7),
				createItemForSulfuras(0, 80),
				createItemForSulfuras(-1, 80),
				createItemForBackstagePasses(15, 20),
				createItemForBackstagePasses(10, 49),
				createItemForBackstagePasses(5, 49),
				createItemForConjured(3, 6)
        };
		return items;
	}
	
	static String produceTextFixtureForDays(ParametrizedItem[] items, int nbDays){
		GildedRoseForParametrizedItems app = new GildedRoseForParametrizedItems(items);
        StringBuffer sbStringToReturn = new StringBuffer();
        for (int i = 0; i < nbDays; i++) {
        	sbStringToReturn.append("-------- day " + i + " --------\n");
        	sbStringToReturn.append("name, sellIn, quality\n");
            for (Item item : items) {
            	sbStringToReturn.append(item).append("\n");
            }
            sbStringToReturn.append("\n");
            app.updateQuality();
        }
        return sbStringToReturn.toString();
    }
		
	
    public static void main(String[] args) {
        System.out.println("OMGHAI!");
        ParametrizedItem[] items = getTestItems();
        int days = 2;
        if (args.length > 0) {
            days = Integer.parseInt(args[0]) + 1;
        }       
        System.out.print(produceTextFixtureForDays(items, days));
     }

}

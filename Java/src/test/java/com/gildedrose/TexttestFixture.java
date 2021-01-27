package com.gildedrose;

public class TexttestFixture {
	
	static Item[] getTestItems(){
        Item[] items = new Item[] {
                new Item("+5 Dexterity Vest", 10, 20), //
                new Item(GildedRose.AGED_BRIE, 2, 0), //
                new Item("Elixir of the Mongoose", 5, 7), //
                new Item(GildedRose.SULFURAS, 0, 80), //
                new Item(GildedRose.SULFURAS, -1, 80),
                new Item(GildedRose.BACKSTAGE_PASSES, 15, 20),
                new Item(GildedRose.BACKSTAGE_PASSES, 10, 49),
                new Item(GildedRose.BACKSTAGE_PASSES, 5, 49),
                new Item(GildedRose.CONJURED, 3, 6) 
        };
		return items;
	}
	
	static String produceTextFixtureForDays(Item[] items, int nbDays){
        GildedRose app = new GildedRose(items);
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
        Item[] items = getTestItems();
        int days = 2;
        if (args.length > 0) {
            days = Integer.parseInt(args[0]) + 1;
        }       
        System.out.print(produceTextFixtureForDays(items, days));
     }

}

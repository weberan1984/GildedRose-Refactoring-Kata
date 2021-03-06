package com.gildedrose;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * 
 * @author Weber Andr�
 *  Unit testing of the class GildedRose.java
 * Business rules tested here (listed in the order of apparition in the specifications we have received):
 * <ol>
 * 	<li>All items have a SellIn value which denotes the number of days we have to sell the item.  All items have a Quality value which denotes how valuable the item is.  At the end of each day our system lowers both values for every item</li>
 * 	<li>Once the sell by date has passed, Quality degrades twice as fast</li>
 * 	<li>The Quality of an item is never negative</li>
 * 	<li>"Aged Brie" actually increases in Quality the older it gets</li>
 * 	<li>The Quality of an item is never more than 50</li>
 * 	<li>"Sulfuras", being a legendary item, never has to be sold or decreases in Quality</li>
 * 	<li>"Backstage passes", like aged brie, increases in Quality as its SellIn value approaches; Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but
Quality drops to 0 after the concert</li>
 *  <li>"Conjured" items degrade in Quality twice as fast as normal items</li>
 * </ol>  
 *
 */
public class GildedRoseTestForParametrizedItems {
	
	public GildedRoseTestForParametrizedItems(){}

    @Test
    /**
     * Test for business rule 1:
     * All items have a SellIn value which denotes the number of days we have to sell the item.  All items have a Quality value which denotes how valuable the item is.  At the end of each day our system lowers both values for every item 
     */
    public void testForBusinessRule1() {
    	int businessRuleNumber = 1;
    	int initialSellIn = 10;
    	int initialQuality = 25;
    	ParametrizedItem item = TexttestFixtureForParametrizedItems.createNormalItem("foo", initialSellIn, initialQuality);
        ParametrizedItem[] items = new ParametrizedItem[] { item };
        GildedRoseForParametrizedItems app = new GildedRoseForParametrizedItems(items);
        app.updateQuality();
        item = app.items[0]; // modified item
        assertEquals(initialSellIn - 1, item.sellIn);
        assertEquals(initialQuality - 1, item.quality);
        String msg = String.format(
        		"Test BusinessRule %d\n - Valeurs initiales \n\t sellIn : %d, quality : %d \n - Valeurs finales \n\t sellIn : %d, quality : %d \n",
        		businessRuleNumber,
        		initialSellIn, initialQuality,
        		item.sellIn, item.quality
        );
        System.out.println(msg);
    }
    
    @Test
    /**
     * Test for business rule 2 :
     * Once the sell by date has passed, Quality degrades twice as fast
     */
    public void testForBusinessRule2() {
    	int businessRuleNumber = 2;
    	int initialSellIn = 0;
    	int initialQuality = 25;
    	ParametrizedItem item = new ParametrizedItem("foo", initialSellIn, initialQuality);
        ParametrizedItem[] items = new ParametrizedItem[] { item };
        GildedRoseForParametrizedItems app = new GildedRoseForParametrizedItems(items);
        app.updateQuality();
        item = app.items[0]; // modified item
        assertEquals(initialSellIn - 1, item.sellIn);
        assertEquals(initialQuality - 2, item.quality);
        String msg = String.format(
        		"Test BusinessRule %d\n - Valeurs initiales \n\t sellIn : %d, quality : %d \n - Valeurs finales \n\t sellIn : %d, quality : %d \n",
        		businessRuleNumber,
        		initialSellIn, initialQuality,
        		item.sellIn, item.quality
        );
        System.out.println(msg);
    }
    
    
    @Test
    /**
     * Test for business rule 3 :
     * The Quality of an item is never negative
     */
    public void testForBusinessRule3() {
    	int businessRuleNumber = 3;
    	int initialSellIn;
    	int initialQuality;
    	ParametrizedItem item;
        ParametrizedItem[] items;
        GildedRoseForParametrizedItems app;
        String msg;
        //
    	initialSellIn = 10;
    	initialQuality = 0;
    	item = new ParametrizedItem("foo", initialSellIn, initialQuality);
        items = new ParametrizedItem[] { item };
        app = new GildedRoseForParametrizedItems(items);
        app.updateQuality();
        item = app.items[0]; // modified item
        assertEquals(initialSellIn - 1, item.sellIn);
        assertEquals(0, item.quality);
        msg = String.format(
        		"Test BusinessRule %d\n - Valeurs initiales \n\t sellIn : %d, quality : %d \n - Valeurs finales \n\t sellIn : %d, quality : %d \n",
        		businessRuleNumber,
        		initialSellIn, initialQuality,
        		item.sellIn, item.quality
        );
        System.out.println(msg);
        //
    	initialSellIn = 0;
    	initialQuality = 0;
    	item = new ParametrizedItem("foo", initialSellIn, initialQuality);
        items = new ParametrizedItem[] { item };
        app = new GildedRoseForParametrizedItems(items);
        app.updateQuality();
        item = app.items[0]; // modified item
        assertEquals(initialSellIn - 1, item.sellIn);
        assertEquals(0, item.quality);
        msg = String.format(
        		"Test BusinessRule %d\n - Valeurs initiales \n\t sellIn : %d, quality : %d \n - Valeurs finales \n\t sellIn : %d, quality : %d \n",
        		businessRuleNumber,
        		initialSellIn, initialQuality,
        		item.sellIn, item.quality
        );
        System.out.println(msg);
        
    }
    
    @Test
    /**
     * Test for business rule 4 :
     * "Aged Brie" actually increases in Quality the older it gets
     */
    public void testForBusinessRule4() {
    	int businessRuleNumber = 4;
    	int initialSellIn;
    	int initialQuality;
    	ParametrizedItem item;
        ParametrizedItem[] items;
        GildedRoseForParametrizedItems app;
        String msg;
        //
    	initialSellIn = 10;
    	initialQuality = 5;
    	item = TexttestFixtureForParametrizedItems.createItemForAgedBrie(initialSellIn, initialQuality);
        items = new ParametrizedItem[] { item };
        app = new GildedRoseForParametrizedItems(items);
        app.updateQuality();
        item = app.items[0]; // modified item
        assertEquals(initialSellIn - 1, item.sellIn);
        assertEquals(initialQuality +1 , item.quality);
        msg = String.format(
        		"Test BusinessRule %d\n - Valeurs initiales \n\t sellIn : %d, quality : %d \n - Valeurs finales \n\t sellIn : %d, quality : %d \n",
        		businessRuleNumber,
        		initialSellIn, initialQuality,
        		item.sellIn, item.quality
        );
        System.out.println(msg);
        //
    	initialSellIn = 0;
    	initialQuality = 5;
    	item = TexttestFixtureForParametrizedItems.createItemForAgedBrie(initialSellIn, initialQuality);
        items = new ParametrizedItem[] { item };
        app = new GildedRoseForParametrizedItems(items);
        app.updateQuality();
        item = app.items[0]; // modified item
        assertEquals(initialSellIn - 1, item.sellIn);
        assertEquals(initialQuality +2, item.quality);
        msg = String.format(
        		"Test BusinessRule %d\n - Valeurs initiales \n\t sellIn : %d, quality : %d \n - Valeurs finales \n\t sellIn : %d, quality : %d \n",
        		businessRuleNumber,
        		initialSellIn, initialQuality,
        		item.sellIn, item.quality
        );
        System.out.println(msg); 
        //
    	initialSellIn = 2;
    	initialQuality = 0;
    	item = TexttestFixtureForParametrizedItems.createItemForAgedBrie(initialSellIn, initialQuality);
        items = new ParametrizedItem[] { item };
        app = new GildedRoseForParametrizedItems(items);
        app.updateQuality();
        item = app.items[0]; // modified item
        assertEquals(initialSellIn - 1, item.sellIn);
        assertEquals(initialQuality +1, item.quality);
        msg = String.format(
        		"Test BusinessRule %d\n - Valeurs initiales \n\t sellIn : %d, quality : %d \n - Valeurs finales \n\t sellIn : %d, quality : %d \n",
        		businessRuleNumber,
        		initialSellIn, initialQuality,
        		item.sellIn, item.quality
        );
        System.out.println(msg);    
        
    }
    
    @Test
    /**
     * Test for business rule 5 :
     * The Quality of an item is never more than 50
     */
    public void testForBusinessRule5() {
    	int businessRuleNumber = 5;
    	int initialSellIn;
    	int initialQuality;
    	ParametrizedItem item;
        ParametrizedItem[] items;
        GildedRoseForParametrizedItems app;
        String msg;
        //
    	initialSellIn = 10;
    	initialQuality = 49;
    	item = TexttestFixtureForParametrizedItems.createItemForAgedBrie(initialSellIn, initialQuality);
        items = new ParametrizedItem[] { item };
        app = new GildedRoseForParametrizedItems(items);
        app.updateQuality();
        item = app.items[0]; // modified item
        assertEquals(initialSellIn - 1, item.sellIn);
        assertEquals(initialQuality +1 , item.quality);
        msg = String.format(
        		"Test BusinessRule %d\n - Valeurs initiales \n\t sellIn : %d, quality : %d \n - Valeurs finales \n\t sellIn : %d, quality : %d \n",
        		businessRuleNumber,
        		initialSellIn, initialQuality,
        		item.sellIn, item.quality
        );
        System.out.println(msg);
        //
     	initialSellIn = 10;
     	initialQuality = 50;
     	item = TexttestFixtureForParametrizedItems.createItemForAgedBrie(initialSellIn, initialQuality);
         items = new ParametrizedItem[] { item };
         app = new GildedRoseForParametrizedItems(items);
         app.updateQuality();
         item = app.items[0]; // modified item
         assertEquals(initialSellIn - 1, item.sellIn);
         assertEquals(initialQuality , item.quality);
         msg = String.format(
         		"Test BusinessRule %d\n - Valeurs initiales \n\t sellIn : %d, quality : %d \n - Valeurs finales \n\t sellIn : %d, quality : %d \n",
         		businessRuleNumber,
         		initialSellIn, initialQuality,
         		item.sellIn, item.quality
         );
         System.out.println(msg);
        //
    	initialSellIn = 0;
    	initialQuality = 50;
    	item = TexttestFixtureForParametrizedItems.createItemForAgedBrie(initialSellIn, initialQuality);
        items = new ParametrizedItem[] { item };
        app = new GildedRoseForParametrizedItems(items);
        app.updateQuality();
        item = app.items[0]; // modified item
        assertEquals(initialSellIn - 1, item.sellIn);
        assertEquals(initialQuality, item.quality);
        msg = String.format(
        		"Test BusinessRule %d\n - Valeurs initiales \n\t sellIn : %d, quality : %d \n - Valeurs finales \n\t sellIn : %d, quality : %d \n",
        		businessRuleNumber,
        		initialSellIn, initialQuality,
        		item.sellIn, item.quality
        );
        System.out.println(msg);
        //
    	initialSellIn = 0;
    	initialQuality = 40;
    	item = TexttestFixtureForParametrizedItems.createItemForAgedBrie(initialSellIn, initialQuality);
    	items = new ParametrizedItem[] { item };
        app = new GildedRoseForParametrizedItems(items);
        app.updateQuality();
        item = app.items[0]; // modified item
        assertEquals(initialSellIn - 1, item.sellIn);
        assertEquals(initialQuality + 2, item.quality);
        msg = String.format(
        		"Test BusinessRule %d\n - Valeurs initiales \n\t sellIn : %d, quality : %d \n - Valeurs finales \n\t sellIn : %d, quality : %d \n",
        		businessRuleNumber,
        		initialSellIn, initialQuality,
        		item.sellIn, item.quality
        );
        System.out.println(msg);
        
    }
    
    
    @Test
    /**
     * Test for business rule 6 :
     * "Sulfuras", being a legendary item, never has to be sold or decreases in Quality
     */
    public void testForBusinessRule6() {
    	int businessRuleNumber = 6;
    	int initialSellIn;
    	int initialQuality;
    	ParametrizedItem item;
        ParametrizedItem[] items;
        GildedRoseForParametrizedItems app;
        String msg;
        //
    	initialSellIn = 10;
    	initialQuality = 80;
    	item = TexttestFixtureForParametrizedItems.createItemForSulfuras(initialSellIn, initialQuality);    	
        items = new ParametrizedItem[] { item };
        app = new GildedRoseForParametrizedItems(items);
        app.updateQuality();
        item = app.items[0]; // modified item
        assertEquals(initialSellIn, item.sellIn);
        assertEquals(initialQuality , item.quality);
        msg = String.format(
        		"Test BusinessRule %d\n - Valeurs initiales \n\t sellIn : %d, quality : %d \n - Valeurs finales \n\t sellIn : %d, quality : %d \n",
        		businessRuleNumber,
        		initialSellIn, initialQuality,
        		item.sellIn, item.quality
        );
        System.out.println(msg);
        //
     	initialSellIn = 0;
     	initialQuality = 80;
    	item = TexttestFixtureForParametrizedItems.createItemForSulfuras(initialSellIn, initialQuality);    	
        items = new ParametrizedItem[] { item };
        app = new GildedRoseForParametrizedItems(items);
        app.updateQuality();
        item = app.items[0]; // modified item
        assertEquals(initialSellIn, item.sellIn);
        assertEquals(initialQuality , item.quality);
        msg = String.format(
         		"Test BusinessRule %d\n - Valeurs initiales \n\t sellIn : %d, quality : %d \n - Valeurs finales \n\t sellIn : %d, quality : %d \n",
         		businessRuleNumber,
         		initialSellIn, initialQuality,
         		item.sellIn, item.quality
        );
        System.out.println(msg);
     }
    
    @Test
    /**
     * Test for business rule 7 :
     * "Backstage passes", like aged brie, increases in Quality as its SellIn value approaches; 
     * Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less 
     * but Quality drops to 0 after the concert
     */
    public void testForBusinessRule7() {
    	int businessRuleNumber = 7;
    	int initialSellIn;
    	int initialQuality;
    	ParametrizedItem item;
        ParametrizedItem[] items;
        GildedRoseForParametrizedItems app;
        String msg;
        //
    	initialSellIn = 20;
    	initialQuality = 5;
    	item = TexttestFixtureForParametrizedItems.createItemForBackstagePasses(initialSellIn, initialQuality);
        items = new ParametrizedItem[] { item };
        app = new GildedRoseForParametrizedItems(items);
        app.updateQuality();
        item = app.items[0]; // modified item
        assertEquals(initialSellIn - 1 , item.sellIn);
        assertEquals(initialQuality + 1, item.quality);
        msg = String.format(
        		"Test BusinessRule %d\n - Valeurs initiales \n\t sellIn : %d, quality : %d \n - Valeurs finales \n\t sellIn : %d, quality : %d \n",
        		businessRuleNumber,
        		initialSellIn, initialQuality,
        		item.sellIn, item.quality
        );
        System.out.println(msg);
        //
     	initialSellIn = 10;
     	initialQuality = 5;
    	item = TexttestFixtureForParametrizedItems.createItemForBackstagePasses(initialSellIn, initialQuality);
		items = new ParametrizedItem[] { item };
		app = new GildedRoseForParametrizedItems(items);
		app.updateQuality();
		item = app.items[0]; // modified item
		assertEquals(initialSellIn - 1, item.sellIn);
		assertEquals(initialQuality + 2, item.quality);
		msg = String.format(
		 		"Test BusinessRule %d\n - Valeurs initiales \n\t sellIn : %d, quality : %d \n - Valeurs finales \n\t sellIn : %d, quality : %d \n",
		 		businessRuleNumber,
		 		initialSellIn, initialQuality,
		 		item.sellIn, item.quality
		 );
		 System.out.println(msg);
		 //
      	initialSellIn = 9;
      	initialQuality = 5;
    	item = TexttestFixtureForParametrizedItems.createItemForBackstagePasses(initialSellIn, initialQuality);
        items = new ParametrizedItem[] { item };
        app = new GildedRoseForParametrizedItems(items);
        app.updateQuality();
        item = app.items[0]; // modified item
        assertEquals(initialSellIn - 1, item.sellIn);
        assertEquals(initialQuality + 2, item.quality);
        msg = String.format(
          		"Test BusinessRule %d\n - Valeurs initiales \n\t sellIn : %d, quality : %d \n - Valeurs finales \n\t sellIn : %d, quality : %d \n",
          		businessRuleNumber,
          		initialSellIn, initialQuality,
          		item.sellIn, item.quality
          );
        System.out.println(msg);
        //
       	initialSellIn = 5;
       	initialQuality = 5;
    	item = TexttestFixtureForParametrizedItems.createItemForBackstagePasses(initialSellIn, initialQuality);
        items = new ParametrizedItem[] { item };
        app = new GildedRoseForParametrizedItems(items);
        app.updateQuality();
        item = app.items[0]; // modified item
        assertEquals(initialSellIn - 1, item.sellIn);
        assertEquals(initialQuality + 3, item.quality);
        msg = String.format(
           		"Test BusinessRule %d\n - Valeurs initiales \n\t sellIn : %d, quality : %d \n - Valeurs finales \n\t sellIn : %d, quality : %d \n",
           		businessRuleNumber,
           		initialSellIn, initialQuality,
           		item.sellIn, item.quality
        );
        System.out.println(msg);
        //
        initialSellIn = 4;
        initialQuality = 5;
    	item = TexttestFixtureForParametrizedItems.createItemForBackstagePasses(initialSellIn, initialQuality);
        items = new ParametrizedItem[] { item };
        app = new GildedRoseForParametrizedItems(items);
        app.updateQuality();
        item = app.items[0]; // modified item
        assertEquals(initialSellIn - 1, item.sellIn);
        assertEquals(initialQuality + 3, item.quality);
        msg = String.format(
        		"Test BusinessRule %d\n - Valeurs initiales \n\t sellIn : %d, quality : %d \n - Valeurs finales \n\t sellIn : %d, quality : %d \n",
        		businessRuleNumber,
        		initialSellIn, initialQuality,
        		item.sellIn, item.quality
        );
        System.out.println(msg);
        //
        initialSellIn = 1;
        initialQuality = 5;
    	item = TexttestFixtureForParametrizedItems.createItemForBackstagePasses(initialSellIn, initialQuality);
        items = new ParametrizedItem[] { item };
        app = new GildedRoseForParametrizedItems(items);
        app.updateQuality();
        item = app.items[0]; // modified item
        assertEquals(initialSellIn - 1, item.sellIn);
        assertEquals(initialQuality + 3, item.quality);
        msg = String.format(
        		"Test BusinessRule %d\n - Valeurs initiales \n\t sellIn : %d, quality : %d \n - Valeurs finales \n\t sellIn : %d, quality : %d \n",
        		businessRuleNumber,
        		initialSellIn, initialQuality,
        		item.sellIn, item.quality
        );
        //
        initialSellIn = 0;
        initialQuality = 5;
    	item = TexttestFixtureForParametrizedItems.createItemForBackstagePasses(initialSellIn, initialQuality);
        items = new ParametrizedItem[] { item };
        app = new GildedRoseForParametrizedItems(items);
        app.updateQuality();
        item = app.items[0]; // modified item
        assertEquals(initialSellIn - 1, item.sellIn);
        assertEquals(0, item.quality);
        msg = String.format(
        		"Test BusinessRule %d\n - Valeurs initiales \n\t sellIn : %d, quality : %d \n - Valeurs finales \n\t sellIn : %d, quality : %d \n",
        		businessRuleNumber,
        		initialSellIn, initialQuality,
        		item.sellIn, item.quality
        );
        System.out.println(msg);
        //
        initialSellIn = -1;
        initialQuality = 0;
    	item = TexttestFixtureForParametrizedItems.createItemForBackstagePasses(initialSellIn, initialQuality);
        items = new ParametrizedItem[] { item };
        app = new GildedRoseForParametrizedItems(items);
        app.updateQuality();
        item = app.items[0]; // modified item
        assertEquals(initialSellIn - 1, item.sellIn);
        assertEquals(0, item.quality);
        msg = String.format(
        		"Test BusinessRule %d\n - Valeurs initiales \n\t sellIn : %d, quality : %d \n - Valeurs finales \n\t sellIn : %d, quality : %d \n",
        		businessRuleNumber,
        		initialSellIn, initialQuality,
        		item.sellIn, item.quality
        );
        System.out.println(msg);
    }
    
    @Test
    /**
     * Test for business rule 8:
     * "Conjured" items degrade in Quality twice as fast as normal items
     */
    public void testForBusinessRule8() {
    	int businessRuleNumber = 1;
    	int initialSellIn = 10;
    	int initialQuality = 25;
    	ParametrizedItem item = TexttestFixtureForParametrizedItems.createItemForConjured(initialSellIn, initialQuality);
        ParametrizedItem[] items = new ParametrizedItem[] { item };
        GildedRoseForParametrizedItems app = new GildedRoseForParametrizedItems(items);
        app.updateQuality();
        item = app.items[0]; // modified item
        assertEquals(initialSellIn - 1, item.sellIn);
        assertEquals(initialQuality - 2, item.quality);
        String msg = String.format(
        		"Test BusinessRule %d\n - Valeurs initiales \n\t sellIn : %d, quality : %d \n - Valeurs finales \n\t sellIn : %d, quality : %d \n",
        		businessRuleNumber,
        		initialSellIn, initialQuality,
        		item.sellIn, item.quality
        );
        System.out.println(msg);
    }
    
    
    @Test
    /**
     * Test on no regression of TexttestFixture
     */
    public void testForTexttestFixture() {    
     	int nbDays = 2;
    	ParametrizedItem[] items;
    	items = TexttestFixtureForParametrizedItems.getTestItems();
    	String texttestOldSolution = TexttestFixture.produceTextFixtureForDays(items, nbDays);
    	items = TexttestFixtureForParametrizedItems.getTestItems();
    	String texttestNewSolution = TexttestFixtureForParametrizedItems.produceTextFixtureForDays(items, nbDays);
    	System.out.println("testForTexttestFixture");
    	System.out.println("text obtained with old solution :");
    	System.out.println(texttestOldSolution);
    	System.out.println("text obtained with new solution :");
    	System.out.println(texttestNewSolution);
    	System.out.println();
    	assertEquals(texttestOldSolution, texttestNewSolution);
    }
    

}

package com.gildedrose;


class GildedRose {
	public static int MAX_QUALITY = 50;
	// Names of special items (we need these names to apply specific rules)
	public static final String AGED_BRIE = "Aged Brie";
	public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
	public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
	public static final String CONJURED = "Conjured Mana Cake";
	//
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }
    
    private static Integer getValueOfQualityForNextDay(Item item){
    	if(item.name == null) throw new IllegalArgumentException("name can't be null");
    	if(item.quality < 0) throw new IllegalArgumentException("quality must have a value greater than 0");
    	if(item.quality > MAX_QUALITY && !item.name.equals(SULFURAS)) throw new IllegalArgumentException("quality must have a value less than " + (MAX_QUALITY +1));
    	int newItemQuality;
    	switch(item.name){
    		case AGED_BRIE:
    			newItemQuality = (item.sellIn > 0)? item.quality + 1 : item.quality + 2;
    			break;
    	   	case SULFURAS:
    			// "Sulfuras", being a legendary item, never decreases in quality
    	   		return item.quality;  // return here to do not apply the other rules
    	   	case BACKSTAGE_PASSES:
    	   		// For "Backstage passes", Quality drops to 0 after the concert
    	   		if(item.sellIn <= 0) return 0; 
    	   		// "Backstage passes", like aged brie, increases in Quality as its SellIn value approaches
    	   		int toAddToQuality;
    	   		toAddToQuality = 1;
    	   		if(item.sellIn <= 10) toAddToQuality++; // Quality increases by 2 when there are 10 days or less
    	   		if(item.sellIn <= 5) toAddToQuality++; // Quality increases by 3 when there are 5 days or less
    	   		newItemQuality = item.quality + toAddToQuality;
    	   		break;
    	   	case CONJURED:
    	   		// Conjured" items degrade in Quality twice as fast as normal items
    	   		newItemQuality = (item.sellIn > 0)? item.quality - 2 : item.quality - 4;
    	   		break;    	   		
    	   	default:
    			//  At the end of each day our system lower the value for the quality
    			//  but when the sell by date has passed, quality degrades twice as fast
    	   		newItemQuality = (item.sellIn > 0)? item.quality - 1 : item.quality - 2;
    	   		break;
    	}
    	if(newItemQuality < 0) newItemQuality = 0;  // we can't decrease the quality under 0 
   		if(newItemQuality > MAX_QUALITY) newItemQuality = MAX_QUALITY; // The Quality of an item is never more than 50 (not applicable for SULFURAS but for SULFURAS we returned before)
    	return newItemQuality;
    }
    
    private static int getValueOfSellInForNextDay(Item item){
    	if(item.name == null) throw new IllegalArgumentException();
    	switch(item.name){
    	case SULFURAS :
    			// "Sulfuras", being a legendary item, never has to be sold
    			return item.sellIn;
    		default:
    			//  At the end of each day our system lower the value for the number of days before the sell-by date
    			return item.sellIn - 1;
    	}
    }
    
    
    

    /**
     * Update quality level (integer value between 80 and 0) and the "sell in" (days) value.
     * This method must be called each day (for example at midnight).
     * It modifies the attributes "quality" and "sellIn" of the array of items referred in this instance (see attribute "items").
     * Business rules implemented here (listed in the order of apparition in the specifications we have received):
     * <ol>
     *  <li>All items have a SellIn value which denotes the number of days we have to sell the item.  All items have a Quality value which denotes how valuable the item is.  At the end of each day our system lowers both values for every item</li>
     * 	<li>Once the sell by date has passed, Quality degrades twice as fast</li>
     * 	<li>The Quality of an item is never negative</li>
     * 	<li>"Aged Brie" actually increases in Quality the older it gets</li>
     * 	<li>The Quality of an item is never more than 50</li>
     * 	<li>"Sulfuras", being a legendary item, never has to be sold or decreases in Quality</li>
     * 	<li>"Backstage passes", like aged brie, increases in Quality as its SellIn value approaches; Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but
	Quality drops to 0 after the concert</li>
     *  <li>"Conjured" items degrade in Quality twice as fast as normal items</li>
     * </ol>  
     */
    public void updateQuality() {
    	for(Item item : items){
    		item.quality = getValueOfQualityForNextDay(item);
    		item.sellIn = getValueOfSellInForNextDay(item);
    	}
    }
}
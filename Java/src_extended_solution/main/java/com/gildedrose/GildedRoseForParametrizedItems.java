package com.gildedrose;


class GildedRoseForParametrizedItems {
	public static int MAX_QUALITY = 50;
	ParametrizedItem[] items;

    public GildedRoseForParametrizedItems(ParametrizedItem[] items) {
        this.items = items;
    }
    
    private static Integer getValueOfQualityForNextDay(ParametrizedItem item){
    	if(item.quality < 0) throw new IllegalArgumentException("quality must have a value greater than 0");
    	if(item.quality > MAX_QUALITY && !item.neverGetOlder) throw new IllegalArgumentException("quality must have a value less than " + (MAX_QUALITY +1));
    	int newItemQuality = item.calculateQualityForNextDay.apply(item.sellIn, item.quality);
    	if(newItemQuality < 0) newItemQuality = 0;  // we can't decrease the quality under 0 
   		if(newItemQuality > MAX_QUALITY && !item.neverGetOlder) newItemQuality = MAX_QUALITY; // The Quality of an item is never more than 50 (not applicable for SULFURAS but for SULFURAS we returned before)
    	return newItemQuality;
    }
    
    private static int getValueOfSellInForNextDay(ParametrizedItem item){
    	if(item.neverGetOlder) return item.sellIn; // legendary item never has to be sold
		//  At the end of each day our system lower the value for the number of days before the sell-by date
		return item.sellIn - 1;
    }
    
    
    

    /**
     * Update quality level (integer value between 80 and 0) and the "sell in" (days) value.
     * This method must be called each day (for example at midnight).
     * It modifies the attributes "quality" and "sellIn" of the array of items referred in this instance (see attribute "items").
     * Business rules implemented here:
     * <ol>
     *  <li>All items have a SellIn value which denotes the number of days we have to sell the item.  All items have a Quality value which denotes how valuable the item is.  At the end of each day our system recalculate both values for every item</li>
     * 	<li>The Quality of an item is never negative</li>
      * <li>The Quality of an item is never more than 50 except when the item never get older (when the attribute as the value true)</li>
     * </ol>
     * Other business rules are implemented via the usage of the attribute calculateQualityForNextDay of each item  
     */
    public void updateQuality() {
	    	for(ParametrizedItem item : items){
	    		item.quality = getValueOfQualityForNextDay(item);
	    		item.sellIn = getValueOfSellInForNextDay(item);
	    	}
	    	return;
    }
}
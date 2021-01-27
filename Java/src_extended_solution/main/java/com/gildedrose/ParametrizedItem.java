package com.gildedrose;

import java.util.function.BiFunction;

public class ParametrizedItem extends Item{

	boolean neverGetOlder = false;
	BiFunction<Integer, Integer, Integer> calculateQualityForNextDay = null;
	
    public ParametrizedItem(String name, int sellIn, int quality, BiFunction<Integer, Integer, Integer> calculateQualityForNextDay, boolean neverGetOlder) {
    	super(name, sellIn, quality);
        this.neverGetOlder = neverGetOlder;
        this.calculateQualityForNextDay = calculateQualityForNextDay;
        
    }
    
    public ParametrizedItem(String name, int sellIn, int quality, BiFunction<Integer, Integer, Integer> calculateQualityForNextDay) {
    	this(name, sellIn, quality, calculateQualityForNextDay, false);
        
    }
    
    public ParametrizedItem(String name, int sellIn, int quality) {
    	this(name, sellIn, quality, (s, q) -> {return (s > 0) ? q -1 : q -2; }, false);
    }

}

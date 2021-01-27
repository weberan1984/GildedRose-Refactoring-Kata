package com.gildedrose;

import org.junit.*;
import static org.junit.Assert.*;


public class GildedRoseTest {
	
	public GildedRoseTest(){}

    @Test
    public void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("fixme", app.items[0].name);
    }

}

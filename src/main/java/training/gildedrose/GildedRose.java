package training.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {

            //Ensures sulfuras quality starts with 80
            updateSulfurasQualityTo80(item);
            //Updates sulfuras' sell in to start at 0 as it has no sell in time
            updateSulfurasSellInTo0(item);
            //for all items other than sulfuras decrease the sell in value
            decreaseSellInIfItemIsNotSulfuras(item);

            if (item.name.equals("Aged Brie")) {
                increaseQualityIfSmallerThan50(item);

                if (item.sellIn < 0) {
                    increaseQualityIfSmallerThan50(item);
                }
            }
            else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                increaseQualityIfSmallerThan50(item);
                if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    //if item is back stage then add 1 more to quality if below 10 days and add another 1 more if below 5
                    increaseQualityBy1MoreWhenSellInIsBelow10Days(item);
                    increaseQualityBy1MoreWhenSellInIsBelow5Days(item);
                }
                if (item.sellIn < 0) {
                    item.quality = 0;
                }
            }
            else if (item.name.equals("Conjured")) {
                decreaseQualityBy2IfPositiveValue(item);
                if (item.sellIn < 0) {
                    decreaseQualityBy2IfPositiveValue(item);
                }
            } else {
                decreaseQualityIfPositiveValue(item);
                if (item.sellIn < 0) {
                    decreaseQualityIfPositiveValue(item);
                }
            }
        }
    }




//            if (!item.name.equals("Aged Brie") && !item.name.equals("Backstage passes to a TAFKAL80ETC concert") && !item.name.equals("Conjured")) {
//                //for all items that are nto aged briw, backstage pass or conjured decrease the quality
//                decreaseQualityIfPositiveValue(item);
//            }
//            if(item.name.equals("Conjured")) {
//                //if item is specifically conjured then also decrease quality by 2
//                decreaseQualityBy2IfPositiveValue(item);
//            //otherwise continue to else
//            } else {
//                //if quality is smaller than 50 allows quality to never be above 50
//                if (item.quality < 50 ) {
//                    // then if item is aged brie or back stage pass or conjured increase the quality by 1
//                    increaseQualityByOne(item);
//                    if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
//                        //if item is back stage then add 1 more to quality if below 10 days and add another 1 more if below 5
//                        increaseQualityBy1MoreWhenSellInIsBelow10Days(item);
//                        increaseQualityBy1MoreWhenSellInIsBelow5Days(item);
//                    }
//                }
//
//            }
//            //when past sell in time
//            if (item.sellIn < 0) {
//                if (!item.name.equals("Aged Brie")) {
//                    if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert") && !item.name.equals("Conjured")) {
//                        //if its not aged brie or backstage pass or conjured then decrease quality
//                        decreaseQualityIfPositiveValue(item);
//                    }
//                    if (item.name.equals("Conjured")) {
//                        decreaseQualityBy2IfPositiveValue(item);
//
//                    } else {
//                        //If item isnt aged brie then make quality equal to 0
//                        item.quality = 0;
//                    }
//                } else {
//                    //if it is aged brie then continue to increase quality but increase by one more as its after sell in so has increased rate
//                    increaseQualityIfSmallerThan50(item);
//                }
//            }
//        }
//    }

    private void increaseQualityIfSmallerThan50(Item item) {
        //increase quality by one if quality is below 50 allowing it to never be above 50
        if (item.quality < 50) {
            increaseQualityByOne(item);
        }
    }

    private void increaseQualityByOne(Item item) {
        //increase quality by one
        item.quality = item.quality + 1;
    }

    private void decreaseQualityIfPositiveValue(Item item) {
        //only decrease quality it by 1 if its bigger than zero as it can't be negative
        if (item.quality > 0) {
            decreaseQualityIfItemIsNotSulfuras(item);
        }
    }

    private void decreaseQualityBy2IfPositiveValue(Item item) {
        if (item.quality > 0) {
            decreaseQualityIfItemIsNotSulfuras(item);
            decreaseQualityIfItemIsNotSulfuras(item);
        }
    }

    private void decreaseQualityIfItemIsNotSulfuras(Item item) {
        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
            item.quality = item.quality - 1;
        }
    }

    private void increaseQualityBy1MoreWhenSellInIsBelow10Days(Item item) {
        if (item.sellIn < 11) {
            increaseQualityIfSmallerThan50(item);
        }
    }

    private void increaseQualityBy1MoreWhenSellInIsBelow5Days(Item item) {
        if (item.sellIn < 6) {
            increaseQualityIfSmallerThan50(item);
        }
    }

    private void decreaseSellInIfItemIsNotSulfuras(Item item) {
        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
            item.sellIn = item.sellIn - 1;
        }
    }

    private void updateSulfurasQualityTo80(Item item) {
        if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
            item.quality = 80;
        }
    }

    private void updateSulfurasSellInTo0(Item item) {
        if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
            item.sellIn = 0;
        }
    }
}
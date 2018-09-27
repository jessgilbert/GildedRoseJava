package training.gildedrose;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

public class GildedRoseTest {

    @Test
    public void SulfurasQualityDoesntChange() {
        // Arrange
        Item sulfuras = new Item("Sulfuras, Hand of Ragnaros", 10, 80);

        Item[] items = new Item[] { sulfuras};
        GildedRose gildedRose = new GildedRose(items);

        // Act
        gildedRose.updateQuality();

        // Assert
        assertThat(sulfuras.quality).isEqualTo(80);

    }

    @Test
    public void BackstagePassessIncreasesBy2Under10Days() {
        Item backstagePasses = new Item("Backstage passes to a TAFKAL80ETC concert", 9, 16);

        Item[] items = new Item[] { backstagePasses };
        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        assertThat(backstagePasses.quality).isEqualTo(18);
    }

    @Test
    public void ItemQualityDecreasesByOnePerDay() {

        Item fish = new Item("Fish", 30, 25);
        Item[] items = new Item[] {fish };
        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        assertThat(fish.quality).isEqualTo(24);
    }

    @Test
    public void AgedBrieQualityIncreasesByOneAday() {

        Item agedBrie = new Item("Aged Brie", 20, 30);

        Item[] items = new Item[] { agedBrie };
        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        assertThat(agedBrie.quality).isEqualTo(31);
    }

    @Test
    public void QualityIsNeverNegative(){

        Item fish = new Item("Fish", 30, 25);
        Item[] items = new Item[] {fish };
        GildedRose gildedRose = new GildedRose(items);

        for(int j = 50; j >=0; j--) {
            gildedRose.updateQuality();
        }

        assertThat(fish.quality).isEqualTo(0);
    }

    @Test
    public void QualityIsNeverAbove50() {

        Item agedBrie = new Item("Aged Brie", 20, 30);

        Item[] items = new Item[] { agedBrie };
        GildedRose gildedRose = new GildedRose(items);

        for(int j = 0; j <=50; j++) {
            gildedRose.updateQuality();
            System.out.println(agedBrie.name + " must be sold in " + agedBrie.sellIn + " days and now has a quality of " + agedBrie.quality );
        }

        assertThat(agedBrie.quality).isEqualTo(50);
    }

    @Test
    public void BackstagePassesQualityIncreasesBy3Under5days() {
        Item BackstagePasses = new Item("Backstage passes to a TAFKAL80ETC concert", 3, 40);

        Item[] items = new Item[] { BackstagePasses };
        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        assertThat(BackstagePasses.quality).isEqualTo(43);
    }

    @Test
    public void AgedBrieQualityIs0WhenSellInIs0() {
        Item BackstagePasses = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 40);

        Item[] items = new Item[] { BackstagePasses };
        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        assertThat(BackstagePasses.quality).isEqualTo(0);
    }

    @Test
    public void SulfurasSellInDoesntChange() {
        Item sulfuras = new Item("Sulfuras, Hand of Ragnaros", 10, 80);

        Item[] items = new Item[] { sulfuras};
        GildedRose gildedRose = new GildedRose(items);

        for(int j = 50; j >=0; j--) {
            // Act
            gildedRose.updateQuality();
        }
        // Assert
        assertThat(sulfuras.sellIn).isEqualTo(10);
    }

    @Test
    public void SellInDecreasesByOneEachDay() {
        Item fish = new Item("Fish", 30, 25);
        Item[] items = new Item[] {fish };
        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        assertThat(fish.sellIn).isEqualTo(29);
    }

    @Test
    public void QualityDecreasesByTwoWhenPastSellIn() {
        Item fish = new Item("Fish", -1, 5);
        Item[] items = new Item[] {fish };
        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        assertThat(fish.quality).isEqualTo(3);
    }

    @Test
    public void AgedBrieQualityIncreasesBy2AfterSellIn() {
        Item agedBrie = new Item("Aged Brie", -1, 40);

        Item[] items = new Item[] { agedBrie };
        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        assertThat(agedBrie.quality).isEqualTo(42);
    }

    @Test
    public void ConjuredQualityDecreaseByTwoEachDay() {
        Item conjured = new Item("Conjured", 30, 40);
        Item[] items = new Item[] { conjured };
        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        assertThat(conjured.quality).isEqualTo(38);
    }

    @Test
    public void ConjuredQualityDecreasesByFourAfterSellIn() {
        Item conjured = new Item("Conjured", -1, 40);
        Item[] items = new Item[] { conjured };
        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        assertThat(conjured.quality).isEqualTo(36);
    }
}
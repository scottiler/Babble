package edu.westga.cs.babble.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class TestTileBagDrawTile {
	private TileBag bag = new TileBag();
	private ArrayList<Tile> tiles = new ArrayList<Tile>();
	
	private int charOccurs(char letter) {
		int occur = 0;
		for (int index = 0; index < 98; index++) {
			if (this.tiles.get(index).getLetter() == letter) {
				occur++;
			}
		}
		return occur;
	}

	@Test
	void canDrawAllTiles() throws EmptyTileBagException {
		
		for (int index = 0; index < 98; index++) {
			this.tiles.add(this.bag.drawTile());
		}
		assertEquals(98, this.tiles.size());
	}

	@Test
	void canNotDrawTooManyTiles() {
		assertThrows(EmptyTileBagException.class, () -> {
			for (int index = 0; index < 99; index++) {
				this.tiles.add(this.bag.drawTile());
			}
		    });
	}
	
	@Test
	void hasProperTileDistribution() throws EmptyTileBagException {
		for (int index = 0; index < 98; index++) {
			this.tiles.add(this.bag.drawTile());
		}
		assertEquals(9, this.charOccurs('A'));
		assertEquals(2, this.charOccurs('B'));
		assertEquals(2, this.charOccurs('C'));
		assertEquals(4, this.charOccurs('D'));
		assertEquals(12, this.charOccurs('E'));
		assertEquals(2, this.charOccurs('F'));
		assertEquals(3, this.charOccurs('G'));
		assertEquals(2, this.charOccurs('H'));
		assertEquals(9, this.charOccurs('I'));
		assertEquals(1, this.charOccurs('J'));
		assertEquals(1, this.charOccurs('K'));
		assertEquals(4, this.charOccurs('L'));
		assertEquals(2, this.charOccurs('M'));
		assertEquals(6, this.charOccurs('N'));
		assertEquals(8, this.charOccurs('O'));
		assertEquals(2, this.charOccurs('P'));
		assertEquals(1, this.charOccurs('Q'));
		assertEquals(6, this.charOccurs('R'));
		assertEquals(4, this.charOccurs('S'));
		assertEquals(6, this.charOccurs('T'));
		assertEquals(4, this.charOccurs('U'));
		assertEquals(2, this.charOccurs('V'));
		assertEquals(2, this.charOccurs('W'));
		assertEquals(1, this.charOccurs('X'));
		assertEquals(2, this.charOccurs('Y'));
		assertEquals(1, this.charOccurs('Z'));
		
	}
}

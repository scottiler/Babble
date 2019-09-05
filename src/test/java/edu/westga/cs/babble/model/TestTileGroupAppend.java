package edu.westga.cs.babble.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestTileGroupAppend {
	private Dummy dummy = new Dummy();
	
	@Test
	void shouldNotAllowNull() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
			Tile tile = null;
			this.dummy.append(tile);
		    });
		 assertTrue(thrown.getMessage().contains("tile cannot be null"));
	}
	
	@Test
	void emptyGroupShouldBeEmpty() {
		assertEquals(true, this.dummy.tiles().isEmpty());
	}

	@Test
	void shouldHaveOneTileInTileGroup() {
		this.dummy.append(new Tile('a'));
		assertEquals(1, this.dummy.tiles().size());
	}
	
	@Test
	void shouldHaveManyTilesInTileGroup() {
		this.dummy.append(new Tile('a'));
		this.dummy.append(new Tile('b'));
		this.dummy.append(new Tile('c'));
		this.dummy.append(new Tile('d'));
		assertEquals(4, this.dummy.tiles().size());
	}
	
	@Test
	void shouldHaveManyTilesIncludingDuplicatesInTileGroup() {
		this.dummy.append(new Tile('a'));
		this.dummy.append(new Tile('a'));
		this.dummy.append(new Tile('d'));
		this.dummy.append(new Tile('d'));
		assertEquals(4, this.dummy.tiles().size());
	}
	
	@Test
	void canNotAddSameTileTwice() {
		Tile tile = new Tile('a');
		this.dummy.append(tile);
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
			this.dummy.append(tile);
		    });
		 assertTrue(thrown.getMessage().contains("can not add same tile twice"));
		
	}
	
	private static class Dummy extends TileGroup {
		
	}
}



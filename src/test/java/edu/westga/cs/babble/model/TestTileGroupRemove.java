package edu.westga.cs.babble.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestTileGroupRemove {
	private Dumber dummy = new Dumber();
	
	@Test
	void shouldNotAllowNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			Tile tile = null;
			this.dummy.remove(tile);
		    });
	}
	
	@Test
	void canNotRemoveFromEmptyTileGroup() {
		Tile tile = new Tile('a');
		assertThrows(TileNotInGroupException.class, () -> {
			this.dummy.remove(tile);
		    });
	}
	
	@Test
	void canNotRemoveTileNotInTileGroup() {
		Tile tile = new Tile('a');
		Tile a = new Tile('a');
		Tile b = new Tile('b');
		Tile c = new Tile('c');
		this.dummy.append(a);
		this.dummy.append(b);
		this.dummy.append(c);
		assertThrows(TileNotInGroupException.class, () -> {
			this.dummy.remove(tile);
		    });
	}
	
	@Test
	void canRemoveOnlyTileInTileGroup() throws TileNotInGroupException {
		assertEquals(true, this.dummy.tiles().isEmpty());
		Tile tile = new Tile('a');
		this.dummy.append(tile);
		assertTrue("A".equals(this.dummy.getHand()));
		assertEquals(false, this.dummy.tiles().isEmpty());
		this.dummy.remove(tile);
		assertEquals(true, this.dummy.tiles().isEmpty());
	}
	
	@Test
	void canRemoveFirstOfManyTilesFromTileGroup() throws TileNotInGroupException {
		Tile a = new Tile('a');
		Tile b = new Tile('b');
		Tile c = new Tile('c');
		Tile d = new Tile('d');
		Tile e = new Tile('e');
		Tile f = new Tile('f');
		this.dummy.append(a);
		this.dummy.append(b);
		this.dummy.append(c);
		this.dummy.append(d);
		this.dummy.append(e);
		this.dummy.append(f);
		assertEquals("ABCDEF", this.dummy.getHand());
		this.dummy.remove(a);
		assertEquals("BCDEF", this.dummy.getHand());
		
	}
	
	@Test
	void canRemoveLastOfManyTilesFromTileGroup() throws TileNotInGroupException {
		Tile a = new Tile('a');
		Tile b = new Tile('b');
		Tile c = new Tile('c');
		Tile d = new Tile('d');
		Tile e = new Tile('e');
		Tile f = new Tile('f');
		this.dummy.append(a);
		this.dummy.append(b);
		this.dummy.append(c);
		this.dummy.append(d);
		this.dummy.append(e);
		this.dummy.append(f);
		assertEquals("ABCDEF", this.dummy.getHand());
		this.dummy.remove(f);
		assertEquals("ABCDE", this.dummy.getHand());
	}
	
	@Test
	void canRemoveMiddleOfManyTilesFromTileGroup() throws TileNotInGroupException {
		Tile a = new Tile('a');
		Tile b = new Tile('b');
		Tile c = new Tile('c');
		Tile d = new Tile('d');
		Tile e = new Tile('e');
		Tile f = new Tile('f');
		this.dummy.append(a);
		this.dummy.append(b);
		this.dummy.append(c);
		this.dummy.append(d);
		this.dummy.append(e);
		this.dummy.append(f);
		assertEquals("ABCDEF", this.dummy.getHand());
		this.dummy.remove(c);
		assertEquals("ABDEF", this.dummy.getHand());
	}
	
	@Test
	void canRemoveMultipleTilesFromTileGroup() throws TileNotInGroupException {
		Tile a = new Tile('a');
		Tile b = new Tile('b');
		Tile c = new Tile('c');
		Tile d = new Tile('d');
		Tile e = new Tile('e');
		Tile f = new Tile('f');
		this.dummy.append(a);
		this.dummy.append(b);
		this.dummy.append(c);
		this.dummy.append(d);
		this.dummy.append(e);
		this.dummy.append(f);
		assertEquals("ABCDEF", this.dummy.getHand());
		this.dummy.remove(b);
		this.dummy.remove(c);
		this.dummy.remove(d);
		assertEquals("AEF", this.dummy.getHand());
	}
	
	@Test
	void doesNotRemoveDuplicateTilesFromTileGroup() {
		Tile a = new Tile('a');
		Tile b = new Tile('b');
		Tile c = new Tile('c');
		this.dummy.append(a);
		this.dummy.append(b);
		this.dummy.append(c);
		
		assertThrows(TileNotInGroupException.class, () -> {
			this.dummy.remove(a);
			this.dummy.remove(a);
		    });
	}

	private static class Dumber extends TileGroup {
		
	}
}

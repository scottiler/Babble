package edu.westga.cs.babble.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestTileConstructor {
	
	@Test
	void shouldNotAllowNonLetters() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
			Tile tile = new Tile('1');
		    });
		 assertTrue(thrown.getMessage().contains("letter must be between A and Z"));
	}
	
	@Test
	//EAIONRTLSU
	void shouldCreateOnePointTiles() {
		Tile e = new Tile('E');
		Tile a = new Tile('A');
		Tile i = new Tile('I');
		Tile o = new Tile('O');
		Tile n = new Tile('N');
		Tile r = new Tile('R');
		Tile t = new Tile('T');
		Tile l = new Tile('L');
		Tile s = new Tile('S');
		Tile u = new Tile('U');
		assertEquals(1, e.getPointValue());
		assertEquals(1, a.getPointValue());
		assertEquals(1, i.getPointValue());
		assertEquals(1, o.getPointValue());
		assertEquals(1, n.getPointValue());
		assertEquals(1, r.getPointValue());
		assertEquals(1, t.getPointValue());
		assertEquals(1, l.getPointValue());
		assertEquals(1, s.getPointValue());
		assertEquals(1, u.getPointValue());
	}

	@Test
	void shouldCreateTwoPointTiles() {
		Tile d = new Tile('D');
		Tile g = new Tile('G');
		assertEquals(2, d.getPointValue());
		assertEquals(2, g.getPointValue());
	}
	
	@Test
	void shouldCreateThreePointTiles() {
		Tile b = new Tile('B');
		Tile c = new Tile('C');
		Tile m = new Tile('M');
		Tile p = new Tile('P');
		assertEquals(3, b.getPointValue());
		assertEquals(3, c.getPointValue());
		assertEquals(3, m.getPointValue());
		assertEquals(3, p.getPointValue());
	}
	
	@Test
	void shouldCreateFourPointTiles() {
		Tile f = new Tile('F');
		Tile h = new Tile('H');
		Tile v = new Tile('V');
		Tile w = new Tile('W');
		Tile y = new Tile('Y');
		assertEquals(4, f.getPointValue());
		assertEquals(4, h.getPointValue());
		assertEquals(4, v.getPointValue());
		assertEquals(4, w.getPointValue());
		assertEquals(4, y.getPointValue());
	}
	
	@Test
	void shouldCreateFivePointTiles() {
		Tile k = new Tile('K');
		assertEquals(5, k.getPointValue());
	}
	
	@Test
	 void shouldCreateEightPointTiles() {
		Tile j = new Tile('J');
		Tile x = new Tile('X');
		assertEquals(8, j.getPointValue());
		assertEquals(8, x.getPointValue());
	}
	
	@Test
	void shouldCreateTenPointTiles() {
		Tile q = new Tile('Q');
		Tile z = new Tile('Z');
		assertEquals(10, q.getPointValue());
		assertEquals(10, z.getPointValue());
	}
}

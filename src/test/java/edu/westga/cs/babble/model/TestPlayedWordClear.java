package edu.westga.cs.babble.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestPlayedWordClear {
	private PlayedWord play = new PlayedWord();

	@Test
	void shouldClearEmptyWord() {
		assertTrue(this.play.tiles().isEmpty());
		this.play.clear();
		assertTrue(this.play.tiles().isEmpty());
	}
	
	@Test
	void shouldClearWordWithOneTile() {
		this.play.append(new Tile('a'));
		assertTrue(this.play.matches("A"));
		assertFalse(this.play.tiles().isEmpty());
		this.play.clear();
		assertTrue(this.play.tiles().isEmpty());
	}
	
	@Test
	void shouldClearWordWithManyTiles() {
		this.play.append(new Tile('h'));
		this.play.append(new Tile('a'));
		this.play.append(new Tile('p'));
		this.play.append(new Tile('p'));
		this.play.append(new Tile('y'));
		assertTrue(this.play.matches("HAPPY"));
		assertFalse(this.play.tiles().isEmpty());
		this.play.clear();
		assertTrue(this.play.tiles().isEmpty());
	}

}

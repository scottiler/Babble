package edu.westga.cs.babble.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestPlayedWordMatches {
	private PlayedWord play = new PlayedWord();

	@Test
	void hasTilesForAMultipleLetterWord() {
		this.play.append(new Tile('w'));
		this.play.append(new Tile('o'));
		this.play.append(new Tile('r'));
		this.play.append(new Tile('d'));
		assertTrue(this.play.matches("WORD"));
	}
	
	@Test
	void hasTilesForASingleLetterWord() {
		this.play.append(new Tile('a'));
		assertTrue(this.play.matches("A"));
	}
	
	@Test
	void cannotMatchWordWhenTilesAreScrambled() {
		this.play.append(new Tile('a'));
		this.play.append(new Tile('h'));
		this.play.append(new Tile('y'));
		this.play.append(new Tile('p'));
		this.play.append(new Tile('p'));
		assertFalse(this.play.matches("HAPPY"));
	}
	
	@Test
	void cannotMatchWordIfInsufficientTiles() {
		this.play.append(new Tile('h'));
		this.play.append(new Tile('a'));
		this.play.append(new Tile('p'));
		this.play.append(new Tile('p'));
		assertFalse(this.play.matches("HAPPY"));
	}
	
	@Test
	void canMatchWordWithDuplicateLetters() {
		this.play.append(new Tile('h'));
		this.play.append(new Tile('a'));
		this.play.append(new Tile('p'));
		this.play.append(new Tile('p'));
		this.play.append(new Tile('y'));
		assertTrue(this.play.matches("HAPPY"));
	}
	
	@Test
	void nonEmptyWordShouldNotMatchEmptyText() {
		this.play.append(new Tile('h'));
		this.play.append(new Tile('a'));
		this.play.append(new Tile('p'));
		this.play.append(new Tile('p'));
		this.play.append(new Tile('y'));
		assertFalse(this.play.matches(""));
	}
	
	@Test
	void emptyWordShouldNotMatchEmptyText() {
		assertFalse(this.play.matches(""));
	}
	
	@Test
	void shouldNotAllowNull() {
		this.play.append(new Tile('h'));
		this.play.append(new Tile('a'));
		this.play.append(new Tile('p'));
		this.play.append(new Tile('p'));
		this.play.append(new Tile('y'));
		assertThrows(IllegalArgumentException.class, () -> {
			String str = null;
			this.play.matches(str);
		    });
	}

}

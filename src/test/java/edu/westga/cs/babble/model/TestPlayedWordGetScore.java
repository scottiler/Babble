package edu.westga.cs.babble.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestPlayedWordGetScore {
	private PlayedWord play = new PlayedWord();
	
	@Test
	void emptyWordShouldHaveScoreOfZero() {
		assertEquals(0, this.play.getScore());
	}
	
	@Test
	void scoreAOneTileWord() {
		this.play.append(new Tile('a'));
		assertEquals(1, this.play.getScore());
	}
	
	@Test
	void scoreAWordWithMultipleDifferingTiles() {
		this.play.append(new Tile('a'));
		this.play.append(new Tile('r'));
		this.play.append(new Tile('m'));
		this.play.append(new Tile('y'));
		assertEquals(9, this.play.getScore());
	}
	
	@Test
	void scoreAWordContainingDuplicateTiles() {
		this.play.append(new Tile('h'));
		this.play.append(new Tile('a'));
		this.play.append(new Tile('p'));
		this.play.append(new Tile('p'));
		this.play.append(new Tile('y'));
		assertEquals(15, this.play.getScore());
	}

}

package edu.westga.cs.babble.controllers;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class TotalScore {
	private final IntegerProperty scoreTotal = new SimpleIntegerProperty();
	
	public int getTotalScore() {
		return this.scoreTotal.get();
	}

	public IntegerProperty scoreTotalProperty() {
		return this.scoreTotal;
	}

	public void setScoreTotal(int total) {
		this.scoreTotal.set(total);
	}
	
	public String getScoreTotalString () {
		return this.scoreTotal.toString();
	}
}

package edu.westga.cs.babble.controllers;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * Creates an InteregerProperty object
 * 
 * @author Perry Iler
 * @version Aug 25, 2019
 *
 */
public class TotalScore {
	private final IntegerProperty scoreTotal = new SimpleIntegerProperty();
	
	/**
	 * Return int value of scoreTotal
	 * 
	 * @return Int value of scoreTotal
	 */
	public int getTotalScore() {
		return this.scoreTotal.get();
	}

	/**
	 * Returns IntegerProperty ScoreTotal
	 * 
	 * @return IntegerProperty ScoreTotal
	 */
	public IntegerProperty scoreTotalProperty() {
		return this.scoreTotal;
	}

	/**
	 * Set the value scoreTotal
	 * 
	 * @param total Value out a score
	 */
	public void setScoreTotal(int total) {
		this.scoreTotal.set(total);
	}
	
	/**
	 * Return value of scoreTotal as a string
	 * 
	 * @return Value of scoreTotal as a string
	 */
	public String getScoreTotalString () {
		return this.scoreTotal.toString();
	}
}

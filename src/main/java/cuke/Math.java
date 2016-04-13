package cuke;

public class Math {
	// variable to hold our test calculation
	private int theCalc;
	
	// accessor
	public int getCalc() {
		return theCalc;
	}
	
	// constructor
	public Math(int baseValue) {
		theCalc = baseValue;
	}
	
	// method
	public void applyCalc(int multiplier) {
		theCalc = theCalc*multiplier;
	}
}

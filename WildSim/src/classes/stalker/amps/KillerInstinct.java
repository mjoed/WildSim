package classes.stalker.amps;

import classes.AMP;

public class KillerInstinct implements AMP {
	
	boolean isActive;
	
	public KillerInstinct(boolean active) {
		isActive = active;
	}

	@Override
	public void setActive(boolean active) {
		isActive = active;
	}

	@Override
	public boolean isActive() {
		return isActive;
	}

	@Override
	public String getName() {
		return "KillerInstinct";
	}
}

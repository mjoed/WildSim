package classes.stalker.amps;

import classes.AMP;

public class BrutalityMastery implements AMP {
	
	boolean isActive;
	
	public BrutalityMastery(boolean active) {
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
		return "BrutalityMastery";
	}

}

package classes.stalker.amps;

import classes.AMP;

public class StealthMastery implements AMP {
	
	boolean isActive;
	
	public StealthMastery(boolean active) {
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
		return "StealthMastery";
	}

}

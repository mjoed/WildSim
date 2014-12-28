package classes.stalker.amps;

import classes.AMP;

public class Onslaught implements AMP {
	
	boolean isActive;
	
	public Onslaught(boolean active) {
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
		return "Onslaught";
	}
}

package classes.stalker.amps;

import classes.AMP;

public class DevastateAMP implements AMP {
	
	boolean isActive;
	
	public DevastateAMP(boolean active) {
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
		return "DevastateAMP";
	}

}

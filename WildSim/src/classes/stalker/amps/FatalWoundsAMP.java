package classes.stalker.amps;

import classes.AMP;

public class FatalWoundsAMP implements AMP {
	
	boolean isActive;
	
	public FatalWoundsAMP(boolean active) {
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
		return "FatalWoundsAMP";
	}

}

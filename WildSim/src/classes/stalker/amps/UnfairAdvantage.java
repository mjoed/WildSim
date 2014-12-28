package classes.stalker.amps;

import classes.AMP;

public class UnfairAdvantage implements AMP {
	
	boolean isActive;
	
	public UnfairAdvantage(boolean active) {
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
		return "UnfairAdvantage";
	}

}

package classes.stalker.amps;

import classes.AMP;

public class CritSevAMP implements AMP {
	
	float amount;
	boolean isActive;
	
	public CritSevAMP(boolean active, float amount) {
		isActive = active;
		this.amount = amount;
	}
	
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public float getAmount() {
		return amount;
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
		return "CritSevAMP";
	}

}

package classes.general.debuffs;

import classes.RaidDebuff;

/**
 * Haunt, Crush t8, Incapacitate t4, Arcane Missiles, Withering Magic
 * @author mjoed
 *
 */
public class ReduceMagResist implements RaidDebuff {

	boolean isActive;
	float uptime;
	float amount;
	
	public ReduceMagResist(float amount, boolean isActive, float uptime) {
		this.amount = amount;
		this.isActive = isActive;
		this.uptime = uptime;
	}
	
	@Override
	public String getName() {
		return "ReduceMagResist";
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
	public float getUptime() {
		return uptime;
	}

	@Override
	public void setUptime(float uptime) {
		this.uptime = uptime;
	}
	
	public float getAmount() {
		return amount;
	}
	
	public void setAmount(float amount) {
		this.amount = amount;
	}

}

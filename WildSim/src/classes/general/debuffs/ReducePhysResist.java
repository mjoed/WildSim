package classes.general.debuffs;

import classes.RaidDebuff;

/**
 * Frenzy,
 * @author mjoed
 *
 */
public class ReducePhysResist implements RaidDebuff {

	boolean isActive;
	float uptime;
	float amount;
	
	public ReducePhysResist(float amount, boolean isActive, float uptime) {
		this.amount = amount;
		this.isActive = isActive;
		this.uptime = uptime;
	}
	
	@Override
	public String getName() {
		return "ReducePhysResist";
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

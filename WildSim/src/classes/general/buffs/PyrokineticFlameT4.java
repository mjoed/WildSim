package classes.general.buffs;

import classes.RaidBuff;

/**
 * Pyrokinetic Flame T4
 * @author mjoed
 *
 */
public class PyrokineticFlameT4 implements RaidBuff {

	boolean isActive;
	float uptime;
	float amount;
	
	public PyrokineticFlameT4(float amount, boolean isActive, float uptime) {
		this.amount = amount;
		this.isActive = isActive;
		this.uptime = uptime;
	}
	
	@Override
	public String getName() {
		return "PyrokineticFlameT4";
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

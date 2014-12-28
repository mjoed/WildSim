package classes.general.buffs;

import classes.RaidBuff;

/**
 * T4 PowerLink Bonus
 * @author mjoed
 *
 */
public class PowerLinkT4 implements RaidBuff {

	boolean isActive;
	float uptime;
	float amount = 0.025f;
	
	public PowerLinkT4(float amount, boolean isActive, float uptime) {
		this.isActive = isActive;
		this.uptime = uptime;
	}
	
	@Override
	public String getName() {
		return "PowerLinkT4";
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
		return;
	}

}

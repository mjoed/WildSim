package classes.general.debuffs;

import classes.RaidDebuff;


/**
 * Punish, 
 * @author mjoed
 *
 */
public class PhysicalDamageTaken implements RaidDebuff {

	boolean isActive;
	float uptime;
	
	public PhysicalDamageTaken(boolean isActive, float uptime) {
		this.isActive = isActive;
		this.uptime = uptime;
	}
	
	@Override
	public String getName() {
		return "Punish";
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
		return 0.1f;
	}
	
	public void setAmount(float amount) {
		return;
	}

}

package classes.general.buffs;

import classes.RaidBuff;

/**
 * Empowering Probes Bonus
 * @author mjoed
 *
 */
public class EmpoweringProbes implements RaidBuff {

	boolean isActive;
	float uptime;
	float amount;
	
	public EmpoweringProbes(float amount, boolean isActive, float uptime) {
		this.amount = amount;
		this.isActive = isActive;
		this.uptime = uptime;
	}
	
	@Override
	public String getName() {
		return "EmpoweringProbes";
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

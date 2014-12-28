package classes.general.buffs;

import classes.RaidBuff;

/**
 * Empowering Probes T4 Bonus
 * @author mjoed
 *
 */
public class EmpoweringProbesT4 implements RaidBuff {

	boolean isActive;
	float uptime;
	float amount;
	
	public EmpoweringProbesT4(float amount, boolean isActive, float uptime) {
		this.amount = amount;
		this.isActive = isActive;
		this.uptime = uptime;
	}
	
	@Override
	public String getName() {
		return "EmpoweringProbesT4";
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

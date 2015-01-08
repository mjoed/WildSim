package classes.stalker.buffs;

import combat.CombatLog;

import classes.Buff;

public class GuaranteedCrit implements Buff {

	boolean isActive;
	int duration = 0;
	int currDuration = 0;
	CombatLog combatlog;
	
	public GuaranteedCrit(CombatLog combatlog) {
		this.combatlog = combatlog;
	}
	
	@Override
	public String getName() {
		return "Guaranteed Crit";
	}

	@Override
	public boolean isActive() {
		return isActive;
	}

	@Override
	public void apply() {
		combatlog.addBuffEvent(this, true);
		isActive = true;
	}

	@Override
	public void remove() {
		combatlog.addBuffEvent(this, false);
		isActive = false;
	}

	@Override
	public void setDuration(int time) {
		duration = time;
	}

	@Override
	public int getDuration() {
		return duration;
	}

	@Override
	public int durationLeft() {
		return currDuration;
	}

	@Override
	public void reduceCurrDuration() {
		currDuration--;
		if (currDuration < 0) currDuration = 0;
	}

	@Override
	public int getStacks() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public int getUptime() {
		// TODO Auto-generated method stub
		return 0;
	}
	


}

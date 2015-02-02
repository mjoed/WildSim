package classes.stalker.buffs;

import combat.CombatLog;

import classes.Buff;

public class KillerInstinctEmpower implements Buff {
	
	boolean isActive;
	int duration = 4000;
	int currDuration = 0;
	int uptime = 0;
	CombatLog combatlog;
	
	public KillerInstinctEmpower(CombatLog combatlog) {
		this.combatlog = combatlog;
	}

	@Override
	public String getName() {
		return "KillerInstinctEmpower";
	}

	@Override
	public boolean isActive() {
		return isActive;
	}

	@Override
	public void apply() {	
		combatlog.addBuffEvent(this, true);
		isActive = true;
		currDuration = duration;
	}

	@Override
	public void remove() {
		isActive = false;
		currDuration = 0;
		combatlog.addBuffEvent(this, false);
	}

	@Override
	public void setDuration(int time) {
		currDuration = time;
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
		if (currDuration > 0) uptime++;
		currDuration--;
		if (currDuration <= 0)  {
			currDuration = 0;
			remove();
		}
	}

	@Override
	public int getStacks() {
		return 1;
	}

	@Override
	public int getUptime() {
		return uptime;
	}
	


}

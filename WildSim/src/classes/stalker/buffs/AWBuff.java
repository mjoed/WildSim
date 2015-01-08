package classes.stalker.buffs;

import combat.CombatLog;

import classes.Buff;

public class AWBuff implements Buff {
	
	boolean isActive;
	int duration = 5000;
	int currDuration = 0;
	CombatLog combatlog;
	int uptime = 0;
	
	public AWBuff(CombatLog combatlog) {
		this.combatlog = combatlog;
	}
	
	@Override
	public String getName() {
		return "AWBuff";
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
		combatlog.addBuffEvent(this, false);
		isActive = false;
		currDuration = 0;
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
	
	public int getUptime() {
		return uptime;
	}


}

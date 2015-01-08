package classes.stalker.buffs;

import combat.CombatLog;

import classes.Buff;

public class OnslaughtBuff implements Buff {
	
	boolean isActive;
	int duration = 8000;
	int currDuration = 0;
	CombatLog combatlog;
	
	public OnslaughtBuff(CombatLog combatlog) {
		this.combatlog = combatlog;
	}

	@Override
	public String getName() {
		return "OnslaughtBuff";
	}

	@Override
	public boolean isActive() {
		return isActive;
	}

	@Override
	public void apply() {
		isActive = true;
		currDuration = duration;
	}

	@Override
	public void remove() {
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
		return 0;
	}
	


}

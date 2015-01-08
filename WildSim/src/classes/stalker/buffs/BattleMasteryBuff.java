package classes.stalker.buffs;

import combat.CombatLog;

import classes.Buff;

public class BattleMasteryBuff implements Buff {
	
	boolean isActive;
	int uptime = 0;
	CombatLog combatlog;
	int durationLeft = 0;
	
	public BattleMasteryBuff(CombatLog combatlog) {
		this.combatlog = combatlog;
	}
	
	
	@Override
	public String getName() {
		return "BattleMasteryBuff";
	}

	@Override
	public boolean isActive() {
		return isActive;
	}

	@Override
	public void apply() {
		combatlog.addBuffEvent(this, true);
		isActive = true;
		durationLeft = 1;
	}

	@Override
	public void remove() {
		combatlog.addBuffEvent(this, false);
		isActive = false;
		durationLeft = 0;
	}

	@Override
	public void setDuration(int time) {
		return;
	}

	@Override
	public int getDuration() {
		return 0;
	}

	@Override
	public int durationLeft() {
		return durationLeft;
	}

	@Override
	public void reduceCurrDuration() {
		if (isActive) uptime++;
		return;
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

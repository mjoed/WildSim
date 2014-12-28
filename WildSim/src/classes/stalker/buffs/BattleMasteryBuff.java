package classes.stalker.buffs;

import classes.Buff;

public class BattleMasteryBuff implements Buff {
	
	boolean isActive;

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
		isActive = true;
	}

	@Override
	public void remove() {
		isActive = false;
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
		return 0;
	}

	@Override
	public void reduceCurrDuration() {
		return;
	}

	@Override
	public int getStacks() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}

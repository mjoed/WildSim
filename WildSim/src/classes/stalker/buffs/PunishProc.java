package classes.stalker.buffs;

import classes.Buff;

public class PunishProc implements Buff {

	boolean isActive = false;
	int duration = 5000;
	int currDuration = 0;
	
	@Override
	public String getName() {
		return "PunishProc";
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
		if (currDuration <= 0)  {
			currDuration = 0;
			isActive = false;
		}
	}

	@Override
	public int getStacks() {
		// TODO Auto-generated method stub
		return 0;
	}
	


}

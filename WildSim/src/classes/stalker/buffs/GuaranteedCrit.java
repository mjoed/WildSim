package classes.stalker.buffs;

import classes.Buff;

public class GuaranteedCrit implements Buff {

	boolean isActive;
	int duration = 0;
	int currDuration = 0;
	
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
		isActive = true;
	}

	@Override
	public void remove() {
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
		return 0;
	}
	


}

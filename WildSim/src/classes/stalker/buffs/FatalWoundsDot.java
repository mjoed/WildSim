package classes.stalker.buffs;

import classes.Buff;

public class FatalWoundsDot implements Buff {
	
	boolean isActive;
	int duration = 8000;
	int currDuration = 0;
	int stacks;

	@Override
	public String getName() {
		return "Enabler";
	}

	@Override
	public boolean isActive() {
		return isActive;
	}

	@Override
	public void apply() {
		stacks += 1;
		if (stacks > 5) stacks = 5;
		
		isActive = true;
		currDuration = duration;
	}

	@Override
	public void remove() {
		isActive = false;
		currDuration = 0;
		stacks = 0;
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
		return stacks;
	}
	


}

package classes.general.runesets;

import classes.Buff;

public class UnfairAdvantageBuff implements Buff {
	
	boolean isActive;
	int duration = 5000;
	int currDuration = 0;
	int amount;
	
	public UnfairAdvantageBuff(int amount) {
		this.amount = amount;
	}
	
	public int getAmount() {
		return amount;
	}
	
	@Override
	public String getName() {
		return "SpecterBuff";
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getUptime() {
		// TODO Auto-generated method stub
		return 0;
	}
	


}

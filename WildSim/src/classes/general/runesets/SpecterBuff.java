package classes.general.runesets;

import classes.Buff;

public class SpecterBuff implements Buff {
	
	boolean isActive;
	int duration = 5000;
	int currDuration = 0;
	int amount;
	
	public SpecterBuff(int amount) {
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
//		System.out.println("Specter applied!");
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
	


}

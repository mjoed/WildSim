package classes.stalker.amps;

import classes.AMP;

public class Cutthroat implements AMP {

	boolean isActive = false;
	int stacks = 0;
	
	public Cutthroat(boolean active) {
		isActive = active;
	}
	
	public int getStacks() {
		return stacks;
	}
	
	public void addStack() {
		stacks++;
	}
	
	public void removeStacks() {
		stacks = stacks%10;
	}
	
	@Override
	public void setActive(boolean active) {
		isActive = active;
	}

	@Override
	public boolean isActive() {
		return isActive;
	}

	@Override
	public String getName() {
		return "Cutthroat";
	}

}

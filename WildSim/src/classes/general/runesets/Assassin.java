package classes.general.runesets;

import classes.RuneSet;

public class Assassin implements RuneSet {

	boolean isActive;
	int amount;
	
	public Assassin(boolean active, int amount) {
		isActive = active;
		this.amount = amount;
	}
	
	@Override
	public String getName() {
		return "Assassin";
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
	public int getAmount() {
		return amount;
	}

	@Override
	public void setAmount(int amount) {
		this.amount = amount;
	}

}

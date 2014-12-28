package classes.stalker.abilities;

import classes.Ability;
import classes.WildstarClass;

public class AnalyzeWeakness implements Ability {
	
	int amountHits = 0;
	int amountCrits = 0;
	int amountDeflects = 0;
	
	float amountHitDamage = 0;
	float amountCritDamage = 0;
	
	boolean isActive;
	int tier;
	int cooldown;
	int currentCD;
	boolean applied = false;
	boolean triggered = false;
	
	public AnalyzeWeakness(int level, boolean active) {
		this.tier = level;
		cooldown = 8000;
		currentCD = 0;
		isActive = active;
	}

	
	public boolean isApplied() {
		return applied;
	}
	
	public void applied(boolean applied) {
		this.applied = applied;
	}
	
	public boolean isTriggered() {
		return triggered;
	}
	
	public void triggered(boolean triggered) {
		this.triggered = triggered;
	}
	
	@Override
	public String getName() {
		return "AW";
	}

	@Override
	public int getGCD() {
		return 0;
	}

	@Override
	public int getCost() {
		return 0;
	}

	@Override
	public float calculateTooltipDmg(float ap, float sp) {
		return ((ap * (0.5032f + (tier/100f * 2.27f))) + 1094f);
	}

	@Override
	public int getCurrentCD() {
		return currentCD;
	}

	@Override
	public void setCurrentCD(int cd) {
		currentCD = cd;
		if (currentCD < 0) {
			currentCD = 0;
		}
	}

	@Override
	public void redCDC() {
		currentCD--;
		if (currentCD < 0) {
			currentCD = 0;
		}
	}

	@Override
	public void setCooldown(int cd) {
		cooldown = cd;		
	}

	@Override
	public int getCooldown() {
		return cooldown;
	}

	@Override
	public boolean canCrit() {
		return true;
	}

	@Override
	public boolean canDeflect() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void addHit(float dmg) {
		amountHits++;
		amountHitDamage += dmg;
	}

	@Override
	public void addCrit(float dmg) {
		amountCrits++;
		amountCritDamage += dmg;
	}

	@Override
	public void addDeflect() {
		amountDeflects++;
	}

	@Override
	public int amountDeflects() {
		return amountDeflects;
	}

	@Override
	public int amountHits() {
		return amountHits;
	}

	@Override
	public float amountHitDamage() {
		return amountHitDamage;
	}

	@Override
	public int amountCrits() {
		return amountCrits;
	}

	@Override
	public float amountCritDamage() {
		return amountCritDamage;
	}


	@Override
	public int getTier() {
		return tier;
	}


	@Override
	public boolean isReady(WildstarClass actor) {
		return currentCD == 0;
	}


	@Override
	public void afterHit(WildstarClass actor) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void beforeHit(WildstarClass actor) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public float getArmorPierce() {
		// TODO Auto-generated method stub
		return 0;
	}
	

	@Override
	public int getType() {
		return 2;
	}


	@Override
	public void setTier(int tier) {
		this.tier = tier;
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
	public int compareTo(Ability arg0) {
		if (arg0.amountHitDamage() + arg0.amountCritDamage() > amountHitDamage + amountCritDamage) {
			return -1;
		} else if (arg0.amountHitDamage() + arg0.amountCritDamage() == amountHitDamage + amountCritDamage){
			return 0;
		} else {
			return 1;
		}
	}


	@Override
	public void resetValues() {
		amountHits = 0;
		amountCrits = 0;
		amountDeflects = 0;
		
		amountHitDamage = 0;
		amountCritDamage = 0;
	
		currentCD = 0;

		applied = false;
		triggered = false;
	}
}

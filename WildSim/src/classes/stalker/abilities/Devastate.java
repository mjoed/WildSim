package classes.stalker.abilities;

import classes.Ability;
import classes.WildstarClass;

public class Devastate implements Ability {
	
	int amountHits = 0;
	int amountCrits = 0;
	int amountDeflects = 0;
	
	float amountHitDamage = 0;
	float amountCritDamage = 0;
	
	boolean isActive;
	boolean triggered = false;
	
	public Devastate(boolean active) {
		isActive = active;
	}

	@Override
	public String getName() {
		return "Devastate";
	}
	
	@Override
	public void setTier(int tier) {
		return;
	}

	@Override
	public int getGCD() {
		return 0;
	}

	@Override
	public int getCost() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float calculateTooltipDmg(float ap, float sp) {
		return (ap * 0.22f) + 738f;
	}

	@Override
	public int getCurrentCD() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setCurrentCD(int cd) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void redCDC() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCooldown(int cd) {
		
	}
	
	@Override
	public int getCooldown() {
		return 0;
	}

	@Override
	public boolean canCrit() {
		return false;
	}
	
	@Override
	public boolean canDeflect() {
		return false;
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
		return 0;
	}
	
	public boolean isReady(WildstarClass actor) {
		return true;
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
		return 1;
	}

	@Override
	public int getType() {
		// TODO Auto-generated method stub
		return 1;
	}
	
	public boolean isTriggered() {
		return triggered;
	}
	
	public void trigger(boolean trigger) {
		triggered = trigger;
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
	
	public void resetValues() {
		amountHits = 0;
		amountCrits = 0;
		amountDeflects = 0;
		
		amountHitDamage = 0;
		amountCritDamage = 0;
	
	}
	
	@Override
	public int getPrio() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public void setPrio(int prio) {
		// TODO Auto-generated method stub
		
	}
}

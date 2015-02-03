package classes.stalker.abilities;

import classes.Ability;
import classes.WildstarClass;

public class Collapse implements Ability {
	
	int amountHits = 0;
	int amountCrits = 0;
	int amountDeflects = 0;
	
	float amountHitDamage = 0;
	float amountCritDamage = 0;
	
	boolean isActive;
	int tier = 0;
	int cooldown = 25000;
	int currentCD = 0;
	
	public Collapse(int level, boolean active) {
		this.tier = level;
		isActive = active;
	}
	@Override
	public String getName() {
		return "Collapse";
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
		return ((ap * (0.2237f + (((float)tier/100f) * 5.0f))) + 973.5f + (sp * (0.2237f + (((float)tier/100f) * 5.0f))));
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
		return false;
	}
	
	@Override
	public boolean canDeflect() {
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
	
	public boolean isReady(WildstarClass actor) {
		if (currentCD == 0) {
			return true;
		}
		return false;
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
		return 1;
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
	
	public void resetValues() {
		amountHits = 0;
		amountCrits = 0;
		amountDeflects = 0;
		
		amountHitDamage = 0;
		amountCritDamage = 0;
	
		currentCD = 0;
		
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

package classes.stalker.abilities;

import classes.Ability;
import classes.WildstarClass;

public class Shred implements Ability {
	
	int amountHits = 0;
	int amountCrits = 0;
	int amountDeflects = 0;
	int amountMultiHits = 0;
	int amountMultiHitCrits = 0;
	
	float amountHitDamage = 0;
	float amountCritDamage = 0;
	float amountMultiHitDamage = 0;
	float amountMultiCritDamage = 0;
	
	boolean isActive;
	int tier;
	int globalCD;
	int prio = 3;
	
	
	//TODO "currentCD" is misused for timing calculation of 2nd and 3rd shred hit
	int currentCD;
	
	public Shred(int level, boolean active) {
		globalCD = 1000;
		this.tier = level;
		isActive = active;
	}
	
	@Override
	public void setTier(int tier) {
		this.tier = tier;
	}
	
	@Override
	public int getGCD() {
		return globalCD;
	}


	@Override
	public int getCurrentCD() {
		return currentCD;
	}
	
	@Override
	public void redCDC() {
		currentCD--;
		if (currentCD < 0) {
			currentCD = 0;
		}
	}

	@Override
	public void setCurrentCD(int cd) {
		currentCD = cd;
	}

	@Override
	public void setCooldown(int cd) {
		return;
	}
	
	@Override
	public int getCooldown() {
		return globalCD;
	}

	@Override
	public float calculateTooltipDmg(float ap, float sp) {
		return ((ap * (0.0966f + ((float)tier/100.0f))) + 211.0f);
	}

	@Override
	public int getCost() {
		return 0;
	}

	@Override
	public String getName() {
		return "Shred";
	}
	
	public boolean canCrit() {
		return true;
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
		if (tier >= 4) {
			return 0.38f;
		}
		return 0;
	}

	@Override
	public int getType() {
		return 1;
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
		amountMultiHits = 0;
		amountMultiHitCrits = 0;
		
		amountHitDamage = 0;
		amountCritDamage = 0;
		amountMultiHitDamage = 0;
		amountMultiCritDamage = 0;
	
		currentCD = 0;
		
	}
	
	
	@Override
	public int getPrio() {
		return prio;
	}


	@Override
	public void setPrio(int prio) {
		this.prio = prio;
		
	}

	@Override
	public boolean canMultiHit() {
		return true;
	}
	
	@Override
	public void addMultiHit(float damage) {
		amountMultiHits++;
		amountMultiHitDamage += damage;
	}


	@Override
	public void addMultiHitCrit(float damage) {
		amountMultiHitCrits++;
		amountMultiCritDamage += damage;
		
	}


	@Override
	public int amountMultiHits() {
		return amountMultiHits;
	}


	@Override
	public float amountMultiHitDamage() {
		return amountMultiHitDamage;
	}


	@Override
	public int amountMultiHitCrits() {
		return amountMultiHitCrits;
	}


	@Override
	public float amountMultiHitCritDamage() {
		return amountMultiCritDamage;
	}
	
}

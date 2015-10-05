package classes.stalker.abilities;

import classes.Ability;
import classes.WildstarClass;

public class ShredAddHits implements Ability {
	
	int tier;
	boolean isActive;
	
	int amountHits = 0;
	int amountCrits = 0;
	int amountDeflects = 0;
	int amountMultiHits = 0;
	int amountMultiHitCrits = 0;
	
	float amountHitDamage = 0;
	float amountCritDamage = 0;
	float amountMultiHitDamage = 0;
	float amountMultiCritDamage = 0;
	
	
	public ShredAddHits(int tier, boolean active) {
		this.tier = tier;
		isActive = active;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Shred(add)";
	}
	
	@Override
	public void setTier(int tier) {
		this.tier = tier;
	}

	@Override
	public int getGCD() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getCost() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isReady(WildstarClass actor) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public float calculateTooltipDmg(float ap, float sp) {
		return ((ap * (0.0966f + ((float)tier/100.0f))) + 211.0f);
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getCooldown() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean canCrit() {
		// TODO Auto-generated method stub
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

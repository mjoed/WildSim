package classes.stalker.abilities;

import classes.Ability;
import classes.WildstarClass;
import classes.stalker.Stalker;

public class Ruin implements Ability {
	
	boolean waitfordot = true;
	
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
	int cooldown = 6000;
	int currentCD = 0;
	
	int prio = 4;
	
	public Ruin(int tier, boolean active) {
		this.tier = tier;
		isActive = active;
	}

	@Override
	public void setTier(int tier) {
		this.tier = tier;
	}
	
	@Override
	public String getName() {
		return "Ruin";
	}

	//TODO check for exact GCD
	@Override
	public int getGCD() {
		return 500;
	}

	@Override
	public int getCost() {
		return 10;
		
	}

	@Override
	public float calculateTooltipDmg(float ap, float sp) {
		return ((ap * (0.1629f + (((float)tier/100f) * 1.52f))) + 354.5f);
	}

	@Override
	public int getCurrentCD() {
		return currentCD;
	}

	@Override
	public void setCurrentCD(int cd) {
		currentCD = cd;
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
		Stalker player = (Stalker)actor;
		Ability ruindot = player.getRuinDot();
		
		
		if (currentCD == 0) {
			if (!waitfordot) {
				return true;
			}
			
			if (ruindot.getCurrentCD() == 0) {
				return true;
			}
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
		return 2;
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
	
	public boolean getWaitForDot() {
		return waitfordot;
	}
	
	public void setWaitForDot(boolean waitfordot) {
		this.waitfordot = waitfordot;
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

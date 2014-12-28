package classes.stalker.abilities;

import classes.Ability;
import classes.Buff;
import classes.WildstarClass;
import classes.stalker.Stalker;

public class ConcussiveKicksFirst implements Ability {
	
	int amountHits = 0;
	int amountCrits = 0;
	int amountDeflects = 0;
	
	float amountHitDamage = 0;
	float amountCritDamage = 0;
	
	int globalcd = 600;
	boolean isActive;
	int tier;
	
	//TODO "currentCD" is misused for timing calculation of 2nd hit
	int currentCD;
	
	public ConcussiveKicksFirst(int tier, boolean active) {
		this.tier = tier;
		isActive = active;
	}
	
	@Override
	public void setTier(int tier) {
		this.tier = tier;
	}

	@Override
	public String getName() {
		return "CK(first)";
	}

	@Override
	public int getGCD() {
		return globalcd;
	}

	@Override
	public int getCost() {
		return 0;
	}

	@Override
	public float calculateTooltipDmg(float ap, float sp) {
		return ((ap * (0.3864f + ((tier/100) * 2.4f))) + 837);
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
		return;
	}
	
	@Override
	public int getCooldown() {
		return globalcd;
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
	
	public boolean isReady(WildstarClass actor) {
		Stalker player = (Stalker)actor;
		
		Ability ck = player.getCK();
		Ability punish = player.getPunish();
		Buff ckcd = player.getCKCD();
			
		if (ck.isActive() && ck.getCurrentCD() != 0) return false;
		
		if (tier == 8) {
			if (!ckcd.isActive()) {
				if (punish.getCurrentCD() > 2000) {
					return true;
				}
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
		
		amountHitDamage = 0;
		amountCritDamage = 0;
	
		currentCD = 0;
		
	}
}

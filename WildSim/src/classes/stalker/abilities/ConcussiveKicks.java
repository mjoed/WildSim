package classes.stalker.abilities;

import classes.Ability;
import classes.Buff;
import classes.WildstarClass;
import classes.stalker.Stalker;

public class ConcussiveKicks implements Ability {
	
	int amountHits = 0;
	int amountCrits = 0;
	int amountDeflects = 0;
	
	float amountHitDamage = 0;
	float amountCritDamage = 0;
	
	boolean isActive;
	int tier;
	int cooldown = 8000;
	int currentCD = 0;
	
	boolean useAfterPunish = false;
	boolean punishUsed = false;
	
	int castAtPunishCD = 2000;
	
	int prio = 1;
	
	public ConcussiveKicks(int tier, boolean active) {
		this.tier = tier;
		isActive = active;
	}

	@Override
	public String getName() {
		return "CK";
	}

	//TODO check for exact GCD
	@Override
	public int getGCD() {
		return 750;
	}

	@Override
	public int getCost() {
		return 15;
		
	}

	@Override
	public float calculateTooltipDmg(float ap, float sp) {
		return ((ap * (0.3864f + (((float)tier/100f) * 2.0f))) + 837f);
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
		Ability punish = player.getPunish();
		Buff ckcd = player.getCKCD();
		
		if (useAfterPunish) {
			if (ckcd.isActive()) {
				if (punishUsed && currentCD == 0) {
					punishUsed = false;
					return true;
				} else {
					return false;
				}
			}
			
		}
		
		if (tier == 8 && currentCD == 0) {
			if (ckcd.isActive()) {
				if (punish.getCurrentCD() > castAtPunishCD) {
					return true;
				}
			}
		}
		
		if (tier < 8 && currentCD == 0) {
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
		
		punishUsed = false;
		
	}
	
	@Override
	public int getPrio() {
		return prio;
	}


	@Override
	public void setPrio(int prio) {
		this.prio = prio;
		
	}
	
	public int getCastAtPunishCD() {
		return castAtPunishCD;
	}
	
	public void setCastAtPunishCD(int castAtPunishCD) {
		this.castAtPunishCD = castAtPunishCD;
	}
	
	public boolean getUseAfterPunish() {
		return useAfterPunish;
	}
	
	public void setUseAfterPunish(boolean useAfterPunish) {
		this.useAfterPunish = useAfterPunish;
	}
	
	public void setPunishUsed(boolean punishUsed) {
		this.punishUsed = punishUsed;
	}
	
}

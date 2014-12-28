package classes.stalker.abilities;

import classes.AMP;
import classes.Ability;
import classes.Buff;
import classes.WildstarClass;
import classes.stalker.Stalker;

public class Impale implements Ability {
	
	int amountHits = 0;
	int amountCrits = 0;
	int amountDeflects = 0;
	
	float amountHitDamage = 0;
	float amountCritDamage = 0;
	
	int cost;
	boolean isActive;
	int tier;
	int globalCD;
	
	public Impale(int level, boolean active) {
		this.tier = level;
		globalCD = 500;
		if (level < 8) {
			cost = 35;
		} else {
			cost = 30;
		}
		isActive = active;
	}
	
	@Override
	public void setTier(int tier) {
		this.tier = tier;
		if (tier < 8) {
			cost = 35;
		} else {
			cost = 30;
		}
	}
	
	@Override
	public int getGCD() {		
		return globalCD;
	}

	@Override
	public int getCost() {
		return cost;
	}

	@Override
	public float calculateTooltipDmg(float ap, float sp) {
		return ((ap * (0.845f + (((float)tier/100f) * 4.1f))) + 1985f);
	}


	@Override
	public int getCurrentCD() {
		return 0;
	}

	@Override
	public void setCurrentCD(int cd) {
		return;
	}

	@Override
	public void redCDC() {
		return;
	}

	@Override
	public void setCooldown(int cd) {
		return;
	}

	@Override
	public int getCooldown() {
		return 0;
	}
	

	@Override
	public String getName() {
		return "Impale";
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
		if (actor.getRessource() > getCost()) {
			return true;
		}
		
		return false;
	}


	@Override
	public void afterHit(WildstarClass actor) {
		Stalker player = (Stalker)actor;
		
		//disable unfair advantage cost reduction
		if ((tier < 8 && cost == 35) || (tier == 8 && cost == 30)) {
			return;
		}
		Ability innate = player.getInnate();
		Ability tretreat = player.getTacticalRetreat();
		

		if (innate.getCurrentCD() != 0) {
			if (tier < 8) {
				cost = 35;
			} else {
				cost = 30;
			}
		}
		
		if (tretreat.getCurrentCD() != 0) {
			if (tier < 8) {
				cost = 35;
			} else {
				cost = 30;
			}
		}
	}


	@Override
	public void beforeHit(WildstarClass actor) {
		Stalker player = (Stalker)actor;
		boolean uaactive = false;
		
		//check for unfair advantage
		AMP ua = player.getUnfairAdvantage();
		Ability innate = player.getInnate();
		Ability tretreat = player.getTacticalRetreat();
		Buff guarantcrit = player.getGuarantCrit();
				
		uaactive = ua.isActive();
		
		//use either innate or tactical retreat if one is up
	
		if (innate.getCurrentCD() == 0) {
			innate.addHit(0);
			innate.setCurrentCD(innate.getCooldown());
//			System.out.println("Innate applied");
			guarantcrit.apply();
			//enable unfair advantage cost reduction
			if (uaactive) {
				cost = cost - 8;
			}
			return;
		}
		
		if (tretreat.getCurrentCD() == 0) {
			tretreat.addHit(0);
			tretreat.setCurrentCD(tretreat.getCooldown());
//			System.out.println("Tactical Retreat applied");
			guarantcrit.apply();
			//enable unfair advantage cost reduction
			if (uaactive) {
				cost = cost - 8;
			}
			return;
		}
		
	}


	@Override
	public float getArmorPierce() {
		if (tier >= 4) {
			return 0.50f;
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
		
		amountHitDamage = 0;
		amountCritDamage = 0;
		
		if (tier < 8) {
			cost = 35;
		} else {
			cost = 30;
		}
	
		
	}
}

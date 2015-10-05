package classes.stalker.abilities;

import classes.Ability;
import classes.WildstarClass;

public class Innate implements Ability {
	
	int cooldown = 25000;
	int currentCD = 0;
	
	boolean isActive;
	int amountHits;

	public Innate(boolean active) {
		isActive = active;
	}
	
	@Override
	public String getName() {
		return "Innate";
	}
	
	@Override
	public void setTier(int tier) {
		return;
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
	public int getTier() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isReady(WildstarClass actor) {
		// TODO Auto-generated method stub
		return currentCD == 0;
	}

	@Override
	public float calculateTooltipDmg(float ap, float sp) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getCurrentCD() {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canDeflect() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addHit(float dmg) {
		amountHits++;
		
	}

	@Override
	public void addCrit(float dmg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addDeflect() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int amountDeflects() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int amountHits() {
		// TODO Auto-generated method stub
		return amountHits;
	}

	@Override
	public float amountHitDamage() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int amountCrits() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float amountCritDamage() {
		// TODO Auto-generated method stub
		return 0;
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
		// TODO Auto-generated method stub
		return 0;
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
		return -1;
	}
	
	public void resetValues() {
		amountHits = 0;
	
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

	@Override
	public boolean canMultiHit() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int amountMultiHits() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float amountMultiHitDamage() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int amountMultiHitCrits() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float amountMultiHitCritDamage() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void addMultiHitCrit(float damage) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addMultiHit(float damage) {
		// TODO Auto-generated method stub
		
	}

}

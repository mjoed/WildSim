package classes.stalker.abilities;

import classes.Ability;
import classes.WildstarClass;

public class Preparation implements Ability {
	
	int amountHits = 0;
	int amountCrits = 0;
	int amountDeflects = 0;
	
	float amountHitDamage = 0;
	float amountCritDamage = 0;
	
	boolean isActive;
	boolean completechannel = false;
	boolean channeloncd = false;
	
	int tier = 0;
	int cooldown = 15000;
	int currentCD = 0;
	int channelTime = 0;
	boolean channeling = false;
	
	public Preparation(int level, boolean active) {
		this.tier = level;
		isActive = active;
	}
	
	@Override
	public void setTier(int tier) {
		this.tier = tier;
	}
	
	@Override
	public String getName() {
		return "Preparation";
	}

	@Override
	public int getGCD() {
		if (!completechannel) {
			return 0;
		} else {
			return 3000;
		}
	}

	@Override
	public int getCost() {
		return 0;
	}

	@Override
	public float calculateTooltipDmg(float ap, float sp) {
		return 0;
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
		return tier;
	}
	
	public boolean isReady(WildstarClass actor) {
		if (currentCD == 0 && !channeling) {
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
	
	public void startChanneling() {
		channeling = true;
	}
	
	public void stopChanneling() {
		channeling = false;
		channelTime = 0;
	}
	
	public void channelAbility() {
		channelTime += 1;
	}
	
	public boolean isChanneling() {
		return channeling;
	}
	
	public int getChannelTime() {
		return channelTime;
	}
	
	public boolean completeChannel() {
		return completechannel;
	}
	
	public void setCompleteChannel(boolean channel) {
		completechannel = channel;
	}
	
	public boolean channelOnCD() {
		return channeloncd;
	}
	
	//only works with complete channel
	public void setChannelOnCD(boolean channeloncd) {
		this.channeloncd = channeloncd;
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
		channelTime = 0;
		channeling = false;
		
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

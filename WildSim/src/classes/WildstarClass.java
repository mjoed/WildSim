package classes;

public interface WildstarClass {

	//should return next ability which can't be cast outside GCD lockout. gets called if GCD is 0.
	public Ability getNextGCDAbility();
	
	//should return next ability which ignores GCD. gets called every ms until it returns null.
	//usage examples: multiple swings from hits, dots, amp dmg etc.
	public Ability getNextNonGCDAbility();
	
	//gets called after each ms. gives currtime for time based calculations
	//usage examples: resource per second etc
	public void afterTick(int currtime);
	
	//gets called after each hit with information regarding the ability, if it was a crit or got deflected.
	//usage examples: CD management, procs/stacks etc.
	public void afterHit(Ability ability, boolean crit, boolean deflect, float damage);
	
	//last check before combat start
	public void lastCheck();
	
	public Ability[] getAbilities();
	public Buff[] getBuffs();
	public AMP[] getAMPs();
	
	public void setAP(float ap);
	public float getAP();
	
	public void setSP(float sp);
	public float getSP();
	
	public void setCrit(float crit);
	public float getCrit();
	
	public void setCritSev(float critsev);
	public float getCritSev();
	
	public void setStrikethrough(float strikethrough);
	public float getStrikethrough();
	
	public void setArmorPierce(float armorPierce);
	public float getArmorPierce();
	
	public void setCDReduction(float cdr);
	public float getCDReduction();
	
	public int getRessource();
	
	public float getFlatDamageBuff();
	
	public void setRaidBuffs(RaidBuff[] raidbuffs);
	public void setRuneSets(RuneSet[] runesets);
	
}

package classes;

public interface Ability extends Comparable<Ability> {
	
	/**
	 * returns name of ability
	 * @return 
	 */
	public String getName();
	
	/**
	 * returns dmg type (1 = physical, 2 = technology, 3 = magic)
	 * @return
	 */
	public int getType();

	/**
	 * returns globalCD time invoked by ability in ms
	 * @return
	 */
	 
	public int getGCD();
	
	/**
	 * returns resource cost of ability
	 * @return
	 */
	public int getCost();
	
	/**
	 * returns tier level
	 * @return
	 */
	public int getTier();
	
	/**
	 * sets tier level
	 * @param tier
	 */
	public void setTier(int tier);
	
	public boolean isActive();
	
	/**
	 * sets active/inactive
	 * @param active
	 */
	public void setActive(boolean active);
	
	/**
	 * returns true if ability is "ready" (can/should be used)
	 * @param actor
	 * @return
	 */
	public boolean isReady(WildstarClass actor);
	
	/**
	 * afterhit logic
	 * @param actor
	 */
	public void afterHit(WildstarClass actor);
	
	//beforehit logic
	public void beforeHit(WildstarClass actor);
	
	//returns tooltip dmg from ability
	public float calculateTooltipDmg(float ap, float sp);
	
	//gets current CD
	public int getCurrentCD();
	
	//sets current CD
	public void setCurrentCD(int cd);
	
	//reduces CD by 1ms
	public void redCDC();
	
	//sets cooldown (NOT current cooldown)
	public void setCooldown(int cd);
	
	//returns cooldown (NOT current cooldown)
	public int getCooldown();
	
	//gets ability specific armor pierce
	public float getArmorPierce();
	
	//if ability can crit (dots etc)
	public boolean canCrit();
	
	//if ability can be deflected
	public boolean canDeflect();
	
	//add hits
	public void addHit(float dmg);
	
	//add crits
	public void addCrit(float dmg);
	
	//add deflects
	public void addDeflect();
	
	//get deflects
	public int amountDeflects();
	
	//get hits
	public int amountHits();
	
	//get hitdmg
	public float amountHitDamage();
	
	//get crits
	public int amountCrits();
	
	//get critdmg
	public float amountCritDamage();
	
	public void resetValues();
	
	public int getPrio();
	
	public void setPrio(int prio);
	
}

package combat;

import helpers.helpers;
import classes.Ability;
import classes.RaidBuff;
import classes.RaidDebuff;
import classes.WildstarClass;
import classes.WildstarMob;
import classes.general.buffs.*;
import classes.general.debuffs.*;
import classes.stalker.Stalker;

/**
 * combat class handles gcd, dmg calculation, max combat duration.
 */
public class Combat implements Runnable {
	
	boolean combatlogdmg = true;
	
	int globalcd = 0;
	int maxtime = 36000000;
	int currtime = 0;
	float dmgoverall;
	float currdmg;
	long startTime;
	
	
	WildstarMob target;
	WildstarClass wildclass;
	Ability nextAbility;
	Ability nextNonGCDAbility;
	
	//raidbuffs/raiddebuffs
	RaidBuff[] raidbuffs;
	RaidDebuff punish;
	RaidBuff powerlinkt4;
	RaidBuff powerlink;
	RaidBuff empowering;
	RaidBuff empoweringt4;
	RaidBuff empoweringaura;
	RaidBuff voidpact;
	RaidBuff surgical;
	RaidBuff pyrokinetict4;
	RaidBuff dualfire;
	RaidBuff bloodthirst;
	
	//statreducing raiddebuffs
	RaidDebuff armorreduction;
	RaidDebuff reduceallresist;
	RaidDebuff reducephysresist;
	RaidDebuff reducemagresist;
	RaidDebuff reducetechresist;
	RaidDebuff reducedeflect;
	
	public Combat() {
		target = new WildstarMob();
		wildclass = new Stalker(2155.665f, 820.524f, 0.0893f, 1.6535f, 0.0340f, 0.0f, 0.00f);
		
		punish = new PhysicalDamageTaken(false, 1.0f);
		powerlinkt4 = new PowerLinkT4(0.025f, false, 1.0f);
		powerlink = new PowerLink(0.14f, false, 1.0f);
		empowering = new EmpoweringProbes(0.1f, false, 1.0f);
		surgical = new Surgical(0.06f, false, 1.0f);
		
		//partice ejector 20%
		armorreduction = new ArmorReduction(0.20f, false, 1.0f);
		//smackdown + armorshred multip.
		reduceallresist = new ReduceAllResist(0.1774f, false, 1.0f);
		//frenzy (stacks multip.)
		reducephysresist = new ReducePhysResist(0.1670f, false, 1.0f);
		//haunt/arcance missiles/withering magic multip.
		reducemagresist = new ReduceMagResist(0.7256f, false, 1.0f);
		//bio shell t0
		reducetechresist = new ReduceTechResist(0.07f, false, 1.0f);
		//tk storm
		reducedeflect = new ReduceDeflectChance(0.08f, false, 1.0f);
		
		//class stat changing raidbuffs
		empoweringt4 = new EmpoweringProbesT4(0.03f, false, 1.0f);
		empoweringaura = new EmpoweringAura(0.06f, false, 1.0f);
		voidpact = new VoidPact(0.09f, false, 1.0f);
		pyrokinetict4 = new PyrokineticFlameT4(0.05f, false, 1.0f);
		dualfire = new DualFireT8(0.036f, false, 1.0f);
		bloodthirst = new BloodThirstT4(0.07f, false, 1.0f);
		
		fillRaidBuffArray();
		
	}
	
	
	//starts combat for defined maxtime
	@Override
	public void run() {
		startTime = System.nanoTime();
		wildclass.setRaidBuffs(raidbuffs);
		wildclass.lastCheck();
		
		dmgoverall = 0;
				
		while (currtime < maxtime) {			
			if (globalcd == 0) {
				
				nextAbility = wildclass.getNextGCDAbility();
				
				if (nextAbility != null) {
					currdmg = calculateDamage(wildclass, nextAbility, target);
					dmgoverall += currdmg;
					globalcd = nextAbility.getGCD();
				}

				
			} 
			
			nextNonGCDAbility = wildclass.getNextNonGCDAbility();
			
			while (nextNonGCDAbility != null) {
				
				currdmg = calculateDamage(wildclass, nextNonGCDAbility, target);
				dmgoverall += currdmg;
				
				if (globalcd < nextNonGCDAbility.getGCD()) {
					globalcd = nextNonGCDAbility.getGCD();
				}
				
				nextNonGCDAbility = wildclass.getNextNonGCDAbility();
				

				
			}
			
			nextTick();
			
		}
		
		System.out.println("[" + helpers.msToString(currtime) + "] " + "Overall dmg: " + dmgoverall);
		System.out.println("[" + helpers.msToString(currtime) + "] " + "DPS: " + dmgoverall/(maxtime/1000));
		
		Ability[] abilities = wildclass.getAbilities();
		float totalcount;
		
		for (int i=0; i<abilities.length; i++) {
			if (abilities[i] != null) {
				totalcount = abilities[i].amountCrits() + abilities[i].amountHits() + abilities[i].amountDeflects();
				System.out.println("[" + helpers.msToString(currtime) + "] " + abilities[i].getName() + " dps: " + (abilities[i].amountCritDamage() + abilities[i].amountHitDamage())/(maxtime/1000) + ", hits: " + abilities[i].amountHits() + " (" + (float)((float)abilities[i].amountHits() * 100 / totalcount) + ") " + ", crits: " + abilities[i].amountCrits() + " (" + (float)((float)abilities[i].amountCrits() * 100 / totalcount) + ") " + ", deflects: " + abilities[i].amountDeflects() + " (" + (float)((float)abilities[i].amountDeflects() * 100 / totalcount) + ") ");	
			}
		}
		
		long endTime = System.nanoTime();
		System.out.println("Took "+(endTime - startTime) + " ns"); 
		
		currtime = 0;

	}

	private void nextTick() {
		currtime++;
		if (globalcd > 0) {
			globalcd--;
		}
		wildclass.afterTick(currtime);
	}
	
	
	
	
	//calculates dmg/crits/deflects from given actor with given ability to given target
	private float calculateDamage(WildstarClass wildclass, Ability ability, WildstarMob target) {

		checkRaidDebuffs();
		
		float tooltipdmg = ability.calculateTooltipDmg(wildclass.getAP(), wildclass.getSP());
		
		//TODO  calculation correct?
		float actualdmg = (tooltipdmg - ((tooltipdmg * (target.getMitigation(ability.getType()) * (1-(wildclass.getArmorPierce()+ability.getArmorPierce()))))));
	
		
		actualdmg = checkRaidBuffs(actualdmg, ability);
		
		
		//class specific flat dmg buffs (AMPs etc.)
		if (wildclass.getFlatDamageBuff() != 0) {
			actualdmg *= (1 + wildclass.getFlatDamageBuff());
		}
	 		
		//1 roll for both
		double roll = Math.random();
		
		if (ability.canDeflect() && roll < (double)(target.getDeflectchance() - wildclass.getStrikethrough())) {
			if (combatlogdmg) {
				System.out.println("[" + helpers.msToString(currtime) + "] " + "[Ressource: " + wildclass.getRessource() + "] " + ability.getName() + " deflected");
			}
			wildclass.afterHit(ability, false, true, 0);
			return 0;
		}
		
		if (ability.canCrit() && (target.getDeflectchance() - wildclass.getStrikethrough()) <= roll && roll < ((target.getDeflectchance() - wildclass.getStrikethrough()) + wildclass.getCrit())) {
			actualdmg *= wildclass.getCritSev();
			if (combatlogdmg) {
				System.out.println("[" + helpers.msToString(currtime) + "] " + "[Ressource: " + wildclass.getRessource() + "] " + ability.getName() + " crits for: " + actualdmg);
			}
			wildclass.afterHit(ability, true, false, actualdmg);
			return actualdmg;
		} else {
			if (combatlogdmg) {
				System.out.println("[" + helpers.msToString(currtime) + "] " + "[Ressource: " + wildclass.getRessource() + "] " + ability.getName() + " hits for: " + actualdmg);
			}
			wildclass.afterHit(ability, false, false, actualdmg);
			return actualdmg;
		}
		
		
		
	}
	
	

	private float checkRaidBuffs(float actualdmg, Ability ability) {
		
		
		double chance = Math.random();
		float buffeddmg = actualdmg;
		
		if (punish.isActive() && ability.getType() == 1 && punish.getUptime() >= chance) {
			buffeddmg *= (1+punish.getAmount());
		}
		if (powerlinkt4.isActive() && powerlinkt4.getUptime() >= chance) {
			buffeddmg *= (1+powerlinkt4.getAmount());
		}
		if (powerlink.isActive() && powerlink.getUptime() >= chance) {
			buffeddmg *= (1+powerlink.getAmount());
		}
		if (empowering.isActive() && empowering.getUptime() >= chance) {
			buffeddmg *= (1+empowering.getAmount());
		}
		if (surgical.isActive() && surgical.getUptime() >= chance) {
			buffeddmg *= (1+surgical.getAmount());
		}
		
		
		return buffeddmg;
	}

	/**
	 * applies all raiddebuffs (with their respective uptime)
	 */
	public void checkRaidDebuffs() {
		target.resetStats();
		
		double chance = Math.random();
		
		if (armorreduction.isActive() && armorreduction.getUptime() >= chance) {
			target.setArmor(target.getArmor() - (target.getArmor() * armorreduction.getAmount()));
		}
		if (reduceallresist.isActive() && reduceallresist.getUptime() >= chance) {
			target.setMagRes(target.getMagRes() - (target.getMagRes() * reduceallresist.getAmount()));
			target.setPhysRes(target.getPhysRes() - (target.getPhysRes() * reduceallresist.getAmount()));
			target.setTechRes(target.getTechRes() - (target.getTechRes() * reduceallresist.getAmount()));
		}
		if (reducephysresist.isActive() && reducephysresist.getUptime() >= chance) {
			target.setPhysRes(target.getPhysRes() - (target.getPhysRes() * reducephysresist.getAmount()));
		}
		if (reducemagresist.isActive() && reducemagresist.getUptime() >= chance) {
			target.setMagRes(target.getMagRes() - (target.getMagRes() * reducemagresist.getAmount()));
		}
		if (reducetechresist.isActive() && reducetechresist.getUptime() >= chance) {
			target.setTechRes(target.getTechRes() - (target.getTechRes() * reducetechresist.getAmount()));
		}
		if (reducedeflect.isActive() && reducedeflect.getUptime() >= chance) {
			target.setDeflectchance(target.getDeflectchance() - (target.getDeflectchance() * reducedeflect.getAmount()));
		}
		
	}
	
	private void fillRaidBuffArray() {
		int amount = 0;
		if (empoweringt4.isActive()) amount++;
		if (empoweringaura.isActive()) amount++;
		if (voidpact.isActive()) amount++;
		if (pyrokinetict4.isActive()) amount++;
		if (dualfire.isActive()) amount++;
		if (bloodthirst.isActive()) amount++;
		raidbuffs = new RaidBuff[amount];
		amount = 0;
		if (empoweringt4.isActive()) {
			raidbuffs[amount] = empoweringt4;
			amount++;
		}
		if (empoweringaura.isActive()) {
			raidbuffs[amount] = empoweringaura;
			amount++;
		}
		if (voidpact.isActive()) {
			raidbuffs[amount] = voidpact;
			amount++;
		}
		if (pyrokinetict4.isActive()) {
			raidbuffs[amount] = pyrokinetict4;
			amount++;
		}
		if (dualfire.isActive()) {
			raidbuffs[amount] = dualfire;
			amount++;
		}
		if (bloodthirst.isActive()) {
			raidbuffs[amount] = bloodthirst;
			amount++;
		}		
	}

	
	public int getMaxtime() {
		return maxtime;
	}
	//set maxtime for combat
	public void setMaxtime(int maxtime) {
		this.maxtime = maxtime;
	}
	
	public WildstarMob getTarget() {
		return target;
	}
	
	public WildstarClass getPlayer() {
		return wildclass;
	}
	
	public int getCurrTime() {
		return currtime;
	}
	
	public float getDmgOverall() {
		return dmgoverall;
	}
	
	
	//raidbuffs/raiddebuffs getter
	public RaidDebuff getPunish() {
		return punish;
	}
	public RaidDebuff getArmorRed() {
		return armorreduction;
	}
	public RaidDebuff getReduceAllRes() {
		return reduceallresist;
	}
	public RaidDebuff getReducePhysRes() {
		return reducephysresist;
	}
	public RaidDebuff getReduceMagRes() {
		return reducemagresist;
	}
	public RaidDebuff getReduceTechRes() {
		return reducetechresist;
	}
	public RaidDebuff getReduceDeflect() {
		return reducedeflect;
	}
	
	public RaidBuff getPowerLinkT4() {
		return powerlinkt4;
	}
	public RaidBuff getPowerLink() {
		return powerlink;
	}
	public RaidBuff getEmpowering() {
		return empowering;
	}
	public RaidBuff getEmpoweringT4() {
		return empoweringt4;
	}
	public RaidBuff getEmpoweringAura() {
		return empoweringaura;
	}
	public RaidBuff getVoidPact() {
		return voidpact;
	}
	public RaidBuff getSurgical() {
		return surgical;
	}
	public RaidBuff getPyroKineticT4() {
		return pyrokinetict4;
	}
	public RaidBuff getDualFire() {
		return dualfire;
	}
	public RaidBuff getBloodThirst() {
		return bloodthirst;
	}

}


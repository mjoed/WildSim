package classes.stalker;

import helpers.helpers;
import classes.*;
import classes.stalker.abilities.*;
import classes.stalker.amps.*;
import classes.stalker.buffs.*;

public class Stalker implements WildstarClass {
	
	
	boolean combatlogressource = false;
	int SuitPower;
	float ap;
	float baseap;
	float sp;
	float basesp;
	float crit;
	float basecrit;
	float critsev;
	float basecritsev;
	float strikethrough;
	float basestrikethrough;
	float cdr;
	float armorPierce;
	float basearmorPierce;
	
	float flatdamagebuff;
	
	int totalSPgain;
	
	//raidbuffs
	RaidBuff[] raidbuffs;
	
	//all buffs
	Buff[] buffs;
	
	//all debuffs
	Debuff[] debuffs;
	
	//all abilities
	Ability[] abilities;
	
	//all amps
	AMP[] amps;
	
	//amps
	Cutthroat cutthroat;
	AMP enabler;
	AMP devastateamp;
	AMP stealthmastery;
	AMP unfairadvantage;
	AMP riposte;
	AMP fatalwounds;
	AMP onslaught;
	AMP battlemastery;
	AMP killerinstinct;
	
	//amp abilities/dmg sources
	Ability cutthroathit;
	Ability fatalwoundshit;
	Devastate devastate;
	
	//abilities
	Ability tretreat;
	Ability innate;
	Ability punish;
	Ability shred;
	Ability impale;
	AnalyzeWeakness aw;
	Ability ck;
	Ability ckfirst;
	Ability ckaddhits;
	Ability ruin;
	Ability ruindot;
	Ability collapse;
	Ability stagger;
	Ability shredaddhits;
	Preparation prep;
	
	//stalker specific buffs/debuffs/dots
	Buff enablerbuff;
	Buff ckcd;
	Buff punishproc;
	Buff shredbuff;
	Buff awbuff;
	Buff ruinbuff;
	Buff prepbuff;
	Buff ripostebuff;
	Buff fatalwoundsdot;
	Buff onslaughtbuff;
	Buff battlemasterybuff;
	Buff killerinstinctbuff;
	
	//innate/gadget ability
	Buff guarantcrit;
	
	//buff uptimes for suit power regens (and maybe other stuff?) TODO move to buffs themselves.. maybe.
	int shreduptime = 0;
	int awbuffuptime = 0;
	int ruinbuffuptime = 0;
	int fatalwoundhitsleft = 0;
	
	
	
	//testvariables
	
	
	public Stalker(float ap, float sp, float crit, float critsev, float strikethrough, float cdr, float armorPierce) {
		this.ap = ap;
		baseap = ap;
		this.sp = sp;
		basesp = sp;
		this.crit = crit;
		basecrit = crit;
		this.critsev = critsev;
		basecritsev = critsev;
		this.strikethrough = strikethrough;
		basestrikethrough = strikethrough;
		this.cdr = cdr;
		this.armorPierce = armorPierce;
		basearmorPierce = armorPierce;
		
		SuitPower = 100;

		//AMP
		cutthroat = new Cutthroat(true);
		cutthroathit = new CutthroatHit(true);
		enabler = new Enabler(true);
		devastateamp = new DevastateAMP(true);
		devastate = new Devastate(true);
		stealthmastery = new StealthMastery(false);
		unfairadvantage = new UnfairAdvantage(true);
		riposte = new Riposte(true);
		fatalwounds = new FatalWoundsAMP(true);
		fatalwoundshit = new FatalWounds(true);
		onslaught = new Onslaught(true);
		battlemastery = new BattleMastery(false);
		killerinstinct = new KillerInstinct(false);
		
		//abilities
		punish = new Punish(8, true);
		shred = new Shred(0, true);
		shredaddhits = new ShredAddHits(0, true);
		impale = new Impale(8, true);
		aw = new AnalyzeWeakness(0, true);
		ck = new ConcussiveKicks(8, true);
		ckfirst = new ConcussiveKicksFirst(8, true);
		ckaddhits = new ConcussiveKicksAddHits(8, true);
		ruin = new Ruin(0, false);
		ruindot = new RuinDot(0, false);
		collapse = new Collapse(0, false);
		stagger = new Stagger(0, false);
		prep = new Preparation(0, true);
		
		tretreat = new TacticalRetreat(true);
		innate = new Innate(true);
		
		checkForAMPsBuffs();
		
		//CDR handling
		checkCDReduction();
		
		if (stealthmastery.isActive()) {
			innate.setCooldown(innate.getCooldown() - 3000);
		}
		
		fillAbilityArray();
		fillBuffArray();		
		fillAMPArray();
		
	}
	

	private void checkCDReduction() {
		if (cdr > 0) {
			punish.setCooldown((int)(punish.getCooldown() * (1-cdr)));
			ck.setCooldown((int)(ck.getCooldown() * (1-cdr)));
			aw.setCooldown((int)(aw.getCooldown() * (1-cdr)));
			tretreat.setCooldown((int)(tretreat.getCooldown() * (1-cdr)));
			ruin.setCooldown((int)(ruin.getCooldown() * (1-cdr)));
			collapse.setCooldown((int)(collapse.getCooldown() * (1-cdr)));
			stagger.setCooldown((int)(stagger.getCooldown() * (1-cdr)));
			prep.setCooldown((int)(prep.getCooldown() * (1-cdr)));
		}
	}


	private void checkForAMPsBuffs() {
		//amp abilities/dmg sources
		cutthroathit.setActive(cutthroat.isActive());
		devastate.setActive(devastateamp.isActive());
		fatalwoundshit.setActive(fatalwounds.isActive());
		//buffs/debuffs
		enablerbuff = enabler.isActive() ? new EnablerBuff() : null;
		ripostebuff = riposte.isActive() ? new RiposteBuff() : null;
		if (ck.isActive() && ck.getTier() == 8) {
			ckcd = new ConcussiveKicksCooldown();
		} else {
			ckcd = null;
		}
		punishproc = punish.isActive() ? new PunishProc() : null;
		guarantcrit = new GuaranteedCrit();
		if (shred.isActive() && shred.getTier() == 8) {
			shredbuff = new ShredBuff();
		} else {
			shredbuff = null;
		}
		if (aw.isActive() && aw.getTier() >= 4){
			awbuff = new AWBuff();
		} else {
			awbuff = null;
		}
		if (ruin.isActive() && ruin.getTier() >= 4) {
			ruinbuff = new RuinBuff();
		} else {
			ruinbuff = null;
		}
		prepbuff = prep.isActive() ? new PreparationBuff() : null;
		fatalwoundsdot = fatalwounds.isActive() ? new FatalWoundsDot() : null;
		onslaughtbuff = onslaught.isActive() ? new OnslaughtBuff() : null;
		battlemasterybuff = battlemastery.isActive() ? new BattleMasteryBuff() : null;
		killerinstinctbuff = killerinstinct.isActive() ? new KillerInstinctBuff() : null;
	}


	@Override
	public Ability getNextNonGCDAbility() {
		checkBuffs();
		
		if (shred.isActive() && shred.getCurrentCD() == 666 || shred.getCurrentCD() == 333) {
			//TODO reduce currentcd to avoid loop.. might want to change that.
			shred.redCDC();
			return shredaddhits;
		}
		
		//ruindot handling
		if (ruindot.isActive() && ruindot.isReady(this)) {
			ruindot.redCDC();
			return ruindot;
		}
		
		//fatalwounds handling
		if (fatalwoundhitsleft > 0) {
			fatalwoundhitsleft--;
			return fatalwoundshit;
		}
		
		//devastate handling
		if (devastateamp.isActive() && devastate.isTriggered()) {
			devastate.trigger(false);
			return devastate;
		}
		
		//full prep channel handling
		if (prep.isActive() && prep.completeChannel() && prep.channelOnCD()) {
			if (prep.isChanneling()) {
				return null;
			}
			if (prep.isReady(this)) {
				prep.startChanneling();
				return prep;
			}
		}
			
		
		
		//AW handlichng
		//apply aw if off CD, set cooldown manually
		if (aw.isActive() && aw.isReady(this)) {
			aw.applied(true);
			aw.setCurrentCD(aw.getCooldown());
		}
		//AW hit if applied and triggered
		if (aw.isActive() && aw.isTriggered()) {
			aw.applied(false);
			aw.triggered(false);
			if (aw.getTier() >= 4) awbuff.apply();
			return aw;
		}
		
		//weaving into shred
		if (shred.isActive() && shred.getCurrentCD() == 1000) {
			if (collapse.isActive() && collapse.isReady(this)) return collapse;
			if (stagger.isActive() && stagger.isReady(this)) return stagger;
			if (prep.isActive() && prep.isReady(this)) {
				prep.startChanneling();
				if (prep.completeChannel()) {
					return prep;
				}
			}
		}
					
		//TODO check for 2nd CK dmg ticks
		if (ck.isActive() && ck.getCurrentCD() == (ck.getCooldown() - 300)) {
			ck.redCDC();
			return ckaddhits;
		}
		if (ckfirst.isActive() && ckfirst.getCurrentCD() == 300) {
			ckfirst.redCDC();
			return ckaddhits;
		}
		
		
		//punish
		if (punish.isActive() && punish.isReady(this)) return punish;
		
		//check for cutthroat stacks, hit cutthroat if at 10
		if (cutthroat.isActive() && cutthroat.getStacks() > 9) {
			return cutthroathit;
		}
		
		return null;
	}
	
	
	
	
	
	
	@Override
	public Ability getNextGCDAbility() {
	
		Ability returnAbility = null;
		

		if (shred.isActive() && shred.isReady(this)) returnAbility = shred;
		if (ck.isActive() && ck.isReady(this) && ck.getTier() < 8) returnAbility = ck;
		if (ckfirst.isActive() && ckfirst.isReady(this) && ckfirst.getTier() < 8) returnAbility = ckfirst;
		if (ruin.isActive() && ruin.isReady(this)) returnAbility = ruin;
		if (impale.isActive() && impale.isReady(this)) returnAbility = impale;
		if (ck.isActive() && ck.isReady(this) && ck.getTier() == 8) returnAbility = ck;
		if (ckfirst.isActive() && ckfirst.isReady(this) && ckfirst.getTier() == 8) returnAbility = ckfirst;
		
		if (returnAbility != null) {
			if (enabler.isActive() && SuitPower > 35 && (SuitPower - returnAbility.getCost()) < 35 && enablerbuff.durationLeft() == 0) {
				enablerbuff.apply();
			}
			returnAbility.beforeHit(this);
			checkBuffs();
			if (returnAbility.getName() == "Shred" && returnAbility.getTier() == 8) shredbuff.apply();
			if (returnAbility.getName() == "Ruin" && returnAbility.getTier() >= 4) ruinbuff.apply();
		}
		
		return returnAbility;
	}
	
	
	
	
	
	
	@Override
	public void afterTick(int currtime) {
		//innate suitpower regen handling
		//7sp/sec = every 142,8571 ms 1sp. taking 143ms, 0,14285ms difference, 1ms every second. compensating every 143 seconds by giving 1 additional sp.
		if (currtime%143 == 0) {
			if (currtime%143000 == 0) {
//				if (combatlogressource) {
//					System.out.println("[" + currtime + "] " + "added additional 1 SP gain to compensate");
//				}
				addSuitPower(1);
			}
			
			addSuitPower(1);
//			if (combatlogressource) {
//				System.out.println("[" + currtime + "] " + "gained 1 SP. Total SP gain: " + totalSPgain);
//			}
		}
		
		//enabler suitpower regen handling
		if (enablerbuff != null && enablerbuff.isActive()) {
			if (enablerbuff.durationLeft() % 333 == 0 && enablerbuff.durationLeft() != 3000) {
				if (combatlogressource) System.out.println("[" + helpers.msToString(currtime) + "] " + "[Ressource: " + getRessource() + "] " + "Enabler tick - +1 SP!");
				addSuitPower(1);
			}
		}
		
		//shred suitpower regen handling		
		if (shred.isActive() && shred.getTier() == 8) {
			
			if (shredbuff.isActive()) {
				shreduptime += 1;
			}
			
			if (!shredbuff.isActive()) shreduptime = 0;
			
			if (shreduptime == 1000) {
				if (shredbuff.getStacks() == 2) {
					if (combatlogressource) System.out.println("[" + helpers.msToString(currtime) + "] " + "[Ressource: " + getRessource() + "] " + "ShredBuff (Invigorate) tick - +1 SP!");
					addSuitPower(1);
				}
				if (combatlogressource) System.out.println("[" + helpers.msToString(currtime) + "] " + "[Ressource: " + getRessource() + "] " + "ShredBuff (Invigorate) tick - +1 SP!");
				addSuitPower(1);
				shreduptime = 0;
			}
		}
		
		//awbuff suitpower regen handling
		if (aw.isActive() && aw.getTier() >= 4) {
			if (awbuff.isActive()) {
				awbuffuptime += 1;
			}
			
			if (!awbuff.isActive()) awbuffuptime = 0;
			
			if (awbuffuptime == 500) {
				if (combatlogressource) System.out.println("[" + helpers.msToString(currtime) + "] " + "[Ressource: " + getRessource() + "] " + "AW Buff tick - +1 SP!");
				addSuitPower(1);
				awbuffuptime = 0;
			}
		}
		
		//ruin suitpower regen handling
		if (ruin.isActive() && ruin.getTier() >= 4) {
			if (ruinbuff.isActive()) {
				ruinbuffuptime += 1;
			}
			
			if (!ruinbuff.isActive()) ruinbuffuptime = 0;
			
			if (ruinbuffuptime == 500) {
				if (combatlogressource) System.out.println("[" + helpers.msToString(currtime) + "] " + "[Ressource: " + getRessource() + "] " + "Ruin Buff tick - +1 SP!");
				addSuitPower(1);
				ruinbuffuptime = 0;
			}
		}
		
		//prep suitpower regen handling
		if (prep.isActive() && prep.isChanneling() && prep.getChannelTime() % 500 == 0) {
			prepbuff.apply();
			if (combatlogressource) System.out.println("[" + helpers.msToString(currtime) + "] " + "[Ressource: " + getRessource() + "] " + "Prep Buff tick - +7 SP!");
			addSuitPower(7);
		}
		
		//fatalwounds handling
		if (fatalwounds.isActive() && fatalwoundsdot.isActive()) {
			if (currtime % 1000 == 0) {
				fatalwoundhitsleft = fatalwoundsdot.getStacks();
			}
		}
		
		//battlemastery handling
		if (battlemastery.isActive()) {
			if (SuitPower < 30) {
				battlemasterybuff.apply();
			} else {
				battlemasterybuff.remove();
			}
		}
		
		//handling buffs/debuffs
		checkBuffs();
		
		//preparation/channling handling
		if (prep != null && prep.isChanneling()) prep.channelAbility();
		
		//reducing ability cds
		for (int i = 0; i < abilities.length; i++) {
			if (abilities[i] != null && abilities[i].getCurrentCD() > 0) abilities[i].redCDC();
		}
		
		//reducing buff durations
		for (int i = 0; i < buffs.length; i++) {
			if (buffs[i] != null && buffs[i].durationLeft() > 0) buffs[i].reduceCurrDuration();
		}
		
	}
	
	
	
	
	
	
	@Override
	public void afterHit(Ability ability, boolean crit, boolean deflect, float damage) {
		
		reduceSuitPower(ability.getCost());
		ability.afterHit(this);
				
		if (!crit && !deflect) {
			if (ability.getName() == "CK(first)" || ability.getName() == "CK(add)") {
				ck.addHit(damage);
			} else if (ability.getName() == "Shred(add)") {
				shred.addHit(damage);
			} else {
				ability.addHit(damage);
			}
		}
		if (crit) {
			if (ability.getName() == "CK(first)" || ability.getName() == "CK(add)") {
				ck.addCrit(damage);
			} else if (ability.getName() == "Shred(add)") {
				shred.addCrit(damage);
			} else {
				ability.addCrit(damage);
			}
			if (ability.getName() != "RuinDot") {
				if (punish.isActive()) punishproc.apply();
				//TODO devastate handling, just triggers 25% of the time until better implementation
				if (devastateamp.isActive() && ability.getName() != "CutthroatHit") {
					double devastateroll = Math.random();
					if (devastateroll <= 0.25) {
						devastate.trigger(true);
					}
				}
				if (fatalwounds.isActive() && ability.getName() != "CutthroatHit") fatalwoundsdot.apply();
				if (killerinstinct.isActive() && killerinstinctbuff.isActive()) killerinstinctbuff.remove();
			}
		}
		if (deflect) {
			if (ability.getName() == "CK(first)" || ability.getName() == "CK(add)") {
				ck.addDeflect();
			} else if (ability.getName() == "Shred(add)") {
				shred.addDeflect();
			} else {
				ability.addDeflect();
			}
			if (riposte.isActive()) ripostebuff.apply();
		}
		
		//if hit is a dot, do nothing else.
		if (ability.getName() == "RuinDot" || ability.getName() == "FatalWounds") {
			return;
		}
		
		//if cutthroat, just remove cutthroat stacks (cutthroat hits don't trigger devastate or fatal wounds, but do trigger punishproc (carbine please :( )
		if (cutthroat.isActive() && ability.getName() == "CutthroatHit") {
			cutthroat.removeStacks();
			return;
		}
		
		//TODO check "== 0" is for realising single dmg ticks from multiple-swing-abilities and AW.. probably not a very good way to handle it.
		if (ability.getCurrentCD() == 0) {
			ability.setCurrentCD(ability.getCooldown());
		}
		
		if (guarantcrit.isActive()) {
			guarantcrit.remove();
		}

		//aw tier8 handling (50% chance to reduce cd by 2.25sec)
		
		if (ability.getName() == "AW" && ability.getTier() == 8) {
			double awroll = Math.random();
			if (awroll <= 0.5) {
				ability.setCurrentCD((ability.getCurrentCD() - 2250));
			}
		}
		
		//ck cooldown buff handling
		if ((ability.getName() == "CK" || ability.getName() == "CK(first)") && ability.getCurrentCD() > 0) {
			if (ckcd.isActive()) {
				ckcd.remove();
			} else {
				ckcd.apply();
			}
		}
		
		//prep interrupt logic
		if (ability.getName() != "CutthroatHit" && ability.getName() != "AW" && ability.getName() != "Shred(add)" && ability.getName() != "Preparation") {
			if (prep != null && prep.isChanneling()) {
				prep.stopChanneling();
				prep.setCurrentCD(prep.getCooldown());
			}
		}
		
		if (!deflect) {
			//add cutthroat if hit isn't AW. trigger AW if AW buff is applied.
			if (ability.getName() != "AW") {
				if (aw != null && aw.isApplied()) {
					aw.triggered(true);
				}
				if (cutthroat.isActive()) cutthroat.addStack();
			}
			
			//apply killerinstinct buff at all first hits
			if (killerinstinct.isActive()) {
				if (ability.getName() != "Shred(add)" || ability.getName() != "CK(add)" || ability.getName() != "AW") {
					killerinstinctbuff.apply();
				}
			}
			
			//apply onslaught buff at any hit
			if (onslaught.isActive()) onslaughtbuff.apply();
			
			//ruin dot handling
			if (ability.getName() == "Ruin") {
				ruindot.setCurrentCD(ruindot.getCooldown());
			}
			
			//if CK tier8, reduce punish/aw cooldowns by 2 seconds
			if ((ability.getName() == "CK" || ability.getName() == "CK(first)") && ability.getTier() == 8) {
				aw.setCurrentCD((aw.getCurrentCD() - 2000));
				punish.setCurrentCD((punish.getCurrentCD() - 2000));
			}
			
			//TODO 45SP at tier 8, 30 otherwise. punish adding suit power when deflected????
			if (ability.getName() == "Punish") {
				punishproc.remove();
				if (ability.getTier() == 8) {
					addSuitPower(45);
				} else {
					addSuitPower(30);
				}
				return;
			}
		}
	}
	
	
	
	
	
	//helper methods for suitpower handling
	public void reduceSuitPower(int amount) {
		SuitPower -= amount;
		
		if (SuitPower < 0) {
			SuitPower = 0;
		}
	}
	
	public void addSuitPower(int amount) {
		SuitPower += amount;
		
		if (SuitPower > 100) {
			SuitPower = 100;
			return;
		}
		
		totalSPgain += amount;
	}
	
	//checks buffs, is called every tick and after/before every hit.
	public void checkBuffs() {
		
		crit = basecrit;
		strikethrough = basestrikethrough;
		ap = baseap;
		sp = basesp;
		flatdamagebuff = 0;
		
		//check if guaranteed crit is active
		if (guarantcrit != null && guarantcrit.isActive()) {
			crit = 1;
		}
		
		//check for prepbuff
		if (prepbuff != null && prepbuff.isActive()) {
			crit += (prepbuff.getStacks() * 0.03f);
		}
		
		//check for killer instinct
		if (killerinstinctbuff != null && killerinstinctbuff.isActive()) {
			crit += (killerinstinctbuff.getStacks() * 0.01f);
		}
		
		//check for riposte
		if (ripostebuff != null && ripostebuff.isActive()) {
			strikethrough += 0.06f;
		}
		
		if (onslaughtbuff != null && onslaughtbuff.isActive()) {
			ap *= 1.12;
		}
		
		if (battlemasterybuff != null && battlemasterybuff.isActive()) {
			flatdamagebuff += 0.08f;
		}
		
		double chance = Math.random();
		
		for (int i = 0; i < raidbuffs.length; i++) {
			if (raidbuffs[i].isActive() && raidbuffs[i].getName() == "EmpoweringProbesT4" && raidbuffs[i].getUptime() >= chance) {
				crit += raidbuffs[i].getAmount();
				strikethrough += raidbuffs[i].getAmount();
			}
			if (raidbuffs[i].isActive() && raidbuffs[i].getName() == "EmpoweringAura" && raidbuffs[i].getUptime() >= chance) {
				crit += raidbuffs[i].getAmount();
			}
			if (raidbuffs[i].isActive() && raidbuffs[i].getName() == "VoidPact" && raidbuffs[i].getUptime() >= chance) {
				ap *= (1+raidbuffs[i].getAmount());
			}
			if (raidbuffs[i].isActive() && raidbuffs[i].getName() == "PyrokineticFlameT4" && raidbuffs[i].getUptime() >= chance) {
				ap *= (1+raidbuffs[i].getAmount());
				sp *= (1+raidbuffs[i].getAmount());
			}
			if (raidbuffs[i].isActive() && raidbuffs[i].getName() == "DualFireT8" && raidbuffs[i].getUptime() >= chance) {
				strikethrough += raidbuffs[i].getAmount();
			}
			if (raidbuffs[i].isActive() && raidbuffs[i].getName() == "BloodThirstT4" && raidbuffs[i].getUptime() >= chance) {
				ap *= (1+raidbuffs[i].getAmount());
			}
			
		}
		
	}
	
	
	
	
	
	private void fillBuffArray() {
		int amount = 0;
		if (ckcd != null) amount++;
		if (punishproc != null) amount++;
		if (guarantcrit != null) amount++;
		if (awbuff != null) amount++;
		if (shredbuff != null) amount++;
		if (ruinbuff != null) amount++;
		if (enablerbuff != null) amount++;
		if (prepbuff != null) amount++;
		if (ripostebuff != null) amount++;
		if (fatalwoundsdot != null) amount++;
		if (onslaughtbuff != null) amount++;
		if (battlemasterybuff != null) amount++;
		if (killerinstinctbuff != null) amount++;
		
		buffs = new Buff[amount];
		amount = 0;
		
		if (ckcd != null) {
			buffs[amount] = ckcd;
			amount++;
		}
		if (punishproc != null) {
			buffs[amount] = punishproc;
			amount++;
		}
		if (guarantcrit != null) {
			buffs[amount] = guarantcrit;
			amount++;
		}
		if (awbuff != null) {
			buffs[amount] = awbuff;
			amount++;
		}
		if (shredbuff != null) {
			buffs[amount] = shredbuff;
			amount++;
		}
		if (ruinbuff != null) {
			buffs[amount] = ruinbuff;
			amount++;
		}
		if (enablerbuff != null) {
			buffs[amount] = enablerbuff;
			amount++;
		}
		if (prepbuff != null) {
			buffs[amount] = prepbuff;
			amount++;
		}
		if (ripostebuff != null) {
			buffs[amount] = ripostebuff;
			amount++;
		}
		if (fatalwoundsdot != null) {
			buffs[amount] = fatalwoundsdot;
			amount++;
		}
		if (onslaughtbuff != null) {
			buffs[amount] = onslaughtbuff;
			amount++;
		}
		if (battlemasterybuff != null) {
			buffs[amount] = battlemasterybuff;
			amount++;
		}
		if (killerinstinctbuff != null) {
			buffs[amount] = killerinstinctbuff;
			amount++;
		}
		
	}





	private void fillAbilityArray() {
		int amount = 0;
		if (impale.isActive()) amount++;
		if (punish.isActive()) amount++;
		if (aw.isActive()) amount++;
		if (shred.isActive()) amount++;
		if (ck.isActive()) amount++;
		if (ckfirst.isActive()) amount++;
		if (ckaddhits.isActive()) amount++;
		if (innate.isActive()) amount++;
		if (tretreat.isActive()) amount++;
		if (ruin.isActive()) amount++;
		if (ruindot.isActive()) amount++;
		if (collapse.isActive()) amount++;
		if (stagger.isActive()) amount++;
		if (shredaddhits.isActive()) amount++;
		if (prep.isActive()) amount++;
		if (cutthroathit.isActive()) amount++;
		if (devastate.isActive()) amount++;
		if (fatalwoundshit.isActive()) amount++;
		
		abilities = new Ability[amount];
		amount = 0;
		
		if (impale.isActive()) {
			abilities[amount] = impale;
			amount++;
		}
		if (punish.isActive()) {
			abilities[amount] = punish;
			amount++;
		}
		if (aw.isActive()) {
			abilities[amount] = aw;
			amount++;
		}
		if (shred.isActive()) {
			abilities[amount] = shred;
			amount++;
		}
		if (cutthroathit.isActive()) {
			abilities[amount] = cutthroathit;
			amount++;
		}
		if (ck.isActive()) {
			abilities[amount] = ck;
			amount++;
		}
		if (ckfirst.isActive()) {
			abilities[amount] = ckfirst;
			amount++;
		}
		if (ckaddhits.isActive()) {
			abilities[amount] = ckaddhits;
			amount++;
		}
		if (innate.isActive()) {
			abilities[amount] = innate;
			amount++;
		}
		if (tretreat.isActive()) {
			abilities[amount] = tretreat;
			amount++;
		}
		if (ruin.isActive()) {
			abilities[amount] = ruin;
			amount++;
		}
		if (ruindot.isActive()) {
			abilities[amount] = ruindot;
			amount++;
		}
		if (collapse.isActive()) {
			abilities[amount] = collapse;
			amount++;
		}
		if (stagger.isActive()) {
			abilities[amount] = stagger;
			amount++;
		}
		if (shredaddhits.isActive()) {
			abilities[amount] = shredaddhits;
			amount++;
		}
		if (prep.isActive()) {
			abilities[amount] = prep;
			amount++;
		}
		if (devastate.isActive()) {
			abilities[amount] = devastate;
			amount++;
		}
		if (fatalwoundshit.isActive()) {
			abilities[amount] = fatalwoundshit;
			amount++;
		}
		
	}





	private void fillAMPArray() { 
		int amount = 0;
		if (cutthroat.isActive()) amount++;
		if (enabler.isActive()) amount++;
		if (devastateamp.isActive()) amount++;
		if (stealthmastery.isActive()) amount++;
		if (unfairadvantage.isActive()) amount++;
		if (riposte.isActive()) amount++;
		if (fatalwounds.isActive()) amount++;
		if (onslaught.isActive()) amount++;
		if (battlemastery.isActive()) amount++;
		if (killerinstinct.isActive()) amount++;
		
		amps = new AMP[amount];
		amount = 0;
		if (cutthroat.isActive()) {
			amps[amount] = cutthroat;
			amount++;
		}
		if (enabler.isActive()) {
			amps[amount] = enabler;
			amount++;
		}
		if (devastateamp.isActive()) {
			amps[amount] = devastateamp;
			amount++;
		}
		if (stealthmastery.isActive()) {
			amps[amount] = stealthmastery;
			amount++;
		}
		if (unfairadvantage.isActive()) {
			amps[amount] = unfairadvantage;
			amount++;
		}
		if (riposte.isActive()) {
			amps[amount] = riposte;
			amount++;
		}
		if (fatalwounds.isActive()) {
			amps[amount] = fatalwounds;
			amount++;
		}
		if (onslaught.isActive()) {
			amps[amount] = onslaught;
			amount++;
		}
		if (battlemastery.isActive()) {
			amps[amount] = battlemastery;
			amount++;
		}
		if (killerinstinct.isActive()) {
			amps[amount] = killerinstinct;
			amount++;
		}

	}
	
	//setters/getters
	
	//get abilities
	public Ability[] getAbilities() {
		return abilities;
	}
	
	//get buffs
	public Buff[] getBuffs() {
		return buffs;
	}
	
	//get amps
	public AMP[] getAMPs() {
		return amps;
	}
	
	@Override
	public int getRessource() {
		return SuitPower;
	}
	
	@Override
	public float getFlatDamageBuff() {
		return flatdamagebuff;
	}
	
	@Override
	public void setAP(float ap) {
		this.ap = ap;
		baseap = ap;
	}

	@Override
	public float getAP() {
		return ap;
	}
	
	@Override
	public void setSP(float sp) {
		this.sp = sp;
		basesp = sp;
	}

	@Override
	public float getSP() {
		return sp;
	}

	@Override
	public void setCrit(float crit) {
		this.crit = crit;
		basecrit = crit;
	}

	@Override
	public float getCrit() {
		return crit;
	}

	@Override
	public void setCritSev(float critsev) {
		this.critsev = critsev;	
		basecritsev = critsev;
	}

	@Override
	public float getCritSev() {
		return critsev;
	}

	@Override
	public void setStrikethrough(float strikethrough) {
		this.strikethrough = strikethrough;
		basestrikethrough = strikethrough;
	}

	@Override
	public float getStrikethrough() {
		return strikethrough;
	}

	@Override
	public void setArmorPierce(float armorPierce) {
		this.armorPierce = armorPierce;
		basearmorPierce = armorPierce;
	}

	@Override
	public float getArmorPierce() {
		return armorPierce;
	}

	@Override
	public void setCDReduction(float cdr) {
		this.cdr = cdr;
		checkCDReduction();
	}

	@Override
	public float getCDReduction() {
		return cdr;
	}	
	
	public void setRaidBuffs(RaidBuff[] raidbuffs) {
		this.raidbuffs = raidbuffs;
	}
	
	
	//abilities getter/setter
	public Ability getImpale() {
		return impale;
	}
	public void setImpaleTier(int tier) {
		impale.setTier(tier);
		checkForAMPsBuffs();
	}
	
	public Ability getShred() {
		return shred;
	}
	public Ability getShredAdd() {
		return shredaddhits;
	}
	public void setShredTier(int tier) {
		shred.setTier(tier);
		shredaddhits.setTier(tier);
		checkForAMPsBuffs();
	}
	
	public Ability getCK() {
		return ck;
	}
	public Ability getCKFirst() {
		return ckfirst;
	}
	public Ability getCKadd() {
		return ckaddhits;
	}
	public void setCKTier(int tier) {
		ck.setTier(tier);
		ckfirst.setTier(tier);
		ckaddhits.setTier(tier);
		checkForAMPsBuffs();
	}
	
	public Ability getPunish() {
		return punish;
	}
	public void setPunishTier(int tier) {
		punish.setTier(tier);
		checkForAMPsBuffs();
	}
	
	public Ability getPreparation() {
		return prep;
	}
	public void setPreparationTier(int tier) {
		prep.setTier(tier);
		checkForAMPsBuffs();
	}
	
	public Ability getCollapse() {
		return collapse;
	}
	public void setCollapseTier(int tier) {
		collapse.setTier(tier);
		checkForAMPsBuffs();
	}
	
	public Ability getAW() {
		return aw;
	}
	public void setAWTier(int tier) {
		aw.setTier(tier);
		checkForAMPsBuffs();
	}
	
	public Ability getRuin() {
		return ruin;
	}
	public Ability getRuinDot() {
		return ruindot;
	}
	public void setRuinTier(int tier) {
		ruin.setTier(tier);
		ruindot.setTier(tier);
		checkForAMPsBuffs();
	}
	
	public Ability getStagger() {
		return stagger;
	}
	public void setStaggerTier(int tier) {
		stagger.setTier(tier);
		checkForAMPsBuffs();
	}
	
	public Ability getTacticalRetreat() {
		return tretreat;
	}
	public void setTacticalRetreatTier(int tier) {
		tretreat.setTier(tier);
		checkForAMPsBuffs();
	}
	
	public Ability getInnate() {
		return innate;
	}
	
	//AMP getter/setter
	public AMP getCutthroat() {
		return cutthroat;
	}
	public void setCutthroat(boolean active) {
		cutthroat.setActive(active);
		checkForAMPsBuffs();
	}
	
	public AMP getEnabler() {
		return enabler;
	}
	public void setEnabler(boolean active) {
		enabler.setActive(active);
		checkForAMPsBuffs();
	}
	
	public AMP getDevastate() {
		return devastateamp;
	}
	public void setDevastate(boolean active) {
		devastateamp.setActive(active);
		checkForAMPsBuffs();
	}
	
	public AMP getStealthMastery() {
		return stealthmastery;
	}
	public void setStealthMastery(boolean active) {
		stealthmastery.setActive(active);
		checkForAMPsBuffs();
	}
	
	public AMP getUnfairAdvantage() {
		return unfairadvantage;
	}
	public void setUnfairAdvantage(boolean active) {
		unfairadvantage.setActive(active);
		checkForAMPsBuffs();
	}
	
	public AMP getRiposte() {
		return riposte;
	}
	public void setRiposte(boolean active) {
		riposte.setActive(active);
		checkForAMPsBuffs();
	}
	
	public AMP getFatalWounds() {
		return fatalwounds;
	}
	public void setFatalWounds(boolean active) {
		fatalwounds.setActive(active);
		checkForAMPsBuffs();
	}
	
	public AMP getOnslaught() {
		return onslaught;
	}
	public void setOnslaught(boolean active) {
		onslaught.setActive(active);
		checkForAMPsBuffs();
	}
	
	public AMP getBattleMastery() {
		return battlemastery;
	}
	public void setBattleMastery(boolean active) {
		battlemastery.setActive(active);
		checkForAMPsBuffs();
	}
	
	public AMP getKillerInstinct() {
		return killerinstinct;
	}
	public void setKillerInstinct(boolean active) {
		killerinstinct.setActive(active);
		checkForAMPsBuffs();
	}
	
	//buff getter
	public Buff getCKCD() {
		return ckcd;
	}
	public Buff getGuarantCrit() {
		return guarantcrit;
	}
	public Buff getPunishProc() {
		return punishproc;
	}


	@Override
	public void lastCheck() {
		checkForAMPsBuffs();
		fillAbilityArray();
		fillBuffArray();		
		fillAMPArray();
		for (int i = 0; i < abilities.length; i++) {
			abilities[i].resetValues();
		}
	}
	
		
}

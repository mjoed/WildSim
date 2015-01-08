package combat;

import inout.Out;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import helpers.helpers;
import classes.Ability;
import classes.Buff;
import classes.WildstarClass;
import classes.stalker.Stalker;

public class CombatLog {
	
	Combat combat;
	StringBuilder combatlog;
	Stalker stalker;
	boolean bufflog = false;
	
	public CombatLog(Combat combat, WildstarClass wildclass) {
		this.combat = combat;
		combatlog = new StringBuilder();
		stalker = (Stalker)wildclass;
	}

	public void addAbilityHit(Ability ability, float dmg, boolean crit, boolean deflect) {
		if (combat.getCurrTime() < 300000) {
			if (deflect) {
				combatlog.append("[" + helpers.msToString(combat.getCurrTime()) + "] " + "[Ressource: " + stalker.getResource() + "] " + ability.getName() + " deflected" + System.lineSeparator());
			} else if (crit) {
				combatlog.append("[" + helpers.msToString(combat.getCurrTime()) + "] " + "[Ressource: " + stalker.getResource() + "] " + ability.getName() + " crits for: *" + dmg + "*" + System.lineSeparator());
			} else {
				combatlog.append("[" + helpers.msToString(combat.getCurrTime()) + "] " + "[Ressource: " + stalker.getResource() + "] " + ability.getName() + " hits for: " + dmg + System.lineSeparator());
			}
		}
	}
	
	public void addResourceEvent(String source, int amount) {
		if (combat.getCurrTime() < 300000) {
			combatlog.append("[" + helpers.msToString(combat.getCurrTime()) + "] " + "[Ressource: " + stalker.getResource() + "] " + source + " SP Reg: +" + amount + System.lineSeparator());
		}
	}
	
	public void addBuffEvent(Buff buff, boolean applied) {
		if (bufflog && combat.getCurrTime() < 300000) {
			if (applied) {
				combatlog.append("[" + helpers.msToString(combat.getCurrTime()) + "] " + "[Ressource: " + stalker.getResource() + "] " + buff.getName() + " applied (current Stacks: " + buff.getStacks() + ")" + System.lineSeparator());
			} else {
				combatlog.append("[" + helpers.msToString(combat.getCurrTime()) + "] " + "[Ressource: " + stalker.getResource() + "] " + buff.getName() + " fades" + System.lineSeparator());
			}
		}
	}
	
	
	public void addRunTime(String runtime) {
		combatlog.append("Run took " + runtime + "ms" + System.lineSeparator());
	}
	
	
	public void resetLog() {
		combatlog = new StringBuilder();
	}
	
	public void addBuffUptimes() {
		Buff[] buffs = stalker.getBuffs();
		
		combatlog.append(System.lineSeparator());
		
		for (int i = 0; i < buffs.length; i++) {
			if (buffs[i].getName() != "Concussive Kicks - Cooldown" && buffs[i].getName() != "Guaranteed Crit" && buffs[i].getName() != "FatalWoundsDot" && buffs[i].getName() != "PunishProc" && buffs[i].getName() != "OnslaughtBuff") {
				combatlog.append(buffs[i].getName() + " uptime: " + (((double)buffs[i].getUptime() * 100.0) / (double)combat.getMaxtime()) + "%" + System.lineSeparator());

			}
		}
	}
	
	
	public void saveLog() {
		addBuffUptimes();
		
		File file;
		
		DateFormat formatter = new SimpleDateFormat("HHmmssSSS");
		Date date = new Date(System.currentTimeMillis());
		String dateFormatted = formatter.format(date);
		
		file = new File(System.getProperty("user.dir") + "\\CombatLog" + dateFormatted + ".txt");
		
		if (file.exists()) {
			file.delete();
		}

		Out.open(file.getAbsolutePath());
		Out.print(combatlog.toString());
		Out.close();
		resetLog();
	}
	
	public void setBufflog(boolean bufflog) {
		this.bufflog = bufflog;
	}
	
	public boolean getBufflog() {
		return bufflog;
	}
	
}

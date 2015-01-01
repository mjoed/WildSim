package classes;

public class WildstarMob {
	
	//i THINK this are target dummy values (IF armor and resistance values are equal.) target dummy mitigation is ~26.7%, deflect ~11.25%
	//mitigation formula: mitigation = (armor+res) / (armor+res) + 12700
	//@mitigation = 0.267: armor+res = 12700 * 0,267 / 0,733  ----- armor+res = 4626,05729

	
	float deflectchance = 0.1120f;
	float deflectchancebase = 0.1120f;
	
	int level = 50;
	
	float armor = 2310;
	float physresistance = 2310;
	float techresistance = 2310;
	float magicresistance = 2310;
	
	float armorbase = 2310;
	float physresistancebase = 2310;
	float techresistancebase = 2310;
	float magicresistancebase = 2310;

	public float getDeflectchance() {
		return deflectchance;
	}

	public float getMitigation(int type) {
		if (type == 1) {
			return ((armor + physresistance) / ((armor + physresistance) + (250f * level + 200)));
		} else if (type == 2) {
			return ((armor + techresistance) / ((armor + techresistance) + (250f * level + 200)));
		} else if (type == 3) {
			return ((armor + magicresistance) / ((armor + magicresistance) + (250f * level + 200)));
		} else {
			return 0;
		}
	}

	public float getTechRes() {
		return techresistance;
	}
	
	public float getPhysRes() {
		return physresistance;
	}
	
	public float getMagRes() {
		return magicresistance;
	}
	
	public float getArmor() {
		return armor;
	}
	
	public void setTechRes(float techres) {
		techresistance = techres;
	}
	public void setTechResBase(float techres) {
		techresistancebase = techres;
	}
	
	public void setPhysRes(float physres) {
		physresistance = physres;
	}
	public void setPhysResBase(float physres) {
		physresistancebase = physres;
	}
	
	public void setMagRes(float magres) {
		magicresistance = magres;
	}
	public void setMagResBase(float magres) {
		magicresistancebase = magres;
	}
	
	public void setArmor(float armor) {
		this.armor = armor;
	}
	public void setArmorBase(float armor) {
		armorbase = armor;
	}

	public void setDeflectchance(float deflectchance) {
		if (deflectchance < 0) {
			this.deflectchance = 0;
		} else {
			this.deflectchance = deflectchance;
		}
	}
	public void setDeflectchanceBase(float deflectchance) {
		if (deflectchance < 0) {
			this.deflectchancebase = 0;
		} else {
			deflectchancebase = deflectchance;
		}
	}
	
	public void resetStats() {
		armor = armorbase;
		physresistance = physresistancebase;
		techresistance = techresistancebase;
		magicresistance = magicresistancebase;
		deflectchance = deflectchancebase;
	}
	
}

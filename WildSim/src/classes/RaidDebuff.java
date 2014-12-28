package classes;

public interface RaidDebuff {

	public String getName();
	public void setActive(boolean active);	
	public boolean isActive();
	
	public float getUptime();
	public void setUptime(float uptime);
	
	public float getAmount();
	public void setAmount(float amount);
	
}
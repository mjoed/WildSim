package classes;

public interface Debuff {

	public String getName();
	public boolean isActive();
	
	public void apply();
	public void remove();
	
	public void setDuration(int time);
	public int getDuration();
	
	public int durationLeft();
	
	public void reduceCurrDuration();
	
	public int getStacks();
}

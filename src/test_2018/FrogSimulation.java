package test_2018;

public class FrogSimulation{
	
	private int   goalDistance;
	private int   maxHops;
	private int   index;
	private int[] hopDistance;
	
	public FrogSimulation(int goalDistance, int maxHops, int[] hopDistance){
		this.goalDistance = goalDistance;
		this.maxHops = maxHops;
		this.hopDistance = hopDistance;
		this.index = 0;
	}
	
	private int hopDistance(){
		return hopDistance[index++];
	}
	
	public boolean simulate(){
		for(int position = 0, hopCount = 0; hopCount <= this.maxHops; hopCount++){
			if(position < 0){
				break;
			}else if(position < this.goalDistance){
				position += hopDistance();
			}else{
				return true;
			}
		}
		return false;
	}
	
	public double runSimulations(int num){
		int successAccum = 0;
		for(int test = 0; test < num; test++){
			if(simulate())
				successAccum++;
		}
		return successAccum / num;
	}
	
	public static void main(String[] args){
		int[]          hopDistance = { 5, 7, -2, 8, 6 };
		FrogSimulation simulation  = new FrogSimulation(24, 5, hopDistance);
		System.out.println(simulation.simulate());
	}
}

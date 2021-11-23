package RideData;

//stored data
public class Rides{

	public RideService savedData;
	
	public Rides(){
		//will be saving data as list
		savedData = new SaveAsList();
	}
	
}

package Data;

//stored data
public class Registrations{

	public DataService savedData;
	
	public Registrations(){
		//will be saving data as list
		savedData = new SaveAsList();
	}
	
}

package dummy;

public class InvokeSingleTon {

	public static void main(String[] args) {
		 
		
		SingleTon.getDriverInstance();
		SingleTon.getDriverInstance();
		SingleTon.getDriverInstance();
		SingleTon.deactivateDriverInstance();
		SingleTon.getDriverInstance();
		SingleTon.getDriverInstance();
		SingleTon.getDriverInstance();
		
	}
}

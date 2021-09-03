package cooperation;

public class TakeTrans {

	public static void main(String[] args) {
		Student james = new Student("James", 5000);
		Student tomas = new Student("Tomas", 10000);
		
		Bus bus100 = new Bus(100);
		james.takeBus(bus100);
		bus100.showInfo();
		
		Subway subwayGreen = new Subway(2);
		tomas.takeSubway(subwayGreen);
		james.takeSubway(subwayGreen);
		
		
		tomas.showInfo();
		james.showInfo();
		subwayGreen.showInfo();
	}

}

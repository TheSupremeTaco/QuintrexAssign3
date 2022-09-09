import java.time.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class App {
	public static void main (String[]args)
	{
		//Lambda Expression Examples
		interface Operator<T> {
			T process(T a, T b);
		}
		//Integer operator
		Operator<Integer> addOperation = (a,b) -> a + b;
		System.out.println(addOperation.process(3, 3));
		
		//String operator
		Operator<String> appendOperation = (a,b) -> a + b;
		System.out.println(appendOperation.process("3", "3"));
		
		//Integer Operator
		Operator<Integer> multOperation = (a,b) -> a *b;
		System.out.println(multOperation.process(3, 3));
		
		List<String> pointList = new ArrayList();
		System.out.println();
		
		//Stream Examples
		//Random numbers and only even filtered then printed
		Stream<Integer> randomNumbers = Stream
			.generate(() -> (new Random()).nextInt(50));
		randomNumbers.filter(s -> s %2 == 0)
			.limit(20).forEach(System.out::println);
		System.out.println();
		
		//Names of companies changed to upper-case
		List<String> companyNames = new ArrayList<>();
		companyNames.add("Chase");
		companyNames.add("Dunkin Donuts");
		companyNames.add("Starbucks");
		companyNames.add("Microsoft");
		companyNames.add("Seagate");
		companyNames.add("Comcast");
		companyNames.add("AT&T");
		companyNames.add("Google");
		
		companyNames.stream().filter((s) -> s.endsWith("T"))
			.map(String::toUpperCase)
			.forEach(System.out::println);
		System.out.println();
		companyNames.stream().map(String::toUpperCase)
			.filter((s) -> s.endsWith("T"))
			.forEach(System.out::println);
		System.out.println();
		
		//Finding first company starting with "C"
		String firstCompany = companyNames.stream()
				.filter((s) -> s.startsWith("C"))
				.findFirst()
					.get();
		System.out.println(firstCompany+"\n");
		
		//Finding the count of companies starting with "C"
		long totalCompanies = companyNames.stream()
				.filter((s) -> s.startsWith("C"))
				.count();
		System.out.println(totalCompanies+"\n");
		
		//Printing current time and time in other time zones
		OffsetDateTime offsetDateTime = OffsetDateTime.now();
		System.out.println(offsetDateTime.toString());  
		//8 hours ahead of current time
		offsetDateTime = offsetDateTime.plusHours(8);
		System.out.println(offsetDateTime);
		 
		ZonedDateTime zonedDateTime = 
		        ZonedDateTime.now(ZoneId.of("Asia/Aden"));
		System.out.println("Time in Asia/Aden: " + zonedDateTime.toString()); 
		
		zonedDateTime = 
		        ZonedDateTime.now(ZoneId.of("Europe/Paris"));
		System.out.println("Time in Europe/Paris: " + zonedDateTime.toString()); 
		
		zonedDateTime = 
		        ZonedDateTime.now(ZoneId.of("America/El_Salvador"));
		System.out.println("Time in America/El_Salvador: " + zonedDateTime.toString()); 
		
		//System.out.println(ZoneId.getAvailableZoneIds());
	}
	
}

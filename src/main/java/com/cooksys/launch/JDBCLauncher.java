package com.cooksys.launch;



import java.util.LinkedHashSet;
import java.util.Set;

public class JDBCLauncher {

	public static void main(String[] args) {
		//Person person = PersonDao.getById((long) 6);
		
		//person.setFirstname("First1");
		//person.setLastname("Last1");
		
		//PersonDao.update(person);
		Location newPersonLocation = new Location("City2","State2","Country2");//LocationDao.getById((long)3);
		
		Set<Interest> newPersonInterests = new LinkedHashSet();
		newPersonInterests.add(InterestDao.getById((long)6));
		newPersonInterests.add(InterestDao.getById((long)3));
		newPersonInterests.add(InterestDao.getById((long)2));
		
		
		Person newPerson = new Person("First8","Last8",88,newPersonLocation,newPersonInterests);
		
		PersonDao.save(newPerson);
		
		
		
		
		//To find people with similar Interest in same location enter interest id and location id
		
		
		//Set peopleWithSameInterest = PersonDao.findInterestGroup(2, 1);
		
		
		//Interest interest = InterestDao.getById((long)6);
		//interest.setTitle("Soccer");
		//InterestDao.update(interest);
		//Interest newInterest1 = new Interest("Horse Riding");
		//InterestDao.saveInterest(newInterest1);
		
		//Interest newInterest = new Interest((long)7,"hiking");
		//InterestDao.saveInterest(newInterest);
		
		//Location location = LocationDao.getById((long)3);
		//location.setCity("Oklahoma-City");
		//LocationDao.update(location);
		//Location newLocation = new Location((long)5,"Oxford","Mississippi","USA");
		//LocationDao.save(newLocation);
		
		
		//Interest

		//		1 -"Swimming"
		//		2 -"Tennis"
		//		3 -"Reading"
		//		4 -"Cooking"
		//		5 -"Running"
		//		6 -"Horse Riding"
		
		//Location
		//"1"	"Memphis"	"Tennessee"	"USA"
		//"2"	"Kansas City"	"Kansas"	"USA"
		//"3"	"Oklahoma City"	"Oklahoma"	"USA"
	}

	

}

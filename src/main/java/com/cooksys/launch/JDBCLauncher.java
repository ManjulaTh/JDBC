package com.cooksys.launch;



import java.util.Set;

public class JDBCLauncher {

	public static void main(String[] args) {
		//Person person = PersonDao.getById((long) 7);
		
		//person.setFirstname("First1");
		//person.setLastname("Last1");
		
		//PersonDao.update(person);
		
		//Person newPerson = new Person((long)9,"First8","Last8",88);
		
		//PersonDao.save(newPerson);
		
		
		//To find people with similar Interest in same location enter interest id and location id
		
		//		Interest

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
		Location newLocation = new Location((long)5,"Oxford","Mississippi","USA");
		LocationDao.save(newLocation);
	}

	

}

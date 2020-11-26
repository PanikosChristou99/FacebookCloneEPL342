/**
 * ekames mono sindesis tou event ke interests.
 */
package application;
import java.sql.Date;

import java.util.ArrayList;
public class User {
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String website;
	private String link;
	private Date birthday;
	private char gender;
	private ArrayList<String> workedFor;
	private ArrayList<String> educationPlaces;
	private ArrayList<String> quotes;
	private boolean isVerified;
	private Location hometown;
	private Location livesInLocation;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public ArrayList<String> getWorkedFor() {
		return workedFor;
	}

	public void setWorkedFor(ArrayList<String> workedFor) {
		this.workedFor = workedFor;
	}

	public ArrayList<String> getEducationPlaces() {
		return educationPlaces;
	}

	public void setEducationPlaces(ArrayList<String> educationPlaces) {
		this.educationPlaces = educationPlaces;
	}

	public ArrayList<String> getQuotes() {
		return quotes;
	}

	public void setQuotes(ArrayList<String> quotes) {
		this.quotes = quotes;
	}

	public boolean isVerified() {
		return isVerified;
	}

	public void setVerified(boolean isVerified) {
		this.isVerified = isVerified;
	}

	public Location getHometown() {
		return hometown;
	}

	public void setHometown(Location hometown) {
		this.hometown = hometown;
	}

	public Location getLivesInLocation() {
		return livesInLocation;
	}

	public void setLivesInLocation(Location livesInLocation) {
		this.livesInLocation = livesInLocation;
	}

	public User(int id, String firstName, String lastName, String email,
			String webiste, String link, Date birthday, char gender,
			ArrayList<String> workedFor, ArrayList<String> educationPlaces, 
			ArrayList<String> quotes,boolean isVerified, Location hometown, Location livesInLocation) {
		this.id=id;
		this.firstName=firstName;
		this.lastName=lastName;
		this.email=email;
		this.website=webiste;
		this.link=link;
		this.birthday=birthday;
		this.gender=gender;
		this.workedFor=workedFor;
		this.educationPlaces=educationPlaces;
		this.quotes=quotes;
		this.isVerified=isVerified;
		this.hometown=hometown;
		this.livesInLocation=livesInLocation;
	}
	
	

}
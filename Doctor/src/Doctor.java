/*
 * The attributes for the doctor object are identified as 
 * name,specialty,location,reviewSocre
 */
public class Doctor implements Comparable<Doctor> {
	private String name;
	private String specialty;
	private String location;
	private double reviewScore;

	public Doctor(String name, String specialty, String location, double reviewScore) {
		this.name = name;
		this.specialty = specialty;
		this.location = location;
		this.reviewScore = reviewScore;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public double getReviewScore() {
		return reviewScore;
	}

	public void setReviewScore(double reviewScore) {
		this.reviewScore = reviewScore;
	}

	public String getSpecialty() {
		return specialty;
	}

	public void setSpeciality(String specialty) {
		this.specialty = specialty;
	}

	@Override
	public String toString() {
		return "name=" + name + ", specialty=" + specialty + ", location=" + location + ", reviewScore=" + reviewScore
				+ "\n";
	}

	@Override
	// To sort doctor objects in the descending order of reviewScore
	public int compareTo(Doctor doctor) {
		if (doctor.reviewScore > this.reviewScore)
			return 1;
		else if (doctor.reviewScore == this.reviewScore)
			return 0;
		else
			return -1;

	}

}

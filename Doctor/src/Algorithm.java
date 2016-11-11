import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Algorithm {
	// map holds all the doctor objects.The key is the name of doctor
	// and the value is the doctor object
	Map<String, Doctor> map;
	// specialtyMap holds the doctors as per their specialty.The key is the
	// specialty attribute of doctor object and the value is a priority queue
	// which holds the doctor objects.
	Map<String, Queue<Doctor>> specialtyMap;

	public Algorithm() {
		map = new HashMap<String, Doctor>();
		specialtyMap = new HashMap<String, Queue<Doctor>>();
	}

	public void addDoctor(String dName, Doctor doctor) {

		map.put(dName, doctor);
		if (doctor.getSpecialty() != null) {
			String currentSpecialty = doctor.getSpecialty();
			if (!specialtyMap.containsKey(currentSpecialty)) {
				// A new PriorityQueue is instantiated if the specialty key
				// does not already exist in map
				specialtyMap.put(currentSpecialty, new PriorityQueue<Doctor>());
			}
			specialtyMap.get(currentSpecialty).offer(doctor);
		}

	}

	/*
	 * The user can browse for similar doctors by giving a doctor's name. The
	 * priority Queue data structure is used here so that all 10 similar doctors
	 * are retrieved in constant time and also in order of Priority.
	 */
	public ArrayList<Doctor> searchByName(String doctorName) {
		// ArrayList holds the list of top 10 similar doctors in the order of
		// priority
		ArrayList<Doctor> result = new ArrayList<Doctor>();
		if (!map.containsKey(doctorName))// checks for empty map or invalid
											// doctor name
		{
			return result;
		}
		Doctor doctor = map.get(doctorName);
		// Queue has all the similar doctors only.
		Queue<Doctor> queue = specialtyMap.get(doctor.getSpecialty());

		int count = 10;// To return Top 10 doctors
		while (!queue.isEmpty() && count >= 0) {
			Doctor d = queue.poll();// returns the doctor with highest
									// reviesScore
			if (!d.equals(doctor)) {
				result.add(d);
			}
			count--;
		}

		return result;
	}

}

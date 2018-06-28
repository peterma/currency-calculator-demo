package hackerrank.java;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class Student {
	int id;
	String name;
	double cgpa;

	public Student(int id, String name, double cgpa) {
		super();
		this.id = id;
		this.name = name;
		this.cgpa = cgpa;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getCgpa() {
		return cgpa;
	}

	public void setCgpa(double cgpa) {
		this.cgpa = cgpa;
	}

	@Override
	public String toString() {
		return "\nStudent [id=" + id + ", name=" + name + ", cgpa=" + cgpa + "]";
	}

}

class StudentChecker implements Comparator<Student> {

	@Override
	public int compare(Student s1, Student s2) {
		if (s2.cgpa > s1.cgpa)
			return 1;
		if (s2.cgpa < s1.cgpa)
			return -1;
		int nameCompared = s1.name.compareTo(s2.name);
		nameCompared = nameCompared > 0 ? 1 : (nameCompared < 0 ? -1 : 0);
		if (nameCompared == 0) {
			if (s2.id > s1.id)
				return 1;
			if (s2.id < s1.id)
				return -1;
		}
		return 0;
	}
}

class Priorities {

	// process all the given events and return all the students yet to be served in the priority order.
	List<Student> getStudents(List<String> events) {
		Queue<Student> queue = new PriorityQueue<Student>(events.size(), new StudentChecker());

		for (Iterator<String> eventItr = events.iterator(); eventItr.hasNext();) {
			String event = eventItr.next();
			String[] eventData = event.split(" ");
			String status = eventData[0];
			String name;
			double cgpa;
			int id;
			if ("ENTER".equals(status)) {
				name = eventData[1];
				cgpa = Double.parseDouble(eventData[2]);
				id = Integer.parseInt(eventData[3]);
				Student student = new Student(id, name, cgpa);
				queue.add(student);
			} else if (!queue.isEmpty()) {
				queue.remove();
			}
		}

		List<Student> students = new ArrayList<Student>(queue.size());
		while (!queue.isEmpty()) {
			students.add(queue.poll());
		}
		return students;
	}
}

public class JavaPriorityQueue {
	// private final static Scanner scan = new Scanner(System.in);
	private final static Priorities priorities = new Priorities();

	public static void main(String[] args) {
		// int totalEvents = Integer.parseInt(scan.nextLine());
		List<String> events = new ArrayList<>();

		// while (totalEvents-- != 0) {
		// String event = scan.nextLine();
		// events.add(event);
		// }

		String[] data = { "ENTER John 3.75 50", "ENTER Mark 3.8 24", "ENTER Shafaet 3.7 35", "SERVED", "SERVED", "ENTER Samiha 3.85 36", "SERVED",
				"ENTER Ashley 3.9 42", "ENTER Maria 3.6 46", "ENTER Anik 3.95 49", "ENTER Dan 3.95 50", "SERVED" };
		// Sample Output 0
		// Dan
		// Ashley
		// Shafaet
		// Maria
		for (int i = 0; i < data.length; i++) {
			events.add(data[i]);
		}

		List<Student> students = priorities.getStudents(events);

		if (students.isEmpty()) {
			System.out.println("EMPTY");
		} else {
			for (Student st : students) {
				System.out.println(st.getName());
			}
		}
	}
}
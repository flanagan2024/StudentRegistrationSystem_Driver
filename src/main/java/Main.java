import org.joda.time.LocalDate;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author Matt
 */
public class Main
{
	public static void main(String[] args)
	{
		// create students
		List<Student> students = new ArrayList<>();
		Student matt = new Student("Matt", "Flanagan", new LocalDate(1993, 9, 9));
		Student breda = new Student("Breda", "Shiels", new LocalDate(1996, 5, 3));
		Student tyrion = new Student("Tyrion", "Lannister", new LocalDate(1990, 1, 25));
		Student jon = new Student("Jon", "Snow", new LocalDate(1989, 10, 1));
		Student ned = new Student("Ned", "Stark", new LocalDate(1976, 7, 23));
		Student homer = new Student("Homer", "Simpson", new LocalDate(1978, 5, 24));
		Student maggie = new Student("Maggie", "Simpson", new LocalDate(2017, 4, 20));
		students.add(matt);
		students.add(breda);
		students.add(tyrion);
		students.add(jon);
		students.add(ned);
		students.add(homer);
		students.add(maggie);

		// create modules
		ArrayList<Module> modules = new ArrayList<>();
		Module ct404 = new Module("Graphics & Image Processing", "CT404");
		ct404.addStudent(matt);
		ct404.addStudent(tyrion);
		ct404.addStudent(jon);
		Module ct417 = new Module("Software Engineering III", "CT417");
		ct417.addStudent(matt);
		ct417.addStudent(ned);
		ct417.addStudent(maggie);
		Module ct421 = new Module("Artificial Intelligence", "CT421");
		ct421.addStudent(matt);
		ct421.addStudent(jon);
		ct421.addStudent(homer);
		Module ps405 = new Module("Advanced Research Methods", "PS405");
		ps405.addStudent(homer);
		ps405.addStudent(jon);
		ps405.addStudent(maggie);
		Module ps412 = new Module("Experimental Psychology", "PS412");
		ps412.addStudent(breda);
		ps412.addStudent(homer);
		Module ps415 = new Module("Perception, Attention & Performance", "PS415");
		ps415.addStudent(breda);
		ps415.addStudent(ned);
		ps415.addStudent(tyrion);
		modules.add(ct404);
		modules.add(ct417);
		modules.add(ct421);
		modules.add(ps405);
		modules.add(ps412);
		modules.add(ps415);

		// create courses
		HashSet<Course> courses = new HashSet<>();
		LocalDate academicStartDate = new LocalDate(2012, 9, 2);
		LocalDate academicEndDate = new LocalDate(2016, 5, 1);
		Course csit = new Course("Computer Science", academicStartDate, academicEndDate);
		csit.addModule(ct404);
		csit.addModule(ct417);
		csit.addModule(ct421);
		ct404.addCourse(csit);
		ct417.addCourse(csit);
		ct421.addCourse(csit);
		courses.add(csit);

		Course psych = new Course("Psychology", academicStartDate, academicEndDate);
		psych.addModule(ps405);
		psych.addModule(ps412);
		psych.addModule(ps415);
		ps405.addCourse(psych);
		ps412.addCourse(psych);
		ps415.addCourse(psych);
		courses.add(psych);

		// print out all courses with their respective modules
		System.out.println("================ Courses ================\n");
		for(Course course : courses)
			System.out.println(course.toString());

		// print out all students, their usernames, assigned modules and the course(s) they are registered for
		System.out.println("================ Students ================\n");
		String assignedModules = "";
		String registeredCourses = "";

		// find which students are doing which modules and what courses they are registered for
		for(Student student : students) {
			for(Module module : modules) {
				if(module.getStudents().contains(student)) {
					assignedModules += module.toString() + "\n";
					for(Course course : module.getCourses()) {
						if(!registeredCourses.contains(course.getCourseName()))
							registeredCourses += course.getCourseName() + "\n\t\t\t";
					}
				}
			}
			System.out.println(student.toString() + registeredCourses);
			System.out.println("Assigned Modules:\n" + assignedModules + "\n");
			assignedModules = "";
			registeredCourses = "";
		}
	}
}

import org.joda.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Matt
 */
public class Main
{
	public static void main(String[] args)
	{
		LocalDate academicStartDate = new LocalDate(2012, 9, 2);
		LocalDate academicEndDate = new LocalDate(2016, 5,  1);

		// create courses
		Course csit = new Course("Computer Science", academicStartDate, academicEndDate);
		Course psyc = new Course("Psychology", academicStartDate, academicEndDate);

		// create students
		List<Student> students = new ArrayList<>();
		Student matt = new Student("Matt", "Flanagan", new LocalDate(1993, 9, 9));
		Student breda = new Student("Breda", "Shiels", new LocalDate(1996, 5, 3));
		Student rohan = new Student("Rohan", "Bajwa", new LocalDate(1994, 1, 25));
		Student molly = new Student("Molly", "Flanagan", new LocalDate(1999, 10, 1));
		students.add(matt);
		students.add(breda);
		students.add(rohan);
		students.add(molly);

		// create modules
		Module softwareEngineering = new Module("Software Engineering III", "CT417");
		softwareEngineering.addStudent(matt);
		softwareEngineering.addStudent(molly);
		Module artificialIntelligence = new Module("Artificial Intelligence", "CT421");
		softwareEngineering.addStudent(matt);
		softwareEngineering.addStudent(breda);
		artificialIntelligence.addStudent(rohan);
		Module machineLearning = new Module("Machine Learning & Data Mining", "CT475");
		machineLearning.addStudent(matt);
		machineLearning.addStudent(breda);
		Module graphicsImage = new Module("Graphics & Image Processing", "CT404");
		graphicsImage.addStudent(breda);
		graphicsImage.addStudent(rohan);
		graphicsImage.addStudent(molly);
	}
}

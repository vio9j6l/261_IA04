/*
 * Name: JiaJia Liu
 * Email: jpl5840@psu.edu
 * Course: IST 261
 * Assignment: IA04
 */
import java.util.*;

enum Session {
    SPRING,
    SUMMER,
    FALL
}

/**
 * One section of a course
 * <p>
 * One course can have many sections.  This class represents one section for
 * one course.  The course is identified by its id.
 */
public class CourseSection {
    /**
     * Uniquely identifies one section
     */
    private UUID id;

    public UUID getId() {
        return id;
    }

    /**
     * The course to which this section belongs
     */
    private Course course;

    public Course getCourse() {
        return course;
    }

    /*
     * Year this section is offered
     */
    private int year;

    /**
     * The semester in which this section is being offered
     * <p>
     * e.g., 1==Spring, 2==Fall, 3=Summer, etc...
     */
    private Session session;

    /**
     * The section number of the course
     * <p>
     * e.g., for IST123-001, "001" is the section
     */
    private String number;

    /**
     * The students who are registered for this section
     */
    private List<Student> students = new ArrayList<>();

    /**
     * Constructor for course section
     * <p>
     * Initialized the new section with the given arguments.
     *
     * @param course  instance of a Course object
     * @param year    year the section is offered
     * @param session session this section is offered
     * @param number  section number
     * @author Phil O'Connell (pxo4@psu.edu)
     */
    public CourseSection(Course course, int year, Session session, String number) {
        this.id = UUID.randomUUID();
        this.course = course;
        this.year = year;
        this.session = session;
        this.number = number;

        students = new ArrayList<>();
    }

    /**
     * String representation of a course section
     *
     * @return string including subject, number, session, and year
     */
    @Override
    public String toString() {
        // TODO 02 + Write CourseSection.toString such that it passes CourseSectionTest.toString__create_course_section__string_is_correct
        Course course = getCourse();
        String courseNumber = course.getSubject() + course.getNumber();
        return String.format("%s-%s (%s %s)", courseNumber, number, session, year);
    }

    /**
     * Add a student to the section
     *
     * @param student a student enrolled in the section
     */
    public void addStudent(Student student) {
        students.add(student);
    }

    public int getCount() {
        return students.size();

    }

    public void removeStudent(Student student) {
        students.remove(student);
    }

    public void removeStudent(UUID studentId) {
        for (Student student : students) {
            if (student.getId().equals(studentId)) {
                students.remove(student);
                return;
            }
        }
    }

    public void removeAllStudents() {
        this.students.clear();
    }

    /**
     * Print the list of students
     * <p>
     * Assumes that Student class overrides toString();
     */
    public void printStudents() {
        for (Student s : this.students) {
            System.out.println(s);
        }
    }

    public Student findStudent(UUID studentId) {
        for (Student enrolled : this.students) {
            if (enrolled.getId().equals(studentId)) {
                return enrolled;
            }
        }
        return null;
    }

    public Student findStudent(String email) {
        // TODO 11 + given a student email, find that student object, and return it
        for (Student enrolled : this.students) {
            if (enrolled.getEmail().equals(email)) {
                return enrolled;
            }
        }
        return null;
    }

    public Student findStudent(Student student) {
        for (Student enrolled : this.students) {
            if (enrolled == student) {
                return student;
            }
        }
        return null;
    }

    public boolean isStudentEnrolled(UUID studentId) {
        return (findStudent(studentId) != null);
    }

    public boolean isStudentEnrolled(Student student) {
        return (findStudent(student) != null);
    }

    public boolean isStudentEnrolled(String email) {
        // TODO 10 + given a student email, determine if that student is enrolled
        for (Student enrolled : this.students) {
            if (enrolled.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

}

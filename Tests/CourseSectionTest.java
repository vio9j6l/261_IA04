/*
 * Name: JiaJia Liu
 * Email: jpl5840@psu.edu
 * Course: IST 261
 * Assignment: IA04
 */
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;


public class CourseSectionTest
{
  /*
   * DON'T CHANGE ANYTHING AT THE CLASS LEVEL
   */
  private static Course testCourse;
  private static CourseSection testSection;

  private static Student homer = new Student("Homer Simpson", "hjs5123@psu.edu");
  private static Student marge = new Student("Marge Simpson", "mxs5456@psu.edu");
  private static Student bart = new Student("Bart Simpson", "bxs5321@psu.edu");


  @BeforeClass
  /**
   * This will run one time -- before all the tests
   */
  public static void setUp() {
    System.out.println("One-time setup");
    // TODO 00 + Put your info here
    System.out.println("Name: JiaJia Liu");
    System.out.println("Email: jpl5840@psu.edu");
    System.out.println("Course: IST 261");
    System.out.println("Assignment: IA04");

    testCourse = new Course("IST", 261, "Application Development Design Studio I");
    testSection = new CourseSection(testCourse, 2020, Session.FALL, "200");
  }

  @Before
  /**
   * This will run before each test
   */
  public void setUpEach() {
    initSection();
  }


  private void initSection() {
    testSection.removeAllStudents();

    testSection.addStudent(homer);
    testSection.addStudent(marge);
    testSection.addStudent(bart);
  }

  @Test
  public void isStudentEnrolled__add_new_student__then_is_enrolled_in_section() {

    // TODO 09 + Write isStudentEnrolled__add_new_student__then_is_enrolled_in_section
    // Create a "new Student" with your name, and your email address0
    // Add yourself to the testSection
    // Write an assert that ensures that you're enrolled
    Student Liu = new Student("JiaJia Liu", "jpl5840@psu.edu");
    testSection.addStudent(Liu);
    assertTrue("Student Liu should be enrolled", testSection.isStudentEnrolled(Liu));

  }

  @Test
  public void isStudentEnrolled__pass_email__then_is_enrolled_in_section() {
    // DON'T EDIT THIS TEST
    // You need to finish writing CourseSection.isStudentEnrolled that accepts an email address argument
    assertTrue(testSection.isStudentEnrolled(homer.getEmail()));
  }

  @Test
  public void isStudentEnrolled__pass_student_object__then_is_enrolled_in_section() {

    // TODO 08 + Write isStudentEnrolled__pass_student_object__then_is_enrolled_in_section
    // Write an assert to ensure you can find a student when you pass their instance object
    // DO NOT create a new student object here.  Use one of the 3 I give you in this class.
    assertSame(homer, testSection.findStudent(homer));
  }

  @Test
  public void isStudentEnrolled__pass_student_id__then_is_enrolled_in_section() {

    // TODO 07 + Write isStudentEnrolled__pass_student_id__then_is_enrolled_in_section
    // Write an assert to ensure you can determine if a student when you pass their ID
    // DO NOT create a new student object here.  Use one of the 3 I give you in this class.
    assertTrue("Homer is enrolled in section by looking at his id",
        testSection.isStudentEnrolled(homer.getId()));
  }

  @Test
  public void isStudentEnrolled__remove_all_students__then_none_enrolled() {

    // TODO 06 + Write isStudentEnrolled__remove_all_students__then_none_enrolled
    // Remove all the students from the section using removeAllStudents
    // Write 3 asserts with isStudentEnrolled to ensure that each student is not enrolled
    // You must use the messages argument to the assertion
    // See the "Messages in the Assertions" slide in the "JUnit – Part 1" PowerPoint

    testSection.removeAllStudents();
    assertFalse( "Homer Student should be removed", testSection.isStudentEnrolled(homer));
    assertFalse("Marge Student should be removed", testSection.isStudentEnrolled(marge));
    assertFalse("Bart student should be removed", testSection.isStudentEnrolled(bart));
  }

  @Test
  public void isStudentEnrolled__remove_student__then_not_enrolled() {

    // TODO 05 + Write isStudentEnrolled__remove_student__then_not_enrolled
    // Remove one student from the section
    // Write an assert to ensure that student is not found in the course
    testSection.removeStudent(homer);
    assertFalse(testSection.isStudentEnrolled(homer));

  }

  @Test
  public void findStudent__pass_existing_student_email__found_in_section() {
    // DO NOT EDIT THIS TEST!
    // You need to finish writing CourseSection.findStudent that takes an email address
    assertSame(homer, testSection.findStudent("hjs5123@psu.edu"));
  }


  @Test
  public void removeAllStudents__remove_all__count_becomes_zero() {

    // TODO 04 + Write removeAllStudents__remove_all__count_becomes_zero
    // Remove all the students from the section using removeAllStudents
    // Write an assert to ensure the count is now zero
    testSection.removeAllStudents();
    assertEquals(0, testSection.getCount());
  }

  @Test
  public void getCount__no_action__count_is_three() {

    // TODO 03 + Write getCount__no_action__count_is_three
    // Nothing to do here except to write an assert to ensure the section student count is 3

    assertEquals(3, testSection.getCount());
  }

  @Test
  public void toString__create_course_section__string_is_correct() {
    // DO NOT EDIT THIS TEST!
    // You need to finish writing CourseSection.toString()
    assertEquals("IST261-200 (FALL 2020)", testSection.toString());
  }
}

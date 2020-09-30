/*
 * Name: JiaJia Liu
 * Email: jpl5840@psu.edu
 * Course: IST 261
 * Assignment: IA04
 */
import java.util.UUID;

/**
 * This class represents a PSU student
 * <p>
 * We don't have many fields in this class.  Its purpose is just to represent a
 * small portion of the data of an actual PSU student.
 *
 * @author Phil O'Connell (pxo4@psu.edu)
 */

public class Student {
    private UUID id;

    public UUID getId() {
        return id;
    }

    private String name;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    private String email;

    public Student(String name, String email) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.email = email;
    }

    /**
     * String representation of a course section
     *
     * @return string including subject, number, session, and year
     */
    @Override
    public String toString() {
        // TODO 01 + Write Student.toString such that it passes StudentTest.toString__pass_student__string_is_correct
        return String.format("%s (%s)", name, email);
    }
}

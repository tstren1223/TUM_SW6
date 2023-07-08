package de.tum.in.ase.eist;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CourseTest {
	private final Course course = new Course("Math");

	// TODO 1: Test getCourseTitle()
	@Test
	void testGetCourseTitle() {
		assertEquals("Math", course.getTitle());
	}

	// TODO 2: Test getNumberOfAttendees()
	@Test
	void testNoAttendees() {
		assertEquals(0, course.getNumberOfAttendees());
	}

	@Test
	void testThreeAttendees() {
		course.addAttendee(new Student("a", "b", "c", "d", "e"));
		course.addAttendee(new Student("a", "b", "c", "d", "e"));
		course.addAttendee(new Student("a", "b", "c", "d", "e"));
		assertEquals(3, course.getNumberOfAttendees());
	}
}

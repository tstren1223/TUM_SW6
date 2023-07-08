package de.tum.in.ase.eist;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import java.net.MalformedURLException;
import java.net.URL;

class OnlineCourseTest {
	private final OnlineCourse onlineCourse = new OnlineCourse("Chinese");
	// TODO 3: Test setOnlineCourseUrl()
	@Test
	void testSetOnlineCourseUrlWithValidUrl() {
		assertAll(() -> { onlineCourse.setUrl("https://www.tum.de/"); assertEquals(new URL("https://www.tum.de/"), onlineCourse.getUrl()); });

	}
	@Test
	void testSetOnlineCourseUrlWithInvalidUrl() {
		assertThrows(MalformedURLException.class, () -> { onlineCourse.setUrl("hps://www.tum.de/"); });
	}
}

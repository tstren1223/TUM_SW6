package de.tum.in.ase.eist;

import org.easymock.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

import java.time.LocalDate;
import static org.easymock.EasyMock.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(EasyMockExtension.class)
class DiscussionTest {

    // TODO implement the tests
    @TestSubject
    private Discussion discussion = new Discussion();
    @Mock
    private Course courseMock;
    @Mock
    private Comment commentMock;
    @Test
    void testComment() {
        int expectedSize = discussion.getNumberOfComments() + 1;
        expect(commentMock.save()).andReturn(true);
        replay(commentMock);
        assertEquals(true, discussion.addComment(commentMock));
        assertEquals(expectedSize, discussion.getNumberOfComments());
    }
    @Test
    void  testCommentIfSavingFails() {
        int expectedSize = discussion.getNumberOfComments();
        expect(commentMock.save()).andReturn(false);
        replay(commentMock);
        assertEquals(false, discussion.addComment(commentMock));
        assertEquals(expectedSize, discussion.getNumberOfComments());
    }
    @Test
    void testStartCourseDiscussion() {
        Student s = new Student("a", "b", LocalDate.of(1, 1, 1), "d", "e");
        expect(courseMock.isDiscussionAllowed(s)).andReturn(true);
        replay(courseMock);
        assertEquals(true, discussion.startCourseDiscussion(courseMock, s, "Math"));
        assertEquals(courseMock, discussion.getCourse());
        assertEquals("Math", discussion.getTopic());
    }
}

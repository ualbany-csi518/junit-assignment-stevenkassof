package sampleQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


class QueueTest {

	/**
	 * Tests for Queue.
	 */

	private static final String SOME_ITEM = "some-content";
	private static final String SOME_OTHER_ITEM = "some-other-content";
	private Queue<String> q;



	@BeforeEach
	void init() {
		this.q = new Queue<String>();
	}

	@Test
	@DisplayName("Verify Queue isEmpty when queue is initialized")
	void isEmptyShouldGiveTrueOnQueueInit() {
		assertTrue(q.isEmpty());
	}


	@Test
	@DisplayName("Verify Queue isEmpty when queue is initialized (second constructor), check size")
	void isEmptyShouldGiveTrueOnQueueInit2() {

		this.q = new Queue<String>(9);
		assertTrue(q.isEmpty());
		assertEquals(q.size(),0);
		q.enqueue(SOME_ITEM);
		assertEquals(q.size(),1);
	}
	

	@Test
	@DisplayName("Verify enqueue/dequeue/peek works for single object")
	void singleObjectEnqueueTest() {

		q.enqueue(SOME_ITEM);
		assertFalse(q.isEmpty());
		assertEquals(q.peek(),SOME_ITEM);
		assertEquals(q.dequeue(),SOME_ITEM);
		assertThrows(NoSuchElementException.class, () -> {q.peek();});
		assertThrows(NoSuchElementException.class, () -> {q.dequeue();});
		}
	
	@Test
	@DisplayName("Verify enqueue/dequeue/peek works for two objects")
	void twoObjectQueueTest() {

		q.enqueue(SOME_ITEM);
		q.enqueue(SOME_OTHER_ITEM);
		assertEquals(q.peek(),SOME_ITEM);
		assertEquals(q.dequeue(),SOME_ITEM);
		assertEquals(q.peek(),SOME_OTHER_ITEM);
		assertEquals(q.dequeue(),SOME_OTHER_ITEM);
		assertThrows(NoSuchElementException.class, () -> {q.peek();});
		assertThrows(NoSuchElementException.class, () -> {q.dequeue();});
	}
	
	@Test
	@DisplayName("Verify enqueue/dequeue/peek works for two objects")
	void threeObjectQueueTest() {

		q.enqueue(SOME_ITEM);
		q.enqueue(SOME_OTHER_ITEM);
		q.enqueue(SOME_ITEM);
		assertEquals(q.peek(),SOME_ITEM);
		assertEquals(q.dequeue(),SOME_ITEM);
		assertEquals(q.peek(),SOME_OTHER_ITEM);
		assertEquals(q.dequeue(),SOME_OTHER_ITEM);
		assertEquals(q.peek(),SOME_ITEM);
		assertEquals(q.dequeue(),SOME_ITEM);
		assertThrows(NoSuchElementException.class, () -> {q.peek();});
		assertThrows(NoSuchElementException.class, () -> {q.dequeue();});
	}
	

	@Test
	@DisplayName("Verify enqueue does not add objects past maximum")
	void fullTest() {

		this.q = new Queue<String>(3);

		q.enqueue(SOME_ITEM);
		q.enqueue(SOME_ITEM);
		q.enqueue(SOME_ITEM);
		assertThrows(Exception.class, () -> {q.enqueue(SOME_ITEM);});
		}
	
	@Test
	@DisplayName("Verify toString works")
	void toStringTest() {

		q.enqueue(SOME_ITEM);
		assertEquals(q.toString(),SOME_ITEM+" ");
		q.enqueue(SOME_OTHER_ITEM);
		assertEquals(q.toString(),SOME_ITEM+" "+SOME_OTHER_ITEM+" ");
	}
	

	
	@Test
	@DisplayName("Verify removeAll works")
	void removeAllTest() {

		q.enqueue(SOME_ITEM);
		q.enqueue(SOME_OTHER_ITEM);
		q.enqueue(SOME_OTHER_ITEM);
		q.enqueue(SOME_OTHER_ITEM);
		q.removeAll();
		assertTrue(q.isEmpty());
	}
	

	


	
}
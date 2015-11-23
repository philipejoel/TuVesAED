package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import dataStructures.*;

public class InsertSimpleTest {

	@Test
	public void insertSimpleTest() {
		OrderedDictionary<Integer, Integer> od = new OrderedDoubleList<Integer, Integer>();

		od.insert(5, 5); // insercao a cabeca
		od.insert(10, 10); // insercao a cauda
		od.insert(-3, -3); // insercao a cabeca
		od.insert(4, 4); // insercao do segundo
		od.insert(9, 9); // insercao do penultimo
		od.insert(7, 77); // insercao no meio
		od.insert(7, 7); // substituição do valor

		assertEquals(od.size(),6);

		TwoWayIterator<Entry<Integer, Integer>> it = (TwoWayIterator<Entry<Integer, Integer>>) od.iterator();

		assertTrue(it.hasNext());
		assertTrue(it.next().getKey() == -3);
		assertTrue(it.next().getKey() == 4);
		assertTrue(it.next().getKey() == 5);
		assertTrue(it.next().getKey() == 7);
		assertTrue(it.next().getKey() == 9);
		assertTrue(it.next().getKey() == 10);

		it.fullForward();
		assertTrue(it.hasPrevious());
		assertTrue(it.previous().getKey() == 10);
		assertTrue(it.previous().getKey() == 9);
		assertTrue(it.previous().getKey() == 7);
		assertTrue(it.previous().getKey() == 5);
		assertTrue(it.previous().getKey() == 4);
		assertTrue(it.previous().getKey() == -3);
		assertFalse(it.hasPrevious());	
	}
}

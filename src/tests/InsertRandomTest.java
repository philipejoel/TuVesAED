package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Random;
import dataStructures.*;

public class InsertRandomTest {

	@Test
	public void insertinsertRandomTest() throws EmptyDictionaryException {
		OrderedDictionary<Integer, Integer> od = new OrderedDoubleList<Integer, Integer>();
		
		insertRandomElems(od, 100);
		
		Iterator<Entry<Integer, Integer>> it = od.iterator();
		Entry<Integer, Integer> previous = it.next();
		Entry<Integer, Integer> current;
		while (it.hasNext()) { // lista esta ordenada
			current = it.next();
			assertTrue(previous.getKey().compareTo(current.getKey()) < 0); 
			previous = current;
		}
		
		
		it = od.iterator();
		Entry<Integer, Integer> max;
			max = od.maxEntry();
		Entry<Integer, Integer> min;
			min = od.minEntry();
		while (it.hasNext()) { 
			current = it.next();
			// maximo 'e maior ou igual a todos os elementos
			assertTrue(current.getKey().compareTo(max.getKey()) <= 0);  
			// minimo 'e menor ou igual a todos os elementos
			assertTrue(current.getKey().compareTo(min.getKey()) >= 0); 
		}
		
	}

	private static void insertRandomElems(OrderedDictionary<Integer, Integer> od, int elems) {
		Random rand = new Random();
		for (int i = 0; i < elems; i++) {
			int e = rand.nextInt();
			od.insert(e, e);
		}
	}
}


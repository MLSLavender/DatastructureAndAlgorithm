package cc.cc1234.algorithm.search;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


/**
 * 线性查找测试用例
 * @author vran
 * @Date 2017-08-03 10:50:02
 */
public class SequenceSearchTest {
	
	private SequenceSearch<Integer> search;
	
	@Test
	public void testSearch() {
		Integer[] data = {1,3,5,7,8,9,10};
		search = new SequenceSearch<>(data);
		
		Integer result = search.search(11);
		assertTrue(result == null);
		
		result = search.search(5);
		assertTrue(result.equals(5));
		
		result = search.search(7);
		assertTrue(result.equals(7));
		
		result = search.search(1);
		assertTrue(result.equals(1));
		
		result = search.search(10);
		assertTrue(result.equals(10));
	}

}

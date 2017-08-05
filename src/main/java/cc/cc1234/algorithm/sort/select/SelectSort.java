package cc.cc1234.algorithm.sort.select;

import cc.cc1234.algorithm.sort.BaseSort;
import cc.cc1234.algorithm.sort.SortTest;

/**
 * 选择排序
 * @author vran1
 */
public class SelectSort<E extends Comparable<? super E>> extends BaseSort<E>{

	@Override
	public void sort(E[] data) {
		for(int i = data.length-1; i >= 0; i--) {
			int pos = 0;
			for(int j = 1; j <= i; j++) {
				if ( data[pos].compareTo(data[j]) == -1 ) {
					pos = j;
				}
			}
			swap(data, i, pos);
		}
	}
}

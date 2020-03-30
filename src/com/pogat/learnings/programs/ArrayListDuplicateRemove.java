package com.pogat.learnings.programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ArrayListDuplicateRemove {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 3, 4, 9, 2, 5, 3, 5));
		// java8
		List<Integer> newList = list.stream().distinct().collect(Collectors.toList());
		System.out.println("New List from Java8: " + newList);

		// second approach
		List<Integer> newList1 = new ArrayList();
		for (Integer element : list) {
			if (!newList1.contains(element)) {
				newList1.add(element);
			}
		}
		System.out.println("newList1 from contains method : " + newList1);
		List<Integer> newList2 = removeDuplicates(list);
		System.out.println("newList2 from contains method : " + newList2);

	}

	public static List<Integer> removeDuplicates(List<Integer> list) {

		// Create a new LinkedHashSet
		Set<Integer> set = new LinkedHashSet<>();

		// Add the elements to set
		set.addAll(list);

		// Clear the list
		list.clear();

		// add the elements of set
		// with no duplicates to the list
		list.addAll(set);

		// return the list
		return list;
	}
}

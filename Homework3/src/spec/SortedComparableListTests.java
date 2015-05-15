package spec;

import static org.junit.Assert.*;
import hw3.SortedComparableList;

import org.junit.Test;

public class SortedComparableListTests {

	@Test
	public void Constructor_WithNoArguments_HasDefaultHeadAndTail() {
		//Arrange
		//nothing to do
		
		//Act
		SortedComparableList sut = new SortedComparableList();
		
		//Assert
		assertEquals(0, sut.head);
		assertNull(sut.tail);
	}
	
	@Test
	public void Constructor_WithArguments_IsAssignedCorrectly() {
		//Arrange
		SortedComparableList tail = new SortedComparableList();
		
		//Act
		SortedComparableList sut = new SortedComparableList(1, tail);
		
		//Assert
		assertEquals(1, sut.head);
		assertEquals(tail, sut.tail);
	}
	
	@Test
	public void Insert_Insert1InDefaultList_BecomesNewTail() {
		//Arrange
		SortedComparableList sut = new SortedComparableList();
		Integer c = 1;
		
		//Act
		sut.insert(c);
		
		//Assert
		assertEquals(1, sut.tail.head);
	}
	
	@Test
	public void Insert_Insert1InLongerList_InsertedInCorrectOrder() {
		//Arrange
		SortedComparableList sut = new SortedComparableList();
		
		//Act
		sut.insert(3);
		sut.insert(1);
		sut.insert(2);
		
		//Assert
		assertEquals("(0, 1, 2, 3)", sut.toString());
	}
	
	@Test
	public void Get_IisZero_ReturnsZero() {
		//Arrange
		SortedComparableList sut = new SortedComparableList();
		
		//Act
		sut.insert(3);
		sut.insert(1);
		sut.insert(2);
		
		//Assert
		assertEquals(0, sut.get(0));
	}
	
	@Test
	public void Get_IisValidIndex_ReturnsValue() {
		//Arrange
		SortedComparableList sut = new SortedComparableList();
		
		//Act
		sut.insert(3);
		sut.insert(1);
		sut.insert(2);
		
		//Assert
		assertEquals(1, sut.get(1));
		assertEquals(2, sut.get(2));
		assertEquals(3, sut.get(3));
	}
	
	@Test
	public void Extend_TwoSingleElementLists_AppendsToTail() {
		//Arrange
		SortedComparableList sut = new SortedComparableList();
		SortedComparableList test = new SortedComparableList(1, null);
		
		//Act
		sut.extend(test);
		
		//Assert
		assertEquals(1, sut.tail.head);
	}
	
	@Test
	public void Extend_ExtendListIsNull_DoesNothing() {
		//Arrange
		SortedComparableList sut = new SortedComparableList();
		SortedComparableList test = null;
		
		//Act
		sut.extend(test);
		
		//Assert
		assertEquals(0, sut.head);
		assertNull(sut.tail);
	}
	
	@Test
	public void Extend_ExtendListHeadIsNull_DoesNothing() {
		//Arrange
		SortedComparableList sut = new SortedComparableList();
		SortedComparableList test = new SortedComparableList(null, null);
		
		//Act
		sut.extend(test);
		
		//Assert
		assertEquals(0, sut.head);
		assertNull(sut.tail);
	}
	
	@Test
	public void Extend_ExtendListOneElementIntoTwoELement_InsertedInOrder() {
		//Arrange
		SortedComparableList sut = new SortedComparableList();
		SortedComparableList test = new SortedComparableList(1, null);
		sut.insert(3);
		
		//Act
		sut.extend(test);
		
		//Assert
		assertEquals("(0, 1, 3)", sut.toString());
	}
	
	@Test
	public void Extend_BothHaveTwoELement_InsertedInOrder() {
		//Arrange
		SortedComparableList sut = new SortedComparableList();
		SortedComparableList test = new SortedComparableList(1, null);
		sut.insert(5);
		test.insert(3);
		
		//Act
		sut.extend(test);
		
		//Assert
		assertEquals("(0, 1, 3, 5)", sut.toString());
	}
	
	@Test
	public void Extend_OddListandEvenList_InsertedInOrder() {
		//Arrange
		SortedComparableList sut = new SortedComparableList();
		SortedComparableList test = new SortedComparableList(1, null);
		sut.insert(3);
		sut.insert(5);
		test.insert(2);
		test.insert(6);
		test.insert(4);
		
		//Act
		sut.extend(test);
		
		//Assert
		assertEquals("(0, 1, 2, 3, 4, 5, 6)", sut.toString());
	}

}

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
	
	@Test
	public void SubTail_DefaultListFromZero_ReturnsDefaultList() {
		//Arrange
		SortedComparableList sut = new SortedComparableList();
		
		//Act
		SortedComparableList sub = SortedComparableList.subTail(sut, 0);
		
		//Assert
		assertEquals(sut, sub);
	}
	
	@Test
	public void SubTail_LongListPositiveIndex_ReturnsSublist() {
		//Arrange
		SortedComparableList sut = new SortedComparableList();
		sut.insert(3);
		sut.insert(5);
		sut.insert(2);
		sut.insert(6);
		sut.insert(4);
		
		//Act
		SortedComparableList sub = SortedComparableList.subTail(sut, 4);
		
		//Assert
		assertEquals("(0, 2, 3, 4, 5, 6)", sut.toString());
		assertEquals("(5, 6)", sub.toString());
	}
	
	@Test
	public void ExpungeTail_ZeroLen_OnlyFirstElement() {
		//Arrange
		SortedComparableList sut = new SortedComparableList();
		sut.insert(3);
		sut.insert(2);
		int len = 0;
		
		//Act
		SortedComparableList.expungeTail(sut, len);
		
		//Assert
		assertEquals("(0)", sut.toString());
	}

	@Test
	public void ExpungeTail_LenIsOne_FirstTwoElements() {
		//Arrange
		SortedComparableList sut = new SortedComparableList();
		sut.insert(3);
		sut.insert(2);
		int len = 1;
		
		//Act
		SortedComparableList.expungeTail(sut, len);
		
		//Assert
		assertEquals("(0, 2)", sut.toString());
	}
	
	@Test
	public void Sublist_StartandLenAreOne_ReturnsSecondAndThirdElements() {
		//Arrange
		SortedComparableList sut = new SortedComparableList();
		sut.insert(3);
		sut.insert(2);
		sut.insert(1);
		int start = 1;
		int len = 1;
		
		//Act
		SortedComparableList sub = SortedComparableList.sublist(sut, start, len);
		
		//Assert
		assertEquals("(0, 1, 2, 3)", sut.toString());
		assertEquals("(1, 2)", sub.toString());
	}
	
	@Test
	public void Squish_DefaultList_DoesNothing() {
		//Arrange
		SortedComparableList sut = new SortedComparableList();
		SortedComparableList test = new SortedComparableList();
		
		//Act
		sut.squish();
		
		//Assert
		assertEquals(test, sut);
	}
	
	@Test
	public void Squish_Triples_EliminatesDupes() {
		//Arrange
		SortedComparableList sut = new SortedComparableList();
		sut.insert(0);
		sut.insert(0);
		sut.insert(1);
		sut.insert(1);
		sut.insert(1);
		
		//Act
		sut.squish();
		
		//Assert
		assertEquals("(0, 1)", sut.toString());
	}
	
	@Test
	public void Twin_TwoElements_Doubles() {
		//Arrange
		SortedComparableList sut = new SortedComparableList();
		sut.insert(1);
		
		//Act
		sut.twin();
		
		//Assert
		assertEquals("(0, 0, 1, 1)", sut.toString());
	}
	
	@Test
	public void Twin_FourElements_Doubles() {
		//Arrange
		SortedComparableList sut = new SortedComparableList();
		sut.insert(1);
		sut.insert(10);
		sut.insert(100);
		
		//Act
		sut.twin();
		
		//Assert
		assertEquals("(0, 0, 1, 1, 10, 10, 100, 100)", sut.toString());
	}
}

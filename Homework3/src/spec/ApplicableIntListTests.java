package spec;

import static org.junit.Assert.*;
import hw3.ApplicableIntList;
import hw3.ApplicableIntList;
import hw3.IntUnaryFunction;

import org.junit.Test;

public class ApplicableIntListTests {

	@Test
	public void Constructor_WithNoArguments_HasDefaultHeadAndTail() {
		//Arrange
		//nothing to do
		
		//Act
		ApplicableIntList sut = new ApplicableIntList();
		
		//Assert
		assertEquals(0, sut.head);
		assertNull(sut.tail);
	}
	
	@Test
	public void Constructor_WithArguments_IsAssignedCorrectly() {
		//Arrange
		ApplicableIntList tail = new ApplicableIntList();
		
		//Act
		ApplicableIntList sut = new ApplicableIntList(1, tail);
		
		//Assert
		assertEquals(1, sut.head);
		assertEquals(tail, sut.tail);
	}
	
	@Test
	public void Insert_Insert1InDefaultList_BecomesNewTail() {
		//Arrange
		ApplicableIntList sut = new ApplicableIntList();
		Integer c = 1;
		
		//Act
		sut.insert(c);
		
		//Assert
		assertEquals(1, sut.tail.head);
	}
	
	@Test
	public void Insert_Insert1InLongerList_InsertedInCorrectOrder() {
		//Arrange
		ApplicableIntList sut = new ApplicableIntList();
		
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
		ApplicableIntList sut = new ApplicableIntList();
		
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
		ApplicableIntList sut = new ApplicableIntList();
		
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
	public void Apply_DummyFunction_ListUnchanged() {
		//Arrange
		ApplicableIntList sut = new ApplicableIntList();
		ApplicableIntList base = new ApplicableIntList();
		sut.insert(1);
		sut.insert(2);
		base.insert(1);
		base.insert(2);
		
		//Act
		sut.apply(new Dummy());
		
		//Assert
		assertEquals(base, sut);
	}
	
	@Test
	public void Apply_DoubleFunction_ListDoubled() {
		//Arrange
		ApplicableIntList sut = new ApplicableIntList();
		sut.insert(1);
		sut.insert(2);
		
		//Act
		sut.apply(new Doubler());
		
		//Assert
		assertEquals("(0, 2, 4)", sut.toString());
	}
	
	@Test
	public void Apply_InverseFunction_ListInverseInCorrectOrder() {
		//Arrange
		ApplicableIntList sut = new ApplicableIntList();
		sut.insert(1);
		sut.insert(2);
		
		//Act
		sut.apply(new Inverse());
		
		//Assert
		assertEquals("(0, 50, 100)", sut.toString());
	}
	
	public class Doubler implements IntUnaryFunction {
		@Override
		public int apply(int x){
			return x * 2;
		}
	}
	
	public class Dummy implements IntUnaryFunction {
		@Override
		public int apply(int x){
			return x;
		}
	}
	
	public class Inverse implements IntUnaryFunction {
		@Override
		public int apply(int x){
			if(x != 0){
				return 100 / x;
			} else {
				return 0;
			}
			
		}
	}

}

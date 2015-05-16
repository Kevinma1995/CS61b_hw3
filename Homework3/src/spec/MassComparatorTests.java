package spec;

import static org.junit.Assert.*;
import hw3.ApplicableIntList;
import hw3.MassComparator;
import hw3.Planet;

import org.junit.Test;

public class MassComparatorTests {

	@Test
	public void Compare_FirstPlanetSmaller_ReturnsNegative() {
		//Arrange
		Planet planet1 = new Planet(0, 0, 0, 0, 1, null);
		Planet planet2 = new Planet(0, 0, 0, 0, 2, null);
		
		//Act
		int result = new MassComparator().compare(planet1, planet2);
		
		//Assert
		assertEquals(-1, result);
	}
	
	@Test
	public void Compare_FirstPlanetLarger_ReturnsPositive() {
		//Arrange
		Planet planet1 = new Planet(0, 0, 0, 0, 3, null);
		Planet planet2 = new Planet(0, 0, 0, 0, 2, null);
		
		//Act
		int result = new MassComparator().compare(planet1, planet2);
		
		//Assert
		assertEquals(1, result);
	}
	
	@Test
	public void Compare_PlanetsSameMass_ReturnsZero() {
		//Arrange
		Planet planet1 = new Planet(0, 0, 0, 0, 1, null);
		Planet planet2 = new Planet(0, 0, 0, 0, 1, null);
		
		//Act
		int result = new MassComparator().compare(planet1, planet2);
		
		//Assert
		assertEquals(0, result);
	}

}

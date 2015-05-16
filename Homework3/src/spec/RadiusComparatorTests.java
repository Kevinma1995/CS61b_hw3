package spec;

import static org.junit.Assert.*;
import hw3.Planet;
import hw3.RadiusComparator;

import org.junit.Test;

public class RadiusComparatorTests {

	@Test
	public void Compare_FirstPlanetSmaller_ReturnsNegative() {
		//Arrange
		Planet planet1 = new Planet(0, 0, 0, 0, 0, null);
		Planet planet2 = new Planet(0, 0, 0, 0, 0, null);
		planet1.setRadius(1);
		planet2.setRadius(2);
		
		//Act
		int result = new RadiusComparator().compare(planet1, planet2);
		
		//Assert
		assertEquals(-1, result);
	}
	
	@Test
	public void Compare_FirstPlanetLarger_ReturnsPositive() {
		//Arrange
		Planet planet1 = new Planet(0, 0, 0, 0, 0, null);
		Planet planet2 = new Planet(0, 0, 0, 0, 0, null);
		planet1.setRadius(3);
		planet2.setRadius(2);
		
		//Act
		int result = new RadiusComparator().compare(planet1, planet2);
		
		//Assert
		assertEquals(1, result);
	}
	
	@Test
	public void Compare_PlanetsSameRadius_ReturnsZero() {
		//Arrange
		Planet planet1 = new Planet(0, 0, 0, 0, 0, null);
		Planet planet2 = new Planet(0, 0, 0, 0, 0, null);
		planet1.setRadius(2);
		planet2.setRadius(2);
		
		//Act
		int result = new RadiusComparator().compare(planet1, planet2);
		
		//Assert
		assertEquals(0, result);
	}

}

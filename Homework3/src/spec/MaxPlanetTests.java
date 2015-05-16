package spec;

import static org.junit.Assert.*;
import hw3.MassComparator;
import hw3.MaxPlanet;
import hw3.Planet;
import hw3.RadiusComparator;

import org.junit.Test;

public class MaxPlanetTests {

	@Test
	public void MaxPlanet_FourDifferentSizePlanets_ReturnsLargestRadius() {
		//Arrange
		Planet planet1 = new Planet(0, 0, 0, 0, 0, null);
		Planet planet2 = new Planet(0, 0, 0, 0, 0, null);
		Planet planet3 = new Planet(0, 0, 0, 0, 0, null);
		Planet planet4 = new Planet(0, 0, 0, 0, 0, null);
		planet1.setRadius(1);
		planet2.setRadius(2);
		planet3.setRadius(3);
		planet4.setRadius(4);
		
		Planet[] planets = new Planet[] {planet1, planet2, planet3, planet4};
		
		//Act
		Planet max = MaxPlanet.maxPlanet(planets, new RadiusComparator());
		
		//Assert
		assertEquals(planet4, max);
	}
	
	@Test
	public void MaxPlanet_FourDifferentMassPlanets_ReturnsLargestMass() {
		//Arrange
		Planet planet1 = new Planet(0, 0, 0, 0, 1, null);
		Planet planet2 = new Planet(0, 0, 0, 0, 10, null);
		Planet planet3 = new Planet(0, 0, 0, 0, 1110, null);
		Planet planet4 = new Planet(0, 0, 0, 0, 110, null);
		
		Planet[] planets = new Planet[] {planet1, planet2, planet3, planet4};
		
		//Act
		Planet max = MaxPlanet.maxPlanet(planets, new MassComparator());
		
		//Assert
		assertEquals(planet3, max);
	}

}

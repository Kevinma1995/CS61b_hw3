package animals;

public class AnimalLauncher {
	public static void main(String[] args){
		
		//Q1
		System.out.print("1:");
		Animal a0 = new Animal();   // Line 1
		
		System.out.print("2:");
		Fox f0 = new Fox();         // Line 2
		
		System.out.print("3:");
		a0.speak();                 // Line 3
		
		System.out.print("4:");
		f0.speak();                 // Line 4
		
		System.out.print("5:");
		((Animal) f0).speak();      // Line 5
		
		System.out.print("6:");
		((Fox) a0).speak();         // Line 6
	
		
		/*//Q2
		System.out.print("1:");
		Animal a1 = new Fox();
		System.out.print("2:");
		a1.speak();
		System.out.print("3:");
		((Animal) a1).speak();*/
		
		//Q3
		/*System.out.print("1:");
		Animal a2 = new Animal();
		
		System.out.print("2:");
		System.out.println(a2.name);
		
		System.out.print("3:");
		Animal a3 = new Fox("SuperFox");
		
		System.out.print("4:");
		System.out.println(a3.name);
		
		System.out.print("5:");
		System.out.println(((Animal) a3).name);*/
		
	}
}

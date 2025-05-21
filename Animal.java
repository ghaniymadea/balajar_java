package belajar_2;

public class Animal {
     
        public void animalSound() {
          System.out.println("The animal makes a sound");
        }
      }
      
      class Pig extends Animal {
        public void animalSound() {
          System.out.println("The pig says: khok khok");
        }
      }
      
      class Dog extends Animal {
        public void animalSound() {
          System.out.println("The dog says: guk guk");
        }
      }
      
      class Main {
        public static void main(String[] args) {
          Animal myAnimal = new Animal();  // Create a Animal object
          Animal myPig = new Pig();  // Create a Pig object
          Animal myDog = new Dog();  // Create a Dog object
          myAnimal.animalSound();
          myPig.animalSound();
          myDog.animalSound();
        }
      }


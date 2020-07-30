import java.util.*;

class WordStoreImp implements WordStore{
	String[] theArray;
	int arraySize;
	int itemsInArray = 0;
	
	public WordStoreImp(int size){
		arraySize = size; //saving the size of array in object
		theArray = new String[size]; //initialising array with size from argument
		Arrays.fill(theArray, "-1"); // fills entire array with -1
	}
	
	public void add(String word){
		int hash = 7;
		for (int i = 0; i < word.length(); i++) {
			hash = hash*31 + word.charAt(i);
			hash = hash % arraySize;
		}
		int arrayIndex = hash;
		while (theArray[arrayIndex] != "-1") {
				++arrayIndex;
				System.out.println("Collision Try " + arrayIndex + " Instead");
				// If we get to the end of the array go back to index 0
				arrayIndex %= arraySize;
			}
			theArray[arrayIndex] = word; 
	}
	
	public int count(String word){
		int hash = 7;
		for (int i = 0; i < word.length(); i++) {
			hash = hash*31 + word.charAt(i);
			hash = hash % arraySize;
		}
		int counter = 0;
		int track = hash;
		while(theArray[track].equals(word)){
			counter++;
			track++;
		}
		return counter;
	}
	
	public void remove(String word){
	
	}
}
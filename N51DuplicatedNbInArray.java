/* https://github.com/zhedahht/ChineseCodingInterviewAppendix/blob/master/DuplicationInArray/FindDuplication.cpp
 * Question Description:
 * An array contains n numbers ranging from 0 to n-1. 
 * There are some numbers duplicated in the array. It is not clear how many numbers are duplicated or 
 * how many times a number gets duplicated. How do you find a duplicated number in the array? 
 * For example, if an array of length 7 contains the numbers {2, 3, 1, 0, 2, 5, 3}, 
 * the implemented function (or method) should return either 2 or 3
*/
public class N51DuplicatedNbInArray {
  public static void main(String[] args) {

  }
  public static int findDuplicatedNb(int[] array) {
    if(array == null || array.length == 0) {
      throw new IllegalArgumentException("invalid array");
    }
    HashMap<Integer, Integer> appears = new HashMap<Integer, Integer>();
    for(int i=0; i<array.length; i++) {
      if(appears.get(array[i]) == null) {
        appears.put(array[i], 1);
      }
      else {
        return array[i];  //find the duplicated number
      }
    }
    return -1; // not found return -1, different with numbers [0,n-1]
  }
  public static int findDuplicate(int[] numbers) {
    if(numbers == null || numbers.length == 0) {
      throw new IllegalArgumentException("invalid input");
    }
    for(int i=0; i<numbers.length; i++) { // range check
      if(numbers[i] < 0 || numbers[i] > numbers.length-1) {
        return -1;
      }
    }
    for(int i=0; i<numbers.length; i++) {
      while(numbers[i] != i) {
        if(numbers[i] == numbers[numbers[i]]) {
          return numbers[i];
        }
        // swap numbers[i] with numbers[numbers[i]]
        int temp = numbers[i];
        numbers[i] = numbers[temp];
        numbers[temp] = temp;
      } // end while
    }// end for
    return -1; // not found return -1, different with numbers [0,n-1]
  }
}

package model;


public class ArraySizeMismatchException extends Exception {
	
	public ArraySizeMismatchException() {
	}
	
	@Override
	public String toString(){
		return "The array Sizes do not match";
	}
}

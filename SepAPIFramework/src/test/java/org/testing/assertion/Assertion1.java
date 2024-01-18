package org.testing.assertion;

public class Assertion1 {
	
	public static Boolean assertion(int actual, int expected)
	{
		if(actual==expected)
		{
			System.out.println("Assertion getting pass");
			return true;
		}
		else
		{
			System.out.println("Assertion getting failed");
			return false;
		}
	}
	public static Boolean assertion(String actual, String expected)
	{
		if(actual.equals(expected))
		{
			System.out.println("Assertion getting pass");
			return true;
		}
		else
		{
			System.out.println("Assertion getting failed");
			return false;
		}
	}
}

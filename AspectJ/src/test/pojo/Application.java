package test.pojo;

public class Application
{
	public static void main(String[] args)
	{
		TestPojo pojo = new TestPojo();
		
		// should throw IllegalArgumentException here
		pojo.setO(null);
	}
}

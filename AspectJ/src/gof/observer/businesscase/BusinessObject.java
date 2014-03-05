package gof.observer.businesscase;


public class BusinessObject extends Object
{
	String businessAttribute;

	public void businessMethod() 
	{
		businessAttribute = "A value";
	}

	public static void main(String[] args) 
	{
		BusinessObject bo = new BusinessObject();
		bo.businessMethod();
		bo.businessAttribute = "B value";
	}
}

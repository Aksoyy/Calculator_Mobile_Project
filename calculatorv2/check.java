package calculatorv2;

public class check 
{
	int firstIntegerNumber;
	int secondIntegerNumber;

	double firstDoubleNumber;
	double secondDoubleNumber;

	public check() //Parametresiz constructor'ı belirtmektedir.
	{
		this.firstIntegerNumber = 0;
		this.secondIntegerNumber = 0;
		this.firstDoubleNumber = 0.0;
		this.secondDoubleNumber = 0.0;
	}

	//Alınan iki değeri integer'a çevirmeyi sağlayan metottur.
	public void checkInteger(String param1, String param2)
	{
		try 
		{
			this.firstIntegerNumber = Integer.parseInt(param1);
			this.secondIntegerNumber = Integer.parseInt(param2);
		} 
		catch (NumberFormatException e)
		{
			//deneme.info("error log message");
			throw new NumberFormatException("not a integer");
		} 
		finally 
		{
			/**/
			//java.util.logging.Logger.getLogger("test");
		}
	}
	
	//Alınan iki değeri double'a çevirmeyi sağlayan metottur.
	public void checkDouble(String param1, String param2)
	{
		try
		{
			this.firstDoubleNumber = Double.parseDouble(param1);
			this.secondDoubleNumber = Double.parseDouble(param2);
		}
		catch (NumberFormatException e)
		{
			throw new NumberFormatException("not a double");
		}
	}
	
	//Alınan değerleri double ve integer'a çeviren metottur.
	public void checkUpper(String param1, String param2)
	{
		try
		{
			this.firstDoubleNumber = Double.parseDouble(param1);
			this.firstIntegerNumber = Integer.parseInt(param2);
		}
		catch (NumberFormatException e)
		{
			throw new NumberFormatException("Not suitable");
		}
	}
		
	//Alınan değeri integer'a çeviren metottur.
	public void checkFacto(String param1)
	{
		try
		{
			this.firstIntegerNumber = Integer.parseInt(param1);
		}
		catch (NumberFormatException e)
		{
			throw new NumberFormatException("Not suitable");
		}
	}
}
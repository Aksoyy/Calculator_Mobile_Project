package calculatorv2;

import calculatorv2.check;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Arithmetic
{
	/* Log tutulması için gerekli tanımlamaları belirtir. */
	public FileHandler fh;
	public Logger logger = Logger.getLogger("Log");
	
	public void main(String[] args)
	{
		// TODO Auto-generated method stub
		  try
		  {
			  fh = new FileHandler("MyLogFile.log",true);
			  logger.addHandler(fh);
			  SimpleFormatter formatter = new SimpleFormatter();
	  	  	  fh.setFormatter(formatter); 
	  	  	  
	  	  	  logger.info("DENEME");
	      }
		  catch( SecurityException e)
		  {
		  		e.printStackTrace();
		  }
		  catch( IOException e)
		  {
		  		e.printStackTrace();
		  }
	}
	
	//Kullanıcıdan alınan 2 değeri toplamaktadır.
	public double addition( String param1, String param2)
	{
		check check1 = new check();
		check1.checkDouble(param1, param2);
		return check1.firstDoubleNumber+check1.secondDoubleNumber;
	}
	
	//Kullanıcıdan alınan ilk değeri, ikinci değere bölmektedir.
	public double division( String param1, String param2)
	{
		check check1 = new check();
		check1.checkDouble(param1, param2);
		
		if( check1.secondDoubleNumber == 0 ) //Girilen Bölen değeri 0 ve 0'dan kucuk olamaz.
		{
			logger.info("Section value can not be 0");
			throw new NumberFormatException("Section value can not be 0");
		}
		return check1.firstDoubleNumber/check1.secondDoubleNumber;
	}
	
	//Kullanıcıdan alınan değerin faktöriyelini vermektedir.
	public int fakto( String param1)
	{
		check check1 = new check();
		check1.checkFacto(param1);
		
		if( check1.firstIntegerNumber < 0) //Girilen değer 0'dan kucuk olmamalıdır.
		{
			logger.info("Value can not be less than 0");
			throw new NumberFormatException("Value can not be less than 0");
		}
		else if ( check1.firstIntegerNumber == 0 || check1.firstIntegerNumber == 1 ) 
		{
			return 1;	// (0!=1) || (1!=1)
		}
		else
		{
			int result=2;
			for ( int i=2; i<check1.firstIntegerNumber ; i+=1 )
			{
				result *= (i+1);
			}
			return result;
		}
	}
	
	//Kullanıcıdan alınan 2 değerdeki ilk değerin üstünü almaktadır.
	public double getUpper( String param1, String degree)
	{
		check check1 = new check();
		check1.checkUpper(param1, degree);
		
		if( check1.firstIntegerNumber < 0 ) //Üst derece 0'dan buyuk olmamalıdır.
		{
			logger.info("Value can not be less than 0");
			throw new NumberFormatException("Value can not be less than 0");
		}
		else if( check1.firstIntegerNumber == 0 ) // x^0=1'dir
		{
			return 1;
		}
		else
		{
			double result=check1.firstDoubleNumber;
			for( int i=1; i<check1.firstIntegerNumber; i++ )
			{
				result *= check1.firstDoubleNumber;
			}
			return result;
		}
	}
	
	//Kullanıcıdan alınan ilk değerin, ikinci değere modunu almaktadır.
	public int mode( String param1, String param2)
	{
		check check1 = new check();
		check1.checkInteger(param1, param2);
		
		if( check1.secondIntegerNumber < 0 ) //Mod degeri 0'dan kucuk degerde bulanamaz.
		{
			logger.info("Value can not be less than 0");
			throw new NumberFormatException("Value can not be less than 0");
		}
		else if( check1.secondIntegerNumber == 0 || check1.firstIntegerNumber<check1.secondIntegerNumber )
		{
			return check1.firstIntegerNumber;
		}
		else
		{
			return check1.firstIntegerNumber%check1.secondIntegerNumber;
		}
	}
	
	//Kullanıcıdan alınan 2 değerin çarpımını bulmaktadır.
	public double multiplication( String param1, String param2)
	{
		check check1 = new check();
		check1.checkDouble(param1, param2);
		
		/*if( check1.firstDoubleNumber<0 || check1.secondDoubleNumber<0 )
		{
			logger.info("Value can not be less than 0");
			throw new NumberFormatException("Value can not be less than 0");
		}*/
		return check1.firstDoubleNumber*check1.secondDoubleNumber;
	}
	
	//Kullanıcıdan alınan 2 değerin farkını almaktadır.
	public double subtraction( String param1, String param2)
	{
		check check1 = new check();
		check1.checkDouble(param1, param2);
		
		return check1.firstDoubleNumber-check1.secondDoubleNumber;
	}
}
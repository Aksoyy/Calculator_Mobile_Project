package com.hkn.calculator;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

/*
 * Web servis ile bağlantının yapıldığı yeri belirtmektedir.
 */
public class OperationsImpl implements IOperations
{
	private static final String NAMESPACE = "http://calculatorv2/";
	private static final String SERVICE_URL = "http://192.168.56.1:8080/calculatorv2/services/Arithmetic?wsdl";

	private static final String CALC_SUM = "addition";
	private static final String CALC_DIV = "division";
	private static final String CALC_MINUS = "subtraction";
	private static final String CALC_MODE = "mode";
	private static final String CALC_UPPER = "getUpper";
	private static final String CALC_MULTIPLICATION = "multiplication";

	/*
	 * Kullanıcı tarafından belirlenen metoda gitmeyi
	 * sağlayan kısımdır.
	 */
	private CalcResult CommonOperator(CalcInput input, String operator)
	{
		CalcResult result = new CalcResult();
		SoapObject request = new SoapObject(NAMESPACE, operator);
		request.addProperty("param1", input.firstNumber);
		request.addProperty("param2", input.secondNumber);

		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		envelope.dotNet = true;
		envelope.encodingStyle = SoapEnvelope.ENC; // ksoap2'de eklenmemişti.
		envelope.setAddAdornments(false); // ksoap2'de eklenmemişti.
		envelope.implicitTypes = false; // ksoap2'de eklenmemişti.
		envelope.setOutputSoapObject(request);

		HttpTransportSE androidHTTPTransport = new HttpTransportSE(SERVICE_URL);
		try
		{
			androidHTTPTransport.call(NAMESPACE + operator, envelope);
			if (envelope.bodyIn instanceof SoapObject)
			{
				SoapObject soapObject = (SoapObject) envelope.bodyIn;

				result.result = Double.parseDouble(soapObject.getProperty(0)
						.toString());
			}
		}
		catch (Exception exp)
		{
			return null;
		}
		return result;
	}

	public CalcResult Sum(CalcInput input) 
	{
		return CommonOperator(input, CALC_SUM);
	}

	public CalcResult getUpper(CalcInput input)
	{
		return CommonOperator(input, CALC_UPPER);
	}

	public CalcResult Minus(CalcInput input)
	{
		return CommonOperator(input, CALC_MINUS);
	}

	public CalcResult Division(CalcInput input)
	{
		return CommonOperator(input, CALC_DIV);
	}

	public CalcResult Mode(CalcInput input)
	{
		return CommonOperator(input, CALC_MODE);
	}

	public CalcResult Multi(CalcInput input)
	{
		return CommonOperator(input, CALC_MULTIPLICATION);
	}
}
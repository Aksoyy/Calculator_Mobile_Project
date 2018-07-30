package com.hkn.calculator;

import com.example.calc2.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.os.AsyncTask;
import android.widget.Toast;
/* Uygulamada kullanılan metodlarla görsel kısmı belirten 
 * yapının bağlantısı sağlayan bölümdür.
 */

public class MainActivity extends Activity 
{
	Button sum, minus, div, mode, multi, upper;
	EditText first, second;
	
	/*
	 * Butonların aktifliğinde kullanılan yapıdaki
	 * ortak kısmı belirtir. Bu metodu kullanarak
	 * kod tekrarı engellenmeye çalışılmıştır.
	 */
	private void CommonClick(String operator)
	{
		CalcAsyncTask task = new CalcAsyncTask();
		CalcInput input = new CalcInput();
		
		input.firstNumber = first.getText().toString();
		input.secondNumber = second.getText().toString();

		task.input = input;
		task.execute(operator);
	}

	/*
	 * Activity dosyaları ilk çalıştıklarında onCreate metodu
	 * devreye girer. Bu metotta genel olarak setContentView
	 * metodu çalıştırılarak bir layout dosyasından ekran tasarımı
	 * yüklenir. Eğer ekran ilk oluştuğunda tanımlanması gereken
	 * başka değişkenler ve aksiyonlar varsa, onlar da onCreate
	 * metodu içinde gerçekleştirilebilirler.
	 */

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		sum = (Button) findViewById(R.id.sum);
		first = (EditText) findViewById(R.id.first);
		second = (EditText) findViewById(R.id.second);
		minus = (Button) findViewById(R.id.minus);
		div = (Button) findViewById(R.id.division);
		mode = (Button) findViewById(R.id.mode);
		multi = (Button) findViewById(R.id.multi);
		upper = (Button) findViewById(R.id.getUpper);

		minus.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				CommonClick("Minus");
			}
		});
	
		upper.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				CommonClick("Upper");
			}
		});
		
		sum.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				CommonClick("Sum");
			}
		});
		
		div.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				CommonClick("Div");
			}
		});
		
		mode.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				CommonClick("Mode");
			}
		});
		
		multi.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				CommonClick("Multi");
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		int id = item.getItemId();
		if (id == R.id.action_settings)
		{
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	private class CalcAsyncTask extends AsyncTask<String, Void, String>
	{
		public CalcInput input;
		public CalcResult calcResult = new CalcResult();

		/*
		 * Kullanıcı tarafından seçilen işlemi
		 * belirlemeyi sağlayan metottur.
		 */
		@Override
		protected String doInBackground(String... urls)
		{
			IOperations i = new OperationsImpl();
			if (urls[0] == "Sum")
			{
				calcResult = i.Sum(input);
			}
			else if (urls[0] == "Minus")
			{
				calcResult = i.Minus(input);
			}
			else if (urls[0] == "Div")
			{
				calcResult = i.Division(input);
			}
			else if (urls[0] == "Mode")
			{
				calcResult = i.Mode(input);
			}
			else if (urls[0] == "Multi")
			{
				calcResult = i.Multi(input);
			}
			else if (urls[0] == "Upper")
			{
				calcResult = i.getUpper(input);
			}
			return "";
		}

		@Override
		protected void onPostExecute(String result) 
		{
			Toast.makeText(getApplicationContext(), "Doğrulama Sonucu : " + calcResult.result,
					Toast.LENGTH_LONG).show();
		}
	}
}
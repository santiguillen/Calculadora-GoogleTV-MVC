package pem.tema5.vista;

import pem.tema5.AppMediador;
import pem.tema5.presentador.IPresentador;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class CalculadoraActivity extends Activity implements IVista, OnClickListener{
	
	private IPresentador presentador;
	private TextView textView;
	private Button cero, uno, dos, tres, cuatro, cinco, seis, siete, ocho, 
				nueve, C, suma, resta, multiplica, divide, sqrt, log, igual;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calculadora);		
		//Presentador y vista
		presentador = AppMediador.getInstance().getPresentador();
		AppMediador.getInstance().setVista(this);		
		//Referenciamos todos los botones
		textView = (TextView) findViewById(R.id.textView1);		
		cero = (Button) findViewById(R.id.cero);
		uno = (Button) findViewById(R.id.uno);
		dos = (Button) findViewById(R.id.dos);
		tres = (Button) findViewById(R.id.tres);
		cuatro = (Button) findViewById(R.id.cuatro);
		cinco = (Button) findViewById(R.id.cinco);
		seis = (Button) findViewById(R.id.seis);
		siete = (Button) findViewById(R.id.siete);
		ocho = (Button) findViewById(R.id.ocho);
		nueve = (Button) findViewById(R.id.nueve);
		C = (Button) findViewById(R.id.C);
		suma = (Button) findViewById(R.id.suma);
		resta = (Button) findViewById(R.id.resta);
		multiplica = (Button) findViewById(R.id.multiplica);
		divide = (Button) findViewById(R.id.divide);
		sqrt = (Button) findViewById(R.id.sqrt);
		log = (Button) findViewById(R.id.log);
		igual = (Button) findViewById(R.id.igual);
		//asignamos un listener a cada botón, para que actúen cuando se pulsan sobre ellos.
		cero.setOnClickListener(this);
		uno.setOnClickListener(this);
		dos.setOnClickListener(this);
		tres.setOnClickListener(this);
		cuatro.setOnClickListener(this);
		cinco.setOnClickListener(this);
		seis.setOnClickListener(this);
		siete.setOnClickListener(this);
		ocho.setOnClickListener(this);
		nueve.setOnClickListener(this);
		C.setOnClickListener(this);
		suma.setOnClickListener(this);
		resta.setOnClickListener(this);
		multiplica.setOnClickListener(this);
		divide.setOnClickListener(this);
		sqrt.setOnClickListener(this);
		log.setOnClickListener(this);
		igual.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.calculadora, menu);
		return true;
	}

	@Override
	public void mostrarResultado(double resultado) {
		textView.setText(Double.toString(resultado));		
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		
		case R.id.cero:
			presentador.obtieneNumero(0);			
			break;
		case R.id.uno:
			presentador.obtieneNumero(1);			
			break;
		case R.id.dos:
			presentador.obtieneNumero(2);			
			break;
		case R.id.tres:
			presentador.obtieneNumero(3);			
			break;
		case R.id.cuatro:
			presentador.obtieneNumero(4);			
			break;
		case R.id.cinco:
			presentador.obtieneNumero(5);			
			break;
		case R.id.seis:
			presentador.obtieneNumero(6);			
			break;
		case R.id.siete:
			presentador.obtieneNumero(7);			
			break;		
		case R.id.ocho:
			presentador.obtieneNumero(8);			
			break;
		case R.id.nueve:
			presentador.obtieneNumero(9);			
			break;
		case R.id.suma:
			presentador.obtieneOperacion('+');			
			break;
		case R.id.resta:
			presentador.obtieneOperacion('-');			
			break;
		case R.id.divide:
			presentador.obtieneOperacion('/');			
			break;
		case R.id.multiplica:
			presentador.obtieneOperacion('*');			
			break;
		case R.id.sqrt:
			presentador.obtieneOperacion('s');			
			break;
		case R.id.log:
			presentador.obtieneOperacion('l');			
			break;
		case R.id.igual:
			presentador.obtieneOperacion('=');
			break;
		case R.id.C:
			presentador.limpiaCalculadora();
			break;

		default:
			break;
		}
	}

}

package pem.tema5.presentador;

import android.util.Log;
import pem.tema5.AppMediador;
import pem.tema5.modelo.Calculadora;
import pem.tema5.modelo.ICalculadora;

public class Presentador implements IPresentador {
	
	private double numeroIntroducido, resultado; 
	private char operador = ' '; //Iniciamos el operador como espacio en blanco (no se ha seleccionados ning�n operador)
	
	private ICalculadora calculadora;
	
	public Presentador() {
		calculadora = new Calculadora();
	}

	@Override
	public void obtieneNumero(double numero) {
		//capturamos los d�gitos pulsados y lo presentamos en pantalla
		numeroIntroducido = (numeroIntroducido*10)+numero;
		AppMediador.getInstance().getVista().mostrarResultado(numeroIntroducido);
		//Una vez que hemos presentado el resultado de alguna operaci�n, se reinicia el valor operador
		if (operador == '=')
			operador = ' ';
		
	}

	@Override
	public void obtieneOperacion(char operacion) {		
		//Cuando seleccionamos el valor operador guardamos el primer n�mero introducido
		if (operador == ' '){
			resultado = numeroIntroducido;
		//Si ya hab�amos introducido el primer numero, realizamos la operaci�n
		} else {
			realizaOperacion(operador);			
		}
		//cargamos el valor del operador introducido
		operador = operacion;
		
		//si el operador es 'igual', 'ra�z' o 'logaritmo'  directamente realizamos la operaci�n
		if (operador == '=' ){
			realizaOperacion(operador);			
		}
		//se reinicia el valor del n�mero introducido
		numeroIntroducido = 0;
	}

	@Override
	public void limpiaCalculadora() {
		//eliminamos todos los datos guardados en las variables de la calculadora y 
		//limpiamos la pantalla
		numeroIntroducido = 0;
		resultado = 0;
		operador = ' ';
		AppMediador.getInstance().getVista().mostrarResultado(0);		
	}
	
	private void realizaOperacion(char operador){ 
		switch (operador) {
		case '+':
			resultado = calculadora.sumar(resultado, numeroIntroducido);
			break;
		case '-':
			resultado = calculadora.restar(resultado, numeroIntroducido);
			break;
		case '*':
			resultado = calculadora.multiplicar(resultado, numeroIntroducido);		
			break;
		case '/':
			resultado = calculadora.dividir(resultado, numeroIntroducido);
			break;
		case 's':
			Log.v("antes", Double.toString(resultado));
			resultado = calculadora.raiz(resultado);
			Log.v("despues", Double.toString(resultado));
			break;
		case 'l':
			resultado =calculadora.logaritmo(resultado);
			break;
		case '=':
			AppMediador.getInstance().getVista().mostrarResultado(resultado);
			break;
		default:
			break;
		}
	}

}

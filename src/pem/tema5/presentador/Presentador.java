package pem.tema5.presentador;

import android.util.Log;
import pem.tema5.AppMediador;
import pem.tema5.modelo.Calculadora;
import pem.tema5.modelo.ICalculadora;

public class Presentador implements IPresentador {
	
	private double numeroIntroducido, resultado; 
	private char operador = ' '; //Iniciamos el operador como espacio en blanco (no se ha seleccionados ningún operador)
	
	private ICalculadora calculadora;
	
	public Presentador() {
		calculadora = new Calculadora();
	}

	@Override
	public void obtieneNumero(double numero) {
		//capturamos los dígitos pulsados y lo presentamos en pantalla
		numeroIntroducido = (numeroIntroducido*10)+numero;
		AppMediador.getInstance().getVista().mostrarResultado(numeroIntroducido);
		//Una vez que hemos presentado el resultado de alguna operación, se reinicia el valor operador
		if (operador == '=')
			operador = ' ';
		
	}

	@Override
	public void obtieneOperacion(char operacion) {		
		//Cuando seleccionamos el valor operador guardamos el primer número introducido
		if (operador == ' '){
			resultado = numeroIntroducido;
		//Si ya habíamos introducido el primer numero, realizamos la operación
		} else {
			realizaOperacion(operador);			
		}
		//cargamos el valor del operador introducido
		operador = operacion;
		
		//si el operador es 'igual', 'raíz' o 'logaritmo'  directamente realizamos la operación
		if (operador == '=' ){
			realizaOperacion(operador);			
		}
		//se reinicia el valor del número introducido
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

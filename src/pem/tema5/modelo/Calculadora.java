package pem.tema5.modelo;

public class Calculadora implements ICalculadora {

	@Override
	public double sumar(double a, double b) {
		return a+b;
	}

	@Override
	public double restar(double a, double b) {
		return a-b;
	}

	@Override
	public double multiplicar(double a, double b) {
		return a*b;
	}

	@Override
	public double dividir(double a, double b) {
		return a/b;
	}

	@Override
	public double raiz(double a) {
		return Math.sqrt(a);
	}

	@Override
	public double logaritmo(double a) {
		return Math.log(a);
	}

}

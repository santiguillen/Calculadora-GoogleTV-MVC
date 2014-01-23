package pem.tema5;

import pem.tema5.presentador.IPresentador;
import pem.tema5.presentador.Presentador;
import pem.tema5.vista.IVista;
import android.app.Application;

public class AppMediador extends Application {
	
	private static AppMediador singleton;
	
	private IPresentador presentador;
	private IVista vista;	
	
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		presentador = new Presentador();
		singleton = this;
	}

	public static AppMediador getInstance() {
		return singleton;
	}

	public IPresentador getPresentador() {
		return presentador;
	}

	public void setPresentador(IPresentador presentador) {
		this.presentador = presentador;
	}

	public IVista getVista() {
		return vista;
	}

	public void setVista(IVista vista) {
		this.vista = vista;
	}

}

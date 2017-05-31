/*
 * Copyright (c) 2017. Esta obra está sujeta a la licencia Reconocimiento 4.0 Internacional de Creative Commons.
 * Para ver una copia de esta licencia, visite http://creativecommons.org/licenses/by/4.0/.
 */

package es.uji.al341823.telefonia.gui.console.facturas;

import es.uji.al341823.telefonia.api.AdministradorMenus;
import es.uji.al341823.telefonia.api.excepciones.ObjetoNoExisteException;
import es.uji.al341823.telefonia.facturacion.Factura;
import es.uji.al341823.telefonia.gui.console.Menu;

/**
 * @author Juanjo González (al341823)
 * @since 0.2
 */
public class MenuRecuperarDatosFactura extends Menu {
	public MenuRecuperarDatosFactura(Menu padre) {
		super(padre);
	}

	@Override
	public void mostrar() {
		AdministradorMenus.imprimeTitulo(this);

		int codigo = AdministradorMenus.leerEntero("Introduce el codigo de la factura: ");

		System.out.println();

		try {
			Factura factura = this.getAdministradorDatos().getFactura(codigo);
			System.out.println("Información de la factura: " + factura);
		} catch (ObjetoNoExisteException e) {
			System.out.println("No existe ninguna factura con ese codigo");
		}

		AdministradorMenus.esperarParaContinuar();
	}

	@Override
	public String getTitulo() {
		return "Recuperar datos factura";
	}
}

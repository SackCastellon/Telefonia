/*
 * Copyright (c) 2017. Esta obra está sujeta a la licencia Reconocimiento 4.0 Internacional de Creative Commons.
 * Para ver una copia de esta licencia, visite http://creativecommons.org/licenses/by/4.0/.
 */

package es.uji.al341823.telefonia.gui.console.clientes;

import es.uji.al341823.telefonia.api.TipoDato;
import es.uji.al341823.telefonia.api.excepciones.ObjetoNoExisteException;
import es.uji.al341823.telefonia.gui.console.Menu;

/**
 * Clase del menu para dar de baja un cliente
 *
 * @author Juanjo González (al341823)
 * @since 0.2
 */
public class MenuBajaCliente extends Menu {

	public MenuBajaCliente(Menu padre) {
		super(padre);
	}

	@Override
	public void mostrar() {
		this.getAdministradorMenus().imprimeTitulo(this);

		String nif = this.getAdministradorMenus().leerDato("Introduce el NIF del cliente: ", TipoDato.NIF);

		System.out.println();

		try {
			this.getAdministradorDatos().removeCliente(nif);
			System.out.println("Cliente eliminado con éxito");
		} catch (ObjetoNoExisteException e) {
			System.out.println("No existe ningún cliente con NIF '" + nif + "'");
		}

		this.getAdministradorMenus().esperarParaContinuar();
	}

	@Override
	public String getTitulo() {
		return "Baja cliente";
	}
}

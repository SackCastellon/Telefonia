/*
 * Copyright (c) 2017. Esta obra está sujeta a la licencia Reconocimiento 4.0 Internacional de Creative Commons.
 * Para ver una copia de esta licencia, visite http://creativecommons.org/licenses/by/4.0/.
 */

package es.uji.al341823.telefonia.gui.console.menu.clientes;

import es.uji.al341823.telefonia.gui.console.menu.Menu;
import es.uji.al341823.telefonia.gui.console.menu.clientes.alta.AltaClienteEmpresa;
import es.uji.al341823.telefonia.gui.console.menu.clientes.alta.AltaClienteParticular;

/**
 * Clase del menu para dar de alta a un cliente
 *
 * @author Juanjo González (al341823)
 * @since 0.2
 */
public class AltaCliente extends Menu {

	public AltaCliente(Menu padre) {
		super(padre);
	}

	@Override
	public String getTitulo() {
		return "Alta cliente";
	}

	@Override
	public Menu[] getSubmenus() {
		return new Menu[] {new AltaClienteParticular(this), new AltaClienteEmpresa(this)};
	}

}

/*
 * Copyright (c) 2017. Esta obra está sujeta a la licencia Reconocimiento 4.0 Internacional de Creative Commons.
 * Para ver una copia de esta licencia, visite http://creativecommons.org/licenses/by/4.0/.
 */

package es.uji.al341823.telefonia.gui.console.clientes.tarifa;

import es.uji.al341823.telefonia.api.excepciones.ObjetoNoExisteException;
import es.uji.al341823.telefonia.api.fabricas.FabricaTarifas;
import es.uji.al341823.telefonia.api.fabricas.TipoTarifa;
import es.uji.al341823.telefonia.clientes.Cliente;
import es.uji.al341823.telefonia.facturacion.tarifas.Tarifa;
import es.uji.al341823.telefonia.facturacion.tarifas.TarifaExtra;
import es.uji.al341823.telefonia.gui.console.Menu;

/**
 * @author Juanjo González (al341823)
 * @author David Agost (al341819)
 * @since 0.3
 */
public class MenuCambiarTarifaExtra extends Menu {
	public MenuCambiarTarifaExtra(Menu padre) {
		super(padre);
	}

	@Override
	public void mostrar() {
		this.getAdministradorMenus().imprimeTitulo(this);

		String nif = this.getAdministradorMenus().leerNIF();

		try {
			Cliente cliente = this.getAdministradorDatos().getCliente(nif);
			Tarifa tarifaBase = cliente.getTarifa();
			FabricaTarifas fabricaTarifas = new FabricaTarifas();

			TarifaExtra[] tarifasExtra = {
					fabricaTarifas.getTarifaExtra(tarifaBase, TipoTarifa.Extra.TARDES),
					fabricaTarifas.getTarifaExtra(tarifaBase, TipoTarifa.Extra.DOMINGOS)};

			Tarifa tarifa = this.getAdministradorMenus().seleccionarOpciones(tarifasExtra);

			cliente.setTarifa(tarifa);
		} catch (ObjetoNoExisteException e) {
			System.out.println("No existe ningún cliente con NIF '" + nif + "'");
		} finally {
			System.out.println();
			this.getAdministradorMenus().esperarParaContinuar();
		}
	}

	@Override
	public String getTitulo() {
		return "Cambiar tarifa extra";
	}

	@Override
	public Menu[] getSubmenus() {
		return new Menu[0];
	}
}

package es.uji.al341823.telefonia.gui.console.menu.clientes;

import es.uji.al341823.telefonia.api.manager.DataManager;
import es.uji.al341823.telefonia.api.manager.EnumTipoDato;
import es.uji.al341823.telefonia.api.excepciones.ClienteYaExisteExcepcion;
import es.uji.al341823.telefonia.clientes.Direccion;
import es.uji.al341823.telefonia.facturacion.Tarifa;
import es.uji.al341823.telefonia.api.manager.MenuManager;
import es.uji.al341823.telefonia.gui.console.menu.Menu;

import java.time.LocalDateTime;

/**
 * Created by juanjo on 3/16/17.
 */
class AltaParticular extends Menu {
	public AltaParticular(Menu padre) {
		super(padre);
	}

	@Override
	public void mostrar() {
		MenuManager.imprimeTitulo(this);

		System.out.println("Introduce los datos del particular:");

		System.out.println();

		String nombre = MenuManager.leerTexto(" - Nombre: ", EnumTipoDato.TEXTO);
		String apellidos = MenuManager.leerTexto(" - Apellidos: ", EnumTipoDato.TEXTO);
		String nif = MenuManager.leerTexto(" - NIF: ", EnumTipoDato.NIF);
		Direccion direccion = MenuManager.leerDireccion(" - Dirección: ");
		String email = MenuManager.leerTexto(" - E-mail: ", EnumTipoDato.EMAIL);
		LocalDateTime fecha = MenuManager.leerFecha(" - Fecha de alta: ");
		Tarifa tarifa = new Tarifa(MenuManager.leerNumero(" - Tarifa: "));

		System.out.println();

		try {
			DataManager.altaParticular(nombre, apellidos, nif, direccion, email, fecha, tarifa);
			System.out.println("Cliente añadido con éxito");
		} catch (ClienteYaExisteExcepcion e) {
			System.out.println("Ya existe un cliente con NIF '" + nif + "'");
		}

		MenuManager.esperarParaContinuar();
	}

	@Override
	public String getTitulo() {
		return "Prticular";
	}

	@Override
	public Menu[] getSubmenus() {
		return null;
	}
}
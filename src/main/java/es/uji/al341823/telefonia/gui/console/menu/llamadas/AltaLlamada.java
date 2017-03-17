package es.uji.al341823.telefonia.gui.console.menu.llamadas;

import es.uji.al341823.telefonia.api.manager.EnumTipoDato;
import es.uji.al341823.telefonia.clientes.Cliente;
import es.uji.al341823.telefonia.api.manager.MenuManager;
import es.uji.al341823.telefonia.gui.console.menu.Menu;
import es.uji.al341823.telefonia.llamadas.Llamada;

import java.time.LocalDateTime;

/**
 * Created by Juanjo on 16/03/2017.
 */
class AltaLlamada extends Menu {
	public AltaLlamada(Menu padre) {
		super(padre);
	}

	@Override
	public void mostrar() {
		MenuManager.imprimeTitulo(this);

		Cliente cliente = MenuManager.leerClienteNIF();

		if (cliente == null) return;

		System.out.println("Introduce los siguientes datos de la llamada:");

		String origen = MenuManager.leerTexto(" - Numero de origen: ", EnumTipoDato.TELEFONO);
		String destino = MenuManager.leerTexto(" - Numero de destino: ", EnumTipoDato.TELEFONO);
		LocalDateTime fecha = MenuManager.leerFecha(" - Fecha de la llamada: ");
		int duracion = MenuManager.leerEntero(" - Duracion de la llamada en segundos: ");

		Llamada llamada = new Llamada(origen, destino, fecha, duracion);

		cliente.altaLlamada(llamada);

		System.out.println("Llamada añadida con éxito");

		MenuManager.esperarParaContinuar();
	}

	@Override
	public String getTitulo() {
		return "Alta llamada";
	}

	@Override
	public Menu[] getSubmenus() {
		return null;
	}
}
/*
 * Copyright (c) 2017. Esta obra está sujeta a la licencia Reconocimiento 4.0 Internacional de Creative Commons.
 * Para ver una copia de esta licencia, visite http://creativecommons.org/licenses/by/4.0/.
 */

package es.uji.al341823.telefonia.gui.console.llamadas;

import es.uji.al341823.telefonia.api.AdministradorMenus;
import es.uji.al341823.telefonia.api.TipoDato;
import es.uji.al341823.telefonia.clientes.Cliente;
import es.uji.al341823.telefonia.gui.console.Menu;
import es.uji.al341823.telefonia.llamadas.Llamada;

import java.time.LocalDateTime;

/**
 * Clase del menu para dar de alta una empresa
 *
 * @author Juanjo González (al341823)
 * @since 0.2
 */
public class AltaLlamada extends Menu {
	public AltaLlamada(Menu padre) {
		super(padre);
	}

	@Override
	public void mostrar() {
		AdministradorMenus.imprimeTitulo(this);

		Cliente cliente = AdministradorMenus.leerClienteNIF();

		if (cliente == null) return;

		System.out.println("Introduce los siguientes datos de la llamada:");

		String origen = AdministradorMenus.leerDato(" - Numero de origen: ", TipoDato.TELEFONO);
		String destino = AdministradorMenus.leerDato(" - Numero de destino: ", TipoDato.TELEFONO);
		LocalDateTime fecha = AdministradorMenus.leerFecha(" - Fecha de la llamada (AAAA-MM-DD hh:mm:ss | hoy): ");
		int duracion = AdministradorMenus.leerEntero(" - Duracion de la llamada en segundos: ");

		Llamada llamada = new Llamada(origen, destino, fecha, duracion);

		cliente.altaLlamada(llamada);

		System.out.println("Llamada añadida con éxito");

		AdministradorMenus.esperarParaContinuar();
	}

	@Override
	public String getTitulo() {
		return "Alta llamada";
	}
}

/*
 * Copyright (c) 2017. Esta obra está sujeta a la licencia Reconocimiento 4.0 Internacional de Creative Commons.
 * Para ver una copia de esta licencia, visite http://creativecommons.org/licenses/by/4.0/.
 */

package es.uji.al341823.telefonia.gui.console;

import es.uji.al341823.telefonia.api.AdministradorMenus;
import es.uji.al341823.telefonia.api.TipoDato;

import java.io.File;

/**
 * Clase del menu para cargar los datos desde un fichero
 *
 * @author Juanjo González (al341823)
 * @since 0.2
 */
public class MenuCargarDatos extends Menu {

	@Override
	public void mostrar() {
		AdministradorMenus.imprimeTitulo(this);

		String ruta = AdministradorMenus.leerDato("Introduce la ruta al fichero de datos: ", TipoDato.FICHERO_O_NINGUNO);

		System.out.println();

		if (ruta.isEmpty())
			System.out.println("Se canceló la carga de datos");
		else {
			getAdministradorDatos().setFicheroDatos(new File(ruta));
			getAdministradorDatos().cargarDatos();
		}

		AdministradorMenus.esperarParaContinuar();
	}

	@Override
	public String getTitulo() {
		return "Cargar datos desde fichero";
	}
}

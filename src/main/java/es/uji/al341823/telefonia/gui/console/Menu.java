/*
 * Copyright (c) 2017. Esta obra está sujeta a la licencia Reconocimiento 4.0 Internacional de Creative Commons.
 * Para ver una copia de esta licencia, visite http://creativecommons.org/licenses/by/4.0/.
 */

package es.uji.al341823.telefonia.gui.console;

import es.uji.al341823.telefonia.api.AdministradorDatos;
import es.uji.al341823.telefonia.api.AdministradorMenus;

import java.util.Scanner;

/**
 * @author Juanjo González (al341823)
 * @since 0.2
 */
public abstract class Menu {

	/** El scanner utilizado en todos los menús */
	public static final Scanner scanner = new Scanner(System.in);

	/** El menú padre de este menú */
	private final Menu padre;

	/** El administrador de datos que se encarga de añadir o borrar; clientes, llamadas o facturas, etc */
	private AdministradorDatos administradorDatos;

	/** El administrador de los menus que se encarga de pedir datos por pantalla */
	private AdministradorMenus administradorMenus;

	protected Menu(Menu padre) {
		super();
		this.padre = padre;
	}

	protected Menu() {
		this(null);
	}

	/**
	 * Devuelve el menú padre de este menú
	 *
	 * @return El menú padre
	 */
	public Menu getPadre() {
		return this.padre;
	}

	/**
	 * El metodo que se ejecuta para mostrar información por pantalla
	 */
	public void mostrar() {
		this.getAdministradorMenus().seleccionarSubmenu(this);
	}

	/**
	 * El titulo de este menú
	 *
	 * @return El titulo
	 */
	public abstract String getTitulo();

	/**
	 * Lista de los submenus de este menú
	 *
	 * @return Lista de submenus
	 */
	public Menu[] getSubmenus() {
		return new Menu[0];
	}

	public AdministradorDatos getAdministradorDatos() {
		return this.administradorDatos;
	}

	public void setAdministradorDatos(AdministradorDatos administradorDatos) {
		this.administradorDatos = administradorDatos;
	}

	public AdministradorMenus getAdministradorMenus() {
		return this.administradorMenus;
	}

	public void setAdministradorMenus(AdministradorMenus administradorMenus) {
		this.administradorMenus = administradorMenus;
	}
}

/*
 * Copyright (c) 2017. Esta obra está sujeta a la licencia Reconocimiento 4.0 Internacional de Creative Commons.
 * Para ver una copia de esta licencia, visite http://creativecommons.org/licenses/by/4.0/.
 */

package es.uji.al341823.telefonia.clientes;

import java.io.Serializable;

/**
 * @author Juanjo González (al341823)
 * @author David Agost (al341819)
 * @since 0.1
 */
public class Direccion implements Serializable {


	private static final long serialVersionUID = 3611141018118208923L;
	/** Codigo postal */
	private final int codigoPostal;
	/** Provincia */
	private final String provincia;
	/** Población */
	private final String poblacion;

	/**
	 * Crea una dirección corespondiente a los dato introducidos
	 *
	 * @param codigoPostal Codigo postal
	 * @param provincia    Provincia
	 * @param poblacion    Población
	 */
	public Direccion(int codigoPostal, String provincia, String poblacion) {
		super();

		this.codigoPostal = codigoPostal;
		this.provincia = provincia;
		this.poblacion = poblacion;
	}

	/**
	 * Devuelve el codigo postal de la dirección
	 *
	 * @return Codigo postal
	 */
	public int getCodigoPostal() {
		return this.codigoPostal;
	}

	/**
	 * Devulve la provincia de la dirección
	 *
	 * @return Provincia
	 */
	public String getProvincia() {
		return this.provincia;
	}

	/**
	 * Devulve la población de la dirección
	 *
	 * @return Población
	 */
	public String getPoblacion() {
		return this.poblacion;
	}

	/**
	 * Devuelve toda la información de la dirección
	 *
	 * @return Información de la dirección
	 */
	@Override
	public String toString() {
		return this.codigoPostal +
				", " + this.provincia +
				", " + this.poblacion;
	}
}

/*
 * Copyright (c) 2017. Esta obra está sujeta a la licencia Reconocimiento 4.0 Internacional de Creative Commons.
 * Para ver una copia de esta licencia, visite http://creativecommons.org/licenses/by/4.0/.
 */

package es.uji.al341823.telefonia.facturacion.tarifas;

import java.time.temporal.ChronoField;

/**
 * @author Juanjo González (al341823)
 * @author David Agost (al341819)
 * @since 0.3
 */
public class TarifaDiasSemana extends TarifaExtra {


	private static final long serialVersionUID = 7814828796871489286L;

	public TarifaDiasSemana(Tarifa tarifaBase, float precio, int momento) {
		super(tarifaBase, precio, ChronoField.DAY_OF_WEEK, momento, momento);
	}
}

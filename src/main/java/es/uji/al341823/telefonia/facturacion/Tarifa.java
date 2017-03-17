package es.uji.al341823.telefonia.facturacion;

import java.io.Serializable;

/**
 * @author Juanjo González (al341823)
 * @author David Agost (al341819)
 * @since 0.1
 */
public class Tarifa implements Serializable {

	private static final long serialVersionUID = 2027121994743403669L;
	/**
	 * Precio por minuto de la tarifa (€/min)
	 */
	private final float precio;

	/**
	 * Crea una tarifa con un precio determinado
	 *
	 * @param precio Precio de la tarifa
	 */
	public Tarifa(float precio) {
		super();

		this.precio = precio;
	}

	/**
	 * Devuelve le precio por minuto de la tarifa (€/min)
	 *
	 * @return Precio por minuto
	 */
	public float getPrecio() {
		return this.precio;
	}

	@Override
	public String toString() {
		return "Precio=" + this.precio;
	}
}
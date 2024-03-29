/*
 * Copyright (c) 2017. Esta obra está sujeta a la licencia Reconocimiento 4.0 Internacional de Creative Commons.
 * Para ver una copia de esta licencia, visite http://creativecommons.org/licenses/by/4.0/.
 */

package es.uji.al341823.telefonia.gui.swing.controladores;

import es.uji.al341823.telefonia.api.AdministradorDatos;
import es.uji.al341823.telefonia.api.excepciones.FechaNoValidaExcepcion;
import es.uji.al341823.telefonia.api.excepciones.ObjetoNoExisteException;
import es.uji.al341823.telefonia.api.excepciones.ObjetoYaExisteException;
import es.uji.al341823.telefonia.api.fabricas.FabricaTarifas;
import es.uji.al341823.telefonia.api.fabricas.TipoTarifa;
import es.uji.al341823.telefonia.clientes.Cliente;
import es.uji.al341823.telefonia.facturacion.Factura;
import es.uji.al341823.telefonia.facturacion.tarifas.Tarifa;
import es.uji.al341823.telefonia.gui.swing.Vista;
import es.uji.al341823.telefonia.llamadas.Llamada;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

/**
 * @author Juanjo González (al341823)
 * @since 0.4
 */
public class Controlador {

	private Vista vista;
	private AdministradorDatos modelo;

	public Vista getVista() {
		return this.vista;
	}

	public void setVista(Vista vista) {
		this.vista = vista;
	}

	public AdministradorDatos getModelo() {
		return this.modelo;
	}

	public void setModelo(AdministradorDatos modelo) {
		this.modelo = modelo;
	}

	public void nuevosDatos() {
		this.modelo.setFicheroDatos(null);
		this.modelo.limpiarDatos();
	}

	public File getFicheroDatos() {
		return this.modelo.getFicheroDatos();
	}

	public void setFicheroDatos(File file) {
		this.modelo.setFicheroDatos(file);
	}

	public void cargarDatos() {
		this.modelo.cargarDatos();
	}

	public void guardarDatos() {
		this.modelo.guardarDatos();
	}

	public ArrayList<Tarifa> getTarifasBasicas() {
		ArrayList<Tarifa> tarifas = new ArrayList<>();

		FabricaTarifas fabrica = new FabricaTarifas();
		for (TipoTarifa.Base base : TipoTarifa.Base.values())
			tarifas.add(fabrica.getTarifaBase(base));

		return tarifas;
	}

	public ArrayList<Tarifa> getTarifasExtra(Tarifa tarifaBase) {
		ArrayList<Tarifa> tarifas = new ArrayList<>();

		FabricaTarifas fabrica = new FabricaTarifas();
		for (TipoTarifa.Extra extra : TipoTarifa.Extra.values())
			tarifas.add(fabrica.getTarifaExtra(tarifaBase, extra));

		return tarifas;
	}

	public Tarifa getTarifa(Cliente cliente) {
		return cliente.getTarifa();
	}

	public void setTarifa(Cliente cliente, Tarifa tarifa) {
		this.modelo.setTarifa(cliente, tarifa);
	}

	public void guardarCliente(HashMap<String, Object> datos) throws ObjetoYaExisteException {
		this.modelo.addCliente(datos);
	}

	public void borrarCliente(Cliente cliente) throws ObjetoNoExisteException {
		this.modelo.removeCliente(cliente.getNif());
	}

	public void altaLlamada(Cliente cliente, Llamada llamada) throws ObjetoNoExisteException, ObjetoYaExisteException {
		this.modelo.addLlamada(cliente.getNif(), llamada);
	}

	public Collection<Llamada> getLlamadas(Cliente cliente) throws ObjetoNoExisteException {
		return this.modelo.getLlamadasCliente(cliente.getNif());
	}

	public void emitirFactura(Cliente cliente) throws ObjetoNoExisteException, FechaNoValidaExcepcion {
		this.modelo.addFactura(cliente.getNif());
	}

	public Collection<Factura> getFacturas(Cliente cliente) throws ObjetoNoExisteException {
		return this.modelo.getFacturasCliente(cliente.getNif());
	}

}

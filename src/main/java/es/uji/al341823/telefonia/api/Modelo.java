package es.uji.al341823.telefonia.api;

import es.uji.al341823.telefonia.clientes.Cliente;
import es.uji.al341823.telefonia.facturacion.Factura;
import es.uji.al341823.telefonia.llamadas.Llamada;

import java.util.LinkedList;

/**
 * Created by al341819 on 25/04/17.
 */
public interface Modelo {
    // Estos son los métodos que necesita conocer el Controlador.
    void añadeCliente(Cliente cliente);
    void añadeLlamada(Llamada llamada);
    void añadeFactura(Factura factura);
    void eliminaCliente(Cliente cliente);
    void eliminaLlamada(Llamada llamada);
    void eliminaFactura(Factura factura);

    // Estos son los métodos que necesita conocer la Vista.
    LinkedList<String> getListaClientes();
}
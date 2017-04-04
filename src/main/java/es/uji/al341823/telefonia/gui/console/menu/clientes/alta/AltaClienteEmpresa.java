package es.uji.al341823.telefonia.gui.console.menu.clientes.alta;

import es.uji.al341823.telefonia.api.AdministradorDatos;
import es.uji.al341823.telefonia.api.AdministradorMenus;
import es.uji.al341823.telefonia.api.EnumTipoDato;
import es.uji.al341823.telefonia.api.excepciones.ClienteYaExisteExcepcion;
import es.uji.al341823.telefonia.api.fabricas.FabricaClientes;
import es.uji.al341823.telefonia.clientes.Direccion;
import es.uji.al341823.telefonia.gui.console.menu.Menu;

import java.time.LocalDateTime;

/**
 * Clase del menu para dar de alta una empresa
 *
 * @author Juanjo González (al341823)
 * @since 0.2
 */
public class AltaClienteEmpresa extends Menu {
	public AltaClienteEmpresa(Menu padre) {
		super(padre);
	}

	@Override
	public void mostrar() {
		AdministradorMenus.imprimeTitulo(this);

		System.out.println("Introduce los datos de la empresa:");

		System.out.println();

		String nombre = AdministradorMenus.leerTexto(" - Nombre: ", EnumTipoDato.TEXTO);
		String nif = AdministradorMenus.leerTexto(" - NIF: ", EnumTipoDato.NIF);
		Direccion direccion = AdministradorMenus.leerDireccion(" - Dirección: ");
		String email = AdministradorMenus.leerTexto(" - E-mail: ", EnumTipoDato.EMAIL);
		LocalDateTime fecha = AdministradorMenus.leerFecha(" - Fecha de alta: ");

		System.out.println();

		FabricaClientes fabricaClientes = new FabricaClientes();
		FabricaTarifas fabricaTarifas = new FabricaTarifas();

		try {
			AdministradorDatos.altaCliente(fabricaClientes.getEmpresa(nombre, nif, direccion, email, fecha, fabricaTarifas.getTarifa(TipoTarifa.BASICA)));
			System.out.println("Cliente añadido con éxito");
		} catch (ClienteYaExisteExcepcion e) {
			System.out.println("Ya existe un cliente con NIF '" + nif + "'");
		}

		AdministradorMenus.esperarParaContinuar();
	}

	@Override
	public String getTitulo() {
		return "Empresa";
	}

	@Override
	public Menu[] getSubmenus() {
		return new Menu[0];
	}
}

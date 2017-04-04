package es.uji.al341823.telefonia.gui.console.menu.clientes.tarifa;

import es.uji.al341823.telefonia.api.AdministradorMenus;
import es.uji.al341823.telefonia.api.fabricas.FabricaTarifas;
import es.uji.al341823.telefonia.api.fabricas.TipoTarifa;
import es.uji.al341823.telefonia.clientes.Cliente;
import es.uji.al341823.telefonia.facturacion.tarifas.Tarifa;
import es.uji.al341823.telefonia.facturacion.tarifas.TarifaExtra;
import es.uji.al341823.telefonia.gui.console.menu.Menu;

/**
 * @author Juanjo González (al341823)
 * @author David Agost (al341819)
 * @since 0.3
 */
public class CambiarTarifaExtra extends Menu {
	public CambiarTarifaExtra(Menu padre) {
		super(padre);
	}

	@Override
	public void mostrar() {
		AdministradorMenus.imprimeTitulo(this);

		Cliente cliente = AdministradorMenus.leerClienteNIF();

		if (cliente == null) return;

		Tarifa tarifaBase = cliente.getTarifa();
		FabricaTarifas fabricaTarifas = new FabricaTarifas();

		TarifaExtra[] tarifasExtra = {
				fabricaTarifas.getTarifaExtra(tarifaBase, TipoTarifa.Extra.TARDES),
				fabricaTarifas.getTarifaExtra(tarifaBase, TipoTarifa.Extra.DOMINGOS)};

		Tarifa tarifa = AdministradorMenus.seleccionarOpciones(tarifasExtra);

		cliente.setTarifa(tarifa);

		AdministradorMenus.esperarParaContinuar();
	}

	@Override
	public String getTitulo() {
		return "Cambiar tarifa extra";
	}

	@Override
	public Menu[] getSubmenus() {
		return new Menu[0];
	}
}
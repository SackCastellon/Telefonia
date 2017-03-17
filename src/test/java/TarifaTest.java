import es.uji.al341823.telefonia.facturacion.Tarifa;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Random;

/**
 * @author David Agost (al341819)
 * @since 0.1
 */
public class TarifaTest {
	private static Random rand;
	private static float precio;
	private static Tarifa tarifa;

	@BeforeClass
	public static void first() {
		rand = new Random();
		precio = rand.nextFloat();

		tarifa = new Tarifa(precio);
	}

	@Test
	public void getPrecioTest() {
		Assert.assertEquals(precio, tarifa.getPrecio(), 0);
	}
}
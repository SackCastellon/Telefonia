package es.uji.al341823.telefonia;

import java.time.LocalDateTime;

/**
 * Created by Juanjo on 21/2/2017.
 */
public class Empresa implements ICliente, IFecha {

    private String nombre;
    private String nif;
    private Direccion direccion;
    private String email;
    private LocalDateTime fechaAlta;
    private Tarifa tarifa;

    public Empresa(String nombre, String nif, Direccion direccion, String email, LocalDateTime fechaAlta, Tarifa tarifa) {
        this.nombre = nombre;
        this.nif = nif;
        this.direccion = direccion;
        this.email = email;
        this.fechaAlta = fechaAlta;
        this.tarifa = tarifa;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNif() {
        return nif;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public LocalDateTime getFecha() {
        return fechaAlta;
    }

    public Tarifa getTarifa() {
        return tarifa;
    }
}

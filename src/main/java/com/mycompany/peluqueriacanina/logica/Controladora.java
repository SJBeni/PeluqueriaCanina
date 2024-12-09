package com.mycompany.peluqueriacanina.logica;

import com.mycompany.peluqueriacanina.persistencia.ControladoraPersistencia;
import java.util.List;

public class Controladora {
    
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();

    public void guardar(String nombreMascota, String raza, String color, String observaciones, 
            String nombreDuenio, String telDuenio, String alergico, String atencionEsp) {
        
        
        //Creamos el dueño y asignamos sus valores
        Duenio duenio = new Duenio();
        
        duenio.setNombre(nombreDuenio);
        duenio.setTelDuenio(telDuenio);
        
        //Creamos la mascota y asignamos sus valores
        Mascota mascota = new Mascota();
        
        mascota.setNombre(nombreMascota);
        mascota.setRaza(raza);
        mascota.setColor(color);
        mascota.setObservaciones(observaciones);
        mascota.setAlergico(alergico);
        mascota.setAtencion_especial(atencionEsp);
        mascota.setUnDuenio(duenio);
        
        controlPersis.guardar(duenio, mascota);
    }

    public List<Mascota> traerMascotas() {
        
        return controlPersis.traerMascotas();
    }

    public void borrarMascota(int num_cliente) {
        
        controlPersis.borrarMascota(num_cliente);
    }

    public Mascota traerMascota(int num_cliente) {
        return controlPersis.traerMascota(num_cliente);
    }

    public void modificarMascota(Mascota mascota, String nombreMascota, String raza, String color, String observaciones, String nombreDuenio, String telDuenio, String alergico, String atencionEsp) {
        
        mascota.setNombre(nombreMascota);
        mascota.setRaza(raza);
        mascota.setColor(color);
        mascota.setObservaciones(observaciones);
        mascota.setAlergico(alergico);
        mascota.setAtencion_especial(atencionEsp);
        
        //modifico mascota
        controlPersis.modificarMascota(mascota);
        
        //seteo valores del dueño
        Duenio duenio = this.buscarDuenio(mascota.getUnDuenio().getId_duenio());
        duenio.setTelDuenio(telDuenio);
        duenio.setNombre(nombreDuenio);
        
        //llamar a modificar Dueño
        this.modificarDuenio(duenio);
        
    }

    private Duenio buscarDuenio(int id_duenio) {
        return controlPersis.traerDuenio(id_duenio);
    }

    private void modificarDuenio(Duenio duenio) {
        controlPersis.modificarDuenio(duenio);
    }
    
}

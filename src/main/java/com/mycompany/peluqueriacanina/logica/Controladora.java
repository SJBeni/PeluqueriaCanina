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
    
}

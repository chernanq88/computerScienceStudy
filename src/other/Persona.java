package other;/*
Clase
 */

import java.util.Date;

public class Persona {

    String nombres;
    String apellidos;
    Date fechaDeNacimiento;

    @Override
    public String toString() {
        return nombres + " " + apellidos + " " + fechaDeNacimiento;
    }


    public Persona(String x, String y){
        this.nombres= x;
        this.apellidos = y;
    }
}

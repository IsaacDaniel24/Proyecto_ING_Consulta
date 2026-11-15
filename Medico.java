import java.util.ArrayDeque;

public class Medico extends People.Empleado{
    private String especialidad; // tipo de medico
    public ArrayDeque<Paciente> lista_pacientes; // lista de pacientes asignados al médico
    
    public Medico(int id, String nombre, boolean is_Available, String especialidad) {
        super(id, nombre, is_Available);
        this.especialidad = especialidad;
        this.lista_pacientes = new ArrayDeque<>();
    }

    // Getters y Setters
    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public ArrayDeque<Paciente> getLista_pacientes() {
        return lista_pacientes;
    }


    // Métodos

}

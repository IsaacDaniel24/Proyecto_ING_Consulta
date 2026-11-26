import java.util.ArrayDeque;

public class Medico extends People.Empleado {
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
    // Añade paciente a la lista: emergencias pasan al frente, normales al final
    public void encolarPaciente(Paciente paciente) {
        if (paciente == null)
            return;

        if (paciente.isEsEmergencia()) {
            lista_pacientes.addFirst(paciente); // Prioridad al inicio
        } else {
            lista_pacientes.addLast(paciente); // FIFO al final
        }
    }

    // Sacar y retornar al siguiente paciente en turno (FIFO / Prioridad)
    public Paciente atenderSiguientePaciente() {
        return lista_pacientes.pollFirst(); // Retorna null si la cola está vacía
    }

    // Ver quién sigue sin sacarlo de la fila
    public Paciente verSiguientePaciente() {
        return lista_pacientes.peekFirst();
    }

    public boolean tienePacientesEnEspera() {
        return !lista_pacientes.isEmpty();
    }

    // Mostrar la fila actual de este médico (para la Opción 5 del menú)
    public void mostrarColaEspera() {
        System.out.println("=== Cola de espera - Dr. " + getNombre() + " (" + especialidad + ") ===");
        if (lista_pacientes.isEmpty()) {
            System.out.println("No hay pacientes en espera.");
            return;
        }
        int turno = 1;
        for (Paciente p : lista_pacientes) {
            System.out.println(turno + ". " + p);
            turno++;
        }
    }

    @Override
    public String toString() {
        return '\n' + "ID: " + getId() +
                " | Nombre: '" + getNombre() + '\'' +
                " | Disponible: " + is_Available() +
                " | Especialidad: " + especialidad;
    }

}


public class Secretaria extends People.Empleado {

    public Secretaria(int id, String nombre, boolean is_Available) {
        super(id, nombre, is_Available);
    }

    // Getters y Setters

    // Métodos
    public static void agregarPacienteACola(Paciente paciente, Medico medico) {
        if (paciente == null || medico == null) {
            System.out.println("Error: Paciente o médico no válido.");
            return;
        }
        medico.encolarPaciente(paciente);
        System.out.println("Paciente " + paciente.getNombre() + " añadido a la cola del Dr. " + medico.getNombre());
    }

    public static void eliminarPacienteDeCola(Paciente paciente, Medico medico) {
        if (medico != null && paciente != null) {
            medico.getLista_pacientes().remove(paciente);
        }
    }

    public static void registrarPaciente(Paciente paciente) {
        // Lógica para registrar un nuevo paciente
        Paciente nuevoPaciente = new Paciente(paciente.getId(), paciente.getNombre(), paciente.isEsEmergencia());
        Database.getInstance().getPacientes().put(nuevoPaciente.getId(), nuevoPaciente); // Agrega el paciente al
                                                                                         // HashMap de pacientes en la
                                                                                         // base de datos
    }

    public static void registrarEmpleado(People.Empleado empleado) {
        // Lógica para registrar un nuevo empleado
        People.Empleado nuevoEmpleado = new People.Empleado(empleado.getId(), empleado.getNombre(),
                empleado.is_Available());
        Database.getInstance().getEmpleados().put(nuevoEmpleado.getId(), nuevoEmpleado); // Agrega el empleado al
                                                                                         // HashMap de empleados en la
                                                                                         // base de datos
    }

    public static void registrarMedico(Medico medico) {
        // Lógica para registrar un nuevo médico
        Medico nuevoMedico = new Medico(medico.getId(), medico.getNombre(), medico.is_Available(),
                medico.getEspecialidad());
        Database.getInstance().getMedicos().put(nuevoMedico.getId(), nuevoMedico); // Agrega el médico al HashMap de
                                                                                   // médicos en la base de datos
    }

    public static void agendarCita(int idCita, Paciente paciente, Medico medico) {
        // Agendar una cita para un paciente con un médico específico
        Cita nuevaCita = new Cita(idCita, paciente, medico);
        Database.getInstance().getCitas().put(idCita, nuevaCita); // Agrega la cita al HashMap de citas en la base de
    }                                                             // datos        
    

    public static void cancelarCita(int idCita) {
        // Cancelar una cita existente
        Cita cita = Database.getInstance().getCitas().get(idCita);
        if (cita != null) {
            cita.cancelarCita(); // Cambia el estado de la cita a "Cancelada"
            // Database.getInstance().getCitas().remove(idCita); // Elimina la cita de la base de datos
            System.out.println("Cita con ID " + idCita + " cancelada exitosamente.");
        } else {
            System.out.println("Error: No se encontró la cita con ID " + idCita);
        }
    }
}

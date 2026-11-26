public class Secretaria extends People.Empleado{
    
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
        Database.getInstance().getPacientes().put(nuevoPaciente.getId(), nuevoPaciente); // Agrega el paciente al HashMap de pacientes en la base de datos
    }

    public static void registrarEmpleado(People.Empleado empleado) {
        // Lógica para registrar un nuevo empleado
        People.Empleado nuevoEmpleado = new People.Empleado(empleado.getId(), empleado.getNombre(), empleado.is_Available());
        Database.getInstance().getEmpleados().put(nuevoEmpleado.getId(), nuevoEmpleado); // Agrega el empleado al HashMap de empleados en la base de datos
    }
}

public class Secretaria extends People.Empleado{
    
    public Secretaria(int id, String nombre, boolean is_Available) {
        super(id, nombre, is_Available);
    }

    // Getters y Setters

    // Métodos
    // public void agregarPaciente(Paciente paciente, Medico medico) {
    //     // añade un paciente a la lista de espera del medico correspondiente según su especialidad

    //     if(paciente.isEsEmergencia()) {
    //         medico.lista_pacientes.addFirst(paciente);
    //     } else {
    //         medico.lista_pacientes.addLast(paciente);
    //     }
    // }

    // public void eliminarPaciente(Paciente paciente, Medico medico) {
    //     // elimina un paciente de la lista de espera del medico correspondiente según su especialidad
    //     medico.lista_pacientes.remove(paciente);
    // }

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

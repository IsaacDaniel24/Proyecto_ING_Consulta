import java.util.HashMap;
import java.util.Map;

public class Database {
    private Map<Integer, People.Persona> pacientes;
    private Map<Integer, People.Empleado> empleados;
    private Map<Integer, Cita> citas;

    private Database() {
        this.pacientes = new HashMap<>();
        this.empleados = new HashMap<>();
        this.citas = new HashMap<>();
        PacientesDePrueba();
    }

    private void PacientesDePrueba() {
        Paciente p1 = new Paciente(1001, "Ana Sofía Rivera", false);
        p1.agregarNotaHistorial("Chequeo general: todo en orden.");

        pacientes.put(101, p1);
        pacientes.put(102, new Paciente(1002, "Carlos Méndez", true));
        pacientes.put(103, new Paciente(1003, "Lucía Morales", false));
    }

    // Singleton pattern para asegurar que haya solamente una instancia de la base
    // de datos
    private static class DatabaseHolder {
        private static final Database INSTANCE = new Database();
    }

    public static Database getInstance() {
        return DatabaseHolder.INSTANCE;
    }

    // getters y setters
    public Map<Integer, People.Persona> getPacientes() {
        return pacientes;
    }

    public void setPacientes(Map<Integer, People.Persona> pacientes) {
        this.pacientes = pacientes;
    }

    public Map<Integer, People.Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Map<Integer, People.Empleado> empleados) {
        this.empleados = empleados;
    }

    public Map<Integer, Cita> getCitas() {
        return citas;
    }

    public Paciente buscarPaciente(int id) { // Método para buscar un paciente por su ID
        People.Persona persona = pacientes.get(id);
        if (persona instanceof Paciente) {
            return (Paciente) persona;
        }
        return null; // Retorna null si el ID no existe
    }

    public Medico buscarMedico(int id) { // Método para buscar un médico por su ID
        People.Empleado empleado = empleados.get(id);
        if (empleado instanceof Medico) {
            return (Medico) empleado;
        }
        return null; // Retorna null si el ID no existe
    }
}

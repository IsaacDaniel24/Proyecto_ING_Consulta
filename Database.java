import java.util.HashMap;
import java.util.Map;

public class Database {
    private Map<Integer, People.Persona> pacientes;
    private Map<Integer, People.Empleado> empleados;

    public Database() {
        this.pacientes = new HashMap<>();
        this.empleados = new HashMap<>();
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

    public Paciente buscarPaciente(int id) { // Método para buscar un paciente por su ID
        People.Persona persona = pacientes.get(id);
        if (persona instanceof Paciente) {
            return (Paciente) persona;
        }
        return null; // Retorna null si el ID no existe
    }
}

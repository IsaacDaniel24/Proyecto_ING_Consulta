import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
public class Database {
    private Map<Integer, People.Persona> pacientes;
    private Map<Integer, People.Empleado> empleados;
    private Map<Integer, Cita> citas;
    private Stack<Cita> citasCompletadas;

    public Database() {
        this.pacientes = new HashMap<>();
        this.empleados = new HashMap<>();
        this.citas = new HashMap<>();
        this.citasCompletadas = new Stack<>();
        PacientesDePrueba();
        EmpleadosDePrueba();
    }

    private void PacientesDePrueba() {
        Paciente p1 = new Paciente(101, "Ana Sofía Rivera", false);
        p1.agregarNotaHistorial("Chequeo general: todo en orden.");
    
        pacientes.put(101, p1);
        pacientes.put(102, new Paciente(102, "Carlos Méndez", true));
        pacientes.put(103, new Paciente(103, "Lucía Morales", false));
    }

    private void EmpleadosDePrueba() {
        // Cada Medico inicializa su propia cola (ArrayDeque) en su constructor
        empleados.put(201, new Medico(201, "Roberto Gómez", true, "General"));
        empleados.put(202, new Medico(202, "Elena Torres", true, "Pediátrico"));
        empleados.put(203, new Medico(203, "Marco Díaz", true, "Neuro"));
        empleados.put(204, new Medico(204, "Sofía Castro", true, "Retinólogo"));
        
        // Opcional: una enfermera y secretaria de prueba
        empleados.put(301, new Enfermera(301, "Marta Cruz", true));
        empleados.put(401, new Secretaria(401, "Laura Vega", true));
    }

    // Singleton pattern para asegurar que haya solamente una instancia de la base de datos
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

    public void setCitas(Map<Integer, Cita> citas) {
        this.citas = citas;
    }

    public Stack<Cita> getCitasCompletadas() {
        return citasCompletadas;
    }

    public void setCitasCompletadas(Stack<Cita> citasCompletadas) {
        this.citasCompletadas = citasCompletadas;
    }
    
}

import java.util.HashMap;
import java.util.Map;

import java.util.Stack;

public class Database {
    private Map<Integer, People.Persona> pacientes;
    private Map<Integer, People.Empleado> medicos;
    private Map<Integer, People.Empleado> empleados;
    private Map<Integer, Cita> citas;
    private Stack<Cita> citasCompletadas;

    public Database() {
        this.pacientes = new HashMap<>();
        this.medicos = new HashMap<>();
        this.empleados = new HashMap<>();
        this.citas = new HashMap<>();
        this.citasCompletadas = new Stack<>();
        PacientesDePrueba();
        EmpleadosDePrueba();
    }

    private void PacientesDePrueba() {
        Paciente p1 = new Paciente(1001, "Ana Sofía Rivera", false);
        p1.agregarNotaHistorial("Chequeo general: todo en orden.");

        pacientes.put(1001, p1);
        pacientes.put(1002, new Paciente(1002, "Carlos Méndez", true));
        pacientes.put(1003, new Paciente(1003, "Lucía Morales", false));
    }

    private void EmpleadosDePrueba() {
        // Cada Medico inicializa su propia cola (ArrayDeque) en su constructor
        medicos.put(2001, new Medico(2001, "Roberto Gómez", true, "General"));
        medicos.put(2002, new Medico(2002, "Elena Torres", true, "Pediátrico"));
        medicos.put(2003, new Medico(2003, "Marco Díaz", true, "Neuro"));
        medicos.put(2004, new Medico(2004, "Sofía Castro", true, "Retinólogo"));

        // Opcional: una enfermera y secretaria de prueba (Empleados)
        empleados.put(3001, new Enfermera(3001, "Marta Cruz", true));
        empleados.put(4001, new Secretaria(4001, "Laura Vega", true));
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

    public Map<Integer, People.Empleado> getMedicos() {
        return medicos;
    }

    public Map<Integer, People.Empleado> getEmpleados() {
        return empleados;
    }

    public void setMedicos(Map<Integer, People.Empleado> empleados) {
        this.medicos = empleados;
    }

    public Paciente buscarPaciente(int id) { // Método para buscar un paciente por su ID
        People.Persona persona = pacientes.get(id);
        if (persona instanceof Paciente) {
            return (Paciente) persona;
        }
        return null; // Retorna null si el ID no existe
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

    public Medico buscarMedico(int id) { // Método para buscar un médico por su ID
        People.Empleado empleado = medicos.get(id);
        if (empleado instanceof Medico) {
            return (Medico) empleado;
        }
        return null; // Retorna null si el ID no existe
    }
}

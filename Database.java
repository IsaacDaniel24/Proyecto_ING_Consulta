import java.util.HashMap;
import java.util.Map;
public class Database {
    private Map<Integer, People.Persona> pacientes;
    private Map<Integer, People.Empleado> empleados;

    public Database() {
        this.pacientes = new HashMap<>();
        this.empleados = new HashMap<>();
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
}

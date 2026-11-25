import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;

public class Paciente extends People.Persona {
    private LinkedList<String> historialClinico; // Guarda las notas médicas por fecha
    private boolean esEmergencia; // true = Emergencia, false = Normal

    public Paciente(int id, String nombre, boolean esEmergencia) {
        super(id, nombre);
        this.esEmergencia = esEmergencia;
        this.historialClinico = new LinkedList<>();
    }

    // Getters y Setters
    public boolean isEsEmergencia() {
        return esEmergencia;
    }

    public void setEsEmergencia(boolean esEmergencia) {
        this.esEmergencia = esEmergencia;
    }

    public LinkedList<String> getHistorialClinico() {
        return historialClinico;
    }

    // Métodos

    // Para el paso de Consulta: el médico añade notas al récord
    public void agregarNotaHistorial(String notaMedica) {
        if (notaMedica == null || notaMedica.trim().isEmpty()) {
            System.out.println("Error: La nota médica no puede estar vacía.");
            return;
        }

        // Obtener fecha y hora actual formateada para mantener orden cronológico
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String fechaActual = LocalDateTime.now().format(formato);

        String registroCompleto = "[" + fechaActual + "] " + notaMedica.trim();
        historialClinico.add(registroCompleto);
    }

    // Para la opción 6 del menú: Ver Historial Clínico de un Paciente
    public void mostrarHistorial() {
        System.out.println("=== Historial Clínico ===");
        System.out.println("Paciente: " + getNombre() + " (ID: " + getId() + ")");
        System.out.println("Estado actual: " + (esEmergencia ? "EMERGENCIA" : "Normal"));
        System.out.println("-------------------------");

        if (historialClinico.isEmpty()) {
            System.out.println("No hay registros médicos previos para este paciente.");
        } else {
            int numeroVisita = 1;
            for (String nota : historialClinico) {
                System.out.println(numeroVisita + ". " + nota);
                numeroVisita++;
            }
        }
        System.out.println("=========================");
    }

    // Útilizar esto para imprimir al paciente por prioridad
    @Override
    public String toString() {
        String prioridad = esEmergencia ? "Emergencia" : "Normal";
        return "ID: " + getId() + " | Nombre: " + getNombre() + " | Prioridad: " + prioridad;
    }
}
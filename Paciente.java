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
        // Añadir nota (idealmente con fecha) a historialClinico
    }

    // Para la opción 6 del menú: Ver Historial Clínico de un Paciente
    public void mostrarHistorial() {
        // Recorrer e imprimir historialClinico
    }
}
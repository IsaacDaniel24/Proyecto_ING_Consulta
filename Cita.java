
public class Cita {
    private int idCita;
    private Paciente paciente;
    private Medico medico;
    private String signosVitales;
    private String estado; // "Pendiente", "Completada", "Cancelada"

    public Cita(int idCita, Paciente paciente, Medico medico) {
        this.idCita = idCita;
        this.paciente = paciente;
        this.medico = medico;
        this.signosVitales = "No registrados";
        this.estado = "Pendiente";
    }

    // --- Getters y Setters ---
    public int getIdCita() {
        return idCita;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public String getSignosVitales() {
        return signosVitales;
    }

    public String getEstado() {
        return estado;
    }

    // --- Métodos del flujo del sistema ---

    // Paso 2 (Triage - Enfermera): Actualiza los signos vitales antes de pasar al
    // médico
    public void registrarSignosVitales(String signosVitales) {
        if (signosVitales == null || signosVitales.trim().isEmpty()) {
            System.out.println("Error: Los signos vitales no pueden estar vacíos.");
            return;
        }
        this.signosVitales = signosVitales.trim();
    }

    // Paso 3 (Consulta - Médico): Marca la cita como finalizada
    public void completarCita() {
        this.estado = "Completada";
    }

    // Módulo de Citas: Cancela la cita pendiente
    public void cancelarCita() {
        if (this.estado.equals("Completada")) {
            System.out.println("Error: No se puede cancelar una cita que ya fue completada.");
            return;
        }
        this.estado = "Cancelada";
    }

    @Override
    public String toString() {
        return "Cita #" + idCita +
                " | Paciente: " + paciente.getNombre() +
                " | Médico: Dr. " + medico.getNombre() + " (" + medico.getEspecialidad() + ")" +
                " | Signos: [" + signosVitales + "]" +
                " | Estado: " + estado;
    }
}
public class Enfermera extends People.Empleado {

    public Enfermera(int id, String nombre, boolean is_Available) {
        super(id, nombre, is_Available);
    }

    // Getters y Setters

    // Métodos
    public void tomarSignosVitales(Paciente paciente, String signosVitales) {
        String estadoPaciente = paciente.isEsEmergencia() ? "Inestable" : "Estable";
        String registro = estadoPaciente + " (" + signosVitales + ")";

        paciente.agregarNotaHistorial("Signos Vitales: " + registro);
        System.out.println("Signos vitales registrados para el paciente " + paciente.getNombre());

    } // Asigna los signos vitales según el estado del paciente y registra los signos
      // vitales en su historial clínico
}

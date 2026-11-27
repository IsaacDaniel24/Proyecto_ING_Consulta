import java.util.ArrayList;
public class Enfermera extends People.Empleado {

    public Enfermera(int id, String nombre, boolean is_Available) {
        super(id, nombre, is_Available);
    }

    // Evalúa los signos vitales, guarda en el historial y retorna el reporte para el médico
    public String tomarSignosVitales(Paciente paciente, int sistolica, int diastolica, int pulso, double temperatura) {
        ArrayList<String> alertas = new ArrayList<>();

        // 1. Evaluar Presión Arterial (Normal: 90-120 / 60-80 mmHg)
        if (sistolica < 90 || diastolica < 60) {
            alertas.add("Presión arterial (" + sistolica + "/" + diastolica + " mmHg) por DEBAJO de lo normal");
        } else if (sistolica > 120 || diastolica > 80) {
            alertas.add("Presión arterial (" + sistolica + "/" + diastolica + " mmHg) por ENCIMA de lo normal");
        }

        // 2. Evaluar Pulso (Normal: 60-100 lpm)
        if (pulso < 60) {
            alertas.add("Pulso (" + pulso + " lpm) por DEBAJO de lo normal");
        } else if (pulso > 100) {
            alertas.add("Pulso (" + pulso + " lpm) por ENCIMA de lo normal");
        }

        // 3. Evaluar Temperatura (Normal: 36.0 - 37.5 °C)
        if (temperatura < 36.0) {
            alertas.add("Temperatura (" + temperatura + " °C) por DEBAJO de lo normal");
        } else if (temperatura > 37.5) {
            alertas.add("Temperatura (" + temperatura + " °C) por ENCIMA de lo normal");
        }

        // 4. Construir diagnóstico de Triage
        String lecturas = "PA: " + sistolica + "/" + diastolica + " mmHg, Pulso: " + pulso + " lpm, Temp: " + temperatura + " °C";
        String resultadoTriage;

        if (alertas.isEmpty()) {
            paciente.setEsEmergencia(false);
            resultadoTriage = "ESTABLE (" + lecturas + ")";
        } else {
            paciente.setEsEmergencia(true);
            String razones = String.join("; ", alertas);
            resultadoTriage = "INESTABLE (" + lecturas + ") -> Razón (" + alertas.size() + " variable(s) fuera de rango): " + razones;
        }

        // Guardar automáticamente en el historial clínico del paciente
        paciente.agregarNotaHistorial("Triage [Enf. " + getNombre() + "]: " + resultadoTriage);
        System.out.println("Signos vitales evaluados y registrados para " + paciente.getNombre() + ".");

        return resultadoTriage;
    }
}
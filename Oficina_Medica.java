import java.util.Scanner;

public class Oficina_Medica {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // // Aquí puedes crear instancias de Paciente y probar los métodos
        // Paciente paciente1 = new Paciente(1, "Juan Pérez", true);
        // paciente1.agregarNotaHistorial("Consulta inicial: Paciente presenta síntomas
        // de fiebre.");
        // paciente1.agregarNotaHistorial("Segunda consulta: Se prescribe
        // antibiótico.");

        // System.out.println("Historial Clínico del Paciente:");
        // paciente1.mostrarHistorial();

        System.out.println("1 . Registrar Nuevo Paciente / Empleado\n"
                + "2 . Agendar / Cancelar Cita\n"
                + "3 . Entrada de Paciente a Fila de Espera (Check-in)\n"
                + "4 . Atender Siguiente Paciente (Enfermero → > Médico)\n"
                + "5 . Consultas (Ver filas de espera, Citas de Hoy, Médicos libres\n"
                + "6 . Ver Historial Clínico de un Paciente\n"
                + "7 . Salir");
    }
}
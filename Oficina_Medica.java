import java.util.InputMismatchException;
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

        int opcion = 0;
        boolean opcionValida = false;

        while (!opcionValida) { // Imprime el menú hasta que se ingrese una opción válida
            System.out.println("1 . Registrar Nuevo Paciente / Empleado\n"
                    + "2 . Agendar / Cancelar Cita\n"
                    + "3 . Entrada de Paciente a Fila de Espera (Check-in)\n"
                    + "4 . Atender Siguiente Paciente (Enfermero → > Médico)\n"
                    + "5 . Consultas (Ver filas de espera, Citas de Hoy, Médicos libres)\n"
                    + "6 . Ver Historial Clínico de un Paciente\n"
                    + "7 . Salir\n"
                    + "Ingrese una opción: ");

            try {
                opcion = scanner.nextInt();

                if (opcion >= 1 && opcion <= 7) {
                    opcionValida = true; // Sale del loop cuando la opción es válida
                } else {
                    System.out.println("Opción inválida. Por favor, ingrese un número del 1 al 7.\n");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, ingrese solo números del 1 al 7.\n");
                scanner.nextLine(); // Borra la entrada inválida
            }
        }

        // Entra aqui solo cuando la opción es válida
        switch (opcion) {
            case 1:
                System.out.println("Registrar Nuevo Paciente / Empleado");
                // Lógica para registrar un nuevo paciente o empleado
                System.out.println("1. Paciente");
                System.out.println("2. Empleado");
                int subOpcion = scanner.nextInt();
                switch (subOpcion) {
                    case 1:
                        // Lógica para registrar un nuevo paciente

                        break;
                    case 2:
                        // Lógica para registrar un nuevo empleado
                        break;
                }
                break;
            case 2:
                System.out.println("Agendar / Cancelar Cita");
                // Lógica para agendar o cancelar una cita
                System.out.println("1. Agendar Cita");
                System.out.println("2. Cancelar Cita");
                int subOpcion2 = scanner.nextInt();
                switch (subOpcion2) {
                    case 1:
                        // Lógica para agendar una cita
                        break;
                    case 2:
                        // Lógica para cancelar una cita
                        break;
                }
                break;
            case 3:
                System.out.println("Entrada de Paciente a Fila de Espera (Check-in)");
                // Lógica para el check-in del paciente
                break;
            case 4:
                System.out.println("Atender Siguiente Paciente (Enfermero → > Médico)");
                // Lógica para atender al siguiente paciente
                break;
            case 5:
                System.out.println("Consultas (Ver filas de espera, Citas de Hoy, Médicos libres)");
                // Lógica para ver consultas
                break;
            case 6:
                System.out.println("Ver Historial Clínico de un Paciente");
                // Lógica para ver el historial clínico de un paciente
                break;
            case 7:
                System.out.println("Salir");
                // Lógica para salir del programa
                break;
        }

    }
}

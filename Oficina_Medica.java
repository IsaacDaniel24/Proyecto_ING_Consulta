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

        while (opcion != 7) { // Imprime el menú y corre el programa hasta que se imprima la opción de salir
                              // (7)
            System.out.println("~~~ Menú Principal Oficina Médica ~~~\n\n"
                    + "1 . Registrar Nuevo Paciente / Empleado\n"
                    + "2 . Agendar / Cancelar Cita\n"
                    + "3 . Entrada de Paciente a Fila de Espera (Check-in)\n"
                    + "4 . Atender Siguiente Paciente (Enfermero → > Médico)\n"
                    + "5 . Consultas (Ver filas de espera, Citas de Hoy, Médicos disponibles)\n"
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
                            System.out.println("Ingrese ID del paciente (4 dígitos):");
                            int idPaciente = scanner.nextInt();
                            System.out.println("Ingrese nombre del paciente:");
                            scanner.nextLine();
                            String nombrePaciente = scanner.nextLine();
                            System.out.println("¿Es emergencia? (true/false):");
                            boolean esEmergencia = scanner.nextBoolean();
                            Secretaria.registrarPaciente(new Paciente(idPaciente, nombrePaciente, esEmergencia));
                            System.out.println("Paciente registrado exitosamente!");
                            break;
                        case 2:
                            // Lógica para registrar un nuevo empleado
                            System.out.println("Ingrese ID del empleado (4 dígitos):");
                            int idEmpleado = scanner.nextInt();
                            System.out.println("Ingrese nombre del empleado:");
                            scanner.nextLine();
                            String nombreEmpleado = scanner.nextLine();
                            Secretaria.registrarEmpleado(new People.Empleado(idEmpleado, nombreEmpleado, true));
                            System.out.println("Empleado registrado exitosamente!");
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
                    System.out.println("=== Entrada de Paciente a Fila de Espera (Check-in) ===");
                        System.out.print("Ingrese el ID del paciente: ");
                        int idPacienteCheckIn = scanner.nextInt();
                        scanner.nextLine(); // Limpiar buffer

                        // 1. Buscar al paciente en Database (O(1))
                        People.Persona personaEncontrada = Database.getInstance().getPacientes().get(idPacienteCheckIn);
                        Paciente pacienteCheckIn = null;

                        if (personaEncontrada instanceof Paciente) {
                            pacienteCheckIn = (Paciente) personaEncontrada;
                            System.out.println("Paciente encontrado: " + pacienteCheckIn);
                            
                            // Opcional: preguntar si hoy viene por emergencia aunque antes estuviera normal
                            System.out.print("¿El paciente ingresa por emergencia hoy? (true/false): ");
                            boolean emergenciaHoy = scanner.nextBoolean();
                            pacienteCheckIn.setEsEmergencia(emergenciaHoy);
                            scanner.nextLine();
                        } else {
                            // Si no existe, el PDF indica que la secretaria lo registra en el momento
                            System.out.println("No se encontró un paciente con el ID " + idPacienteCheckIn + ".");
                            System.out.print("¿Desea registrarlo ahora? (s/n): ");
                            String respuesta = scanner.nextLine();
                            
                            if (respuesta.equalsIgnoreCase("s")) {
                                System.out.print("Ingrese nombre del nuevo paciente: ");
                                String nuevoNombre = scanner.nextLine();
                                System.out.print("¿Es emergencia? (true/false): ");
                                boolean esEmergencia = scanner.nextBoolean();
                                scanner.nextLine();
                                
                                pacienteCheckIn = new Paciente(idPacienteCheckIn, nuevoNombre, esEmergencia);
                                Secretaria.registrarPaciente(pacienteCheckIn);
                                System.out.println("Paciente registrado exitosamente.");
                            } else {
                                System.out.println("Check-in cancelado.");
                                break;
                            }
                        }

                        // 2. Mostrar médicos disponibles para que el usuario elija
                        System.out.println("\n--- Médicos Disponibles ---");
                        boolean hayMedicos = false;
                        for (People.Empleado emp : Database.getInstance().getEmpleados().values()) {
                            if (emp instanceof Medico && emp.is_Available()) {
                                Medico doc = (Medico) emp;
                                System.out.println("ID: " + doc.getId() + " | Dr. " + doc.getNombre() + " (" + doc.getEspecialidad() + ")");
                                hayMedicos = true;
                            }
                        }

                        if (!hayMedicos) {
                            System.out.println("No hay médicos disponibles en este momento.");
                            break;
                        }

                        // 3. Seleccionar el médico y encolar al paciente
                        System.out.print("\nIngrese el ID del médico asignado: ");
                        int idMedicoAsignado = scanner.nextInt();
                        scanner.nextLine();

                        People.Empleado empSeleccionado = Database.getInstance().getEmpleados().get(idMedicoAsignado);
                        
                        if (empSeleccionado instanceof Medico) {
                            Medico medicoAsignado = (Medico) empSeleccionado;
                            if (!medicoAsignado.is_Available()) {
                                System.out.println("Error: Ese médico no está disponible actualmente.");
                            } else {
                                // Usa el método de Secretaria que llama a medico.encolarPaciente()
                                Secretaria.agregarPacienteACola(pacienteCheckIn, medicoAsignado);
                                medicoAsignado.mostrarColaEspera(); // Muestra cómo quedó la fila actualizada
                            }
                        } else {
                            System.out.println("Error: El ID ingresado no corresponde a un médico válido.");
                        }
                            break;

                case 4:
                    System.out.println("Atender Siguiente Paciente (Enfermero -> Médico)");
                    // Lógica para atender al siguiente paciente
                    break;

                case 5:
                    System.out.println("Consultas (Ver filas de espera, Citas de Hoy, Médicos disponibles)"); // Lógica
                                                                                                              // para
                                                                                                              // ver
                                                                                                              // consultas
                    break;

                case 6:
                    System.out.println("Ver Historial Clínico de un Paciente");
                    System.out.println("Ingrese ID del paciente:");
                    int idPaciente = scanner.nextInt();

                    Database database = Database.getInstance();
                    Paciente paciente = database.buscarPaciente(idPaciente); // Busca el paciente en la base de datos
                                                                             // por su ID

                    if (paciente != null) {
                        paciente.mostrarHistorial();
                    } else {
                        System.out.println("Paciente no encontrado.");
                    } // Lógica para ver el historial clínico de un paciente
                    break;

                case 7:
                    System.out.println("Salir");
                    // Lógica para salir del programa
                    System.out.println("Saliendo del programa... \n"
                            + "Gracias por usar la Oficina Médica. Que tenga un buen día.");
                    break;
            }
        }
        System.out.println(Database.getInstance().getPacientes().values()); // Imprime el HashMap de pacientes para
                                                                            // verificar que
        // se
        // registraron correctamente
        System.out.println(Database.getInstance().getEmpleados().values()); // Imprime el HashMap de empleados para
                                                                            // verificar que
        // se registraron
    }
}

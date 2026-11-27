
import java.util.InputMismatchException;
import java.util.Scanner;

public class Oficina_Medica {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int opcion = 0;
        boolean opcionValida = false;

        while (opcion != 7) { // Imprime el menú y corre el programa hasta que se imprima la opción de salir
                              // (7)
            System.out.println("~~~ Menú Principal Oficina Médica ~~~\n\n"
                    + "1 . Registrar Nuevo Paciente / Empleado\n"
                    + "2 . Agendar / Cancelar Cita\n"
                    + "3 . Entrada de Paciente a Fila de Espera (Check-in)\n"
                    + "4 . Atender Siguiente Paciente (Enfermero -> Médico)\n"
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
                            System.out.println("Ingrese ID del paciente (4 dígitos, empezando por 1):");
                            int idPaciente = scanner.nextInt();
                            while (!Database.getInstance().validID("paciente", idPaciente, 1000, 1999)) {

                                // por si el usuario ingresa un ID inválido o repetido

                                System.out.println("Ingrese ID del paciente (4 dígitos, empezando por 1):");
                                idPaciente = scanner.nextInt();
                            }
                            System.out.println("Ingrese nombre del paciente:");
                            scanner.nextLine();
                            String nombrePaciente = scanner.nextLine();
                            System.out.println("¿Es emergencia? (true/false):");
                            while (!scanner.hasNextBoolean()) {
                                System.out.println(
                                        "Entrada inválida. Ingrese 'true' o 'false' para indicar si es emergencia:");
                                scanner.nextLine(); // Borra la entrada inválida
                            }
                            boolean esEmergencia = scanner.nextBoolean();
                            Secretaria.registrarPaciente(new Paciente(idPaciente, nombrePaciente, esEmergencia));
                            System.out.println("Paciente registrado exitosamente! (ID asignado: " + idPaciente + ")");
                            break;
                        case 2:
                            // Lógica para registrar un nuevo empleado
                            System.out.println(
                                    "Ingrese el tipo de empleado a registrar (1. Médico, 2. Enfermera, 3. Secretaria):");
                            int tipoEmpleado = scanner.nextInt();

                            if (tipoEmpleado < 1 || tipoEmpleado > 3) { // el usuario ingresa un tipo de empleado
                                                                        // inválido
                                System.out.println("Tipo de empleado inválido. Registro cancelado.");
                                break;
                            }
                            scanner.nextLine();
                            System.out.println("Ingrese el nombre del empleado:");
                            String nombreEmpleado = scanner.nextLine();
                            switch (tipoEmpleado) {
                                case 1:
                                    System.out.println("Ingrese ID del médico (4 dígitos, empezando por 2):");
                                    int idMedico = scanner.nextInt();
                                    while (!Database.getInstance().validID("médico", idMedico, 2000, 2999)) {
                                        // por si el usuario ingresa un ID inválido o repetido

                                        System.out.println("Ingrese ID del médico (4 dígitos, empezando por 2):");
                                        idMedico = scanner.nextInt();
                                    }
                                    scanner.nextLine();
                                    System.out.println("Ingrese la especialidad del médico:");
                                    String especialidad = scanner.nextLine();
                                    Secretaria
                                            .registrarMedico(new Medico(idMedico, nombreEmpleado, true, especialidad));
                                    break;
                                case 2:
                                    System.out.println("Ingrese ID de la enfermera (4 dígitos, empezando por 3):");
                                    int idEnfermera = scanner.nextInt();
                                    while (!Database.getInstance().validID("enfermera", idEnfermera, 3000, 3999)) {
                                        // por si el usuario ingresa un ID inválido o repetido

                                        System.out.println("Ingrese ID de la enfermera (4 dígitos, empezando por 3):");
                                        idEnfermera = scanner.nextInt();
                                    }
                                    Secretaria.registrarEmpleado(new Enfermera(idEnfermera, nombreEmpleado, true));
                                    break;
                                case 3:
                                    System.out.println("Ingrese ID de la secretaria (4 dígitos, empezando por 4):");
                                    int idSecretaria = scanner.nextInt();
                                    while (!Database.getInstance().validID("secretaria", idSecretaria, 4000, 4999)) {
                                        // por si el usuario ingresa un ID inválido o repetido

                                        System.out.println("Ingrese ID de la secretaria (4 dígitos, empezando por 4):");
                                        scanner.nextLine(); // Borra la entrada inválida
                                        idSecretaria = scanner.nextInt();
                                    }
                                    Secretaria.registrarEmpleado(new Secretaria(idSecretaria, nombreEmpleado, true));
                                    break;
                            }
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
                            System.out.println("Ingrese ID de la cita (3 dígitos):");
                            int idCita = scanner.nextInt();
                            while (idCita < 100 || idCita > 999
                                    || Database.getInstance().getCitas().containsKey(idCita)) { // por si el usuario
                                                                                                // ingresa un ID
                                                                                                // inválido o repetido
                                System.out.println("ID inválido o ya existe. Debe ser un número de 3 dígitos único.");
                                System.out.println("Ingrese ID de la cita (3 dígitos):");
                                idCita = scanner.nextInt();
                            }
                            System.out.println("Ingrese ID del paciente:");
                            int idPaciente = scanner.nextInt();
                            if (Database.getInstance().buscarPaciente(idPaciente) == null) { // ID de paciente que no
                                                                                             // existe
                                System.out.println("Paciente no encontrado. Por favor, registre al paciente primero.");
                                break;
                            } else if (Database.getInstance().pacienteTieneCita(idPaciente)) { // Verifica si el
                                                                                               // paciente ya tiene una
                                                                                               // cita agendada
                                System.out.println(
                                        "Error: " + Database.getInstance().buscarPaciente(idPaciente).getNombre()
                                                + " ya tiene una cita agendada.");
                                break;

                            } else {
                                System.out.println(
                                        "Paciente encontrado: " + Database.getInstance().buscarPaciente(idPaciente));
                            }
                            System.out.println("=== Médicos ===");
                            for (People.Empleado emp : Database.getInstance().getMedicos().values()) { // imprime la
                                                                                                       // lista de
                                                                                                       // médicos para
                                                                                                       // que el usuario
                                                                                                       // pueda elegir
                                if (emp instanceof Medico) {
                                    Medico doc = (Medico) emp;
                                    System.out.println("ID: " + doc.getId() + " | Dr. " + doc.getNombre() + " ("
                                            + doc.getEspecialidad() + ")");
                                }
                            }
                            System.out.println("Ingrese ID del médico:");
                            int idMedico = scanner.nextInt();
                            if (Database.getInstance().buscarMedico(idMedico) == null) { // ID de médico que no existe
                                System.out.println("Médico no encontrado. Por favor, registre al médico primero.");
                                break;
                            }
                            scanner.nextLine(); // Limpiar el buffer

                            Secretaria.agendarCita(idCita, Database.getInstance().buscarPaciente(idPaciente),
                                    Database.getInstance().buscarMedico(idMedico));
                            System.out.println("Cita " + idCita + " agendada exitosamente para "
                                    + Database.getInstance().buscarPaciente(idPaciente).getNombre()
                                    + " con " + Database.getInstance().buscarMedico(idMedico).getEspecialidad() + " "
                                    + Database.getInstance().buscarMedico(idMedico).getNombre() + ".");
                            break;
                        case 2:
                            // Lógica para cancelar una cita
                            System.out.println("Ingrese ID de la cita a cancelar:");
                            int idCitaCancelar = scanner.nextInt();
                            Secretaria.cancelarCita(idCitaCancelar);
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
                        while (!scanner.hasNextBoolean()) {
                            System.out.println("Entrada inválida. Por favor, ingrese 'true' o 'false'.");
                            scanner.nextLine(); // Borra la entrada inválida
                        }
                        boolean emergenciaHoy = scanner.nextBoolean();
                        pacienteCheckIn.setEsEmergencia(emergenciaHoy);
                        scanner.nextLine();
                    } else {
                        // Si no existe, indica que la secretaria lo registra en el momento
                        System.out.println("No se encontró un paciente con el ID " + idPacienteCheckIn + ".");
                        System.out.print("¿Desea registrarlo ahora? (s/n): ");
                        String respuesta = scanner.nextLine();

                        if (respuesta.equalsIgnoreCase("s")) {
                            System.out.print("Ingrese nombre del nuevo paciente: ");
                            String nuevoNombre = scanner.nextLine();
                            System.out.print("¿Es emergencia? (true/false): ");
                            while (!scanner.hasNextBoolean()) {
                                System.out.println(
                                        "Entrada inválida. Ingrese 'true' o 'false' para indicar si es emergencia:");
                                scanner.nextLine(); // Borra la entrada inválida
                            }
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
                    for (People.Empleado emp : Database.getInstance().getMedicos().values()) {
                        if (emp instanceof Medico && emp.is_Available()) {
                            Medico doc = (Medico) emp;
                            System.out.println("ID: " + doc.getId() + " | Dr. " + doc.getNombre() + " ("
                                    + doc.getEspecialidad() + ")");
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

                    People.Empleado empSeleccionado = Database.getInstance().getMedicos().get(idMedicoAsignado);

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
                    System.out.println("Ingrese ID del médico que atenderá al siguiente paciente:");
                    int idMedicoAtender = scanner.nextInt();
                    scanner.nextLine();

                    People.Empleado empAtender = Database.getInstance().getMedicos().get(idMedicoAtender);

                    if (empAtender instanceof Medico) {
                        Medico medicoAtender = (Medico) empAtender;
                        Paciente siguientePaciente = medicoAtender.atenderSiguientePaciente();

                        if (siguientePaciente != null) {
                            System.out.println("\n--- Paso 1: Triage (Enfermería) ---");

                            Enfermera enfermeraTurno = null;
                            for (People.Empleado emp : Database.getInstance().getEmpleados().values()) {
                                if (emp instanceof Enfermera && emp.is_Available()) {
                                    enfermeraTurno = (Enfermera) emp;
                                    break;
                                }
                            }

                            if (enfermeraTurno != null) {
                                System.out.println("Triage atendido por: Enf. " + enfermeraTurno.getNombre());

                                System.out.print("Ingrese presión sistólica (ej. 120): ");
                                int sistolica = scanner.nextInt();

                                System.out.print("Ingrese presión diastólica (ej. 80): ");
                                int diastolica = scanner.nextInt();

                                System.out.print("Ingrese pulso en lpm (ej. 75): ");
                                int pulso = scanner.nextInt();

                                System.out.print("Ingrese temperatura en °C (ej. 36.8): ");
                                double temperatura = scanner.nextDouble();
                                scanner.nextLine(); // Limpiar buffer

                                // Evaluar signos y guardar en historial del paciente
                                String reporteTriage = enfermeraTurno.tomarSignosVitales(
                                        siguientePaciente, sistolica, diastolica, pulso, temperatura);

                                // Buscar la cita pendiente para actualizarle los signos vitales
                                Cita citaActual = null;
                                for (Cita c : Database.getInstance().getCitas().values()) {
                                    if (c.getPaciente().getId() == siguientePaciente.getId()
                                            && c.getMedico().getId() == medicoAtender.getId()
                                            && c.getEstado().equals("Pendiente")) {
                                        citaActual = c;
                                        break;
                                    }
                                }

                                if (citaActual != null) {
                                    citaActual.registrarSignosVitales(reporteTriage);
                                }

                                System.out.println("\n--- Paso 2: Consulta Médica ---");
                                System.out.println("Dr. " + medicoAtender.getNombre() + " atendiendo a: "
                                        + siguientePaciente.getNombre() + " (ID: " + siguientePaciente.getId() + ")");
                                System.out.println("ALERTA DE TRIAGE: " + reporteTriage);

                                System.out.print("Ingrese diagnóstico o nota médica de la consulta: ");
                                String notaConsulta = scanner.nextLine();
                                siguientePaciente
                                        .agregarNotaHistorial("Dr. " + medicoAtender.getNombre() + ": " + notaConsulta);

                                if (citaActual != null) {
                                    citaActual.completarCita();
                                    Database.getInstance().getCitasCompletadas().push(citaActual);
                                    System.out.println("Cita #" + citaActual.getIdCita() + " marcada como Completada.");
                                }
                            } else {
                                System.out.println(
                                        "Error: No hay enfermeras disponibles en el sistema para realizar el triage.");
                                medicoAtender.getLista_pacientes().addFirst(siguientePaciente);
                            }
                        } else {
                            System.out.println("No hay pacientes en espera para el Dr. " + medicoAtender.getNombre());
                        }
                    } else {
                        System.out.println("Error: El ID ingresado no corresponde a un médico válido.");
                    }
                    break;

                case 5:
                    System.out.println("Consultas (Ver filas de espera, Citas de Hoy, Médicos disponibles)");
                    // Lógica para ver consultas

                    System.out.println("1. Ver Filas de Espera");
                    System.out.println("2. Ver Citas de Hoy");
                    System.out.println("3. Ver Médicos Disponibles");
                    int subOpcion3 = scanner.nextInt();
                    switch (subOpcion3) {
                        case 1:
                            // Lógica para ver filas de espera
                            System.out.println("=== Filas de Espera por Médico ===");
                            for (People.Empleado emp : Database.getInstance().getMedicos().values()) {
                                if (emp instanceof Medico) {
                                    Medico doc = (Medico) emp;
                                    doc.mostrarColaEspera();
                                }
                            }

                            break;

                        case 2:
                            System.out.println("=== Citas de Hoy (Agenda y Walk-ins) ===");
                            if (Database.getInstance().getCitas().isEmpty()) {
                                System.out.println("No hay citas registradas para hoy.");
                            } else {
                                for (Cita cita : Database.getInstance().getCitas().values()) {
                                    boolean enFila = Database.getInstance()
                                            .buscarMedicoDePacienteEnCola(cita.getPaciente().getId()) != null;
                                    String ubicacion = cita.getEstado().equals("Pendiente")
                                            ? (enFila ? " [En sala de espera]" : " [Sin Check-in]")
                                            : "";
                                    System.out.println(cita + ubicacion);
                                }
                            }
                            break;

                        case 3:
                            // Lógica para ver médicos disponibles
                            System.out.println("=== Médicos Disponibles ===");
                            boolean hayMedicosDisponibles = false;
                            for (People.Empleado emp : Database.getInstance().getMedicos().values()) {
                                if (emp instanceof Medico && emp.is_Available()) {
                                    Medico doc = (Medico) emp;
                                    System.out.println("ID: " + doc.getId() + " | Dr. " + doc.getNombre() + " ("
                                            + doc.getEspecialidad() + ")");
                                    hayMedicosDisponibles = true;
                                }
                            }
                            if (!hayMedicosDisponibles) {
                                System.out.println("No hay médicos disponibles en este momento.");
                            }
                            break;
                    }
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
        System.out.println(Database.getInstance().getMedicos().values()); // Imprime el HashMap de empleados para
                                                                          // verificar que
        // se registraron

        System.out.println(Database.getInstance().getCitas().values()); // Imprime el HashMap de citas para verificar
                                                                        // que se registraron correctamente

        System.out.println(Database.getInstance().getEmpleados().values()); // Imprime el HashMap de empleados para
                                                                            // verificar
                                                                            // que se registraron correctamente
    }
}

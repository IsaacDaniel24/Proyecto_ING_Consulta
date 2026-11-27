# Proyecto_Consulta — Sistema de Manejo Médico

## 1. Título del proyecto
Sistema de Gestión de Oficina Médica

## 2. Descripción
Aplicación de consola desarrollada en Java para la clase de Estructura de Datos. El sistema simula el flujo operativo completo de una oficina médica utilizando "object oriented programming" y estructuras de datos seleccionadas según la eficiencia requerida por cada módulo. En el mismo se utilizaron estructuras como HashMap para almacenamiento y búsqueda instantánea por ID único para pacientes (`1000–1999`), médicos (`2000–2999`), enfermeras (`3000–3999`), secretarias (`4000–4999`) y citas (`100–999`) dentro de la base de datos. ArrayDeques para que cada médico administre su propia fila de espera. Los pacientes de emergencia ingresan al inicio de la cola y los pacientes regulares al final. LinkedList para almacenar de forma secuencial las notas de signos vitales y diagnósticos médicos en el historial clínico de cada paciente. Finalmente, Stacks para el registro de citas completadas.

## 3. Instalación
1. Verifica que tengas instalado **Java JDK 11 o superior**.
2. Clona el repositorio y habrelo atravez de VSCode.
3. Presionar el botton de Run and Debug.


## 4. Uso y Funcionalidades principales
1. **Registro de Pacientes y Personal:** Creación de pacientes (normal o emergencia) y empleados (`Medico`, `Enfermera`, `Secretaria`) con validación de rango y ID.
2. **Gestión de Citas:** Agendamiento de citas vinculando paciente y médico (evitando duplicados pendientes) y cancelación por ID de cita.
3. **Check-in a Fila de Espera:** Búsqueda rápida del paciente (o registro inmediato si es nuevo) y asignación a la cola de un médico disponible según prioridad.
4. **Flujo de Atención ("Triage" y Consulta):** Extracción del siguiente paciente en la cola del médico, toma automática de signos vitales por una enfermera disponible, registro de diagnóstico médico en el historial y cierre de la cita.
5. **Consultas del Sistema:** Visualización en tiempo real de las filas de espera por doctor, citas programadas y médicos disponibles.
6. **Historial Clínico:** Consulta detallada de todas las visitas, signos vitales y notas médicas de un paciente.

## 5. Configuración:
N/A

## 6. Autores o Agradecimientos
**Autores:**
1. Isaac
2. Norelis
3. Gabriel A. Borrero Jiménez (gabriel.borrero1@upr.edu) (802-20-0150)
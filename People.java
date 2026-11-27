public class People {

    // Clase interna para representar a una persona, la base de las clases de
    // empleados y pacientes
    public static class Persona {
        private int id;
        private String nombre;

        public Persona(int id, String nombre) {
            this.id = id;
            this.nombre = nombre;
        }

        public int getId() {
            return id;
        }

        public String getNombre() {
            return nombre;
        }
    }

    public static class Empleado extends Persona {
        // Clase interna para representar a un empleado, que puede ser un médico,
        // enfermera o secretaria
        private boolean is_Available;

        public Empleado(int id, String nombre, boolean is_Available) {
            super(id, nombre);
            this.is_Available = is_Available;
        }

        public boolean is_Available() {
            return is_Available;
        }

        @Override
        public String toString() {
            return '\n' + "ID: " + getId() +
                    " | Nombre: '" + getNombre() + '\'' +
                    " | Disponible: " + is_Available();
        }
    }

}
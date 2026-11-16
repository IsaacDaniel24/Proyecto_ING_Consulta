public class People {

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
        private boolean is_Available;

        public Empleado(int id, String nombre, boolean is_Available) {
            super(id, nombre);
            this.is_Available = true; // Por defecto, el empleado está disponible al crearse
        }

        public boolean is_Available() {
            return is_Available;
        }
    }

}
public class People {

    public static class Persona {
        int id;
        String nombre;

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
}

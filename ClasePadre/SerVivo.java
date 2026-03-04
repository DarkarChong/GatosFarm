package ClasePadre;
// CLASE PADRE: Animal
// Esta clase demuestra:
//   ✅ Atributos private (nadie los toca directo desde afuera)
//   ✅ Constructor con parámetros (inicializa los private)
//   ✅ Getters (la única forma de leer los private desde afuera)
//   ✅ Un método que las hijas pueden sobreescribir con @Override


public class SerVivo implements SerVivoIO {

    // ── ATRIBUTOS private ─────────────────────────────────────
    // "private" = solo ESTA clase puede leerlos y escribirlos.
    // Ni las clases hijas (Gato, GatoPersa) pueden tocarlos directo.
    // La única forma de acceder desde afuera es usando los GETTERS.
    private String nombre;
    private String sonido;


    // ── CONSTRUCTOR ───────────────────────────────────────────
    // Recibe los valores por parámetro y los guarda en los atributos.
    // "this.nombre" = el atributo de ESTE objeto
    // "nombre"      = el parámetro que recibimos
    public SerVivo(String nombre, String sonido) {
        this.nombre = nombre;
        this.sonido = sonido;
    }


    // ── GETTERS ───────────────────────────────────────────────
    // Son la "puerta de salida" controlada de los atributos private.
    // Las clases hijas los llaman para leer lo que no pueden ver directo.
    //
    // Ejemplo:
    //   Animal a = new Animal("Luna", "...");
    //   a.getNombre()  →  "Luna"    ✅
    //   a.nombre       →  ERROR ❌  (private)
    @Override
    public String getNombre() {
        return nombre;
    }
    @Override
    public String getSonido() {
        return sonido;
    }


    // ── MÉTODO BASE ───────────────────────────────────────────
    // Este método lo pueden sobreescribir las clases hijas con @Override.
    // Si NO lo sobreescriben, usan esta versión genérica.
    @Override
    public void describir() {
        // Aquí SÍ podemos usar "nombre" y "sonido" directo
        // porque estamos DENTRO de la misma clase Animal.
        System.out.println("Soy " + nombre + " y hago " + sonido);
    }
}

package ClaseHija_Gato;

// ══════════════════════════════════════════════════════════════
// CLASE HIJA: Gato  (extends Animal)
// ══════════════════════════════════════════════════════════════
// Esta clase demuestra:
//   ✅ extends Animal → hereda todo lo público/protected del padre
//   ✅ super() → le pasa los valores al constructor del PADRE
//   ✅ Atributo propio (private boolean ronronea)
//   ✅ @Override describir() → reemplaza el del padre
//   ✅ getSonido() → accede al private del padre mediante su GETTER
// ══════════════════════════════════════════════════════════════

import ClasePadre.SerVivo;

public  class Gato extends SerVivo implements GatoIO {

    // ── ATRIBUTO PROPIO DE GATO ───────────────────────────────
    // Este atributo NO existe en Animal — es exclusivo de Gato.
    // También es private: solo Gato lo toca directo.
    private boolean ronronea;
    private EstadosGato estadoactual;


    // ── CONSTRUCTOR ───────────────────────────────────────────
    // Gato recibe nombre y ronronea como parámetros.
    //
    // super(nombre, "Miau"):
    //   → llama al constructor de ANIMAL
    //   → le dice: "guarda nombre='nombre', sonido='Miau'"
    //   → Animal guarda esos valores en SUS atributos private
    //
    // Gato NO puede escribir this.nombre directamente porque
    // nombre es PRIVATE en Animal. Solo super() puede hacerlo.
    public Gato(String nombre, boolean ronronea) {
        super(nombre, "Miau");       // Animal guarda nombre y "Miau"
        this.ronronea = ronronea;    // Gato guarda su propio atributo
        this.estadoactual = EstadosGato.COMIENDO;
    }


    // ── GETTER PROPIO ─────────────────────────────────────────
    // Expone el atributo private "ronronea" para que otras clases
    // (como CafeGato) puedan leerlo sin tocarlo directo.
    @Override
    public boolean isRonroneando() {
        return ronronea;
    }

    @Override
    public EstadosGato getEstadoActual(){
        return estadoactual;
    }
    @Override
    public void setEstadoActual(EstadosGato nuevoEstado){
        this.estadoactual = nuevoEstado;
    }

    // ── @Override describir() ─────────────────────────────────
    // Reemplaza el describir() de Animal con uno más específico.
    //
    // ¿Por qué no podemos usar "nombre" directo aquí?
    //   → Porque "nombre" es PRIVATE en Animal.
    //   → Aunque somos hijos, no tenemos acceso directo.
    //   → SOLUCIÓN: llamar al getter getNombre() que heredamos.
    //
    // Lo mismo con "sonido" → usamos getSonido().
    @Override
    public void describir() {
        // ✅ getNombre() y getSonido() son getters HEREDADOS de Animal
        // ❌ this.nombre → ERROR de compilación (private en Animal)
        System.out.println(
            "🐱 " + getNombre() +
            " dice '" + getSonido() + "'" +
            (ronronea ? " y ronronea 😻" : " sin ronronear")
        );
    }
}

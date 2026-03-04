package ClaseNieta_GatoPersa;
// ══════════════════════════════════════════════════════════════
// CLASE NIETA: GatoPersa  (extends Gato → extends Animal)
// ══════════════════════════════════════════════════════════════
// Cadena de herencia:
//   GatoPersa → Gato → Animal
//
// GatoPersa hereda de TODOS los eslabones:
//   De Animal:    getNombre(), getSonido(), describir() (base)
//   De Gato:      isRonroneando(), describir() (sobreescrito)
//   Propio:       peinar(), @Override describir() (el suyo)
//
// Esta clase demuestra:
//   ✅ Herencia en cadena (3 niveles)
//   ✅ super() que llama al constructor de GATO (que a su vez llama a Animal)
//   ✅ @Override en el segundo nivel
//   ✅ Método nuevo que solo GatoPersa tiene
// ══════════════════════════════════════════════════════════════

import ClaseHija_Gato.Gato;

public class GatoPersa extends Gato implements GatoPersaIO {

    // ── ATRIBUTO PROPIO DE GATOPERSA ──────────────────────────
    // Este dato solo existe en la raza Persa.
    private String colorPelaje;


    // ── CONSTRUCTOR ───────────────────────────────────────────
    // GatoPersa le pasa nombre y ronronea a Gato con super().
    // Gato a su vez se los pasa a Animal con su propio super().
    // La cadena completa:
    //   GatoPersa("Mochi","Blanco",true)
    //     → super("Mochi", true)          ← llama a Gato
    //       → super("Mochi", "Miau")      ← Gato llama a Animal
    //         → Animal guarda nombre y sonido en sus private
    public GatoPersa(String nombre, String colorPelaje, boolean ronronea) {
        super(nombre, ronronea);            // llama al constructor de Gato
        this.colorPelaje = colorPelaje;
    }


    // ── @Override describir() ─────────────────────────────────
    // Reemplaza el describir() de GATO con uno aún más específico.
    // También usa los getters heredados de Animal (3 niveles arriba).
    @Override
    public void describir() {
        System.out.println(
            "🐱✨ Soy " + getNombre() +        // getter de Animal (heredado)
            ", un Persa de pelaje " + colorPelaje +
            ". Digo '" + getSonido() + "'"    // getter de Animal (heredado)
            + (isRonroneando() ? " y ronroneo mucho 😻" : "")
        );
    }


    // ── MÉTODO EXCLUSIVO DE GATOPERSA ────────────────────────
    // Este método no existe en Gato ni en Animal.
    // Solo los objetos de tipo GatoPersa lo tienen.
    @Override
    public void peinar() {
        System.out.println(
            "🪮 Peinando el pelaje " + colorPelaje +
            " de " + getNombre() + "..."       // getter de Animal
        );
    }
}

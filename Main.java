// MAIN — Punto de entrada
// Aquí se crean todas las instancias y se usa todo lo que
// definimos en los demás archivos.
//
// Flujo que demuestra:
//   1. Crear instancias de cada clase
//   2. Pasar objetos como parámetros (variable guardada)
//   3. Pasar objetos inline (new Clase() dentro del paréntesis)
//   4. Ver @Override en acción (polimorfismo con examinar)
//   5. Usar métodos exclusivos de subclases (peinar)

import ClaseHija_Gato.EstadosGato;
import ClaseHija_Gato.Gato;
import ClaseNieta_GatoPersa.GatoPersa;
import ClasePadre.SerVivo;

public class Main {

    public static void main(String[] args) {


        // ── 1. CREAR INSTANCIAS 
        // La instancia del café — el "manager" principal
        CafeGato cafe = new CafeGato();

        // Instancias de Gato con parámetros
        // Gato(nombre, ronronea)
        Gato luna  = new Gato("Luna",  true);   // ronronea = sí
        Gato noche = new Gato("Noche", false);  // ronronea = no

        // Instancia de GatoPersa (hereda de Gato)
        // GatoPersa(nombre, colorPelaje, ronronea)
        GatoPersa mochi = new GatoPersa("Mochi", "Blanco", true);


        luna.setEstadoActual(EstadosGato.ENOJADO);
        System.out.println("Estado de Luna: " + luna.getEstadoActual());

        // ── 2. PASAR OBJETOS COMO PARÁMETROS (variable) 
        // Pasamos el objeto luna — es el MISMO objeto, no una copia.
        // Dentro de puedeAtender(), Java llama luna.isRonroneando()
      //  System.out.println(" Evaluaciones con variable guardada ");
        cafe.puedeAtender(luna);    // pasa objeto Gato
        cafe.puedeAtender(noche);   // pasa objeto Gato
        cafe.puedeAtender(mochi);   // GatoPersa también es un Gato


        // ── 3. INSTANCIA INLINE 
        // new Gato("Visitante", true) se crea DENTRO del paréntesis.
        // No tenemos referencia al objeto después — "vive" solo ahí.
      //  System.out.println(" Evaluación con instancia inline ");
        cafe.recibirGato(noche, true);    // internamente hace new Gato() inline
        cafe.recibirGato(luna,false);

        // También funciona directo en puedeAtender():
      //  System.out.println();
        cafe.puedeAtender(new Gato("Pelusa", true));  // ← inline directa


        // ── 4. POLIMORFISMO CON examinar(Animal) 
        // examinar recibe un Animal — funciona con Gato Y GatoPersa.
        // Java llama el describir() del TIPO REAL del objeto.
      // System.out.println("\n--- Polimorfismo con examinar(Animal) ---");
        cafe.examinar(luna);    // → llama Gato.describir()
        cafe.examinar(mochi);   // → llama GatoPersa.describir()
        cafe.examinar(noche);   // → llama Gato.describir()

        // También funciona inline:
        cafe.examinar(new GatoPersa("Cleo", "Naranja", false));


        // ── 5. MÉTODO EXCLUSIVO DE GATOPERSA 
        // peinar() solo existe en GatoPersa — no en Gato ni Animal.
        // Por eso necesitamos la variable como tipo GatoPersa,
        // no como Animal (Animal no sabe que peinar() existe).
        System.out.println("\n--- Método exclusivo de GatoPersa ---");
        mochi.peinar();


        // ── 6. VER @Override EN ACCIÓN ────────────────────────
        // Llamamos describir() en los 3 tipos:
        // Cada uno ejecuta SU propia versión del método.
        System.out.println("\n--- @Override en los 3 niveles ---");
        luna.describir();    // → Gato.describir()
        mochi.describir();   // → GatoPersa.describir()

        // Si creáramos un Animal directo, usaría Animal.describir():
        SerVivo animalGenerico = new SerVivo("Genérico", "??");
        animalGenerico.describir();   // → Animal.describir() (base)

        System.out.println("\n¡El café cerró! 🌙");
    }
}

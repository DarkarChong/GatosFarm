// CLASE: CafeGato
// Esta clase demuestra:
//   ✅ Objetos como parámetros (recibir Gato en un método)
//   ✅ Llamar métodos del objeto recibido (gato.isRonroneando())
//   ✅ Un método que llama a otro de la misma clase
//   ✅ Instancia inline: new Gato() dentro del paréntesis
//   ✅ Polimorfismo: examinar(Animal a) acepta Gato Y GatoPersa
// ══════════════════════════════════════════════════════════════
import ClaseNieta_GatoPersa.GatoPersa;
import ClaseHija_Gato.Gato;
import ClasePadre.SerVivo;

public class CafeGato {

    // ── MÉTODO A: recibe un objeto Gato como parámetro ────────
    // "Gato gato" → el tipo es Gato, el nombre del parámetro es "gato"
    // Dentro podemos llamar CUALQUIER método público de Gato:
    //   gato.isRonroneando()
    //   gato.getNombre()    (heredado de Animal)
    //   gato.getSonido()    (heredado de Animal)
    //   gato.describir()    (heredado/sobreescrito)
    //
    // IMPORTANTE: "gato" no es una copia — es el MISMO objeto.
    // Si modificaras algo dentro (si hubiera setters), el objeto
    // original en Main también cambiaría.
    public boolean puedeAtender(Gato gatito) {
        System.out.println("🏠 Evaluando a: " + gatito.getNombre());

        if (gatito.isRonroneando()) {
            // El gato ronronea → es buena compañía → puede entrar
            System.out.println("   ✅ " + gatito.getNombre() + " puede entrar.");
            return true;
        } else {
            // El gato no ronronea → podría estresar a los otros
            System.out.println("   ❌ " + gatito.getNombre() + " no puede entrar hoy.");
            return false;
        }
    }


    // ── MÉTODO B: crea el objeto y llama al MÉTODO A ──────────
    // Este método recibe un boolean simple, crea un Gato INLINE
    // y llama a puedeAtender() pasándole ese gato recién creado.
    //
    // new Gato("Visitante", ronronea)  → se crea EN EL MISMO paréntesis
    //
    // Es exactamente igual a:
    //   Gato g = new Gato("Visitante", ronronea);
    //   return puedeAtender(g);
    // Solo que más corto — el objeto "vive" solo mientras lo usa el método.
    public boolean recibirGato(Gato gatito, boolean ronronea) {
        return puedeAtender(new Gato(gatito.getNombre(), ronronea));  // ← instancia INLINE
    }


    // ── MÉTODO POLIMÓRFICO: recibe Animal, funciona con Gato Y GatoPersa ──
    // "Animal a" como parámetro → acepta CUALQUIER subclase de Animal.
    // Cuando llamas a.describir(), Java automáticamente ejecuta
    // el describir() del TIPO REAL del objeto (Gato o GatoPersa).
    // Esto es POLIMORFISMO: mismo método, resultado diferente.
    //
    // Ejemplo:
    //   examinar(new Gato(...))       → ejecuta Gato.describir()
    //   examinar(new GatoPersa(...))  → ejecuta GatoPersa.describir()
    public void examinar(SerVivo animal) {
        System.out.println("\n🔍 Examinando un nuevo animal:");
        animal.describir();   // polimorfismo en acción
    }
}

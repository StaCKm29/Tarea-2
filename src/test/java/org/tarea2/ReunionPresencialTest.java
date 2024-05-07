package pruebas;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*; para importar todos los essertion
public class ReunionPresencialTest {

    //@BeforeEach para inicializar variables
    public static void setUp() {
        System.out.println("Iniciando pruebas de ReunionPresencial");
    }

    @Test
    public void testReunionPresencial() {
        System.out.println("Prueba de ReunionPresencial");
    }
}

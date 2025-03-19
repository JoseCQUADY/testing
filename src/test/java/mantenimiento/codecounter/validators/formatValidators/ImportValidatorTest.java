package mantenimiento.codecounter.validators.formatValidators;

import mantenimiento.codecounter.exceptions.InvalidFormatException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ImportValidatorTest {

    @Test
    @DisplayName("Debe de aceptar la declaracion de import")
    void testValidImport() throws InvalidFormatException {
        ImportValidator validator = new ImportValidator();
        assertTrue(validator.isValid("import java.util.List;"));
        assertTrue(validator.isValid("import static java.util.List;"));
    }

    @Test
    @DisplayName("Debe de lanzar la excepion al detectar comodin en import")
    void importWithWildcardThrowsException() {
        ImportValidator validator = new ImportValidator();
        assertThrows(InvalidFormatException.class,
                () -> validator.isValid("import java.util.*;"));
    }

    @Test
    @DisplayName("Debe de lanzar la excepion al detectar comodin en import static")
    void testStaticImportWithWildcardThrowsException() {
        ImportValidator validator = new ImportValidator();
        assertThrows(InvalidFormatException.class,
                () -> validator.isValid("import static java.lang.Math.*;"));
    }
}

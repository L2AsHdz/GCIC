package analyzer;

import analizadores.lexico.Lexer;
import analizadores.sintactico.Parser;
import java.io.StringReader;
import java.util.List;
import model.errores.ErrorAnalisis;
import model.tags.GCIC;

/**
 *
 * @date 28/04/2021
 * @time 01:36:04
 * @author asael
 */
public class GCICAnalyzer {

    private String inputText;
    private Lexer lexer;
    private Parser parser;
    private GCIC gcic;
    private List<ErrorAnalisis> errores;

    public GCICAnalyzer(String inputText) {
        this.inputText = inputText;
    }
    
    public void analyze() {
        try {
            StringReader reader = new StringReader(inputText);
            lexer = new Lexer(reader);
            parser = new Parser(lexer);
            parser.parse();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    public GCIC getGcic() {
        return (GCIC) parser.getGCIC();
    }

    public List<ErrorAnalisis> getErrores() {
        return errores;
    }
}

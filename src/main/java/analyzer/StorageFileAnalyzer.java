package analyzer;

import analizadores.lexico.StorageLexer;
import analizadores.sintactico.StorageParser;
import java.io.Reader;
import java.util.List;
import model.Captcha;

/**
 *
 * @date 18/05/2021
 * @time 10:58:35
 * @author asael
 */
public class StorageFileAnalyzer {
    private StorageLexer lex;
    private StorageParser parser;

    public StorageFileAnalyzer() {
    }
    
    public List<Captcha> analyzeData(Reader reader) {
        try {
            lex = new StorageLexer(reader);
            parser = new StorageParser(lex);
            
            parser.parse();
            return parser.getCaptchas();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return null;
        }
    }
}

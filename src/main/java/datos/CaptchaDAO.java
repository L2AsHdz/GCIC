package datos;

import analyzer.StorageFileAnalyzer;
import static controller.FileController.readFile;
import static controller.FileController.saveFile;
import static controller.FileController.createDirectory;
import static controller.FileController.verifyFile;
import generator.StorageGenerator;
import java.io.StringReader;
import java.util.List;
import model.Captcha;

/**
 *
 * @date 18/05/2021
 * @time 10:56:08
 * @author asael
 */
public class CaptchaDAO {

    private final String USER_HOME_LINUX = System.getProperty("user.home");
    private final String PATH_FORMS = USER_HOME_LINUX + "/GCIC/data/";
    private final StorageFileAnalyzer analyzer = new StorageFileAnalyzer();
    private StorageGenerator storageG;

    public void create(List<Captcha> t) {
        storageG = new StorageGenerator(t);
        createDirectory(PATH_FORMS);
        saveFile(PATH_FORMS + "/captchas.db" , storageG.generate());
    }

    public List<Captcha> getObject() {
        StringReader text = new StringReader(readFile(PATH_FORMS + "/captchas.db"));
        return analyzer.analyzeData(text);
    }
    
    public boolean exists() {
        return verifyFile(PATH_FORMS + "/captchas.db");
    }
}

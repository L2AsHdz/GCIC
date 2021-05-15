package generator.body;

import generator.Generator;
import generator.body.scripting.ProcessGenerator;
import java.util.List;
import model.scripting.Process;
import model.tags.body.Scripting;

/**
 *
 * @date 15/05/2021
 * @time 09:44:50
 * @author asael
 */
public class ScriptingGenerator extends Generator {
    
    private final Scripting script;

    public ScriptingGenerator(Scripting script) {
        this.script = script;
    }

    @Override
    public String generate() {
        htmlCode = new StringBuilder();
        
        addLine("<script>", 0);
        generateProcesos(script.getOnload(), script.getProcesos());
        addLine("</script>", 0);
        
        return htmlCode.toString();
    }

    private void generateProcesos(Process onload, List<Process> procesos) {
        ProcessGenerator processG = new ProcessGenerator();
        
        if (onload != null) {
            processG.setProcess(onload);
            addLine(processG.generate(), 0);
        }
        
        procesos.forEach(p -> {
            processG.setProcess(p);
            addLine(processG.generate(), 0);
        });
    }

}

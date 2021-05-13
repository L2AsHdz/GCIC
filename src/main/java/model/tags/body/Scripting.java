package model.tags.body;

import java.util.List;
import model.scripting.Process;
import model.tags.Tag;

/**
 *
 * @date 12/05/2021
 * @time 11:30:10
 * @author asael
 */
public class Scripting extends Tag {

    private Process Onload;
    private List<Process> procesos;

    public Scripting(Process Onload, List<Process> procesos) {
        this.Onload = Onload;
        this.procesos = procesos;
    }

    public Scripting(Process Onload) {
        this.Onload = Onload;
    }

    public Scripting(List<Process> procesos) {
        this.procesos = procesos;
    }

    public Scripting() {
    }

    public List<Process> getProcesos() {
        return procesos;
    }

    public void setProcesos(List<Process> procesos) {
        this.procesos = procesos;
    }

    public Process getOnload() {
        return Onload;
    }

    public void setOnload(Process Onload) {
        this.Onload = Onload;
    }
}

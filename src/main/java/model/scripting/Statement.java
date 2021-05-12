package model.scripting;

/**
 *
 * @date 12/05/2021
 * @time 10:25:02
 * @author asael
 */
public class Statement implements Instruction {
    
    private String statement;

    public Statement(String statement) {
        this.statement = statement;
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }
}

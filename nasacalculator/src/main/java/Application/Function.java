package Application;

public class Function extends Object{
    private String functionName;
    private String function;

    public Function(String functionName, String function){
        this.functionName=functionName; // nazwa funkcji(np sinus)
        this.function=function; // symbol funkcji np(sin())


    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public void setFunction(String function) {
        this.function = function;
    }


    public String getFunctionName() {
        return functionName;
    }

    public String getFunction() {
        return function;
    }

    public String toString(){
        return functionName;

    }

}

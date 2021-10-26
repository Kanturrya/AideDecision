package chaining;
public class Solver {

    private Resolution solver;

    public String solve(){
        return this.solver.solver();
    }

    public void setSolver(Resolution solver){
        this.solver = solver;
    }
}
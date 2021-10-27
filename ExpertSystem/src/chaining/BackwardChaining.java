package chaining;
import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;

import problem.Fact;
import problem.Problem;
import problem.Rule;

import java.util.HashMap;


public class BackwardChaining implements Resolution {
    
    private Problem problem;
    private Map<Integer, Rule> rules;
    private ArrayList<Fact> factDataBase;

    public BackwardChaining(Problem problem) {

        this.problem = problem;

        this.rules = new HashMap<>(this.problem.getRules());
        this.factDataBase = new ArrayList<>();
    }

    public String solver() {

        try{
            this.test(this.problem.getFinalAnswer(), this.problem.getFactsDataBase());
            
        } catch (Exception e){
            System.out.println(e);
        }

        return this.factDataBase.toString();
    }

    public boolean test(Fact but, ArrayList<Fact> factsBase) throws IOException{

        System.out.println("Press Enter to continue");
        BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
        String read2 = reader1.readLine();

        System.out.println("But: " + but);
        boolean ok = false;
      
        for (Fact fact : factsBase) {
            if(but.equals(fact))
                ok = true;
        }

        

        for(Map.Entry<Integer, Rule> rule : this.rules.entrySet()) {    
            if(rule.getValue().getAnswer().contains(but)){
                while(!ok){                 
                    ok = isOk(rule.getValue().getFacts(), factsBase);
                }
            }     
        }

        if(!ok){
            System.out.println("1 or 0");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String read = reader.readLine();

            if(read.equals("0")){
                return false;
            } else {
                return true;
            }
        }
  
        if(ok) {
            factsBase.add(but);
            this.factDataBase.add(but);
        }

        return ok;
    }

    public boolean isOk(ArrayList<Fact> buts, ArrayList<Fact> factsBase) throws IOException{
        
        boolean ok = true;

        for (Fact but : buts) {        
            ok = test(but, factsBase);
        }

        return ok;
    }


    @Override
    public ArrayList<Fact> getFactDataBase() {
        // TODO Auto-generated method stub
        return null;
    }
}

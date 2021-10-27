package chaining;
import java.util.ArrayList;
import java.util.Map;

import problem.Fact;
import problem.Problem;
import problem.Rule;

import java.util.HashMap;

public class ForwardChaining implements Resolution{

    private Map<Integer, Rule> rules;
    private ArrayList<Fact> factDataBase;

    private Problem problem;

    public ForwardChaining(Problem problem) {

        this.problem = problem;
        this.rules = new HashMap<>(this.problem.getRules());
        this.factDataBase = new ArrayList<>(this.problem.getFactsDataBase());
    }

    public ArrayList<Fact> getFactDataBase(){
        return this.factDataBase;
    }

    public String solver(){
        
        boolean stop = false;
        ArrayList<Fact> seenFactsDB = new ArrayList<>();
        ArrayList<Fact> seenFactsRule = new ArrayList<>();

        while(!stop){
            
            stop = true;

            for(Map.Entry<Integer, Rule> rule : this.rules.entrySet()){
                
                boolean declanchable = false;

                for(Fact factDB : this.factDataBase) {

                    for (Fact factRule : rule.getValue().getFacts()) {

                        if(factRule.equals(factDB)){
                            seenFactsDB.add(factDB);
                            seenFactsRule.add(factRule);
                        }
                    }                 
                }

                if(factDataBase.containsAll(seenFactsDB) && seenFactsRule.containsAll(rule.getValue().getFacts())){
                    declanchable = true;
                } else {
                    declanchable = false;
                }
                seenFactsDB.clear();
                seenFactsRule.clear();
     
                if(declanchable){
                    stop = false;   
                    for (Fact factAnswer : rule.getValue().getAnswer()) {
                        if(!this.factDataBase.contains(factAnswer))
                            this.factDataBase.add(factAnswer);
                    }                 
                    
                    this.rules.remove(rule.getKey());
                    break;
                }            
            }
        }
        return this.factDataBase.toString();
    }
}

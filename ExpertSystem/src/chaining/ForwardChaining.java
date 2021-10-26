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
    private ArrayList<Fact> factDataBaseTMP;

    private Problem problem;

    public ForwardChaining(Problem problem) {

        this.problem = problem;
        this.rules = new HashMap<>(this.problem.getRules());
        this.factDataBase = new ArrayList<>(this.problem.getFactsDataBase());
        this.factDataBaseTMP = new ArrayList<>();
    }

    public String solver(){
        
        //Si le problème n'a pas de Rules ou que la base de faits est vide
        if(this.rules.isEmpty() || this.factDataBase.isEmpty()){
            return "Forward chaining : No solution found, Empty problem OR Empty facts database";
        }

        //Boucle sur les rules.
        for(Map.Entry<Integer, Rule> rules : this.rules.entrySet()) {

            for (Fact factRule : rules.getValue().getFacts()) {

                for (Fact factDB : factDataBase) {

                    if(factRule.equals(factDB)){
                        System.out.println(factDB + " " + factRule);
                        System.out.println(factRule.equals(factDB));
                        if(!this.factDataBaseTMP.contains(rules.getValue().getAnswer()) && !this.factDataBase.contains(rules.getValue().getAnswer())){
                            this.factDataBaseTMP.add(rules.getValue().getAnswer());
                        }
                    } else {
                        this.factDataBaseTMP.clear();
                    }
                }  
            }
            this.factDataBase.addAll(this.factDataBaseTMP);
            this.factDataBaseTMP.clear();

            //Si on a la réponse final alors on valide la recherche.
            if(this.factDataBase.contains(this.problem.getFinalAnswer())){
                return "\nForwardChaining : \nAccepted with facts database : " + this.factDataBase;
            }
        }  
        return "Forward chaining : No solution found";
    }
}

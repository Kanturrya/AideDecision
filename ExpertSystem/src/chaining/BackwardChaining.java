package chaining;
import java.util.ArrayList;
import java.util.Map;

import problem.Fact;
import problem.Problem;
import problem.Rule;

import java.util.HashMap;


public class BackwardChaining implements Resolution {
    
    private Problem problem;
    
    private ArrayList<Fact> factsDataBaseTMP;

    private Map<Integer, Rule> rules;
    private ArrayList<Fact> factDataBase;

    public BackwardChaining(Problem problem) {

        this.factsDataBaseTMP = new ArrayList<>();
        this.problem = problem;

        this.rules = new HashMap<>(this.problem.getRules());
        this.factDataBase = new ArrayList<>(this.problem.getFactsDataBase());

        this.setFirstFactsForBackwardChaining();
    }


    //Méthode pour set les premiers facts dans la base de faits tmp (Ref : Problem)
    public void setFirstFactsForBackwardChaining() {
        this.factsDataBaseTMP = this.problem.getFactsFromFinalAnswer();
        System.out.println(this.factsDataBaseTMP);
    }

    public String solver() {

        //Si le problème n'a pas de Rules ou que la base de faits est vide
        if(this.rules.isEmpty() || this.factsDataBaseTMP.isEmpty()){
            return "Backward chaining : No solution found, Empty problem OR Empty facts database";
        }

        //Boucle sur les rules
        for(Map.Entry<Integer, Rule> entry :this.rules.entrySet()) {

            //Si la réponse de la rule est dans la base de faits temporaire.
            if(this.factsDataBaseTMP.contains(entry.getValue().getAnswer())){
                
                //Si la base de faits temporaire possède tous les facts de la base de faits alors nous avons trouvé une solution.
                if(factsDataBaseTMP.containsAll(problem.getFactsDataBase())){                 
                    return "\nBackward Chaining : \nAccepted with facts database : " + this.factsDataBaseTMP;
                } 
                //Si la réponse que je lis n'est pas dans la base de faits alors je l'ajoutes
                if(!factsDataBaseTMP.containsAll(entry.getValue().getFacts())) {
                    
                    //Boucle sur les facts de la règle que je regarde
                    for (Fact entry2 : entry.getValue().getFacts()) {
                        
                        //Si la base de faits tmp ne possède pas le fact alors je l'ajoute
                        if(!factsDataBaseTMP.contains(entry2)) {
                            factsDataBaseTMP.add(entry2);
                        }
                    }
                    this.solver();
                }
            }
        }
        return "Backward chaining : No solution found";
    }
}

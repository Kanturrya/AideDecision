package problem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Problem {
    

    private int num_rule;
    private Map<Integer, Rule> rules;
    private ArrayList<Fact> factsDataBase;
    private Fact finalAnswer;

    public Problem(Fact finalAnswer) {
        this.rules = new HashMap<>();
        this.num_rule = 1;
        this.factsDataBase = new ArrayList<Fact>();
        this.finalAnswer = finalAnswer;
    }

    public void addRule(Rule rule) {
        rules.put(num_rule, rule);
        this.num_rule++;
    }

    public Map<Integer, Rule> getRules() {
        return this.rules;
    }

    public void addFactDataBase(Fact fact) {
        this.factsDataBase.add(fact);
    }

    public ArrayList<Fact> getFactsDataBase() {
        return this.factsDataBase;
    }

    public void setFinalAnswer(Fact finalAnswer) {
        this.finalAnswer = finalAnswer;
    }

    public Fact getFinalAnswer() {
        return this.finalAnswer;
    }

    //Utilisé pour le backward chaining 
    public ArrayList<Fact> getFactsFromFinalAnswer(){

        for(Map.Entry<Integer, Rule> entry : this.rules.entrySet()){
            if(entry.getValue().getAnswer().equals(this.finalAnswer)) {
                return entry.getValue().getFacts();
            }
        }
        return new ArrayList<>();
    }

    //Paquet de rules (Je ne sais pas si c'est bon)
    public void createPackedRules(){

        Map<Integer, Rule> packedRules = new HashMap<>();
        int i = 1;

        //Boucle sur les rules
        for(Map.Entry<Integer, Rule> entry : this.rules.entrySet()){
            
            //Boucle sur les rules
            for(Map.Entry<Integer, Rule> entry2 : this.rules.entrySet()){

                //Si les 2 réponses indentiques on ajoute à la suite sinon les rules s'ajoutent normalement
                if(entry2.getValue().getAnswer().equals(entry.getValue().getAnswer()) && !packedRules.containsValue(entry2.getValue())){
                    packedRules.put(i, entry2.getValue());
                    i++;
                }
            }
        }
        System.out.println(packedRules);
        this.rules = packedRules;
    }

    public String toString() {

        String res = "";

        for (Map.Entry<Integer, Rule> entry : rules.entrySet()) {
            res += entry.getKey() + "/" + entry.getValue() + "\n";
        }

        res += "Fin si : " + this.finalAnswer;
        
        return res;
    }

}

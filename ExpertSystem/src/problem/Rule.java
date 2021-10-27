package problem;
/*
Une règle est composée de fact afin de déterminer si oui ou non la règle est valide.
Si elle est valide elle donne son fact réponse.
*/

import java.util.ArrayList;

public class Rule {
    
    //private int priority;
    private ArrayList<Fact> facts;
    private ArrayList<Fact> answers;

    public Rule () {
        this.facts = new ArrayList<>();
        this.answers = new ArrayList<>();
    }

    public void addFact(Fact fact) {
        this.facts.add(fact);
    }

    public ArrayList<Fact> getFacts() {
        return this.facts;
    } 

    public void addAnswer(Fact fact) {
        this.answers.add(fact);
    }

    public ArrayList<Fact> getAnswer() {
        return this.answers;
    }

    public String toString() {
        String res = "Rule :\nIF : ";
        
        int i = 0;
        for(Fact f : this.facts){
            res += f.get_fact() + "\n";
            
            if(i != this.facts.size()-1)
                res +=" AND ";

            i++;
        }
        
        res +=  "THEN " + this.answers.toString() + "\n";
        return res;
    }
    
}

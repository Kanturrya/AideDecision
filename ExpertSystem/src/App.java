import chaining.BackwardChaining;
import chaining.ForwardChaining;
import chaining.Solver;
import filereader.JsonFileHandler;
import problem.Fact;
import problem.Operator;
import problem.Problem;
import problem.Rule;

public class App {
    public static void main(String[] args) throws Exception {

        //JsonFileHandler js = new JsonFileHandler();

        Fact fact1 = new Fact("Poste à responsabilité", "", Operator.NONE);
        Fact fact2 = new Fact("Langues faciles", "", Operator.NONE);
        Fact fact3 = new Fact("Néerlandais", "", Operator.NONE);
        Fact fact4 = new Fact("Dynamique", "", Operator.NONE);
        Fact fact5 = new Fact("Parle anglais", "", Operator.NONE);
        Fact fact6 = new Fact("Bonne adaptabilité", "", Operator.NONE);
        Fact fact7 = new Fact("Slave", "", Operator.NONE);
        Fact fact8 = new Fact("Leadership", "", Operator.NONE);
        Fact fact9 = new Fact("Accepté", "", Operator.NONE);

        Rule rule1 = new Rule();
        rule1.addFact(fact1);
        rule1.addFact(fact2);
        rule1.addFact(fact3);
        rule1.addAnswer(fact4);

        Rule rule2 = new Rule();
        rule2.addFact(fact2);
        rule2.addFact(fact5);
        rule2.addAnswer(fact6);

        Rule rule3 = new Rule();
        rule3.addFact(fact7);
        rule3.addFact(fact4);
        rule3.addAnswer(fact6);

        Rule rule4 = new Rule();
        rule4.addFact(fact1);
        rule4.addAnswer(fact8);

        Rule rule5 = new Rule();
        rule5.addFact(fact2);
        rule5.addAnswer(fact3);

        Rule rule6 = new Rule();
        rule6.addFact(fact6);
        rule6.addFact(fact8);
        rule6.addAnswer(fact9);

        Rule rule7 = new Rule();
        rule7.addFact(fact7);
        rule7.addAnswer(fact2);

        Rule rule8 = new Rule();
        rule8.addFact(fact8);
        rule8.addFact(fact7);
        rule8.addAnswer(fact6);


        
        Problem problem = new Problem(fact9);

        problem.addRule(rule1);
        problem.addRule(rule2);
        problem.addRule(rule3);
        problem.addRule(rule4);
        problem.addRule(rule5);
        problem.addRule(rule6);
        problem.addRule(rule7);
        problem.addRule(rule8);
        
        
        problem.addFactDataBase(fact7);
        problem.addFactDataBase(fact1);

        //problem.createPackedRules();
        /*
    

        Rule r1 = new Rule();
        Fact fact1 = new Fact("Age", "18.0", Operator.SUPEQ);
        r1.addFact(fact1);
        Fact fact6 = new Fact("Age", "18.0", Operator.NONE);
        r1.addAnswer(fact6);

        Rule r2 = new Rule();
        Fact fact4 = new Fact("Sexe", "Femme", Operator.NEQ);
        r2.addFact(fact4);
        Fact fact3 = new Fact("Sexe", "Homme", Operator.NONE);
        r2.addAnswer(fact3);

        Rule r3 = new Rule();
        r3.addFact(fact3);
        r3.addFact(fact6);
        Fact fact7 = new Fact("Ok", "", Operator.NONE);
        r3.addAnswer(fact7);

        Problem problem = new Problem(fact7);

        problem.addRule(r1);
        problem.addRule(r2);
        problem.addRule(r3);


        Fact fact5 = new Fact("Sexe", "Homme", Operator.EQ);
        Fact fact2 = new Fact("Age", "19.0", Operator.EQ);
        problem.addFactDataBase(fact2);
        problem.addFactDataBase(fact5);
*/

        Solver solver = new Solver();

        solver.setSolver(new ForwardChaining(problem));
        System.out.println("Retour: " + solver.solve());

        solver.setSolver(new BackwardChaining(problem));
        System.out.println(solver.solve());


    }
}

package problem;

import java.util.Objects;

/*
Cette class permet de définir un fait
Un/des fact(s) sera(ont) utilisé(s) dans les rules afin de déterminer si  
la règle est valide ou non. De plus ils seront utilisé dans la base de faits 
pour compléter le problème.
*/

public class Fact extends AbstractFact{

    // =, <, >, <=, >=, !
    private Operator operator;
    
    public Fact (String fact, String value, Operator operator) {   
        super(fact, value);
        this.operator = operator;
    }

    @Override
    public boolean equals(Object obj){
        
        if(obj == null || !(obj instanceof Fact)){
            return false;
        }

        if(obj == this){
            return true;
        }

        final Fact fact2 = (Fact) obj;
        if(this.get_fact().equals(fact2.get_fact())) {

            if(this.operator.equals(Operator.NONE)){
                return false;
            } else if(this.operator.equals(Operator.EQ)){
                if(this.get_value().equals(fact2.get_value())){
                    return true;
                }
            } else if(this.operator.equals(Operator.NEQ)){
                if(!this.get_value().equals(fact2.get_value())){
                    return true;
                }
            } else if(this.operator.equals(Operator.INF)){
                if(Double.valueOf(fact2.get_value()) < Double.valueOf(this.get_value())){
                    return true;
                }
            } else if(this.operator.equals(Operator.INFEQ)){
                if(Double.valueOf(fact2.get_value()) <= Double.valueOf(this.get_value())){
                    return true;
                }
            } else if(this.operator.equals(Operator.SUP)){
                if(Double.valueOf(fact2.get_value()) > Double.valueOf(this.get_value())){
                    return true;
                }
            } else if(this.operator.equals(Operator.SUPEQ)){
                if(Double.valueOf(fact2.get_value()) >= Double.valueOf(this.get_value())){
                    return true;
                }
            } else {
                return false;
            }  
        }

        return false;
    }

    @Override
    public int hashCode(){
        return Objects.hash(get_fact(), get_value(), this.operator);
    }
}

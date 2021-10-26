package problem;

public class AbstractFact {
    
    private String value;
    private String fact;

    public AbstractFact (String fact, String value) {   
        this.fact = fact;
        this.value = value;
    }

    public String get_value() {
        return this.value;
    }

    public String get_fact(){
        return this.fact;
    }

    @Override
    public String toString(){
        if(this.value.equals("")){
            return this.fact;
        }
        return this.fact + ":" + this.value;
    }
}

package chaining;

import java.util.ArrayList;

import problem.Fact;

public interface Resolution {
    public String solver();
    public ArrayList<Fact> getFactDataBase();
}

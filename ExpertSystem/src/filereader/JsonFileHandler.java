package filereader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import problem.Fact;
import problem.Problem;

public class JsonFileHandler {
     
    private static final Type Fact = new TypeToken<List<Problem>>() {}.getType();;

    private Gson gson;

    public JsonFileHandler(){
        
        this.gson = new Gson();
        try {
            this.Read();
        } catch (Exception e) {
            System.out.println("Erreur : " + e);    
        }
    }

    public void Read() throws FileNotFoundException{

        JsonReader jsonReader = new JsonReader(new FileReader("jsonfile/test.txt"));
        List<Problem> problems = gson.fromJson(jsonReader, Fact);
        for(Problem pb : problems){
            if(pb != null){
                System.out.println("pb : " + pb);
                System.out.println("db facts : " + pb.getFactsDataBase());
                System.out.println("f answer : " + pb.getFinalAnswer());
            }
            
        }
    }
}

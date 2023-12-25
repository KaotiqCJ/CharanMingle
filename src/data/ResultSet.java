package data;

import java.util.ArrayList;
import java.util.List;

public class ResultSet {
    
    private List<Result> results;

    public ResultSet() {
        results = new ArrayList<Result>();
    }

    public void addResult(Result result) {
        results.add(result);
    }

    public List<Result> getResults() {
        return results;
    }

}

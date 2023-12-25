package data;

import java.util.HashMap;

public class ComparisonSet {
    
    private HashMap<String, Float> comparisonResults;
    
    public ComparisonSet(HashMap<String, Float> comparisonResults) {
        this.comparisonResults = comparisonResults;
    }

    public HashMap<String, Float> getComparisonResults() {
        return comparisonResults;
    }

}

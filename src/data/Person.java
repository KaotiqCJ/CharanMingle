package data;

import java.util.HashMap;

public class Person {
    
    private String name;
    private Orientation orientation;
    private AnswerVector answerVector;
    private ComparisonSet comparisonSet;

    public Person(String name, Orientation orientation, AnswerVector answerVector) {
        this.name = name;
        this.orientation = orientation;
        this.answerVector = answerVector;
    } 

    public String getName() {
        return name;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public AnswerVector getAnswerVector() {
        return answerVector;
    }

    public void setComparisonSet(HashMap<String, Float> comparisonSet) {
        this.comparisonSet = new ComparisonSet(comparisonSet);
    }

    public ComparisonSet getComparisonSet() {
        return comparisonSet;
    }

}

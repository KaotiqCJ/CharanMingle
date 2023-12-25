package data;

public class Result {
    private String nameA;
    private String nameB;
    private float similarity;

    public Result(String nameA, String nameB, float similarity) {
        this.nameA = nameA;
        this.nameB = nameB;
        this.similarity = similarity;
    }

    public String getNameA() {
            return nameA;
    }

    public String getNameB() {
        return nameB;
    }

    public float getSimilarity() {
        return similarity;
    }

}

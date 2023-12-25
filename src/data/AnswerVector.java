package data;

public class AnswerVector {

    private float[] answers;

    public AnswerVector(float[] answers) {
        this.answers = answers;

    }

    public float[] getAnswers() {
        return answers;
    }

    public float compare(AnswerVector other) {
        float sum = 0;
        for (int i = 0; i < answers.length; i++) {
            sum += answers[i] * other.answers[i];
        }
        return sum / (length() * other.length());
    }

    private float length() {
        float l = 0;
        for (int i = 0; i < answers.length; i++) {
            l += answers[i] * answers[i];
        }
        return (float) Math.sqrt(l);
    }

}

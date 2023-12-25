package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import algo.GroupComparitor;
import data.AnswerVector;
import data.Orientation;
import data.Person;
import data.ResultSet;

public class Generator {
    
    public static void main(String[] args) {
        // Gay test
        System.out.println("GAY:");
        List<Person> gay = generate(11, "Gay", Orientation.G);
        GroupComparitor gayComparitor = new GroupComparitor();
        ResultSet gayResults = gayComparitor.groupCompareHomo(gay);
        dump(gayResults);
        // Lesbian test
        System.out.println("LESBIAN:");
        List<Person> lesbian = generate(9, "Lesbian", Orientation.L);
        GroupComparitor lesbianComparitor = new GroupComparitor();
        ResultSet lesbianResults = lesbianComparitor.groupCompareHomo(lesbian);
        dump(lesbianResults);
        // Hetero test
        System.out.println("HETERO:");
        List<Person> men = generate(65, "Man", Orientation.M);
        List<Person> women = generate(77, "Woman", Orientation.W);
        GroupComparitor heteroComparator = new GroupComparitor();
        ResultSet heteroResults = heteroComparator.compareHetero(men, women);
        dump(heteroResults);
    }

    private static List<Person> generate(int n, String title, Orientation orientation) {
        List<Person> people = new ArrayList<Person>();
        for (int i = 0; i < n; i++) {
            Random random = new Random();
            people.add(new Person(title + i, orientation, new AnswerVector(new float[] {random.nextInt(5)/4.0f, random.nextInt(5)/4.0f, random.nextInt(5)/4.0f, random.nextInt(5)/4.0f, random.nextInt(5)/4.0f})));
        }
        return people;
    }

    private static void dump(ResultSet results) {
        for (int i = 0; i < results.getResults().size(); i++) {
            System.out.println(results.getResults().get(i).getNameA() + " " + results.getResults().get(i).getNameB() + " " + results.getResults().get(i).getSimilarity());
        }
    }


}

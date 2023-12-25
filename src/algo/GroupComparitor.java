package algo;

import java.util.HashMap;
import java.util.List;

import data.Person;
import data.Result;
import data.ResultSet;

public class GroupComparitor {
    
    public ResultSet groupCompareHomo(List<Person> people) {
        ResultSet resultSet = new ResultSet();
        for (Person a: people) {
            HashMap<String, Float> currentComparisonSet = new HashMap<String, Float>();
            for (Person b: people) {
                if (a.getName().equals(b.getName()) )
                    continue;
                currentComparisonSet.put(b.getName(), a.getAnswerVector().compare(b.getAnswerVector()));
            }
            a.setComparisonSet(currentComparisonSet);
        }
        while (people.size() > 1) {
            performBestMatchHomo(people, resultSet);
        }
        return resultSet;
    }

    private void performBestMatchHomo(List<Person> people, ResultSet resultSet) {
        float max = 0;
        Person bestPersonA = null;
        Person bestPersonB = null;
        for (Person a: people) {
            for (Person b: people) {
                if (a.getName().equals(b.getName()))
                    continue;
                if (a.getComparisonSet().getComparisonResults().get(b.getName()) > max) {
                    max = a.getComparisonSet().getComparisonResults().get(b.getName());
                    bestPersonA = a;
                    bestPersonB = b;
                }
            }
        }
        resultSet.addResult(new Result(bestPersonA.getName(), bestPersonB.getName(), max));
        people.remove(bestPersonA);
        people.remove(bestPersonB);
        for (Person person: people) {
            person.getComparisonSet().getComparisonResults().remove(bestPersonA.getName());
            person.getComparisonSet().getComparisonResults().remove(bestPersonB.getName());
        }
    }

    public ResultSet compareHetero(List<Person> men, List<Person> women) {
        ResultSet resultSet = new ResultSet();
        for (Person woman: women) {
            HashMap<String, Float> currentComparisonSet = new HashMap<String, Float>();
            for (Person man: men) {
                currentComparisonSet.put(man.getName(), man.getAnswerVector().compare(woman.getAnswerVector()));
            }
            woman.setComparisonSet(currentComparisonSet);
        }
        while (men.size() > 0 && women.size() > 0) {
            performBestMatchHetero(men, women, resultSet);
        } 
        return resultSet;
    }

    private void performBestMatchHetero(List<Person> men, List<Person> women, ResultSet resultSet) {
        float max = 0;
        Person bestPersonA = null;
        Person bestPersonB = null;
        for (Person woman: women) {
            for (Person man: men) {
                if (woman.getComparisonSet().getComparisonResults().get(man.getName()) > max) {
                    max = woman.getComparisonSet().getComparisonResults().get(man.getName());
                    bestPersonA = woman;
                    bestPersonB = man;
                } 
            }
        }
        resultSet.addResult(new Result(bestPersonA.getName(), bestPersonB.getName(), max));
        women.remove(bestPersonA);
        men.remove(bestPersonB);
        for (Person person: women) {
            person.getComparisonSet().getComparisonResults().remove(bestPersonB.getName());
        }
    }

}

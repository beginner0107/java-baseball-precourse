package baseball.service;

import java.util.List;
import java.util.Objects;

public class NumericBaseBallService {

    public int[] matchesNumbers(List<Integer> computerNumbers, List<Integer> personNumbers) {
        int matchNumbers = 0;
        int nonMatchNumbers = 0;
        int containsNumber = 0;
        for (int i = 0; i < personNumbers.size(); i++) {
            if (Objects.equals(computerNumbers.get(i), personNumbers.get(i))) {
                matchNumbers++;
            }
            if (!computerNumbers.contains(personNumbers.get(i)) && !Objects.equals(computerNumbers.get(i), personNumbers.get(i))) {
                nonMatchNumbers++;
            } else {
                containsNumber++;
            }
        }
        return new int[]{nonMatchNumbers, matchNumbers, containsNumber};
    }
}

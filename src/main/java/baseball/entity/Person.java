package baseball.entity;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Person implements Player{

    @Override
    public List<Integer> pickNumbers() throws IllegalAccessException{
        List<Integer> numbers = new ArrayList<>();
        String[] splitNumbers = Console.readLine().trim().split("");
        if (splitNumbers.length != 3) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
        for (int i = 0; i < 3; i++) {
            numbers.add(Integer.parseInt(splitNumbers[i]));
        }

        return numbers;
    }
}

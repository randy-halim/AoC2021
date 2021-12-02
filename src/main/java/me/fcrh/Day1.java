package me.fcrh;

import me.fcrh.util.AsciiArt;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Day1 {
    public static void main(String[] args) {
        System.out.println(AsciiArt.borderedMessage("Day 1, Part 1"));
        partOne();
        System.out.println(AsciiArt.borderedMessage("Day 1, Part 2"));
        partTwo();
    }

    private static void partOne() {
        Scanner scanner = AoC2021.getChallenge(1);

        int increases = 0;
        int lastNumber = Integer.parseInt(scanner.nextLine());
        int currentNumber;

        while (scanner.hasNext()) {
            currentNumber = Integer.parseInt(scanner.nextLine());
            if (currentNumber > lastNumber) {
                increases++;
            }
            lastNumber = currentNumber;
        }

        System.out.printf("There are %s increases\n", increases);
    }

    private static void partTwo() {
        // region data intake
        Scanner scanner = AoC2021.getChallenge(1);

        List<Integer> inputs = new ArrayList<>();

        while (scanner.hasNext()) {
            inputs.add(Integer.parseInt(scanner.nextLine()));
        }
        // endregion

        // region sliding windows creation
        List<List<Integer>> slidingWindows = new ArrayList<>();
        int index = 0;

        while (index < inputs.size() - 2) {
            List<Integer> window = new ArrayList<>();

            window.add(inputs.get(index));
            window.add(inputs.get(index + 1));
            window.add(inputs.get(index + 2));

            slidingWindows.add(window);
            index++;
        }
        // endregion

        // region calculate sum of each window
        List<Integer> summedSlidingWindows = new ArrayList<>();

        for (List<Integer> window : slidingWindows) {
            int sum = window.stream().mapToInt(i -> i).sum();
            summedSlidingWindows.add(sum);
        }
        // endregion

        // region calculate increases
        Iterator<Integer> iterator = summedSlidingWindows.iterator();

        int increases = 0;
        int lastNumber = iterator.next();
        int currentNumber;

        while (iterator.hasNext()) {
            currentNumber = iterator.next();
            if (currentNumber > lastNumber) {
                increases++;
            }
            lastNumber = currentNumber;
        }

        System.out.printf("There are %s increases using the sliding window technique\n", increases);
    }
}

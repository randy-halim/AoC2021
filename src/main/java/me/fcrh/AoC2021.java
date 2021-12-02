package me.fcrh;

import me.fcrh.util.AsciiArt;

import java.util.Objects;
import java.util.Scanner;

public class AoC2021 {
    public static void main(String[] args) {
        System.out.println(AsciiArt.getChristmasTree());
        System.out.println(AsciiArt.borderedMessage("Advent of Code 2021"));
        System.out.println(AsciiArt.borderedMessage("https://github.com/randy-halim/AoC2021"));
        System.out.println("\n\n");

        // Day 1
        Day1.main(null);

        // Day 2
        Day2.main(null);
    }

    public static Scanner getChallenge(int dayNumber) {
        String path = String.format("/inputs/day%s.txt", dayNumber);
        return new Scanner(Objects.requireNonNull(AoC2021.class.getResourceAsStream(path)));
        /*
         * Yes, I know that `Objects#requireNonNull` will throw an ambiguous NPE
         *  if it were to throw. However, I hate the neon yellow highlight that IntelliJ
         *  produces, so this will have to do.
         */
    }
    public static Scanner getChallenge(int dayNumber, boolean sample) {
        if (sample) {
            String path = String.format("/samples/day%s.txt", dayNumber);
            return new Scanner(Objects.requireNonNull(AoC2021.class.getResourceAsStream(path)));
        } else {
            return getChallenge(dayNumber);
        }
    }
}

package me.fcrh;

import me.fcrh.util.AsciiArt;

import java.util.Scanner;

public class Day2 {
    public static void main(String[] args) {
        System.out.println(AsciiArt.borderedMessage("Day 1, Part 1"));
        partOne();
        System.out.println(AsciiArt.borderedMessage("Day 1, Part 2"));
        partTwo();
    }

    /*
     * Instructions look like
     *  forward 5
     *  down 5
     *  up 3
     *
     * We need to parse these and change `depth` and `horizontal`.
     */
    public static void partOne() {
        int horizontal = 0;
        int depth = 0;

        Scanner scanner = AoC2021.getChallenge(2);

        while (scanner.hasNext()) {
            Command command = parseCommand(scanner);

            switch (command.getCommand()) {
                case "forward" -> horizontal += command.getValue();
                case "down" -> depth += command.getValue();
                case "up" -> depth -= command.getValue();
                default -> throw new IllegalArgumentException("Not one of 'forward' 'down' or 'up'");
            }
        }

        System.out.printf("The depth is %s \n", depth);
        System.out.printf("The horizontal distance is %s \n", horizontal);
        System.out.println();
        System.out.printf("Multiplied together (answer) is %s\n", depth * horizontal);
    }

    /*
     * Same as part one, but now we track an aim variable. Depth and movement depends on the aim,
     *  where down and up change it.
     */
    public static void partTwo() {
        int aim = 0;
        int depth = 0;
        int horz = 0;

        Scanner scanner = AoC2021.getChallenge(2);

        while (scanner.hasNext()) {
            Command command = parseCommand(scanner);

            switch (command.getCommand()) {
                case "down" -> aim += command.getValue();
                case "up" -> aim -= command.getValue();
                case "forward" -> {
                    horz += command.getValue();
                    depth += (command.getValue() * aim);
                }
            }
        }

        System.out.printf("The depth is %s \n", depth);
        System.out.printf("The horizontal distance is %s \n", horz);
        System.out.println();
        System.out.printf("Multiplied together (answer) is %s", depth * horz);
    }

    private static Command parseCommand (Scanner scanner) {
        String[] input = scanner.nextLine().split(" ");

        String cmd = input[0];
        int val = Integer.parseInt(input[1]);

        return new Command(cmd, val);
    }

    public record Command(String command, int value) {
        public String getCommand() {
            return command;
        }

        public int getValue() {
            return value;
        }
    }
}

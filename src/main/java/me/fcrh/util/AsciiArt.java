package me.fcrh.util;

public record AsciiArt() {
    public static String getChristmasTree() {
        // taken from https://www.asciiart.eu/holiday-and-events/christmas/trees
        return """
                   *    *  ()   *   *
                *        * /\\         *
                      *   /i\\\\    *  *
                    *     o/\\\\  *      *
                 *       ///\\i\\    *
                     *   /*/o\\\\  *    *
                   *    /i//\\*\\      *
                        /o/*\\\\i\\   *
                  *    //i//o\\\\\\\\     *
                    * /*////\\\\\\\\i\\*
                 *    //o//i\\\\*\\\\\\   *
                   * /i///*/\\\\\\\\\\o\\   *
                  *    *   ||     * jrei""";
    }

    public static String borderedMessage(String message) {
        return "=".repeat(message.length() + 4) +
                "\n= " +
                message +
                " =\n" +
                "=".repeat(message.length() + 4);
    }
}

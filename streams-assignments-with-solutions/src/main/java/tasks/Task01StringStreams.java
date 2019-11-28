package tasks;

import java.util.Arrays;
import java.util.stream.Collectors;

class Task01StringStreams {

    /**
     * Функция должна вернуть число строчных символов в строке.
     * <p>
     * Пример:
     * "abcDE" -> 3
     * "ABC" -> 0
     */
    static long countLowercaseLetters(String str) {
        return str.chars()
                .filter(Character::isLowerCase)
                .count();
    }


    /**
     * Функция должна заменить каждое слово в строке его длинной.
     * <p>
     * Слова разделяются одним или более пробелами.
     * <p>
     * Пример:
     * "a b cd" -> "1 1 2"
     * "one two   three" -> "3 3 5"
     * <p>
     * Тут подойдут эти методы:
     * - String::split
     * - Stream::map
     * - Stream::collect
     * - Collectors.joining
     */
    static String replaceWordsOnLength(String str) {
        return Arrays.stream(str.split("\\s+"))
                .map(String::length)
                .map(Object::toString)
                .collect(Collectors.joining(" "));
    }
}
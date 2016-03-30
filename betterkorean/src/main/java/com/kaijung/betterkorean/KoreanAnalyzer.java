package com.kaijung.betterkorean;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by kai on 16. 3. 24..
 */
public class KoreanAnalyzer {

    private static final char HANGUL_SYLLABLES_BEGIN = 0xAC00;
    private static final char HANGUL_SYLLABLES_END = 0xD7A3;

    private static int CHOSUNG_BASE = 588;
    private static int JUNGSUNG_BASE = 28;

    private static final String[] JONG_SUNG_LIST = {" ", "ㄱ", "ㄲ", "ㄳ", "ㄴ", "ㄵ", "ㄶ", "ㄷ", "ㄹ", "ㄺ", "ㄻ", "ㄼ", "ㄽ", "ㄾ", "ㄿ", "ㅀ", "ㅁ", "ㅂ", "ㅄ", "ㅅ", "ㅆ", "ㅇ", "ㅈ", "ㅊ", "ㅋ", "ㅌ", "ㅍ", "ㅎ"};
    private static final String[] ENG_CHECK_LIST = {"A", "a", "E", "e", "F", "f", "G", "g", "H", "h", "I", "i", "J", "j", "O", "o", "R", "r", "S", "s", "U", "u", "V", "v", "X", "x", "Y", "y", "Z", "z"};
    private static final String[] ENG_TYPE_1 = { "NG", "LE", "ME" };
    private static final String[] ENG_TYPE_2 = {"ND", "ED", "LT", "ST", "RD", "LD"};

    public enum Number {
        ZERO('0'), ONE('1'), TWO('2'), THREE('3'), FOUR('4'), FIVE('5'), SIX('6'), SEVEN('7'), EIGHT('8'), NINE('9');

        private char value;

        Number(char value) {
            this.value = value;
        }

        public static Number convert(char value) {
            for (Number number : values()) {
                if (number.value == value) {
                    return number;
                }
            }
            return null;
        }
    }

    private final String src;

    public KoreanAnalyzer(String src) {
        this.src = src;
    }

    public boolean isThere종성() {
        int jos = get종정Idx();

        return (!JONG_SUNG_LIST[jos].equals(" "));
    }

    public boolean isㄹ종성() {
        int jos = get종정Idx();
        return (JONG_SUNG_LIST[jos].equals("ㄹ"));
    }

    public boolean isHangul() {
        char ch = getLastChar();
        return ch >= HANGUL_SYLLABLES_BEGIN && ch <= HANGUL_SYLLABLES_END;
    }

    public boolean isEnglish() {
        char ch = getLastChar();
        return (65 <= ch && ch <= 90) || (97 <= ch && ch <= 122);
    }

    public boolean isKindOf받침() {

        if (src.length() >= 2) {
            String lastTwoString = src.substring(src.length() - 2, src.length());
            for (String item : ENG_TYPE_1) {
                if (lastTwoString.toUpperCase().equals(item)) {
                    return true;
                }
            }
            for (String item : ENG_TYPE_2) {
                if (lastTwoString.toUpperCase().equals(item)) {
                    return false;
                }
            }
        }

        String lastString = src.substring(src.length() - 1, src.length());
        ArrayList<String> list = new ArrayList<>(Arrays.asList(ENG_CHECK_LIST));

        return !list.contains(lastString);
    }

    public boolean isL() {
        char lastChar = getLastChar();
        return (lastChar == 76 || lastChar == 108);
    }

    public boolean isEndWithNumber() {
        char last = getLastChar();
        return (48 <= last && last <= 57);
    }

    public boolean isKindOf받침Number() {
        char last = getLastChar();

        switch (Number.convert(last)) {
            case ZERO:
            case ONE:
            case THREE:
            case SIX:
            case SEVEN:
            case EIGHT:
                return true;
            case TWO:
            case FOUR:
            case FIVE:
            case NINE:
                return false;
        }
        return false;
    }

    public boolean isOne() {
        char last = getLastChar();
        return last == '1';
    }

    public String getSrc() {
        return this.src;
    }

    private int get종정Idx() {
        char ch = getLastChar();
        int base = ch - HANGUL_SYLLABLES_BEGIN;
        int cs = base / CHOSUNG_BASE;
        int jus = (base - (CHOSUNG_BASE * cs)) / JUNGSUNG_BASE;
        return (base - (CHOSUNG_BASE * cs)) - (JUNGSUNG_BASE * jus);
    }

    private char getLastChar() {
        return src.charAt(src.length() - 1);
    }
}

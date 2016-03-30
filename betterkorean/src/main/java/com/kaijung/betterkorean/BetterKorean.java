package com.kaijung.betterkorean;

/**
 * Created by kai on 16. 3. 29..
 */
public class BetterKorean {

    private KoreanAnalyzer analyzer;

    private BetterKorean(String src) {
        analyzer = new KoreanAnalyzer(src);
    }

    public static BetterKorean with(String src) {
        return new BetterKorean(src);
    }

    public String get_이_가() {
        if (analyzer.isHangul()) {
            return analyzer.isThere종성() ? "이" : "가";
        } else if (analyzer.isEnglish()) {
            return analyzer.isKindOf받침() ? "이" : "가";
        } else if (analyzer.isEndWithNumber()) {
            return analyzer.isKindOf받침Number() ? "이" : "가";
        }else {
            return "";
        }
    }

    public String get_이_가_with() {
        return analyzer.getSrc() + get_이_가();
    }

    public String get_은_는() {
        if (analyzer.isHangul()) {
            return analyzer.isThere종성() ? "은" : "는";
        } else if (analyzer.isEnglish()) {
            return analyzer.isKindOf받침() ? "은" : "는";
        } else if (analyzer.isEndWithNumber()) {
            return analyzer.isKindOf받침Number() ? "은" : "는";
        } else {
            return "";
        }
    }

    public String get_은_는_with() {
        return analyzer.getSrc() + get_은_는();
    }

    public String get_을_를() {
        if (analyzer.isHangul()) {
            return analyzer.isThere종성() ? "을" : "를";
        } else if (analyzer.isEnglish()) {
            return analyzer.isKindOf받침() ? "을" : "를";
        } else if (analyzer.isEndWithNumber()) {
            return analyzer.isKindOf받침Number() ? "을" : "를";
        } else {
            return "";
        }
    }

    public String get_을_를_with() {
        return analyzer.getSrc() + get_을_를();
    }

    public String get_으로_로() {
        if (analyzer.isHangul()) {
            return analyzer.isㄹ종성() ? "로" : (analyzer.isThere종성() ? "으로" : "로");
        } else if (analyzer.isEnglish()) {
            return analyzer.isL() ? "로" : (analyzer.isKindOf받침() ? "으로" : "로");
        } else if (analyzer.isEndWithNumber()) {
            return analyzer.isOne() ? "로" : (analyzer.isKindOf받침Number() ? "으로" : "로");
        } else {
            return "";
        }
    }

    public String get_으로_로_with() {
        return analyzer.getSrc() + get_으로_로();
    }

    public String get_아_야() {
        if (analyzer.isHangul()) {
            return analyzer.isThere종성() ? "아" : "야";
        } else if (analyzer.isEnglish()) {
            return analyzer.isKindOf받침() ? "아" : "야";
        } else if (analyzer.isEndWithNumber()) {
            return analyzer.isKindOf받침Number() ? "아" : "야";
        } else {
            return "";
        }
    }

    public String get_아_야_with() {
        return analyzer.getSrc() + get_아_야();
    }

    public String get_와_과() {
        if (analyzer.isHangul()) {
            return analyzer.isThere종성() ? "과" : "와";
        } else if (analyzer.isEnglish()) {
            return analyzer.isKindOf받침() ? "과" : "와";
        } else if (analyzer.isEndWithNumber()) {
            return analyzer.isKindOf받침Number() ? "과" : "와";
        } else {
            return "";
        }
    }

    public String get_와_과_with() {
        return analyzer.getSrc() + get_와_과();
    }
}

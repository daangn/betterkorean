betterkorean
============

betterkorean 은 ios https://github.com/trillione/JNaturalKorean 을 안드로이드 버전으로 포팅한 라이브러리 입니다.
특정단어에 대한 조사를 자연스럽게 연결해주는 역할을 하고 있어요. 특정 단어를 서버에서 받아오거나 유저의 입력을 받는 경우 이 단어에 대한 조사를 미리 정하지 못하기 때문에 "은(는)" 이런식으로 보기 안좋게 개발을 해야하는 문제를 해결하고 싶어서 포팅을 하게 됐습니다. :)

예) 사과**가** 맜있다, 아버지**가** 바나나**를** 드신다.

사용법
======

_with() 가 붙는 메소드는 단어까지 포함해서 리턴
* BetterKorean.with("아파트").get_와_과() ==> "와" 리턴
* BetterKorean.with("아파트").get_와_과_with() ==> "아파트와" 리턴

```Android
String sample_1 = BetterKorean.with("아빠").get_이_가_with() + " 방으로 들어가신다.";
//"아빠가 방으로 들어가신다.

String sample_2 = BetterKorean.with("집").get_으로_로_with() + " 가야지";
//"집으로 가야지

String region = "서초1동";
String sample_3 = "\'" + region + "\'" + BetterKorean.with(region).get_을_를() + " 내 지역으로 설정할까요?";
//'서초1동'을 내 지역으로 설정할까요?
```

제공하는 인터페이스
===================

```Android
get_이_가(), get_이_가_with() 
get_은_는(), get_은_는_with()
get_을_를(), get_을_를_with()
get_으로_로(), get_으로_로_with()
get_아_야(), get_아_야_with()
get_와_과(), get_와_과_with()
```

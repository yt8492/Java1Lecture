# Lecture4 クラス変数とクラスメソッド

前回は変数とメソッドについて説明したが、厳密に言うと前回説明したのはインスタンス変数とインスタンスメソッドである。
今回はクラス変数とクラスメソッドについて説明する。

## クラス変数、クラスメソッドとは
インスタンス変数、インスタンスメソッドとは、インスタンスから呼び出すことのできる変数(フィールド)やメソッドのことである。
それに対し、クラス変数、クラスメソッドとは、クラスからインスタンス化せずに使うことのできる変数(フィールド)やメソッドのことである。
呼び出し方は、`(クラス名).(変数orメソッド)`である。

## インスタンスとの違い
前回のHumanクラスを再掲する。

```java
class Human {
    int age = 0; // 年齢
    String sex; // 性別 ※本来はenumを使うべき
    String name; // 名前

    Human(String sex, String name) { // コンストラクタ
        this.sex = sex;
        this.name = name;
    }

    void incrementAge() { // メソッド
        age++;
    }
}
```

この例の場合、フィールド`age`, `sex`, `name`がインスタンス変数、メソッド`incrementAge()`がインスタンスメソッドである。
これらは`Human`のオブジェクトから呼び出すことができる。

```java
Human taro = new Human("男", "太郎");
taro.incrementAge();
System.out.println(taro.age); // 1
System.out.println(taro.sex); // 男
System.out.println(taro.name); // 太郎
```

これらがインスタンス変数とインスタンスメソッドである。

今回は、`Human`クラスにクラス変数`speciesName`とクラスメソッド`printSpeciesName()`を追加する。

```java
class Human {
    static String speciesName = "ヒト"; // 追加
    int age = 0;
    String sex;
    String name;

    Human(String sex, String name) {
        this.sex = sex;
        this.name = name;
    }

    void incrementAge() {
        age++;
    }

    static void printSpeciesName() { // 追加
        System.out.println(speciesName);
    }
}
```

クラス変数とクラスメソッドは、インスタンスのそれとは違い、インスタンス化せずに使う。

```java
System.out.println("種族名: " + Human.speciesName); // 種族名: ヒト
Human.printSpeciesName(); // ヒト
```

クラス変数で気をつけるべき点は、あくまで変数なため値の再代入が可能なことである。例えば、以下のような処理も実行できてしまう。

```java
Human.speciesName = "タコ";
Human.printSpeciesName(); // タコ
```

そのため、staticにするのは基本的に定数(再代入不可)のみにするべきである。

```java
class Human {
    static final String speciesName = "ヒト"; // finalを追加
    (以下略)
```

```java
Human.speciesName = "イカ"; // コンパイルエラー
```

再代入可能なstatic変数はバグの温床なのでよほどの理由がない限りはfinalをつけましょう。



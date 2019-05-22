# Lecture11 抽象クラス

## 抽象クラスとは
抽象クラスとは、抽象メソッドを持つことのできるクラスである。抽象メソッドとは、メソッド名、引数、返り値の型のみを定義して具体的な実装を継承先がオーバーライドして実装するメソッドのことである。

抽象クラスの宣言は `class` の前に `abstract` をつける。抽象メソッドの宣言はメソッドの前に `abstract` をつける。

```java
abstract class AbClass {
    abstract void abMethod();
}
```

## インスタンス化

抽象クラスは直接インスタンス化することができない。extendsで抽象クラスを継承し、abstractなメソッドをオーバーライドして実装したクラス(具象クラス)のインスタンスを利用する。

```java
abstract class Person {
    private String name;

    Person(String name) {
        this.name = name;
    }

    abstract String getGreeting();

    void greet() {
        System.out.println(getGreeting() + " I'm " + name +".");
    }
}

class JapanesePerson extends Person {
    JapanesePerson(String name) {
        super(name);
    }

    @Override
    String getGreeting() {
        return "こんにちは。";
    }
}

class EnglishPerson extends Person {
    EnglishPerson(String name) {
        super(name);
    }

    @Override
    String getGreeting() {
        return "Hello.";
    }
}

class Main {
    public static void main(String[] args) throws Exception {
        Person japanese = new JapanesePerson("Taro");
        Person american = new EnglishPerson("Tom");
        japanese.greet(); // こんにちは。 I'm Taro.
        american.greet(); // Hello. I'm Tom.
    }
}
```

抽象クラスの主な用途として、一部の処理を共通化するなどがある。

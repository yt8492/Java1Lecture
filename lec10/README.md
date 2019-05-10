# Lecture10 継承について その2
今回はクラスの継承について細かく説明する。

## 親クラスのコンストラクタの呼び出し
親クラスのコンストラクタに引数がある場合、子クラスのコンストラクタ内で親クラスのコンストラクタを呼び出す必要がある。

```java
class Hoge {
    int foo;

    Hoge(int foo) {
        this.foo = foo;
    }
}

class Fuga extends Hoge {
    int bar;

    Fuga(int foo, int bar) {
        super(foo); // 親クラスのコンストラクタ呼び出し
        this.bar = bar;
    }
}
```

呼び出し方は `super(引数);` である。親クラスのコンストラクタに必要な引数のみ括弧内に入れる。

## 親クラスのメソッド呼び出し
親クラスのメソッドをオーバーライドするとき、必要に応じて親クラスのメソッドを呼び出すことができる。

```java
class Foo {
    void sayFoo() {
        System.out.println("Foo"); // Foo
    }
}

class Bar extends Foo {
    @Override
    void sayFoo() {
        super.sayFoo(); // Foo
        System.out.println("Bar"); // Bar
    }
}
```

```java
Bar bar = new Bar();
bar.sayFoo(); // Foo Bar
```

呼び出し方は `super.メソッド名(引数)` である。
コンストラクタと違い、必ずしも必要ではない。

## おまけ Objectクラス
全てのクラスは暗黙的にObjectクラスを継承している。

代表的なメソッドに `toString` と `equals` がある。

[Lecture8](https://github.com/yt8492/Java1Lecture/blob/master/lec08/README.md)でも紹介したが、 `System.out.println` はObjectクラスの引数をとる場合がある。その場合内部で`toString`を呼び出している。

```java
class MyClass {
    String desc;

    MyClass(String desc) {
        this.desc = desc;
    }

    @Override
    public String  toString() {
        return desc;
    }
}
```

```java
MyClass myClass = new MyClass("hogehoge");
System.out.println(myClass); // hogehoge
```

この例の場合、内部で `myClass.toString()` を呼び出しているため、hogehogeが出力される。

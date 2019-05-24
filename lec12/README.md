# Lecture12 インターフェース

## インターフェースとは
インターフェースは、抽象メソッドと定数(static finalなフィールド)のみ持つことができる。(Java8以降のインターフェースはデフォルト実装を持つことができるがここでは触れない。)

## 抽象クラスとの違い
抽象メソッドを持つ点や単体ではインスタンス化できず必ずなにかに継承させないと使えない点など、インターフェースと抽象クラスは共通点が多い。しかし、抽象クラスとの最大の違いとして、複数継承可能という点がある。

インターフェースの継承は `extends` ではなく `implements` でやる。抽象メソッドの定義は、抽象クラスと違い `abstract` をつける必要がない。

```java
interface Foo {
    void doSomething(String foo);
}

class Bar implements Foo {

    @Override
    public void doSomething(String foo) {
        System.out.println(foo);
    }
}

class Main {
    public static void main(String[] args) throws Exception {
        Foo foo = new Bar();
        foo.doSomething("Hoge"); // Hoge
    }
}
```

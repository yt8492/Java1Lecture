# Lecture9 継承について その1
Javaのクラスには継承という概念がある。
継承周りの話は複雑なので初めに例を示し少しずつ解説していく。

## 親クラスと子クラス
継承元のクラスを親クラス、継承先のクラスを子クラスという。

以下の例では`Parent`が親クラス、それを継承している`Child`が子クラスである。

継承のやり方は、クラス名の定義のところで

`class 子クラス名 extends 親クラス名`

とする。

```java
class Parent {
    String name = "Parent";
    int num = 1;

    void printName() {
        System.out.println(name);
    }

    void printFoo() {
        System.out.println("Foo");
    }
}

class Child extends Parent {
    String parentName = super.name;
    String name = "Child";

    @Override
    void printName() {
        System.out.println("override");
        System.out.println(name);
    }

    void printParent() {
        System.out.println(num);
        System.out.println(parentName);
    }
}
```

```java
Parent parent = new Parent();
parent.printName(); // Parent
parent.printFoo(); // Foo

Child child = new Child();
child.printName(); // override Child
child.printParent(); // 1, Parent
child.printFoo(); // Foo
```

↑からもわかるとおり、継承元のクラスに定義してあるメソッド(`printFoo()`)は、継承先のインスタンスからも呼び出すことができる。
また、継承元の型の変数に継承先の型のインスタンスを代入することもできる。

```java
Parent p = new Child();
p.printName(); // override Child
```

継承元の型の変数に継承先の型のインスタンスを入れている場合でも、メソッドの呼び出しは実際のインスタンスのメソッド(この場合はChildのprintName)になる。

継承先の型の変数に継承元の型のインスタンスを代入することはできない。しかし、前述の例のように継承元の型の変数に継承先のインスタンスが入っている場合、その変数をキャストすることで代入することができる。

```java
Parent p = new Child();
Child c = p; // コンパイルエラー
if (p instanceof Child) { // pのインスタンスがChildであることの証明
    Child c = (Child) p; // キャストして代入
}
```

キャストに失敗すると例外が発生してプログラムが終了してしまうので、キャストする前にifで `instanceof` 演算子を用いてキャストできるかチェックするようにするべきである。

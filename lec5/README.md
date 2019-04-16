# Lecture5 nullについて
Javaでプログラミングをする上で避けて通れないのがnullである。 ~~ぬるぽを許すな~~

## nullとは
Null（ヌル、ナル）は、何もない、という意味で、プログラミング言語などコンピュータ関係では、「何も示さないもの」を表すのに使われる。同様のものに、nil が使われることもある。他の名前のこともある。(Wikipediaより)

Javaでは、この「何もない」を表すのに`null`を使う。nullは参照型の変数にのみ入れることができる。

```java
int a = null; // コンパイルエラー
Integer b = null; // ok
```

nullは変数宣言のときに明示的に何も入っていないことを表すために使ったり、または何らかの値を取得するメソッド(ファイル読み込みなど)で何も取得できなかった時にnullを返したりする。
また、クラスのフィールドに値を何も入れずに宣言した場合、デフォルトで暗黙的にnullが入る。
前回使ったHumanクラスでコンストラクタで初期化をしない場合の例を挙げる。

```java
class Human {
    int age = 0;
    String sex;
    String name;

    Human(){} // 空のコンストラクタ

    Human(String sex, String name) {
        this.sex = sex;
        this.name = name;
    }

    void incrementAge() {
        age++;
    }
}

class Main {
    public static void main(String[] args) {
        Human human = new Human();
        System.out.println(human.name); // null
    }
}
```

暗黙的なnullはバグの原因になりやすいため、デフォルト値がない場合は基本的にコンストラクタでフィールドの変数に値を入れるか、もしくは明示的にnullを代入するべきである。

## NullPointerException
nullは「何もない」ため、nullが入っている変数を使おうとすると`NullPointerException`(通称ぬるぽ)が発生しプログラムが終了してしまう。

```java
String str = null;
System.out.println(str.length()); // 無の長さは取得できないためぬるぽ
```

そのため、変数にnullが入る可能性がある場合は使う前にnullのチェックをする必要がある。

```java
if (str == null) {
    return;
}
System.out.println(str.length()); // nullの場合は直前のifでreturnするためここではぬるぽが起きない
```

正しくnullを扱うことでバグを防ぎましょう。

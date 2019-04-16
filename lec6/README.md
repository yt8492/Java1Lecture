# Lecture6 条件分岐と繰り返し
JavaもCと同じようにif文、switch-case文、for文、while文、do-while文がある。
ただし、できることに若干の差異があるため注意が必要。

## if文
基本的にC言語と同じだが、括弧内の値は真偽値(booleanもしくはBoolean)である必要がある。

```java
int a = 1;
if (a == 1) {
    System.out.println("a is one");
} else if (a > 1) {
    System.out.println("a is bigger than one");
} else {
    System.out.println("a is smaller than one");
}
```

条件を網羅していれば、ifとelseだけでreturnできる。

```java
boolean isEven(int x) {
    if (x % 2 == 0) {
        return true;
    } else {
        return false;
    }
}
```

注意: 今回はあくまでifの説明のためにこのような関数を作って説明しているだけで、本来は`return x % 2 == 0;`とすべきである。

## switch-case文
これも基本的にCと同じ。括弧内に判定させたい変数を、caseに一致するか確かめたい定数を書く。caseに変数を指定することは不可能。また、参照型であってもcaseにnullを指定することは不可能(コンパイルエラー)。

switch-case文で使えるのはintからbyteまでのプリミティブ型(int, char, short, byte)、それらのラッパークラス(Integer, Character, Short, Byte)、String、列挙型(あとでやる)のみ。

```java
String str = "String";
switch (str) {
    case "boolean":
        System.out.println("bool");
        break;
    case "int":
    case "short":
    case "long":
        System.out.println("integer");
        break;
    case "String":
        System.out.println("string");
        break;
    default: 
        System.out.println("other");
        break;
}
// string
```

一つ注意しなければいけないのが、参照型の場合switchの括弧内に渡す変数がnullの場合、NullPointerExceptionが発生するということ。これは、参照型の場合には一致するかの判定を`equals`メソッドでしているため。

## for文
これも基本的にCと同じだが、ループ変数をforの括弧内で宣言できる。

```java
for (int i = 0; i < 10; i++) {
    System.out.println(i); // 0~9まで出力される
}
```

配列をforで回すときは継続条件のところで`配列.length`を使うのが一般的。

```java
int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
for (int i = 0; i < array.length; i++) {
    System.out.println(array[i]); // 1~10まで出力される
}
```

### おまけ: 拡張for文
配列を扱う際、ループ変数が不要なときは拡張for文を使うこともできる。

```java
int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
for (int num : array) {
    System.out.println(num); // 1~10まで出力される
}
```

要素を直接取得できるのでループ変数が不要なときはこちらのほうが良い。

## while文, do-while文
こちらもCと基本的に同じ。
ただし、ifと同じく条件には真偽値のみ使用可能。無限ループは`while(1)`ではなく`while(true)`を使う。
do-whileも同様。

```java
int i = 0;
while (i < 5) {
    System.out.println(i);
    i++;
}
```

```java
int i = 0;
do {
    System.out.println(i);
    i++;
} while (i < 5);
```

どちらも0~4が出力される。

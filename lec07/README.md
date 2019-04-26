# Lecture7 演算子編
四則演算は[Lecture2](https://github.com/yt8492/Java1Lecture/blob/master/lec02/README.md)で既に解説しているため省略。

## 論理演算

### シフト演算
シフト演算とは、変数をビット列として考えたときに、ビット列を左や右にずらす演算のことである。
プリミティブの`int`, `long`, `short`, `byte`, `char`と、それらのラッパークラスである`Integer`, `Long`, `Short`, `Byte`, `Character`で使うことができる。

byte型変数aに4が入っている場合、2進数では`00000100`と表すことができる。この0と1の並びがビット列である。

```java
byte a = 0b00000100; // 0bを先頭につけると2進数
System.out.println(a); // 4
```

4(00000100)を右にずらす右シフト演算は`>>`で、左にずらす左シフト演算は`<<`でできる。

```java
byte a = 0b00000100; // 4
System.out.println(a << 1); // 8(00001000)
System.out.println(a >> 1); // 2(00000010)
```

Javaのシフト演算は符号無し左シフト、符号付き右シフト、符号無し右シフトの3種類ある。

|演算子|意味|
|:-:|:-:|
|<<|符号無し左シフト|
|>>|符号付き右シフト|
|>>>|符号無し右シフト|

符号無しシフトは空いた分に0を、符号付きシフトは最上位ビットと同じ数字が入る。

```java
int a = 0b10000000000000000000000000000000; // -2147483648
System.out.println(a >> 1); // -1073741824
System.out.println(a >>> 1); // 1073741824
```

これは、算術右シフトである`>>`と論理右シフトである`>>>`で最上位ビットの扱いの差によって結果が変わっている。

### 注意
`int`未満のサイズの型(`short`, `byte`)は、シフト演算の際に内部で暗黙的に`int`に変換されてから演算が行われるため注意が必要。

```java
byte a = -128; // 2進数で10000000
System.out.println(a >> 1); // -64
System.out.println(a >>> 1); // 2147483584(この時だけintになっている)
a >>>= 1;
System.out.println(a); // -64(この時点ではbyteに戻っている)
```

これは、byteの-128が内部で一旦intの-128(11111111111111111111111110000000)に変換されてから右シフトさせているため、論理シフトであっても結果が(11000000)となってしまい、-64になる。

### 論理演算
Javaにも論理演算(論理積, 論理和, 論理否定, 排他的論理和)が用意されている。

|演算子|意味|
|:-:|:-:|
|&|論理積|
|&#124;|論理和|
|~|論理否定|
|^|排他的論理和|

```java
byte a = 0b00000111;
byte b = 0b00011100;
System.out.println(a & b); // 4(00000100)
System.out.println(a | b); // 31(00011111)
System.out.println(~a); // -8(11111000)
System.out.println(a ^ b); // 27(00011011)
```

`~` はbooleanに使うことができないため注意。

booleanのみに使える論理積、論理和、論理否定もある。

|演算子|意味|
|:-:|:-:|
|&&|論理積|
|&#124;&#124;|論理和|
|!|論理否定|

```java
boolean t = true;
boolean f = false;
System.out.println(t && f); // false
System.out.println(t || f); // true
System.out.println(!t); false
```

&&と&、||と|の違いは、短絡評価があるかどうか。

|演算子|短絡評価|
|:-:|:-:|
|&|なし|
|&&|あり|
|&#124;|なし|
|&#124;&#124;|あり|

短絡評価をするとは、`true or false`(true) や `false and true`(false)など、左辺のみで結果が決まる場合に右辺の評価をしないこと。条件分岐で使う場合は短絡評価ありのほうがよい。

## インクリメント/デクリメント
これはCと同じ。

インクリメントは`++`、デクリメントは`--` 。

```java
int i = 0;
System.out.println(i++); // 0
System.out.println(++i); // 2
```

## 代入演算子
これも基本的にCと同じ。
四則演算のほかに論理演算やシフト演算でも使える。

|演算子|説明|
|:--:|:--:|
|=|右辺の値を左辺に代入|
|+=|右辺の値を加算した結果を代入|
|-=|右辺の値を減算した結果を代入|
|\*=|右辺の値を乗算した結果を代入|
|/=|右辺の値で除算した結果を代入|
|%=|右辺の値で除算した余りを代入|
|&=|右辺の値で論理積演算した結果を代入|
|&#124;=|右辺の値で論理和演算した結果を代入|
|^=|右辺の値で排他的論理和演算した結果を代入|
|<<=|右辺の値だけ論理左シフトした結果を代入|
|>>=|右辺の値だけ算術右シフトした結果を代入|
|>>>=|右辺の値だけ論理右シフトした結果を代入|

## 三項演算子
`<条件式> ? <trueのときの値> : <falseのときの値>` といった形で使う。

条件によって変数に代入する値を変えたい場合、単純な条件分岐の場合はifよりも三項演算子を使ったほうがよい。

ifを使う場合

```java
int i = 2;
String str;
if (i % 2 == 0) {
    str = "偶数";
} else {
    str = "奇数";
}
System.out.println(str); // 偶数
```

三項演算子を使う場合

```java
int i = 2;
String str = i % 2 == 0 ? "偶数" : "奇数";
System.out.println(str); // 偶数
```

## instanceof
instanceof演算子はオブジェクトの型を判定する。

```java
Number number = new Integer(1);
System.out.println(number instanceof Double); // false
System.out.println(number instanceof Integer); // true
```

```java
Integer integer = new Integer(1);
System.out.println(integer instanceof Number); // true(Integer型はNumber型を継承しているため。)
```



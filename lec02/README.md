# Lecture2 変数宣言から四則演算まで

## 前提知識: プリミティブ型と参照型
C言語には普通の変数とポインタ変数があるが、Javaにはポインタの概念はなく、代わりにプリミティブ型と参照型の2つがある。

### プリミティブ型
`int`, `float`, `double`, `boolean`, `char`, `byte`, `short`, `long` がある。

### 参照型
プリミティブ型以外の型。`Object`クラスもしくはそれの子孫クラス。`Integer`, `Float`, `Double`, `Boolean`, `Character`, `Byte`, `Short`, `Long`, `String`など。

### プリミティブ型と参照型の違い
プリミティブ型は値自身を、参照型は値のある場所を保持する。
例えば、

```java
int a = 1;
int b = 1;
System.out.println(a == b);
```

は`true`が出力されるが、

```java
Integer c = new Integer(1);
Integer d = new Integer(1);
System.out.println(c == d);
```

は`false`が出力されるはず。

これは、`int`同士の `==` での比較は値(この場合だと1)を比較しているが、`Integer`同士の `==` での比較は値のある場所(この場合だと変数cと変数dの
場所)を比較しているため。

## 変数宣言と初期化
基本的にC言語と同じ。`long`のLや`float`のfは省略可能。

```java
int a = 1;
long b = 2L;
double c = 3.5;
float d = 4.5f;
String str = "string";
```

Cと違い、文字列は`char`型の配列ではなく`String`型を使う。

## 四則演算
これも基本的にC言語と同じ。

```java
int a = 5;
int b = 2;
System.out.println(a + b); // 7
System.out.println(a - b); // 3
System.out.println(a * b); // 10
System.out.println(a / b); // 2
System.out.println(a % b); // 1
```

`int`, `long`, `byte`, `short`, `float`, `double`同士は明示的なキャストなしに四則演算を行うことができる。

### おまけ: Stringの+
`String`も`+`が使えるが、これは文字列の連結に使う。

```java
String str1 = "Java";
String str2 = "Script";
System.out.println(str1 + str2); // JavaScript
```


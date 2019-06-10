# Lecture13 例外
Javaではプログラムのエラーを例外(Exception)を用いて表す。

## 例外とは
記述したプログラムに期待していない動作が起きたことを例外と呼ぶ。

例えば、サイズが5の配列arrayで `array[5]` を指定するとエラーになるが、これが例外である。

この場合、C言語では `Segmentation fault (core dumped)` がエラーとして吐かれるが、Javaでは `ArrayIndexOutOfBoundsException` というもう少し具体的なエラーと、どのクラスのどのメソッドのどの行でそれが起きたかを教えてくれるスタックトレースと呼ばれるものが出力される。以下に例を示す。

```java
public class Main {
    public static void main(String[] args) {
        ExceptionTest test = new ExceptionTest();
        test.throwException();
    }
}

class ExceptionTest {
    void throwException() {
        int[] array = new int[4];
        for (int i = 0; i < 4; i ++) {
            array[i] = i;
        }
        for (int i = 0; i <= 4; i ++) {
            System.out.println(array[i]);
        }
    }
}
```

出力結果

```
0
1
2
3
Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 4
	at ExceptionTest.throwException(Main.java:15)
	at Main.main(Main.java:4)

Process finished with exit code 1
```

この例では、存在しない5番目の要素(i=4)にアクセスした時点で例外が吐かれている。

エラーの読み方は

```
Exception in thread "スレッド名" 例外のクラス名: メッセージ
  at 例外が起きたクラス名.メソッド名(ファイル名:行番号)
```

である。例外が起きたメソッドの呼び出し元も出力される。

この例の場合だと、 `Main` クラスの `main` メソッドで呼び出された `ExceptionTest` クラスの `throwException` メソッドで例外が起きたということがスタックトレースから読み取ることができる。

## 例外の種類
Javaの例外には大きく分けて3つの例外がある。

- 検査例外
- 実行時例外
- エラー

検査例外は、プログラムの中で必ず捕捉(catch)するか上位の呼び出し元に対して例外を投げる(throws)かしないといけない(後述)。これをしないとコンパイルエラーになる。

実行時例外は、検査例外と違い、プログラムの中で捕捉しなくてもコンパイルエラーにならない。 `ArrayIndexOutOfBoundsException` や `NullPointerException` などがこれにあたる。

エラーは、システムの動作を継続するべきではない致命的なエラーを示す。これはプログラムで捕捉するべきではない。 `OutOfMemoryError` (メモリ不足)などがある。

## 例外の捕捉
例外が発生するとプログラムが停止してしまうが、この例外はtry-catchを用いて捕捉・対処することができる。以下に例を示す。

```java
public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println(reader.readLine());
        } catch (IOException e) {
            System.out.println("catch IOException " + e.getMessage());
        }
    }
}
```

`BufferedReader` の `readLine()` メソッドは、例外`IOException` を投げる可能性がある。これは検査例外のため、try-catchを用いて捕捉しないとコンパイルエラーになってしまう。

`try` のブロックの中で実際に `IOException` が発生した場合、 `catch (IOException e)` のブロックの処理が実行される。

## throws
try-catchで例外を捕捉しない代わりに起きた例外を上位の呼び出し元に投げる `throws` がある。以下に例を示す。

```java
public class Main {
    public static void main(String[] args)  {
        try {
            printReadLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printReadLine() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(reader.readLine());
    }
}
```

`printReadLine` メソッドで検査例外の発生する可能性のある処理をしているが、メソッドの定義に `throws IOException` をしているため、そのメソッド内では例外を捕捉しなくてもコンパイルエラーが起こらない。そのかわりに、 `printReadLine` メソッドを呼び出している `main` メソッド側で例外を捕捉する必要がある。

## finally
try-catchで例外が起きたか起きていないかに関わらず最終的に実行したい処理は `finally` を使って処理することができる。

```java
public static void main(String[] args)  {
    try {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(reader.readLine());
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        System.out.println("finish");
    }
}
```

`try` ブロックが正常に終了した場合でも、 `try` ブロック内で例外が発生して `catch` ブロックが実行された場合でも、最終的に `finally` ブロックの処理が実行される。この場合、どんな場合でも `finish` が最終的に出力される。



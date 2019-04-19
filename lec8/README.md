# Lecture8 メソッドのオーバーロードについて
Javaは同じ名前で引数の数や種類が異なるメソッドを複数作ることができる。`System.out.println`がその一例である。

`System.out`に定義されている`println`一覧

```java
public void println()
public void println(boolean x)
public void println(char x)
public void println(int x)
public void println(long x)
public void println(float x)
public void println(double x)
public void println(char x[])
public void println(String x)
public void println(Object x)
```

## 注意: イレイジャについて
これはJava2の範囲なので詳しい説明は省くが、同じ名前で引数の異なるメソッドでも場合によってコンパイルエラーになる場合がある。

```java
class Example {
    void printList(List<String> list) {
        for (String str : list) {
            System.out.println(str);
        }
    }

    void printList(List<Integer> list) {
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}
```

この例では、同じ`printList`という名前で引数の`list`が`List<String>`の場合と`List<Integer>`の場合の2つメソッドを作ったが、この例はコンパイルエラーになる。

`List`の`<>`内に指定している型がListの種類になる(StringのリストとIntegerのリスト)が、Javaのコンパイラは引数に渡される型の情報として`List`が定義されていることしか知ることができない(<>内の型は無視される)ため、コンパイラからはこの2つのメソッドはどちらも`void printList(List list)`として見えている。そのため、同じ名前と引数のメソッドが2つあると認識されてしまい、コンパイルエラーになる。

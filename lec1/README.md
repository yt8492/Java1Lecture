# Lecture1 Hello world編

## Javaがインストールされているかの確認
今回はJava8を使う前提で資料を作っています。

ターミナルで

```
java -version
```

を実行、

```
java version "1.8.0_201"
Java(TM) SE Runtime Environment (build 1.8.0_201-b09)
Java HotSpot(TM) 64-Bit Server VM (build 25.201-b09, mixed mode)
```

のように表示されれば既にJavaの実行環境が導入されているので次に進んでください。

エラーが出る場合は導入が完了していないので各環境ごとの導入記事などを参考に導入してください。

[Windows](https://eng-entrance.com/java-install-jdk-windows)
[Mac](https://eng-entrance.com/java-install-jdk-mac)

## Hello worldを出力するまで

### ファイルの作成
適当な作業用ディレクトリに`Lec1.java`というファイルを作成してください。

### ソースコードの記述
以下のソースコードをコピペして保存してください。

```java:Lec1.java
class Lec1 {
    public static void main(String[] args) {
        System.out.println("Hello world");
    }
}
```

### コンパイル
Lec1.javaと同じディレクトリでコマンドラインから

```
javac Lec1.java
```

を実行してください。ディレクトリ内に`Lec1.class`というファイルが生成されれば成功です。

### 実行
コマンドラインから

```
java Lec1
```
を実行すると、

```
Hello world
```
が表示されるはずです。

## 少し解説

`public static void main(String[] args)`は、C言語の`main`関数みたいなもの

`System.out.println()`は標準出力(C言語の`printf`で変数の変換指定子(`%d`, `%s`など)を指定する必要がなく改行も
自動でしてくれるやつみたいな)

自動で改行しないものには`System.out.print()`がある

# Lecture3 クラスとインスタンス
Java初心者が一番つまづきやすいのがクラスとインスタンスである。説明不足の部分や分かり辛い説明は遠慮なく指摘してほしい。

## クラス
C言語でいう構造体に関数を持たせられるようにしたようなもの。

```java
class Human {
    int age = 0; // 年齢
    String sex; // 性別 ※本来はenumを使うべき
    String name; // 名前

    Human(String sex, String name) { // コンストラクタ
        this.sex = sex;
        this.name = name;
    }
    
    void incrementAge() { // メソッド
        age++;
    }
}
```

`age`, `sex`, `name` はフィールドで、Cの構造体でいうメンバのこと。
メソッドは関数。
コンストラクタについてはインスタンスの項目で説明する。

## インスタンス
上記の `Human` クラスを実際に使ってみる。

```java
class HumanDemo {
    public static void main(String[] args) {
        Human taro = new Human("男", "太郎");
        System.out.println("名前:" + taro.name + ", 性別:" + taro.sex + ", 年齢:" + taro.age); // 名前:太郎, 性別:男, 年齢:0
        taro.incrementAge(); // 年齢を1歳プラスする
        System.out.println("名前:" + taro.name + ", 性別:" + taro.sex + ", 年齢:" + taro.age); // 名前:太郎, 性別:男, 年齢:1
    }
}
```

`Human taro = new Human("男", "太郎");` の部分でインスタンスを生成している。

インスタンスとは、クラスで定義したものの実体のこと。例えば、今回のHumanクラスの場合、クラスに年齢、性別、名前の定義を書き、インスタンスの生成でその実体(今回の場合性別男で名前が太郎、年齢は初期値で0)を作っている。

インスタンスの生成( `new Human` )でインスタンス生成に必要な情報を引数として渡す。今回の場合は性別と名前。

コンストラクタ内では、インスタンス生成時に必要な処理を行う。

```java
Human(String sex, String name) {
    this.sex = sex;
    this.name = name;
}
```

ここでは引数として渡されたageとnameを、フィールドのageとnameに代入している。

引数として渡されたageとnameは、既にフィールドとして存在しているnameとageに名前が被るため、区別するためにフィールドのほうのageとnameにthisをつける必要がある。

`taro.incrementAge()` のように、クラスで定義したメソッドはインスタンスから呼び出すことができる。

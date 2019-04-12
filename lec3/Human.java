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

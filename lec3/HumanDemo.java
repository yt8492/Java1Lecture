class HumanDemo {
    public static void main(String[] args) {
        Human taro = new Human("男", "太郎");
        System.out.println("名前:" + taro.name + ", 性別:" + taro.sex + ", 年齢:" + taro.age);
        taro.incrementAge();
        System.out.println("名前:" + taro.name + ", 性別:" + taro.sex + ", 年齢:" + taro.age);
    }
}

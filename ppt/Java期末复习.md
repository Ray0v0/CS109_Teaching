## Java前置知识

### Java的诞生

1990年

Sun公司

James Gosling

一次编写，全平台运行

### Java的运行环境

JRE: Java Runtime Essential Java运行必要组件

JDK: Java Development Kit Java开发套件

JVM: Java Virtual Machine 用来运行Java的虚拟机（类似安卓模拟器）

JDK包含JRE，JRE包含JVM

### Java的运行流程

#### 编译型语言

代表：C

工作方式：由编译器将程序转换成机器语言，再由CPU一次性执行

优缺点：运行效率高，跨平台支持差

#### 解释型语言

代表：Python

工作方式：解释一条，运行一条

优缺点：运行效率低，跨平台支持高

#### Java

类型：编译-解释型语言

工作方式：由编译器将.java文件转换成.class文件，再由JVM对.class文件解释并执行

### ASCII编码

编码规范

32 -> space

48 -> 0

65 -> A

97 -> a

### X进制编码

各进制编码相互转换

## Java编程基础

### 运算符

#### 算数运算符

```java
// + - * / % ++ --

// 运算优先级
// ++ -- 
// * / %
// + -

// 结合性 - 从左至右

// 整除
int a = 5;
int b = 3;
int c = a / b; // 都是整数，整除运算 c = 1
double d = a / b; // 先整除，然后将结果转换为浮点数，d = (double) 1 = 1.0
double e = 3.0;
double f = a / d; // 运算数中存在浮点数，进行浮点数运算，e = 1.66...

// 小quiz，下面哪个是正确的？
A. int g = a / d;
B. g = (int) a / d;
C. int g = (int) (a / d);
D. int g = (int) a / (int) d;

// 自增自减运算符
// a++ 和 ++a 有什么区别？
int a = 1;
System.out.println(a++); // 输出 1
System.out.println(a);   // 输出 2
System.out.println(++a); // 输出 3
System.out.println(a);   // 输出 3
// System.out.println(a++); 等价于 System.out.println(a); a += 1;
// System.out.println(++a); 等价于 a += 1; System.out.println(a);

// 小quiz，执行代码后a和b的结果分别是多少？
int a = 1;
int b = a+++ ++a*a++;
System.out.println(a);
System.out.println(b);
```

#### 关系运算符

```java
// == != > < >= <=

// 运算优先级
// > < >= <=
// == !=

// 结合性 - 从左至右运算符
```

#### 位移运算符

```java
// << >> >>> 
// 结合性 - 从左至右

// 位移的意义：乘/除以二的n次方
int a = 4;
int a = -4;
System.out.println(Integer.toBinaryString(a));       // 11...11(30个1)00
System.out.println(Integer.toBinaryString(a >> 2));  // 11...11(30个1)11
System.out.println(Integer.toBinaryString(a >>> 2)); // 001...1(28个1)11
```

#### 逻辑运算符与位运算符

```java
// 逻辑运算符
// && || !

// 优先级
// !
// &&
// ||
// (!a && b || c && !d) 等价于 (((!a) && b) || (c && (!d)))

// 位运算符
// & | ^ ~

// 异或（xor）运算符^（不是幂！！！）
// 1 ^ 1 = 0
// 0 ^ 0 = 0
// 1 ^ 0 = 1
// 0 ^ 1 = 1

// 逻辑短路：在 b < 3不成立后，Java不会运行a[b]!=0，因此不存在数组越界的情况
int[] a = new int[]{1, 2, 3};
int b = 3;
if (b < 3 && a[b] != 0) {
    System.out.println(a[b]);
}

// 位运算符没有逻辑短路，下面的程序运行会报错
int[] a = new int[]{1, 2, 3};
int b = 3;
if (b < 3 & a[b] != 0) {
    System.out.println(a[b]);
}
```

#### 赋值运算符

```java
// = += -= *= /= %= <<= >>= &= ^= |=
// 结合性 - 从右向左！！！

int a = 5;
int b = a += 1;
// 等价于 a += 1; c = b;

// 下面这两个问题应该不会考，但我还是想提一句
// 1. a += 1 完全等价于 a = a + 1 吗？
// 下面这句代码不会报错
byte a += 1
// 下面这句代码会报错，因为1是int类型的，a + 1被强制转换成了int类型，无法直接赋值给a
byte a = a + 1;
// 应该改成
byte a = (byte) (a + 1);
// 2. a += 1 完全等价于 a++ 吗？
// a += 1 是一个赋值语句
// 而 a++ 可以被作为一个变量放在表达式中
```

在进行赋值运算时，要注意类型匹配，详见下文“基本数据类型与类型转换”

#### 其他运算符

```java
// 三元运算符 - (条件) ？ (成立表达式) : (不成立表达式)
int a = 1;
int b = 2;
int c = a == b ? a : b; // c = 2
// 结合性 - 从右至左
int d = a == b ? a : a == b ? a : b;
// 等价于
int c = (a == b) ? a : b;
int d = (a == b) ? a : c;

// instanceof运算符
String s = "123";
System.out.println(s instanceof String); // true

// 对继承也有效
// 假设有一个类叫Human，有一个接口叫Mamba
class Man extends Human implements Mamba {}
Human whatCanISay = new Man();
System.out.println(whatCanISay instanceof Human);  // true
System.out.println(whatCanISay instanceof Man);    // true
System.out.println(whatCanISay instanceof Mamba);  // true
System.out.println(whatCanISay instanceof String); // false
```

#### 运算符优先级（自己去背）

### 基本数据类型与类型转换

#### 基本数据类型

八种基本数据类型

```java
byte by; // 1个字节
short s; // 2个字节
int i; // 4个字节
long l; // 8个字节
char c; // 2个字节
float f; // 4个字节
double d; // 8个字节
boolean bo; // 1个字节
```

地址有几个字节？

32位计算机系统中，地址是32位的，即4字节

64位计算机系统中，地址是64位的，即8字节

**浮点数的表示要注意精度问题！**

#### 类型转换

##### 八种基本数据类型的转换

核心：低精度自动转为高精度，高精度强制转为低精度

byte -> short -> int -> long -> float -> double

```java
int a = 5;
long b = a;
int c = (int) b;

// 下面的程序是否正确？
long a = 5, b = 10;
int c = (int) a + b;

// (int) 只对紧跟着的表达式生效
// 正确的写法应该是
int c = (int) (a + b);
```

char

```java
// char -> int
char c = 'a';
int i = c; // i = 97

// [0, 65536)的整数可以被转换成char
char c = 97; // c = 'a';
char d = 65536; // 会报错
```

boolean不能被上述方法转换

##### 立即数与变量间的类型转换

```java
long d = 100; // 不会报错，Java自动把int类型的100自动转换成了长整型
long d = 100_0000_0000; // 会报错，因为一百亿超过了int类型的表示范围
long d = 100_0000_0000L; // 因此需要在后面加L表示长整型

float f = 3.33; // 会报错，因为3.33默认是double类型，赋值给float会有精度损失
float f = 3.33f; // 因此需要加f表示float类型
```

##### String的转换

转成String

```java
int n = 5;
String s = String.valueOf(n);

char c = 'a';
String s = String.valueOf(c);

float f = 3.33f;
String s = String.valueOf(f);

boolean b = true;
String s = String.valueOf(b);
```

从String转（char除外）

```java
int n = Integer.parseInt(s);
double d = Double.parseDouble(s);
boolean b = Boolean.parseBoolean(s);
```

String转char

```java
// 获取String中第n位的字符
char c = s.charAt(n);

// 将整个String转换成char[]
char[] c = s.toCharArray();
```

##### 溢出与报错

Java中溢出不会报错

```java
// byte的范围是[0, 256)
byte b = (byte) 256; // b = 0

// 运算中的溢出
int n = Integer.MAX_VALUE + 1; // n = -2147483648 = Integer.MIN_VALUE

// 利用这一特性，可以在不使用第三个变量的情况下交换两个变量的值
int a, b;
a = a + b;
b = a - b;
a = a - b;
```

由String通过XXX.parseXXX()方法转换为其他类型可能报错

```java
String s = "Hello";
int i = Integer.parseInt(s); // 报错
```

### 关键字

abstract, final, break, continue, class, enum, interface, extends, implements, import, instanceof, new, null, private, protected, public, return, static, super, this, try, void等，理解每个词的含义和作用

## 面向对象编程

### 值和地址

值与地址在Java中的存储方法没有任何区别，只有意义的差别

变量a中存储的101既可以表示一个值101，也可以表示一个门牌号101

```java
int a; // 表示值
String b; // 表示地址

System.out.println(a); // 直接输出101
System.out.println(b); // Java会去101栋房子寻找存储的具体内容，然后输出，例如"Hello World"
```

八种基本类型的变量中储存的是值

其他的变量中储存的都是地址

```java
// Java中所有的函数传递都是存储内容的复制
// 具体原理请回看第一次的录屏

// 下面这个例子中，主方法里a的值不会改变，输出0
public static void main() {
    int a = 0;
    intAddOne(a);
    System.out.println(a);
}
static void intAddOne(int a) {
    a += 1;
}

// 下面这个例子中，主方法里a[0]的值会改变，输出1
public static void main() {
    int[] a = new int[1];
    a[0] = 0;
    System.out.println(a[0]);
}
static void arrayAddOne(int[] a) {
    a[0] += 1;
}

// 特殊例子，String
// 下面这个例子中，主方法里s不会改变，输出"Hello"
public static void main() {
    String s = "Hello";
    System.out.println(s);
}
static void stringAddOne(String s) {
    s += 1; // "Hello1"
}
```

### 类和对象（Static和非Static）

核心思想：类是对象（实例）的集合

例如：日常生活中，当我们说“鼠标”的时候，我们可以指代具体某一个鼠标（对象），也可以指代鼠标这一类事物（类）。

```java
// 类Mouse表示鼠标这类东西
class Mouse {
    // static表示是类公有的，下文中mouse1和mouse2的name都是“鼠标”
    static String name = "鼠标";
    static String getName() {return name;}
    // 非static表示是对象私有的，mouse1的型号是Master3s，mouse2型号是GPW
    String model;
    String getModel() {return model;}
    public Mouse(String model) {
        this.model = model;
    }
} 

public static void main() {
    Mouse mouse1 = new Mouse("Master3s"); // 对象mouse表示某个具体的鼠标
    Mouse mouse2 = new Mouse("GPW");
}
```

只要类存在，static的变量/方法就存在；只有对象被创建，非static的变量/方法才被创建

因此，static变量和方法可以随时被访问，而非static变量和方法只能通过对象访问

### 继承

核心思想：给对象归类

对类的继承通过extends关键字申明

一个类只能继承一个父类

final class无法被继承

子类会继承父类的所有方法与变量（即使无法访问）

```java
class Man {}
class Mamba extends Man {}
```

类对接口的实现通过implements关键字申明

接口对接口的实现通过extends关键字申明

一个类/接口能实现多个接口

接口中未定义的方法为抽象方法，需要子类定义

接口中已定义的变量和方法默认为静态常量和静态方法（该方法只能通过接口名调用）

```java
interface BasketBall { void playBasketBall(); }
interface Rap { void rap(); }
interface Sing extends Rap { void sing(); }
interface Dance { void dance(); }
class BlackPurple implements Sing, Dance, BasketBall {
    // 接口的实现：略
}
```

从某种程度来说，对接口的实现是一种更弱的继承

对类的继承表示了某一类物体的本质特征

对接口的实现赋予了某一类物体其他特性

```java
// 例如，下面这段代码描述了：
// BlackPurple的本质特征为人
// BlackPurple会唱跳Rap篮球
class BlackPurple extends Human implements Sing, Dance, BasketBall{
    // 接口的实现：略
}
```

### 多态

核心思想：一个对象可以被归入多个类中

例如，ikun可以既是BlackPurple，也是Human

```Java
// ikun被归入BlackPurple类
BlackPurple ikun = new BlackPurple();
// ikun可以唱跳Rap篮球
ikun.sing();
ikun.dance();
ikun.rap();
ikun.playBasketBall();


// ikun被归入Human类
Human ikun = new BlackPurple();
// 因为ikun被归入Human类，Java不知道ikun可以唱跳rap篮球
// 因此如果ikun需要表演唱跳rap篮球，需要类型转换
((BlackPurple) ikun).rap();

// 万一这是真ikun，不是小黑子，那么上面的类型转换在运行时会报错
// 因此在类型转换的时候最好判断一下这个ikun是不是小黑子
if (ikun instanceof BlackPurple) {
    ((BlackPurple) ikun).rap();
}
```

假设BlackPurple和Human都有eat()方法

```java
Human ikun = new BlackPurple();
ikun.eat(); // 仍然会调用BlackPurple的eat()方法，这是一种动态绑定
```

### 可见性（封装）

核心思想：我们只需要关注方法，不需要关注具体实现方式

例如：我们都会使用电脑，但我们不需要知道电脑具体是怎么运行的；驾校会教你开车，但是驾校不会教你怎么造车。

四种可见性：

修饰符：private, (default), protected, public

可见性：类内部，+包内，+子类，+全局

**为什么要有可见性？**

1. 正常人开车只需要懂得踩油门踩刹车就够了，但是小明恰好懂一点造车，想要装X，偏不用油门刹车，反而把仪表盘拆了直接接线，然后把车给搞炸了——在协作中，将部分变量或方法暴露给他人可能是很危险的，他人对这些变量或方法的错误使用可能导致程序的崩溃，因此将这些变量或方法设为private，相当于给仪表盘钉死，保障程序的运行安全。
2. 小黑子会打篮球，黑曼巴也会打篮球；如果两者都是public的，那么在调用方法的时候，就容易调用错。将二者设为private，可以在一定程度上避免混淆。

### 抽象类

核心思想：接口是最抽象的类，类是最具象的接口

|        | 具象方法 | 抽象方法 | 创建实例对象 |
| ------ | -------- | -------- | ------------ |
| 普通类 | 可以有   | 不能有   | 可以创建     |
| 抽象类 | 可以有   | 可以有   | 不能创建     |
| 接口   | 不能有   | 可以有   | 不能创建     |

```java
// 抽象类中的抽象方法用abstract修饰
abstract class 抽象类 {
    abstract void 搞抽象();
    void 不搞抽象() {}
}

// 接口中的抽象方法不用abstract修饰
interface 抽象接口 {
    void 搞抽象();
}
```

### Override和Overload（Dynamic / Static Binding）

Override 重写

Overload 重载

```java
// 下面是一个Override的例子
class Man {
    public void say() {
        System.out.println("Hello!");
    }
}

class Mamba extends Man {
    // @表示注解，是Java语言的一种独特写法
    // @Override表示告诉编译器下面这个方法是一个对父类同名方法的重写
    // 如果下面这个方法名字写错或者拼错了（比如写成了says），编译器会帮你检查并报错
    // 因此@Override是一种“代码规范”，能够降低你写代码出错的概率，但是不写也行
    // （有些注解，例如JavaFX或SpringBoot中的注入，不得不写）
    @Override
    public void say() {
        System.out.println("What can I say!");
    }
}

// 由于Man的say方法被Mamba重写，因此当Mamba对象（尽管被存在Man对象容器中）在调用该方法的时候会优先调用Mamba.say()；如果Mamba没有重写say方法，则调用Mam.say()
// 编译器无法在编译时确定具体调用哪个方法，因为在编译器看来，bryant被储存在Man对象容器中，但是编译器不知道bryant究竟是Man的实例还是Mamba的实例。因此bryant.say()调用的是Man.say()还是Mamba.say()是在实际运行时才被确定的，这就叫做Dynamic Binding（动态绑定）
public static void main() {
    Man bryant = new Mamba();
    bryant.say();  // What can I say!
}

// 下面是一个Overload的例子
// 两个具有不同参数的同名方法构成了Overload（方法重载），Java会根据具体传入参数确定究竟哪个方法被调用；由于参数类型是确定的，因此具体调用哪个方法在编译时就可以确定，这就叫做Static Binding（静态绑定）
public static void main() {
    int a = 1;
    float b = 2;
    addLittle(a); // 2
    addLittle(b); // 2.1
}
static void addLittle(int k) {
    System.out.println(k + 1)
}
static void addLittle(float k) {
    System.out.println(k + 0.1);
}

// 小quiz，一个特殊情况
public static void main() {
	Man m = new Mamba();
    call(m); // 会输出什么？
}
static void call(Man m) {
	System.out.println("Man!");
}
static void call(Mamba m) {
    System.out.println("What can I say!!!");
}
```

### ENUM类

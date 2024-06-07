## 运算符

算数运算符

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
// int g = a / d;
// int g = (int) a / d;
// int g = (int) (a / d);
// int g = (int) a / (int) d;

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

关系运算符

```java
// == != > < >= <=

// 运算优先级
// > < >= <=
// == !=

// 结合性 - 从左至右运算符
```

位移运算符

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

逻辑运算符与位运算符

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

赋值运算符

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

其他运算符

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

运算符优先级（自己去搜去背）

## 基本数据类型

```

```



## 值和地址

值与地址在Java中的存储方法没有任何区别，只有意义的差别

变量a中存储的101既可以表示一个值101，也可以表示一个门牌号101

```java
int a; // 表示值
char a; // 表示值
String a; // 表示地址
int[] a; // 表示地址

System.out.println(int a); // 直接输出101
System.out.println(String a); // Java会去101栋房子寻找存储的具体内容，然后输出，例如"Hello World"
```

值传递与地址传递（建议回看第一次课内容）

## Override和Overload（Dynamic / Static Binding）



## enum类


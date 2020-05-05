#### java的基本数据类型

| 数据类型      | 占字节 | 占位数 | 包装类型 | 取值范围                                   | 归类     |
| ------------- | ------ | ------ | -------- | ------------------------------------------ | -------- |
| byte          | 1      | 8      | Byte     | -128到127                                  | 整数类型 |
| short         | 2      | 16     | Short    | -32768到32767                              | 整数类型 |
| int           | 4      | 32     | Integer  | -2147483648到2147483647                    | 整数类型 |
| long          | 8      | 64     | Long     | -9223372036854775808到9223372036854775807  | 整数类型 |
| float         | 4      | 32     | Float    | 小数                                       | 浮点类型 |
| double        | 8      | 64     | Double   | 范围越大，精度越高                         | 浮点类型 |
| boolean       |        |        | Boolean  | true和false                                | 布尔类型 |
| char          | 2      | 16     | Char     | 从'\u0000'到'\uffff'包括在内，即从0到65535 | 字符型   |
| returnAddress |        |        |          | 虚拟机内部使用，我们不能直接使用           |          |

##### boolean类型

尽管Java虚拟机定义了一种 `boolean`类型，但它仅提供对它的非常有限的支持。没有Java虚拟机指令专门用于`boolean` 值的操作。相反，将对`boolean`值进行运算的Java编程语言中的表达式 编译为使用Java虚拟机`int`数据类型的值(4个字节)。

Java虚拟机确实直接支持`boolean`数组。它*newarray*指令，能够创建`boolean` 阵列。类型的阵列`boolean`被访问并且使用经修改的 `byte`阵列指令*baload*和*bastore*。

在Oracle的Java虚拟机实现中，`boolean`将Java编程语言中的`byte`数组编码为Java虚拟机数组，每个`boolean`元素使用8位 。

Java虚拟机`boolean` 使用`1`表示`true`和`0`表示对数组组件进行编码`false`。如果`boolean`编译器将Java编程语言值映射到Java虚拟机类型的值`int`，则编译器必须使用相同的编码。

##### returnAddress类型

该`returnAddress`类型由Java虚拟机的使用*JSR*，*RET*和*jsr_w*指令。该`returnAddress` 类型的值是指向Java虚拟机指令的操作码的指针。与数字原始类型不同，该`returnAddress`类型不与任何Java编程语言类型相对应，并且不能由正在运行的程序进行修改。只有该`returnAddress`类型不与Java编程语言类型直接关联。我们不能直接使用
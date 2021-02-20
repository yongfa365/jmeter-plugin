### 简介
写JMeter函数插件的最少必要代码
- jdk8
- gui对应的class类的全名称必须满足：*.gui.*，也就是包名必须有gui
- 编译成jar包，放到Jmeter所在目录，如：D:\Tools\apache-jmeter\lib\ext

### 打包方法
![](build.png)

图上的jar包名错了，仅演示用，不影响

### 演示
![](demo.png)


### 代码
[LoginController及GUI](src\main\java\yongfa365\jmeter\control)

GuiUtil是辅助用的，初次用代码画UI太难了，还是用别人封装好的吧
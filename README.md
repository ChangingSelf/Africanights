# Africanights

明日非舟，java写的练手作品，明日方舟抽卡模拟

## 环境

| 系统    | win10                                     |
| ------- | ----------------------------------------- |
| IDE     | eclipse                                   |
| jdk     | java8（可能会改）                         |
| gui框架 | swing（肯定会改，做好试验品后改为javaFX） |

## 进度

- [x] 从1~6星中抽取星级
- [ ] 从对应星级的简历池，抽取下一份简历



## 测试代码

测试代码注释在源代码中，在起始注释处删除`*`即可解除注释。如：

```java
/*/测试代码1
这是未在测试的代码块
//测试代码1**/

//测试代码2
这是正在测试的代码
//测试代码2**/
```



### 从1~6星中抽取星级

Pool类的main函数

```java
public class Pool {
    //...
	public static void main(String[] args) {
		//测试randomStar()
		Pool pool = new Pool();
		int[] counter=new int[7];
		for(int i=0;i<100;i++) {
			int star = pool.randomStar();//测试randomStar()
			System.out.format("%d\n",star);
			counter[star]++;
		}
		for(int i=0;i<7;i++) {
			System.out.format("抽到%d星%d个\n",i,counter[i]);
		}
		//测试randomStar()*/

	}
}
```


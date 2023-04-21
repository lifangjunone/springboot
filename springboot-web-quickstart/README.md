# springboot
## 三层架构
- controller: 控制层  接受前端发送的请求,对请求进行处理,并响应数据
- service: 业务逻辑层   处理具体的业务逻辑
- dao: 数据访问层(Data Access Object)   负责数据访问操作,包括数据的增删改查

## IOC & DI 
> 将所有的依赖对象都存入到一个容器当中,然后在程序运行的时候将依赖进行注入进去

#### 控制反转
> Inversion of Control, 简称 IOC. 对象的创建控制权由程序自身转移到外部(容器),这种思想成为控制反转.
#### 依赖注入
> Dependency injection, 简称 DI. 容器为应用程序提供运行时所依赖的资源,称之为依赖注入.
#### Bean对象
> IOC 容器中创建,管理的对象,称之为 bean.

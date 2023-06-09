## AOP
> 面向切面编程，面向特定的方法编程
##### 场景
- 记录操作日志
- 权限控制
- 事物管理

##### 优势
- 代码无侵入
- 减少重复代码
- 提高开发效率
- 维护方便

##### AOP 核心概念
- 连接点：　JoinPoint,　可以被AOP控制的方法（暗含方法执行时的相关信息）
- 通知：　Advice, 指那些重复的逻辑，也就是共性功能（最终体现为一个方法）
- 切入点:  PointCut, 匹配连接点的条件，通知仅会在切入点方法执行时被应用
- 切面: Aspect
- 目标对象: Target

#####　Advice type (通知类型)
- @Around: 环绕通知，　目标方法前、后执行
- @Before: 前置通知，　目标方法前执行
- @After:  后置通知，　目标方法后执行（无论是否有异常）
- @AfterReturning: 返回后通知，　目标方法后执行（有异常不执行）
- @AfterThrowing: 异常后通知，　目标方法异常后执行
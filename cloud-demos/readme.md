# spring cloud 学习笔记
@(spring)[spring cloud|eureka]

---

[TOC]

## 模块简介
- register
> 服务注册中心(Eureka)

- commons
> 公用域，主要包括domain、util相关

- server-user

依赖: `[commons]`
> 用户相关服务


- server-bpm
> 流程相关服务

- server-project

消费: `[server-user]``
> 项目相关服务，使用ribbon 消费server-user
1. 尝试在project里面通过ribbon消费user服务


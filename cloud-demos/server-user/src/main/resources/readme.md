# 用户微服务

---
> 本模块，演示微服务模块是如何以服务提供者(provider)的身份，向指定服务注册中心进行服务注册的.


## 配置信息
- 端口: 8101
- 服务ID: service-user
- 注册地址: http://localhost:8100/eureka/

## 依赖配置
- eureka 服务注册
```
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-config</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-netflix-eureka-server</artifactId>
</dependency>
```
- application 注解
```
@SpringBootApplication
# 用于server发现与注册
@EnableEurekaServer 
```

## 数据
```
create table t_user_authorize(
  id int4 not null,
  username varchar(32) not null,
  password varchar(24) not null,
  created timestamp not null default now(),
	create_by int4 not null,
  updated timestamp not null default now(),
  update_by int4,
  state int2 not null default 0,
  constraint PK_USER_ID primary key(id)
);

comment on table t_user_authorize is '用户账户信息';
comment on column t_user_authorize.id is '主键ID';
comment on column t_user_authorize.username is '用户登陆名';
comment on column t_user_authorize.password is '用户密码';
comment on column t_user_authorize.created is '创建日期';
comment on column t_user_authorize.create_by is '创建人ID';
comment on column t_user_authorize.updated is '更新时间';
comment on column t_user_authorize.update_by is '更新人ID';
comment on column t_user_authorize.state is '账号状态 [0-未激活,1-激活,2-禁用]';
```



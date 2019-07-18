# 根据MyBatis实体类生成表结构

适用于Mybatis生成工具生成的实体类。

## 原理

解析Mybatis生成的实体类java文件，拼装成JPA需要的实体类，使用JPA的生成表结构功能。

## 功能

- 根据类名生成表名（驼峰转下划线）
- 根据属性的中文注释，生成字段注释
- 根据属性的类型，生成字段的类型

## 程序运行步骤

1. 修改com.mybatis.data.file.InputFile类中的的`filePath`路径，修改为MyBatis的实体类路径
2. 运行InputFile，会在项目的jpa目录下生成jpa格式的实体类
3. 修改application.yaml中的数据库配置
4. 运行GenerateDataApplication

执行完毕上述步骤，表结构就生成好了
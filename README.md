# myBatisGeneratorPlugin
自定义生成myBatis相关文件

## 使用说明

1. 在pom文件加入

```xml
<plugin>
          <groupId>org.mybatis.generator</groupId>
          <artifactId>mybatis-generator-maven-plugin</artifactId>
          <version>1.3.5</version>
          <configuration>
            <overwrite>true</overwrite>
            <configurationFile>src/main/resources/generatorConfig/generatorConfig.xml</configurationFile>
          </configuration>
          <dependencies>
            <dependency>
              <groupId>org.mybatis</groupId>
              <artifactId>mybatis</artifactId>
              <version>3.3.0</version>
            </dependency>
            <dependency>
              <groupId>mysql</groupId>
              <artifactId>mysql-connector-java</artifactId>
              <version>5.1.21</version>
            </dependency>
            <dependency>
              <groupId>org.mybatis.generator</groupId>
              <artifactId>mybatis-generator-core</artifactId>
              <version>1.3.2</version>
            </dependency>
            <dependency>
              <groupId>me.caixin</groupId>
              <artifactId>myBatisGeneratorPlugin</artifactId>
              <version>1.0.0</version>
            </dependency>
          </dependencies>
        </plugin>
```

2. 执行
```java
mybatis-generator:generate
```
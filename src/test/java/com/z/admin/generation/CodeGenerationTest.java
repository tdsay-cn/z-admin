package com.z.admin.generation;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.z.admin.entity.po.base.BasePo;
import jakarta.annotation.Resource;
import org.apache.ibatis.annotations.Mapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Types;
import java.util.Collections;

/**
 * @author tdsay
 * @description 代码生成
 */
@SpringBootTest
public class CodeGenerationTest {

    @Resource
    private MysqlPropertyMaster mysqlPropertyMaster;

    @Resource
    private MysqlPropertySlave1 mysqlPropertySlave1;

    @Resource
    private MysqlPropertySlave2 mysqlPropertySlave2;

    /**
     * 主库代码生成
     */
    @Test
    public void codeGenerationMaster() {
        String url = mysqlPropertyMaster.getUrl();
        String username = mysqlPropertyMaster.getUsername();
        String password = mysqlPropertyMaster.getPassword();
        generateCode(url, username, password, "master");
    }

    /**
     * 从库1代码生成
     */
    @Test
    public void codeGenerationSlave1() {
        String url = mysqlPropertySlave1.getUrl();
        String username = mysqlPropertySlave1.getUsername();
        String password = mysqlPropertySlave1.getPassword();
        generateCode(url, username, password, "slave_1");
    }

    /**
     * 从库2代码生成
     */
    @Test
    public void codeGenerationSlave2() {
        String url = mysqlPropertySlave2.getUrl();
        String username = mysqlPropertySlave2.getUsername();
        String password = mysqlPropertySlave2.getPassword();
        generateCode(url, username, password, "slave_2");
    }

    /**
     * 通用代码生成方法
     * @param url 数据库连接URL
     * @param username 用户名
     * @param password 密码
     * @param dataSourceName 数据源名称（用于日志输出）
     */
    private void generateCode(String url, String username, String password, String dataSourceName) {
        System.out.println("开始生成代码，数据源: " + dataSourceName);
        System.out.println("数据库URL: " + url);

        FastAutoGenerator.create(url, username, password)
                .globalConfig(builder -> {
                    builder.author("system") // 设置作者
                            .outputDir(System.getProperty("user.dir") + "/src/main/java") // 指定输出目录
                            .disableOpenDir(); //生成完不打开文件夹
                })
                .dataSourceConfig(builder ->
                        builder.typeConvertHandler((globalConfig, typeRegistry, metaInfo) -> {
                            // 自定义类型转换
                            int typeCode = metaInfo.getJdbcType().TYPE_CODE;
                            if (typeCode == Types.SMALLINT) {
                                return DbColumnType.INTEGER;
                            } else if (typeCode == Types.TINYINT) {
                                return DbColumnType.INTEGER;
                            }
                            return typeRegistry.getColumnType(metaInfo);
                        })
                )
                .packageConfig(builder ->
                        builder.parent("com.z.admin")
                                .entity("entity.po")
                                .mapper("dao")
                                .pathInfo(Collections.singletonMap(OutputFile.xml, System.getProperty("user.dir") + "/src/main/resources/mybatis")) // 设置mapperXml生成路径
                )
                .strategyConfig(builder ->
                        //po配置
                        builder.entityBuilder()
                                //设置po父类
                                .superClass(BasePo.class)
                                //设置父类字段（数据库中的字段），为了在子类中忽略这些字段的生成
                                .addSuperEntityColumns("id", "create_by", "create_time", "update_by", "update_time", "create_time", "is_disabled", "is_deleted")
                                //不生成序列化id
                                .disableSerialVersionUID()
                                //使用lombok
                                .enableLombok()
                                //覆盖已生成文件
                                .enableFileOverride()

                                //controller配置
                                .controllerBuilder()
                                //不生成controller
                                .disable()

                                //service配置
                                .serviceBuilder()
                                .formatServiceImplFileName("%sService")

                                //mapper配置 生成@Mapper注解
                                .mapperBuilder()
                                .mapperAnnotation(Mapper.class)
                )
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();

        System.out.println("代码生成完成，数据源: " + dataSourceName);
    }
}

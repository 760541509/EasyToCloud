package com.yingtongquan.startcommon;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CodeGenerator {


    private static final String ENTITYNAME = "%sPo";
    private static final String SERVICENAME = "%sService";


    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StrUtil.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        String projectName = "yingtongquan";

        String projectPath = System.getProperty("user.dir");
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入子项目名称");
        String mainModuleName = scanner.next();
        System.out.println("输入模块名称");
        String moduleName = scanner.next();


//        System.out.println("要生成java代码文件的路径==="+projectPath+"\\"+mainModuleName+"\\src\\main\\java\\com\\"+projectName+"\\"+mainModuleName+"\\"+moduleName);
//        System.out.println("要生成mapper文件的路径==="+projectPath+"\\"+mainModuleName+"\\src\\main\\resources\\mapper\\"+moduleName);


        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://192.168.0.102:3306/easytocloud?serverTimezone=UTC&characterEncoding=utf8&useUnicode=true&useSSL=false");

        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("root");
        mpg.setDataSource(dsc);

        String mainPath = projectPath + "\\" + mainModuleName + "\\src\\main\\java\\";
//        System.out.println("相同路径==="+mainPath);

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(mainPath);
        gc.setEntityName(ENTITYNAME);
        gc.setServiceName(SERVICENAME);
        gc.setAuthor("ML");
        gc.setOpen(false);
        gc.setSwagger2(true);
        gc.setBaseResultMap(true);
        gc.setBaseColumnList(true);
        mpg.setGlobalConfig(gc);

        //java文件包配置
        PackageConfig pc = new PackageConfig();
        String mainModuleName2 = mainModuleName;
        int _index = mainModuleName2.indexOf("_");
        if (_index != -1) {
            mainModuleName2 = mainModuleName2.substring(0, _index);
        }
        String parent = "com." + projectName + "." + mainModuleName2;
//        System.out.println("parent==="+parent);
        pc.setParent(parent);
        pc.setModuleName(moduleName);
        mpg.setPackageInfo(pc);


        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        // 如果模板引擎是 freemarker
        String templatePath = "/templates/mymapper.xml.ftl";
        // 如果模板引擎是 velocity
//         String templatePath = "/templates/mapper.xml.vm";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                System.out.println(tableInfo);
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                //projectPath+"\\"+mainModuleName+"\\src\\main\\resources\\mapper\\"+moduleName
                //+"\\"+moduleName
                return projectPath + "\\" + mainModuleName + "\\src\\main\\resources\\mapper" + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });

        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setXml(null);
        templateConfig.setMapper("/templates/mymapper.java");
        templateConfig.setController("/templates/mycontroller.java");
//    templateConfig.setService("/templates/myservice.java");
//    templateConfig.setServiceImpl("/templates/myserviceImpI.java");
        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
//        strategy.setSuperEntityClass("com.baomidou.ant.common.BaseEntity");
//        strategy.setEntityLombokModel(false);
        strategy.setRestControllerStyle(true);
        // 公共父类
//        strategy.setSuperControllerClass("com.baomidou.ant.common.BaseController");
        // 写于父类中的公共字段`
//        strategy.setSuperEntityColumns("id");
        //scanner("表名，多个英文逗号分割").split(",")
        strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));
        strategy.setControllerMappingHyphenStyle(false);
        strategy.setTablePrefix(pc.getModuleName() + "_");
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }

}

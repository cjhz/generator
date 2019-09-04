/**
 * Copyright © 2018 Treefinance All Rights Reserved
 */
package org.mybatis.generator;

import org.junit.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by chenjh on 2019/9/4.
 * <p>
 * TODO 添加类描述
 */
public class MyBatisGeneratorPlusTest {

    @Test(expected = InvalidConfigurationException.class)
    public void testGenerateMyBatis3WithInvalidConfig() throws Exception {
        List<String> warnings = new ArrayList<String>();
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(this.getClass().getClassLoader().getResourceAsStream("generatorConfigExtends.xml"));

        DefaultShellCallback shellCallback = new DefaultShellCallback(true);

        try {
            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, shellCallback, warnings);
            myBatisGenerator.generate(null);
        } catch (InvalidConfigurationException e) {
            e.printStackTrace();
            throw e;
        }
    }

}

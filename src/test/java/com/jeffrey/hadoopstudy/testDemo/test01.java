package com.jeffrey.hadoopstudy.testDemo;

import com.jeffrey.hadoopstudy.demo.HdfsUtils;
import org.apache.hadoop.fs.FileSystem;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @version 1.0
 * @Aythor jeffrey 王吉慧
 * @date 2022/3/2 17:45
 * @description
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class test01 {

    @Resource
    private HdfsUtils hdfsUtils;

    private String url="hdfs://localhost:9000";

    @Test
    public void test01() {
        FileSystem fileSystem = hdfsUtils.getFileSystem(url);
        System.out.println(fileSystem);
    }

    @Test
    public void test02() {
        hdfsUtils.mkdir(url,"/createTest");
    }

}

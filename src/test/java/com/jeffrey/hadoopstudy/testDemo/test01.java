package com.jeffrey.hadoopstudy.testDemo;

import com.alibaba.fastjson.JSON;
import com.jeffrey.hadoopstudy.demo.HdfsUtils;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;
import org.apache.hadoop.fs.BlockLocation;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.hdfs.protocol.DatanodeInfo;
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


    @Test
    public void test03() {
        hdfsUtils.rmdir(url,"/createTest");
    }

    @Test
    public void test04() {
        String[] strings = hdfsUtils.listFile(url, "/", null);
        for (String str : strings) {
            System.out.println(str);
        }
    }

    @Test
    public void test05() {
        hdfsUtils.copyFileToHDFS(url,false, false, "F:\\Profession\\hadoop\\hadoop-2.7.1-one\\README.txt","/temp/copy");
    }

    @Test
    public void test06() {
        hdfsUtils.getFile(url, "/temp/copy","E:\\repository\\gitRepository\\my-projects\\hadoop-study\\src\\main\\java\\com\\jeffrey\\hadoopstudy\\document\\copy.txt");
    }

    @Test
    public void test07() {
        DatanodeInfo[] hdfsNodes = hdfsUtils.getHDFSNodes(url);
        System.out.println("hdfsNodes=" + JSON.toJSONString(hdfsNodes));
    }

    @Test
    public void test08() {
        BlockLocation[] fileBlockLocations = hdfsUtils.getFileBlockLocations(url, "/temp/copy");
        System.out.println("fileBlockLocations=" + JSON.toJSONString(fileBlockLocations));
    }


    @Test
    public void test09() {
        boolean b = hdfsUtils.existDir(url, "/temp", false);
        System.out.println(b);
    }

}

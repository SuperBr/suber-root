package com.mojo;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.io.File;

/**
 * @author wangyongchao
 * @date 2019/2/15  10:06
 */


/**
 ${basedir} 项目根目录
 ${project.build.directory} 构建目录，缺省为target
 ${project.build.outputDirectory} 构建过程输出目录，缺省为target/classes
 ${project.build.finalName} 产出物名称，缺省为${project.artifactId}-${project.version}
 ${project.packaging} 打包类型，缺省为jar
 ${project.xxx} 当前pom文件的任意节点的内容
 */
@Mojo(name = "plugin", defaultPhase = LifecyclePhase.PACKAGE)
public class MyPluginMojo extends AbstractMojo {

    @Parameter(defaultValue = "${project.build.directory}" + "/docker")
    private File dockerDir;

    @Parameter(required = true)
    private String st;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        System.out.println("this is my first plugin!");
        System.out.println(dockerDir);
    }
}

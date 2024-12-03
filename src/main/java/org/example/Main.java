package org.example;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException, LifecycleException {
    final var tomcat = new Tomcat();

    final var baseDir = Files.createTempDirectory("tomcat");

    baseDir.toFile().deleteOnExit();

    tomcat.setBaseDir(baseDir.toAbsolutePath().toString());

    final var connector = new Connector();

    connector.setPort(9999);

    tomcat.setConnector(connector);

    tomcat.getHost().setAppBase(".");
    tomcat.addWebapp("", ".");

    tomcat.start();
    tomcat.getServer().await();
    }
}
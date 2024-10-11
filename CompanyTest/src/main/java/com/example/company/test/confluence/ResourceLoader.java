package com.example.company.test.confluence;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.InputStream;
import java.io.IOException;

public class ResourceLoader {
    public static void main(String[] args) {
        InputStream resourceAsStream = null;

        try {
            resourceAsStream = ResourceLoader.class.getClassLoader().getResourceAsStream("atlassian-plugin.xml");
            if (resourceAsStream == null) {
                System.err.println("未找到 atlassian-plugin.xml 文件！");
                return;
            }

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(resourceAsStream);
            doc.getDocumentElement().normalize();

            // 这里可以添加修改 XML 的逻辑...

            // 使用相对路径
            String path = "src/main/resources/atlassian-plugin.xml";
            File outputFile = new File(path);

            // 确保目标目录存在
            outputFile.getParentFile().mkdirs();

            // 将修改后的内容写回原文件
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(outputFile);
            transformer.transform(source, result);

            System.out.println("XML 文件已成功修改！");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭 InputStream
            if (resourceAsStream != null) {
                try {
                    resourceAsStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

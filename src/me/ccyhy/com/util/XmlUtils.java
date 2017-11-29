package me.ccyhy.com.util;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

/**
 * @author ccyhy
 * XML解析类工具
 * 1，获取与xml关联的文档对象，以便于提供给数据访问层进行使用
 * 2，根据关联文档对象，将修改后的内容写入对应的xml文件
 */
public class XmlUtils
{
    //数据源文件名对象
    private static final String filename="DB.xml";
    public static Document getDocument() throws DocumentException
    {
        //反射得到classPath的类路径URL对象，以便于加载文件
        URL url=XmlUtils.class.getClassLoader().getResource(filename);
        //获取文件的真实路径
        String realPath=url.getPath();
        //创建SAXReader对象
        SAXReader reader=new SAXReader();
        //返回xml关联的文档对象
        return  reader.read(new File(realPath));
    }
    public static void write2Xml(Document document)throws IOException
    {
        //获取文件真实路径
        String realPath=XmlUtils.class.getClassLoader().getResource(filename).getPath();
        //美化格式
        OutputFormat format=OutputFormat.createPrettyPrint();
        //XmlWriter对象
        XMLWriter writer=new XMLWriter(new FileOutputStream(realPath),format);
        //将文档对象写入xml文件
        writer.write(document);
        //关闭
        writer.close();
    }
}

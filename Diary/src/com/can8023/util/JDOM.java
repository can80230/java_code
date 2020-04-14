package com.can8023.util;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.XMLOutputter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class JDOM {
    public static String write(String n, String p, String id) {
        String path = "D:\\Code\\java_code\\Diary\\src\\UserInfo.xml";
        File file = new File(path);
        SAXBuilder saxBuilder = new SAXBuilder();
        Document doc;
        try {
            doc = saxBuilder.build(file);

            Element root = doc.getRootElement();
            Element user = new Element("User");
            Element name = new Element("name");
            Element passwd = new Element("passwd");

            if (checkID(id, root)) {
                user.setAttribute(new Attribute("id", id));
                name.setText(n);
                passwd.setText(p);

                user.addContent(name);
                user.addContent(passwd);

                root.addContent(user);

                XMLOutputter out = new XMLOutputter();
                out.output(doc, new FileOutputStream(file));
                return "Successful registration";
            } else {
                return "ID already exists, please input again";
            }
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "ERROR";
    }

    public static boolean checkID(String id, Element root) {
        // 检测 ID 是否存在，true 则不存在。
        boolean flag = true;
        List<Element> list = root.getChildren("User");
        Iterator<Element> it = list.iterator();
        while (it.hasNext()) {
            Element e = (Element) it.next();
            if (e.getAttributeValue("id").equals(id)) {
                flag = false;
            }
        }
        return flag;
    }

    public static String read(String id, String passwd) {
        String path = "D:\\Code\\java_code\\Diary\\src\\UserInfo.xml";
        File file = new File(path);
        SAXBuilder saxBuilder = new SAXBuilder();

        try {
            Document doc = saxBuilder.build(file);
            Element root = doc.getRootElement();

            String info = getPasswd(root).get(id);
            if (info == null) {
                return "User does not exist!!";
            }
            String[] buf = info.split("/");
            if (buf[0].equals(passwd)) {
                return "Successful landing/" + buf[1];
            }
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Wrong passwd!!";
    }

    /* 将用户的密码和姓名添加到 map 集合中 */
    private static Map<String, String> getPasswd(Element root) {
        Map<String, String> map = new TreeMap<String, String>();
        List<Element> list = new ArrayList<Element>();
        list = root.getChildren("User");
        Iterator<Element> it = list.iterator();
        while(it.hasNext()) {
            Element e = it.next();
            String id = e.getAttributeValue("id");
            String passwd = e.getChildText("passwd");
            String name = e.getChildText("name");
            map.put(id, getInfo(passwd, id));
        }
        return map;
    }

    /* 处理用户密码和信息 */
    private static String getInfo(String passwd, String name) {
        return passwd + "/" + name;
    }
}


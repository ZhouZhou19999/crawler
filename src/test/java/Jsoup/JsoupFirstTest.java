package Jsoup;

import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.File;
import java.net.URL;

public class JsoupFirstTest {

    //解析网页
    @Test
    public void testUrl() throws Exception {
        Document doc = Jsoup.parse(new URL("http://www.baidu.com"), 1000);
        String title = doc.getElementsByTag("title").first().text();
        System.out.println(title);

    }

    //解析字符串
    @Test
    public void testString() throws Exception {
        String content = FileUtils.readFileToString(new File("D:/Idea2020/YunXingWenJian/crawler-first/src/test/java/Jsoup/1.txt"), "utf-8");
        Document doc = Jsoup.parse(content);
        String text = doc.getElementsByTag("title").first().text();
        System.out.println(text);
    }

    //解析文件
    @Test
    public void testFile() throws Exception {
        Document doc = Jsoup.parse(new File("D:/Idea2020/YunXingWenJian/crawler-first/src/test/java/Jsoup/1.html"), "utf-8");
        String title = doc.getElementsByTag("title").first().text();
        System.out.println(title);
    }

    //使用dom的方式
    @Test
    public void testDOM() throws Exception {
        Document doc = Jsoup.parse(new File("D:/Idea2020/YunXingWenJian/crawler-first/src/test/java/Jsoup/1.html"), "utf-8");

        //Id
        Element element = doc.getElementById("city_bj");
        System.out.println(element.text());

        //标签
        String span = doc.getElementsByTag("span").first().text();
        System.out.println(span);

        //class
        String classa_b = doc.getElementsByClass("class_a").first().text();
        System.out.println(classa_b);

        //属性
        Elements abc = doc.getElementsByAttribute("abc");
        System.out.println(abc.first().text());

        //属性&&属性值
        Elements elementsByAttributeValue = doc.getElementsByAttributeValue("href", "http://sh.itcast.cn");
        System.out.println(elementsByAttributeValue.text());
    }

    //获取其中的数据
    @Test
    public void testData() throws Exception {
        Document doc = Jsoup.parse(new File("D:/Idea2020/YunXingWenJian/crawler-first/src/test/java/Jsoup/1.html"), "utf-8");
        Element test = doc.getElementById("test");
        String str = "";

//        str = test.attr("id");

//        Attributes attributes = test.attributes();
//        System.out.println(attributes.toString());

//        str = test.attr("id");

//        Set<String> strings = test.classNames();
//        for (String string : strings) {
//            System.out.println(string);
//        }
        str = test.text();

        System.out.println(str);
    }

    //元素选择器
    @Test
    public void testSelector() throws Exception {
        Document doc = Jsoup.parse(new File("D:/Idea2020/YunXingWenJian/crawler-first/src/test/java/Jsoup/1.html"), "utf-8");
        //1.标签
//        Elements span = doc.select("span");
//        for (Element element : span) {
//            System.out.println(element.className());
//        }

        //2.ID
//        Element id = doc.select("#city_bj").first();
//        System.out.println(id);

        //3.class
//        Element first = doc.select(".s_name").first();
//        System.out.println(first.text());

        //4.属性
//        Elements select = doc.select("[abc]");
//        System.out.println(select.text());
//        Elements select = doc.select("[class=s_name]");
//        System.out.println(select.text());
    }

    @Test
    public void testSelector2() throws Exception {
        Document doc = Jsoup.parse(new File("D:\\Idea2020\\YunXingWenJian\\carwlar\\src\\test\\java\\Jsoup/1.html"), "utf-8");
//        标签id
//        Element select = doc.select("h3#city_bj").first();

//标签class
//        Element select = doc.select("li.class_a").first();

//        元素+属性名
//        Element first = doc.select("span[abc]").first();

//        Elements select = doc.select("span.s_name[abc=123]");

//        查找他下的他
//        Elements select = doc.select(".city_con li");
//        for (Element element : select) {
//            System.out.println(element.text());
//        }

        //查找直接子元素
//        Elements select = doc.select(".city_con > ul > li");
//        for (Element element : select) {
//            System.out.println(element.text());
//        }

        //查找子元素下的所有
        Elements select = doc.select(".city_con > ul > *");
        for (Element element : select) {
            System.out.println(element.text());
        }

    }
}

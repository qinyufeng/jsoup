package com.qyf.serviceImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
/**
 * 网络爬虫
 * 爬一本小说《天龙八部》转成txt文本文件
 * @author qyf
 * 2018-08-27
 */
public class JsoupHtml {
	public static void main(String[] args) {       
		JsoupHtml jHtml = new JsoupHtml("http://www.jinyongwang.com/tian/");//小说网址
		jHtml.getTianLongBaBu();  
     }
	String srcUrl="";
	public JsoupHtml(String srcurl) {
		this.srcUrl=srcurl;
	}
	/**
	 * 根据网址爬出html并处理得到文字
	 */
	public void getTianLongBaBu() {	
		try {
			String filePath="tianlongbabu.txt";
	        File file = new File(filePath);
	        @SuppressWarnings("resource")
			PrintStream ps = new PrintStream(new FileOutputStream(file));
	        StringBuffer results=new StringBuffer();
			try {
				Document doc = Jsoup.connect(srcUrl).get();
				Elements lis=doc.getElementsByClass("mlist");

				Elements href=null;
				for(Element e:lis) {
					href=e.getElementsByTag("a");
					break;
				}
				for(Element e:href) {
					String linkHref=e.attr("href");
					StringBuffer strs=getChapter("http://www.jinyongwang.com"+linkHref);
					results.append(strs);
					//System.out.println(linkHref);
				}
				ps.print(results);		
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 获取每一章节
	 * @param srcUrl
	 * @return
	 */
	private StringBuffer getChapter(String srcUrl) {
		Document doc;
		StringBuffer result=new StringBuffer();
		try {
			doc = Jsoup.connect(srcUrl).get();
			Elements box=doc.getElementsByTag("p");
			String title=doc.title();
			result.append(title);
			for(Element e:box) {
				String test=e.text();
				StringBuffer sbf=new StringBuffer(test);
				for(int i=80;i<sbf.length();i+=83) {
					sbf.insert(i, "\r\n");
				}
				result.append("    "+sbf+"\r\n");
			}			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return result;
	}
}

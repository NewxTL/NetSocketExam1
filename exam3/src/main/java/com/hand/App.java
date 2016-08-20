package com.hand;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;


public class App 
{
    public static void main( String[] args )
    {
    	new Get().start();
    }
}

class Get extends Thread{
	@Override
	public void run() {
		try {
			
			URL url = new URL("http://hq.sinajs.cn/list=sz300170");
			URLConnection conn = url.openConnection();
			InputStream is = conn.getInputStream();
			InputStreamReader isr = new InputStreamReader(is,"UTF-8");
			BufferedReader br = new BufferedReader(isr);
			
			String line ;
			StringBuilder sb = new StringBuilder();
			while ((line = br.readLine()) != null) {
				sb.append(line);
				
			}
			br.close();
			isr.close();
			is.close();
			
			System.out.println(sb.toString());
			System.out.println("成功从数据接口获取数据");
			System.out.println("该文数据的解释如下：");
			System.out.println("0"+"\"汉得信息\",股票名字；name");
			System.out.println("1"+"\"13.780\",今日开盘价；open");
			System.out.println("2"+"\"13.820\",昨日收盘价；close");
			System.out.println("3"+"\"13.820\",当前价格；current");
			System.out.println("4"+"\"13.920\",今日最高价；high");
			System.out.println("5"+"\"13.770\",今日最低价；low");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
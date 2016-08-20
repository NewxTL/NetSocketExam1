package com.hand;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
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
			
			URL url = new URL("http://files.saas.hand-china.com/java/target.pdf");
			URLConnection conn = url.openConnection();
			InputStream is = conn.getInputStream();
			InputStreamReader isr = new InputStreamReader(is,"UTF-8");
			BufferedReader br = new BufferedReader(isr);
			FileOutputStream fos = new FileOutputStream("target.pdf");
			OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
			PrintWriter pw = new PrintWriter(osw, true);
			
			
			String line ;
			
			while ((line = br.readLine()) != null) {
				pw.println(line);
				
			}
			br.close();
			isr.close();
			is.close();
			pw.close();
			osw.close();
			fos.close();
			
			System.out.println("文件写入成功！我已经指定了编码为UTF-8，但还是乱码，PDF打开不显示内容");
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

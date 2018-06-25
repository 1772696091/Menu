package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.json.JSONObject;

import viewpager.doctor;
import viewpager.huifu;
import viewpager.wenzhang;


import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import android.text.TextUtils;
import android.util.Log;

public class httpconnection {
	private HttpURLConnection myurlcoonection=null;
	private URL url;
	private String result=null;
	public httpconnection(String arg) throws IOException{
		url=new URL(arg);
		myurlcoonection=(HttpURLConnection) url.openConnection();
		myurlcoonection.setConnectTimeout(5000);
		myurlcoonection.setReadTimeout(10000);
		myurlcoonection.setDoInput(true);
        myurlcoonection.setUseCaches(false);
        myurlcoonection.setDoOutput(true);
        myurlcoonection.setRequestProperty("Connection", "Keep-Alive");
        myurlcoonection.setRequestProperty("Charset", "UTF-8");
	}
public String post(String Json){
	try {
		myurlcoonection.setRequestMethod("POST");
		myurlcoonection.setRequestProperty("Content-Type","application/json; charset=UTF-8");
		if (Json!= null) {
            byte[] writebytes = Json.getBytes();
            // 设置文件长度
            myurlcoonection.setRequestProperty("Content-Length", String.valueOf(writebytes.length));
            OutputStream outwritestream = myurlcoonection.getOutputStream();
            outwritestream.write(Json.getBytes());
            outwritestream.flush();
            outwritestream.close();
            if (myurlcoonection.getResponseCode() == 200) {
            	InputStream in=myurlcoonection.getInputStream();
            	BufferedReader reader = new BufferedReader(new InputStreamReader(in));   
                StringBuilder sb = new StringBuilder();   
                String line = null;   
                try {   
                    while ((line = reader.readLine()) != null) {   
                        sb.append(line);   
                    }   
                } catch (IOException e) {   
                    e.printStackTrace();   
                } finally {   
                    try {   
                        in.close();   
                    } catch (IOException e) {   
                        e.printStackTrace();   
                    }   
                }   
                return sb.toString();   
        		
            }else{
   				result="失败";
   			}
        }else{
        	result="失败";
        }
	} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return result;
	
}
public ArrayList<wenzhang> getJson(String Json) throws Exception{
	Log.i("111111111111", "a");
	try {
		myurlcoonection.setRequestMethod("GET");
		myurlcoonection.setRequestProperty("Content-Type","application/json; charset=UTF-8");
		if (Json!= null) {
			Log.i("111111111111", "b");
            byte[] writebytes = Json.getBytes();
            // 设置文件长度
            myurlcoonection.setRequestProperty("Content-Length", String.valueOf(writebytes.length));
            OutputStream outwritestream = myurlcoonection.getOutputStream();
            outwritestream.write(Json.getBytes());
            outwritestream.flush();
            outwritestream.close();
            if (myurlcoonection.getResponseCode() == 200) {
        	InputStream in=myurlcoonection.getInputStream();
        	Log.i("111111111111", "c");
        	return parseJSON(in);
            }
        }
	} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
	}
public ArrayList<doctor> getdoctor(String Json) throws Exception{
	try {
		myurlcoonection.setRequestMethod("POST");
		myurlcoonection.setRequestProperty("Content-Type","application/json; charset=UTF-8");
		if (Json!= null) {
            byte[] writebytes = Json.getBytes();
            // 设置文件长度
            myurlcoonection.setRequestProperty("Content-Length", String.valueOf(writebytes.length));
            OutputStream outwritestream = myurlcoonection.getOutputStream();
            outwritestream.write(Json.getBytes());
            outwritestream.flush();
            outwritestream.close();
            if (myurlcoonection.getResponseCode() == 200) {
        	InputStream in=myurlcoonection.getInputStream();
        	return parsedoctor(in);
            }
        }
	} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
	}
public ArrayList<huifu> getHuifu(String Json) throws Exception{
	try {
		myurlcoonection.setRequestMethod("POST");
		myurlcoonection.setRequestProperty("Content-Type","application/json; charset=UTF-8");
		if (Json!= null) {
            byte[] writebytes = Json.getBytes();
            // 设置文件长度
            myurlcoonection.setRequestProperty("Content-Length", String.valueOf(writebytes.length));
            OutputStream outwritestream = myurlcoonection.getOutputStream();
            outwritestream.write(Json.getBytes());
            outwritestream.flush();
            outwritestream.close();
            if (myurlcoonection.getResponseCode() == 200) {
        	InputStream in=myurlcoonection.getInputStream();
        	return parseHuifu(in);
            }
        }
	} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
	}
public String getzixun(String Json) throws Exception{
	try {
		myurlcoonection.setRequestMethod("POST");
		myurlcoonection.setRequestProperty("Content-Type","application/json; charset=UTF-8");
		if (Json!= null) {
            byte[] writebytes = Json.getBytes();
            // 设置文件长度
            myurlcoonection.setRequestProperty("Content-Length", String.valueOf(writebytes.length));
            OutputStream outwritestream = myurlcoonection.getOutputStream();
            String a="咨询"+Json;
            outwritestream.write(Json.getBytes());
            outwritestream.flush();
            outwritestream.close();
            if (myurlcoonection.getResponseCode() == 200) {
        	InputStream in=myurlcoonection.getInputStream();
        	BufferedReader reader = new BufferedReader(new InputStreamReader(in));   
    	    StringBuilder sb = new StringBuilder();
    		String line=null;
    		 try {   
    	         while ((line = reader.readLine()) != null) {   
    	             sb.append(line);   
    	         }   
    	     } catch (IOException e) {
    	         e.printStackTrace();   
    	     } finally { 
    	         try {   
    	             in.close();   
    	         } catch (IOException e) {   
    	             e.printStackTrace();   
    	         }   
    	     }  return sb.toString(); 
            }
        }
	} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
	}
private static ArrayList<wenzhang> parseJSON(InputStream jsonStream) throws Exception{
	Log.i("111111111111", "d");
		ArrayList<wenzhang> list =new ArrayList<wenzhang>();
		BufferedReader reader = new BufferedReader(new InputStreamReader(jsonStream));   
	    StringBuilder sb = new StringBuilder();
		String line=null;
		 try {   
	         while ((line = reader.readLine()) != null) {   
	             sb.append(line);   
	         }   
	     } catch (IOException e) {   
	         e.printStackTrace();   
	     } finally {   
	         try {   
	             jsonStream.close();   
	         } catch (IOException e) {   
	             e.printStackTrace();   
	         }   
	     } 
		 JsonObject job=new JsonParser().parse(sb.toString()).getAsJsonObject();
		 JsonArray jay=job.getAsJsonArray("jsona");
		Gson gson=new Gson();
		for(JsonElement obj : jay ){
		    wenzhang wz = gson.fromJson( obj , wenzhang.class);
		    list.add(wz);
		}
    return list;
	}
private static ArrayList<doctor> parsedoctor(InputStream jsonStream) throws Exception{
	ArrayList<doctor> list =new ArrayList<doctor>();
	BufferedReader reader = new BufferedReader(new InputStreamReader(jsonStream));   
    StringBuilder sb = new StringBuilder();
	String line=null;
	 try {   
         while ((line = reader.readLine()) != null) {   
             sb.append(line);   
         }   
     } catch (IOException e) {   
         e.printStackTrace();   
     } finally {   
         try {   
             jsonStream.close();   
         } catch (IOException e) {   
             e.printStackTrace();   
         }   
     }   
	 	JsonObject job=new JsonParser().parse(sb.toString()).getAsJsonObject();
	 	JsonArray jarray=job.getAsJsonArray("jsona");
	 	Gson gson=new Gson();
		for(JsonElement obj : jarray ){
		    doctor doc = gson.fromJson( obj , doctor.class);
		    list.add(doc);
		}
    return list;
	}
private static ArrayList<huifu> parseHuifu(InputStream jsonStream) throws Exception{
	ArrayList<huifu> list =new ArrayList<huifu>();
	BufferedReader reader = new BufferedReader(new InputStreamReader(jsonStream));   
    StringBuilder sb = new StringBuilder();
	String line=null;
	 try {   
         while ((line = reader.readLine()) != null) {   
             sb.append(line);   
         }   
     } catch (IOException e) {   
         e.printStackTrace();   
     } finally {   
         try {   
             jsonStream.close();   
         } catch (IOException e) {   
             e.printStackTrace();   
         }   
     }   
	 Log.i("asd", sb.toString());
	 	JsonObject job=new JsonParser().parse(sb.toString()).getAsJsonObject();
	 	JsonArray jay=job.getAsJsonArray("jsona");
	 	Gson gson=new Gson();
		for(JsonElement obj : jay ){
		    huifu huifu = gson.fromJson( obj ,huifu.class);
		    list.add(huifu);
		}
    return list;
	}
}

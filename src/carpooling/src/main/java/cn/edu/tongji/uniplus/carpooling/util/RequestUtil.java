package cn.edu.tongji.uniplus.carpooling.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author tangshuo
 * @version 1.0.0
 * @ClassName RequestUtil.java
 * @Description TODO
 * @createTime 2021年12月29日 17:39:00
 */
public class RequestUtil {
    private static final String APP_KEY = "cc0b4637976cccd5cb54c95758007141";//网易云信分配的账号
    private static final String APP_SECRET = "099c4e10f454";//网易云信分配的密钥
    private static final String NONCE = "123456";//随机数

    public static void main(String[] args) throws Exception {
        // 创建云信id
        createAccid("https://api.netease.im/nimserver/user/create.action", "034", "测试");
        // 发送普通消息
        // sendMessage("https://api.netease.im/nimserver/msg/sendMsg.action","liuxuanlin","0","lin","0","{\"msg\":\"测试测试\"}",null,"","","");
        // 批量发送消息
        // sendBatchMessage("https://api.netease.im/nimserver/msg/sendBatchMsg.action","liuxuanlin","['lin']","0","{\"msg\":\"测试测试\"}",null,"","","");
    }

    /**
     * @throws
     * @title 生成用户对应ID，保存在
     * @description
     * @author tangshuo
     * @update_author
     * @updateTime 2021/12/29 5:45 下午
     */
    public static String createAccid(String url, String accid, String name) throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost post = new HttpPost(url);
        String curTime = String.valueOf((new Date().getTime() / 1000L));
        String checkSum = CheckSumBuilder.getCheckSum(APP_SECRET, NONCE, curTime);
        //设置请求的header
        post.addHeader("AppKey", APP_KEY);
        post.addHeader("Nonce", NONCE);
        post.addHeader("CurTime", curTime);
        post.addHeader("CheckSum", checkSum);
        post.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
        //设置请求参数
        List<NameValuePair> nameValuePairs = new ArrayList<>();
        nameValuePairs.add(new BasicNameValuePair("accid", accid));
        nameValuePairs.add(new BasicNameValuePair("name", name));
        post.setEntity(new UrlEncodedFormEntity(nameValuePairs, "utf-8"));

        //执行请求
        HttpResponse response = httpclient.execute(post);
        // 执行请求
        JSONObject object = JSONObject.parseObject(EntityUtils.toString(response.getEntity()));
        JSONObject info = object.getJSONObject("info");
        String token = info.getString("token");
        System.out.println(token);
        return token;
    }

    public static void sendMessage(String url, String from, String ope, String to, String type, String body, String option, String pushcontent, String payload, String ext) throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost post = new HttpPost(url);
        String curTime = String.valueOf((new Date().getTime() / 1000L));
        String checkSum = CheckSumBuilder.getCheckSum(APP_SECRET, NONCE, curTime);
        //设置请求的header
        post.addHeader("AppKey", APP_KEY);
        post.addHeader("Nonce", NONCE);
        post.addHeader("CurTime", curTime);
        post.addHeader("CheckSum", checkSum);
        post.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
        //设置请求参数
        List<NameValuePair> nameValuePairs = new ArrayList<>();
        nameValuePairs.add(new BasicNameValuePair("from", from));
        nameValuePairs.add(new BasicNameValuePair("ope", ope));
        nameValuePairs.add(new BasicNameValuePair("to", to));
        nameValuePairs.add(new BasicNameValuePair("type", type));
        nameValuePairs.add(new BasicNameValuePair("body", body));
        nameValuePairs.add(new BasicNameValuePair("option", option));
        nameValuePairs.add(new BasicNameValuePair("pushcontent", pushcontent));
        nameValuePairs.add(new BasicNameValuePair("payload", payload));
        nameValuePairs.add(new BasicNameValuePair("ext", ext));
        post.setEntity(new UrlEncodedFormEntity(nameValuePairs, "utf-8"));

        //执行请求
        HttpResponse response = httpclient.execute(post);
        // 提取Token


    }

    public static void sendBatchMessage(String url, String fromAccid, String toAccids, String type, String body, String option, String pushcontent, String payload, String ext) throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost post = new HttpPost(url);
        String curTime = String.valueOf((new Date().getTime() / 1000L));
        String checkSum = CheckSumBuilder.getCheckSum(APP_SECRET, NONCE, curTime);
        //设置请求的header
        post.addHeader("AppKey", APP_KEY);
        post.addHeader("Nonce", NONCE);
        post.addHeader("CurTime", curTime);
        post.addHeader("CheckSum", checkSum);
        post.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
        //设置请求参数
        List<NameValuePair> nameValuePairs = new ArrayList<>();
        nameValuePairs.add(new BasicNameValuePair("fromAccid", fromAccid));
        nameValuePairs.add(new BasicNameValuePair("toAccids", toAccids));
        nameValuePairs.add(new BasicNameValuePair("type", type));
        nameValuePairs.add(new BasicNameValuePair("body", body));
        nameValuePairs.add(new BasicNameValuePair("option", option));
        nameValuePairs.add(new BasicNameValuePair("pushcontent", pushcontent));
        nameValuePairs.add(new BasicNameValuePair("payload", payload));
        nameValuePairs.add(new BasicNameValuePair("ext", ext));
        post.setEntity(new UrlEncodedFormEntity(nameValuePairs, "utf-8"));

        //执行请求
        HttpResponse response = httpclient.execute(post);
        // 执行请求
        System.out.println(EntityUtils.toString(response.getEntity(), "utf-8") + "\n");
    }

}

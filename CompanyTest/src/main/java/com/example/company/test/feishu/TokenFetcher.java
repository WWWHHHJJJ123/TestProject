package com.example.company.test.feishu;


import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author CiZhong
 * @since 2025/11/20 15:22
 */
public class TokenFetcher {
    public static void main(String[] args) throws Exception {
        // 1. 创建 HTTP 客户端
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            // 2. 构造请求参数（放在请求体中）
            Map<String, String> params = new HashMap<>();
            params.put("grant_type", "authorization_code");
            params.put("client_id", "cli_a997e0ec9fe9d013");
            params.put("client_secret", "m24I5OJIWvPl5OVn5tCTmfXadvePJegf");
            params.put("code", "手动获取的code");
            params.put("redirect_uri", "https://ehr-micro.qunhequnhe.com"); // 与授权链接中的一致
            // 3. 创建 POST 请求
            HttpPost httpPost = new HttpPost("https://open.feishu.cn/open-apis/authen/v2/oauth/token");
            httpPost.setEntity(new StringEntity(
                    new Gson().toJson(params),
                    ContentType.APPLICATION_JSON // 指定 JSON 格式
            ));
            // 4. 发送请求并获取响应
            try (CloseableHttpResponse response = httpClient.execute(httpPost)) {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    String responseBody = EntityUtils.toString(entity);
                    System.out.println("响应内容: " + responseBody);
                    // 解析响应获取 user_access_token
                    Map<String, Object> result = new Gson().fromJson(responseBody, Map.class);
                    String userAccessToken = result.get("access_token").toString();
                    System.out.println("user_access_token: " + userAccessToken);
                }
            }
        }
    }
}
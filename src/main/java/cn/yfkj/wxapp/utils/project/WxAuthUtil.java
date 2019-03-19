package cn.yfkj.wxapp.utils.project;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @author maochangan
 * 微信公众号工具
 */
public class WxAuthUtil {


    public static final String APP_ID = "wxb622a8ee83cd186e";

    public static final String APPSECRET = "280ca023bf9ba48fc85695ca5e8f88aa";

    public static final String TOKEN = "UEHFANV3OJFU6FW";

    public static final Integer ZERO = 0;

    public static JSONObject doGet(String url) throws IOException {
        JSONObject jsonObject = null;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response = httpClient.execute(httpGet);
        HttpEntity entity = response.getEntity();
        if (null != entity) {
            String result = EntityUtils.toString(entity, "UTF-8");
            jsonObject = JSONObject.parseObject(result);
        }
        return jsonObject;
    }


}

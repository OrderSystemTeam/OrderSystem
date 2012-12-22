package cn.com.voyagegroup.ordersystem.web;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

import android.util.Log;
import cn.com.voyagegroup.ordersystem.utils.CommonUtil;
import cn.com.voyagegroup.ordersystem.utils.Constants;

public class BaseService {
    private static final String TAG = "BaseService";

    protected String postData(String url, Object object) {
        HttpPost httpPost = new HttpPost(url);
        HttpClient httpClient = new DefaultHttpClient();
        HttpParams httpParams = httpClient.getParams();
        httpParams.setParameter(Constants.HTTP_PARAM_KEY, CommonUtil.parseToJson(object));
        try {
            HttpResponse httpResponse = httpClient.execute(httpPost);
            return EntityUtils.toString(httpResponse.getEntity()).trim();
        } catch (ClientProtocolException e) {
            Log.e(TAG, "postData : ClientProtocolException is " + e.getLocalizedMessage());
        } catch (IOException e) {
            Log.e(TAG, "postData : IOException is " + e.getLocalizedMessage());
        }
        return null;
    }
}

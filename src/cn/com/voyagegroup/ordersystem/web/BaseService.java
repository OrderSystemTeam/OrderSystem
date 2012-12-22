package cn.com.voyagegroup.ordersystem.web;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpParams;

import android.util.Log;
import cn.com.voyagegroup.ordersystem.utils.CommonUtil;
import cn.com.voyagegroup.ordersystem.utils.Constants;

public class BaseService {
    private static final String TAG = "BaseService";

    protected String executeUrl(String urlString, Object object) {
        URL url;
        InputStream is = null;
        DataInputStream dis;
        StringBuilder sb = new StringBuilder();
        if (object != null) {
            urlString = urlString + "?" + Constants.HTTP_PARAM_KEY + CommonUtil.parseToJson(object);
        }
        try {
            String line;
            url = new URL(urlString);
            is = url.openStream();
            dis = new DataInputStream(new BufferedInputStream(is));
            while ((line = dis.readLine()) != null) {
                sb.append(line);
            }
        } catch (MalformedURLException e) {
            Log.e(TAG, "executeUrl : MalformedURLException is " + e.getLocalizedMessage());
        } catch (IOException e) {
            Log.e(TAG, "executeUrl : IOException is " + e.getLocalizedMessage());
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                Log.e(TAG, "executeUrl : IOException is " + e.getLocalizedMessage());
            }
        }
        return sb.toString();
    }

    protected boolean postData(String url, Object object) {
        HttpPost httpGet = new HttpPost(url);
        HttpClient httpClient = new DefaultHttpClient();
        HttpParams httpParams = httpClient.getParams();
        httpParams.setParameter(Constants.HTTP_PARAM_KEY, CommonUtil.parseToJson(object));
        try {
            HttpResponse httpResponse = httpClient.execute(httpGet);
            if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                return true;
            }
        } catch (ClientProtocolException e) {
            Log.e(TAG, "postData : ClientProtocolException is " + e.getLocalizedMessage());
        } catch (IOException e) {
            Log.e(TAG, "postData : IOException is " + e.getLocalizedMessage());
        }
        return false;
    }

}

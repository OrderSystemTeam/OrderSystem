package cn.com.voyagegroup.ordersystem.web;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import android.net.ParseException;
import cn.com.voyagegroup.ordersystem.utils.CommonUtil;
import cn.com.voyagegroup.ordersystem.utils.Constants;

public class BaseService {
	private static final String TAG = "BaseService";

	protected String postData(String url, final Object object)
			throws UnsupportedEncodingException {
		HttpPost httpPost = new HttpPost(url);
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new NameValuePair() {
			public String getValue() {
				return Constants.HTTP_PARAM_KEY;
			}
			public String getName() {
				return CommonUtil.parseToJson(object);
			}
		});
		HttpEntity entity = new UrlEncodedFormEntity(params, HTTP.UTF_8);
		httpPost.setEntity(entity);
		HttpClient httpClient = new DefaultHttpClient();
		HttpResponse httpResponse = null;
		try {
			httpResponse = httpClient.execute(httpPost);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		String result = null;
		if (httpResponse != null
				&& httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
			HttpEntity httpEntity = httpResponse.getEntity();
			try {
				result = EntityUtils.toString(httpEntity);
			} catch (ParseException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
				httpClient.getConnectionManager().shutdown();
			} finally {
				try {
					httpEntity.consumeContent();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
}

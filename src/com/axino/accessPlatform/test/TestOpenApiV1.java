package com.axino.accessPlatform.test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.stream.events.StartDocument;

import com.axino.accessPlatform.bean.PrivateData;
import com.axino.accessPlatform.bean.PublicData;
import com.axino.accessPlatform.bean.RequestMode;
import com.axino.accessPlatform.exception.OpensnsException;
import com.axino.accessPlatform.service.OpenApiV1;
import com.axino.accessPlatform.util.SecurityUtil;
import com.axino.accessPlatform.util.StateData;
import com.axino.accessPlatform.util.ValidataUtil;

/**
 * 测试示例
 * 
 * @author sdk.jss.com.cn
 * @version 2.0
 * @since jdk1.6
 */
public class TestOpenApiV1 {
	private static String shuihao = StateData.user_Tax;
	private static final String[] TAXNUM = { "taxnum","taxNum"};
	private static String INVOICETIMESTART ="invoiceTimeStart";
	private static String INVOICETIMEEND = "invoiceTimeEnd";
	private static String start = "2018-01-01 00:00:00";
	private static String end = "2019-05-01 23:59:59";
	public static void main(String[] args) {

		// 定义请求头数据
		// 定义请求体中的公共数据
		// 定义请求体中的业务数据 PrivateData<Object>
		// 生成6位不重复的随机数字
		// api版本
		Map<String, String> headers = getHeaders(); 
		//公共请求参数消息体
		PublicData pdData = getPublicData(); 
		
		PrivateData<Object> pvData = getPvData();
		RequestMode requestMode = getRequestMode(pdData, pvData);
		OpenApiV1 sdk = new OpenApiV1();
		String result = "";
		try { 
			result = sdk.handle(StateData.url, headers, requestMode);
			if (!ValidataUtil.isEmpty(result)) {
				System.out.println("服务端的响应：" + result);
			}
		} catch (OpensnsException e) {
			System.out.printf("Request failed 【" + e.getErrorCode() + ":" + e.getMessage() + "】");
			e.printStackTrace();
		}

		//mytest();
	}

	private static PrivateData<Object> getPvData() {
		
		new PrivateData<Object>();
		PrivateData<Object> pvData = new PrivateData<Object>();
		
		//私有请求参数消息体
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(TAXNUM[0], StateData.taxNum);
		map.put(INVOICETIMESTART,start);
		map.put(INVOICETIMEEND, end);
		list.add(map);
		pvData.setServicedata(list);
		return pvData;
	}
	private static PrivateData<Object> getPvData1() {
		
		new PrivateData<Object>();
		PrivateData<Object> pvData = new PrivateData<Object>();
		
		//私有请求参数消息体
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();      
		List<Map<String,Object>> list_invoiceDetail = new ArrayList<Map<String,Object>>();      
		Map<String,Object> map_s = new HashMap<String,Object>();       
		Map<String,Object> map_order = new HashMap<String,Object>();      
		Map<String,Object> map_invoiceDetails = new HashMap<String,Object>();      
		  map_order.put("pushMode", "1");      
		  map_order.put("buyerName", "个人");    
		  map_order.put("buyerTaxNum", "110101TRDX8RQU1");    
		  map_order.put("buyerPhone", "17098074113");    
		  map_order.put("buyerAddress", "333");    
		  map_order.put("buyerAccount", "333");    
		  map_order.put("orderNo", System.currentTimeMillis() + "001");    
		  map_order.put("invoiceDate", "2016-06-15 01:59:41");    
		  map_order.put("clerk", "袁牧庆");    
		  map_order.put("salerAccount", "东亚银行杭州分行131001088303400");    
		  map_order.put("salerTel", "0571-87022168");    
		  map_order.put("salerAddress", "杭州市中河中路222号平海国际商务大厦5楼");    
		  map_order.put("salerTaxNum", "339901999999142");    
		  map_order.put("invoiceType", "1");    
		  map_order.put("remark", "开票机号为02 请前往诺诺网(www.jss.com.cn)查询发票详情");    
		  map_order.put("payee", "络克");    
		  map_order.put("checker", "朱燕");    
		  map_order.put("invoiceCode", "11");    
		  map_order.put("invoiceNum", "11");    
		  map_order.put("pushMode", "1");    
		  map_order.put("email", "122@qq.com");    
		  map_order.put("listFlag", "0");    
		  map_order.put("listName", "1111");    
		  map_order.put("buyerTel", "0571-88888888");    
		  map_order.put("proxyInvoiceFlag", "0");    
		  map_order.put("departmentId", "23456790");    
		  map_order.put("clerkId", "");    
		  map_invoiceDetails.put("goodsName", "1");    
		  map_invoiceDetails.put("num", "1");    
		  map_invoiceDetails.put("withTaxFlag", "1");    
		  map_invoiceDetails.put("price", "46.79");    
		  map_invoiceDetails.put("taxRate", "0.16");    
		  map_invoiceDetails.put("specType", "1");    
		  map_invoiceDetails.put("unit", "1");    
		  map_invoiceDetails.put("goodsCode", "1090511030000000000");    
		  map_invoiceDetails.put("selfCode", null);    
		  map_invoiceDetails.put("invoiceLineProperty", "0");    
		  map_invoiceDetails.put("favouredPolicyFlag", "0");    
		  map_invoiceDetails.put("favouredPolicyName", null);    
		  map_invoiceDetails.put("zeroRateFlag", null);    
		  map_invoiceDetails.put("deduction", null);    
		  map_invoiceDetails.put("tax", "6.45");    
		  map_invoiceDetails.put("taxIncludedAmount", "46.79");    
		  map_invoiceDetails.put("taxExcludedAmount", "40.34");    
		  list_invoiceDetail.add(map_invoiceDetails);    
		  map_order.put("invoiceDetail", list_invoiceDetail);    
		  map_order.put("invoiceLine", "p");    
		  map_order.put("productOilFlag", "0");  
		  map_s.put("order", map_order);    
		  list.add(map_s);      
		pvData.setServicedata(list);
		return pvData;
	}

	// 定义请求头数据
	private static Map<String, String> getHeaders() {
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("userTax", StateData.user_Tax); // ISV下商家需要填写当前商户税号，普通商家模式用户可以不填写此值
		headers.put("compress", StateData.app_compressType);// 压缩方式：提供GZIP 置空“”不压缩
		headers.put("appKey", StateData.app_key); // 用户申请的appkey
		headers.put("appRate", StateData.app_rate); // app并发请求数 ，平台默认10如需升级请联系开放平台
		headers.put("dataType", StateData.app_dataType); // 数据请求格式： JSON/XML
		headers.put("signMethod", StateData.app_signType); // 加密方式：提供AES/AES，不可为空
		headers.put("accessToken", StateData.app_accessToken); // 用户Oauth登录后得到的令牌accessToken
		headers.put("Content-Type", StateData.contentType); // http发送模式
		
		return headers;
	}

	// 定义请求体中的公共数据
	private static PublicData getPublicData() {
		PublicData pdData = new PublicData();
		pdData.setVersion(StateData.app_apiVersion); // API版本
		pdData.setTimestamp(String.valueOf(System.currentTimeMillis()));
		pdData.setMethod(StateData.API_METHOD[8]);// API名称
		return pdData;
	}

	private static RequestMode getRequestMode(PublicData pdata, PrivateData<Object> pvData) {
		RequestMode requestMode = new RequestMode();
		requestMode.setPrivate(pvData);
		requestMode.setPublic(pdata);
		return requestMode;
	}

	public static void mytest() {
		// 定义请求头数据
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("appKey", "i3DD5GRf");
		headers.put("accessToken", "529397f243ddbe6f7ac53c01c1191d94");// 通过Oauth获取的令牌
		headers.put("compress", "GZIP");// 压缩方式,例：GZIP;当请求数据需要压缩时,compress值设置GZIP,同时数据在URLEncoder编码后调用压缩方法
		headers.put("signMethod", "AES");// 加密方式
		headers.put("dataType", "JSON");// 数据类型
		headers.put("appRate", StateData.app_rate);// 平台默认10次/秒
		
		
		headers.put("userTax", StateData.user_Tax); // ISV下商家需要填写当前商户税号，普通商家模式用户可以不填写此值
		headers.put("Content-Type", StateData.contentType); // http发送模式
		// 定义请求体中的公共数据
		
		
		PublicData pdData = new PublicData();
		pdData.setVersion("1.0"); // api版本
		pdData.setTimestamp(String.valueOf(System.currentTimeMillis()));
		pdData.setMethod("nuonuo.einvoice.createreq1"); // API名称
		// 定义请求体中的业务数据
		PrivateData<Object> pvData = new PrivateData<Object>();
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		Map<String, String> map = new HashMap<String, String>();
		map.put("signid", "6772af8821cb259bd9f30e175e903321");
		map.put("shuihao", "330681687889191");
		map.put("validator", "123456");
		list.add(map);
		pvData.setServicedata(list);
		RequestMode requestMode = new RequestMode();
		requestMode.setPrivate(pvData);
		requestMode.setPublic(pdData);
		OpenApiV1 sdk = new OpenApiV1();
		// 设置请求接口的url
		// sdk.setServerName(StateData.url);
		String result = "";
		try {
			// 调用服务
			result = sdk.handle(StateData.url, headers, requestMode);
			if (!ValidataUtil.isEmpty(result)) {
				System.out.println("服务端的响应：" + URLDecoder.decode(result, "UTF-8"));
			}
		} catch (OpensnsException e) {
			System.out.printf("Request failed [" + e.getErrorCode() + ":" + e.getMessage() + "]");
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

}

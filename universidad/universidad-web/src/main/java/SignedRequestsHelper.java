import java.io.UnsupportedEncodingException;

import java.net.URLDecoder;
import java.net.URLEncoder;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.SortedMap;
import java.util.TimeZone;
import java.util.TreeMap;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class SignedRequestsHelper {
	private static final String UTF8_CHARSET = "UTF-8";
	private static final String HMAC_SHA256_ALGORITHM = "HmacSHA256";
	private static final String REQUEST_URI = "/onca/xml";
	private static final String REQUEST_METHOD = "GET";

	private String endpoint = "webservices.amazon.com"; // must be lowercase
	private String awsAccessKeyId = "AKIAJ3D74NAIO57LJRNA";
	private String awsSecretKey = "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";

	private SecretKeySpec secretKeySpec = null;
	private Mac mac = null;

	public SignedRequestsHelper() throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException {
		byte[] secretyKeyBytes = awsSecretKey.getBytes(UTF8_CHARSET);
		secretKeySpec = new SecretKeySpec(secretyKeyBytes, HMAC_SHA256_ALGORITHM);
		mac = Mac.getInstance(HMAC_SHA256_ALGORITHM);
		mac.init(secretKeySpec);
	}

	public String sign(Map<String, String> params) {
		params.put("AWSAccessKeyId", awsAccessKeyId);
		params.put("Timestamp", timestamp());

		SortedMap<String, String> sortedParamMap = new TreeMap<String, String>(params);
		String canonicalQS = canonicalize(sortedParamMap);
		String toSign = REQUEST_METHOD + "\n" + endpoint + "\n" + REQUEST_URI + "\n" + canonicalQS;
		System.err.println("TO SIGN:"+toSign);
		String hmac = hmac(toSign);
		String sig = percentEncodeRfc3986(hmac);
		String url = "http://" + endpoint + REQUEST_URI + "?" + canonicalQS+"" + "&Signature=" + sig;

		return url;
	}

	private String hmac(String stringToSign) {
		String signature = null;
		byte[] data;
		byte[] rawHmac;
		try {
			data = stringToSign.getBytes(UTF8_CHARSET);
			rawHmac = mac.doFinal(data);
			signature = new String(java.util.Base64.getEncoder().encode(rawHmac));
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(UTF8_CHARSET + " is unsupported!", e);
		}
		return signature;
	}

	private String timestamp() {
		String timestamp = null;
		Calendar cal = Calendar.getInstance();
		DateFormat dfm = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
		dfm.setTimeZone(TimeZone.getTimeZone("GMT"));
		timestamp = dfm.format(cal.getTime());
		return timestamp;
	}

	private String canonicalize(SortedMap<String, String> sortedParamMap) {
		if (sortedParamMap.isEmpty()) {
			return "";
		}

		StringBuffer buffer = new StringBuffer();
		Iterator<Map.Entry<String, String>> iter = sortedParamMap.entrySet().iterator();

		while (iter.hasNext()) {
			Map.Entry<String, String> kvpair = iter.next();
			buffer.append(percentEncodeRfc3986(kvpair.getKey()));
			buffer.append("=");
			buffer.append(percentEncodeRfc3986(kvpair.getValue()));
			if (iter.hasNext()) {
				buffer.append("&");
			}
		}
		String canonical = buffer.toString();
		System.err.println("CANONICAL:"+canonical);
		return canonical;
	}

	private String percentEncodeRfc3986(String s) {
		String out;
		try {
			out = URLEncoder.encode(s, UTF8_CHARSET).replace("+", "%20").replace("*", "%2A").replace("%7E", "~");
		} catch (UnsupportedEncodingException e) {
			out = s;
		}
		return out;
	}
	
	public static void main(String[] args) throws InvalidKeyException, UnsupportedEncodingException, NoSuchAlgorithmException {
		SignedRequestsHelper signer=new SignedRequestsHelper();
		Map<String, String> params=new HashMap<String, String>();
		params.put("AssociateTag", "cloudeam-21");
		params.put("Operation", "ItemSearch");
		params.put("Keywords", "lego");
		params.put("ResponseGroup", "Images,ItemAttributes");		
		params.put("SearchIndex", "All+");
		params.put("ItemPage", "4");
		System.out.println(signer.sign(params));
		
		
		params=new HashMap<String, String>();
		params.put("AssociateTag", "cloudeam-21");
		params.put("Operation", "ItemLookup");
		params.put("ItemId", "B01NGTXADX");
		params.put("ResponseGroup", "Images,ItemAttributes");		

		params.put("IdType", "ASIN");
		System.out.println(signer.sign(params));
		
		System.out.println(signer.hmac("ItemSearch2017-01-28T20:23:00Z"));
		
		
		
	}

}

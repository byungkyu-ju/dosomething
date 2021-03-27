package me.bk.tinyurl.tinyUrl.application;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import org.springframework.stereotype.Service;

import me.bk.tinyurl.tinyUrl.dto.CreateTinyUrlResponse;

/**
 * @author : byungkyu
 * @date : 2021/03/24
 * @description :
 **/
@Service
public class TinyUrlService {
	public static final String UTF_8 = "UTF-8";

	public CreateTinyUrlResponse createTinyUrl(String url) {
		String encodedActualUrl = encodeActualUrl(url);
		return CreateTinyUrlResponse.of(encodedActualUrl);
	}

	private String decodeActualUrl(String encodedActualUrl) {
		try {
			Base64.Decoder base64Decoder = Base64.getDecoder();
			byte[] decodeByte = base64Decoder.decode(encodedActualUrl);
			String decodedString = new String(decodeByte);
			return URLDecoder.decode(decodedString, UTF_8);
		} catch (UnsupportedEncodingException e) {
			throw new IllegalArgumentException("cannot decode url");
		}
	}

	private String encodeActualUrl(String url) {
		try {
			String encodedUrl = URLEncoder.encode(url, UTF_8);
			Base64.Encoder base64Encoder = Base64.getEncoder();
			return base64Encoder.encodeToString(encodedUrl.getBytes(StandardCharsets.UTF_8));
		} catch (UnsupportedEncodingException e) {
			throw new IllegalArgumentException("cannot encode url");
		}
	}
}

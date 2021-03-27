package me.bk.tinyurl.tinyUrl;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import me.bk.tinyurl.AcceptanceTest;
import me.bk.tinyurl.tinyUrl.dto.CreateTinyUrlResponse;

/**
 * @author : byungkyu
 * @date : 2021/03/23
 * @description :
 **/

@DisplayName("TinyURL 인수 테스트")
public class TinyUrlAcceptanceTest extends AcceptanceTest {

	public static final String LONG_URL = "https://medium.com/byungkyu-ju";

	@DisplayName("TinyURL을 생성한다.")
	@Test
	void createTinyUrl(){
		// when
		ExtractableResponse<Response> response = 짧은_URL_생성(LONG_URL);
		// then
		짧은_URL_생성됨(response);
	}

	private void 짧은_URL_생성됨(ExtractableResponse<Response> response) {
		assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
		String tinyUrl = response.jsonPath().getObject(".", CreateTinyUrlResponse.class).getTinyUrl();
		assertThat(tinyUrl).isNotEmpty();
		assertThat(tinyUrl).isNotBlank();
	}

	private ExtractableResponse<Response> 짧은_URL_생성(String longUrl) {
		return RestAssured
			.given().log().all()
			.accept(MediaType.APPLICATION_JSON_VALUE)
			.when().get("/tinyUrl?url=" + longUrl)
			.then().log().all()
			.extract();
	}
}

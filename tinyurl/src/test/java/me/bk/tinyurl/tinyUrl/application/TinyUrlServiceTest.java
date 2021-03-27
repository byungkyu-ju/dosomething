package me.bk.tinyurl.tinyUrl.application;

import static me.bk.tinyurl.tinyUrl.TinyUrlAcceptanceTest.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import me.bk.tinyurl.tinyUrl.dto.CreateTinyUrlResponse;

/**
 * @author : byungkyu
 * @date : 2021/03/24
 * @description :
 **/
class TinyUrlServiceTest {

	@Test
	void createTinyUrl() {
		//given
		TinyUrlService tinyUrlService = new TinyUrlService();
		CreateTinyUrlResponse response = tinyUrlService.createTinyUrl(LONG_URL);

		assertThat(response.getTinyUrl()).isNotEmpty();
		assertThat(response.getTinyUrl()).isNotBlank();

	}
}
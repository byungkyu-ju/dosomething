package me.bk.tinyurl.tinyUrl.ui;

import static me.bk.tinyurl.tinyUrl.TinyUrlAcceptanceTest.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import me.bk.tinyurl.tinyUrl.application.TinyUrlService;

/**
 * @author : byungkyu
 * @date : 2021/03/24
 * @description :
 **/
public class TinyUrlControllerTest {

	@Mock
	private TinyUrlService tinyUrlService;

	@Test
	void createTinyUrl() {
		tinyUrlService = new TinyUrlService();

		// given
		TinyUrlController tinyUrlController = new TinyUrlController(tinyUrlService);

		// when
		ResponseEntity response = tinyUrlController.createTinyUrl(LONG_URL);

		//then
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

	}
}

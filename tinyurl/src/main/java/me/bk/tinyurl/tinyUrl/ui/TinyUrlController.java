package me.bk.tinyurl.tinyUrl.ui;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import me.bk.tinyurl.common.dto.CommonApiLinkResponse;
import me.bk.tinyurl.tinyUrl.application.TinyUrlService;
import me.bk.tinyurl.tinyUrl.dto.CreateTinyUrlResponse;

/**
 * @author : byungkyu
 * @date : 2021/03/24
 * @description :
 **/
@RestController
@RequiredArgsConstructor
public class TinyUrlController {

	private final TinyUrlService tinyUrlService;

	@GetMapping("/tinyUrl")
	public ResponseEntity createTinyUrl(@RequestParam(name = "url") String url) {
		CreateTinyUrlResponse tinyUrlResponse = tinyUrlService.createTinyUrl(url);

		CommonApiLinkResponse selfResponse = CommonApiLinkResponse.
			linkBuilder(linkTo(methodOn(TinyUrlController.class).createTinyUrl(url)).withSelfRel()
				.withType(HttpMethod.GET.name()));
		tinyUrlResponse.addLink(selfResponse);
		return ResponseEntity.ok(tinyUrlResponse);
	}
}

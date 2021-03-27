package me.bk.tinyurl.tinyUrl.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.bk.tinyurl.common.dto.CommonApiResponse;

/**
 * @author : byungkyu
 * @date : 2021/03/23
 * @description :
 **/
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CreateTinyUrlResponse extends CommonApiResponse {
	private String tinyUrl;

	public static CreateTinyUrlResponse of(String encodedActualUrl) {
		return new CreateTinyUrlResponse(encodedActualUrl);
	}
}

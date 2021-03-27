package me.bk.tinyurl.common.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Builder;
import lombok.Getter;

/**
 * @author : byungkyu
 * @date : 2021/03/27
 * @description :
 **/
@Builder
@Getter
public class CommonApiResponse {
	private List<CommonApiLinkResponse> links;

	public CommonApiResponse() {
		links = new ArrayList<>();
	}

	public CommonApiResponse(List<CommonApiLinkResponse> links) {
		this.links = new ArrayList<>();
		if (!links.isEmpty()) {
			this.links = links;
		}
	}

	public void addLink(CommonApiLinkResponse linkResponse) {
		links.add(linkResponse);
	}
}

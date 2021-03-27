package me.bk.tinyurl.common.dto;

import javax.validation.constraints.NotNull;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.LinkRelation;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author : byungkyu
 * @date : 2021/03/27
 * @description :
 **/
@Getter
@NoArgsConstructor
public class CommonApiLinkResponse {
	@NotNull
	private String href;
	@NotNull
	private LinkRelation rel;
	@NotNull
	private String type;

	@Builder(builderMethodName = "linkBuilder")
	public static CommonApiLinkResponse linkBuilder(Link link) {
		return new CommonApiLinkResponse(link.getHref(), link.getRel(), link.getType());
	}

	public CommonApiLinkResponse(String href, LinkRelation rel, String type) {
		this.href = href;
		this.rel = rel;
		this.type = type;
	}

}

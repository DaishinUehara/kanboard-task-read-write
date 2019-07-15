package uehara.daishin.kanboard.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class KanboardVersion {
	@JsonProperty("jsonrpc")
	private String jsonrpc;

	@JsonProperty("id")
	private Integer id;

	@JsonProperty("result")
	private String result;
}

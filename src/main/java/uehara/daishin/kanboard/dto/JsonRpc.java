package uehara.daishin.kanboard.dto;


import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class JsonRpc {
	@JsonProperty("jsonrpc")
	public String jsonrpc;

	@JsonProperty("method")
	public String method;

	@JsonProperty("id")
	public long id;
}

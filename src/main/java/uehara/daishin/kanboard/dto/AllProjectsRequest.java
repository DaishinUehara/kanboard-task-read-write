package uehara.daishin.kanboard.dto;

public class AllProjectsRequest {
	public String jsonrpc;
	public String method;
	public long id;

	public AllProjectsRequest(){
		this.jsonrpc="2.0";
		this.method="getAllProjects";
		this.id=1;
	}
}

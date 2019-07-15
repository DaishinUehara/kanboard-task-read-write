package uehara.daishin.kanboard;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.Base64;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import uehara.daishin.kanboard.dto.JsonRpc;
import uehara.daishin.kanboard.dto.KanboardVersion;

public class TaskReadWrite {

	public static DataFormatter formatter;
	public static String kbApiToken;
	public static String kbUrl;
	public static String kbUser;
	public static String kbUserToken;

	public static void main(String[] args) {
		if (1 != args.length){
			System.err.println("taskrw ExcelFileName");
			System.exit(1);
		}
		kbUrl = System.getenv("KB_URL");
		if ( null == kbUrl ) {
			System.err.println("Set Kanboard API Endpoint URL to System Environment KB_URL.");
			System.exit(1);
		}
		kbApiToken = System.getenv("KB_API_TOKEN");
		if ( null == kbApiToken ) {
			System.err.println("Set Kanboard API Token to System Environment KB_API_TOKEN.");
			System.exit(1);
		}
		kbUser = System.getenv("KB_USER");
		if ( null == kbUser ) {
			System.err.println("Set Kanboard User to System Environment KB_USER.");
			System.exit(1);
		}
		kbUserToken = System.getenv("KB_USER_TOKEN");
		if ( null == kbUserToken ) {
			System.err.println("Set Kanboard User Access Token to System Environment KB_USER_TOKEN.");
			System.exit(1);
		}

		// REST API Client.

        System.out.println("[INFO]処理を開始しました");


        // encode api token
        byte[] xApiAuthTokenBytes;
        String xApiAuthToken=null;
		try {
			xApiAuthTokenBytes = String.join(":", "jsonrpc", kbApiToken).getBytes("utf-8");
	        xApiAuthToken = Base64.getEncoder().encodeToString(xApiAuthTokenBytes);
			//System.out.println(kbUser);
			System.out.println(kbApiToken);
	        System.out.println(xApiAuthToken);
		} catch (UnsupportedEncodingException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			System.exit(1);
		}


        URI uri=null;
        try {
			uri=new URI(kbUrl + "/jsonrpc.php");
		} catch (URISyntaxException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-API-Auth",xApiAuthToken);
        //headers.setContentType(new MediaType("text", "json", Charset.forName("utf-8")));
        headers.setContentType(new MediaType("application", "json", Charset.forName("utf-8")));

        JsonRpc request=new JsonRpc();
        request.jsonrpc="2.0";
        request.method="getVersion";
        request.id=1;
        RequestEntity<?> req = new RequestEntity<>(request, headers, HttpMethod.POST, uri);

        RestTemplate client = new RestTemplate(new SimpleClientHttpRequestFactory());

        //リクエスト処理（第二引数は受信したボディの変換先の型）
        ResponseEntity<KanboardVersion> res = client.exchange(req, KanboardVersion.class);
        //String answer = client.postForObject(kbUrl+"/jsonrpc.php", entity, String.class);

        System.out.println(res.getBody().getResult());


	}
}


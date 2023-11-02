import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C01_GetMethod {

    @Test
    public void test01(){

        String url="https://jsonplaceholder.typicode.com/posts/44";

        Response response=given().when().get(url);

        response.then().assertThat().statusCode(200)
                .contentType(ContentType.JSON).body("userId", Matchers.equalTo(5))
                .body("title",Matchers.equalTo("optio dolor molestias sit"));

    }

    @Test
    public  void post01(){
        String url="https://jsonplaceholder.typicode.com/posts";

        JSONObject jsBody=new JSONObject();
        jsBody.put("title","API");
        jsBody.put("body","API ogrenmek ne guzel");
        jsBody.put("userId",10);

        Response response=given().contentType(ContentType.JSON).when().body(jsBody.toString()).post(url);

        response.prettyPrint();

        response.then().assertThat().statusCode(201).contentType(ContentType.JSON).
                body("title",Matchers.equalTo("API")).
                body("userId",Matchers.lessThan(200)).
                body("body",Matchers.containsString("API"));





    }
}

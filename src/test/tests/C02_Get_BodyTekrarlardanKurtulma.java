import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class C02_Get_BodyTekrarlardanKurtulma {

    @Test
    public void get01(){
        String url="https://restful-booker.herokuapp.com/booking/10";

        Response response=given().when().get(url);

        response.then().assertThat().statusCode(200).contentType(ContentType.JSON).
                body("firstname", Matchers.equalTo("Sally"))
                .body("lastname",Matchers.equalTo("Jones"))
                .body("totalprice",Matchers.lessThan(1000))
                .body("depositpaid",Matchers.equalTo(true))
                .body("additionalneeds",Matchers.notNullValue());
        //matcherslardan kurtulabilirz
        response.then().assertThat().statusCode(200).contentType(ContentType.JSON)
                .body("firstname",equalTo("Sally"),"lastname",equalTo("Jones"));
    }
}

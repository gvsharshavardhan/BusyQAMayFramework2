package restAssured;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostExample {


    public static void main(String[] args) {

        int id = given().header("Content-Type", ContentType.JSON).header("Accept", ContentType.JSON).
                body("{\n" +
                        "    \"firstname\" : \"harsha\",\n" +
                        "    \"lastname\" : \"vardhan\",\n" +
                        "    \"totalprice\" : 123,\n" +
                        "    \"depositpaid\" : true,\n" +
                        "    \"bookingdates\" : {\n" +
                        "        \"checkin\" : \"2018-01-01\",\n" +
                        "        \"checkout\" : \"2019-01-01\"\n" +
                        "    },\n" +
                        "    \"additionalneeds\" : \"brunch\"\n" +
                        "}")
                .when().post("https://restful-booker.herokuapp.com/booking")
                .then().extract().body().jsonPath().get("bookingid");

        given().
                when().
                get("https://restful-booker.herokuapp.com/booking/" + id + "").
                then().
                log().
                all().
                assertThat().body("firstname", equalTo("harsha"));

//        System.out.println(id);
    }
}

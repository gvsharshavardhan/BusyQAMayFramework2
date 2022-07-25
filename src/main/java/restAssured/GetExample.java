package restAssured;


import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;


public class GetExample {

    public static void main(String[] args) {

        //given -> specify the params
        //when -> describe the action
        //then -> describe the result

//        given().
//                when().
//                get("https://restful-booker.herokuapp.com/booking").
//                then().
//                log().
//                all().
//                statusCode(200);

        given().header("Accept",ContentType.JSON)
                .header("Content-Type",ContentType.JSON).
                when().get("https://6922f323-5989-4599-bd9f-3fe8a734a4ee.mock.pstmn.io/complexJson").
                then().body("phoneNumbers[1].number",equalTo("0123-4567-8910"));


    }
}

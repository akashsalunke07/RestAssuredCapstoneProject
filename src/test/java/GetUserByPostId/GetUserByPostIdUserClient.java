package GetUserByPostId;

import GetUserByPostId.GetUserByPostIdResponse.GetUserByPostIdResponse;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class GetUserByPostIdUserClient {

    public GetUserByPostIdResponse GetUserByPostId(String post_id) {
        Response response = given()
                .pathParam("post_id",post_id)
                .when()
                .headers("app-id","633be1303c58178363f1168a")
                .get("https://dummyapi.io/data/v1/user/{post_id}");

        response
                .then()
                .log().body();
        int statusCode = response.getStatusCode();
        GetUserByPostIdResponse allResponse = response.as(GetUserByPostIdResponse.class);
        allResponse.setStatusCode(statusCode);
        return allResponse;
    }
}

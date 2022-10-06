package GetAllPosts;

import GetAllPosts.GetAllPostsResponse.GetAllPostsResponse;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class GetAllPostsUserClient {

    public GetAllPostsResponse getAllPosts() {
        Response response = given()
                .when()
                .headers("app-id","633be1303c58178363f1168a")
                .get("https://dummyapi.io/data/v1/post");
        response
                .then()
                .log().body();
        int statusCode = response.getStatusCode();
        GetAllPostsResponse allResponse = response.as(GetAllPostsResponse.class);
        allResponse.setStatusCode(statusCode);
        return allResponse;
    }
}

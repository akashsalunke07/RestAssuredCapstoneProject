package GetAllUsers;

import GetAllUsers.GetAllUsersResponse.GetUserResponse;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class GetAllUsersUserClient {

    public GetUserResponse getAllUser() {
        Response response = given()
                .when()
                .headers("app-id","633be1303c58178363f1168a")
                .get("https://dummyapi.io/data/v1/user");
        response
                .then()
                .log().body();
        int statusCode = response.getStatusCode();
        GetUserResponse allResponse = response.as(GetUserResponse.class);
        allResponse.setStatusCode(statusCode);
        return allResponse;
    }
}

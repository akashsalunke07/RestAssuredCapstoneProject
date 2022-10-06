package CreateUser;

import CreateUser.CreateUserRequest.CreateUserRequest;
import CreateUser.CreateUserResponse.CreateUserResponse;
import CreateUser.CreateUserResponse.ErrorResponse.CreateUserErrorResponse;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class CreateUserClient {

    public CreateUserResponse createUserResponse(CreateUserRequest requestBody) {

        Response response = createUser(requestBody);
        CreateUserResponse createUserResponse = response.as(CreateUserResponse.class);

        createUserResponse.setStatusCode(response.statusCode());

        return createUserResponse;
    }

    public Response createUser(CreateUserRequest requestBody) {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .headers("app-id","633be1303c58178363f1168a")
                .body(requestBody)
                .when()
                .post("https://dummyapi.io/data/v1/user/create");

        response.then()
                .log().body();

        return
                response;
    }

    public CreateUserErrorResponse createUserErrorResponse(CreateUserRequest requestBody) {

        Response response = createUser(requestBody);
        CreateUserErrorResponse createUserResponse = response.as(CreateUserErrorResponse.class);
        createUserResponse.setStatusCode(response.statusCode());
        return createUserResponse;
    }
}

package GetUserUnderYourAccount;


import GetUserUnderYourAccount.GetUsersUnderYourAccountResponse.GetUserResponseUnderYourAccount;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class GetUsersUnderYourAccountUserClient {

    public GetUserResponseUnderYourAccount getAllUser() {
        Response response = given()
                .when()
                .headers("app-id","633be1303c58178363f1168a")
                .get("https://dummyapi.io/data/v1/user?created=1");
        response
                .then()
                .log().body();
        int statusCode = response.getStatusCode();
        GetUserResponseUnderYourAccount allResponse = response.as(GetUserResponseUnderYourAccount.class);
        allResponse.setStatusCode(statusCode);
        return allResponse;
    }
}

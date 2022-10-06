package DeletePostById;

import DeletePostById.DeletePostByIdResponse.DeleteUserByIdResponse;
import GetAllPosts.GetAllPostsResponse.GetAllPostsResponse;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class DeletePostByIdUserClient {

    public DeleteUserByIdResponse deleteUserResponse(String post_id){

        Response response = getResponse(post_id);
        DeleteUserByIdResponse deleteUserByIdResponse = response.as(DeleteUserByIdResponse.class);
        deleteUserByIdResponse.setStatusCode(response.getStatusCode());

        return deleteUserByIdResponse;
    }

    private static Response getResponse(String post_id) {
        Response response = given()
                .pathParam("post_id", post_id)
                .headers("app-id", "633be1303c58178363f1168a")
                .delete("https://dummyapi.io/data/v1/post/{post_id}");

        response
                .then()
                .log().body();

        return response;
    }

}

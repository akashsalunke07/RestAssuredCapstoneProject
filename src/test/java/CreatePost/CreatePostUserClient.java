package CreatePost;

import CreatePost.CreatePostRequest.CreatePostRequest;
import CreatePost.CreatePostResponse.CreatePostResponse;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class CreatePostUserClient {

    public CreatePostResponse createPost(CreatePostRequest request){
        Response response = getResponse(request);
        CreatePostResponse createPostResponse = response.as(CreatePostResponse.class);
        createPostResponse.setStatusCode(response.getStatusCode());
        return createPostResponse;

    }

    private static Response getResponse(CreatePostRequest request) {
        Response response = given()
                    .accept(ContentType.JSON)
                    .contentType(ContentType.JSON)
                    .headers("app-id","633be1303c58178363f1168a")
                    .body(request)
                .when()
                    .post("https://dummyapi.io/data/v1/post/create");
        response
                .then()
                .log().body();
       return response;

    }
}

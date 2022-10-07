package IntegrationTests;

import CreatePost.CreatePostRequest.CreatePostRequest;
import CreatePost.CreatePostResponse.CreatePostResponse;
import CreatePost.CreatePostUserClient;
import DeletePostById.DeletePostByIdResponse.DeleteUserByIdResponse;
import DeletePostById.DeletePostByIdUserClient;
import GetAllPosts.GetAllPostsResponse.GetAllPostsResponse;
import GetAllPosts.GetAllPostsUserClient;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class EndToEndTest {

    CreatePostUserClient createPostUserClient;
    DeletePostByIdUserClient deletePostByIdUserClient;
    GetAllPostsUserClient getAllPostsUserClient;



    @BeforeClass
    public void initializer(){
        createPostUserClient = new CreatePostUserClient();
        deletePostByIdUserClient = new DeletePostByIdUserClient();
        getAllPostsUserClient = new GetAllPostsUserClient();
    }

    @Test
    public void shouldCreateAndDeletePost(){

        // Builder pattern default values
//        String text = "The TestVagrant Story";
        String image = "https://img.dummyapi.io/photo-1564694202779-bc908c327862.jpg";
        String ownerId = "633ea1d65030244ef9e41c02";

        List<String> tag = List.of(new String[]{"Java", "JavaScript", "Python"});

        CreatePostRequest createPostRequestBody = CreatePostRequest.builder()
                .owner(ownerId)
                .image(image)
                .likes(0)
                .tags(tag)
//                .text(text)
                .build();

        CreatePostResponse createPostResponse = createPostUserClient.createPost(createPostRequestBody);
        assertEquals(createPostResponse.getStatusCode(),200);
        String postId = createPostResponse.getId();


        GetAllPostsResponse allPosts = getAllPostsUserClient.getAllPosts();

        assertTrue(allPosts.hasPost(postId));


        DeleteUserByIdResponse deleteUserByIdResponse = deletePostByIdUserClient.deleteUserResponse(postId);
        assertEquals(deleteUserByIdResponse.getStatusCode(),200);

        GetAllPostsResponse posts2 = getAllPostsUserClient.getAllPosts();
        assertFalse(posts2.hasPost(postId));

    }

}

package IntegrationTests;

import CreatePost.CreatePostRequest.CreatePostRequest;
import CreatePost.CreatePostResponse.CreatePostResponse;
import CreatePost.CreatePostUserClient;
import DeletePostById.DeletePostByIdResponse.DeleteUserByIdResponse;
import DeletePostById.DeletePostByIdUserClient;
import GetAllPosts.GetAllPostsResponse.GetAllPostsResponse;
import GetAllPosts.GetAllPostsUserClient;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

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

        String text = "The TestVagrant Story";
        String image = "https://img.dummyapi.io/photo-1564694202779-bc908c327862.jpg";
        String ownerId = "633ea1d65030244ef9e41c02";
        List<String> tag = List.of(new String[]{"Java", "JavaScript", "Python"});

        CreatePostRequest createPostRequestBody = CreatePostRequest.builder()
                .owner(ownerId)
                .image(image)
                .likes(0)
                .tags(tag)
                .text(text)
                .build();

        CreatePostResponse createPostResponse = createPostUserClient.createPost(createPostRequestBody);
        Assert.assertEquals(createPostResponse.getStatusCode(),200);
        String post_id = createPostResponse.getId();


        GetAllPostsResponse posts1 = getAllPostsUserClient.getAllPosts();
        posts1.hasPost(post_id,true);


        DeleteUserByIdResponse deleteUserByIdResponse = deletePostByIdUserClient.deleteUserResponse(post_id);
        Assert.assertEquals(deleteUserByIdResponse.getStatusCode(),200);

        GetAllPostsResponse posts2 = getAllPostsUserClient.getAllPosts();
        posts2.hasPost(post_id,false);

    }

}

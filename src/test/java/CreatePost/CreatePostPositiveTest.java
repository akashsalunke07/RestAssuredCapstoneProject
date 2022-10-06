package CreatePost;

import CreatePost.CreatePostRequest.CreatePostRequest;
import CreatePost.CreatePostResponse.CreatePostResponse;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class CreatePostPositiveTest {

    CreatePostUserClient userClient;

    @BeforeClass
    public void initializer(){
        userClient = new CreatePostUserClient();
    }

    @Test
    public void shouldGetUserByPostId() {

        //Arrange
        String text = "adult Labrador retriever";
        String image = "https://img.dummyapi.io/photo-1564694202779-bc908c327862.jpg";
        String ownerId = "633ea1d65030244ef9e41c02";

        List<String> tag = List.of(new String[]{"animal", "dog", "golden retriever"});
        CreatePostRequest createPostRequest = CreatePostRequest.builder()
                .text(text)
                .image(image)
                .likes(0)
              //  .tags(tag)
                .owner(ownerId)
                .build();

        //Act
        CreatePostResponse createPostResponse = userClient.createPost(createPostRequest);

        //Assert
        Assert.assertEquals(createPostResponse.getOwner().getId(),ownerId);

    }
}

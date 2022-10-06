package DeletePostById;

import DeletePostById.DeletePostByIdResponse.DeleteUserByIdResponse;
import GetAllPosts.GetAllPostsResponse.GetAllPostsResponse;
import GetAllPosts.GetAllPostsUserClient;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DeletePostByIdPositiveTest {

    DeletePostByIdUserClient userClient;
    GetAllPostsUserClient getAllPostsUserClient;


    @BeforeClass
    public void initializer(){
        userClient = new DeletePostByIdUserClient();
    }

    @Test
    public void shouldDeletePostByPostId(){

        //Arrange


        GetAllPostsResponse allPosts = getAllPostsUserClient.getAllPosts();
        String post_id = allPosts.getData().get(0).getId();


        //Act
        DeleteUserByIdResponse deleteUserByIdResponse = userClient.deleteUserResponse(post_id);

        //Assert
        Assert.assertEquals(deleteUserByIdResponse.getId(),post_id);

    }

}
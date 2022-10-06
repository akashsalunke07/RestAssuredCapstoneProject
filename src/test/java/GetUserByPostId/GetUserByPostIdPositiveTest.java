package GetUserByPostId;

import GetUserByPostId.GetUserByPostIdResponse.GetUserByPostIdResponse;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GetUserByPostIdPositiveTest {

    GetUserByPostIdUserClient userClient;

    @BeforeClass
    public void initializer(){
        userClient = new GetUserByPostIdUserClient();
    }

    @Test
    public void shouldGetUserByPostId(){

        //Arrange

        String post_id = "60d0fe4f5311236168a109ca";

        //Act
        GetUserByPostIdResponse getUserByPostId = userClient.GetUserByPostId(post_id);

        //Assert
        Assert.assertNotNull(getUserByPostId.getEmail());
        Assert.assertEquals(getUserByPostId.getStatusCode(),200);
        Assert.assertEquals(getUserByPostId.getId(),post_id);
    }
}

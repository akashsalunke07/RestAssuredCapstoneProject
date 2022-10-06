package GetAllUsers;

import GetAllUsers.GetAllUsersResponse.GetUserResponse;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GetAllUsersPositiveTests {
    GetAllUsersUserClient userClient;

    @BeforeClass
    public void initializer(){
        userClient = new GetAllUsersUserClient();
    }

    @Test
    public void shouldGetAllUsers(){

        //Arrange

        //Act
        GetUserResponse getAllUserResponse = userClient.getAllUser();

        //Assert
        Assert.assertNotNull(getAllUserResponse.getData());
        Assert.assertEquals(getAllUserResponse.getStatusCode(),200);
        Assert.assertEquals(getAllUserResponse.getData().size(),20);
    }
}

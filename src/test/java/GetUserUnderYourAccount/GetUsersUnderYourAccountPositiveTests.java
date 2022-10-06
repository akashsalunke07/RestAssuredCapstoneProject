package GetUserUnderYourAccount;

import GetAllUsers.GetAllUsersResponse.GetUserResponse;
import GetUserUnderYourAccount.GetUsersUnderYourAccountResponse.GetUserResponseUnderYourAccount;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GetUsersUnderYourAccountPositiveTests {
    GetUsersUnderYourAccountUserClient userClient;

    @BeforeClass
    public void initializer(){
        userClient = new GetUsersUnderYourAccountUserClient();
    }

    @Test
    public void shouldGetAllUsersUnderYourAccount(){

        //Arrange

        //Act
        GetUserResponseUnderYourAccount getUserResponseUnderYourAccount = userClient.getAllUser();

        //Assert
        Assert.assertNotNull(getUserResponseUnderYourAccount.getData());
        Assert.assertEquals(getUserResponseUnderYourAccount.getStatusCode(),200);
        Assert.assertEquals(getUserResponseUnderYourAccount.getData().size(),6);
    }
}

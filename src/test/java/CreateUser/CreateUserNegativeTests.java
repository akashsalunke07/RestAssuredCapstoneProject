package CreateUser;

import CreateUser.CreateUserRequest.CreateUserRequest;
import CreateUser.CreateUserResponse.ErrorResponse.CreateUserErrorResponse;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CreateUserNegativeTests {

    CreateUserClient userClient;

    @BeforeClass
    public void beforeClass(){
        userClient  = new CreateUserClient();
    }


    @Test
    public void shouldNotCreateUserWithExistingEmail(){

        //Arrange
        String email = "akashsalunke123@gmail.com";

        CreateUserRequest createUserRequestBody = CreateUserRequest.builder()
                .firstName("Akash")
                .lastName("Salunke")
                .email(email)
                .build();

        //Act
        CreateUserErrorResponse userErrorResponse = userClient.createUserErrorResponse(createUserRequestBody);

        //Assert
        Assert.assertEquals(userErrorResponse.getStatusCode(),400);
        Assert.assertEquals(userErrorResponse.getData().getEmail(),"Email already used");


    }

}

package CreateUser;

import CreateUser.CreateUserRequest.CreateUserRequest;
import CreateUser.CreateUserResponse.CreateUserResponse;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.UUID;

public class CreateUserPositiveTest {
    CreateUserClient userClient;
    @BeforeClass

    public void initializer(){
        userClient = new CreateUserClient();
    }

    @Test
    public void shouldCreateUserAllUsers(){

        //Arrange
        String email = UUID.randomUUID() +"@gmail.com";

        CreateUserRequest createUserRequestBody = CreateUserRequest.builder()
                .firstName("Akash")
                .lastName("Salunke")
                .email(email)
                .build();

        //Act
        CreateUserResponse createUserResponse = userClient.createUserResponse(createUserRequestBody);

        //Assert
        Assert.assertEquals(createUserResponse.getStatusCode(),200);
        Assert.assertEquals(createUserResponse.getEmail(),createUserRequestBody.getEmail());


    }


}

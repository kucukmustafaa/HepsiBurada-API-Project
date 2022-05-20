package Test;

import Base.HttpClient;
import Model.Response.VegetableListResponse;
import io.restassured.RestAssured;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import org.junit.Test;


public class ExampleTest {


    @Test
    public void safsfasfa(){


        RestAssured.baseURI="http://localhost:3000/";

        HttpClient httpClient=new HttpClient();
        Response response=httpClient.get("/allGrocery");

        VegetableListResponse vegetableListResponse=response.then().extract().as(VegetableListResponse.class, ObjectMapperType.GSON);


        System.out.println(vegetableListResponse.data.get(1).getId());


    }

}

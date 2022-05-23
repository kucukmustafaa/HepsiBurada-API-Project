package Test;

import Base.HttpClient;
import Model.Request.Vegetable;
import Model.Response.VegetableListResponse;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;


public class HBTestExample {


    @Test(groups = "e2e",description = "Tüm ürünlerin listelenmesi")
    public void test1(){
        HttpClient httpClient=new HttpClient();
        Response response=httpClient.get("/allGrocery");
        VegetableListResponse vegetableListResponse=response.then().extract().as(VegetableListResponse.class, ObjectMapperType.GSON);
        Assert.assertEquals(response.getStatusCode(),200);

    }


    @Test(groups = "e2e",description = "Tüm ürünlerin içinde bir ürünün aranması")
    public void test2(){
        HttpClient httpClient=new HttpClient();
        Response response=httpClient.getWithPathParam("/allGrocery","apple");
        VegetableListResponse vegetableListResponse=response.then().extract().as(VegetableListResponse.class, ObjectMapperType.GSON);
        Assert.assertEquals(response.getStatusCode(),200);
    }

    @Test(groups = "e2e",description = "Başarılı şekilde ürün ekleme")
    public void test3(){

        Vegetable vegetable=Vegetable.
                    builder().
                    id(1).
                    name("elma").
                    price(3.43f).
                    stock(3).
                    build();

        HttpClient httpClient=new HttpClient();
        Response response=httpClient.post("/allGrocery",vegetable);
        VegetableListResponse vegetableListResponse=response.then().extract().as(VegetableListResponse.class, ObjectMapperType.GSON);
        Assert.assertEquals(response.getStatusCode(),201);
    }

}

package Test;

import Base.HttpClient;
import Config.Config;
import Model.Request.Vegetable;
import Model.Response.VegetableListResponse;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;


public class HBTestExample {


    @Test(groups = {"e2e","smoke"},description = "Tüm ürünlerin listelenmesi")
    public void test1(){
        HttpClient httpClient=new HttpClient(Config.PROD_URL);
        Response response=httpClient.get("/allGrocery");
        VegetableListResponse vegetableListResponse=response.then().extract().as(VegetableListResponse.class, ObjectMapperType.GSON);
        Assert.assertEquals(response.getStatusCode(),200);

    }


    @Test(groups = {"smoke"},description = "Tüm ürünlerin listelenmesi yanlis endpoint girilmesi")
    public void test2(){
        HttpClient httpClient=new HttpClient(Config.PROD_URL);
        Response response=httpClient.get("/allGroceryasdaf");
        VegetableListResponse vegetableListResponse=response.then().extract().as(VegetableListResponse.class, ObjectMapperType.GSON);
        Assert.assertEquals(response.getStatusCode(),404);
    }


    @Test(groups = {"e2e","smoke"},description = "Tüm ürünlerin içinde bir ürünün aranması")
    public void test3(){
        HttpClient httpClient=new HttpClient(Config.PROD_URL);
        Response response=httpClient.getWithPathParam("/allGrocery","apple");
        VegetableListResponse vegetableListResponse=response.then().extract().as(VegetableListResponse.class, ObjectMapperType.GSON);
        Assert.assertEquals(response.getStatusCode(),200);

    }

    @Test(groups = {"e2e","smoke"},description = "Başarılı ürün ekleme")
    public void test4(){


        Vegetable vegetable=Vegetable.
                    builder().
                    id(1).
                    name("elma").
                    price(3.43f).
                    stock(3).
                    build();

        HttpClient httpClient=new HttpClient(Config.PROD_URL);
        Response response=httpClient.post("/allGrocery",vegetable);
        VegetableListResponse vegetableListResponse=response.then().extract().as(VegetableListResponse.class, ObjectMapperType.GSON);
        Assert.assertEquals(response.getStatusCode(),201);
    }

    @Test(groups = {"e2e","smoke"},description = "Başarılı şekilde ürün ekleme")
    public void test5(){

        Vegetable vegetable=Vegetable.
                            builder().
                            id(1).
                            name("elma").
                            price(3.43f).
                            stock(3).
                            build();

        HttpClient httpClient=new HttpClient(Config.INVALID_URL);
        Response response=httpClient.post("/allGrocery",vegetable);
        VegetableListResponse vegetableListResponse=response.then().extract().as(VegetableListResponse.class, ObjectMapperType.GSON);
        Assert.assertEquals(response.getStatusCode(),404);
    }

}

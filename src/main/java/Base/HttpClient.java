package Base;


import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class HttpClient {


    public Response post(String path,Object object){

        return given().
                log().all().
                header("content-type","application/json").
                body(object).
                when().
                post(path);
    }



    public Response put(String path,Object object){

        return given().
                log().all().
                header("content-type","application/json").
                body(object).
                when().
                put(path);
    }


    public Response get(String path){

        return given().
                log().all().
                header("content-type","application/json").
                when().
                get(path);
    }

    public Response getWithPathParam(String path,String pathParam){

        return given().
                log().all().
                header("content-type","application/json").
                when().pathParam("","").
                get(path);
    }


    public Response delete(String path){

        return given().
                log().all().
                header("content-type","application/json").
                when().
                delete(path);
    }




}

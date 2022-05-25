package Base;


import Config.Config;
import Config.SpecBuilder;
import Utils.APIResponseFilter;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class HttpClient {

    private String URL;

    public HttpClient(String url){
        this.URL=url;
    }


    public Response post(String path,Object object){

        return given().
                spec(SpecBuilder.getNormalUserSpec()).
                baseUri(URL).
                body(object).
                when().
                post(path);
    }



    public Response put(String path,Object object){

        return given().
                spec(SpecBuilder.getNormalUserSpec()).
                baseUri(URL).
                body(object).
                when().
                put(path);
    }


    public Response get(String path){

        return given().
                spec(SpecBuilder.getNormalUserSpec()).
                baseUri(URL).
                when().
                get(path);
    }

    public Response getWithPathParam(String path,String pathParam){

        return given().
                spec(SpecBuilder.getNormalUserSpec()).
                baseUri(URL).
                when().
                pathParam("pathParam",pathParam ).
                get(path+"{pathParam}");
    }


    public Response delete(String path){

        return given().
                spec(SpecBuilder.getNormalUserSpec()).
                baseUri(URL).
                when().
                delete(path);
    }




}

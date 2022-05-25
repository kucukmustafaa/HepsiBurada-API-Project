package Config;

import Utils.APIResponseFilter;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class SpecBuilder {

    public static RequestSpecification getNormalUserSpec(){

        RequestSpecification requestSpecification= RestAssured.given().
                log().all().
                filter(new APIResponseFilter()).
                header("content-type","application/json");

        return requestSpecification;
    }

    public static RequestSpecification getLoginUserSpec(){

        RequestSpecification requestSpecification= RestAssured.given().
                log().all().
                filter(new APIResponseFilter()).
                header("content-type","application/json").
                header("token","EFSAA-2SAFAS-ASFA2-12212");

        return requestSpecification;
    }


}

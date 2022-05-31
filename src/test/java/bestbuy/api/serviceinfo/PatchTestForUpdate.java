package bestbuy.api.serviceinfo;


import bestbuy.api.model.ServicePojo;
import bestbuy.api.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PatchTestForUpdate extends TestBase {
    @Test
    public void createEService(){
        ServicePojo servicePoJo = new ServicePojo();
        servicePoJo.setName("String");
        Response response = given()
                .header("content-type","application/json")
                .when()
                .body(servicePoJo)
                .put("/services/15");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}
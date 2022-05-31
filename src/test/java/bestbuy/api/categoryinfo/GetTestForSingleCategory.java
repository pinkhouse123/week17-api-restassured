package bestbuy.api.categoryinfo;

import bestbuy.api.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetTestForSingleCategory extends TestBase {
    @Test
    public void readProductList(){
        Response response = given()
                .when()
                .get("/categories/pcmcat84000050004");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}
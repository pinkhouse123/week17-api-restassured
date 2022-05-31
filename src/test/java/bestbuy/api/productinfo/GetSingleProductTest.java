package bestbuy.api.productinfo;

import bestbuy.api.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetSingleProductTest extends TestBase {
    @Test
    public void readProductList() {
        Response response = given()
                .pathParam("id",48530)
                .when()
                .get("/products/{id}");
        response.prettyPrint();
        response.then().statusCode(200);
    }
}
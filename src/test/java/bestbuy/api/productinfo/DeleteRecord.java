package bestbuy.api.productinfo;

import bestbuy.api.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class DeleteRecord extends TestBase {
    @Test
    public void deleteProduct(){
        Response response = given()
                .when()
                .delete("/products/127687");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}
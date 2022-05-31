package bestbuy.api.storeinfo;

import bestbuy.api.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class DeleteRecord extends TestBase {
    @Test
    public void deleteRecord(){
        Response response = given()
                .when()
                .delete("/stores/13");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}
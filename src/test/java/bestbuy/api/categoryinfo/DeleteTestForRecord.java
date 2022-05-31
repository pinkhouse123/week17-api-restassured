package bestbuy.api.categoryinfo;

import bestbuy.api.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class DeleteTestForRecord extends TestBase {
    @Test
    public void deleteRecord(){
        Response response = given()
                .when()
                .delete("/categories/abcat0020001");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}
package bestbuy.api.categoryinfo;

import bestbuy.api.model.CategoryPojo;
import bestbuy.api.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PutTestForUpdate extends TestBase {
    @Test
    public void readProductList(){
        CategoryPojo categoryPojo = new CategoryPojo();
        categoryPojo.setName("String");
        categoryPojo.setId("String");
        Response response = given()
                .header("content-type","application/json")
                .body(categoryPojo)
                .when()
                .put("/categories/abcat0102006");
        response.then().statusCode(201);
        response.prettyPrint();
    }
}
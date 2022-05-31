package bestbuy.api.categoryinfo;

import bestbuy.api.model.ProductPojo;
import bestbuy.api.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PostCreateProduct extends TestBase {
    @Test
    public void createProductRecord(){
        ProductPojo productPojo = new ProductPojo();
        productPojo.setName("Sony");
        productPojo.setDescription("string");
        productPojo.setModel("string");
        productPojo.setShipping(0);
        productPojo.setImage("string");
        productPojo.setType("string");
        productPojo.setUpc("string");
        productPojo.setUrl("string");
        productPojo.setPrice(0);
        productPojo.setManufacturer("string");
        Response response = given()
                .header("content-type","application/json")
                .when()
                .body(productPojo)
                .post("/products");
        response.then().statusCode(201);
        response.prettyPrint();
    }
}
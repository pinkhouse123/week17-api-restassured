package bestbuy.api.extractingresponsedata;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class SearchJsonPathExample {
    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        response = given().log().all()
                .when()
                .get("/stores")
                .then().statusCode(200);

    }

    @Test
    //1. Extract the limit
    public void test001() {
        int numberOfLimit = response.extract().path("limit");
        System.out.println("number of limit is:= " + numberOfLimit);

    }

    @Test
    //2. Extract the total
    public void test002() {
        int total = response.extract().path("total");
        System.out.println("total is := " + total);
    }

    @Test
    //3. Extract the name of 5th store
    public void test003() {
        String name = response.extract().path("data[5].name");
        System.out.println("5th store name: " + name);
    }

    @Test
    //4. Extract the names of all the store
    public void test004() {
        List<String> listOfStore = response.extract().path("data.name");
        System.out.println(" list of store name:= " + listOfStore);
    }

    @Test
    //5. Extract the storeId of all the store
    public void test005() {
        List<Integer> listOfId = response.extract().path("data.id");
        System.out.println(" list of store name:= " + listOfId);
    }

    @Test
    //6. Print the size of the data list
    public void test006() {
        int size = response.extract().path("data.size()");
        System.out.println("size of the data list := " + size);
    }

    @Test
    //7. Get all the value of the store where store name = St Cloud
    public void test007() {
        List<List<String>> data = response.extract().path("data.findAll{it.name=='St Cloud'}");
        System.out.println("get all value of the stores which name is st cloud = " + data);
        ;
    }

    @Test
    //8. Get the address of the store where store name = Rochester
    public void test008() {
        String address = response.extract().path("data.findAll{it.name=='Rochester'}.address").toString();
        System.out.println(" store name=  rochester which is  address:= " + address);
    }

    @Test
    //9. Get all the services of 8th store
    public void test009() {
        List<String> listOfServices = response.extract().path("data[8].services");
        System.out.println("8th store's list of services := " + listOfServices);

    }

    @Test
    //10. Get storeservices of the store where service name = Windows Store
    public void test010() {

        List<Map<String, String>> listOfStoreServices = response.extract().
                path("data.findAll{it.services.find{it.name =='Windows Store'}}.services.storeservices");
        System.out.println("storeservices of the store where service name = Windows Store are :=  " + listOfStoreServices);

    }

    @Test
    //11. Get all the storeId of all the store
    public void test011() {
        List<?> storeIdlist = response.extract().
                path("data.findAll{it.services}.services.findAll{it.storeservices}.storeservices.storeId");
        System.out.println("all stores' storeID are  :=  " + storeIdlist);

    }

    @Test
    //12. Get id of all the store
    public void test012() {
        List<?> listOfId
                = response.extract().path("data.find{it.services}.services.id");
        System.out.println("get all store id : " + listOfId);
    }

    @Test
    //13. Find the store names Where state = IA
    public void test013() {

        List<?> storeName
                = response.extract().path("data.findAll{it.state=='IA'}.find{it.services}.services.name");
        System.out.println("List of store names Where state = IA :=" + storeName);
    }

    @Test
    //14. Find the Total number of services for the store where store name = Rochester
    public void test014() {
        int numberOfServices = response.extract().path("data.findAll{it.name=='Rochester'}.find{it.services}.services.size()");
        System.out.println("Total number of services for the store where store name = Rochester:= " + numberOfServices);
    }

    @Test
    //15. Find the createdAt for all services whose name = “Windows Store”
    public void test015() {
        List<String> time = response.extract().
                path("data.findAll{it.services.find{it.name =='Windows Store'}}.createdAt");
        System.out.println("the createdAt for all services whose name = “Windows Store”:= " + time);
    }
    @Test
    //16. Find the name of all services Where store name = “Fargo”
    public void test016(){
        List<String> serviceName = response.extract().
                path("data.findAll{it.name =='Inver Grove Heights'}.find{it.services}.services.name");
        System.out.println("the createdAt for all services whose name = “Windows Store”:= " + serviceName);
    }
    @Test
    //17. Find the zip of all the store
    public void test017(){
        List<String> zipList = response.extract().
                path("data.zip");
        System.out.println("the createdAt for all services whose name = “Windows Store”:= " + zipList);
    }
    @Test
    //18. Find the zip of store name = Roseville
    public void test018(){
        String zip = response.extract().
                path("data.find{it.name=='Roseville'}.zip");
        System.out.println("the createdAt for all services whose name = “Windows Store”:= " + zip);
    }
    @Test
    //19. Find the storeservices details of the service name = Magnolia Home Theater
    public void test019(){
        List<Map<String, String>> listOfStoreServices = response.extract().
                path("data.findAll{it.services.find{it.name =='Magnolia Home Theater'}}.services.storeservices");
        System.out.println("storeservices of the store where service name =  Magnolia Home Theater :=  " + listOfStoreServices);

    }
    @Test
    //20. Find the lat of all the stores
    public void test020(){
        List<?> listOfLat= response.extract().path("data.lat");
        System.out.println("the lat of all the stores:=" + listOfLat);
    }
}
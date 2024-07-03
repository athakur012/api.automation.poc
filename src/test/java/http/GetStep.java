package http;

import com.google.gson.Gson;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.Before;
import pojo.TodoItem;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class GetStep {

    private int statusCode;
    private String responseBody;
    TodoItem actualResponse;
    @Before
    public void setUp() {
        System.out.println("Setting up before scenario execution");
    }

    @Given("^an authorised user sends a GET request to the endpoint$")
    public void sendHttpRequest() {
        String endpointUrl = "https://jsonplaceholder.typicode.com/todos/1";

        //returns a new http client with default settings
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endpointUrl)).header("Authorization", "Bearer your_token").GET().build();

        try{
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            statusCode = response.statusCode();
            responseBody = response.body();
        }
        catch(IOException | InterruptedException io){
          io.printStackTrace();
        }

    }

    @When("^the status response code will be (\\d+)$")
    public void validateResponseCode(int responseCode){

        Assert.assertEquals(responseCode, statusCode);

    }

   @Then("^the user ID is (\\d+), the ID is (\\d+), the title is \"([^\"]*)\", and it (is|is not) completed$")
   public void validateResponseMessage(int userId, int id, String title, Boolean status){

        Gson gson = new Gson();

        //Deserialize JSON to object
       actualResponse = gson.fromJson(responseBody, TodoItem.class);

        TodoItem expectedResponse = new TodoItem(userId, id, title, status);
        Assert.assertEquals("Actual response is same as expected response", expectedResponse, actualResponse);

    }

    @Then("the response contains the following TodoItem details:")
    public void theResponseContainsTheFollowingTodoItemDetails(DataTable dataTable) {

        int userId = Integer.parseInt(dataTable.cell(1,1));
        int id = Integer.parseInt(dataTable.cell(2,1));
        String title = dataTable.cell(3,1);
        boolean completed  = Boolean.parseBoolean(dataTable.cell(4,1));

        Gson gson = new Gson();

        //Deserialize JSON to object
        actualResponse = gson.fromJson(responseBody, TodoItem.class);

        TodoItem expectedResponse = new TodoItem(userId, id, title, completed);
        Assert.assertEquals("Actual response is same as expected response", expectedResponse, actualResponse);

    }
}

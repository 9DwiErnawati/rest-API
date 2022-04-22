package starter.user;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class Get {
    protected static String url = "https://reqres.in/api/";

    @Step("I set GET api endpoints")
    public String iSetGETApiEndpoints() {
        return url + "users/2";
    }

    @Step("I send GET HTTP request")
    public void iSendGETHTTPRequest() {
        SerenityRest.given().get(iSetGETApiEndpoints());
    }

    @Step("I receive valid HTTP response code 200")
    public void iReceiveValidHTTPResponseCode200() {
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("I receive valid data for detail user")
    public void iReceiveValidDataForDetailUser() {
        restAssuredThat(response -> response.body("'data'.'id'", equalTo(2)));
        restAssuredThat(response -> response.body("'data'.'email'", equalTo("janet.weaver@reqres.in")));
        restAssuredThat(response -> response.body("'data'.'first_name'", equalTo("Janet")));
        restAssuredThat(response -> response.body("'data'.'last_name'", equalTo("Weaver")));
        restAssuredThat(response -> response.body("'data'.'avatar'", equalTo("https://reqres.in/img/faces/2-image.jpg")));
    }
}

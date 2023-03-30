package Testcases.Cards;

import PojoData.Cards.CardPojo;
import com.google.gson.Gson;
import common.BaseSetup;
import org.testng.annotations.Test;
import reports.ExtentReportManager;
import reports.ExtentTestManager;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class TestDeleteACard extends BaseSetup {

    @Test
    public void testUpdateACard() {

       given().spec(request())
                .when()
                .pathParam("cardId", TestCreateACard.cardId)
                .put("/cards/{cardId}?key={key}&token={token}")
                .then()
                .assertThat()
                .spec(response200());

        if (ExtentTestManager.getExtentTest() != null) {
            ExtentReportManager.pass("Test Update A Card Successfully");
        }
    }
}

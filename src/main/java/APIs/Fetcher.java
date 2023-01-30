package APIs;
import com.google.gson.*;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import models.Offers;
import utils.JSONHandle;

public class Fetcher {
    public Offers offersFetcher(String url) throws UnirestException {
        HttpResponse<JsonNode> response = Unirest.get(url)
                .asJson();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonParser jp = new JsonParser();
        JsonElement je = jp.parse(response.getBody().toString());
        String prettyJsonString = gson.toJson(je);
        return JSONHandle.JSONToOffers(prettyJsonString);
    }
}

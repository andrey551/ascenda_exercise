package utils;

import com.google.gson.*;
import models.Merchant;
import models.Offer;
import models.Offers;

import java.util.ArrayList;
import java.util.List;

public class JSONHandle {
    private static Gson gson = new Gson();

    public static Offers JSONToOffers(String JSONString) {
        JsonParser jsonParser = new JsonParser();
        JsonElement rootNode = jsonParser.parse(JSONString);
        Offers offers = new Offers();
        if(rootNode.isJsonObject()) {
            JsonObject jsonObject = rootNode.getAsJsonObject();
            jsonObject.get("offers")
                    .getAsJsonArray()
                    .forEach(offer -> {
                        JsonObject offerJsonObject  = offer.getAsJsonObject();
                        offers.addOffer(offerFromJsonObject(offerJsonObject));
                    });
        }
        return offers;
    }

    public static String offersToJSON(Offers objectList) {
        return gson.toJson(objectList);
    }

    public static List<Merchant> merchantFromJsonObject(JsonArray jsonArray) {
        List<Merchant> merchantList = new ArrayList<>();
        jsonArray.forEach(merchant ->{
            JsonObject jsonObject = merchant.getAsJsonObject();
            merchantList.add(new Merchant(
                    jsonObject.get("id").getAsInt(),
                    jsonObject.get("name").getAsString(),
                    jsonObject.get("distance").getAsFloat()
            ));
        });
        return merchantList;
    }

    public static Offer offerFromJsonObject( JsonObject offerJsonObject) {
        return new Offer(
                offerJsonObject.get("id").getAsInt(),
                offerJsonObject.get("title").getAsString(),
                offerJsonObject.get("description").getAsString(),
                offerJsonObject.get("category").getAsInt(),
                merchantFromJsonObject(offerJsonObject.get("merchants").getAsJsonArray()),
                offerJsonObject.get("valid_to").getAsString()
        );
    }


}

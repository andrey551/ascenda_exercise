import APIs.Fetcher;
import com.mashape.unirest.http.exceptions.UnirestException;
import controller.TaskFilter;
import models.Offer;
import models.Offers;
import utils.JSONHandle;

import java.time.LocalDate;
import java.util.List;

public class index {
    public static void main(String[] args) {
        Fetcher fetcher = new Fetcher();
        String url = "https://61c3deadf1af4a0017d990e7.mockapi.io/offers/near_by?lat=1.313492&lon=103.860359&rad=20";
        LocalDate checkingDate = LocalDate.parse("2019-12-25");
        try {
            Offers offers = fetcher.offersFetcher(url);
            List<Offer> offerList = offers.getOffers();
            TaskFilter taskFilter = new TaskFilter();
            List<Offer> response = taskFilter.offerFilter(offerList, checkingDate);
            System.out.println(JSONHandle.offersToJSON(new Offers(response)));
        } catch (UnirestException e) {
            e.printStackTrace();
        }
    }
}

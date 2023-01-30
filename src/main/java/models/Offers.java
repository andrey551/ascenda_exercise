package models;

import java.util.ArrayList;
import java.util.List;

public class Offers {
    private List<Offer> offers;

    public Offers() {
        offers = new ArrayList<>();
    }
    public Offers(List<Offer> offerList) {
        this.offers = offerList;
    }
    public void addOffer(Offer offer) {
        offers.add(offer);
    }

    public List<Offer> getOffers() {
        return offers;
    }

    public void setOffers(List<Offer> offers) {
        this.offers = offers;
    }

    @Override
    public String toString() {
        return "offers=" + offers.toString() +
                '}';
    }
}

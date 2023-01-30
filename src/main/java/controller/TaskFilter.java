package controller;

import models.CategoryType;
import models.Merchant;
import models.Offer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TaskFilter {
    public List<Offer> offerFilter(List<Offer> offerList, LocalDate checkingDate) {
        System.out.println(offerList);
        List<Offer> result = offerList
                .stream()
                .filter(offer -> checkValidCategory(offer.getCategory())
                && checkValidDate(checkingDate, offer.getValid_to()))
                .toList();

        result.forEach(this::setClosestMerchants);
        result = getClosestForEveryCategoryType(result);
        if(result.size() == 3) {
            result.remove(result.stream().max(Offer::compareTo).get());
        }
        return result;
    }

    public boolean checkValidDate(LocalDate checkingDate, LocalDate validTo) {
        return !checkingDate.isAfter(validTo.plusDays(5));
    }

    public boolean checkValidCategory(CategoryType categoryType) {
        return categoryType != CategoryType.HOTEL
                && categoryType != CategoryType.NOT_EXIST;
    }

    public void setClosestMerchants(Offer offer) {
        Merchant closestMerchant = offer.getMerchants()
                .stream()
                .min(Merchant::compareTo)
                .get();

        offer.getMerchants().clear();
        offer.getMerchants().add(closestMerchant);
    }

    List<Offer> getClosestForEveryCategoryType(List<Offer> offerList) {
        List<Offer> result = new ArrayList<>();
        CategoryType[] categoryType = new CategoryType[]{CategoryType.ACTIVITY, CategoryType.RESTAURANT, CategoryType.RETAIL};
        for (CategoryType category: categoryType) {
            result.add(
                    offerList
                            .stream()
                            .filter(offer->{return offer.getCategory().equals(category);})
                            .min(Offer::compareTo)
                            .get());
        }

        return result;
    }


}

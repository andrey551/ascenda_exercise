package models;

import java.time.LocalDate;
import java.util.List;

public class Offer implements Comparable<Offer>{
    private int id;
    private String title;
    private String description;
    private CategoryType category;
    private List<Merchant> merchants;

    private LocalDate valid_to;

    public Offer(int id,
                 String title,
                 String description,
                 int order,
                 List<Merchant> merchants,
                 String valid_to) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.category = CategoryType.convertFromInt(order);
        this.merchants = merchants;
        this.valid_to = LocalDate.parse(valid_to);
    }

    public List<Merchant> getMerchants() {
        return merchants;
    }

    public void setMerchants(List<Merchant> merchants) {
        this.merchants = merchants;
    }

    public LocalDate getValid_to() {
        return valid_to;
    }

    public CategoryType getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Offer{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", categoryType=" + category +
                ", merchants=" + merchants +
                ", validTo=" + valid_to +
                '}';
    }

    @Override
    public int compareTo(Offer offer) {
        if(this.getMerchants().get(0).getDistance() == offer.getMerchants().get(0).getDistance()) return 0;
        if(this.getMerchants().get(0).getDistance() > offer.getMerchants().get(0).getDistance()) return 1;
        return -1;
    }
}

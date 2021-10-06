package training.proj.mobilele.models.views;


import training.proj.mobilele.models.entities.ModelEntity;

import java.math.BigDecimal;

public class OfferSummaryViewModel {

    private String engine;

    private String imageUrl;

    private int mileage;

    private BigDecimal price;

    private int year;

    private String transmission;

    private String modelName;

    private String brandName;

    public String getEngine() {
        return engine;
    }

    public OfferSummaryViewModel setEngine(String engine) {
        this.engine = engine;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public OfferSummaryViewModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public int getMileage() {
        return mileage;
    }

    public OfferSummaryViewModel setMileage(int mileage) {
        this.mileage = mileage;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OfferSummaryViewModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public int getYear() {
        return year;
    }

    public OfferSummaryViewModel setYear(int year) {
        this.year = year;
        return this;
    }

    public String getTransmission() {
        return transmission;
    }

    public OfferSummaryViewModel setTransmission(String transmission) {
        this.transmission = transmission;
        return this;
    }

    public String getModelName() {
        return modelName;
    }

    public OfferSummaryViewModel setModelName(String modelName) {
        this.modelName = modelName;
        return this;
    }

    public String getBrandName() {
        return brandName;
    }

    public OfferSummaryViewModel setBrandName(String brandName) {
        this.brandName = brandName;
        return this;
    }

    @Override
    public String toString() {
        return "OfferSummaryViewModel{" +
                "engine='" + engine + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", mileage=" + mileage +
                ", price=" + price +
                ", year=" + year +
                ", transmission='" + transmission + '\'' +
                ", modelName='" + modelName + '\'' +
                ", brandName='" + brandName + '\'' +
                '}';
    }
}

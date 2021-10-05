package training.proj.mobilele.models.views;

public class ModelViewModel {
//    <th>No</th>
//    <th >Model Name</th>
//    <th >Model Category</th>
//    <th >Model Start Year</th>
//    <th >Model End Year</th>
    private Long number;
    private String name;
    private String category;
    private Integer startYear;
    private Integer endYear;
    private String imageUrl;

    public Long getNumber() {
        return number;
    }

    public ModelViewModel setNumber(Long number) {
        this.number = number;
        return this;
    }

    public String getName() {
        return name;
    }

    public ModelViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public ModelViewModel setCategory(String category) {
        this.category = category;
        return this;
    }

    public Integer getStartYear() {
        return startYear;
    }

    public ModelViewModel setStartYear(Integer startYear) {
        this.startYear = startYear;
        return this;
    }

    public Integer getEndYear() {
        return endYear;
    }

    public ModelViewModel setEndYear(Integer endYear) {
        this.endYear = endYear;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public ModelViewModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    @Override
    public String toString() {
        return "ModelViewModel{" +
                "number=" + number +
                ", category='" + category + '\'' +
                ", startYear=" + startYear +
                ", endYear=" + endYear +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}

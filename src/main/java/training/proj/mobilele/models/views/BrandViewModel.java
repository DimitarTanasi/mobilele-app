package training.proj.mobilele.models.views;

import java.util.ArrayList;
import java.util.List;

public class BrandViewModel {

    private String name;

    private List<ModelViewModel> models;

    public BrandViewModel() {
        this.models = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public BrandViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public List<ModelViewModel> getModels() {
        return models;
    }

    public BrandViewModel setModels(List<ModelViewModel> models) {
        this.models = models;
        return this;
    }

    public void addModel(ModelViewModel model){
        this.models.add(model);
    }
    @Override
    public String toString() {
        return "BrandViewModel{" +
                "name='" + name + '\'' +
                ", models=" + models +
                '}';
    }
}

package training.proj.mobilele.services;

import org.springframework.stereotype.Service;
import training.proj.mobilele.models.views.BrandViewModel;

import java.util.List;


public interface BrandService {
    public List<BrandViewModel> getAllBrands();
}

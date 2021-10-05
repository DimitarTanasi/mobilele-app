package training.proj.mobilele.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import training.proj.mobilele.models.entities.BrandEntity;
import training.proj.mobilele.models.entities.ModelEntity;
import training.proj.mobilele.models.views.BrandViewModel;
import training.proj.mobilele.models.views.ModelViewModel;
import training.proj.mobilele.repositories.BrandRepository;
import training.proj.mobilele.repositories.ModelRepository;
import training.proj.mobilele.services.BrandService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BrandServiceImpl implements BrandService {


    private final ModelRepository modelRepository;
    private final ModelMapper modelMapper;

    public BrandServiceImpl(ModelRepository modelRepository,
                            ModelMapper modelMapper) {

        this.modelRepository = modelRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<BrandViewModel> getAllBrands() {
//TODO:refactor
        List<BrandViewModel> resultList = new ArrayList<>();
        List<ModelEntity> allModels = modelRepository.findAll();


        allModels.forEach(me->{
            BrandEntity  brandEntity = me.getBrand();

            Optional<BrandViewModel> brandViewModelOpt = findBrandByName(resultList,brandEntity.getName());

            if (!brandViewModelOpt.isPresent()){
                BrandViewModel newBrandViewModel = new BrandViewModel();
                modelMapper.map(brandEntity,newBrandViewModel);
                resultList.add(newBrandViewModel);
                brandViewModelOpt = Optional.of(newBrandViewModel);

            }
            ModelViewModel newModelViewModel = new ModelViewModel();
            modelMapper.map(me,newModelViewModel);
            brandViewModelOpt.get().addModel(newModelViewModel);


        });
        return resultList;
    }

    private static Optional<BrandViewModel> findBrandByName(List<BrandViewModel> allBrands, String name){
        return allBrands.stream().filter(b -> b.getName().equals(name)).findAny();

    }
}

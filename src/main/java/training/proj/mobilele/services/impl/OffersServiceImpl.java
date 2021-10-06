package training.proj.mobilele.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import training.proj.mobilele.models.entities.OfferEntity;
import training.proj.mobilele.models.views.OfferSummaryViewModel;
import training.proj.mobilele.repositories.OfferRepository;
import training.proj.mobilele.services.OffersService;

import java.util.ArrayList;
import java.util.List;

@Service
public class OffersServiceImpl implements OffersService {

    OfferRepository offerRepository;
    ModelMapper modelMapper;

    public OffersServiceImpl(OfferRepository offerRepository,ModelMapper modelMapper) {
        this.offerRepository = offerRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<OfferSummaryViewModel> getAllOffers() {

        List<OfferEntity> offers = offerRepository.findAll();
        List<OfferSummaryViewModel> offerModels = new ArrayList<>();
        offers.forEach(o->{
            OfferSummaryViewModel model = new OfferSummaryViewModel();

            modelMapper.map(o,model);
            model.setBrandName(o.getModel().getBrand().getName())
                    .setModelName(o.getModel().getName());
            offerModels.add(model);
        });

        //TODO-Implement mapping
       // throw new UnsupportedOperationException("Coming Soon...");
        return offerModels;
    }
}

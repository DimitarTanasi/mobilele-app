package training.proj.mobilele;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import training.proj.mobilele.models.entities.BaseEntity;
import training.proj.mobilele.models.entities.BrandEntity;
import training.proj.mobilele.models.entities.ModelEntity;
import training.proj.mobilele.models.entities.OfferEntity;
import training.proj.mobilele.models.entities.enums.EngineEnum;
import training.proj.mobilele.models.entities.enums.ModelCategory;
import training.proj.mobilele.models.entities.enums.TransmissionEnum;
import training.proj.mobilele.repositories.BrandRepository;
import training.proj.mobilele.repositories.ModelRepository;
import training.proj.mobilele.repositories.OfferRepository;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Component
public class DbInit implements CommandLineRunner {


    private final ModelRepository modelRepository;
    private final BrandRepository brandRepository;
    private final OfferRepository offerRepository;

    public DbInit(ModelRepository modelRepository,
                  BrandRepository brandRepository, OfferRepository offerRepository) {
        this.modelRepository = modelRepository;
        this.brandRepository = brandRepository;
        this.offerRepository = offerRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        BrandEntity fordBrand = new BrandEntity();
        fordBrand.setName("Ford");
        setCurrentTimestamps(fordBrand);

        ModelEntity fiesta = new ModelEntity();
        fiesta.setCategory(ModelCategory.CAR)
                .setName("Fiesta")
                .setImageUrl("https://www.motopfohe.bg/files/news/archive/2017/08/blob-server.jpg")
                .setStartYear(1976)
                .setBrand(fordBrand);
        setCurrentTimestamps(fiesta);

        ModelEntity focus = new ModelEntity();
        focus.setCategory(ModelCategory.CAR)
                .setName("Focus")
                .setImageUrl("https://cdn.motor1.com/images/mgl/kMpqN/s1/new-ford-focus-rs-render.webp")
                .setStartYear(1998)
                .setBrand(fordBrand);
        setCurrentTimestamps(focus);


        BrandEntity hondaBrand = new BrandEntity();
        hondaBrand.setName("Honda");
        setCurrentTimestamps(hondaBrand);

        ModelEntity cbr = new ModelEntity();
        cbr.setCategory(ModelCategory.MOTORCYCLE)
                .setName("CBR")
                .setImageUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/7/79/CBR_1000_RR-R_SP_2020.jpg/630px-CBR_1000_RR-R_SP_2020.jpg")
                .setStartYear(1983)
                .setBrand(hondaBrand);
        setCurrentTimestamps(cbr);


        brandRepository.saveAll(List.of(fordBrand,hondaBrand));
        modelRepository.saveAll(List.of(fiesta,focus,cbr));
        OfferEntity fiestaOffer = new OfferEntity();
        fiestaOffer.setEngine(EngineEnum.DIESEL)
                .setImageUrl("https://media.autoexpress.co.uk/image/private/s--aTV0y29z--/v1562244738/autoexpress/2017/07/1fordfiestadiesel.jpg")
                .setMileage(80000)
                .setPrice(BigDecimal.valueOf(20000))
                .setYear(2017)
                .setDescription("Kachvash se i karash :)")
                .setTransmission(TransmissionEnum.MANUAL)
                .setModel(fiesta);
        setCurrentTimestamps(fiestaOffer);
        offerRepository.save(fiestaOffer);

    }

    private static void setCurrentTimestamps(BaseEntity baseEntity){
        baseEntity.setCreated(Instant.now());
        baseEntity.setUpdated(Instant.now());

    }
//    private void createFiestaOffer(ModelEntity model) {
//
//        OfferEntity fiestaOffer = new OfferEntity();
//        fiestaOffer.setEngine(EngineEnum.DIESEL)
//                .setImageUrl("https://media.autoexpress.co.uk/image/private/s--aTV0y29z--/v1562244738/autoexpress/2017/07/1fordfiestadiesel.jpg")
//                .setMileage(80000)
//                .setPrice(BigDecimal.valueOf(20000))
//                .setYear(2017)
//                .setDescription("Kachvash se i karash :)")
//                .setTransmission(TransmissionEnum.MANUAL)
//                .setModel(model);
//        offerRepository.save(fiestaOffer);
//    }
}
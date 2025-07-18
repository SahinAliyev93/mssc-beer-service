package guru.springframework.msscbeerservice.bootstrap;


import guru.springframework.msscbeerservice.domain.Beer;
import guru.springframework.msscbeerservice.repositories.BeerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;

@Component
public class BeerLoader implements CommandLineRunner {
    private final BeerRepository beerRepository;

    public BeerLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        loadBeerOnBootStrap();
    }

    private void loadBeerOnBootStrap() {
     if(beerRepository.count() == 0) {
         // Load Beer Data
         beerRepository.save(Beer.builder()
                 .beerName("Mango Bobs")
                 .beerStyle("IPA")
                 .upc(337000000001L)
                 .price(new BigDecimal("12.95"))
                 .build());

         beerRepository.save(Beer.builder()
                 .beerName("Galaxy Cat")
                 .beerStyle("Pale Ale")
                 .upc(337000000002L)
                 .price(new BigDecimal("11.95"))
                 .build());

         beerRepository.save(Beer.builder()
                 .beerName("Pinball Porter")
                 .beerStyle("Porter")
                 .upc(337000000003L)
                 .price(new BigDecimal("10.95"))
                 .build());
     }
    }
}

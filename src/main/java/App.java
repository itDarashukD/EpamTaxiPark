import facade.TaxiPark;

import java.util.logging.Logger;


public class App {
    private static final Logger log = Logger.getLogger(TaxiPark.class.getName());

    public static void main(String[] args) {

        log.info("IN main() : application was started");

        TaxiPark taxiPark = TaxiPark.getInstance();

        taxiPark.prepareAllData();

        //test
        taxiPark.getAll();

        taxiPark.calculateCostAllCars();

        taxiPark.findCarBySpeed() ;

        taxiPark.sortByFuelConsumption();


    }

}

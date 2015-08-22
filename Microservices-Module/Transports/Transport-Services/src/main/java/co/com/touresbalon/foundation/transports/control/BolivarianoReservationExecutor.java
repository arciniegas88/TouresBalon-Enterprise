package co.com.touresbalon.foundation.transports.control;

import co.com.touresbalon.foundation.transports.model.ReservationRequestMessage;
import co.com.touresbalon.foundation.transports.model.ReservationResponseMessage;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;

import javax.inject.Inject;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.text.SimpleDateFormat;

/**
 * Created by garciniegas on 21/08/2015.
 */

public class BolivarianoReservationExecutor implements ReservationExecutor {

    //[attributes] --------------------------

    @Inject
    private Logger logger;
    private SimpleDateFormat df = new SimpleDateFormat("ddMMyyyy");

    @Override
    public ReservationResponseMessage generateReservation(ReservationRequestMessage request) {

        ReservationResponseMessage response = new ReservationResponseMessage();
        response.setAvailable(false);

        StringBuilder csvName = new StringBuilder();
        csvName.append( System.getProperty("touresbalon.transports.bolivariano.shared_directory") )
                .append("/")
                .append("viajes_")
                .append( df.format( request.getDate() ) )
                .append(".csv");

        try {

            File csvFile = new File(csvName.toString());

            if (csvFile.exists()) {

                Reader in = new FileReader(csvFile);
                Iterable<CSVRecord> records = CSVFormat.EXCEL.withHeader().parse(in);

                for (CSVRecord record : records) {

                    System.out.print(record.get("NUM_VIAJE")+" ");
                    System.out.print(record.get("CIUDAD_ORIGEN") + " ");
                    System.out.print(record.get("CIUDAD_DESTINO")+" ");
                    System.out.print(record.get("NUM_SILLA")+" ");
                    System.out.println(record.get("HORA_SALIDA")+" ");
                }
            }else
            {
                response.setDescription("no positions available for this travel");
            }

        }catch (IOException io){
            logger.error( "an internal server error has ocurred: " + io.getMessage() );
            response.setDescription("an internal server error has ocurred");
        }

        return response;
    }
}

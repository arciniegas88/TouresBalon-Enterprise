package co.com.touresbalon.foundation.transports.infrastructure;

import co.com.touresbalon.foundation.transports.model.Reservation;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;
import org.slf4j.Logger;

import javax.cache.Cache;
import javax.cache.CacheManager;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by garciniegas on 22/08/2015.
 */

public class CSVFilesMonitor extends FileAlterationListenerAdaptor {

    private CacheManager cm;
    private Logger loggger;
    private String cacheName;

    public CSVFilesMonitor(CacheManager cm, Logger loggger, String cacheName) {
        this.cm = cm;
        this.loggger = loggger;
        this.cacheName = cacheName;
    }

    @Override
    public void onFileCreate(File file) {
        try {
            loadCSVToCache(file);
        } catch (IOException e) {
            loggger.error("BolivarianoCSVFilesMonitor - error procesing csv file");
        }
    }


    public void loadCSVToCache( File csvFile ) throws IOException{

        Cache<String, Object> cache = cm.getCache(cacheName,String.class,Object.class);
            loggger.info("csv monitor: loading file -> " + csvFile.getName());

            if (csvFile.exists()) {

            String key = csvFile.getName().replace("viajes_","").replace(".csv","");

            if ( cache.containsKey( key ) ) {
                loggger.info("csv monitor: csv file excluded by duplicate key -> " + csvFile.getName());
                return;
            }

            Reader in = new FileReader(csvFile);
            Iterable<CSVRecord> records = CSVFormat.EXCEL.withHeader().parse(in);
            List<Reservation> reservations = new ArrayList<>();

            for (CSVRecord record : records) {

                Reservation r = new Reservation();
                r.setChairNumber( record.get("NUM_SILLA")  );
                r.setOutTime(record.get("HORA_SALIDA"));
                r.setSourceCity(record.get("CIUDAD_ORIGEN"));
                r.setTargetCity(record.get("CIUDAD_DESTINO"));
                r.setTravelNumber( record.get("NUM_VIAJE") );
                reservations.add(r);
            }

            loggger.info("csv monitor: file loaded ok -> " + csvFile.getName());
            cache.put(key,reservations);
            }

    }

}

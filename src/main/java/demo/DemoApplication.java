package demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@SpringBootApplication
public class DemoApplication {

    private static Logger logger = Logger.getLogger(DemoApplication.class.getName());


    public static void main(String[] args) {


        String sourceParam = args[1];
        String targetParam = args[2];
        String fileName = args[0];

        Runnable runnable = new Runnable() {
            public void run() {

                System.out.println("********************************************");

                // lines(Path path, Charset cs)
                try (Stream<String> lines = Files.lines(Paths.get(fileName))) {
                    //@formatter:off
                    List<LogLine> filteredLines= lines.map(line -> line.split(" "))
                            .map(lineArr -> new LogLine(lineArr[0],lineArr[1],lineArr[2]))
                            .filter(logLine -> Utils.dateInRange(logLine.setLineDate())).collect(Collectors.toList());


                    System.out.println( "HOSTS RECEVING CONNECTIONS FROM " + targetParam);
                    List<String> hostsReceiving = filteredLines.stream().filter(l ->l.getDestination().equals(targetParam))
                            .map(l -> l.getSource()).distinct()
                            .collect(Collectors.toList());

                    System.out.println(hostsReceiving.toString());


                    //a list of hostnames connected to a given (configurable) host during the last hour
                    System.out.println("HOSTS CONNECTED TO " + sourceParam);

                    List<String> hostsConnected =
                            filteredLines.stream()
                            .filter(l ->l.getSource().equals(sourceParam))
                            .map(l -> l.getDestination()).distinct()
                            .collect(Collectors.toList());

                    System.out.println(hostsConnected.toString());

                    Map<String,Integer> test =filteredLines.stream().map(l -> l.getSource()).collect(Collectors.toConcurrentMap(
                            w -> w, w -> 1, Integer::sum));

                    System.out.println("HOST NAME GENERATED MOST CONNECTIONS");

                    System.out.println(test.entrySet().stream()
                            .max(Map.Entry.comparingByValue()).get().toString());



                }
                catch (IOException e)
                {
                    //TODO
                    System.out.println("Handle error");
                }

            }
        };

        ScheduledExecutorService service = Executors
                .newSingleThreadScheduledExecutor();
        service.scheduleAtFixedRate(runnable, 0, 10, TimeUnit.SECONDS);


    }
}

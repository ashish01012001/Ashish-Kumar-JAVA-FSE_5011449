package Week5.bookstoreapi.src.main.java.com.example.bookstoreapi.metrics;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class CustomMetrics {

    private final MeterRegistry meterRegistry;

    public CustomMetrics(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
    }

    @PostConstruct
    public void init() {
        meterRegistry.counter("custom.bookstore.book.additions").increment(0);
        meterRegistry.gauge("custom.bookstore.book.count", this, CustomMetrics::countBooks);
    }

    public void incrementBookAdditions() {
        meterRegistry.counter("custom.bookstore.book.additions").increment();
    }

    public double countBooks() {
        // Replace with actual logic to count the books
        return 100; // Example value
    }
}

import java.util.ArrayList;
import java.util.List;

public record Moedas(
ConversionRate conversion_rates
) {
    @Override
    public String toString() {
        return ""+conversion_rates;

    }
}

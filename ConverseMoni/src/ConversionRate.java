import static java.lang.Integer.parseInt;

public record ConversionRate (
        String USD,
        String EUR,
        String GBP,
        String JPY,
        String AUD,
        String CHF,
        String CAD,
        String BRL)
{
    @Override
    public String toString() {
        return "Dólar Americano(USD)= " +USD+
                "\nEuro(EUR)= " + EUR +
                "\nReal(BRL)= " + BRL +
                "\nLibra esterlina(GBP)= " + GBP +
                "\nIene(JPY)= " + JPY +
                "\nDólar Australiano(AUD)= " + AUD +
                "\nFranco Suíço(CHF)= " + CHF +
                "\nDólar Canadense(CAD)=" + CAD;
    }
}


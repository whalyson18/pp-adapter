public class Principal2{
    public static void main(String[] args) {
        System.out.println(new AlphaVantageAdapter().getCotacao("INTL"));
        System.out.println(new YahooAdapter().getCotacao("MGLU3.SA"));
        System.out.println(new QuandlAdapter().getCotacao("WIKI/AAPL"));
    }
}

public class Principal2{
    public static void main(String[] args) {

        ServicoCotacao cotacao = new YahooAdapter();
        System.out.println(cotacao.getCotacao("CMIG4.SA"));

        cotacao = new AlphaVantageAdapter();
        System.out.println(cotacao.getCotacao("INTL"));

        cotacao = new QuandlAdapter();
        System.out.println(cotacao.getCotacao("WIKI/AAPL"));
        //System.out.println(new AlphaVantageAdapter().getCotacao("INTL"));
        //System.out.println(new YahooAdapter().getCotacao("MGLU3.SA"));
        //System.out.println(new QuandlAdapter().getCotacao("WIKI/AAPL"));
    }
}

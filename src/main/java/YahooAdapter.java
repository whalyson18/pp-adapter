import io.github.mainstringargs.yahooFinance.YahooFinanceModules;
import io.github.mainstringargs.yahooFinance.YahooFinanceRequest;
import io.github.mainstringargs.yahooFinance.YahooFinanceUrlBuilder;

public class YahooAdapter implements ServicoCotacao {

    @Override
    public double getCotacao(String codEmpresa) {
        System.out.printf("Cotação da Empresa %s pelo serviço Yahoo Finance: https://finance.yahoo.com%n", codEmpresa);
        var builder =
                new YahooFinanceUrlBuilder().modules(YahooFinanceModules.values()).symbol(codEmpresa);

        var request = new YahooFinanceRequest();
        var financeData = request.getFinanceData(request.invoke(builder));

        var financialData = financeData.getFinancialData();
        if (financialData == null)
            System.err.printf("Não foi possível obter a cotação para a empresa %s%n", codEmpresa);

        return financialData.getCurrentPrice().getRaw().doubleValue();
    }
}

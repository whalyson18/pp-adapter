import com.jimmoores.quandl.DataSetRequest;
import com.jimmoores.quandl.Row;
import com.jimmoores.quandl.classic.ClassicQuandlSession;

import java.time.format.DateTimeFormatter;

public class QuandlAdapter implements ServicoCotacao {
    @Override
    public double getCotacao(String codEmpresa) {
        System.out.printf("Cotação da Empresa %s pelo serviço Quandl: http://quandl.com/%n", codEmpresa);
        var session = ClassicQuandlSession.create();
        var request = DataSetRequest.Builder
                .of(codEmpresa)
                .withMaxRows(1)
                .build();
        var tabularResult = session.getDataSet(request);
        if (tabularResult.size() == 0){
            System.err.printf("Não foi possível obter a cotação para a empresa %s%n", codEmpresa);
            return 0;
        }
        else {
            Row row = tabularResult.get(0);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String date = formatter.format(row.getLocalDate("Date"));
            System.out.printf("Data: %s Preço: %s%n", date, row.getDouble("Close"));
            return row.getDouble("Close");
        }
    }
}

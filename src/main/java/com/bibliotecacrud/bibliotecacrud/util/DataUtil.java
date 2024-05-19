package com.bibliotecacrud.bibliotecacrud.util;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class DataUtil {
    public static Date dataParaEntrega(){
       LocalDate dataAtual = LocalDate.now();
       LocalDate dataEntrega = dataAtual.plusDays(6);

        return Date.from(dataEntrega.atStartOfDay(ZoneId.systemDefault()).toInstant());

    }
}

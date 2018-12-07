package utilities;

import java.sql.Date;
import java.time.DateTimeException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * Providencia uma forma de utilizar a API LocalDate, mais completa, e mapear
 * num formato apropriado a BD.
 * 
 * @author Diogo Sousa
 *
 */
@Converter(autoApply = true)
public class DateUtils implements AttributeConverter<LocalDate, Date> {

    /**
     * Padrao utilizado pela data (YY-MM-DD).
     */
    private static final String DATE_PATTERN = "yy/MM/dd";
    /**
     * Como as duracoes sao inclusive, requer subtrair um dia quando usando o
     * plus().
     */
    private static final long INCLUSIVE = -1;
    /**
     * Permite formatar a data.
     */
    private static final DateTimeFormatter style = DateTimeFormatter.ofPattern(DATE_PATTERN);

    @Override
    public Date convertToDatabaseColumn(LocalDate data) {
        return Date.valueOf(data);
    }

    @Override
    public LocalDate convertToEntityAttribute(Date sqlDate) {
        return sqlDate.toLocalDate();
    }

    /**
     * Valida se uma data de inicio cumpre com os criterios definidos para um
     * torneio de equipa.
     * 
     * @param data
     *            - A data inicial do torneio.
     * @param duracao
     *            - A duracao do torneio, em dias.
     * @return true, se o torneio dura pelo menos dois dias e apanha um
     *         fim-de-semana.
     */
    public static boolean validaData(LocalDate data, int duracao) {
        if (duracao < 2)
            return false;
        /* Se durar uma semana, garantidamente apanha um fim-de-semana */
        if (duracao >= 7) {
            return true;
        }
        /* Para apanhar um fim-de-semana defina-se pelo menos Sabado */
        DayOfWeek startDay = data.getDayOfWeek();
        int index = startDay.getValue();
        /*
         * Se Segunda (1) tem de durar 6 dias, se Terca (2) tem de durar 5, etc.
         */
        return duracao >= (7 - index);
    }

    /**
     * Valida de existe sobreposicao de datas. Como a duracao eh inclusive,
     * subtrai-se um dia.
     * 
     * @param dataInicio
     *            - A data inicial do evento.
     * @param duracao
     *            - A duracao em dias.
     * @param inicioTorneio
     *            - O inicio do outro torneio.
     * @param duracaoTorn
     *            - a Duracao do outro torneio.
     * @return true, se os intervalos se sobrepoe.
     */
    public static boolean existeIntersecao(LocalDate dataInicio, int duracao,
            LocalDate inicioTorneio, int duracaoTorn) {
        LocalDate dataFim = dataInicio.plusDays(duracao + INCLUSIVE);
        LocalDate fimTorneio = inicioTorneio.plusDays(duracaoTorn + INCLUSIVE);
        return ((dataFim.isAfter(inicioTorneio) || dataFim.isEqual(inicioTorneio))
                && (dataInicio.isBefore(fimTorneio) || dataInicio.isEqual(fimTorneio)));
    }

    /**
     * Formata uma data no formato yy/MM/dd
     * 
     * @param data
     *            - a data a formatar
     * @return a String no formato especificado.
     * @requires data != null;
     */
    public static String format(LocalDate data) {
        return data.format(style);
    }

    /**
     * Parses a String in the yy/MM/dd format to a LocalDate.
     * 
     * @param data
     *            - a String a formatar.
     * @return a Data local ou null, caso seja invalida.
     */
    public static LocalDate parseDate(int dia, int mes, int ano) {
        try {
            return LocalDate.of(ano, mes, dia );
        } catch (DateTimeException e) {
            return null;
        }
    }

}

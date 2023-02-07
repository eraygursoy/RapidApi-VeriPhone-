package Utils;

/**
 * @Author Eray Gürsoy
 */
public class VeriPhoneUtils {

    //TODO: https://veriphone.p.rapidapi.com/verify?phone=05368401740
    public static final String ENDPOINT_URL_VERIFY = "https://veriphone.p.rapidapi.com/verify?phone=/";

    //TODO: https://veriphone.p.rapidapi.com/example?country_code=TR&type=mobile
    public static final String ENDPOINT_URL_EXAMPLE = "https://veriphone.p.rapidapi.com/example?";

    public static final String HEADER_KEY = "X-RapidAPI-Key";
    public static final String HEADER_KEY_VALUE = "cc85335a12msh9c0da795849a181p1fb8cfjsn5c966012c39d";
    public static final String HEADER_HOST = "X-RapidAPI-Host";
    public static final String HEADER_HOST_VALUE = "veriphone.p.rapidapi.com";

}

package veriphone;

import Utils.VeriPhoneUtils;
import com.google.gson.Gson;
import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.stream.Collectors;

/**
 * @Author Eray Gürsoy
 */
public class Client {

    public VerifyResponseDto getVerifyPhoneNumber(String phoneNumber) {

        VerifyResponseDto exampleResponseDto = null;

        try {

            String endpointUrlVerify = VeriPhoneUtils.ENDPOINT_URL_VERIFY;

            HttpURLConnection connection = createConnection(endpointUrlVerify + phoneNumber);

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader((connection.getInputStream())));

            String responseAsStr = bufferedReader.lines().collect(Collectors.joining());

            Gson gson = new Gson();
            exampleResponseDto = gson.fromJson(responseAsStr, VerifyResponseDto.class);

            connection.disconnect();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return exampleResponseDto;
    }

    public ExampleResponseDto getExamplePhoneByCountryCodeAndType(String countryCodeAsParameter, String typeAsParameter) {

        ExampleResponseDto exampleResponseDto = null;

        StringBuilder url = new StringBuilder();
        url.append(VeriPhoneUtils.ENDPOINT_URL_EXAMPLE);

        if (StringUtils.hasText(countryCodeAsParameter)) {
            url.append("country_code=").append(countryCodeAsParameter);
        }

        if (StringUtils.hasText(typeAsParameter)) {
            url.append("&type=").append(typeAsParameter);
        }

        try {
            HttpURLConnection connection = createConnection(url.toString());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader((connection.getInputStream())));

            String responseAsStr = bufferedReader.lines().collect(Collectors.joining());

            Gson gson = new Gson();
            exampleResponseDto = gson.fromJson(responseAsStr, ExampleResponseDto.class);
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return exampleResponseDto;
    }

    private HttpURLConnection createConnection(String urlAsStr) {

        HttpURLConnection httpURLConnection = null;

        try {
            URL url = new URL(urlAsStr);

            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("Accept", "application/json");
            httpURLConnection.setRequestProperty(VeriPhoneUtils.HEADER_KEY, VeriPhoneUtils.HEADER_KEY_VALUE);
            httpURLConnection.setRequestProperty(VeriPhoneUtils.HEADER_HOST, VeriPhoneUtils.HEADER_HOST_VALUE);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return httpURLConnection;
    }
}

package stringcalculator.domain.Delimiter;

import stringcalculator.exception.ExtractCustomDelimiterException;
import stringcalculator.exception.IllegalCustomDelimiterException;
import stringcalculator.exception.IllegalCustomDelimiterPositionException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static stringcalculator.Utils.isNumeric;

public class CustomDelimiter implements Delimiter {
    private static final String FORMAT = "//(.)" + System.lineSeparator() + "(.*)";
    private static final Pattern PATTERN = Pattern.compile(FORMAT);
    private final String delimiter;

    private CustomDelimiter(String input) {
        validateCustomDelimiterPosition(input);

        String delimiter = extractCustomDelimiter(input);

        validateNumericDelimiter(delimiter);

        this.delimiter = Pattern.quote(delimiter);
    }

    public static CustomDelimiter valueOf(String input) {
        return new CustomDelimiter(input);
    }

    public static boolean isSupport(String input) {
        return PATTERN.matcher(input).find();
    }

    private void validateCustomDelimiterPosition(String input) {
        Matcher matcher = PATTERN.matcher(input);

        if (matcher.find() && matcher.start() == 0) {
            return;
        }

        throw new IllegalCustomDelimiterPositionException();
    }

    private String extractCustomDelimiter(String input) {
        Matcher matcher = PATTERN.matcher(input);

        if (matcher.find()) {
            return matcher.group(1);
        }

        throw new ExtractCustomDelimiterException();
    }

    private void validateNumericDelimiter(String delimiter) {
        if (isNumeric(delimiter)) {
            throw new IllegalCustomDelimiterException();
        }
    }

    @Override
    public String[] split(String input) {
        return input.split(delimiter);
    }
}
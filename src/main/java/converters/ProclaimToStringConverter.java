
package converters;

import org.springframework.core.convert.converter.Converter;

import domain.Proclaim;

public class ProclaimToStringConverter implements Converter<Proclaim, String> {

	@Override
	public String convert(final Proclaim source) {
		String result;

		if (source == null)
			result = null;
		else
			result = String.valueOf(source.getId());
		return result;

	}

}

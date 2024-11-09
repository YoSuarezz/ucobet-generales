package co.edu.uco.ucobet.generales.domain.city.rules.impl;

import co.edu.uco.ucobet.generales.domain.city.exceptions.CityNameLengthIsNotValidException;
import co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.messages.MessageCatalog;
import co.edu.uco.ucobet.generales.domain.city.rules.CityNameLenghtIsValidRule;
import org.springframework.stereotype.Service;

@Service
public class CityNameLengthIsValidRuleImpl implements CityNameLenghtIsValidRule {

	private static final int MIN_NAME_LENGTH = 3;
	private static final int MAX_NAME_LENGTH = 40;
	private final MessageCatalog messageCatalog;

    public CityNameLengthIsValidRuleImpl(MessageCatalog messageCatalog) {
        this.messageCatalog = messageCatalog;
    }

    @Override
	public void validate(String data) {
		if (data.length() < MIN_NAME_LENGTH || data.length() > MAX_NAME_LENGTH) {
			throw CityNameLengthIsNotValidException.create(messageCatalog);
		}
	}
}

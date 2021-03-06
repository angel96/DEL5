
package forms;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.SafeHtml;
import org.hibernate.validator.constraints.URL;

public class CustomForm {

	private String	systemName;
	private String	banner;
	private String	message;
	private String	spamwordsEnglish;
	private String	spamwordsSpanish;
	private Integer	hoursFinder;
	private Integer	resultFinder;
	private String	phonePrefix;
	private String	creditCardMakes;


	@NotBlank
	@SafeHtml
	public String getSystemName() {
		return this.systemName;
	}

	public void setSystemName(final String systemName) {
		this.systemName = systemName;
	}
	@NotBlank
	@URL
	public String getBanner() {
		return this.banner;
	}

	public void setBanner(final String banner) {
		this.banner = banner;
	}
	@NotBlank
	@SafeHtml
	public String getMessage() {
		return this.message;
	}

	public void setMessage(final String message) {
		this.message = message;
	}
	@NotBlank
	@SafeHtml
	public String getSpamwordsEnglish() {
		return this.spamwordsEnglish;
	}

	public void setSpamwordsEnglish(final String spamwordsEnglish) {
		this.spamwordsEnglish = spamwordsEnglish;
	}
	@NotBlank
	@SafeHtml
	public String getSpamwordsSpanish() {
		return this.spamwordsSpanish;
	}

	public void setSpamwordsSpanish(final String spamwordsSpanish) {
		this.spamwordsSpanish = spamwordsSpanish;
	}

	@Range(min = 1, max = 24)
	public Integer getHoursFinder() {
		return this.hoursFinder;
	}

	public void setHoursFinder(final Integer hoursFinder) {
		this.hoursFinder = hoursFinder;
	}
	@Range(min = 10, max = 100)
	public Integer getResultFinder() {
		return this.resultFinder;
	}

	public void setResultFinder(final Integer resultFinder) {
		this.resultFinder = resultFinder;
	}

	@NotBlank
	@SafeHtml
	public String getPhonePrefix() {
		return this.phonePrefix;
	}

	public void setPhonePrefix(final String phonePrefix) {
		this.phonePrefix = phonePrefix;
	}

	@NotBlank
	@SafeHtml
	public String getCreditCardMakes() {
		return this.creditCardMakes;
	}

	public void setCreditCardMakes(final String creditCardMakes) {
		this.creditCardMakes = creditCardMakes;
	}
}

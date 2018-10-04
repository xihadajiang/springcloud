package com.inspur.incloud.log.util;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;

import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

public class OperateLogCodeMessageUtil {
	
	private static MessageSource messageSource;
	/** The provider locale. */
    private static List<Locale> providerLocale = new ArrayList<Locale>();

	private static MessageSource initMessageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename(OperateLogCodeMessageConfig.getBasename());
		messageSource.setDefaultEncoding(OperateLogCodeMessageConfig.getEncoding());
		return messageSource;
	}

	public static String getMessage(String code, Object[] params, String lang) {
		if (null == messageSource) {
			messageSource = initMessageSource();
		}
		Locale locale = null;
		if ("en_US".equals(lang)) {
			locale = Locale.US;
		} else if ("zh_CN".equals(lang)) {
			locale = Locale.SIMPLIFIED_CHINESE;
		} else {
			locale = Locale.getDefault();
		}
		String result = null;
		try {
			if (null != params){
				result = messageSource.getMessage(code, params, locale);
			} else {
				result = messageSource.getMessage(code, null, locale);
			}
			
		} catch (NoSuchMessageException e) {
			return null;
		}
		
		return result;

	}
	/**
     * The Class LockUtilHolder.
     */
    private static class LocaleProviderUtilHolder {
        /** The instance. */
        static OperateLogCodeMessageUtil instance = new OperateLogCodeMessageUtil();

    }

    /**
     * Gets the single instance of LocaleProviderUtil.
     * @return single instance of LocaleProviderUtil
     */
    private static OperateLogCodeMessageUtil getInstance() {

        return LocaleProviderUtilHolder.instance;

    }
    /**
     * Instantiates a new locale provider util.
     */
    private OperateLogCodeMessageUtil() {
        Locale[] locales = Locale.getAvailableLocales();
        if (null == providerLocale || providerLocale.size() <= 0) {
            for (Locale locale : locales) {
                try {
                    URL localeUrl = OperateLogCodeMessageUtil.class.getClassLoader().getResource(
                            toBundleName(OperateLogCodeMessageConfig.getBasename(), locale));
                    if (null != localeUrl) {
                        providerLocale.add(locale);
                    }
                } catch (MissingResourceException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Gets the provider locale.
     * @return the provider locale
     */
    public static List<Locale> getProviderLocale() {
        return OperateLogCodeMessageUtil.getInstance().providerLocale;
    }

    /**
     * To bundle name.
     * @param paramString
     *            the param string
     * @param paramLocale
     *            the param locale
     * @return the string
     */
    private static String toBundleName(String paramString, Locale paramLocale) {
        if (paramLocale == Locale.ROOT) {
            return paramString;
        }
        String str1 = paramLocale.getLanguage();
        String str2 = paramLocale.getCountry();
        String str3 = paramLocale.getVariant();
        if (("".equals(str1) ) && ("".equals(str2) ) && ("".equals(str3) )) {
            return paramString;
        }
        StringBuilder localStringBuilder = new StringBuilder(paramString);
        localStringBuilder.append('_');
        if (!"".equals(str3)) {
            localStringBuilder.append(str1).append('_').append(str2).append('_').append(str3);
        } else if (!"".equals(str2)) {
            localStringBuilder.append(str1).append('_').append(str2);
        } else {
            localStringBuilder.append(str1);
        }
        localStringBuilder.append(".properties");
        return localStringBuilder.toString();
    }

}

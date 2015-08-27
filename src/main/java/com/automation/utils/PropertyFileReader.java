package com.automation.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


// TODO: Auto-generated Javadoc
/**
 * The Class PropertyFileReader.
 */
public class PropertyFileReader {
	/** The property file name. */
	private String propFileName;

	/** The property object. */
	private Properties properties;

	/**
	 * Instantiates a new property reader.
	 *
	 * @param propertyFile
	 *            the property file
	 */
	public PropertyFileReader(final String propertyFile) {
		propFileName = propertyFile;
		loadProperty();
	}


	/**
	 * Gets the property.
	 *
	 * @param key the key
	 * @return the property
	 */
	public String getProperty(String key) {
		
		String value = properties.getProperty(key);
		return value;
	}
	
	/**
	 * Loads the property file.
	 */
	private final void loadProperty() {

		InputStream is = null;

		try {
			is = this.getClass().getResourceAsStream(propFileName);
			properties = new Properties();
			properties.load(is);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

}

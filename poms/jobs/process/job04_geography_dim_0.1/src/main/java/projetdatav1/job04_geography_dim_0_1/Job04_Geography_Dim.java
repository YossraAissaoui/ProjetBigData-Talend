// ============================================================================
//
// Copyright (c) 2006-2015, Talend SA
//
// Ce code source a été automatiquement généré par_Talend Open Studio for Data Integration
// / Soumis à la Licence Apache, Version 2.0 (la "Licence") ;
// votre utilisation de ce fichier doit respecter les termes de la Licence.
// Vous pouvez obtenir une copie de la Licence sur
// http://www.apache.org/licenses/LICENSE-2.0
// 
// Sauf lorsqu'explicitement prévu par la loi en vigueur ou accepté par écrit, le logiciel
// distribué sous la Licence est distribué "TEL QUEL",
// SANS GARANTIE OU CONDITION D'AUCUNE SORTE, expresse ou implicite.
// Consultez la Licence pour connaître la terminologie spécifique régissant les autorisations et
// les limites prévues par la Licence.

package projetdatav1.job04_geography_dim_0_1;

import routines.Numeric;
import routines.DataOperation;
import routines.TalendDataGenerator;
import routines.TalendStringUtil;
import routines.TalendString;
import routines.StringHandling;
import routines.Relational;
import routines.TalendDate;
import routines.Mathematical;
import routines.system.*;
import routines.system.api.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.Comparator;

@SuppressWarnings("unused")

/**
 * Job: Job04_Geography_Dim Purpose: <br>
 * Description: <br>
 * 
 * @author user@talend.com
 * @version 8.0.1.20211109_1610
 * @status
 */
public class Job04_Geography_Dim implements TalendJob {

	protected static void logIgnoredError(String message, Throwable cause) {
		System.err.println(message);
		if (cause != null) {
			cause.printStackTrace();
		}

	}

	public final Object obj = new Object();

	// for transmiting parameters purpose
	private Object valueObject = null;

	public Object getValueObject() {
		return this.valueObject;
	}

	public void setValueObject(Object valueObject) {
		this.valueObject = valueObject;
	}

	private final static String defaultCharset = java.nio.charset.Charset.defaultCharset().name();

	private final static String utf8Charset = "UTF-8";

	// contains type for every context property
	public class PropertiesWithType extends java.util.Properties {
		private static final long serialVersionUID = 1L;
		private java.util.Map<String, String> propertyTypes = new java.util.HashMap<>();

		public PropertiesWithType(java.util.Properties properties) {
			super(properties);
		}

		public PropertiesWithType() {
			super();
		}

		public void setContextType(String key, String type) {
			propertyTypes.put(key, type);
		}

		public String getContextType(String key) {
			return propertyTypes.get(key);
		}
	}

	// create and load default properties
	private java.util.Properties defaultProps = new java.util.Properties();

	// create application properties with default
	public class ContextProperties extends PropertiesWithType {

		private static final long serialVersionUID = 1L;

		public ContextProperties(java.util.Properties properties) {
			super(properties);
		}

		public ContextProperties() {
			super();
		}

		public void synchronizeContext() {

			if (Connect_Data_Password != null) {

				this.setProperty("Connect_Data_Password", Connect_Data_Password.toString());

			}

			if (Connect_Data_Login != null) {

				this.setProperty("Connect_Data_Login", Connect_Data_Login.toString());

			}

			if (Connect_Data_AdditionalParams != null) {

				this.setProperty("Connect_Data_AdditionalParams", Connect_Data_AdditionalParams.toString());

			}

			if (Connect_Data_File != null) {

				this.setProperty("Connect_Data_File", Connect_Data_File.toString());

			}

		}

		// if the stored or passed value is "<TALEND_NULL>" string, it mean null
		public String getStringValue(String key) {
			String origin_value = this.getProperty(key);
			if (NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY.equals(origin_value)) {
				return null;
			}
			return origin_value;
		}

		public java.lang.String Connect_Data_Password;

		public java.lang.String getConnect_Data_Password() {
			return this.Connect_Data_Password;
		}

		public String Connect_Data_Login;

		public String getConnect_Data_Login() {
			return this.Connect_Data_Login;
		}

		public String Connect_Data_AdditionalParams;

		public String getConnect_Data_AdditionalParams() {
			return this.Connect_Data_AdditionalParams;
		}

		public String Connect_Data_File;

		public String getConnect_Data_File() {
			return this.Connect_Data_File;
		}

	}

	protected ContextProperties context = new ContextProperties(); // will be instanciated by MS.

	public ContextProperties getContext() {
		return this.context;
	}

	private final String jobVersion = "0.1";
	private final String jobName = "Job04_Geography_Dim";
	private final String projectName = "PROJETDATAV1";
	public Integer errorCode = null;
	private String currentComponent = "";

	private final java.util.Map<String, Object> globalMap = new java.util.HashMap<String, Object>();
	private final static java.util.Map<String, Object> junitGlobalMap = new java.util.HashMap<String, Object>();

	private final java.util.Map<String, Long> start_Hash = new java.util.HashMap<String, Long>();
	private final java.util.Map<String, Long> end_Hash = new java.util.HashMap<String, Long>();
	private final java.util.Map<String, Boolean> ok_Hash = new java.util.HashMap<String, Boolean>();
	public final java.util.List<String[]> globalBuffer = new java.util.ArrayList<String[]>();

	private RunStat runStat = new RunStat();

	// OSGi DataSource
	private final static String KEY_DB_DATASOURCES = "KEY_DB_DATASOURCES";

	private final static String KEY_DB_DATASOURCES_RAW = "KEY_DB_DATASOURCES_RAW";

	public void setDataSources(java.util.Map<String, javax.sql.DataSource> dataSources) {
		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		for (java.util.Map.Entry<String, javax.sql.DataSource> dataSourceEntry : dataSources.entrySet()) {
			talendDataSources.put(dataSourceEntry.getKey(),
					new routines.system.TalendDataSource(dataSourceEntry.getValue()));
		}
		globalMap.put(KEY_DB_DATASOURCES, talendDataSources);
		globalMap.put(KEY_DB_DATASOURCES_RAW, new java.util.HashMap<String, javax.sql.DataSource>(dataSources));
	}

	public void setDataSourceReferences(List serviceReferences) throws Exception {

		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		java.util.Map<String, javax.sql.DataSource> dataSources = new java.util.HashMap<String, javax.sql.DataSource>();

		for (java.util.Map.Entry<String, javax.sql.DataSource> entry : BundleUtils
				.getServices(serviceReferences, javax.sql.DataSource.class).entrySet()) {
			dataSources.put(entry.getKey(), entry.getValue());
			talendDataSources.put(entry.getKey(), new routines.system.TalendDataSource(entry.getValue()));
		}

		globalMap.put(KEY_DB_DATASOURCES, talendDataSources);
		globalMap.put(KEY_DB_DATASOURCES_RAW, new java.util.HashMap<String, javax.sql.DataSource>(dataSources));
	}

	private final java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
	private final java.io.PrintStream errorMessagePS = new java.io.PrintStream(new java.io.BufferedOutputStream(baos));

	public String getExceptionStackTrace() {
		if ("failure".equals(this.getStatus())) {
			errorMessagePS.flush();
			return baos.toString();
		}
		return null;
	}

	private Exception exception;

	public Exception getException() {
		if ("failure".equals(this.getStatus())) {
			return this.exception;
		}
		return null;
	}

	private class TalendException extends Exception {

		private static final long serialVersionUID = 1L;

		private java.util.Map<String, Object> globalMap = null;
		private Exception e = null;
		private String currentComponent = null;
		private String virtualComponentName = null;

		public void setVirtualComponentName(String virtualComponentName) {
			this.virtualComponentName = virtualComponentName;
		}

		private TalendException(Exception e, String errorComponent, final java.util.Map<String, Object> globalMap) {
			this.currentComponent = errorComponent;
			this.globalMap = globalMap;
			this.e = e;
		}

		public Exception getException() {
			return this.e;
		}

		public String getCurrentComponent() {
			return this.currentComponent;
		}

		public String getExceptionCauseMessage(Exception e) {
			Throwable cause = e;
			String message = null;
			int i = 10;
			while (null != cause && 0 < i--) {
				message = cause.getMessage();
				if (null == message) {
					cause = cause.getCause();
				} else {
					break;
				}
			}
			if (null == message) {
				message = e.getClass().getName();
			}
			return message;
		}

		@Override
		public void printStackTrace() {
			if (!(e instanceof TalendException || e instanceof TDieException)) {
				if (virtualComponentName != null && currentComponent.indexOf(virtualComponentName + "_") == 0) {
					globalMap.put(virtualComponentName + "_ERROR_MESSAGE", getExceptionCauseMessage(e));
				}
				globalMap.put(currentComponent + "_ERROR_MESSAGE", getExceptionCauseMessage(e));
				System.err.println("Exception in component " + currentComponent + " (" + jobName + ")");
			}
			if (!(e instanceof TDieException)) {
				if (e instanceof TalendException) {
					e.printStackTrace();
				} else {
					e.printStackTrace();
					e.printStackTrace(errorMessagePS);
					Job04_Geography_Dim.this.exception = e;
				}
			}
			if (!(e instanceof TalendException)) {
				try {
					for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
						if (m.getName().compareTo(currentComponent + "_error") == 0) {
							m.invoke(Job04_Geography_Dim.this, new Object[] { e, currentComponent, globalMap });
							break;
						}
					}

					if (!(e instanceof TDieException)) {
					}
				} catch (Exception e) {
					this.e.printStackTrace();
				}
			}
		}
	}

	public void tDBInput_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tMap_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBOutput_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBInput_2_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBInput_3_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBInput_4_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBInput_5_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBInput_7_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBInput_8_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tAdvancedHash_row2_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tAdvancedHash_row3_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tAdvancedHash_row4_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tAdvancedHash_row6_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tAdvancedHash_row7_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tAdvancedHash_row8_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBInput_1_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public static class Geography_Dim_OutputStruct
			implements routines.system.IPersistableRow<Geography_Dim_OutputStruct> {
		final static byte[] commonByteArrayLock_PROJETDATAV1_Job04_Geography_Dim = new byte[0];
		static byte[] commonByteArray_PROJETDATAV1_Job04_Geography_Dim = new byte[0];
		protected static final int DEFAULT_HASHCODE = 1;
		protected static final int PRIME = 31;
		protected int hashCode = DEFAULT_HASHCODE;
		public boolean hashCodeDirty = true;

		public String loopKey;

		public Double Street_ID;

		public Double getStreet_ID() {
			return this.Street_ID;
		}

		public String Continent;

		public String getContinent() {
			return this.Continent;
		}

		public String Country;

		public String getCountry() {
			return this.Country;
		}

		public String State_Code;

		public String getState_Code() {
			return this.State_Code;
		}

		public String State;

		public String getState() {
			return this.State;
		}

		public String Region;

		public String getRegion() {
			return this.Region;
		}

		public String Province;

		public String getProvince() {
			return this.Province;
		}

		public String County;

		public String getCounty() {
			return this.County;
		}

		public String City;

		public String getCity() {
			return this.City;
		}

		public String Postal_Code;

		public String getPostal_Code() {
			return this.Postal_Code;
		}

		public String Street_Name;

		public String getStreet_Name() {
			return this.Street_Name;
		}

		@Override
		public int hashCode() {
			if (this.hashCodeDirty) {
				final int prime = PRIME;
				int result = DEFAULT_HASHCODE;

				result = prime * result + ((this.Street_ID == null) ? 0 : this.Street_ID.hashCode());

				this.hashCode = result;
				this.hashCodeDirty = false;
			}
			return this.hashCode;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			final Geography_Dim_OutputStruct other = (Geography_Dim_OutputStruct) obj;

			if (this.Street_ID == null) {
				if (other.Street_ID != null)
					return false;

			} else if (!this.Street_ID.equals(other.Street_ID))

				return false;

			return true;
		}

		public void copyDataTo(Geography_Dim_OutputStruct other) {

			other.Street_ID = this.Street_ID;
			other.Continent = this.Continent;
			other.Country = this.Country;
			other.State_Code = this.State_Code;
			other.State = this.State;
			other.Region = this.Region;
			other.Province = this.Province;
			other.County = this.County;
			other.City = this.City;
			other.Postal_Code = this.Postal_Code;
			other.Street_Name = this.Street_Name;

		}

		public void copyKeysDataTo(Geography_Dim_OutputStruct other) {

			other.Street_ID = this.Street_ID;

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_PROJETDATAV1_Job04_Geography_Dim.length) {
					if (length < 1024 && commonByteArray_PROJETDATAV1_Job04_Geography_Dim.length == 0) {
						commonByteArray_PROJETDATAV1_Job04_Geography_Dim = new byte[1024];
					} else {
						commonByteArray_PROJETDATAV1_Job04_Geography_Dim = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_PROJETDATAV1_Job04_Geography_Dim, 0, length);
				strReturn = new String(commonByteArray_PROJETDATAV1_Job04_Geography_Dim, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_PROJETDATAV1_Job04_Geography_Dim.length) {
					if (length < 1024 && commonByteArray_PROJETDATAV1_Job04_Geography_Dim.length == 0) {
						commonByteArray_PROJETDATAV1_Job04_Geography_Dim = new byte[1024];
					} else {
						commonByteArray_PROJETDATAV1_Job04_Geography_Dim = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_PROJETDATAV1_Job04_Geography_Dim, 0, length);
				strReturn = new String(commonByteArray_PROJETDATAV1_Job04_Geography_Dim, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_PROJETDATAV1_Job04_Geography_Dim) {

				try {

					int length = 0;

					length = dis.readByte();
					if (length == -1) {
						this.Street_ID = null;
					} else {
						this.Street_ID = dis.readDouble();
					}

					this.Continent = readString(dis);

					this.Country = readString(dis);

					this.State_Code = readString(dis);

					this.State = readString(dis);

					this.Region = readString(dis);

					this.Province = readString(dis);

					this.County = readString(dis);

					this.City = readString(dis);

					this.Postal_Code = readString(dis);

					this.Street_Name = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_PROJETDATAV1_Job04_Geography_Dim) {

				try {

					int length = 0;

					length = dis.readByte();
					if (length == -1) {
						this.Street_ID = null;
					} else {
						this.Street_ID = dis.readDouble();
					}

					this.Continent = readString(dis);

					this.Country = readString(dis);

					this.State_Code = readString(dis);

					this.State = readString(dis);

					this.Region = readString(dis);

					this.Province = readString(dis);

					this.County = readString(dis);

					this.City = readString(dis);

					this.Postal_Code = readString(dis);

					this.Street_Name = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// Double

				if (this.Street_ID == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this.Street_ID);
				}

				// String

				writeString(this.Continent, dos);

				// String

				writeString(this.Country, dos);

				// String

				writeString(this.State_Code, dos);

				// String

				writeString(this.State, dos);

				// String

				writeString(this.Region, dos);

				// String

				writeString(this.Province, dos);

				// String

				writeString(this.County, dos);

				// String

				writeString(this.City, dos);

				// String

				writeString(this.Postal_Code, dos);

				// String

				writeString(this.Street_Name, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// Double

				if (this.Street_ID == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this.Street_ID);
				}

				// String

				writeString(this.Continent, dos);

				// String

				writeString(this.Country, dos);

				// String

				writeString(this.State_Code, dos);

				// String

				writeString(this.State, dos);

				// String

				writeString(this.Region, dos);

				// String

				writeString(this.Province, dos);

				// String

				writeString(this.County, dos);

				// String

				writeString(this.City, dos);

				// String

				writeString(this.Postal_Code, dos);

				// String

				writeString(this.Street_Name, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("Street_ID=" + String.valueOf(Street_ID));
			sb.append(",Continent=" + Continent);
			sb.append(",Country=" + Country);
			sb.append(",State_Code=" + State_Code);
			sb.append(",State=" + State);
			sb.append(",Region=" + Region);
			sb.append(",Province=" + Province);
			sb.append(",County=" + County);
			sb.append(",City=" + City);
			sb.append(",Postal_Code=" + Postal_Code);
			sb.append(",Street_Name=" + Street_Name);
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(Geography_Dim_OutputStruct other) {

			int returnValue = -1;

			returnValue = checkNullsAndCompare(this.Street_ID, other.Street_ID);
			if (returnValue != 0) {
				return returnValue;
			}

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public static class row1Struct implements routines.system.IPersistableRow<row1Struct> {
		final static byte[] commonByteArrayLock_PROJETDATAV1_Job04_Geography_Dim = new byte[0];
		static byte[] commonByteArray_PROJETDATAV1_Job04_Geography_Dim = new byte[0];

		public Double STREET_ID;

		public Double getSTREET_ID() {
			return this.STREET_ID;
		}

		public String COUNTRY;

		public String getCOUNTRY() {
			return this.COUNTRY;
		}

		public String STREET_NAME;

		public String getSTREET_NAME() {
			return this.STREET_NAME;
		}

		public Double CITY_ID;

		public Double getCITY_ID() {
			return this.CITY_ID;
		}

		public String POSTAL_CODE;

		public String getPOSTAL_CODE() {
			return this.POSTAL_CODE;
		}

		public Double FROM_STREET_NUM;

		public Double getFROM_STREET_NUM() {
			return this.FROM_STREET_NUM;
		}

		public Double TO_STREET_NUM;

		public Double getTO_STREET_NUM() {
			return this.TO_STREET_NUM;
		}

		public String CITY_NAME;

		public String getCITY_NAME() {
			return this.CITY_NAME;
		}

		public Double COUNT;

		public Double getCOUNT() {
			return this.COUNT;
		}

		public Double COUNTY_ID;

		public Double getCOUNTY_ID() {
			return this.COUNTY_ID;
		}

		public Double POSTAL_CODE_ID;

		public Double getPOSTAL_CODE_ID() {
			return this.POSTAL_CODE_ID;
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_PROJETDATAV1_Job04_Geography_Dim.length) {
					if (length < 1024 && commonByteArray_PROJETDATAV1_Job04_Geography_Dim.length == 0) {
						commonByteArray_PROJETDATAV1_Job04_Geography_Dim = new byte[1024];
					} else {
						commonByteArray_PROJETDATAV1_Job04_Geography_Dim = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_PROJETDATAV1_Job04_Geography_Dim, 0, length);
				strReturn = new String(commonByteArray_PROJETDATAV1_Job04_Geography_Dim, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_PROJETDATAV1_Job04_Geography_Dim.length) {
					if (length < 1024 && commonByteArray_PROJETDATAV1_Job04_Geography_Dim.length == 0) {
						commonByteArray_PROJETDATAV1_Job04_Geography_Dim = new byte[1024];
					} else {
						commonByteArray_PROJETDATAV1_Job04_Geography_Dim = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_PROJETDATAV1_Job04_Geography_Dim, 0, length);
				strReturn = new String(commonByteArray_PROJETDATAV1_Job04_Geography_Dim, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_PROJETDATAV1_Job04_Geography_Dim) {

				try {

					int length = 0;

					length = dis.readByte();
					if (length == -1) {
						this.STREET_ID = null;
					} else {
						this.STREET_ID = dis.readDouble();
					}

					this.COUNTRY = readString(dis);

					this.STREET_NAME = readString(dis);

					length = dis.readByte();
					if (length == -1) {
						this.CITY_ID = null;
					} else {
						this.CITY_ID = dis.readDouble();
					}

					this.POSTAL_CODE = readString(dis);

					length = dis.readByte();
					if (length == -1) {
						this.FROM_STREET_NUM = null;
					} else {
						this.FROM_STREET_NUM = dis.readDouble();
					}

					length = dis.readByte();
					if (length == -1) {
						this.TO_STREET_NUM = null;
					} else {
						this.TO_STREET_NUM = dis.readDouble();
					}

					this.CITY_NAME = readString(dis);

					length = dis.readByte();
					if (length == -1) {
						this.COUNT = null;
					} else {
						this.COUNT = dis.readDouble();
					}

					length = dis.readByte();
					if (length == -1) {
						this.COUNTY_ID = null;
					} else {
						this.COUNTY_ID = dis.readDouble();
					}

					length = dis.readByte();
					if (length == -1) {
						this.POSTAL_CODE_ID = null;
					} else {
						this.POSTAL_CODE_ID = dis.readDouble();
					}

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_PROJETDATAV1_Job04_Geography_Dim) {

				try {

					int length = 0;

					length = dis.readByte();
					if (length == -1) {
						this.STREET_ID = null;
					} else {
						this.STREET_ID = dis.readDouble();
					}

					this.COUNTRY = readString(dis);

					this.STREET_NAME = readString(dis);

					length = dis.readByte();
					if (length == -1) {
						this.CITY_ID = null;
					} else {
						this.CITY_ID = dis.readDouble();
					}

					this.POSTAL_CODE = readString(dis);

					length = dis.readByte();
					if (length == -1) {
						this.FROM_STREET_NUM = null;
					} else {
						this.FROM_STREET_NUM = dis.readDouble();
					}

					length = dis.readByte();
					if (length == -1) {
						this.TO_STREET_NUM = null;
					} else {
						this.TO_STREET_NUM = dis.readDouble();
					}

					this.CITY_NAME = readString(dis);

					length = dis.readByte();
					if (length == -1) {
						this.COUNT = null;
					} else {
						this.COUNT = dis.readDouble();
					}

					length = dis.readByte();
					if (length == -1) {
						this.COUNTY_ID = null;
					} else {
						this.COUNTY_ID = dis.readDouble();
					}

					length = dis.readByte();
					if (length == -1) {
						this.POSTAL_CODE_ID = null;
					} else {
						this.POSTAL_CODE_ID = dis.readDouble();
					}

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// Double

				if (this.STREET_ID == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this.STREET_ID);
				}

				// String

				writeString(this.COUNTRY, dos);

				// String

				writeString(this.STREET_NAME, dos);

				// Double

				if (this.CITY_ID == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this.CITY_ID);
				}

				// String

				writeString(this.POSTAL_CODE, dos);

				// Double

				if (this.FROM_STREET_NUM == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this.FROM_STREET_NUM);
				}

				// Double

				if (this.TO_STREET_NUM == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this.TO_STREET_NUM);
				}

				// String

				writeString(this.CITY_NAME, dos);

				// Double

				if (this.COUNT == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this.COUNT);
				}

				// Double

				if (this.COUNTY_ID == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this.COUNTY_ID);
				}

				// Double

				if (this.POSTAL_CODE_ID == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this.POSTAL_CODE_ID);
				}

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// Double

				if (this.STREET_ID == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this.STREET_ID);
				}

				// String

				writeString(this.COUNTRY, dos);

				// String

				writeString(this.STREET_NAME, dos);

				// Double

				if (this.CITY_ID == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this.CITY_ID);
				}

				// String

				writeString(this.POSTAL_CODE, dos);

				// Double

				if (this.FROM_STREET_NUM == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this.FROM_STREET_NUM);
				}

				// Double

				if (this.TO_STREET_NUM == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this.TO_STREET_NUM);
				}

				// String

				writeString(this.CITY_NAME, dos);

				// Double

				if (this.COUNT == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this.COUNT);
				}

				// Double

				if (this.COUNTY_ID == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this.COUNTY_ID);
				}

				// Double

				if (this.POSTAL_CODE_ID == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this.POSTAL_CODE_ID);
				}

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("STREET_ID=" + String.valueOf(STREET_ID));
			sb.append(",COUNTRY=" + COUNTRY);
			sb.append(",STREET_NAME=" + STREET_NAME);
			sb.append(",CITY_ID=" + String.valueOf(CITY_ID));
			sb.append(",POSTAL_CODE=" + POSTAL_CODE);
			sb.append(",FROM_STREET_NUM=" + String.valueOf(FROM_STREET_NUM));
			sb.append(",TO_STREET_NUM=" + String.valueOf(TO_STREET_NUM));
			sb.append(",CITY_NAME=" + CITY_NAME);
			sb.append(",COUNT=" + String.valueOf(COUNT));
			sb.append(",COUNTY_ID=" + String.valueOf(COUNTY_ID));
			sb.append(",POSTAL_CODE_ID=" + String.valueOf(POSTAL_CODE_ID));
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row1Struct other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public static class after_tDBInput_1Struct implements routines.system.IPersistableRow<after_tDBInput_1Struct> {
		final static byte[] commonByteArrayLock_PROJETDATAV1_Job04_Geography_Dim = new byte[0];
		static byte[] commonByteArray_PROJETDATAV1_Job04_Geography_Dim = new byte[0];
		protected static final int DEFAULT_HASHCODE = 1;
		protected static final int PRIME = 31;
		protected int hashCode = DEFAULT_HASHCODE;
		public boolean hashCodeDirty = true;

		public String loopKey;

		public Double STREET_ID;

		public Double getSTREET_ID() {
			return this.STREET_ID;
		}

		public String COUNTRY;

		public String getCOUNTRY() {
			return this.COUNTRY;
		}

		public String STREET_NAME;

		public String getSTREET_NAME() {
			return this.STREET_NAME;
		}

		public Double CITY_ID;

		public Double getCITY_ID() {
			return this.CITY_ID;
		}

		public String POSTAL_CODE;

		public String getPOSTAL_CODE() {
			return this.POSTAL_CODE;
		}

		public Double FROM_STREET_NUM;

		public Double getFROM_STREET_NUM() {
			return this.FROM_STREET_NUM;
		}

		public Double TO_STREET_NUM;

		public Double getTO_STREET_NUM() {
			return this.TO_STREET_NUM;
		}

		public String CITY_NAME;

		public String getCITY_NAME() {
			return this.CITY_NAME;
		}

		public Double COUNT;

		public Double getCOUNT() {
			return this.COUNT;
		}

		public Double COUNTY_ID;

		public Double getCOUNTY_ID() {
			return this.COUNTY_ID;
		}

		public Double POSTAL_CODE_ID;

		public Double getPOSTAL_CODE_ID() {
			return this.POSTAL_CODE_ID;
		}

		@Override
		public int hashCode() {
			if (this.hashCodeDirty) {
				final int prime = PRIME;
				int result = DEFAULT_HASHCODE;

				result = prime * result + ((this.STREET_ID == null) ? 0 : this.STREET_ID.hashCode());

				this.hashCode = result;
				this.hashCodeDirty = false;
			}
			return this.hashCode;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			final after_tDBInput_1Struct other = (after_tDBInput_1Struct) obj;

			if (this.STREET_ID == null) {
				if (other.STREET_ID != null)
					return false;

			} else if (!this.STREET_ID.equals(other.STREET_ID))

				return false;

			return true;
		}

		public void copyDataTo(after_tDBInput_1Struct other) {

			other.STREET_ID = this.STREET_ID;
			other.COUNTRY = this.COUNTRY;
			other.STREET_NAME = this.STREET_NAME;
			other.CITY_ID = this.CITY_ID;
			other.POSTAL_CODE = this.POSTAL_CODE;
			other.FROM_STREET_NUM = this.FROM_STREET_NUM;
			other.TO_STREET_NUM = this.TO_STREET_NUM;
			other.CITY_NAME = this.CITY_NAME;
			other.COUNT = this.COUNT;
			other.COUNTY_ID = this.COUNTY_ID;
			other.POSTAL_CODE_ID = this.POSTAL_CODE_ID;

		}

		public void copyKeysDataTo(after_tDBInput_1Struct other) {

			other.STREET_ID = this.STREET_ID;

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_PROJETDATAV1_Job04_Geography_Dim.length) {
					if (length < 1024 && commonByteArray_PROJETDATAV1_Job04_Geography_Dim.length == 0) {
						commonByteArray_PROJETDATAV1_Job04_Geography_Dim = new byte[1024];
					} else {
						commonByteArray_PROJETDATAV1_Job04_Geography_Dim = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_PROJETDATAV1_Job04_Geography_Dim, 0, length);
				strReturn = new String(commonByteArray_PROJETDATAV1_Job04_Geography_Dim, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_PROJETDATAV1_Job04_Geography_Dim.length) {
					if (length < 1024 && commonByteArray_PROJETDATAV1_Job04_Geography_Dim.length == 0) {
						commonByteArray_PROJETDATAV1_Job04_Geography_Dim = new byte[1024];
					} else {
						commonByteArray_PROJETDATAV1_Job04_Geography_Dim = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_PROJETDATAV1_Job04_Geography_Dim, 0, length);
				strReturn = new String(commonByteArray_PROJETDATAV1_Job04_Geography_Dim, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_PROJETDATAV1_Job04_Geography_Dim) {

				try {

					int length = 0;

					length = dis.readByte();
					if (length == -1) {
						this.STREET_ID = null;
					} else {
						this.STREET_ID = dis.readDouble();
					}

					this.COUNTRY = readString(dis);

					this.STREET_NAME = readString(dis);

					length = dis.readByte();
					if (length == -1) {
						this.CITY_ID = null;
					} else {
						this.CITY_ID = dis.readDouble();
					}

					this.POSTAL_CODE = readString(dis);

					length = dis.readByte();
					if (length == -1) {
						this.FROM_STREET_NUM = null;
					} else {
						this.FROM_STREET_NUM = dis.readDouble();
					}

					length = dis.readByte();
					if (length == -1) {
						this.TO_STREET_NUM = null;
					} else {
						this.TO_STREET_NUM = dis.readDouble();
					}

					this.CITY_NAME = readString(dis);

					length = dis.readByte();
					if (length == -1) {
						this.COUNT = null;
					} else {
						this.COUNT = dis.readDouble();
					}

					length = dis.readByte();
					if (length == -1) {
						this.COUNTY_ID = null;
					} else {
						this.COUNTY_ID = dis.readDouble();
					}

					length = dis.readByte();
					if (length == -1) {
						this.POSTAL_CODE_ID = null;
					} else {
						this.POSTAL_CODE_ID = dis.readDouble();
					}

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_PROJETDATAV1_Job04_Geography_Dim) {

				try {

					int length = 0;

					length = dis.readByte();
					if (length == -1) {
						this.STREET_ID = null;
					} else {
						this.STREET_ID = dis.readDouble();
					}

					this.COUNTRY = readString(dis);

					this.STREET_NAME = readString(dis);

					length = dis.readByte();
					if (length == -1) {
						this.CITY_ID = null;
					} else {
						this.CITY_ID = dis.readDouble();
					}

					this.POSTAL_CODE = readString(dis);

					length = dis.readByte();
					if (length == -1) {
						this.FROM_STREET_NUM = null;
					} else {
						this.FROM_STREET_NUM = dis.readDouble();
					}

					length = dis.readByte();
					if (length == -1) {
						this.TO_STREET_NUM = null;
					} else {
						this.TO_STREET_NUM = dis.readDouble();
					}

					this.CITY_NAME = readString(dis);

					length = dis.readByte();
					if (length == -1) {
						this.COUNT = null;
					} else {
						this.COUNT = dis.readDouble();
					}

					length = dis.readByte();
					if (length == -1) {
						this.COUNTY_ID = null;
					} else {
						this.COUNTY_ID = dis.readDouble();
					}

					length = dis.readByte();
					if (length == -1) {
						this.POSTAL_CODE_ID = null;
					} else {
						this.POSTAL_CODE_ID = dis.readDouble();
					}

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// Double

				if (this.STREET_ID == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this.STREET_ID);
				}

				// String

				writeString(this.COUNTRY, dos);

				// String

				writeString(this.STREET_NAME, dos);

				// Double

				if (this.CITY_ID == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this.CITY_ID);
				}

				// String

				writeString(this.POSTAL_CODE, dos);

				// Double

				if (this.FROM_STREET_NUM == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this.FROM_STREET_NUM);
				}

				// Double

				if (this.TO_STREET_NUM == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this.TO_STREET_NUM);
				}

				// String

				writeString(this.CITY_NAME, dos);

				// Double

				if (this.COUNT == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this.COUNT);
				}

				// Double

				if (this.COUNTY_ID == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this.COUNTY_ID);
				}

				// Double

				if (this.POSTAL_CODE_ID == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this.POSTAL_CODE_ID);
				}

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// Double

				if (this.STREET_ID == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this.STREET_ID);
				}

				// String

				writeString(this.COUNTRY, dos);

				// String

				writeString(this.STREET_NAME, dos);

				// Double

				if (this.CITY_ID == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this.CITY_ID);
				}

				// String

				writeString(this.POSTAL_CODE, dos);

				// Double

				if (this.FROM_STREET_NUM == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this.FROM_STREET_NUM);
				}

				// Double

				if (this.TO_STREET_NUM == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this.TO_STREET_NUM);
				}

				// String

				writeString(this.CITY_NAME, dos);

				// Double

				if (this.COUNT == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this.COUNT);
				}

				// Double

				if (this.COUNTY_ID == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this.COUNTY_ID);
				}

				// Double

				if (this.POSTAL_CODE_ID == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this.POSTAL_CODE_ID);
				}

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("STREET_ID=" + String.valueOf(STREET_ID));
			sb.append(",COUNTRY=" + COUNTRY);
			sb.append(",STREET_NAME=" + STREET_NAME);
			sb.append(",CITY_ID=" + String.valueOf(CITY_ID));
			sb.append(",POSTAL_CODE=" + POSTAL_CODE);
			sb.append(",FROM_STREET_NUM=" + String.valueOf(FROM_STREET_NUM));
			sb.append(",TO_STREET_NUM=" + String.valueOf(TO_STREET_NUM));
			sb.append(",CITY_NAME=" + CITY_NAME);
			sb.append(",COUNT=" + String.valueOf(COUNT));
			sb.append(",COUNTY_ID=" + String.valueOf(COUNTY_ID));
			sb.append(",POSTAL_CODE_ID=" + String.valueOf(POSTAL_CODE_ID));
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(after_tDBInput_1Struct other) {

			int returnValue = -1;

			returnValue = checkNullsAndCompare(this.STREET_ID, other.STREET_ID);
			if (returnValue != 0) {
				return returnValue;
			}

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public void tDBInput_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tDBInput_1_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		String iterateId = "";

		String currentComponent = "";
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				tDBInput_2Process(globalMap);
				tDBInput_3Process(globalMap);
				tDBInput_4Process(globalMap);
				tDBInput_5Process(globalMap);
				tDBInput_7Process(globalMap);
				tDBInput_8Process(globalMap);

				row1Struct row1 = new row1Struct();
				Geography_Dim_OutputStruct Geography_Dim_Output = new Geography_Dim_OutputStruct();

				/**
				 * [tDBOutput_1 begin ] start
				 */

				ok_Hash.put("tDBOutput_1", false);
				start_Hash.put("tDBOutput_1", System.currentTimeMillis());

				currentComponent = "tDBOutput_1";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "Geography_Dim_Output");
				}

				int tos_count_tDBOutput_1 = 0;

				int updateKeyCount_tDBOutput_1 = 1;
				if (updateKeyCount_tDBOutput_1 < 1) {
					throw new RuntimeException("For update, Schema must have a key");
				} else if (updateKeyCount_tDBOutput_1 == 11 && true) {
					System.err.println("For update, every Schema column can not be a key");
				}

				int nb_line_tDBOutput_1 = 0;
				int nb_line_update_tDBOutput_1 = 0;
				int nb_line_inserted_tDBOutput_1 = 0;
				int nb_line_deleted_tDBOutput_1 = 0;
				int nb_line_rejected_tDBOutput_1 = 0;

				int tmp_batchUpdateCount_tDBOutput_1 = 0;

				int deletedCount_tDBOutput_1 = 0;
				int updatedCount_tDBOutput_1 = 0;
				int insertedCount_tDBOutput_1 = 0;
				int rowsToCommitCount_tDBOutput_1 = 0;
				int rejectedCount_tDBOutput_1 = 0;

				boolean whetherReject_tDBOutput_1 = false;

				java.sql.Connection conn_tDBOutput_1 = null;

				// optional table
				String dbschema_tDBOutput_1 = null;
				String tableName_tDBOutput_1 = null;
				String driverClass_tDBOutput_1 = "oracle.jdbc.OracleDriver";

				java.lang.Class.forName(driverClass_tDBOutput_1);
				String url_tDBOutput_1 = null;
				url_tDBOutput_1 = "jdbc:oracle:thin:@" + "192.168.1.144" + ":" + "1521" + ":" + "XE";
				String dbUser_tDBOutput_1 = "orion_DW_user";

				final String decryptedPassword_tDBOutput_1 = routines.system.PasswordEncryptUtil.decryptPassword(
						"enc:routine.encryption.key.v1:ONIE7dx5wOP7pBqxNsl4vLCp15CQe15ldEpTi82GHNsSY9CjGoTN4nw=");

				String dbPwd_tDBOutput_1 = decryptedPassword_tDBOutput_1;
				dbschema_tDBOutput_1 = "";

				conn_tDBOutput_1 = java.sql.DriverManager.getConnection(url_tDBOutput_1, dbUser_tDBOutput_1,
						dbPwd_tDBOutput_1);
				resourceMap.put("conn_tDBOutput_1", conn_tDBOutput_1);
				conn_tDBOutput_1.setAutoCommit(false);
				int commitEvery_tDBOutput_1 = 10000;
				int commitCounter_tDBOutput_1 = 0;
				int count_tDBOutput_1 = 0;

				if (dbschema_tDBOutput_1 == null || dbschema_tDBOutput_1.trim().length() == 0) {
					tableName_tDBOutput_1 = ("Geography_Dim ");
				} else {
					tableName_tDBOutput_1 = dbschema_tDBOutput_1 + "." + ("Geography_Dim ");
				}
				java.sql.PreparedStatement pstmt_tDBOutput_1 = conn_tDBOutput_1
						.prepareStatement("SELECT COUNT(1) FROM " + tableName_tDBOutput_1 + " WHERE Street_ID = ?");
				resourceMap.put("pstmt_tDBOutput_1", pstmt_tDBOutput_1);
				String insert_tDBOutput_1 = "INSERT INTO " + tableName_tDBOutput_1
						+ " (Street_ID,Continent,Country,State_Code,State,Region,Province,County,City,Postal_Code,Street_Name) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
				java.sql.PreparedStatement pstmtInsert_tDBOutput_1 = conn_tDBOutput_1
						.prepareStatement(insert_tDBOutput_1);
				resourceMap.put("pstmtInsert_tDBOutput_1", pstmtInsert_tDBOutput_1);
				String update_tDBOutput_1 = "UPDATE " + tableName_tDBOutput_1
						+ " SET Continent = ?,Country = ?,State_Code = ?,State = ?,Region = ?,Province = ?,County = ?,City = ?,Postal_Code = ?,Street_Name = ? WHERE Street_ID = ?";
				java.sql.PreparedStatement pstmtUpdate_tDBOutput_1 = conn_tDBOutput_1
						.prepareStatement(update_tDBOutput_1);
				resourceMap.put("pstmtUpdate_tDBOutput_1", pstmtUpdate_tDBOutput_1);

				/**
				 * [tDBOutput_1 begin ] stop
				 */

				/**
				 * [tMap_1 begin ] start
				 */

				ok_Hash.put("tMap_1", false);
				start_Hash.put("tMap_1", System.currentTimeMillis());

				currentComponent = "tMap_1";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row1");
				}

				int tos_count_tMap_1 = 0;

// ###############################
// # Lookup's keys initialization

				org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row2Struct> tHash_Lookup_row2 = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row2Struct>) ((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row2Struct>) globalMap
						.get("tHash_Lookup_row2"));

				tHash_Lookup_row2.initGet();

				row2Struct row2HashKey = new row2Struct();
				row2Struct row2Default = new row2Struct();

				org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row3Struct> tHash_Lookup_row3 = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row3Struct>) ((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row3Struct>) globalMap
						.get("tHash_Lookup_row3"));

				row3Struct row3HashKey = new row3Struct();
				row3Struct row3Default = new row3Struct();

				org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row4Struct> tHash_Lookup_row4 = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row4Struct>) ((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row4Struct>) globalMap
						.get("tHash_Lookup_row4"));

				tHash_Lookup_row4.initGet();

				row4Struct row4HashKey = new row4Struct();
				row4Struct row4Default = new row4Struct();

				org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row6Struct> tHash_Lookup_row6 = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row6Struct>) ((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row6Struct>) globalMap
						.get("tHash_Lookup_row6"));

				row6Struct row6HashKey = new row6Struct();
				row6Struct row6Default = new row6Struct();

				org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row7Struct> tHash_Lookup_row7 = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row7Struct>) ((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row7Struct>) globalMap
						.get("tHash_Lookup_row7"));

				tHash_Lookup_row7.initGet();

				row7Struct row7HashKey = new row7Struct();
				row7Struct row7Default = new row7Struct();

				org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row8Struct> tHash_Lookup_row8 = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row8Struct>) ((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row8Struct>) globalMap
						.get("tHash_Lookup_row8"));

				row8Struct row8HashKey = new row8Struct();
				row8Struct row8Default = new row8Struct();
// ###############################        

// ###############################
// # Vars initialization
				class Var__tMap_1__Struct {
				}
				Var__tMap_1__Struct Var__tMap_1 = new Var__tMap_1__Struct();
// ###############################

// ###############################
// # Outputs initialization
				Geography_Dim_OutputStruct Geography_Dim_Output_tmp = new Geography_Dim_OutputStruct();
// ###############################

				/**
				 * [tMap_1 begin ] stop
				 */

				/**
				 * [tDBInput_1 begin ] start
				 */

				ok_Hash.put("tDBInput_1", false);
				start_Hash.put("tDBInput_1", System.currentTimeMillis());

				currentComponent = "tDBInput_1";

				int tos_count_tDBInput_1 = 0;

				int nb_line_tDBInput_1 = 0;
				java.sql.Connection conn_tDBInput_1 = null;
				String driverClass_tDBInput_1 = "net.ucanaccess.jdbc.UcanaccessDriver";
				java.lang.Class.forName(driverClass_tDBInput_1);

				String url_tDBInput_1 = "jdbc:ucanaccess://" + context.Connect_Data_File
						+ ";jackcessOpener=org.talend.ucanaccess.encrypt.CryptCodecOpener;singleConnection=true";
				String dbUser_tDBInput_1 = context.Connect_Data_Login;

				final String decryptedPassword_tDBInput_1 = context.Connect_Data_Password;

				String dbPwd_tDBInput_1 = decryptedPassword_tDBInput_1;

				String atnParams_tDBInput_1 = context.Connect_Data_AdditionalParams;
				atnParams_tDBInput_1 = atnParams_tDBInput_1.replaceAll("&", "\n");
				java.util.Properties atnParamsPrope_tDBInput_1 = new java.util.Properties();
				atnParamsPrope_tDBInput_1.put("user", dbUser_tDBInput_1);
				atnParamsPrope_tDBInput_1.put("password", dbPwd_tDBInput_1);
				atnParamsPrope_tDBInput_1.load(new java.io.ByteArrayInputStream(atnParams_tDBInput_1.getBytes()));
				conn_tDBInput_1 = java.sql.DriverManager.getConnection(url_tDBInput_1, atnParamsPrope_tDBInput_1);

				java.sql.Statement stmt_tDBInput_1 = conn_tDBInput_1.createStatement();

				String dbquery_tDBInput_1 = "SELECT \n  STREET_CODE.STREET_ID, \n  STREET_CODE.COUNTRY, \n  STREET_CODE.STREET_NAME, \n  STREET_CODE.CITY_ID, \n  STREET_"
						+ "CODE.POSTAL_CODE, \n  STREET_CODE.FROM_STREET_NUM, \n  STREET_CODE.TO_STREET_NUM, \n  STREET_CODE.CITY_NAME, \n  STREET_CODE"
						+ ".[COUNT], \n  STREET_CODE.COUNTY_ID, \n  STREET_CODE.POSTAL_CODE_ID\nFROM STREET_CODE";

				globalMap.put("tDBInput_1_QUERY", dbquery_tDBInput_1);
				java.sql.ResultSet rs_tDBInput_1 = null;

				try {
					rs_tDBInput_1 = stmt_tDBInput_1.executeQuery(dbquery_tDBInput_1);
					java.sql.ResultSetMetaData rsmd_tDBInput_1 = rs_tDBInput_1.getMetaData();
					int colQtyInRs_tDBInput_1 = rsmd_tDBInput_1.getColumnCount();

					String tmpContent_tDBInput_1 = null;

					while (rs_tDBInput_1.next()) {
						nb_line_tDBInput_1++;

						if (colQtyInRs_tDBInput_1 < 1) {
							row1.STREET_ID = null;
						} else {

							row1.STREET_ID = rs_tDBInput_1.getDouble(1);
							if (rs_tDBInput_1.wasNull()) {
								row1.STREET_ID = null;
							}
						}
						if (colQtyInRs_tDBInput_1 < 2) {
							row1.COUNTRY = null;
						} else {

							row1.COUNTRY = routines.system.JDBCUtil.getString(rs_tDBInput_1, 2, false);
						}
						if (colQtyInRs_tDBInput_1 < 3) {
							row1.STREET_NAME = null;
						} else {

							row1.STREET_NAME = routines.system.JDBCUtil.getString(rs_tDBInput_1, 3, false);
						}
						if (colQtyInRs_tDBInput_1 < 4) {
							row1.CITY_ID = null;
						} else {

							row1.CITY_ID = rs_tDBInput_1.getDouble(4);
							if (rs_tDBInput_1.wasNull()) {
								row1.CITY_ID = null;
							}
						}
						if (colQtyInRs_tDBInput_1 < 5) {
							row1.POSTAL_CODE = null;
						} else {

							row1.POSTAL_CODE = routines.system.JDBCUtil.getString(rs_tDBInput_1, 5, false);
						}
						if (colQtyInRs_tDBInput_1 < 6) {
							row1.FROM_STREET_NUM = null;
						} else {

							row1.FROM_STREET_NUM = rs_tDBInput_1.getDouble(6);
							if (rs_tDBInput_1.wasNull()) {
								row1.FROM_STREET_NUM = null;
							}
						}
						if (colQtyInRs_tDBInput_1 < 7) {
							row1.TO_STREET_NUM = null;
						} else {

							row1.TO_STREET_NUM = rs_tDBInput_1.getDouble(7);
							if (rs_tDBInput_1.wasNull()) {
								row1.TO_STREET_NUM = null;
							}
						}
						if (colQtyInRs_tDBInput_1 < 8) {
							row1.CITY_NAME = null;
						} else {

							row1.CITY_NAME = routines.system.JDBCUtil.getString(rs_tDBInput_1, 8, false);
						}
						if (colQtyInRs_tDBInput_1 < 9) {
							row1.COUNT = null;
						} else {

							row1.COUNT = rs_tDBInput_1.getDouble(9);
							if (rs_tDBInput_1.wasNull()) {
								row1.COUNT = null;
							}
						}
						if (colQtyInRs_tDBInput_1 < 10) {
							row1.COUNTY_ID = null;
						} else {

							row1.COUNTY_ID = rs_tDBInput_1.getDouble(10);
							if (rs_tDBInput_1.wasNull()) {
								row1.COUNTY_ID = null;
							}
						}
						if (colQtyInRs_tDBInput_1 < 11) {
							row1.POSTAL_CODE_ID = null;
						} else {

							row1.POSTAL_CODE_ID = rs_tDBInput_1.getDouble(11);
							if (rs_tDBInput_1.wasNull()) {
								row1.POSTAL_CODE_ID = null;
							}
						}

						/**
						 * [tDBInput_1 begin ] stop
						 */

						/**
						 * [tDBInput_1 main ] start
						 */

						currentComponent = "tDBInput_1";

						tos_count_tDBInput_1++;

						/**
						 * [tDBInput_1 main ] stop
						 */

						/**
						 * [tDBInput_1 process_data_begin ] start
						 */

						currentComponent = "tDBInput_1";

						/**
						 * [tDBInput_1 process_data_begin ] stop
						 */

						/**
						 * [tMap_1 main ] start
						 */

						currentComponent = "tMap_1";

						if (execStat) {
							runStat.updateStatOnConnection(iterateId, 1, 1

									, "row1"

							);
						}

						boolean hasCasePrimitiveKeyWithNull_tMap_1 = false;

						// ###############################
						// # Input tables (lookups)
						boolean rejectedInnerJoin_tMap_1 = false;
						boolean mainRowRejected_tMap_1 = false;

						///////////////////////////////////////////////
						// Starting Lookup Table "row2"
						///////////////////////////////////////////////

						boolean forceLooprow2 = false;

						row2Struct row2ObjectFromLookup = null;

						if (!rejectedInnerJoin_tMap_1) { // G_TM_M_020

							tHash_Lookup_row2.lookup(row2HashKey);

							if (!tHash_Lookup_row2.hasNext()) { // G_TM_M_090

								forceLooprow2 = true;

							} // G_TM_M_090

						} // G_TM_M_020

						else { // G 20 - G 21
							forceLooprow2 = true;
						} // G 21

						row2Struct row2 = null;

						while ((tHash_Lookup_row2 != null && tHash_Lookup_row2.hasNext()) || forceLooprow2) { // G_TM_M_043

							// CALL close loop of lookup 'row2'

							row2Struct fromLookup_row2 = null;
							row2 = row2Default;

							if (!forceLooprow2) { // G 46

								fromLookup_row2 = tHash_Lookup_row2.next();

								if (fromLookup_row2 != null) {
									row2 = fromLookup_row2;
								}

							} // G 46

							forceLooprow2 = false;

							///////////////////////////////////////////////
							// Starting Lookup Table "row3"
							///////////////////////////////////////////////

							boolean forceLooprow3 = false;

							row3Struct row3ObjectFromLookup = null;

							if (!rejectedInnerJoin_tMap_1) { // G_TM_M_020

								hasCasePrimitiveKeyWithNull_tMap_1 = false;

								row3HashKey.CONTINENT_ID = row2.CONTINENT_ID;

								row3HashKey.hashCodeDirty = true;

								tHash_Lookup_row3.lookup(row3HashKey);

							} // G_TM_M_020

							if (tHash_Lookup_row3 != null && tHash_Lookup_row3.getCount(row3HashKey) > 1) { // G 071

								// System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'row3'
								// and it contains more one result from keys : row3.CONTINENT_ID = '" +
								// row3HashKey.CONTINENT_ID + "'");
							} // G 071

							row3Struct row3 = null;

							row3Struct fromLookup_row3 = null;
							row3 = row3Default;

							if (tHash_Lookup_row3 != null && tHash_Lookup_row3.hasNext()) { // G 099

								fromLookup_row3 = tHash_Lookup_row3.next();

							} // G 099

							if (fromLookup_row3 != null) {
								row3 = fromLookup_row3;
							}

							///////////////////////////////////////////////
							// Starting Lookup Table "row4"
							///////////////////////////////////////////////

							boolean forceLooprow4 = false;

							row4Struct row4ObjectFromLookup = null;

							if (!rejectedInnerJoin_tMap_1) { // G_TM_M_020

								tHash_Lookup_row4.lookup(row4HashKey);

								if (!tHash_Lookup_row4.hasNext()) { // G_TM_M_090

									forceLooprow4 = true;

								} // G_TM_M_090

							} // G_TM_M_020

							else { // G 20 - G 21
								forceLooprow4 = true;
							} // G 21

							row4Struct row4 = null;

							while ((tHash_Lookup_row4 != null && tHash_Lookup_row4.hasNext()) || forceLooprow4) { // G_TM_M_043

								// CALL close loop of lookup 'row4'

								row4Struct fromLookup_row4 = null;
								row4 = row4Default;

								if (!forceLooprow4) { // G 46

									fromLookup_row4 = tHash_Lookup_row4.next();

									if (fromLookup_row4 != null) {
										row4 = fromLookup_row4;
									}

								} // G 46

								forceLooprow4 = false;

								///////////////////////////////////////////////
								// Starting Lookup Table "row6"
								///////////////////////////////////////////////

								boolean forceLooprow6 = false;

								row6Struct row6ObjectFromLookup = null;

								if (!rejectedInnerJoin_tMap_1) { // G_TM_M_020

									hasCasePrimitiveKeyWithNull_tMap_1 = false;

									row6HashKey.STATE_ID = row4.STATE_ID;

									row6HashKey.hashCodeDirty = true;

									tHash_Lookup_row6.lookup(row6HashKey);

								} // G_TM_M_020

								if (tHash_Lookup_row6 != null && tHash_Lookup_row6.getCount(row6HashKey) > 1) { // G 071

									// System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'row6'
									// and it contains more one result from keys : row6.STATE_ID = '" +
									// row6HashKey.STATE_ID + "'");
								} // G 071

								row6Struct row6 = null;

								row6Struct fromLookup_row6 = null;
								row6 = row6Default;

								if (tHash_Lookup_row6 != null && tHash_Lookup_row6.hasNext()) { // G 099

									fromLookup_row6 = tHash_Lookup_row6.next();

								} // G 099

								if (fromLookup_row6 != null) {
									row6 = fromLookup_row6;
								}

								///////////////////////////////////////////////
								// Starting Lookup Table "row7"
								///////////////////////////////////////////////

								boolean forceLooprow7 = false;

								row7Struct row7ObjectFromLookup = null;

								if (!rejectedInnerJoin_tMap_1) { // G_TM_M_020

									tHash_Lookup_row7.lookup(row7HashKey);

									if (!tHash_Lookup_row7.hasNext()) { // G_TM_M_090

										forceLooprow7 = true;

									} // G_TM_M_090

								} // G_TM_M_020

								else { // G 20 - G 21
									forceLooprow7 = true;
								} // G 21

								row7Struct row7 = null;

								while ((tHash_Lookup_row7 != null && tHash_Lookup_row7.hasNext()) || forceLooprow7) { // G_TM_M_043

									// CALL close loop of lookup 'row7'

									row7Struct fromLookup_row7 = null;
									row7 = row7Default;

									if (!forceLooprow7) { // G 46

										fromLookup_row7 = tHash_Lookup_row7.next();

										if (fromLookup_row7 != null) {
											row7 = fromLookup_row7;
										}

									} // G 46

									forceLooprow7 = false;

									///////////////////////////////////////////////
									// Starting Lookup Table "row8"
									///////////////////////////////////////////////

									boolean forceLooprow8 = false;

									row8Struct row8ObjectFromLookup = null;

									if (!rejectedInnerJoin_tMap_1) { // G_TM_M_020

										hasCasePrimitiveKeyWithNull_tMap_1 = false;

										row8HashKey.POSTAL_CODE_ID = row1.POSTAL_CODE_ID;

										row8HashKey.CITY_ID = row7.CITY_ID;

										row8HashKey.hashCodeDirty = true;

										tHash_Lookup_row8.lookup(row8HashKey);

									} // G_TM_M_020

									if (tHash_Lookup_row8 != null && tHash_Lookup_row8.getCount(row8HashKey) > 1) { // G
																													// 071

										// System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'row8'
										// and it contains more one result from keys : row8.POSTAL_CODE_ID = '" +
										// row8HashKey.POSTAL_CODE_ID + "', row8.CITY_ID = '" + row8HashKey.CITY_ID +
										// "'");
									} // G 071

									row8Struct row8 = null;

									row8Struct fromLookup_row8 = null;
									row8 = row8Default;

									if (tHash_Lookup_row8 != null && tHash_Lookup_row8.hasNext()) { // G 099

										fromLookup_row8 = tHash_Lookup_row8.next();

									} // G 099

									if (fromLookup_row8 != null) {
										row8 = fromLookup_row8;
									}

									// ###############################
									{ // start of Var scope

										// ###############################
										// # Vars tables

										Var__tMap_1__Struct Var = Var__tMap_1;// ###############################
										// ###############################
										// # Output tables

										Geography_Dim_Output = null;

// # Output table : 'Geography_Dim_Output'
										Geography_Dim_Output_tmp.Street_ID = row1.STREET_ID;
										Geography_Dim_Output_tmp.Continent = row2.CONTINENT_NAME;
										Geography_Dim_Output_tmp.Country = row1.COUNTRY;
										Geography_Dim_Output_tmp.State_Code = row4.STATE_CODE;
										Geography_Dim_Output_tmp.State = row4.STATE_NAME;
										Geography_Dim_Output_tmp.Region = row6.REGION_NAME;
										Geography_Dim_Output_tmp.Province = row6.PROVINCE_NAME;
										Geography_Dim_Output_tmp.County = row6.COUNTY_NAME;
										Geography_Dim_Output_tmp.City = row7.CITY_NAME;
										Geography_Dim_Output_tmp.Postal_Code = row8.POSTAL_CODE;
										Geography_Dim_Output_tmp.Street_Name = row1.STREET_NAME;
										Geography_Dim_Output = Geography_Dim_Output_tmp;
// ###############################

									} // end of Var scope

									rejectedInnerJoin_tMap_1 = false;

									tos_count_tMap_1++;

									/**
									 * [tMap_1 main ] stop
									 */

									/**
									 * [tMap_1 process_data_begin ] start
									 */

									currentComponent = "tMap_1";

									/**
									 * [tMap_1 process_data_begin ] stop
									 */
// Start of branch "Geography_Dim_Output"
									if (Geography_Dim_Output != null) {

										/**
										 * [tDBOutput_1 main ] start
										 */

										currentComponent = "tDBOutput_1";

										if (execStat) {
											runStat.updateStatOnConnection(iterateId, 1, 1

													, "Geography_Dim_Output"

											);
										}

										whetherReject_tDBOutput_1 = false;
										if (Geography_Dim_Output.Street_ID == null) {
											pstmt_tDBOutput_1.setNull(1, java.sql.Types.DOUBLE);
										} else {
											pstmt_tDBOutput_1.setDouble(1, Geography_Dim_Output.Street_ID);
										}

										int checkCount_tDBOutput_1 = -1;
										try (java.sql.ResultSet rs_tDBOutput_1 = pstmt_tDBOutput_1.executeQuery()) {
											while (rs_tDBOutput_1.next()) {
												checkCount_tDBOutput_1 = rs_tDBOutput_1.getInt(1);
											}
										}
										if (checkCount_tDBOutput_1 > 0) {
											if (Geography_Dim_Output.Continent == null) {
												pstmtUpdate_tDBOutput_1.setNull(1, java.sql.Types.VARCHAR);
											} else {
												pstmtUpdate_tDBOutput_1.setString(1, Geography_Dim_Output.Continent);
											}

											if (Geography_Dim_Output.Country == null) {
												pstmtUpdate_tDBOutput_1.setNull(2, java.sql.Types.VARCHAR);
											} else {
												pstmtUpdate_tDBOutput_1.setString(2, Geography_Dim_Output.Country);
											}

											if (Geography_Dim_Output.State_Code == null) {
												pstmtUpdate_tDBOutput_1.setNull(3, java.sql.Types.VARCHAR);
											} else {
												pstmtUpdate_tDBOutput_1.setString(3, Geography_Dim_Output.State_Code);
											}

											if (Geography_Dim_Output.State == null) {
												pstmtUpdate_tDBOutput_1.setNull(4, java.sql.Types.VARCHAR);
											} else {
												pstmtUpdate_tDBOutput_1.setString(4, Geography_Dim_Output.State);
											}

											if (Geography_Dim_Output.Region == null) {
												pstmtUpdate_tDBOutput_1.setNull(5, java.sql.Types.VARCHAR);
											} else {
												pstmtUpdate_tDBOutput_1.setString(5, Geography_Dim_Output.Region);
											}

											if (Geography_Dim_Output.Province == null) {
												pstmtUpdate_tDBOutput_1.setNull(6, java.sql.Types.VARCHAR);
											} else {
												pstmtUpdate_tDBOutput_1.setString(6, Geography_Dim_Output.Province);
											}

											if (Geography_Dim_Output.County == null) {
												pstmtUpdate_tDBOutput_1.setNull(7, java.sql.Types.VARCHAR);
											} else {
												pstmtUpdate_tDBOutput_1.setString(7, Geography_Dim_Output.County);
											}

											if (Geography_Dim_Output.City == null) {
												pstmtUpdate_tDBOutput_1.setNull(8, java.sql.Types.VARCHAR);
											} else {
												pstmtUpdate_tDBOutput_1.setString(8, Geography_Dim_Output.City);
											}

											if (Geography_Dim_Output.Postal_Code == null) {
												pstmtUpdate_tDBOutput_1.setNull(9, java.sql.Types.VARCHAR);
											} else {
												pstmtUpdate_tDBOutput_1.setString(9, Geography_Dim_Output.Postal_Code);
											}

											if (Geography_Dim_Output.Street_Name == null) {
												pstmtUpdate_tDBOutput_1.setNull(10, java.sql.Types.VARCHAR);
											} else {
												pstmtUpdate_tDBOutput_1.setString(10, Geography_Dim_Output.Street_Name);
											}

											if (Geography_Dim_Output.Street_ID == null) {
												pstmtUpdate_tDBOutput_1.setNull(11 + count_tDBOutput_1,
														java.sql.Types.DOUBLE);
											} else {
												pstmtUpdate_tDBOutput_1.setDouble(11 + count_tDBOutput_1,
														Geography_Dim_Output.Street_ID);
											}

											try {
												int processedCount_tDBOutput_1 = pstmtUpdate_tDBOutput_1
														.executeUpdate();
												updatedCount_tDBOutput_1 += processedCount_tDBOutput_1;
												rowsToCommitCount_tDBOutput_1 += processedCount_tDBOutput_1;
												nb_line_tDBOutput_1++;
											} catch (java.lang.Exception e_tDBOutput_1) {
												globalMap.put("tDBOutput_1_ERROR_MESSAGE", e_tDBOutput_1.getMessage());
												whetherReject_tDBOutput_1 = true;
												nb_line_tDBOutput_1++;
												System.err.print(e_tDBOutput_1.getMessage());
											}
										} else {
											if (Geography_Dim_Output.Street_ID == null) {
												pstmtInsert_tDBOutput_1.setNull(1, java.sql.Types.DOUBLE);
											} else {
												pstmtInsert_tDBOutput_1.setDouble(1, Geography_Dim_Output.Street_ID);
											}

											if (Geography_Dim_Output.Continent == null) {
												pstmtInsert_tDBOutput_1.setNull(2, java.sql.Types.VARCHAR);
											} else {
												pstmtInsert_tDBOutput_1.setString(2, Geography_Dim_Output.Continent);
											}

											if (Geography_Dim_Output.Country == null) {
												pstmtInsert_tDBOutput_1.setNull(3, java.sql.Types.VARCHAR);
											} else {
												pstmtInsert_tDBOutput_1.setString(3, Geography_Dim_Output.Country);
											}

											if (Geography_Dim_Output.State_Code == null) {
												pstmtInsert_tDBOutput_1.setNull(4, java.sql.Types.VARCHAR);
											} else {
												pstmtInsert_tDBOutput_1.setString(4, Geography_Dim_Output.State_Code);
											}

											if (Geography_Dim_Output.State == null) {
												pstmtInsert_tDBOutput_1.setNull(5, java.sql.Types.VARCHAR);
											} else {
												pstmtInsert_tDBOutput_1.setString(5, Geography_Dim_Output.State);
											}

											if (Geography_Dim_Output.Region == null) {
												pstmtInsert_tDBOutput_1.setNull(6, java.sql.Types.VARCHAR);
											} else {
												pstmtInsert_tDBOutput_1.setString(6, Geography_Dim_Output.Region);
											}

											if (Geography_Dim_Output.Province == null) {
												pstmtInsert_tDBOutput_1.setNull(7, java.sql.Types.VARCHAR);
											} else {
												pstmtInsert_tDBOutput_1.setString(7, Geography_Dim_Output.Province);
											}

											if (Geography_Dim_Output.County == null) {
												pstmtInsert_tDBOutput_1.setNull(8, java.sql.Types.VARCHAR);
											} else {
												pstmtInsert_tDBOutput_1.setString(8, Geography_Dim_Output.County);
											}

											if (Geography_Dim_Output.City == null) {
												pstmtInsert_tDBOutput_1.setNull(9, java.sql.Types.VARCHAR);
											} else {
												pstmtInsert_tDBOutput_1.setString(9, Geography_Dim_Output.City);
											}

											if (Geography_Dim_Output.Postal_Code == null) {
												pstmtInsert_tDBOutput_1.setNull(10, java.sql.Types.VARCHAR);
											} else {
												pstmtInsert_tDBOutput_1.setString(10, Geography_Dim_Output.Postal_Code);
											}

											if (Geography_Dim_Output.Street_Name == null) {
												pstmtInsert_tDBOutput_1.setNull(11, java.sql.Types.VARCHAR);
											} else {
												pstmtInsert_tDBOutput_1.setString(11, Geography_Dim_Output.Street_Name);
											}

											try {
												int processedCount_tDBOutput_1 = pstmtInsert_tDBOutput_1
														.executeUpdate();
												insertedCount_tDBOutput_1 += processedCount_tDBOutput_1;
												rowsToCommitCount_tDBOutput_1 += processedCount_tDBOutput_1;
												nb_line_tDBOutput_1++;
											} catch (java.lang.Exception e_tDBOutput_1) {
												globalMap.put("tDBOutput_1_ERROR_MESSAGE", e_tDBOutput_1.getMessage());
												whetherReject_tDBOutput_1 = true;
												nb_line_tDBOutput_1++;
												System.err.print(e_tDBOutput_1.getMessage());
											}
										}
										commitCounter_tDBOutput_1++;
										if (commitEvery_tDBOutput_1 <= commitCounter_tDBOutput_1) {
											if (rowsToCommitCount_tDBOutput_1 != 0) {

											}
											conn_tDBOutput_1.commit();
											if (rowsToCommitCount_tDBOutput_1 != 0) {

												rowsToCommitCount_tDBOutput_1 = 0;
											}
											commitCounter_tDBOutput_1 = 0;
										}

										tos_count_tDBOutput_1++;

										/**
										 * [tDBOutput_1 main ] stop
										 */

										/**
										 * [tDBOutput_1 process_data_begin ] start
										 */

										currentComponent = "tDBOutput_1";

										/**
										 * [tDBOutput_1 process_data_begin ] stop
										 */

										/**
										 * [tDBOutput_1 process_data_end ] start
										 */

										currentComponent = "tDBOutput_1";

										/**
										 * [tDBOutput_1 process_data_end ] stop
										 */

									} // End of branch "Geography_Dim_Output"

								} // close loop of lookup 'row7' // G_TM_M_043

							} // close loop of lookup 'row4' // G_TM_M_043

						} // close loop of lookup 'row2' // G_TM_M_043

						/**
						 * [tMap_1 process_data_end ] start
						 */

						currentComponent = "tMap_1";

						/**
						 * [tMap_1 process_data_end ] stop
						 */

						/**
						 * [tDBInput_1 process_data_end ] start
						 */

						currentComponent = "tDBInput_1";

						/**
						 * [tDBInput_1 process_data_end ] stop
						 */

						/**
						 * [tDBInput_1 end ] start
						 */

						currentComponent = "tDBInput_1";

					}
				} finally {
					if (rs_tDBInput_1 != null) {
						rs_tDBInput_1.close();
					}
					if (stmt_tDBInput_1 != null) {
						stmt_tDBInput_1.close();
					}
					if (conn_tDBInput_1 != null && !conn_tDBInput_1.isClosed()) {

						conn_tDBInput_1.close();

						if ("com.mysql.cj.jdbc.Driver".equals((String) globalMap.get("driverClass_"))
								&& routines.system.BundleUtils.inOSGi()) {
							Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread")
									.getMethod("checkedShutdown").invoke(null, (Object[]) null);
						}

					}
				}
				globalMap.put("tDBInput_1_NB_LINE", nb_line_tDBInput_1);

				ok_Hash.put("tDBInput_1", true);
				end_Hash.put("tDBInput_1", System.currentTimeMillis());

				/**
				 * [tDBInput_1 end ] stop
				 */

				/**
				 * [tMap_1 end ] start
				 */

				currentComponent = "tMap_1";

// ###############################
// # Lookup hashes releasing
				if (tHash_Lookup_row2 != null) {
					tHash_Lookup_row2.endGet();
				}
				globalMap.remove("tHash_Lookup_row2");

				if (tHash_Lookup_row3 != null) {
					tHash_Lookup_row3.endGet();
				}
				globalMap.remove("tHash_Lookup_row3");

				if (tHash_Lookup_row4 != null) {
					tHash_Lookup_row4.endGet();
				}
				globalMap.remove("tHash_Lookup_row4");

				if (tHash_Lookup_row6 != null) {
					tHash_Lookup_row6.endGet();
				}
				globalMap.remove("tHash_Lookup_row6");

				if (tHash_Lookup_row7 != null) {
					tHash_Lookup_row7.endGet();
				}
				globalMap.remove("tHash_Lookup_row7");

				if (tHash_Lookup_row8 != null) {
					tHash_Lookup_row8.endGet();
				}
				globalMap.remove("tHash_Lookup_row8");

// ###############################      

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "row1");
				}

				ok_Hash.put("tMap_1", true);
				end_Hash.put("tMap_1", System.currentTimeMillis());

				/**
				 * [tMap_1 end ] stop
				 */

				/**
				 * [tDBOutput_1 end ] start
				 */

				currentComponent = "tDBOutput_1";

				if (pstmtUpdate_tDBOutput_1 != null) {
					pstmtUpdate_tDBOutput_1.close();
					resourceMap.remove("pstmtUpdate_tDBOutput_1");
				}
				if (pstmtInsert_tDBOutput_1 != null) {
					pstmtInsert_tDBOutput_1.close();
					resourceMap.remove("pstmtInsert_tDBOutput_1");
				}
				if (pstmt_tDBOutput_1 != null) {
					pstmt_tDBOutput_1.close();
					resourceMap.remove("pstmt_tDBOutput_1");
				}
				resourceMap.put("statementClosed_tDBOutput_1", true);
				if (commitCounter_tDBOutput_1 > 0 && rowsToCommitCount_tDBOutput_1 != 0) {

				}
				conn_tDBOutput_1.commit();
				if (commitCounter_tDBOutput_1 > 0 && rowsToCommitCount_tDBOutput_1 != 0) {

					rowsToCommitCount_tDBOutput_1 = 0;
				}
				commitCounter_tDBOutput_1 = 0;

				conn_tDBOutput_1.close();

				resourceMap.put("finish_tDBOutput_1", true);

				nb_line_deleted_tDBOutput_1 = nb_line_deleted_tDBOutput_1 + deletedCount_tDBOutput_1;
				nb_line_update_tDBOutput_1 = nb_line_update_tDBOutput_1 + updatedCount_tDBOutput_1;
				nb_line_inserted_tDBOutput_1 = nb_line_inserted_tDBOutput_1 + insertedCount_tDBOutput_1;
				nb_line_rejected_tDBOutput_1 = nb_line_rejected_tDBOutput_1 + rejectedCount_tDBOutput_1;

				globalMap.put("tDBOutput_1_NB_LINE", nb_line_tDBOutput_1);
				globalMap.put("tDBOutput_1_NB_LINE_UPDATED", nb_line_update_tDBOutput_1);
				globalMap.put("tDBOutput_1_NB_LINE_INSERTED", nb_line_inserted_tDBOutput_1);
				globalMap.put("tDBOutput_1_NB_LINE_DELETED", nb_line_deleted_tDBOutput_1);
				globalMap.put("tDBOutput_1_NB_LINE_REJECTED", nb_line_rejected_tDBOutput_1);

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "Geography_Dim_Output");
				}

				ok_Hash.put("tDBOutput_1", true);
				end_Hash.put("tDBOutput_1", System.currentTimeMillis());

				/**
				 * [tDBOutput_1 end ] stop
				 */

			} // end the resume

		} catch (java.lang.Exception e) {

			TalendException te = new TalendException(e, currentComponent, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			// free memory for "tMap_1"
			globalMap.remove("tHash_Lookup_row2");

			// free memory for "tMap_1"
			globalMap.remove("tHash_Lookup_row3");

			// free memory for "tMap_1"
			globalMap.remove("tHash_Lookup_row4");

			// free memory for "tMap_1"
			globalMap.remove("tHash_Lookup_row6");

			// free memory for "tMap_1"
			globalMap.remove("tHash_Lookup_row7");

			// free memory for "tMap_1"
			globalMap.remove("tHash_Lookup_row8");

			try {

				/**
				 * [tDBInput_1 finally ] start
				 */

				currentComponent = "tDBInput_1";

				/**
				 * [tDBInput_1 finally ] stop
				 */

				/**
				 * [tMap_1 finally ] start
				 */

				currentComponent = "tMap_1";

				/**
				 * [tMap_1 finally ] stop
				 */

				/**
				 * [tDBOutput_1 finally ] start
				 */

				currentComponent = "tDBOutput_1";

				try {
					if (resourceMap.get("statementClosed_tDBOutput_1") == null) {
						java.sql.PreparedStatement pstmtUpdateToClose_tDBOutput_1 = null;
						if ((pstmtUpdateToClose_tDBOutput_1 = (java.sql.PreparedStatement) resourceMap
								.remove("pstmtUpdate_tDBOutput_1")) != null) {
							pstmtUpdateToClose_tDBOutput_1.close();
						}
						java.sql.PreparedStatement pstmtInsertToClose_tDBOutput_1 = null;
						if ((pstmtInsertToClose_tDBOutput_1 = (java.sql.PreparedStatement) resourceMap
								.remove("pstmtInsert_tDBOutput_1")) != null) {
							pstmtInsertToClose_tDBOutput_1.close();
						}
						java.sql.PreparedStatement pstmtToClose_tDBOutput_1 = null;
						if ((pstmtToClose_tDBOutput_1 = (java.sql.PreparedStatement) resourceMap
								.remove("pstmt_tDBOutput_1")) != null) {
							pstmtToClose_tDBOutput_1.close();
						}
					}
				} finally {
					if (resourceMap.get("finish_tDBOutput_1") == null) {
						java.sql.Connection ctn_tDBOutput_1 = null;
						if ((ctn_tDBOutput_1 = (java.sql.Connection) resourceMap.get("conn_tDBOutput_1")) != null) {
							try {
								ctn_tDBOutput_1.close();
							} catch (java.sql.SQLException sqlEx_tDBOutput_1) {
								String errorMessage_tDBOutput_1 = "failed to close the connection in tDBOutput_1 :"
										+ sqlEx_tDBOutput_1.getMessage();
								System.err.println(errorMessage_tDBOutput_1);
							}
						}
					}
				}

				/**
				 * [tDBOutput_1 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tDBInput_1_SUBPROCESS_STATE", 1);
	}

	public static class row2Struct implements routines.system.IPersistableRow<row2Struct> {
		final static byte[] commonByteArrayLock_PROJETDATAV1_Job04_Geography_Dim = new byte[0];
		static byte[] commonByteArray_PROJETDATAV1_Job04_Geography_Dim = new byte[0];

		public Double CONTINENT_ID;

		public Double getCONTINENT_ID() {
			return this.CONTINENT_ID;
		}

		public String CONTINENT_NAME;

		public String getCONTINENT_NAME() {
			return this.CONTINENT_NAME;
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_PROJETDATAV1_Job04_Geography_Dim.length) {
					if (length < 1024 && commonByteArray_PROJETDATAV1_Job04_Geography_Dim.length == 0) {
						commonByteArray_PROJETDATAV1_Job04_Geography_Dim = new byte[1024];
					} else {
						commonByteArray_PROJETDATAV1_Job04_Geography_Dim = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_PROJETDATAV1_Job04_Geography_Dim, 0, length);
				strReturn = new String(commonByteArray_PROJETDATAV1_Job04_Geography_Dim, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_PROJETDATAV1_Job04_Geography_Dim.length) {
					if (length < 1024 && commonByteArray_PROJETDATAV1_Job04_Geography_Dim.length == 0) {
						commonByteArray_PROJETDATAV1_Job04_Geography_Dim = new byte[1024];
					} else {
						commonByteArray_PROJETDATAV1_Job04_Geography_Dim = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_PROJETDATAV1_Job04_Geography_Dim, 0, length);
				strReturn = new String(commonByteArray_PROJETDATAV1_Job04_Geography_Dim, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_PROJETDATAV1_Job04_Geography_Dim) {

				try {

					int length = 0;

					length = dis.readByte();
					if (length == -1) {
						this.CONTINENT_ID = null;
					} else {
						this.CONTINENT_ID = dis.readDouble();
					}

					this.CONTINENT_NAME = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_PROJETDATAV1_Job04_Geography_Dim) {

				try {

					int length = 0;

					length = dis.readByte();
					if (length == -1) {
						this.CONTINENT_ID = null;
					} else {
						this.CONTINENT_ID = dis.readDouble();
					}

					this.CONTINENT_NAME = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// Double

				if (this.CONTINENT_ID == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this.CONTINENT_ID);
				}

				// String

				writeString(this.CONTINENT_NAME, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// Double

				if (this.CONTINENT_ID == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this.CONTINENT_ID);
				}

				// String

				writeString(this.CONTINENT_NAME, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("CONTINENT_ID=" + String.valueOf(CONTINENT_ID));
			sb.append(",CONTINENT_NAME=" + CONTINENT_NAME);
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row2Struct other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public void tDBInput_2Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tDBInput_2_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		String iterateId = "";

		String currentComponent = "";
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				row2Struct row2 = new row2Struct();

				/**
				 * [tAdvancedHash_row2 begin ] start
				 */

				ok_Hash.put("tAdvancedHash_row2", false);
				start_Hash.put("tAdvancedHash_row2", System.currentTimeMillis());

				currentComponent = "tAdvancedHash_row2";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row2");
				}

				int tos_count_tAdvancedHash_row2 = 0;

				// connection name:row2
				// source node:tDBInput_2 - inputs:(after_tDBInput_1) outputs:(row2,row2) |
				// target node:tAdvancedHash_row2 - inputs:(row2) outputs:()
				// linked node: tMap_1 - inputs:(row1,row2,row3,row4,row6,row7,row8)
				// outputs:(Geography_Dim_Output)

				org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_row2 = org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.ALL_ROWS;

				org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row2Struct> tHash_Lookup_row2 = org.talend.designer.components.lookup.memory.AdvancedMemoryLookup
						.<row2Struct>getLookup(matchingModeEnum_row2);

				globalMap.put("tHash_Lookup_row2", tHash_Lookup_row2);

				/**
				 * [tAdvancedHash_row2 begin ] stop
				 */

				/**
				 * [tDBInput_2 begin ] start
				 */

				ok_Hash.put("tDBInput_2", false);
				start_Hash.put("tDBInput_2", System.currentTimeMillis());

				currentComponent = "tDBInput_2";

				int tos_count_tDBInput_2 = 0;

				int nb_line_tDBInput_2 = 0;
				java.sql.Connection conn_tDBInput_2 = null;
				String driverClass_tDBInput_2 = "net.ucanaccess.jdbc.UcanaccessDriver";
				java.lang.Class.forName(driverClass_tDBInput_2);

				String url_tDBInput_2 = "jdbc:ucanaccess://" + context.Connect_Data_File
						+ ";jackcessOpener=org.talend.ucanaccess.encrypt.CryptCodecOpener;singleConnection=true";
				String dbUser_tDBInput_2 = context.Connect_Data_Login;

				final String decryptedPassword_tDBInput_2 = context.Connect_Data_Password;

				String dbPwd_tDBInput_2 = decryptedPassword_tDBInput_2;

				String atnParams_tDBInput_2 = context.Connect_Data_AdditionalParams;
				atnParams_tDBInput_2 = atnParams_tDBInput_2.replaceAll("&", "\n");
				java.util.Properties atnParamsPrope_tDBInput_2 = new java.util.Properties();
				atnParamsPrope_tDBInput_2.put("user", dbUser_tDBInput_2);
				atnParamsPrope_tDBInput_2.put("password", dbPwd_tDBInput_2);
				atnParamsPrope_tDBInput_2.load(new java.io.ByteArrayInputStream(atnParams_tDBInput_2.getBytes()));
				conn_tDBInput_2 = java.sql.DriverManager.getConnection(url_tDBInput_2, atnParamsPrope_tDBInput_2);

				java.sql.Statement stmt_tDBInput_2 = conn_tDBInput_2.createStatement();

				String dbquery_tDBInput_2 = "SELECT \n  CONTINENT.CONTINENT_ID, \n  CONTINENT.CONTINENT_NAME\nFROM CONTINENT";

				globalMap.put("tDBInput_2_QUERY", dbquery_tDBInput_2);
				java.sql.ResultSet rs_tDBInput_2 = null;

				try {
					rs_tDBInput_2 = stmt_tDBInput_2.executeQuery(dbquery_tDBInput_2);
					java.sql.ResultSetMetaData rsmd_tDBInput_2 = rs_tDBInput_2.getMetaData();
					int colQtyInRs_tDBInput_2 = rsmd_tDBInput_2.getColumnCount();

					String tmpContent_tDBInput_2 = null;

					while (rs_tDBInput_2.next()) {
						nb_line_tDBInput_2++;

						if (colQtyInRs_tDBInput_2 < 1) {
							row2.CONTINENT_ID = null;
						} else {

							row2.CONTINENT_ID = rs_tDBInput_2.getDouble(1);
							if (rs_tDBInput_2.wasNull()) {
								row2.CONTINENT_ID = null;
							}
						}
						if (colQtyInRs_tDBInput_2 < 2) {
							row2.CONTINENT_NAME = null;
						} else {

							row2.CONTINENT_NAME = routines.system.JDBCUtil.getString(rs_tDBInput_2, 2, false);
						}

						/**
						 * [tDBInput_2 begin ] stop
						 */

						/**
						 * [tDBInput_2 main ] start
						 */

						currentComponent = "tDBInput_2";

						tos_count_tDBInput_2++;

						/**
						 * [tDBInput_2 main ] stop
						 */

						/**
						 * [tDBInput_2 process_data_begin ] start
						 */

						currentComponent = "tDBInput_2";

						/**
						 * [tDBInput_2 process_data_begin ] stop
						 */

						/**
						 * [tAdvancedHash_row2 main ] start
						 */

						currentComponent = "tAdvancedHash_row2";

						if (execStat) {
							runStat.updateStatOnConnection(iterateId, 1, 1

									, "row2"

							);
						}

						row2Struct row2_HashRow = new row2Struct();

						row2_HashRow.CONTINENT_ID = row2.CONTINENT_ID;

						row2_HashRow.CONTINENT_NAME = row2.CONTINENT_NAME;

						tHash_Lookup_row2.put(row2_HashRow);

						tos_count_tAdvancedHash_row2++;

						/**
						 * [tAdvancedHash_row2 main ] stop
						 */

						/**
						 * [tAdvancedHash_row2 process_data_begin ] start
						 */

						currentComponent = "tAdvancedHash_row2";

						/**
						 * [tAdvancedHash_row2 process_data_begin ] stop
						 */

						/**
						 * [tAdvancedHash_row2 process_data_end ] start
						 */

						currentComponent = "tAdvancedHash_row2";

						/**
						 * [tAdvancedHash_row2 process_data_end ] stop
						 */

						/**
						 * [tDBInput_2 process_data_end ] start
						 */

						currentComponent = "tDBInput_2";

						/**
						 * [tDBInput_2 process_data_end ] stop
						 */

						/**
						 * [tDBInput_2 end ] start
						 */

						currentComponent = "tDBInput_2";

					}
				} finally {
					if (rs_tDBInput_2 != null) {
						rs_tDBInput_2.close();
					}
					if (stmt_tDBInput_2 != null) {
						stmt_tDBInput_2.close();
					}
					if (conn_tDBInput_2 != null && !conn_tDBInput_2.isClosed()) {

						conn_tDBInput_2.close();

						if ("com.mysql.cj.jdbc.Driver".equals((String) globalMap.get("driverClass_"))
								&& routines.system.BundleUtils.inOSGi()) {
							Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread")
									.getMethod("checkedShutdown").invoke(null, (Object[]) null);
						}

					}
				}
				globalMap.put("tDBInput_2_NB_LINE", nb_line_tDBInput_2);

				ok_Hash.put("tDBInput_2", true);
				end_Hash.put("tDBInput_2", System.currentTimeMillis());

				/**
				 * [tDBInput_2 end ] stop
				 */

				/**
				 * [tAdvancedHash_row2 end ] start
				 */

				currentComponent = "tAdvancedHash_row2";

				tHash_Lookup_row2.endPut();

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "row2");
				}

				ok_Hash.put("tAdvancedHash_row2", true);
				end_Hash.put("tAdvancedHash_row2", System.currentTimeMillis());

				/**
				 * [tAdvancedHash_row2 end ] stop
				 */

			} // end the resume

		} catch (java.lang.Exception e) {

			TalendException te = new TalendException(e, currentComponent, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			try {

				/**
				 * [tDBInput_2 finally ] start
				 */

				currentComponent = "tDBInput_2";

				/**
				 * [tDBInput_2 finally ] stop
				 */

				/**
				 * [tAdvancedHash_row2 finally ] start
				 */

				currentComponent = "tAdvancedHash_row2";

				/**
				 * [tAdvancedHash_row2 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tDBInput_2_SUBPROCESS_STATE", 1);
	}

	public static class row3Struct implements routines.system.IPersistableComparableLookupRow<row3Struct> {
		final static byte[] commonByteArrayLock_PROJETDATAV1_Job04_Geography_Dim = new byte[0];
		static byte[] commonByteArray_PROJETDATAV1_Job04_Geography_Dim = new byte[0];
		protected static final int DEFAULT_HASHCODE = 1;
		protected static final int PRIME = 31;
		protected int hashCode = DEFAULT_HASHCODE;
		public boolean hashCodeDirty = true;

		public String loopKey;

		public String COUNTRY;

		public String getCOUNTRY() {
			return this.COUNTRY;
		}

		public String COUNTRY_NAME;

		public String getCOUNTRY_NAME() {
			return this.COUNTRY_NAME;
		}

		public Double POPULATION;

		public Double getPOPULATION() {
			return this.POPULATION;
		}

		public Double COUNTRY_ID;

		public Double getCOUNTRY_ID() {
			return this.COUNTRY_ID;
		}

		public Double CONTINENT_ID;

		public Double getCONTINENT_ID() {
			return this.CONTINENT_ID;
		}

		public String COUNTRY_FORMERNAME;

		public String getCOUNTRY_FORMERNAME() {
			return this.COUNTRY_FORMERNAME;
		}

		@Override
		public int hashCode() {
			if (this.hashCodeDirty) {
				final int prime = PRIME;
				int result = DEFAULT_HASHCODE;

				result = prime * result + ((this.CONTINENT_ID == null) ? 0 : this.CONTINENT_ID.hashCode());

				this.hashCode = result;
				this.hashCodeDirty = false;
			}
			return this.hashCode;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			final row3Struct other = (row3Struct) obj;

			if (this.CONTINENT_ID == null) {
				if (other.CONTINENT_ID != null)
					return false;

			} else if (!this.CONTINENT_ID.equals(other.CONTINENT_ID))

				return false;

			return true;
		}

		public void copyDataTo(row3Struct other) {

			other.COUNTRY = this.COUNTRY;
			other.COUNTRY_NAME = this.COUNTRY_NAME;
			other.POPULATION = this.POPULATION;
			other.COUNTRY_ID = this.COUNTRY_ID;
			other.CONTINENT_ID = this.CONTINENT_ID;
			other.COUNTRY_FORMERNAME = this.COUNTRY_FORMERNAME;

		}

		public void copyKeysDataTo(row3Struct other) {

			other.CONTINENT_ID = this.CONTINENT_ID;

		}

		private String readString(DataInputStream dis, ObjectInputStream ois) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				byte[] byteArray = new byte[length];
				dis.read(byteArray);
				strReturn = new String(byteArray, utf8Charset);
			}
			return strReturn;
		}

		private String readString(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller)
				throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				byte[] byteArray = new byte[length];
				unmarshaller.read(byteArray);
				strReturn = new String(byteArray, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, DataOutputStream dos, org.jboss.marshalling.Marshaller marshaller)
				throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		private void writeString(String str, DataOutputStream dos, ObjectOutputStream oos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		public void readKeysData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_PROJETDATAV1_Job04_Geography_Dim) {

				try {

					int length = 0;

					length = dis.readByte();
					if (length == -1) {
						this.CONTINENT_ID = null;
					} else {
						this.CONTINENT_ID = dis.readDouble();
					}

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_PROJETDATAV1_Job04_Geography_Dim) {

				try {

					int length = 0;

					length = dis.readByte();
					if (length == -1) {
						this.CONTINENT_ID = null;
					} else {
						this.CONTINENT_ID = dis.readDouble();
					}

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeKeysData(ObjectOutputStream dos) {
			try {

				// Double

				if (this.CONTINENT_ID == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this.CONTINENT_ID);
				}

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
			try {

				// Double

				if (this.CONTINENT_ID == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this.CONTINENT_ID);
				}

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		/**
		 * Fill Values data by reading ObjectInputStream.
		 */
		public void readValuesData(DataInputStream dis, ObjectInputStream ois) {
			try {

				int length = 0;

				this.COUNTRY = readString(dis, ois);

				this.COUNTRY_NAME = readString(dis, ois);

				length = dis.readByte();
				if (length == -1) {
					this.POPULATION = null;
				} else {
					this.POPULATION = dis.readDouble();
				}

				length = dis.readByte();
				if (length == -1) {
					this.COUNTRY_ID = null;
				} else {
					this.COUNTRY_ID = dis.readDouble();
				}

				this.COUNTRY_FORMERNAME = readString(dis, ois);

			} catch (IOException e) {
				throw new RuntimeException(e);

			}

		}

		public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
			try {
				int length = 0;

				this.COUNTRY = readString(dis, objectIn);

				this.COUNTRY_NAME = readString(dis, objectIn);

				length = objectIn.readByte();
				if (length == -1) {
					this.POPULATION = null;
				} else {
					this.POPULATION = objectIn.readDouble();
				}

				length = objectIn.readByte();
				if (length == -1) {
					this.COUNTRY_ID = null;
				} else {
					this.COUNTRY_ID = objectIn.readDouble();
				}

				this.COUNTRY_FORMERNAME = readString(dis, objectIn);

			} catch (IOException e) {
				throw new RuntimeException(e);

			}

		}

		/**
		 * Return a byte array which represents Values data.
		 */
		public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
			try {

				writeString(this.COUNTRY, dos, oos);

				writeString(this.COUNTRY_NAME, dos, oos);

				if (this.POPULATION == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this.POPULATION);
				}

				if (this.COUNTRY_ID == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this.COUNTRY_ID);
				}

				writeString(this.COUNTRY_FORMERNAME, dos, oos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut) {
			try {

				writeString(this.COUNTRY, dos, objectOut);

				writeString(this.COUNTRY_NAME, dos, objectOut);

				if (this.POPULATION == null) {
					objectOut.writeByte(-1);
				} else {
					objectOut.writeByte(0);
					objectOut.writeDouble(this.POPULATION);
				}

				if (this.COUNTRY_ID == null) {
					objectOut.writeByte(-1);
				} else {
					objectOut.writeByte(0);
					objectOut.writeDouble(this.COUNTRY_ID);
				}

				writeString(this.COUNTRY_FORMERNAME, dos, objectOut);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}

		public boolean supportMarshaller() {
			return true;
		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("COUNTRY=" + COUNTRY);
			sb.append(",COUNTRY_NAME=" + COUNTRY_NAME);
			sb.append(",POPULATION=" + String.valueOf(POPULATION));
			sb.append(",COUNTRY_ID=" + String.valueOf(COUNTRY_ID));
			sb.append(",CONTINENT_ID=" + String.valueOf(CONTINENT_ID));
			sb.append(",COUNTRY_FORMERNAME=" + COUNTRY_FORMERNAME);
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row3Struct other) {

			int returnValue = -1;

			returnValue = checkNullsAndCompare(this.CONTINENT_ID, other.CONTINENT_ID);
			if (returnValue != 0) {
				return returnValue;
			}

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public void tDBInput_3Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tDBInput_3_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		String iterateId = "";

		String currentComponent = "";
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				row3Struct row3 = new row3Struct();

				/**
				 * [tAdvancedHash_row3 begin ] start
				 */

				ok_Hash.put("tAdvancedHash_row3", false);
				start_Hash.put("tAdvancedHash_row3", System.currentTimeMillis());

				currentComponent = "tAdvancedHash_row3";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row3");
				}

				int tos_count_tAdvancedHash_row3 = 0;

				// connection name:row3
				// source node:tDBInput_3 - inputs:(after_tDBInput_1) outputs:(row3,row3) |
				// target node:tAdvancedHash_row3 - inputs:(row3) outputs:()
				// linked node: tMap_1 - inputs:(row1,row2,row3,row4,row6,row7,row8)
				// outputs:(Geography_Dim_Output)

				org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_row3 = org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.UNIQUE_MATCH;

				org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row3Struct> tHash_Lookup_row3 = org.talend.designer.components.lookup.memory.AdvancedMemoryLookup
						.<row3Struct>getLookup(matchingModeEnum_row3);

				globalMap.put("tHash_Lookup_row3", tHash_Lookup_row3);

				/**
				 * [tAdvancedHash_row3 begin ] stop
				 */

				/**
				 * [tDBInput_3 begin ] start
				 */

				ok_Hash.put("tDBInput_3", false);
				start_Hash.put("tDBInput_3", System.currentTimeMillis());

				currentComponent = "tDBInput_3";

				int tos_count_tDBInput_3 = 0;

				int nb_line_tDBInput_3 = 0;
				java.sql.Connection conn_tDBInput_3 = null;
				String driverClass_tDBInput_3 = "net.ucanaccess.jdbc.UcanaccessDriver";
				java.lang.Class.forName(driverClass_tDBInput_3);

				String url_tDBInput_3 = "jdbc:ucanaccess://" + context.Connect_Data_File
						+ ";jackcessOpener=org.talend.ucanaccess.encrypt.CryptCodecOpener;singleConnection=true";
				String dbUser_tDBInput_3 = context.Connect_Data_Login;

				final String decryptedPassword_tDBInput_3 = context.Connect_Data_Password;

				String dbPwd_tDBInput_3 = decryptedPassword_tDBInput_3;

				String atnParams_tDBInput_3 = context.Connect_Data_AdditionalParams;
				atnParams_tDBInput_3 = atnParams_tDBInput_3.replaceAll("&", "\n");
				java.util.Properties atnParamsPrope_tDBInput_3 = new java.util.Properties();
				atnParamsPrope_tDBInput_3.put("user", dbUser_tDBInput_3);
				atnParamsPrope_tDBInput_3.put("password", dbPwd_tDBInput_3);
				atnParamsPrope_tDBInput_3.load(new java.io.ByteArrayInputStream(atnParams_tDBInput_3.getBytes()));
				conn_tDBInput_3 = java.sql.DriverManager.getConnection(url_tDBInput_3, atnParamsPrope_tDBInput_3);

				java.sql.Statement stmt_tDBInput_3 = conn_tDBInput_3.createStatement();

				String dbquery_tDBInput_3 = "SELECT \n  COUNTRY.COUNTRY, \n  COUNTRY.COUNTRY_NAME, \n  COUNTRY.POPULATION, \n  COUNTRY.COUNTRY_ID, \n  COUNTRY.CONTINENT_"
						+ "ID, \n  COUNTRY.COUNTRY_FORMERNAME\nFROM COUNTRY";

				globalMap.put("tDBInput_3_QUERY", dbquery_tDBInput_3);
				java.sql.ResultSet rs_tDBInput_3 = null;

				try {
					rs_tDBInput_3 = stmt_tDBInput_3.executeQuery(dbquery_tDBInput_3);
					java.sql.ResultSetMetaData rsmd_tDBInput_3 = rs_tDBInput_3.getMetaData();
					int colQtyInRs_tDBInput_3 = rsmd_tDBInput_3.getColumnCount();

					String tmpContent_tDBInput_3 = null;

					while (rs_tDBInput_3.next()) {
						nb_line_tDBInput_3++;

						if (colQtyInRs_tDBInput_3 < 1) {
							row3.COUNTRY = null;
						} else {

							row3.COUNTRY = routines.system.JDBCUtil.getString(rs_tDBInput_3, 1, false);
						}
						if (colQtyInRs_tDBInput_3 < 2) {
							row3.COUNTRY_NAME = null;
						} else {

							row3.COUNTRY_NAME = routines.system.JDBCUtil.getString(rs_tDBInput_3, 2, false);
						}
						if (colQtyInRs_tDBInput_3 < 3) {
							row3.POPULATION = null;
						} else {

							row3.POPULATION = rs_tDBInput_3.getDouble(3);
							if (rs_tDBInput_3.wasNull()) {
								row3.POPULATION = null;
							}
						}
						if (colQtyInRs_tDBInput_3 < 4) {
							row3.COUNTRY_ID = null;
						} else {

							row3.COUNTRY_ID = rs_tDBInput_3.getDouble(4);
							if (rs_tDBInput_3.wasNull()) {
								row3.COUNTRY_ID = null;
							}
						}
						if (colQtyInRs_tDBInput_3 < 5) {
							row3.CONTINENT_ID = null;
						} else {

							row3.CONTINENT_ID = rs_tDBInput_3.getDouble(5);
							if (rs_tDBInput_3.wasNull()) {
								row3.CONTINENT_ID = null;
							}
						}
						if (colQtyInRs_tDBInput_3 < 6) {
							row3.COUNTRY_FORMERNAME = null;
						} else {

							row3.COUNTRY_FORMERNAME = routines.system.JDBCUtil.getString(rs_tDBInput_3, 6, false);
						}

						/**
						 * [tDBInput_3 begin ] stop
						 */

						/**
						 * [tDBInput_3 main ] start
						 */

						currentComponent = "tDBInput_3";

						tos_count_tDBInput_3++;

						/**
						 * [tDBInput_3 main ] stop
						 */

						/**
						 * [tDBInput_3 process_data_begin ] start
						 */

						currentComponent = "tDBInput_3";

						/**
						 * [tDBInput_3 process_data_begin ] stop
						 */

						/**
						 * [tAdvancedHash_row3 main ] start
						 */

						currentComponent = "tAdvancedHash_row3";

						if (execStat) {
							runStat.updateStatOnConnection(iterateId, 1, 1

									, "row3"

							);
						}

						row3Struct row3_HashRow = new row3Struct();

						row3_HashRow.COUNTRY = row3.COUNTRY;

						row3_HashRow.COUNTRY_NAME = row3.COUNTRY_NAME;

						row3_HashRow.POPULATION = row3.POPULATION;

						row3_HashRow.COUNTRY_ID = row3.COUNTRY_ID;

						row3_HashRow.CONTINENT_ID = row3.CONTINENT_ID;

						row3_HashRow.COUNTRY_FORMERNAME = row3.COUNTRY_FORMERNAME;

						tHash_Lookup_row3.put(row3_HashRow);

						tos_count_tAdvancedHash_row3++;

						/**
						 * [tAdvancedHash_row3 main ] stop
						 */

						/**
						 * [tAdvancedHash_row3 process_data_begin ] start
						 */

						currentComponent = "tAdvancedHash_row3";

						/**
						 * [tAdvancedHash_row3 process_data_begin ] stop
						 */

						/**
						 * [tAdvancedHash_row3 process_data_end ] start
						 */

						currentComponent = "tAdvancedHash_row3";

						/**
						 * [tAdvancedHash_row3 process_data_end ] stop
						 */

						/**
						 * [tDBInput_3 process_data_end ] start
						 */

						currentComponent = "tDBInput_3";

						/**
						 * [tDBInput_3 process_data_end ] stop
						 */

						/**
						 * [tDBInput_3 end ] start
						 */

						currentComponent = "tDBInput_3";

					}
				} finally {
					if (rs_tDBInput_3 != null) {
						rs_tDBInput_3.close();
					}
					if (stmt_tDBInput_3 != null) {
						stmt_tDBInput_3.close();
					}
					if (conn_tDBInput_3 != null && !conn_tDBInput_3.isClosed()) {

						conn_tDBInput_3.close();

						if ("com.mysql.cj.jdbc.Driver".equals((String) globalMap.get("driverClass_"))
								&& routines.system.BundleUtils.inOSGi()) {
							Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread")
									.getMethod("checkedShutdown").invoke(null, (Object[]) null);
						}

					}
				}
				globalMap.put("tDBInput_3_NB_LINE", nb_line_tDBInput_3);

				ok_Hash.put("tDBInput_3", true);
				end_Hash.put("tDBInput_3", System.currentTimeMillis());

				/**
				 * [tDBInput_3 end ] stop
				 */

				/**
				 * [tAdvancedHash_row3 end ] start
				 */

				currentComponent = "tAdvancedHash_row3";

				tHash_Lookup_row3.endPut();

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "row3");
				}

				ok_Hash.put("tAdvancedHash_row3", true);
				end_Hash.put("tAdvancedHash_row3", System.currentTimeMillis());

				/**
				 * [tAdvancedHash_row3 end ] stop
				 */

			} // end the resume

		} catch (java.lang.Exception e) {

			TalendException te = new TalendException(e, currentComponent, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			try {

				/**
				 * [tDBInput_3 finally ] start
				 */

				currentComponent = "tDBInput_3";

				/**
				 * [tDBInput_3 finally ] stop
				 */

				/**
				 * [tAdvancedHash_row3 finally ] start
				 */

				currentComponent = "tAdvancedHash_row3";

				/**
				 * [tAdvancedHash_row3 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tDBInput_3_SUBPROCESS_STATE", 1);
	}

	public static class row4Struct implements routines.system.IPersistableRow<row4Struct> {
		final static byte[] commonByteArrayLock_PROJETDATAV1_Job04_Geography_Dim = new byte[0];
		static byte[] commonByteArray_PROJETDATAV1_Job04_Geography_Dim = new byte[0];

		public Double STATE_ID;

		public Double getSTATE_ID() {
			return this.STATE_ID;
		}

		public Double STATE_TYPE;

		public Double getSTATE_TYPE() {
			return this.STATE_TYPE;
		}

		public String STATE_CODE;

		public String getSTATE_CODE() {
			return this.STATE_CODE;
		}

		public String STATE_NAME;

		public String getSTATE_NAME() {
			return this.STATE_NAME;
		}

		public String COUNTRY;

		public String getCOUNTRY() {
			return this.COUNTRY;
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_PROJETDATAV1_Job04_Geography_Dim.length) {
					if (length < 1024 && commonByteArray_PROJETDATAV1_Job04_Geography_Dim.length == 0) {
						commonByteArray_PROJETDATAV1_Job04_Geography_Dim = new byte[1024];
					} else {
						commonByteArray_PROJETDATAV1_Job04_Geography_Dim = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_PROJETDATAV1_Job04_Geography_Dim, 0, length);
				strReturn = new String(commonByteArray_PROJETDATAV1_Job04_Geography_Dim, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_PROJETDATAV1_Job04_Geography_Dim.length) {
					if (length < 1024 && commonByteArray_PROJETDATAV1_Job04_Geography_Dim.length == 0) {
						commonByteArray_PROJETDATAV1_Job04_Geography_Dim = new byte[1024];
					} else {
						commonByteArray_PROJETDATAV1_Job04_Geography_Dim = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_PROJETDATAV1_Job04_Geography_Dim, 0, length);
				strReturn = new String(commonByteArray_PROJETDATAV1_Job04_Geography_Dim, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_PROJETDATAV1_Job04_Geography_Dim) {

				try {

					int length = 0;

					length = dis.readByte();
					if (length == -1) {
						this.STATE_ID = null;
					} else {
						this.STATE_ID = dis.readDouble();
					}

					length = dis.readByte();
					if (length == -1) {
						this.STATE_TYPE = null;
					} else {
						this.STATE_TYPE = dis.readDouble();
					}

					this.STATE_CODE = readString(dis);

					this.STATE_NAME = readString(dis);

					this.COUNTRY = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_PROJETDATAV1_Job04_Geography_Dim) {

				try {

					int length = 0;

					length = dis.readByte();
					if (length == -1) {
						this.STATE_ID = null;
					} else {
						this.STATE_ID = dis.readDouble();
					}

					length = dis.readByte();
					if (length == -1) {
						this.STATE_TYPE = null;
					} else {
						this.STATE_TYPE = dis.readDouble();
					}

					this.STATE_CODE = readString(dis);

					this.STATE_NAME = readString(dis);

					this.COUNTRY = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// Double

				if (this.STATE_ID == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this.STATE_ID);
				}

				// Double

				if (this.STATE_TYPE == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this.STATE_TYPE);
				}

				// String

				writeString(this.STATE_CODE, dos);

				// String

				writeString(this.STATE_NAME, dos);

				// String

				writeString(this.COUNTRY, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// Double

				if (this.STATE_ID == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this.STATE_ID);
				}

				// Double

				if (this.STATE_TYPE == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this.STATE_TYPE);
				}

				// String

				writeString(this.STATE_CODE, dos);

				// String

				writeString(this.STATE_NAME, dos);

				// String

				writeString(this.COUNTRY, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("STATE_ID=" + String.valueOf(STATE_ID));
			sb.append(",STATE_TYPE=" + String.valueOf(STATE_TYPE));
			sb.append(",STATE_CODE=" + STATE_CODE);
			sb.append(",STATE_NAME=" + STATE_NAME);
			sb.append(",COUNTRY=" + COUNTRY);
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row4Struct other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public void tDBInput_4Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tDBInput_4_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		String iterateId = "";

		String currentComponent = "";
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				row4Struct row4 = new row4Struct();

				/**
				 * [tAdvancedHash_row4 begin ] start
				 */

				ok_Hash.put("tAdvancedHash_row4", false);
				start_Hash.put("tAdvancedHash_row4", System.currentTimeMillis());

				currentComponent = "tAdvancedHash_row4";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row4");
				}

				int tos_count_tAdvancedHash_row4 = 0;

				// connection name:row4
				// source node:tDBInput_4 - inputs:(after_tDBInput_1) outputs:(row4,row4) |
				// target node:tAdvancedHash_row4 - inputs:(row4) outputs:()
				// linked node: tMap_1 - inputs:(row1,row2,row3,row4,row6,row7,row8)
				// outputs:(Geography_Dim_Output)

				org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_row4 = org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.ALL_ROWS;

				org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row4Struct> tHash_Lookup_row4 = org.talend.designer.components.lookup.memory.AdvancedMemoryLookup
						.<row4Struct>getLookup(matchingModeEnum_row4);

				globalMap.put("tHash_Lookup_row4", tHash_Lookup_row4);

				/**
				 * [tAdvancedHash_row4 begin ] stop
				 */

				/**
				 * [tDBInput_4 begin ] start
				 */

				ok_Hash.put("tDBInput_4", false);
				start_Hash.put("tDBInput_4", System.currentTimeMillis());

				currentComponent = "tDBInput_4";

				int tos_count_tDBInput_4 = 0;

				int nb_line_tDBInput_4 = 0;
				java.sql.Connection conn_tDBInput_4 = null;
				String driverClass_tDBInput_4 = "net.ucanaccess.jdbc.UcanaccessDriver";
				java.lang.Class.forName(driverClass_tDBInput_4);

				String url_tDBInput_4 = "jdbc:ucanaccess://" + context.Connect_Data_File
						+ ";jackcessOpener=org.talend.ucanaccess.encrypt.CryptCodecOpener;singleConnection=true";
				String dbUser_tDBInput_4 = context.Connect_Data_Login;

				final String decryptedPassword_tDBInput_4 = context.Connect_Data_Password;

				String dbPwd_tDBInput_4 = decryptedPassword_tDBInput_4;

				String atnParams_tDBInput_4 = context.Connect_Data_AdditionalParams;
				atnParams_tDBInput_4 = atnParams_tDBInput_4.replaceAll("&", "\n");
				java.util.Properties atnParamsPrope_tDBInput_4 = new java.util.Properties();
				atnParamsPrope_tDBInput_4.put("user", dbUser_tDBInput_4);
				atnParamsPrope_tDBInput_4.put("password", dbPwd_tDBInput_4);
				atnParamsPrope_tDBInput_4.load(new java.io.ByteArrayInputStream(atnParams_tDBInput_4.getBytes()));
				conn_tDBInput_4 = java.sql.DriverManager.getConnection(url_tDBInput_4, atnParamsPrope_tDBInput_4);

				java.sql.Statement stmt_tDBInput_4 = conn_tDBInput_4.createStatement();

				String dbquery_tDBInput_4 = "SELECT \n  STATE.STATE_ID, \n  STATE.STATE_TYPE, \n  STATE.STATE_CODE, \n  STATE.STATE_NAME, \n  STATE.COUNTRY\nFROM STATE";

				globalMap.put("tDBInput_4_QUERY", dbquery_tDBInput_4);
				java.sql.ResultSet rs_tDBInput_4 = null;

				try {
					rs_tDBInput_4 = stmt_tDBInput_4.executeQuery(dbquery_tDBInput_4);
					java.sql.ResultSetMetaData rsmd_tDBInput_4 = rs_tDBInput_4.getMetaData();
					int colQtyInRs_tDBInput_4 = rsmd_tDBInput_4.getColumnCount();

					String tmpContent_tDBInput_4 = null;

					while (rs_tDBInput_4.next()) {
						nb_line_tDBInput_4++;

						if (colQtyInRs_tDBInput_4 < 1) {
							row4.STATE_ID = null;
						} else {

							row4.STATE_ID = rs_tDBInput_4.getDouble(1);
							if (rs_tDBInput_4.wasNull()) {
								row4.STATE_ID = null;
							}
						}
						if (colQtyInRs_tDBInput_4 < 2) {
							row4.STATE_TYPE = null;
						} else {

							row4.STATE_TYPE = rs_tDBInput_4.getDouble(2);
							if (rs_tDBInput_4.wasNull()) {
								row4.STATE_TYPE = null;
							}
						}
						if (colQtyInRs_tDBInput_4 < 3) {
							row4.STATE_CODE = null;
						} else {

							row4.STATE_CODE = routines.system.JDBCUtil.getString(rs_tDBInput_4, 3, false);
						}
						if (colQtyInRs_tDBInput_4 < 4) {
							row4.STATE_NAME = null;
						} else {

							row4.STATE_NAME = routines.system.JDBCUtil.getString(rs_tDBInput_4, 4, false);
						}
						if (colQtyInRs_tDBInput_4 < 5) {
							row4.COUNTRY = null;
						} else {

							row4.COUNTRY = routines.system.JDBCUtil.getString(rs_tDBInput_4, 5, false);
						}

						/**
						 * [tDBInput_4 begin ] stop
						 */

						/**
						 * [tDBInput_4 main ] start
						 */

						currentComponent = "tDBInput_4";

						tos_count_tDBInput_4++;

						/**
						 * [tDBInput_4 main ] stop
						 */

						/**
						 * [tDBInput_4 process_data_begin ] start
						 */

						currentComponent = "tDBInput_4";

						/**
						 * [tDBInput_4 process_data_begin ] stop
						 */

						/**
						 * [tAdvancedHash_row4 main ] start
						 */

						currentComponent = "tAdvancedHash_row4";

						if (execStat) {
							runStat.updateStatOnConnection(iterateId, 1, 1

									, "row4"

							);
						}

						row4Struct row4_HashRow = new row4Struct();

						row4_HashRow.STATE_ID = row4.STATE_ID;

						row4_HashRow.STATE_TYPE = row4.STATE_TYPE;

						row4_HashRow.STATE_CODE = row4.STATE_CODE;

						row4_HashRow.STATE_NAME = row4.STATE_NAME;

						row4_HashRow.COUNTRY = row4.COUNTRY;

						tHash_Lookup_row4.put(row4_HashRow);

						tos_count_tAdvancedHash_row4++;

						/**
						 * [tAdvancedHash_row4 main ] stop
						 */

						/**
						 * [tAdvancedHash_row4 process_data_begin ] start
						 */

						currentComponent = "tAdvancedHash_row4";

						/**
						 * [tAdvancedHash_row4 process_data_begin ] stop
						 */

						/**
						 * [tAdvancedHash_row4 process_data_end ] start
						 */

						currentComponent = "tAdvancedHash_row4";

						/**
						 * [tAdvancedHash_row4 process_data_end ] stop
						 */

						/**
						 * [tDBInput_4 process_data_end ] start
						 */

						currentComponent = "tDBInput_4";

						/**
						 * [tDBInput_4 process_data_end ] stop
						 */

						/**
						 * [tDBInput_4 end ] start
						 */

						currentComponent = "tDBInput_4";

					}
				} finally {
					if (rs_tDBInput_4 != null) {
						rs_tDBInput_4.close();
					}
					if (stmt_tDBInput_4 != null) {
						stmt_tDBInput_4.close();
					}
					if (conn_tDBInput_4 != null && !conn_tDBInput_4.isClosed()) {

						conn_tDBInput_4.close();

						if ("com.mysql.cj.jdbc.Driver".equals((String) globalMap.get("driverClass_"))
								&& routines.system.BundleUtils.inOSGi()) {
							Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread")
									.getMethod("checkedShutdown").invoke(null, (Object[]) null);
						}

					}
				}
				globalMap.put("tDBInput_4_NB_LINE", nb_line_tDBInput_4);

				ok_Hash.put("tDBInput_4", true);
				end_Hash.put("tDBInput_4", System.currentTimeMillis());

				/**
				 * [tDBInput_4 end ] stop
				 */

				/**
				 * [tAdvancedHash_row4 end ] start
				 */

				currentComponent = "tAdvancedHash_row4";

				tHash_Lookup_row4.endPut();

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "row4");
				}

				ok_Hash.put("tAdvancedHash_row4", true);
				end_Hash.put("tAdvancedHash_row4", System.currentTimeMillis());

				/**
				 * [tAdvancedHash_row4 end ] stop
				 */

			} // end the resume

		} catch (java.lang.Exception e) {

			TalendException te = new TalendException(e, currentComponent, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			try {

				/**
				 * [tDBInput_4 finally ] start
				 */

				currentComponent = "tDBInput_4";

				/**
				 * [tDBInput_4 finally ] stop
				 */

				/**
				 * [tAdvancedHash_row4 finally ] start
				 */

				currentComponent = "tAdvancedHash_row4";

				/**
				 * [tAdvancedHash_row4 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tDBInput_4_SUBPROCESS_STATE", 1);
	}

	public static class row6Struct implements routines.system.IPersistableComparableLookupRow<row6Struct> {
		final static byte[] commonByteArrayLock_PROJETDATAV1_Job04_Geography_Dim = new byte[0];
		static byte[] commonByteArray_PROJETDATAV1_Job04_Geography_Dim = new byte[0];
		protected static final int DEFAULT_HASHCODE = 1;
		protected static final int PRIME = 31;
		protected int hashCode = DEFAULT_HASHCODE;
		public boolean hashCodeDirty = true;

		public String loopKey;

		public Double COUNTY_ID;

		public Double getCOUNTY_ID() {
			return this.COUNTY_ID;
		}

		public Double COUNTY_TYPE;

		public Double getCOUNTY_TYPE() {
			return this.COUNTY_TYPE;
		}

		public String COUNTY_NAME;

		public String getCOUNTY_NAME() {
			return this.COUNTY_NAME;
		}

		public Double PROVINCE_TYPE;

		public Double getPROVINCE_TYPE() {
			return this.PROVINCE_TYPE;
		}

		public String PROVINCE_NAME;

		public String getPROVINCE_NAME() {
			return this.PROVINCE_NAME;
		}

		public String REGION_NAME;

		public String getREGION_NAME() {
			return this.REGION_NAME;
		}

		public Double REGION_TYPE;

		public Double getREGION_TYPE() {
			return this.REGION_TYPE;
		}

		public Double STATE_ID;

		public Double getSTATE_ID() {
			return this.STATE_ID;
		}

		public String COUNTRY;

		public String getCOUNTRY() {
			return this.COUNTRY;
		}

		@Override
		public int hashCode() {
			if (this.hashCodeDirty) {
				final int prime = PRIME;
				int result = DEFAULT_HASHCODE;

				result = prime * result + ((this.STATE_ID == null) ? 0 : this.STATE_ID.hashCode());

				this.hashCode = result;
				this.hashCodeDirty = false;
			}
			return this.hashCode;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			final row6Struct other = (row6Struct) obj;

			if (this.STATE_ID == null) {
				if (other.STATE_ID != null)
					return false;

			} else if (!this.STATE_ID.equals(other.STATE_ID))

				return false;

			return true;
		}

		public void copyDataTo(row6Struct other) {

			other.COUNTY_ID = this.COUNTY_ID;
			other.COUNTY_TYPE = this.COUNTY_TYPE;
			other.COUNTY_NAME = this.COUNTY_NAME;
			other.PROVINCE_TYPE = this.PROVINCE_TYPE;
			other.PROVINCE_NAME = this.PROVINCE_NAME;
			other.REGION_NAME = this.REGION_NAME;
			other.REGION_TYPE = this.REGION_TYPE;
			other.STATE_ID = this.STATE_ID;
			other.COUNTRY = this.COUNTRY;

		}

		public void copyKeysDataTo(row6Struct other) {

			other.STATE_ID = this.STATE_ID;

		}

		private String readString(DataInputStream dis, ObjectInputStream ois) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				byte[] byteArray = new byte[length];
				dis.read(byteArray);
				strReturn = new String(byteArray, utf8Charset);
			}
			return strReturn;
		}

		private String readString(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller)
				throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				byte[] byteArray = new byte[length];
				unmarshaller.read(byteArray);
				strReturn = new String(byteArray, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, DataOutputStream dos, org.jboss.marshalling.Marshaller marshaller)
				throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		private void writeString(String str, DataOutputStream dos, ObjectOutputStream oos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		public void readKeysData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_PROJETDATAV1_Job04_Geography_Dim) {

				try {

					int length = 0;

					length = dis.readByte();
					if (length == -1) {
						this.STATE_ID = null;
					} else {
						this.STATE_ID = dis.readDouble();
					}

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_PROJETDATAV1_Job04_Geography_Dim) {

				try {

					int length = 0;

					length = dis.readByte();
					if (length == -1) {
						this.STATE_ID = null;
					} else {
						this.STATE_ID = dis.readDouble();
					}

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeKeysData(ObjectOutputStream dos) {
			try {

				// Double

				if (this.STATE_ID == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this.STATE_ID);
				}

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
			try {

				// Double

				if (this.STATE_ID == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this.STATE_ID);
				}

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		/**
		 * Fill Values data by reading ObjectInputStream.
		 */
		public void readValuesData(DataInputStream dis, ObjectInputStream ois) {
			try {

				int length = 0;

				length = dis.readByte();
				if (length == -1) {
					this.COUNTY_ID = null;
				} else {
					this.COUNTY_ID = dis.readDouble();
				}

				length = dis.readByte();
				if (length == -1) {
					this.COUNTY_TYPE = null;
				} else {
					this.COUNTY_TYPE = dis.readDouble();
				}

				this.COUNTY_NAME = readString(dis, ois);

				length = dis.readByte();
				if (length == -1) {
					this.PROVINCE_TYPE = null;
				} else {
					this.PROVINCE_TYPE = dis.readDouble();
				}

				this.PROVINCE_NAME = readString(dis, ois);

				this.REGION_NAME = readString(dis, ois);

				length = dis.readByte();
				if (length == -1) {
					this.REGION_TYPE = null;
				} else {
					this.REGION_TYPE = dis.readDouble();
				}

				this.COUNTRY = readString(dis, ois);

			} catch (IOException e) {
				throw new RuntimeException(e);

			}

		}

		public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
			try {
				int length = 0;

				length = objectIn.readByte();
				if (length == -1) {
					this.COUNTY_ID = null;
				} else {
					this.COUNTY_ID = objectIn.readDouble();
				}

				length = objectIn.readByte();
				if (length == -1) {
					this.COUNTY_TYPE = null;
				} else {
					this.COUNTY_TYPE = objectIn.readDouble();
				}

				this.COUNTY_NAME = readString(dis, objectIn);

				length = objectIn.readByte();
				if (length == -1) {
					this.PROVINCE_TYPE = null;
				} else {
					this.PROVINCE_TYPE = objectIn.readDouble();
				}

				this.PROVINCE_NAME = readString(dis, objectIn);

				this.REGION_NAME = readString(dis, objectIn);

				length = objectIn.readByte();
				if (length == -1) {
					this.REGION_TYPE = null;
				} else {
					this.REGION_TYPE = objectIn.readDouble();
				}

				this.COUNTRY = readString(dis, objectIn);

			} catch (IOException e) {
				throw new RuntimeException(e);

			}

		}

		/**
		 * Return a byte array which represents Values data.
		 */
		public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
			try {

				if (this.COUNTY_ID == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this.COUNTY_ID);
				}

				if (this.COUNTY_TYPE == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this.COUNTY_TYPE);
				}

				writeString(this.COUNTY_NAME, dos, oos);

				if (this.PROVINCE_TYPE == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this.PROVINCE_TYPE);
				}

				writeString(this.PROVINCE_NAME, dos, oos);

				writeString(this.REGION_NAME, dos, oos);

				if (this.REGION_TYPE == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this.REGION_TYPE);
				}

				writeString(this.COUNTRY, dos, oos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut) {
			try {

				if (this.COUNTY_ID == null) {
					objectOut.writeByte(-1);
				} else {
					objectOut.writeByte(0);
					objectOut.writeDouble(this.COUNTY_ID);
				}

				if (this.COUNTY_TYPE == null) {
					objectOut.writeByte(-1);
				} else {
					objectOut.writeByte(0);
					objectOut.writeDouble(this.COUNTY_TYPE);
				}

				writeString(this.COUNTY_NAME, dos, objectOut);

				if (this.PROVINCE_TYPE == null) {
					objectOut.writeByte(-1);
				} else {
					objectOut.writeByte(0);
					objectOut.writeDouble(this.PROVINCE_TYPE);
				}

				writeString(this.PROVINCE_NAME, dos, objectOut);

				writeString(this.REGION_NAME, dos, objectOut);

				if (this.REGION_TYPE == null) {
					objectOut.writeByte(-1);
				} else {
					objectOut.writeByte(0);
					objectOut.writeDouble(this.REGION_TYPE);
				}

				writeString(this.COUNTRY, dos, objectOut);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}

		public boolean supportMarshaller() {
			return true;
		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("COUNTY_ID=" + String.valueOf(COUNTY_ID));
			sb.append(",COUNTY_TYPE=" + String.valueOf(COUNTY_TYPE));
			sb.append(",COUNTY_NAME=" + COUNTY_NAME);
			sb.append(",PROVINCE_TYPE=" + String.valueOf(PROVINCE_TYPE));
			sb.append(",PROVINCE_NAME=" + PROVINCE_NAME);
			sb.append(",REGION_NAME=" + REGION_NAME);
			sb.append(",REGION_TYPE=" + String.valueOf(REGION_TYPE));
			sb.append(",STATE_ID=" + String.valueOf(STATE_ID));
			sb.append(",COUNTRY=" + COUNTRY);
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row6Struct other) {

			int returnValue = -1;

			returnValue = checkNullsAndCompare(this.STATE_ID, other.STATE_ID);
			if (returnValue != 0) {
				return returnValue;
			}

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public void tDBInput_5Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tDBInput_5_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		String iterateId = "";

		String currentComponent = "";
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				row6Struct row6 = new row6Struct();

				/**
				 * [tAdvancedHash_row6 begin ] start
				 */

				ok_Hash.put("tAdvancedHash_row6", false);
				start_Hash.put("tAdvancedHash_row6", System.currentTimeMillis());

				currentComponent = "tAdvancedHash_row6";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row6");
				}

				int tos_count_tAdvancedHash_row6 = 0;

				// connection name:row6
				// source node:tDBInput_5 - inputs:(after_tDBInput_1) outputs:(row6,row6) |
				// target node:tAdvancedHash_row6 - inputs:(row6) outputs:()
				// linked node: tMap_1 - inputs:(row1,row2,row3,row4,row6,row7,row8)
				// outputs:(Geography_Dim_Output)

				org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_row6 = org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.UNIQUE_MATCH;

				org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row6Struct> tHash_Lookup_row6 = org.talend.designer.components.lookup.memory.AdvancedMemoryLookup
						.<row6Struct>getLookup(matchingModeEnum_row6);

				globalMap.put("tHash_Lookup_row6", tHash_Lookup_row6);

				/**
				 * [tAdvancedHash_row6 begin ] stop
				 */

				/**
				 * [tDBInput_5 begin ] start
				 */

				ok_Hash.put("tDBInput_5", false);
				start_Hash.put("tDBInput_5", System.currentTimeMillis());

				currentComponent = "tDBInput_5";

				int tos_count_tDBInput_5 = 0;

				int nb_line_tDBInput_5 = 0;
				java.sql.Connection conn_tDBInput_5 = null;
				String driverClass_tDBInput_5 = "net.ucanaccess.jdbc.UcanaccessDriver";
				java.lang.Class.forName(driverClass_tDBInput_5);

				String url_tDBInput_5 = "jdbc:ucanaccess://" + context.Connect_Data_File
						+ ";jackcessOpener=org.talend.ucanaccess.encrypt.CryptCodecOpener;singleConnection=true";
				String dbUser_tDBInput_5 = context.Connect_Data_Login;

				final String decryptedPassword_tDBInput_5 = context.Connect_Data_Password;

				String dbPwd_tDBInput_5 = decryptedPassword_tDBInput_5;

				String atnParams_tDBInput_5 = context.Connect_Data_AdditionalParams;
				atnParams_tDBInput_5 = atnParams_tDBInput_5.replaceAll("&", "\n");
				java.util.Properties atnParamsPrope_tDBInput_5 = new java.util.Properties();
				atnParamsPrope_tDBInput_5.put("user", dbUser_tDBInput_5);
				atnParamsPrope_tDBInput_5.put("password", dbPwd_tDBInput_5);
				atnParamsPrope_tDBInput_5.load(new java.io.ByteArrayInputStream(atnParams_tDBInput_5.getBytes()));
				conn_tDBInput_5 = java.sql.DriverManager.getConnection(url_tDBInput_5, atnParamsPrope_tDBInput_5);

				java.sql.Statement stmt_tDBInput_5 = conn_tDBInput_5.createStatement();

				String dbquery_tDBInput_5 = "SELECT \n  COUNTY.COUNTY_ID, \n  COUNTY.COUNTY_TYPE, \n  COUNTY.COUNTY_NAME, \n  COUNTY.PROVINCE_TYPE, \n  COUNTY.PROVINCE_N"
						+ "AME, \n  COUNTY.REGION_NAME, \n  COUNTY.REGION_TYPE, \n  COUNTY.STATE_ID, \n  COUNTY.COUNTRY\nFROM COUNTY";

				globalMap.put("tDBInput_5_QUERY", dbquery_tDBInput_5);
				java.sql.ResultSet rs_tDBInput_5 = null;

				try {
					rs_tDBInput_5 = stmt_tDBInput_5.executeQuery(dbquery_tDBInput_5);
					java.sql.ResultSetMetaData rsmd_tDBInput_5 = rs_tDBInput_5.getMetaData();
					int colQtyInRs_tDBInput_5 = rsmd_tDBInput_5.getColumnCount();

					String tmpContent_tDBInput_5 = null;

					while (rs_tDBInput_5.next()) {
						nb_line_tDBInput_5++;

						if (colQtyInRs_tDBInput_5 < 1) {
							row6.COUNTY_ID = null;
						} else {

							row6.COUNTY_ID = rs_tDBInput_5.getDouble(1);
							if (rs_tDBInput_5.wasNull()) {
								row6.COUNTY_ID = null;
							}
						}
						if (colQtyInRs_tDBInput_5 < 2) {
							row6.COUNTY_TYPE = null;
						} else {

							row6.COUNTY_TYPE = rs_tDBInput_5.getDouble(2);
							if (rs_tDBInput_5.wasNull()) {
								row6.COUNTY_TYPE = null;
							}
						}
						if (colQtyInRs_tDBInput_5 < 3) {
							row6.COUNTY_NAME = null;
						} else {

							row6.COUNTY_NAME = routines.system.JDBCUtil.getString(rs_tDBInput_5, 3, false);
						}
						if (colQtyInRs_tDBInput_5 < 4) {
							row6.PROVINCE_TYPE = null;
						} else {

							row6.PROVINCE_TYPE = rs_tDBInput_5.getDouble(4);
							if (rs_tDBInput_5.wasNull()) {
								row6.PROVINCE_TYPE = null;
							}
						}
						if (colQtyInRs_tDBInput_5 < 5) {
							row6.PROVINCE_NAME = null;
						} else {

							row6.PROVINCE_NAME = routines.system.JDBCUtil.getString(rs_tDBInput_5, 5, false);
						}
						if (colQtyInRs_tDBInput_5 < 6) {
							row6.REGION_NAME = null;
						} else {

							row6.REGION_NAME = routines.system.JDBCUtil.getString(rs_tDBInput_5, 6, false);
						}
						if (colQtyInRs_tDBInput_5 < 7) {
							row6.REGION_TYPE = null;
						} else {

							row6.REGION_TYPE = rs_tDBInput_5.getDouble(7);
							if (rs_tDBInput_5.wasNull()) {
								row6.REGION_TYPE = null;
							}
						}
						if (colQtyInRs_tDBInput_5 < 8) {
							row6.STATE_ID = null;
						} else {

							row6.STATE_ID = rs_tDBInput_5.getDouble(8);
							if (rs_tDBInput_5.wasNull()) {
								row6.STATE_ID = null;
							}
						}
						if (colQtyInRs_tDBInput_5 < 9) {
							row6.COUNTRY = null;
						} else {

							row6.COUNTRY = routines.system.JDBCUtil.getString(rs_tDBInput_5, 9, false);
						}

						/**
						 * [tDBInput_5 begin ] stop
						 */

						/**
						 * [tDBInput_5 main ] start
						 */

						currentComponent = "tDBInput_5";

						tos_count_tDBInput_5++;

						/**
						 * [tDBInput_5 main ] stop
						 */

						/**
						 * [tDBInput_5 process_data_begin ] start
						 */

						currentComponent = "tDBInput_5";

						/**
						 * [tDBInput_5 process_data_begin ] stop
						 */

						/**
						 * [tAdvancedHash_row6 main ] start
						 */

						currentComponent = "tAdvancedHash_row6";

						if (execStat) {
							runStat.updateStatOnConnection(iterateId, 1, 1

									, "row6"

							);
						}

						row6Struct row6_HashRow = new row6Struct();

						row6_HashRow.COUNTY_ID = row6.COUNTY_ID;

						row6_HashRow.COUNTY_TYPE = row6.COUNTY_TYPE;

						row6_HashRow.COUNTY_NAME = row6.COUNTY_NAME;

						row6_HashRow.PROVINCE_TYPE = row6.PROVINCE_TYPE;

						row6_HashRow.PROVINCE_NAME = row6.PROVINCE_NAME;

						row6_HashRow.REGION_NAME = row6.REGION_NAME;

						row6_HashRow.REGION_TYPE = row6.REGION_TYPE;

						row6_HashRow.STATE_ID = row6.STATE_ID;

						row6_HashRow.COUNTRY = row6.COUNTRY;

						tHash_Lookup_row6.put(row6_HashRow);

						tos_count_tAdvancedHash_row6++;

						/**
						 * [tAdvancedHash_row6 main ] stop
						 */

						/**
						 * [tAdvancedHash_row6 process_data_begin ] start
						 */

						currentComponent = "tAdvancedHash_row6";

						/**
						 * [tAdvancedHash_row6 process_data_begin ] stop
						 */

						/**
						 * [tAdvancedHash_row6 process_data_end ] start
						 */

						currentComponent = "tAdvancedHash_row6";

						/**
						 * [tAdvancedHash_row6 process_data_end ] stop
						 */

						/**
						 * [tDBInput_5 process_data_end ] start
						 */

						currentComponent = "tDBInput_5";

						/**
						 * [tDBInput_5 process_data_end ] stop
						 */

						/**
						 * [tDBInput_5 end ] start
						 */

						currentComponent = "tDBInput_5";

					}
				} finally {
					if (rs_tDBInput_5 != null) {
						rs_tDBInput_5.close();
					}
					if (stmt_tDBInput_5 != null) {
						stmt_tDBInput_5.close();
					}
					if (conn_tDBInput_5 != null && !conn_tDBInput_5.isClosed()) {

						conn_tDBInput_5.close();

						if ("com.mysql.cj.jdbc.Driver".equals((String) globalMap.get("driverClass_"))
								&& routines.system.BundleUtils.inOSGi()) {
							Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread")
									.getMethod("checkedShutdown").invoke(null, (Object[]) null);
						}

					}
				}
				globalMap.put("tDBInput_5_NB_LINE", nb_line_tDBInput_5);

				ok_Hash.put("tDBInput_5", true);
				end_Hash.put("tDBInput_5", System.currentTimeMillis());

				/**
				 * [tDBInput_5 end ] stop
				 */

				/**
				 * [tAdvancedHash_row6 end ] start
				 */

				currentComponent = "tAdvancedHash_row6";

				tHash_Lookup_row6.endPut();

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "row6");
				}

				ok_Hash.put("tAdvancedHash_row6", true);
				end_Hash.put("tAdvancedHash_row6", System.currentTimeMillis());

				/**
				 * [tAdvancedHash_row6 end ] stop
				 */

			} // end the resume

		} catch (java.lang.Exception e) {

			TalendException te = new TalendException(e, currentComponent, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			try {

				/**
				 * [tDBInput_5 finally ] start
				 */

				currentComponent = "tDBInput_5";

				/**
				 * [tDBInput_5 finally ] stop
				 */

				/**
				 * [tAdvancedHash_row6 finally ] start
				 */

				currentComponent = "tAdvancedHash_row6";

				/**
				 * [tAdvancedHash_row6 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tDBInput_5_SUBPROCESS_STATE", 1);
	}

	public static class row7Struct implements routines.system.IPersistableRow<row7Struct> {
		final static byte[] commonByteArrayLock_PROJETDATAV1_Job04_Geography_Dim = new byte[0];
		static byte[] commonByteArray_PROJETDATAV1_Job04_Geography_Dim = new byte[0];

		public Double CITY_ID;

		public Double getCITY_ID() {
			return this.CITY_ID;
		}

		public String CITY_NAME;

		public String getCITY_NAME() {
			return this.CITY_NAME;
		}

		public String COUNTRY;

		public String getCOUNTRY() {
			return this.COUNTRY;
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_PROJETDATAV1_Job04_Geography_Dim.length) {
					if (length < 1024 && commonByteArray_PROJETDATAV1_Job04_Geography_Dim.length == 0) {
						commonByteArray_PROJETDATAV1_Job04_Geography_Dim = new byte[1024];
					} else {
						commonByteArray_PROJETDATAV1_Job04_Geography_Dim = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_PROJETDATAV1_Job04_Geography_Dim, 0, length);
				strReturn = new String(commonByteArray_PROJETDATAV1_Job04_Geography_Dim, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_PROJETDATAV1_Job04_Geography_Dim.length) {
					if (length < 1024 && commonByteArray_PROJETDATAV1_Job04_Geography_Dim.length == 0) {
						commonByteArray_PROJETDATAV1_Job04_Geography_Dim = new byte[1024];
					} else {
						commonByteArray_PROJETDATAV1_Job04_Geography_Dim = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_PROJETDATAV1_Job04_Geography_Dim, 0, length);
				strReturn = new String(commonByteArray_PROJETDATAV1_Job04_Geography_Dim, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_PROJETDATAV1_Job04_Geography_Dim) {

				try {

					int length = 0;

					length = dis.readByte();
					if (length == -1) {
						this.CITY_ID = null;
					} else {
						this.CITY_ID = dis.readDouble();
					}

					this.CITY_NAME = readString(dis);

					this.COUNTRY = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_PROJETDATAV1_Job04_Geography_Dim) {

				try {

					int length = 0;

					length = dis.readByte();
					if (length == -1) {
						this.CITY_ID = null;
					} else {
						this.CITY_ID = dis.readDouble();
					}

					this.CITY_NAME = readString(dis);

					this.COUNTRY = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// Double

				if (this.CITY_ID == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this.CITY_ID);
				}

				// String

				writeString(this.CITY_NAME, dos);

				// String

				writeString(this.COUNTRY, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// Double

				if (this.CITY_ID == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this.CITY_ID);
				}

				// String

				writeString(this.CITY_NAME, dos);

				// String

				writeString(this.COUNTRY, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("CITY_ID=" + String.valueOf(CITY_ID));
			sb.append(",CITY_NAME=" + CITY_NAME);
			sb.append(",COUNTRY=" + COUNTRY);
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row7Struct other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public void tDBInput_7Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tDBInput_7_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		String iterateId = "";

		String currentComponent = "";
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				row7Struct row7 = new row7Struct();

				/**
				 * [tAdvancedHash_row7 begin ] start
				 */

				ok_Hash.put("tAdvancedHash_row7", false);
				start_Hash.put("tAdvancedHash_row7", System.currentTimeMillis());

				currentComponent = "tAdvancedHash_row7";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row7");
				}

				int tos_count_tAdvancedHash_row7 = 0;

				// connection name:row7
				// source node:tDBInput_7 - inputs:(after_tDBInput_1) outputs:(row7,row7) |
				// target node:tAdvancedHash_row7 - inputs:(row7) outputs:()
				// linked node: tMap_1 - inputs:(row1,row2,row3,row4,row6,row7,row8)
				// outputs:(Geography_Dim_Output)

				org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_row7 = org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.ALL_ROWS;

				org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row7Struct> tHash_Lookup_row7 = org.talend.designer.components.lookup.memory.AdvancedMemoryLookup
						.<row7Struct>getLookup(matchingModeEnum_row7);

				globalMap.put("tHash_Lookup_row7", tHash_Lookup_row7);

				/**
				 * [tAdvancedHash_row7 begin ] stop
				 */

				/**
				 * [tDBInput_7 begin ] start
				 */

				ok_Hash.put("tDBInput_7", false);
				start_Hash.put("tDBInput_7", System.currentTimeMillis());

				currentComponent = "tDBInput_7";

				int tos_count_tDBInput_7 = 0;

				int nb_line_tDBInput_7 = 0;
				java.sql.Connection conn_tDBInput_7 = null;
				String driverClass_tDBInput_7 = "net.ucanaccess.jdbc.UcanaccessDriver";
				java.lang.Class.forName(driverClass_tDBInput_7);

				String url_tDBInput_7 = "jdbc:ucanaccess://" + context.Connect_Data_File
						+ ";jackcessOpener=org.talend.ucanaccess.encrypt.CryptCodecOpener;singleConnection=true";
				String dbUser_tDBInput_7 = context.Connect_Data_Login;

				final String decryptedPassword_tDBInput_7 = context.Connect_Data_Password;

				String dbPwd_tDBInput_7 = decryptedPassword_tDBInput_7;

				String atnParams_tDBInput_7 = context.Connect_Data_AdditionalParams;
				atnParams_tDBInput_7 = atnParams_tDBInput_7.replaceAll("&", "\n");
				java.util.Properties atnParamsPrope_tDBInput_7 = new java.util.Properties();
				atnParamsPrope_tDBInput_7.put("user", dbUser_tDBInput_7);
				atnParamsPrope_tDBInput_7.put("password", dbPwd_tDBInput_7);
				atnParamsPrope_tDBInput_7.load(new java.io.ByteArrayInputStream(atnParams_tDBInput_7.getBytes()));
				conn_tDBInput_7 = java.sql.DriverManager.getConnection(url_tDBInput_7, atnParamsPrope_tDBInput_7);

				java.sql.Statement stmt_tDBInput_7 = conn_tDBInput_7.createStatement();

				String dbquery_tDBInput_7 = "SELECT \n  CITY.CITY_ID, \n  CITY.CITY_NAME, \n  CITY.COUNTRY\nFROM CITY";

				globalMap.put("tDBInput_7_QUERY", dbquery_tDBInput_7);
				java.sql.ResultSet rs_tDBInput_7 = null;

				try {
					rs_tDBInput_7 = stmt_tDBInput_7.executeQuery(dbquery_tDBInput_7);
					java.sql.ResultSetMetaData rsmd_tDBInput_7 = rs_tDBInput_7.getMetaData();
					int colQtyInRs_tDBInput_7 = rsmd_tDBInput_7.getColumnCount();

					String tmpContent_tDBInput_7 = null;

					while (rs_tDBInput_7.next()) {
						nb_line_tDBInput_7++;

						if (colQtyInRs_tDBInput_7 < 1) {
							row7.CITY_ID = null;
						} else {

							row7.CITY_ID = rs_tDBInput_7.getDouble(1);
							if (rs_tDBInput_7.wasNull()) {
								row7.CITY_ID = null;
							}
						}
						if (colQtyInRs_tDBInput_7 < 2) {
							row7.CITY_NAME = null;
						} else {

							row7.CITY_NAME = routines.system.JDBCUtil.getString(rs_tDBInput_7, 2, false);
						}
						if (colQtyInRs_tDBInput_7 < 3) {
							row7.COUNTRY = null;
						} else {

							row7.COUNTRY = routines.system.JDBCUtil.getString(rs_tDBInput_7, 3, false);
						}

						/**
						 * [tDBInput_7 begin ] stop
						 */

						/**
						 * [tDBInput_7 main ] start
						 */

						currentComponent = "tDBInput_7";

						tos_count_tDBInput_7++;

						/**
						 * [tDBInput_7 main ] stop
						 */

						/**
						 * [tDBInput_7 process_data_begin ] start
						 */

						currentComponent = "tDBInput_7";

						/**
						 * [tDBInput_7 process_data_begin ] stop
						 */

						/**
						 * [tAdvancedHash_row7 main ] start
						 */

						currentComponent = "tAdvancedHash_row7";

						if (execStat) {
							runStat.updateStatOnConnection(iterateId, 1, 1

									, "row7"

							);
						}

						row7Struct row7_HashRow = new row7Struct();

						row7_HashRow.CITY_ID = row7.CITY_ID;

						row7_HashRow.CITY_NAME = row7.CITY_NAME;

						row7_HashRow.COUNTRY = row7.COUNTRY;

						tHash_Lookup_row7.put(row7_HashRow);

						tos_count_tAdvancedHash_row7++;

						/**
						 * [tAdvancedHash_row7 main ] stop
						 */

						/**
						 * [tAdvancedHash_row7 process_data_begin ] start
						 */

						currentComponent = "tAdvancedHash_row7";

						/**
						 * [tAdvancedHash_row7 process_data_begin ] stop
						 */

						/**
						 * [tAdvancedHash_row7 process_data_end ] start
						 */

						currentComponent = "tAdvancedHash_row7";

						/**
						 * [tAdvancedHash_row7 process_data_end ] stop
						 */

						/**
						 * [tDBInput_7 process_data_end ] start
						 */

						currentComponent = "tDBInput_7";

						/**
						 * [tDBInput_7 process_data_end ] stop
						 */

						/**
						 * [tDBInput_7 end ] start
						 */

						currentComponent = "tDBInput_7";

					}
				} finally {
					if (rs_tDBInput_7 != null) {
						rs_tDBInput_7.close();
					}
					if (stmt_tDBInput_7 != null) {
						stmt_tDBInput_7.close();
					}
					if (conn_tDBInput_7 != null && !conn_tDBInput_7.isClosed()) {

						conn_tDBInput_7.close();

						if ("com.mysql.cj.jdbc.Driver".equals((String) globalMap.get("driverClass_"))
								&& routines.system.BundleUtils.inOSGi()) {
							Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread")
									.getMethod("checkedShutdown").invoke(null, (Object[]) null);
						}

					}
				}
				globalMap.put("tDBInput_7_NB_LINE", nb_line_tDBInput_7);

				ok_Hash.put("tDBInput_7", true);
				end_Hash.put("tDBInput_7", System.currentTimeMillis());

				/**
				 * [tDBInput_7 end ] stop
				 */

				/**
				 * [tAdvancedHash_row7 end ] start
				 */

				currentComponent = "tAdvancedHash_row7";

				tHash_Lookup_row7.endPut();

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "row7");
				}

				ok_Hash.put("tAdvancedHash_row7", true);
				end_Hash.put("tAdvancedHash_row7", System.currentTimeMillis());

				/**
				 * [tAdvancedHash_row7 end ] stop
				 */

			} // end the resume

		} catch (java.lang.Exception e) {

			TalendException te = new TalendException(e, currentComponent, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			try {

				/**
				 * [tDBInput_7 finally ] start
				 */

				currentComponent = "tDBInput_7";

				/**
				 * [tDBInput_7 finally ] stop
				 */

				/**
				 * [tAdvancedHash_row7 finally ] start
				 */

				currentComponent = "tAdvancedHash_row7";

				/**
				 * [tAdvancedHash_row7 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tDBInput_7_SUBPROCESS_STATE", 1);
	}

	public static class row8Struct implements routines.system.IPersistableComparableLookupRow<row8Struct> {
		final static byte[] commonByteArrayLock_PROJETDATAV1_Job04_Geography_Dim = new byte[0];
		static byte[] commonByteArray_PROJETDATAV1_Job04_Geography_Dim = new byte[0];
		protected static final int DEFAULT_HASHCODE = 1;
		protected static final int PRIME = 31;
		protected int hashCode = DEFAULT_HASHCODE;
		public boolean hashCodeDirty = true;

		public String loopKey;

		public Double POSTAL_CODE_ID;

		public Double getPOSTAL_CODE_ID() {
			return this.POSTAL_CODE_ID;
		}

		public String POSTAL_CODE;

		public String getPOSTAL_CODE() {
			return this.POSTAL_CODE;
		}

		public String CITY_NAME;

		public String getCITY_NAME() {
			return this.CITY_NAME;
		}

		public Double CITY_ID;

		public Double getCITY_ID() {
			return this.CITY_ID;
		}

		@Override
		public int hashCode() {
			if (this.hashCodeDirty) {
				final int prime = PRIME;
				int result = DEFAULT_HASHCODE;

				result = prime * result + ((this.POSTAL_CODE_ID == null) ? 0 : this.POSTAL_CODE_ID.hashCode());

				result = prime * result + ((this.CITY_ID == null) ? 0 : this.CITY_ID.hashCode());

				this.hashCode = result;
				this.hashCodeDirty = false;
			}
			return this.hashCode;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			final row8Struct other = (row8Struct) obj;

			if (this.POSTAL_CODE_ID == null) {
				if (other.POSTAL_CODE_ID != null)
					return false;

			} else if (!this.POSTAL_CODE_ID.equals(other.POSTAL_CODE_ID))

				return false;

			if (this.CITY_ID == null) {
				if (other.CITY_ID != null)
					return false;

			} else if (!this.CITY_ID.equals(other.CITY_ID))

				return false;

			return true;
		}

		public void copyDataTo(row8Struct other) {

			other.POSTAL_CODE_ID = this.POSTAL_CODE_ID;
			other.POSTAL_CODE = this.POSTAL_CODE;
			other.CITY_NAME = this.CITY_NAME;
			other.CITY_ID = this.CITY_ID;

		}

		public void copyKeysDataTo(row8Struct other) {

			other.POSTAL_CODE_ID = this.POSTAL_CODE_ID;
			other.CITY_ID = this.CITY_ID;

		}

		private String readString(DataInputStream dis, ObjectInputStream ois) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				byte[] byteArray = new byte[length];
				dis.read(byteArray);
				strReturn = new String(byteArray, utf8Charset);
			}
			return strReturn;
		}

		private String readString(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller)
				throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				byte[] byteArray = new byte[length];
				unmarshaller.read(byteArray);
				strReturn = new String(byteArray, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, DataOutputStream dos, org.jboss.marshalling.Marshaller marshaller)
				throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		private void writeString(String str, DataOutputStream dos, ObjectOutputStream oos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		public void readKeysData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_PROJETDATAV1_Job04_Geography_Dim) {

				try {

					int length = 0;

					length = dis.readByte();
					if (length == -1) {
						this.POSTAL_CODE_ID = null;
					} else {
						this.POSTAL_CODE_ID = dis.readDouble();
					}

					length = dis.readByte();
					if (length == -1) {
						this.CITY_ID = null;
					} else {
						this.CITY_ID = dis.readDouble();
					}

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_PROJETDATAV1_Job04_Geography_Dim) {

				try {

					int length = 0;

					length = dis.readByte();
					if (length == -1) {
						this.POSTAL_CODE_ID = null;
					} else {
						this.POSTAL_CODE_ID = dis.readDouble();
					}

					length = dis.readByte();
					if (length == -1) {
						this.CITY_ID = null;
					} else {
						this.CITY_ID = dis.readDouble();
					}

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeKeysData(ObjectOutputStream dos) {
			try {

				// Double

				if (this.POSTAL_CODE_ID == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this.POSTAL_CODE_ID);
				}

				// Double

				if (this.CITY_ID == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this.CITY_ID);
				}

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
			try {

				// Double

				if (this.POSTAL_CODE_ID == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this.POSTAL_CODE_ID);
				}

				// Double

				if (this.CITY_ID == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this.CITY_ID);
				}

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		/**
		 * Fill Values data by reading ObjectInputStream.
		 */
		public void readValuesData(DataInputStream dis, ObjectInputStream ois) {
			try {

				int length = 0;

				this.POSTAL_CODE = readString(dis, ois);

				this.CITY_NAME = readString(dis, ois);

			} catch (IOException e) {
				throw new RuntimeException(e);

			}

		}

		public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
			try {
				int length = 0;

				this.POSTAL_CODE = readString(dis, objectIn);

				this.CITY_NAME = readString(dis, objectIn);

			} catch (IOException e) {
				throw new RuntimeException(e);

			}

		}

		/**
		 * Return a byte array which represents Values data.
		 */
		public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
			try {

				writeString(this.POSTAL_CODE, dos, oos);

				writeString(this.CITY_NAME, dos, oos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut) {
			try {

				writeString(this.POSTAL_CODE, dos, objectOut);

				writeString(this.CITY_NAME, dos, objectOut);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}

		public boolean supportMarshaller() {
			return true;
		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("POSTAL_CODE_ID=" + String.valueOf(POSTAL_CODE_ID));
			sb.append(",POSTAL_CODE=" + POSTAL_CODE);
			sb.append(",CITY_NAME=" + CITY_NAME);
			sb.append(",CITY_ID=" + String.valueOf(CITY_ID));
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row8Struct other) {

			int returnValue = -1;

			returnValue = checkNullsAndCompare(this.POSTAL_CODE_ID, other.POSTAL_CODE_ID);
			if (returnValue != 0) {
				return returnValue;
			}

			returnValue = checkNullsAndCompare(this.CITY_ID, other.CITY_ID);
			if (returnValue != 0) {
				return returnValue;
			}

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public void tDBInput_8Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tDBInput_8_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		String iterateId = "";

		String currentComponent = "";
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				row8Struct row8 = new row8Struct();

				/**
				 * [tAdvancedHash_row8 begin ] start
				 */

				ok_Hash.put("tAdvancedHash_row8", false);
				start_Hash.put("tAdvancedHash_row8", System.currentTimeMillis());

				currentComponent = "tAdvancedHash_row8";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row8");
				}

				int tos_count_tAdvancedHash_row8 = 0;

				// connection name:row8
				// source node:tDBInput_8 - inputs:(after_tDBInput_1) outputs:(row8,row8) |
				// target node:tAdvancedHash_row8 - inputs:(row8) outputs:()
				// linked node: tMap_1 - inputs:(row1,row2,row3,row4,row6,row7,row8)
				// outputs:(Geography_Dim_Output)

				org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_row8 = org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.UNIQUE_MATCH;

				org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row8Struct> tHash_Lookup_row8 = org.talend.designer.components.lookup.memory.AdvancedMemoryLookup
						.<row8Struct>getLookup(matchingModeEnum_row8);

				globalMap.put("tHash_Lookup_row8", tHash_Lookup_row8);

				/**
				 * [tAdvancedHash_row8 begin ] stop
				 */

				/**
				 * [tDBInput_8 begin ] start
				 */

				ok_Hash.put("tDBInput_8", false);
				start_Hash.put("tDBInput_8", System.currentTimeMillis());

				currentComponent = "tDBInput_8";

				int tos_count_tDBInput_8 = 0;

				int nb_line_tDBInput_8 = 0;
				java.sql.Connection conn_tDBInput_8 = null;
				String driverClass_tDBInput_8 = "net.ucanaccess.jdbc.UcanaccessDriver";
				java.lang.Class.forName(driverClass_tDBInput_8);

				String url_tDBInput_8 = "jdbc:ucanaccess://" + context.Connect_Data_File
						+ ";jackcessOpener=org.talend.ucanaccess.encrypt.CryptCodecOpener;singleConnection=true";
				String dbUser_tDBInput_8 = context.Connect_Data_Login;

				final String decryptedPassword_tDBInput_8 = context.Connect_Data_Password;

				String dbPwd_tDBInput_8 = decryptedPassword_tDBInput_8;

				String atnParams_tDBInput_8 = context.Connect_Data_AdditionalParams;
				atnParams_tDBInput_8 = atnParams_tDBInput_8.replaceAll("&", "\n");
				java.util.Properties atnParamsPrope_tDBInput_8 = new java.util.Properties();
				atnParamsPrope_tDBInput_8.put("user", dbUser_tDBInput_8);
				atnParamsPrope_tDBInput_8.put("password", dbPwd_tDBInput_8);
				atnParamsPrope_tDBInput_8.load(new java.io.ByteArrayInputStream(atnParams_tDBInput_8.getBytes()));
				conn_tDBInput_8 = java.sql.DriverManager.getConnection(url_tDBInput_8, atnParamsPrope_tDBInput_8);

				java.sql.Statement stmt_tDBInput_8 = conn_tDBInput_8.createStatement();

				String dbquery_tDBInput_8 = "SELECT \n  POSTAL_CODE.POSTAL_CODE_ID, \n  POSTAL_CODE.POSTAL_CODE, \n  POSTAL_CODE.CITY_NAME, \n  POSTAL_CODE.CITY_ID\nFROM"
						+ " POSTAL_CODE";

				globalMap.put("tDBInput_8_QUERY", dbquery_tDBInput_8);
				java.sql.ResultSet rs_tDBInput_8 = null;

				try {
					rs_tDBInput_8 = stmt_tDBInput_8.executeQuery(dbquery_tDBInput_8);
					java.sql.ResultSetMetaData rsmd_tDBInput_8 = rs_tDBInput_8.getMetaData();
					int colQtyInRs_tDBInput_8 = rsmd_tDBInput_8.getColumnCount();

					String tmpContent_tDBInput_8 = null;

					while (rs_tDBInput_8.next()) {
						nb_line_tDBInput_8++;

						if (colQtyInRs_tDBInput_8 < 1) {
							row8.POSTAL_CODE_ID = null;
						} else {

							row8.POSTAL_CODE_ID = rs_tDBInput_8.getDouble(1);
							if (rs_tDBInput_8.wasNull()) {
								row8.POSTAL_CODE_ID = null;
							}
						}
						if (colQtyInRs_tDBInput_8 < 2) {
							row8.POSTAL_CODE = null;
						} else {

							row8.POSTAL_CODE = routines.system.JDBCUtil.getString(rs_tDBInput_8, 2, false);
						}
						if (colQtyInRs_tDBInput_8 < 3) {
							row8.CITY_NAME = null;
						} else {

							row8.CITY_NAME = routines.system.JDBCUtil.getString(rs_tDBInput_8, 3, false);
						}
						if (colQtyInRs_tDBInput_8 < 4) {
							row8.CITY_ID = null;
						} else {

							row8.CITY_ID = rs_tDBInput_8.getDouble(4);
							if (rs_tDBInput_8.wasNull()) {
								row8.CITY_ID = null;
							}
						}

						/**
						 * [tDBInput_8 begin ] stop
						 */

						/**
						 * [tDBInput_8 main ] start
						 */

						currentComponent = "tDBInput_8";

						tos_count_tDBInput_8++;

						/**
						 * [tDBInput_8 main ] stop
						 */

						/**
						 * [tDBInput_8 process_data_begin ] start
						 */

						currentComponent = "tDBInput_8";

						/**
						 * [tDBInput_8 process_data_begin ] stop
						 */

						/**
						 * [tAdvancedHash_row8 main ] start
						 */

						currentComponent = "tAdvancedHash_row8";

						if (execStat) {
							runStat.updateStatOnConnection(iterateId, 1, 1

									, "row8"

							);
						}

						row8Struct row8_HashRow = new row8Struct();

						row8_HashRow.POSTAL_CODE_ID = row8.POSTAL_CODE_ID;

						row8_HashRow.POSTAL_CODE = row8.POSTAL_CODE;

						row8_HashRow.CITY_NAME = row8.CITY_NAME;

						row8_HashRow.CITY_ID = row8.CITY_ID;

						tHash_Lookup_row8.put(row8_HashRow);

						tos_count_tAdvancedHash_row8++;

						/**
						 * [tAdvancedHash_row8 main ] stop
						 */

						/**
						 * [tAdvancedHash_row8 process_data_begin ] start
						 */

						currentComponent = "tAdvancedHash_row8";

						/**
						 * [tAdvancedHash_row8 process_data_begin ] stop
						 */

						/**
						 * [tAdvancedHash_row8 process_data_end ] start
						 */

						currentComponent = "tAdvancedHash_row8";

						/**
						 * [tAdvancedHash_row8 process_data_end ] stop
						 */

						/**
						 * [tDBInput_8 process_data_end ] start
						 */

						currentComponent = "tDBInput_8";

						/**
						 * [tDBInput_8 process_data_end ] stop
						 */

						/**
						 * [tDBInput_8 end ] start
						 */

						currentComponent = "tDBInput_8";

					}
				} finally {
					if (rs_tDBInput_8 != null) {
						rs_tDBInput_8.close();
					}
					if (stmt_tDBInput_8 != null) {
						stmt_tDBInput_8.close();
					}
					if (conn_tDBInput_8 != null && !conn_tDBInput_8.isClosed()) {

						conn_tDBInput_8.close();

						if ("com.mysql.cj.jdbc.Driver".equals((String) globalMap.get("driverClass_"))
								&& routines.system.BundleUtils.inOSGi()) {
							Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread")
									.getMethod("checkedShutdown").invoke(null, (Object[]) null);
						}

					}
				}
				globalMap.put("tDBInput_8_NB_LINE", nb_line_tDBInput_8);

				ok_Hash.put("tDBInput_8", true);
				end_Hash.put("tDBInput_8", System.currentTimeMillis());

				/**
				 * [tDBInput_8 end ] stop
				 */

				/**
				 * [tAdvancedHash_row8 end ] start
				 */

				currentComponent = "tAdvancedHash_row8";

				tHash_Lookup_row8.endPut();

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "row8");
				}

				ok_Hash.put("tAdvancedHash_row8", true);
				end_Hash.put("tAdvancedHash_row8", System.currentTimeMillis());

				/**
				 * [tAdvancedHash_row8 end ] stop
				 */

			} // end the resume

		} catch (java.lang.Exception e) {

			TalendException te = new TalendException(e, currentComponent, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			try {

				/**
				 * [tDBInput_8 finally ] start
				 */

				currentComponent = "tDBInput_8";

				/**
				 * [tDBInput_8 finally ] stop
				 */

				/**
				 * [tAdvancedHash_row8 finally ] start
				 */

				currentComponent = "tAdvancedHash_row8";

				/**
				 * [tAdvancedHash_row8 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tDBInput_8_SUBPROCESS_STATE", 1);
	}

	public String resuming_logs_dir_path = null;
	public String resuming_checkpoint_path = null;
	public String parent_part_launcher = null;
	private String resumeEntryMethodName = null;
	private boolean globalResumeTicket = false;

	public boolean watch = false;
	// portStats is null, it means don't execute the statistics
	public Integer portStats = null;
	public int portTraces = 4334;
	public String clientHost;
	public String defaultClientHost = "localhost";
	public String contextStr = "Default";
	public boolean isDefaultContext = true;
	public String pid = "0";
	public String rootPid = null;
	public String fatherPid = null;
	public String fatherNode = null;
	public long startTime = 0;
	public boolean isChildJob = false;
	public String log4jLevel = "";

	private boolean enableLogStash;

	private boolean execStat = true;

	private ThreadLocal<java.util.Map<String, String>> threadLocal = new ThreadLocal<java.util.Map<String, String>>() {
		protected java.util.Map<String, String> initialValue() {
			java.util.Map<String, String> threadRunResultMap = new java.util.HashMap<String, String>();
			threadRunResultMap.put("errorCode", null);
			threadRunResultMap.put("status", "");
			return threadRunResultMap;
		};
	};

	protected PropertiesWithType context_param = new PropertiesWithType();
	public java.util.Map<String, Object> parentContextMap = new java.util.HashMap<String, Object>();

	public String status = "";

	public static void main(String[] args) {
		final Job04_Geography_Dim Job04_Geography_DimClass = new Job04_Geography_Dim();

		int exitCode = Job04_Geography_DimClass.runJobInTOS(args);

		System.exit(exitCode);
	}

	public String[][] runJob(String[] args) {

		int exitCode = runJobInTOS(args);
		String[][] bufferValue = new String[][] { { Integer.toString(exitCode) } };

		return bufferValue;
	}

	public boolean hastBufferOutputComponent() {
		boolean hastBufferOutput = false;

		return hastBufferOutput;
	}

	public int runJobInTOS(String[] args) {
		// reset status
		status = "";

		String lastStr = "";
		for (String arg : args) {
			if (arg.equalsIgnoreCase("--context_param")) {
				lastStr = arg;
			} else if (lastStr.equals("")) {
				evalParam(arg);
			} else {
				evalParam(lastStr + " " + arg);
				lastStr = "";
			}
		}
		enableLogStash = "true".equalsIgnoreCase(System.getProperty("audit.enabled"));

		if (clientHost == null) {
			clientHost = defaultClientHost;
		}

		if (pid == null || "0".equals(pid)) {
			pid = TalendString.getAsciiRandomString(6);
		}

		if (rootPid == null) {
			rootPid = pid;
		}
		if (fatherPid == null) {
			fatherPid = pid;
		} else {
			isChildJob = true;
		}

		if (portStats != null) {
			// portStats = -1; //for testing
			if (portStats < 0 || portStats > 65535) {
				// issue:10869, the portStats is invalid, so this client socket can't open
				System.err.println("The statistics socket port " + portStats + " is invalid.");
				execStat = false;
			}
		} else {
			execStat = false;
		}
		boolean inOSGi = routines.system.BundleUtils.inOSGi();

		if (inOSGi) {
			java.util.Dictionary<String, Object> jobProperties = routines.system.BundleUtils.getJobProperties(jobName);

			if (jobProperties != null && jobProperties.get("context") != null) {
				contextStr = (String) jobProperties.get("context");
			}
		}

		try {
			// call job/subjob with an existing context, like: --context=production. if
			// without this parameter, there will use the default context instead.
			java.io.InputStream inContext = Job04_Geography_Dim.class.getClassLoader()
					.getResourceAsStream("projetdatav1/job04_geography_dim_0_1/contexts/" + contextStr + ".properties");
			if (inContext == null) {
				inContext = Job04_Geography_Dim.class.getClassLoader()
						.getResourceAsStream("config/contexts/" + contextStr + ".properties");
			}
			if (inContext != null) {
				try {
					// defaultProps is in order to keep the original context value
					if (context != null && context.isEmpty()) {
						defaultProps.load(inContext);
						context = new ContextProperties(defaultProps);
					}
				} finally {
					inContext.close();
				}
			} else if (!isDefaultContext) {
				// print info and job continue to run, for case: context_param is not empty.
				System.err.println("Could not find the context " + contextStr);
			}

			if (!context_param.isEmpty()) {
				context.putAll(context_param);
				// set types for params from parentJobs
				for (Object key : context_param.keySet()) {
					String context_key = key.toString();
					String context_type = context_param.getContextType(context_key);
					context.setContextType(context_key, context_type);

				}
			}
			class ContextProcessing {
				private void processContext_0() {
					context.setContextType("Connect_Data_Password", "id_Password");
					if (context.getStringValue("Connect_Data_Password") == null) {
						context.Connect_Data_Password = null;
					} else {
						String pwd_Connect_Data_Password_value = context.getProperty("Connect_Data_Password");
						context.Connect_Data_Password = null;
						if (pwd_Connect_Data_Password_value != null) {
							if (context_param.containsKey("Connect_Data_Password")) {// no need to decrypt if it come
																						// from program argument or
																						// parent job runtime
								context.Connect_Data_Password = pwd_Connect_Data_Password_value;
							} else if (!pwd_Connect_Data_Password_value.isEmpty()) {
								try {
									context.Connect_Data_Password = routines.system.PasswordEncryptUtil
											.decryptPassword(pwd_Connect_Data_Password_value);
									context.put("Connect_Data_Password", context.Connect_Data_Password);
								} catch (java.lang.RuntimeException e) {
									// do nothing
								}
							}
						}
					}
					context.setContextType("Connect_Data_Login", "id_String");
					if (context.getStringValue("Connect_Data_Login") == null) {
						context.Connect_Data_Login = null;
					} else {
						context.Connect_Data_Login = (String) context.getProperty("Connect_Data_Login");
					}
					context.setContextType("Connect_Data_AdditionalParams", "id_String");
					if (context.getStringValue("Connect_Data_AdditionalParams") == null) {
						context.Connect_Data_AdditionalParams = null;
					} else {
						context.Connect_Data_AdditionalParams = (String) context
								.getProperty("Connect_Data_AdditionalParams");
					}
					context.setContextType("Connect_Data_File", "id_File");
					if (context.getStringValue("Connect_Data_File") == null) {
						context.Connect_Data_File = null;
					} else {
						context.Connect_Data_File = (String) context.getProperty("Connect_Data_File");
					}
				}

				public void processAllContext() {
					processContext_0();
				}
			}

			new ContextProcessing().processAllContext();
		} catch (java.io.IOException ie) {
			System.err.println("Could not load context " + contextStr);
			ie.printStackTrace();
		}

		// get context value from parent directly
		if (parentContextMap != null && !parentContextMap.isEmpty()) {
			if (parentContextMap.containsKey("Connect_Data_Password")) {
				context.Connect_Data_Password = (java.lang.String) parentContextMap.get("Connect_Data_Password");
			}
			if (parentContextMap.containsKey("Connect_Data_Login")) {
				context.Connect_Data_Login = (String) parentContextMap.get("Connect_Data_Login");
			}
			if (parentContextMap.containsKey("Connect_Data_AdditionalParams")) {
				context.Connect_Data_AdditionalParams = (String) parentContextMap.get("Connect_Data_AdditionalParams");
			}
			if (parentContextMap.containsKey("Connect_Data_File")) {
				context.Connect_Data_File = (String) parentContextMap.get("Connect_Data_File");
			}
		}

		// Resume: init the resumeUtil
		resumeEntryMethodName = ResumeUtil.getResumeEntryMethodName(resuming_checkpoint_path);
		resumeUtil = new ResumeUtil(resuming_logs_dir_path, isChildJob, rootPid);
		resumeUtil.initCommonInfo(pid, rootPid, fatherPid, projectName, jobName, contextStr, jobVersion);

		List<String> parametersToEncrypt = new java.util.ArrayList<String>();
		parametersToEncrypt.add("Connect_Data_Password");
		// Resume: jobStart
		resumeUtil.addLog("JOB_STARTED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "",
				"", "", "", "", resumeUtil.convertToJsonText(context, parametersToEncrypt));

		if (execStat) {
			try {
				runStat.openSocket(!isChildJob);
				runStat.setAllPID(rootPid, fatherPid, pid, jobName);
				runStat.startThreadStat(clientHost, portStats);
				runStat.updateStatOnJob(RunStat.JOBSTART, fatherNode);
			} catch (java.io.IOException ioException) {
				ioException.printStackTrace();
			}
		}

		java.util.concurrent.ConcurrentHashMap<Object, Object> concurrentHashMap = new java.util.concurrent.ConcurrentHashMap<Object, Object>();
		globalMap.put("concurrentHashMap", concurrentHashMap);

		long startUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		long endUsedMemory = 0;
		long end = 0;

		startTime = System.currentTimeMillis();

		this.globalResumeTicket = true;// to run tPreJob

		this.globalResumeTicket = false;// to run others jobs

		try {
			errorCode = null;
			tDBInput_1Process(globalMap);
			if (!"failure".equals(status)) {
				status = "end";
			}
		} catch (TalendException e_tDBInput_1) {
			globalMap.put("tDBInput_1_SUBPROCESS_STATE", -1);

			e_tDBInput_1.printStackTrace();

		}

		this.globalResumeTicket = true;// to run tPostJob

		end = System.currentTimeMillis();

		if (watch) {
			System.out.println((end - startTime) + " milliseconds");
		}

		endUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		if (false) {
			System.out.println(
					(endUsedMemory - startUsedMemory) + " bytes memory increase when running : Job04_Geography_Dim");
		}

		if (execStat) {
			runStat.updateStatOnJob(RunStat.JOBEND, fatherNode);
			runStat.stopThreadStat();
		}
		int returnCode = 0;

		if (errorCode == null) {
			returnCode = status != null && status.equals("failure") ? 1 : 0;
		} else {
			returnCode = errorCode.intValue();
		}
		resumeUtil.addLog("JOB_ENDED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "", "",
				"" + returnCode, "", "", "");

		return returnCode;

	}

	// only for OSGi env
	public void destroy() {

	}

	private java.util.Map<String, Object> getSharedConnections4REST() {
		java.util.Map<String, Object> connections = new java.util.HashMap<String, Object>();

		return connections;
	}

	private void evalParam(String arg) {
		if (arg.startsWith("--resuming_logs_dir_path")) {
			resuming_logs_dir_path = arg.substring(25);
		} else if (arg.startsWith("--resuming_checkpoint_path")) {
			resuming_checkpoint_path = arg.substring(27);
		} else if (arg.startsWith("--parent_part_launcher")) {
			parent_part_launcher = arg.substring(23);
		} else if (arg.startsWith("--watch")) {
			watch = true;
		} else if (arg.startsWith("--stat_port=")) {
			String portStatsStr = arg.substring(12);
			if (portStatsStr != null && !portStatsStr.equals("null")) {
				portStats = Integer.parseInt(portStatsStr);
			}
		} else if (arg.startsWith("--trace_port=")) {
			portTraces = Integer.parseInt(arg.substring(13));
		} else if (arg.startsWith("--client_host=")) {
			clientHost = arg.substring(14);
		} else if (arg.startsWith("--context=")) {
			contextStr = arg.substring(10);
			isDefaultContext = false;
		} else if (arg.startsWith("--father_pid=")) {
			fatherPid = arg.substring(13);
		} else if (arg.startsWith("--root_pid=")) {
			rootPid = arg.substring(11);
		} else if (arg.startsWith("--father_node=")) {
			fatherNode = arg.substring(14);
		} else if (arg.startsWith("--pid=")) {
			pid = arg.substring(6);
		} else if (arg.startsWith("--context_type")) {
			String keyValue = arg.substring(15);
			int index = -1;
			if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
				if (fatherPid == null) {
					context_param.setContextType(keyValue.substring(0, index),
							replaceEscapeChars(keyValue.substring(index + 1)));
				} else { // the subjob won't escape the especial chars
					context_param.setContextType(keyValue.substring(0, index), keyValue.substring(index + 1));
				}

			}

		} else if (arg.startsWith("--context_param")) {
			String keyValue = arg.substring(16);
			int index = -1;
			if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
				if (fatherPid == null) {
					context_param.put(keyValue.substring(0, index), replaceEscapeChars(keyValue.substring(index + 1)));
				} else { // the subjob won't escape the especial chars
					context_param.put(keyValue.substring(0, index), keyValue.substring(index + 1));
				}
			}
		} else if (arg.startsWith("--log4jLevel=")) {
			log4jLevel = arg.substring(13);
		} else if (arg.startsWith("--audit.enabled") && arg.contains("=")) {// for trunjob call
			final int equal = arg.indexOf('=');
			final String key = arg.substring("--".length(), equal);
			System.setProperty(key, arg.substring(equal + 1));
		}
	}

	private static final String NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY = "<TALEND_NULL>";

	private final String[][] escapeChars = { { "\\\\", "\\" }, { "\\n", "\n" }, { "\\'", "\'" }, { "\\r", "\r" },
			{ "\\f", "\f" }, { "\\b", "\b" }, { "\\t", "\t" } };

	private String replaceEscapeChars(String keyValue) {

		if (keyValue == null || ("").equals(keyValue.trim())) {
			return keyValue;
		}

		StringBuilder result = new StringBuilder();
		int currIndex = 0;
		while (currIndex < keyValue.length()) {
			int index = -1;
			// judege if the left string includes escape chars
			for (String[] strArray : escapeChars) {
				index = keyValue.indexOf(strArray[0], currIndex);
				if (index >= 0) {

					result.append(keyValue.substring(currIndex, index + strArray[0].length()).replace(strArray[0],
							strArray[1]));
					currIndex = index + strArray[0].length();
					break;
				}
			}
			// if the left string doesn't include escape chars, append the left into the
			// result
			if (index < 0) {
				result.append(keyValue.substring(currIndex));
				currIndex = currIndex + keyValue.length();
			}
		}

		return result.toString();
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public String getStatus() {
		return status;
	}

	ResumeUtil resumeUtil = null;
}
/************************************************************************************************
 * 231896 characters generated by Talend Open Studio for Data Integration on the
 * 24 janvier 2022 à 02:00:26 CET
 ************************************************************************************************/
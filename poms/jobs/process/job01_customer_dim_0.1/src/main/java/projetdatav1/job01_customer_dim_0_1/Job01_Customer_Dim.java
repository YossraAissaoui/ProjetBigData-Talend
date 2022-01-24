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

package projetdatav1.job01_customer_dim_0_1;

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
 * Job: Job01_Customer_Dim Purpose: <br>
 * Description: <br>
 * 
 * @author user@talend.com
 * @version 8.0.1.20211109_1610
 * @status
 */
public class Job01_Customer_Dim implements TalendJob {

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
	private final String jobName = "Job01_Customer_Dim";
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
					Job01_Customer_Dim.this.exception = e;
				}
			}
			if (!(e instanceof TalendException)) {
				try {
					for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
						if (m.getName().compareTo(currentComponent + "_error") == 0) {
							m.invoke(Job01_Customer_Dim.this, new Object[] { e, currentComponent, globalMap });
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

	public void tAdvancedHash_Customer_type_error(Exception exception, String errorComponent,
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

	public static class customer_dimStruct implements routines.system.IPersistableRow<customer_dimStruct> {
		final static byte[] commonByteArrayLock_PROJETDATAV1_Job01_Customer_Dim = new byte[0];
		static byte[] commonByteArray_PROJETDATAV1_Job01_Customer_Dim = new byte[0];
		protected static final int DEFAULT_HASHCODE = 1;
		protected static final int PRIME = 31;
		protected int hashCode = DEFAULT_HASHCODE;
		public boolean hashCodeDirty = true;

		public String loopKey;

		public double Customer_ID;

		public double getCustomer_ID() {
			return this.Customer_ID;
		}

		public String Customer_Country;

		public String getCustomer_Country() {
			return this.Customer_Country;
		}

		public Character Customer_Group;

		public Character getCustomer_Group() {
			return this.Customer_Group;
		}

		public Character Customer_Type;

		public Character getCustomer_Type() {
			return this.Customer_Type;
		}

		public Character Customer_Gender;

		public Character getCustomer_Gender() {
			return this.Customer_Gender;
		}

		public String Customer_Age_Group;

		public String getCustomer_Age_Group() {
			return this.Customer_Age_Group;
		}

		public int Customer_Age;

		public int getCustomer_Age() {
			return this.Customer_Age;
		}

		public String Customer_Name;

		public String getCustomer_Name() {
			return this.Customer_Name;
		}

		public String Customer_Firstname;

		public String getCustomer_Firstname() {
			return this.Customer_Firstname;
		}

		public String Customer_Lastname;

		public String getCustomer_Lastname() {
			return this.Customer_Lastname;
		}

		public java.util.Date Customer_Birth_Date;

		public java.util.Date getCustomer_Birth_Date() {
			return this.Customer_Birth_Date;
		}

		@Override
		public int hashCode() {
			if (this.hashCodeDirty) {
				final int prime = PRIME;
				int result = DEFAULT_HASHCODE;

				result = prime * result + (int) this.Customer_ID;

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
			final customer_dimStruct other = (customer_dimStruct) obj;

			if (this.Customer_ID != other.Customer_ID)
				return false;

			return true;
		}

		public void copyDataTo(customer_dimStruct other) {

			other.Customer_ID = this.Customer_ID;
			other.Customer_Country = this.Customer_Country;
			other.Customer_Group = this.Customer_Group;
			other.Customer_Type = this.Customer_Type;
			other.Customer_Gender = this.Customer_Gender;
			other.Customer_Age_Group = this.Customer_Age_Group;
			other.Customer_Age = this.Customer_Age;
			other.Customer_Name = this.Customer_Name;
			other.Customer_Firstname = this.Customer_Firstname;
			other.Customer_Lastname = this.Customer_Lastname;
			other.Customer_Birth_Date = this.Customer_Birth_Date;

		}

		public void copyKeysDataTo(customer_dimStruct other) {

			other.Customer_ID = this.Customer_ID;

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_PROJETDATAV1_Job01_Customer_Dim.length) {
					if (length < 1024 && commonByteArray_PROJETDATAV1_Job01_Customer_Dim.length == 0) {
						commonByteArray_PROJETDATAV1_Job01_Customer_Dim = new byte[1024];
					} else {
						commonByteArray_PROJETDATAV1_Job01_Customer_Dim = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_PROJETDATAV1_Job01_Customer_Dim, 0, length);
				strReturn = new String(commonByteArray_PROJETDATAV1_Job01_Customer_Dim, 0, length, utf8Charset);
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
				if (length > commonByteArray_PROJETDATAV1_Job01_Customer_Dim.length) {
					if (length < 1024 && commonByteArray_PROJETDATAV1_Job01_Customer_Dim.length == 0) {
						commonByteArray_PROJETDATAV1_Job01_Customer_Dim = new byte[1024];
					} else {
						commonByteArray_PROJETDATAV1_Job01_Customer_Dim = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_PROJETDATAV1_Job01_Customer_Dim, 0, length);
				strReturn = new String(commonByteArray_PROJETDATAV1_Job01_Customer_Dim, 0, length, utf8Charset);
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

		private java.util.Date readDate(ObjectInputStream dis) throws IOException {
			java.util.Date dateReturn = null;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				dateReturn = null;
			} else {
				dateReturn = new Date(dis.readLong());
			}
			return dateReturn;
		}

		private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			java.util.Date dateReturn = null;
			int length = 0;
			length = unmarshaller.readByte();
			if (length == -1) {
				dateReturn = null;
			} else {
				dateReturn = new Date(unmarshaller.readLong());
			}
			return dateReturn;
		}

		private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException {
			if (date1 == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeLong(date1.getTime());
			}
		}

		private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (date1 == null) {
				marshaller.writeByte(-1);
			} else {
				marshaller.writeByte(0);
				marshaller.writeLong(date1.getTime());
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_PROJETDATAV1_Job01_Customer_Dim) {

				try {

					int length = 0;

					this.Customer_ID = dis.readDouble();

					this.Customer_Country = readString(dis);

					length = dis.readByte();
					if (length == -1) {
						this.Customer_Group = null;
					} else {
						this.Customer_Group = dis.readChar();
					}

					length = dis.readByte();
					if (length == -1) {
						this.Customer_Type = null;
					} else {
						this.Customer_Type = dis.readChar();
					}

					length = dis.readByte();
					if (length == -1) {
						this.Customer_Gender = null;
					} else {
						this.Customer_Gender = dis.readChar();
					}

					this.Customer_Age_Group = readString(dis);

					this.Customer_Age = dis.readInt();

					this.Customer_Name = readString(dis);

					this.Customer_Firstname = readString(dis);

					this.Customer_Lastname = readString(dis);

					this.Customer_Birth_Date = readDate(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_PROJETDATAV1_Job01_Customer_Dim) {

				try {

					int length = 0;

					this.Customer_ID = dis.readDouble();

					this.Customer_Country = readString(dis);

					length = dis.readByte();
					if (length == -1) {
						this.Customer_Group = null;
					} else {
						this.Customer_Group = dis.readChar();
					}

					length = dis.readByte();
					if (length == -1) {
						this.Customer_Type = null;
					} else {
						this.Customer_Type = dis.readChar();
					}

					length = dis.readByte();
					if (length == -1) {
						this.Customer_Gender = null;
					} else {
						this.Customer_Gender = dis.readChar();
					}

					this.Customer_Age_Group = readString(dis);

					this.Customer_Age = dis.readInt();

					this.Customer_Name = readString(dis);

					this.Customer_Firstname = readString(dis);

					this.Customer_Lastname = readString(dis);

					this.Customer_Birth_Date = readDate(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// double

				dos.writeDouble(this.Customer_ID);

				// String

				writeString(this.Customer_Country, dos);

				// Character

				if (this.Customer_Group == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeChar(this.Customer_Group);
				}

				// Character

				if (this.Customer_Type == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeChar(this.Customer_Type);
				}

				// Character

				if (this.Customer_Gender == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeChar(this.Customer_Gender);
				}

				// String

				writeString(this.Customer_Age_Group, dos);

				// int

				dos.writeInt(this.Customer_Age);

				// String

				writeString(this.Customer_Name, dos);

				// String

				writeString(this.Customer_Firstname, dos);

				// String

				writeString(this.Customer_Lastname, dos);

				// java.util.Date

				writeDate(this.Customer_Birth_Date, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// double

				dos.writeDouble(this.Customer_ID);

				// String

				writeString(this.Customer_Country, dos);

				// Character

				if (this.Customer_Group == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeChar(this.Customer_Group);
				}

				// Character

				if (this.Customer_Type == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeChar(this.Customer_Type);
				}

				// Character

				if (this.Customer_Gender == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeChar(this.Customer_Gender);
				}

				// String

				writeString(this.Customer_Age_Group, dos);

				// int

				dos.writeInt(this.Customer_Age);

				// String

				writeString(this.Customer_Name, dos);

				// String

				writeString(this.Customer_Firstname, dos);

				// String

				writeString(this.Customer_Lastname, dos);

				// java.util.Date

				writeDate(this.Customer_Birth_Date, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("Customer_ID=" + String.valueOf(Customer_ID));
			sb.append(",Customer_Country=" + Customer_Country);
			sb.append(",Customer_Group=" + String.valueOf(Customer_Group));
			sb.append(",Customer_Type=" + String.valueOf(Customer_Type));
			sb.append(",Customer_Gender=" + String.valueOf(Customer_Gender));
			sb.append(",Customer_Age_Group=" + Customer_Age_Group);
			sb.append(",Customer_Age=" + String.valueOf(Customer_Age));
			sb.append(",Customer_Name=" + Customer_Name);
			sb.append(",Customer_Firstname=" + Customer_Firstname);
			sb.append(",Customer_Lastname=" + Customer_Lastname);
			sb.append(",Customer_Birth_Date=" + String.valueOf(Customer_Birth_Date));
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(customer_dimStruct other) {

			int returnValue = -1;

			returnValue = checkNullsAndCompare(this.Customer_ID, other.Customer_ID);
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

	public static class CustomerStruct implements routines.system.IPersistableRow<CustomerStruct> {
		final static byte[] commonByteArrayLock_PROJETDATAV1_Job01_Customer_Dim = new byte[0];
		static byte[] commonByteArray_PROJETDATAV1_Job01_Customer_Dim = new byte[0];

		public Double CUSTOMER_ID;

		public Double getCUSTOMER_ID() {
			return this.CUSTOMER_ID;
		}

		public String COUNTRY;

		public String getCOUNTRY() {
			return this.COUNTRY;
		}

		public Character GENDER;

		public Character getGENDER() {
			return this.GENDER;
		}

		public String PERSONAL_ID;

		public String getPERSONAL_ID() {
			return this.PERSONAL_ID;
		}

		public String CUSTOMER_NAME;

		public String getCUSTOMER_NAME() {
			return this.CUSTOMER_NAME;
		}

		public String CUSTOMER_FIRSTNAME;

		public String getCUSTOMER_FIRSTNAME() {
			return this.CUSTOMER_FIRSTNAME;
		}

		public String CUSTOMER_LASTNAME;

		public String getCUSTOMER_LASTNAME() {
			return this.CUSTOMER_LASTNAME;
		}

		public java.util.Date BIRTH_DATE;

		public java.util.Date getBIRTH_DATE() {
			return this.BIRTH_DATE;
		}

		public String CUSTOMER_ADDRESS;

		public String getCUSTOMER_ADDRESS() {
			return this.CUSTOMER_ADDRESS;
		}

		public Double STREET_ID;

		public Double getSTREET_ID() {
			return this.STREET_ID;
		}

		public String STREET_NUMBER;

		public String getSTREET_NUMBER() {
			return this.STREET_NUMBER;
		}

		public Double CUSTOMER_TYPE_ID;

		public Double getCUSTOMER_TYPE_ID() {
			return this.CUSTOMER_TYPE_ID;
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_PROJETDATAV1_Job01_Customer_Dim.length) {
					if (length < 1024 && commonByteArray_PROJETDATAV1_Job01_Customer_Dim.length == 0) {
						commonByteArray_PROJETDATAV1_Job01_Customer_Dim = new byte[1024];
					} else {
						commonByteArray_PROJETDATAV1_Job01_Customer_Dim = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_PROJETDATAV1_Job01_Customer_Dim, 0, length);
				strReturn = new String(commonByteArray_PROJETDATAV1_Job01_Customer_Dim, 0, length, utf8Charset);
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
				if (length > commonByteArray_PROJETDATAV1_Job01_Customer_Dim.length) {
					if (length < 1024 && commonByteArray_PROJETDATAV1_Job01_Customer_Dim.length == 0) {
						commonByteArray_PROJETDATAV1_Job01_Customer_Dim = new byte[1024];
					} else {
						commonByteArray_PROJETDATAV1_Job01_Customer_Dim = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_PROJETDATAV1_Job01_Customer_Dim, 0, length);
				strReturn = new String(commonByteArray_PROJETDATAV1_Job01_Customer_Dim, 0, length, utf8Charset);
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

		private java.util.Date readDate(ObjectInputStream dis) throws IOException {
			java.util.Date dateReturn = null;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				dateReturn = null;
			} else {
				dateReturn = new Date(dis.readLong());
			}
			return dateReturn;
		}

		private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			java.util.Date dateReturn = null;
			int length = 0;
			length = unmarshaller.readByte();
			if (length == -1) {
				dateReturn = null;
			} else {
				dateReturn = new Date(unmarshaller.readLong());
			}
			return dateReturn;
		}

		private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException {
			if (date1 == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeLong(date1.getTime());
			}
		}

		private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (date1 == null) {
				marshaller.writeByte(-1);
			} else {
				marshaller.writeByte(0);
				marshaller.writeLong(date1.getTime());
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_PROJETDATAV1_Job01_Customer_Dim) {

				try {

					int length = 0;

					length = dis.readByte();
					if (length == -1) {
						this.CUSTOMER_ID = null;
					} else {
						this.CUSTOMER_ID = dis.readDouble();
					}

					this.COUNTRY = readString(dis);

					length = dis.readByte();
					if (length == -1) {
						this.GENDER = null;
					} else {
						this.GENDER = dis.readChar();
					}

					this.PERSONAL_ID = readString(dis);

					this.CUSTOMER_NAME = readString(dis);

					this.CUSTOMER_FIRSTNAME = readString(dis);

					this.CUSTOMER_LASTNAME = readString(dis);

					this.BIRTH_DATE = readDate(dis);

					this.CUSTOMER_ADDRESS = readString(dis);

					length = dis.readByte();
					if (length == -1) {
						this.STREET_ID = null;
					} else {
						this.STREET_ID = dis.readDouble();
					}

					this.STREET_NUMBER = readString(dis);

					length = dis.readByte();
					if (length == -1) {
						this.CUSTOMER_TYPE_ID = null;
					} else {
						this.CUSTOMER_TYPE_ID = dis.readDouble();
					}

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_PROJETDATAV1_Job01_Customer_Dim) {

				try {

					int length = 0;

					length = dis.readByte();
					if (length == -1) {
						this.CUSTOMER_ID = null;
					} else {
						this.CUSTOMER_ID = dis.readDouble();
					}

					this.COUNTRY = readString(dis);

					length = dis.readByte();
					if (length == -1) {
						this.GENDER = null;
					} else {
						this.GENDER = dis.readChar();
					}

					this.PERSONAL_ID = readString(dis);

					this.CUSTOMER_NAME = readString(dis);

					this.CUSTOMER_FIRSTNAME = readString(dis);

					this.CUSTOMER_LASTNAME = readString(dis);

					this.BIRTH_DATE = readDate(dis);

					this.CUSTOMER_ADDRESS = readString(dis);

					length = dis.readByte();
					if (length == -1) {
						this.STREET_ID = null;
					} else {
						this.STREET_ID = dis.readDouble();
					}

					this.STREET_NUMBER = readString(dis);

					length = dis.readByte();
					if (length == -1) {
						this.CUSTOMER_TYPE_ID = null;
					} else {
						this.CUSTOMER_TYPE_ID = dis.readDouble();
					}

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// Double

				if (this.CUSTOMER_ID == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this.CUSTOMER_ID);
				}

				// String

				writeString(this.COUNTRY, dos);

				// Character

				if (this.GENDER == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeChar(this.GENDER);
				}

				// String

				writeString(this.PERSONAL_ID, dos);

				// String

				writeString(this.CUSTOMER_NAME, dos);

				// String

				writeString(this.CUSTOMER_FIRSTNAME, dos);

				// String

				writeString(this.CUSTOMER_LASTNAME, dos);

				// java.util.Date

				writeDate(this.BIRTH_DATE, dos);

				// String

				writeString(this.CUSTOMER_ADDRESS, dos);

				// Double

				if (this.STREET_ID == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this.STREET_ID);
				}

				// String

				writeString(this.STREET_NUMBER, dos);

				// Double

				if (this.CUSTOMER_TYPE_ID == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this.CUSTOMER_TYPE_ID);
				}

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// Double

				if (this.CUSTOMER_ID == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this.CUSTOMER_ID);
				}

				// String

				writeString(this.COUNTRY, dos);

				// Character

				if (this.GENDER == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeChar(this.GENDER);
				}

				// String

				writeString(this.PERSONAL_ID, dos);

				// String

				writeString(this.CUSTOMER_NAME, dos);

				// String

				writeString(this.CUSTOMER_FIRSTNAME, dos);

				// String

				writeString(this.CUSTOMER_LASTNAME, dos);

				// java.util.Date

				writeDate(this.BIRTH_DATE, dos);

				// String

				writeString(this.CUSTOMER_ADDRESS, dos);

				// Double

				if (this.STREET_ID == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this.STREET_ID);
				}

				// String

				writeString(this.STREET_NUMBER, dos);

				// Double

				if (this.CUSTOMER_TYPE_ID == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this.CUSTOMER_TYPE_ID);
				}

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("CUSTOMER_ID=" + String.valueOf(CUSTOMER_ID));
			sb.append(",COUNTRY=" + COUNTRY);
			sb.append(",GENDER=" + String.valueOf(GENDER));
			sb.append(",PERSONAL_ID=" + PERSONAL_ID);
			sb.append(",CUSTOMER_NAME=" + CUSTOMER_NAME);
			sb.append(",CUSTOMER_FIRSTNAME=" + CUSTOMER_FIRSTNAME);
			sb.append(",CUSTOMER_LASTNAME=" + CUSTOMER_LASTNAME);
			sb.append(",BIRTH_DATE=" + String.valueOf(BIRTH_DATE));
			sb.append(",CUSTOMER_ADDRESS=" + CUSTOMER_ADDRESS);
			sb.append(",STREET_ID=" + String.valueOf(STREET_ID));
			sb.append(",STREET_NUMBER=" + STREET_NUMBER);
			sb.append(",CUSTOMER_TYPE_ID=" + String.valueOf(CUSTOMER_TYPE_ID));
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(CustomerStruct other) {

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
		final static byte[] commonByteArrayLock_PROJETDATAV1_Job01_Customer_Dim = new byte[0];
		static byte[] commonByteArray_PROJETDATAV1_Job01_Customer_Dim = new byte[0];
		protected static final int DEFAULT_HASHCODE = 1;
		protected static final int PRIME = 31;
		protected int hashCode = DEFAULT_HASHCODE;
		public boolean hashCodeDirty = true;

		public String loopKey;

		public Double CUSTOMER_ID;

		public Double getCUSTOMER_ID() {
			return this.CUSTOMER_ID;
		}

		public String COUNTRY;

		public String getCOUNTRY() {
			return this.COUNTRY;
		}

		public Character GENDER;

		public Character getGENDER() {
			return this.GENDER;
		}

		public String PERSONAL_ID;

		public String getPERSONAL_ID() {
			return this.PERSONAL_ID;
		}

		public String CUSTOMER_NAME;

		public String getCUSTOMER_NAME() {
			return this.CUSTOMER_NAME;
		}

		public String CUSTOMER_FIRSTNAME;

		public String getCUSTOMER_FIRSTNAME() {
			return this.CUSTOMER_FIRSTNAME;
		}

		public String CUSTOMER_LASTNAME;

		public String getCUSTOMER_LASTNAME() {
			return this.CUSTOMER_LASTNAME;
		}

		public java.util.Date BIRTH_DATE;

		public java.util.Date getBIRTH_DATE() {
			return this.BIRTH_DATE;
		}

		public String CUSTOMER_ADDRESS;

		public String getCUSTOMER_ADDRESS() {
			return this.CUSTOMER_ADDRESS;
		}

		public Double STREET_ID;

		public Double getSTREET_ID() {
			return this.STREET_ID;
		}

		public String STREET_NUMBER;

		public String getSTREET_NUMBER() {
			return this.STREET_NUMBER;
		}

		public Double CUSTOMER_TYPE_ID;

		public Double getCUSTOMER_TYPE_ID() {
			return this.CUSTOMER_TYPE_ID;
		}

		@Override
		public int hashCode() {
			if (this.hashCodeDirty) {
				final int prime = PRIME;
				int result = DEFAULT_HASHCODE;

				result = prime * result + ((this.CUSTOMER_ID == null) ? 0 : this.CUSTOMER_ID.hashCode());

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

			if (this.CUSTOMER_ID == null) {
				if (other.CUSTOMER_ID != null)
					return false;

			} else if (!this.CUSTOMER_ID.equals(other.CUSTOMER_ID))

				return false;

			return true;
		}

		public void copyDataTo(after_tDBInput_1Struct other) {

			other.CUSTOMER_ID = this.CUSTOMER_ID;
			other.COUNTRY = this.COUNTRY;
			other.GENDER = this.GENDER;
			other.PERSONAL_ID = this.PERSONAL_ID;
			other.CUSTOMER_NAME = this.CUSTOMER_NAME;
			other.CUSTOMER_FIRSTNAME = this.CUSTOMER_FIRSTNAME;
			other.CUSTOMER_LASTNAME = this.CUSTOMER_LASTNAME;
			other.BIRTH_DATE = this.BIRTH_DATE;
			other.CUSTOMER_ADDRESS = this.CUSTOMER_ADDRESS;
			other.STREET_ID = this.STREET_ID;
			other.STREET_NUMBER = this.STREET_NUMBER;
			other.CUSTOMER_TYPE_ID = this.CUSTOMER_TYPE_ID;

		}

		public void copyKeysDataTo(after_tDBInput_1Struct other) {

			other.CUSTOMER_ID = this.CUSTOMER_ID;

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_PROJETDATAV1_Job01_Customer_Dim.length) {
					if (length < 1024 && commonByteArray_PROJETDATAV1_Job01_Customer_Dim.length == 0) {
						commonByteArray_PROJETDATAV1_Job01_Customer_Dim = new byte[1024];
					} else {
						commonByteArray_PROJETDATAV1_Job01_Customer_Dim = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_PROJETDATAV1_Job01_Customer_Dim, 0, length);
				strReturn = new String(commonByteArray_PROJETDATAV1_Job01_Customer_Dim, 0, length, utf8Charset);
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
				if (length > commonByteArray_PROJETDATAV1_Job01_Customer_Dim.length) {
					if (length < 1024 && commonByteArray_PROJETDATAV1_Job01_Customer_Dim.length == 0) {
						commonByteArray_PROJETDATAV1_Job01_Customer_Dim = new byte[1024];
					} else {
						commonByteArray_PROJETDATAV1_Job01_Customer_Dim = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_PROJETDATAV1_Job01_Customer_Dim, 0, length);
				strReturn = new String(commonByteArray_PROJETDATAV1_Job01_Customer_Dim, 0, length, utf8Charset);
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

		private java.util.Date readDate(ObjectInputStream dis) throws IOException {
			java.util.Date dateReturn = null;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				dateReturn = null;
			} else {
				dateReturn = new Date(dis.readLong());
			}
			return dateReturn;
		}

		private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			java.util.Date dateReturn = null;
			int length = 0;
			length = unmarshaller.readByte();
			if (length == -1) {
				dateReturn = null;
			} else {
				dateReturn = new Date(unmarshaller.readLong());
			}
			return dateReturn;
		}

		private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException {
			if (date1 == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeLong(date1.getTime());
			}
		}

		private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (date1 == null) {
				marshaller.writeByte(-1);
			} else {
				marshaller.writeByte(0);
				marshaller.writeLong(date1.getTime());
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_PROJETDATAV1_Job01_Customer_Dim) {

				try {

					int length = 0;

					length = dis.readByte();
					if (length == -1) {
						this.CUSTOMER_ID = null;
					} else {
						this.CUSTOMER_ID = dis.readDouble();
					}

					this.COUNTRY = readString(dis);

					length = dis.readByte();
					if (length == -1) {
						this.GENDER = null;
					} else {
						this.GENDER = dis.readChar();
					}

					this.PERSONAL_ID = readString(dis);

					this.CUSTOMER_NAME = readString(dis);

					this.CUSTOMER_FIRSTNAME = readString(dis);

					this.CUSTOMER_LASTNAME = readString(dis);

					this.BIRTH_DATE = readDate(dis);

					this.CUSTOMER_ADDRESS = readString(dis);

					length = dis.readByte();
					if (length == -1) {
						this.STREET_ID = null;
					} else {
						this.STREET_ID = dis.readDouble();
					}

					this.STREET_NUMBER = readString(dis);

					length = dis.readByte();
					if (length == -1) {
						this.CUSTOMER_TYPE_ID = null;
					} else {
						this.CUSTOMER_TYPE_ID = dis.readDouble();
					}

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_PROJETDATAV1_Job01_Customer_Dim) {

				try {

					int length = 0;

					length = dis.readByte();
					if (length == -1) {
						this.CUSTOMER_ID = null;
					} else {
						this.CUSTOMER_ID = dis.readDouble();
					}

					this.COUNTRY = readString(dis);

					length = dis.readByte();
					if (length == -1) {
						this.GENDER = null;
					} else {
						this.GENDER = dis.readChar();
					}

					this.PERSONAL_ID = readString(dis);

					this.CUSTOMER_NAME = readString(dis);

					this.CUSTOMER_FIRSTNAME = readString(dis);

					this.CUSTOMER_LASTNAME = readString(dis);

					this.BIRTH_DATE = readDate(dis);

					this.CUSTOMER_ADDRESS = readString(dis);

					length = dis.readByte();
					if (length == -1) {
						this.STREET_ID = null;
					} else {
						this.STREET_ID = dis.readDouble();
					}

					this.STREET_NUMBER = readString(dis);

					length = dis.readByte();
					if (length == -1) {
						this.CUSTOMER_TYPE_ID = null;
					} else {
						this.CUSTOMER_TYPE_ID = dis.readDouble();
					}

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// Double

				if (this.CUSTOMER_ID == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this.CUSTOMER_ID);
				}

				// String

				writeString(this.COUNTRY, dos);

				// Character

				if (this.GENDER == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeChar(this.GENDER);
				}

				// String

				writeString(this.PERSONAL_ID, dos);

				// String

				writeString(this.CUSTOMER_NAME, dos);

				// String

				writeString(this.CUSTOMER_FIRSTNAME, dos);

				// String

				writeString(this.CUSTOMER_LASTNAME, dos);

				// java.util.Date

				writeDate(this.BIRTH_DATE, dos);

				// String

				writeString(this.CUSTOMER_ADDRESS, dos);

				// Double

				if (this.STREET_ID == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this.STREET_ID);
				}

				// String

				writeString(this.STREET_NUMBER, dos);

				// Double

				if (this.CUSTOMER_TYPE_ID == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this.CUSTOMER_TYPE_ID);
				}

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// Double

				if (this.CUSTOMER_ID == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this.CUSTOMER_ID);
				}

				// String

				writeString(this.COUNTRY, dos);

				// Character

				if (this.GENDER == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeChar(this.GENDER);
				}

				// String

				writeString(this.PERSONAL_ID, dos);

				// String

				writeString(this.CUSTOMER_NAME, dos);

				// String

				writeString(this.CUSTOMER_FIRSTNAME, dos);

				// String

				writeString(this.CUSTOMER_LASTNAME, dos);

				// java.util.Date

				writeDate(this.BIRTH_DATE, dos);

				// String

				writeString(this.CUSTOMER_ADDRESS, dos);

				// Double

				if (this.STREET_ID == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this.STREET_ID);
				}

				// String

				writeString(this.STREET_NUMBER, dos);

				// Double

				if (this.CUSTOMER_TYPE_ID == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this.CUSTOMER_TYPE_ID);
				}

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("CUSTOMER_ID=" + String.valueOf(CUSTOMER_ID));
			sb.append(",COUNTRY=" + COUNTRY);
			sb.append(",GENDER=" + String.valueOf(GENDER));
			sb.append(",PERSONAL_ID=" + PERSONAL_ID);
			sb.append(",CUSTOMER_NAME=" + CUSTOMER_NAME);
			sb.append(",CUSTOMER_FIRSTNAME=" + CUSTOMER_FIRSTNAME);
			sb.append(",CUSTOMER_LASTNAME=" + CUSTOMER_LASTNAME);
			sb.append(",BIRTH_DATE=" + String.valueOf(BIRTH_DATE));
			sb.append(",CUSTOMER_ADDRESS=" + CUSTOMER_ADDRESS);
			sb.append(",STREET_ID=" + String.valueOf(STREET_ID));
			sb.append(",STREET_NUMBER=" + STREET_NUMBER);
			sb.append(",CUSTOMER_TYPE_ID=" + String.valueOf(CUSTOMER_TYPE_ID));
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(after_tDBInput_1Struct other) {

			int returnValue = -1;

			returnValue = checkNullsAndCompare(this.CUSTOMER_ID, other.CUSTOMER_ID);
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

				CustomerStruct Customer = new CustomerStruct();
				customer_dimStruct customer_dim = new customer_dimStruct();

				/**
				 * [tDBOutput_1 begin ] start
				 */

				ok_Hash.put("tDBOutput_1", false);
				start_Hash.put("tDBOutput_1", System.currentTimeMillis());

				currentComponent = "tDBOutput_1";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "customer_dim");
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
						"enc:routine.encryption.key.v1:IswU0gVtFPCTgM7+baAoypN2icSY/x3KqEtokuJtwWkoliD/Tk1ts5Q=");

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
					tableName_tDBOutput_1 = ("Customer_Dim");
				} else {
					tableName_tDBOutput_1 = dbschema_tDBOutput_1 + "." + ("Customer_Dim");
				}
				java.sql.PreparedStatement pstmt_tDBOutput_1 = conn_tDBOutput_1
						.prepareStatement("SELECT COUNT(1) FROM " + tableName_tDBOutput_1 + " WHERE Customer_ID = ?");
				resourceMap.put("pstmt_tDBOutput_1", pstmt_tDBOutput_1);
				String insert_tDBOutput_1 = "INSERT INTO " + tableName_tDBOutput_1
						+ " (Customer_ID,Customer_Country,Customer_Group,Customer_Type,Customer_Gender,Customer_Age_Group,Customer_Age,Customer_Name,Customer_Firstname,Customer_Lastname,Customer_Birth_Date) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
				java.sql.PreparedStatement pstmtInsert_tDBOutput_1 = conn_tDBOutput_1
						.prepareStatement(insert_tDBOutput_1);
				resourceMap.put("pstmtInsert_tDBOutput_1", pstmtInsert_tDBOutput_1);
				String update_tDBOutput_1 = "UPDATE " + tableName_tDBOutput_1
						+ " SET Customer_Country = ?,Customer_Group = ?,Customer_Type = ?,Customer_Gender = ?,Customer_Age_Group = ?,Customer_Age = ?,Customer_Name = ?,Customer_Firstname = ?,Customer_Lastname = ?,Customer_Birth_Date = ? WHERE Customer_ID = ?";
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
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "Customer");
				}

				int tos_count_tMap_1 = 0;

// ###############################
// # Lookup's keys initialization

				org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<Customer_typeStruct> tHash_Lookup_Customer_type = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<Customer_typeStruct>) ((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<Customer_typeStruct>) globalMap
						.get("tHash_Lookup_Customer_type"));

				tHash_Lookup_Customer_type.initGet();

				Customer_typeStruct Customer_typeHashKey = new Customer_typeStruct();
				Customer_typeStruct Customer_typeDefault = new Customer_typeStruct();
// ###############################        

// ###############################
// # Vars initialization
				class Var__tMap_1__Struct {
					Integer Age;
					String Age_GROUP;
				}
				Var__tMap_1__Struct Var__tMap_1 = new Var__tMap_1__Struct();
// ###############################

// ###############################
// # Outputs initialization
				customer_dimStruct customer_dim_tmp = new customer_dimStruct();
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

				String dbquery_tDBInput_1 = "SELECT \n  CUSTOMER.CUSTOMER_ID, \n  CUSTOMER.COUNTRY, \n  CUSTOMER.GENDER, \n  CUSTOMER.PERSONAL_ID, \n  CUSTOMER.CUSTOMER_"
						+ "NAME, \n  CUSTOMER.CUSTOMER_FIRSTNAME, \n  CUSTOMER.CUSTOMER_LASTNAME, \n  CUSTOMER.BIRTH_DATE, \n  CUSTOMER.CUSTOMER_ADDRES"
						+ "S, \n  CUSTOMER.STREET_ID, \n  CUSTOMER.STREET_NUMBER, \n  CUSTOMER.CUSTOMER_TYPE_ID\nFROM CUSTOMER";

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
							Customer.CUSTOMER_ID = null;
						} else {

							Customer.CUSTOMER_ID = rs_tDBInput_1.getDouble(1);
							if (rs_tDBInput_1.wasNull()) {
								Customer.CUSTOMER_ID = null;
							}
						}
						if (colQtyInRs_tDBInput_1 < 2) {
							Customer.COUNTRY = null;
						} else {

							Customer.COUNTRY = routines.system.JDBCUtil.getString(rs_tDBInput_1, 2, false);
						}
						if (colQtyInRs_tDBInput_1 < 3) {
							Customer.GENDER = null;
						} else {

							tmpContent_tDBInput_1 = rs_tDBInput_1.getString(3);
							if (tmpContent_tDBInput_1 != null && tmpContent_tDBInput_1.length() > 0) {
								Customer.GENDER = tmpContent_tDBInput_1.charAt(0);
							} else {
								if (tmpContent_tDBInput_1 == null) {
									Customer.GENDER = null;
								} else {
									Customer.GENDER = '\0';
								}
							}
						}
						if (colQtyInRs_tDBInput_1 < 4) {
							Customer.PERSONAL_ID = null;
						} else {

							Customer.PERSONAL_ID = routines.system.JDBCUtil.getString(rs_tDBInput_1, 4, false);
						}
						if (colQtyInRs_tDBInput_1 < 5) {
							Customer.CUSTOMER_NAME = null;
						} else {

							Customer.CUSTOMER_NAME = routines.system.JDBCUtil.getString(rs_tDBInput_1, 5, false);
						}
						if (colQtyInRs_tDBInput_1 < 6) {
							Customer.CUSTOMER_FIRSTNAME = null;
						} else {

							Customer.CUSTOMER_FIRSTNAME = routines.system.JDBCUtil.getString(rs_tDBInput_1, 6, false);
						}
						if (colQtyInRs_tDBInput_1 < 7) {
							Customer.CUSTOMER_LASTNAME = null;
						} else {

							Customer.CUSTOMER_LASTNAME = routines.system.JDBCUtil.getString(rs_tDBInput_1, 7, false);
						}
						if (colQtyInRs_tDBInput_1 < 8) {
							Customer.BIRTH_DATE = null;
						} else {

							java.sql.Timestamp timestamp_tDBInput_1 = rs_tDBInput_1.getTimestamp(8);
							if (timestamp_tDBInput_1 != null) {
								Customer.BIRTH_DATE = new java.util.Date(timestamp_tDBInput_1.getTime());
							} else {
								Customer.BIRTH_DATE = null;
							}
						}
						if (colQtyInRs_tDBInput_1 < 9) {
							Customer.CUSTOMER_ADDRESS = null;
						} else {

							Customer.CUSTOMER_ADDRESS = routines.system.JDBCUtil.getString(rs_tDBInput_1, 9, false);
						}
						if (colQtyInRs_tDBInput_1 < 10) {
							Customer.STREET_ID = null;
						} else {

							Customer.STREET_ID = rs_tDBInput_1.getDouble(10);
							if (rs_tDBInput_1.wasNull()) {
								Customer.STREET_ID = null;
							}
						}
						if (colQtyInRs_tDBInput_1 < 11) {
							Customer.STREET_NUMBER = null;
						} else {

							Customer.STREET_NUMBER = routines.system.JDBCUtil.getString(rs_tDBInput_1, 11, false);
						}
						if (colQtyInRs_tDBInput_1 < 12) {
							Customer.CUSTOMER_TYPE_ID = null;
						} else {

							Customer.CUSTOMER_TYPE_ID = rs_tDBInput_1.getDouble(12);
							if (rs_tDBInput_1.wasNull()) {
								Customer.CUSTOMER_TYPE_ID = null;
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

									, "Customer"

							);
						}

						boolean hasCasePrimitiveKeyWithNull_tMap_1 = false;

						// ###############################
						// # Input tables (lookups)
						boolean rejectedInnerJoin_tMap_1 = false;
						boolean mainRowRejected_tMap_1 = false;

						///////////////////////////////////////////////
						// Starting Lookup Table "Customer_type"
						///////////////////////////////////////////////

						boolean forceLoopCustomer_type = false;

						Customer_typeStruct Customer_typeObjectFromLookup = null;

						if (!rejectedInnerJoin_tMap_1) { // G_TM_M_020

							tHash_Lookup_Customer_type.lookup(Customer_typeHashKey);

							if (!tHash_Lookup_Customer_type.hasNext()) { // G_TM_M_090

								forceLoopCustomer_type = true;

							} // G_TM_M_090

						} // G_TM_M_020

						else { // G 20 - G 21
							forceLoopCustomer_type = true;
						} // G 21

						Customer_typeStruct Customer_type = null;

						while ((tHash_Lookup_Customer_type != null && tHash_Lookup_Customer_type.hasNext())
								|| forceLoopCustomer_type) { // G_TM_M_043

							// CALL close loop of lookup 'Customer_type'

							Customer_typeStruct fromLookup_Customer_type = null;
							Customer_type = Customer_typeDefault;

							if (!forceLoopCustomer_type) { // G 46

								fromLookup_Customer_type = tHash_Lookup_Customer_type.next();

								if (fromLookup_Customer_type != null) {
									Customer_type = fromLookup_Customer_type;
								}

							} // G 46

							forceLoopCustomer_type = false;

							// ###############################
							{ // start of Var scope

								// ###############################
								// # Vars tables

								Var__tMap_1__Struct Var = Var__tMap_1;
								Var.Age = Mathematical.INT(TalendDate.formatDate("yyyy", TalendDate.getCurrentDate()))
										- Mathematical.INT(TalendDate.formatDate("yyyy", Customer.BIRTH_DATE));
								Var.Age_GROUP = Var.Age < 30 ? "<30 years"
										: Var.Age < 46 ? "30-45 years"
												: Var.Age < 61 ? "46-60 years"
														: Var.Age < 76 ? "61-75 years" : ">75 years";// ###############################
								// ###############################
								// # Output tables

								customer_dim = null;

// # Output table : 'customer_dim'
								customer_dim_tmp.Customer_ID = Customer.CUSTOMER_ID;
								customer_dim_tmp.Customer_Country = Customer.COUNTRY;
								customer_dim_tmp.Customer_Group = Customer_type.CUSTOMER_GROUP;
								customer_dim_tmp.Customer_Type = Customer_type.CUSTOMER_TYPE;
								customer_dim_tmp.Customer_Gender = Customer.GENDER;
								customer_dim_tmp.Customer_Age_Group = Var.Age_GROUP;
								customer_dim_tmp.Customer_Age = Var.Age;
								customer_dim_tmp.Customer_Name = Customer.CUSTOMER_NAME;
								customer_dim_tmp.Customer_Firstname = Customer.CUSTOMER_FIRSTNAME;
								customer_dim_tmp.Customer_Lastname = Customer.CUSTOMER_LASTNAME;
								customer_dim_tmp.Customer_Birth_Date = Customer.BIRTH_DATE;
								customer_dim = customer_dim_tmp;
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
// Start of branch "customer_dim"
							if (customer_dim != null) {

								/**
								 * [tDBOutput_1 main ] start
								 */

								currentComponent = "tDBOutput_1";

								if (execStat) {
									runStat.updateStatOnConnection(iterateId, 1, 1

											, "customer_dim"

									);
								}

								whetherReject_tDBOutput_1 = false;
								pstmt_tDBOutput_1.setDouble(1, customer_dim.Customer_ID);

								int checkCount_tDBOutput_1 = -1;
								try (java.sql.ResultSet rs_tDBOutput_1 = pstmt_tDBOutput_1.executeQuery()) {
									while (rs_tDBOutput_1.next()) {
										checkCount_tDBOutput_1 = rs_tDBOutput_1.getInt(1);
									}
								}
								if (checkCount_tDBOutput_1 > 0) {
									if (customer_dim.Customer_Country == null) {
										pstmtUpdate_tDBOutput_1.setNull(1, java.sql.Types.VARCHAR);
									} else {
										pstmtUpdate_tDBOutput_1.setString(1, customer_dim.Customer_Country);
									}

									if (customer_dim.Customer_Group == null) {
										pstmtUpdate_tDBOutput_1.setNull(2, java.sql.Types.CHAR);
									} else {
										if (customer_dim.Customer_Group == null) {
											pstmtUpdate_tDBOutput_1.setNull(2, java.sql.Types.CHAR);
										} else if (customer_dim.Customer_Group == ' ') {
											pstmtUpdate_tDBOutput_1.setString(2, "");
										} else {
											pstmtUpdate_tDBOutput_1.setString(2,
													String.valueOf(customer_dim.Customer_Group));
										}
									}

									if (customer_dim.Customer_Type == null) {
										pstmtUpdate_tDBOutput_1.setNull(3, java.sql.Types.CHAR);
									} else {
										if (customer_dim.Customer_Type == null) {
											pstmtUpdate_tDBOutput_1.setNull(3, java.sql.Types.CHAR);
										} else if (customer_dim.Customer_Type == ' ') {
											pstmtUpdate_tDBOutput_1.setString(3, "");
										} else {
											pstmtUpdate_tDBOutput_1.setString(3,
													String.valueOf(customer_dim.Customer_Type));
										}
									}

									if (customer_dim.Customer_Gender == null) {
										pstmtUpdate_tDBOutput_1.setNull(4, java.sql.Types.CHAR);
									} else {
										if (customer_dim.Customer_Gender == null) {
											pstmtUpdate_tDBOutput_1.setNull(4, java.sql.Types.CHAR);
										} else if (customer_dim.Customer_Gender == ' ') {
											pstmtUpdate_tDBOutput_1.setString(4, "");
										} else {
											pstmtUpdate_tDBOutput_1.setString(4,
													String.valueOf(customer_dim.Customer_Gender));
										}
									}

									if (customer_dim.Customer_Age_Group == null) {
										pstmtUpdate_tDBOutput_1.setNull(5, java.sql.Types.VARCHAR);
									} else {
										pstmtUpdate_tDBOutput_1.setString(5, customer_dim.Customer_Age_Group);
									}

									pstmtUpdate_tDBOutput_1.setInt(6, customer_dim.Customer_Age);

									if (customer_dim.Customer_Name == null) {
										pstmtUpdate_tDBOutput_1.setNull(7, java.sql.Types.VARCHAR);
									} else {
										pstmtUpdate_tDBOutput_1.setString(7, customer_dim.Customer_Name);
									}

									if (customer_dim.Customer_Firstname == null) {
										pstmtUpdate_tDBOutput_1.setNull(8, java.sql.Types.VARCHAR);
									} else {
										pstmtUpdate_tDBOutput_1.setString(8, customer_dim.Customer_Firstname);
									}

									if (customer_dim.Customer_Lastname == null) {
										pstmtUpdate_tDBOutput_1.setNull(9, java.sql.Types.VARCHAR);
									} else {
										pstmtUpdate_tDBOutput_1.setString(9, customer_dim.Customer_Lastname);
									}

									if (customer_dim.Customer_Birth_Date != null) {
										pstmtUpdate_tDBOutput_1.setTimestamp(10,
												new java.sql.Timestamp(customer_dim.Customer_Birth_Date.getTime()));
									} else {
										pstmtUpdate_tDBOutput_1.setNull(10, java.sql.Types.DATE);
									}

									pstmtUpdate_tDBOutput_1.setDouble(11 + count_tDBOutput_1, customer_dim.Customer_ID);

									try {
										int processedCount_tDBOutput_1 = pstmtUpdate_tDBOutput_1.executeUpdate();
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
									pstmtInsert_tDBOutput_1.setDouble(1, customer_dim.Customer_ID);

									if (customer_dim.Customer_Country == null) {
										pstmtInsert_tDBOutput_1.setNull(2, java.sql.Types.VARCHAR);
									} else {
										pstmtInsert_tDBOutput_1.setString(2, customer_dim.Customer_Country);
									}

									if (customer_dim.Customer_Group == null) {
										pstmtInsert_tDBOutput_1.setNull(3, java.sql.Types.CHAR);
									} else {
										if (customer_dim.Customer_Group == null) {
											pstmtInsert_tDBOutput_1.setNull(3, java.sql.Types.CHAR);
										} else if (customer_dim.Customer_Group == ' ') {
											pstmtInsert_tDBOutput_1.setString(3, "");
										} else {
											pstmtInsert_tDBOutput_1.setString(3,
													String.valueOf(customer_dim.Customer_Group));
										}
									}

									if (customer_dim.Customer_Type == null) {
										pstmtInsert_tDBOutput_1.setNull(4, java.sql.Types.CHAR);
									} else {
										if (customer_dim.Customer_Type == null) {
											pstmtInsert_tDBOutput_1.setNull(4, java.sql.Types.CHAR);
										} else if (customer_dim.Customer_Type == ' ') {
											pstmtInsert_tDBOutput_1.setString(4, "");
										} else {
											pstmtInsert_tDBOutput_1.setString(4,
													String.valueOf(customer_dim.Customer_Type));
										}
									}

									if (customer_dim.Customer_Gender == null) {
										pstmtInsert_tDBOutput_1.setNull(5, java.sql.Types.CHAR);
									} else {
										if (customer_dim.Customer_Gender == null) {
											pstmtInsert_tDBOutput_1.setNull(5, java.sql.Types.CHAR);
										} else if (customer_dim.Customer_Gender == ' ') {
											pstmtInsert_tDBOutput_1.setString(5, "");
										} else {
											pstmtInsert_tDBOutput_1.setString(5,
													String.valueOf(customer_dim.Customer_Gender));
										}
									}

									if (customer_dim.Customer_Age_Group == null) {
										pstmtInsert_tDBOutput_1.setNull(6, java.sql.Types.VARCHAR);
									} else {
										pstmtInsert_tDBOutput_1.setString(6, customer_dim.Customer_Age_Group);
									}

									pstmtInsert_tDBOutput_1.setInt(7, customer_dim.Customer_Age);

									if (customer_dim.Customer_Name == null) {
										pstmtInsert_tDBOutput_1.setNull(8, java.sql.Types.VARCHAR);
									} else {
										pstmtInsert_tDBOutput_1.setString(8, customer_dim.Customer_Name);
									}

									if (customer_dim.Customer_Firstname == null) {
										pstmtInsert_tDBOutput_1.setNull(9, java.sql.Types.VARCHAR);
									} else {
										pstmtInsert_tDBOutput_1.setString(9, customer_dim.Customer_Firstname);
									}

									if (customer_dim.Customer_Lastname == null) {
										pstmtInsert_tDBOutput_1.setNull(10, java.sql.Types.VARCHAR);
									} else {
										pstmtInsert_tDBOutput_1.setString(10, customer_dim.Customer_Lastname);
									}

									if (customer_dim.Customer_Birth_Date != null) {
										pstmtInsert_tDBOutput_1.setTimestamp(11,
												new java.sql.Timestamp(customer_dim.Customer_Birth_Date.getTime()));
									} else {
										pstmtInsert_tDBOutput_1.setNull(11, java.sql.Types.DATE);
									}

									try {
										int processedCount_tDBOutput_1 = pstmtInsert_tDBOutput_1.executeUpdate();
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

							} // End of branch "customer_dim"

						} // close loop of lookup 'Customer_type' // G_TM_M_043

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
				if (tHash_Lookup_Customer_type != null) {
					tHash_Lookup_Customer_type.endGet();
				}
				globalMap.remove("tHash_Lookup_Customer_type");

// ###############################      

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "Customer");
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
					runStat.updateStat(resourceMap, iterateId, 2, 0, "customer_dim");
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
			globalMap.remove("tHash_Lookup_Customer_type");

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

	public static class Customer_typeStruct implements routines.system.IPersistableRow<Customer_typeStruct> {
		final static byte[] commonByteArrayLock_PROJETDATAV1_Job01_Customer_Dim = new byte[0];
		static byte[] commonByteArray_PROJETDATAV1_Job01_Customer_Dim = new byte[0];

		public double CUSTOMER_TYPE_ID;

		public double getCUSTOMER_TYPE_ID() {
			return this.CUSTOMER_TYPE_ID;
		}

		public String CUSTOMER_TYPE;

		public String getCUSTOMER_TYPE() {
			return this.CUSTOMER_TYPE;
		}

		public double CUSTOMER_GROUP_ID;

		public double getCUSTOMER_GROUP_ID() {
			return this.CUSTOMER_GROUP_ID;
		}

		public String CUSTOMER_GROUP;

		public String getCUSTOMER_GROUP() {
			return this.CUSTOMER_GROUP;
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_PROJETDATAV1_Job01_Customer_Dim.length) {
					if (length < 1024 && commonByteArray_PROJETDATAV1_Job01_Customer_Dim.length == 0) {
						commonByteArray_PROJETDATAV1_Job01_Customer_Dim = new byte[1024];
					} else {
						commonByteArray_PROJETDATAV1_Job01_Customer_Dim = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_PROJETDATAV1_Job01_Customer_Dim, 0, length);
				strReturn = new String(commonByteArray_PROJETDATAV1_Job01_Customer_Dim, 0, length, utf8Charset);
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
				if (length > commonByteArray_PROJETDATAV1_Job01_Customer_Dim.length) {
					if (length < 1024 && commonByteArray_PROJETDATAV1_Job01_Customer_Dim.length == 0) {
						commonByteArray_PROJETDATAV1_Job01_Customer_Dim = new byte[1024];
					} else {
						commonByteArray_PROJETDATAV1_Job01_Customer_Dim = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_PROJETDATAV1_Job01_Customer_Dim, 0, length);
				strReturn = new String(commonByteArray_PROJETDATAV1_Job01_Customer_Dim, 0, length, utf8Charset);
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

			synchronized (commonByteArrayLock_PROJETDATAV1_Job01_Customer_Dim) {

				try {

					int length = 0;

					this.CUSTOMER_TYPE_ID = dis.readDouble();

					this.CUSTOMER_TYPE = readString(dis);

					this.CUSTOMER_GROUP_ID = dis.readDouble();

					this.CUSTOMER_GROUP = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_PROJETDATAV1_Job01_Customer_Dim) {

				try {

					int length = 0;

					this.CUSTOMER_TYPE_ID = dis.readDouble();

					this.CUSTOMER_TYPE = readString(dis);

					this.CUSTOMER_GROUP_ID = dis.readDouble();

					this.CUSTOMER_GROUP = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// double

				dos.writeDouble(this.CUSTOMER_TYPE_ID);

				// String

				writeString(this.CUSTOMER_TYPE, dos);

				// double

				dos.writeDouble(this.CUSTOMER_GROUP_ID);

				// String

				writeString(this.CUSTOMER_GROUP, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// double

				dos.writeDouble(this.CUSTOMER_TYPE_ID);

				// String

				writeString(this.CUSTOMER_TYPE, dos);

				// double

				dos.writeDouble(this.CUSTOMER_GROUP_ID);

				// String

				writeString(this.CUSTOMER_GROUP, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("CUSTOMER_TYPE_ID=" + String.valueOf(CUSTOMER_TYPE_ID));
			sb.append(",CUSTOMER_TYPE=" + CUSTOMER_TYPE);
			sb.append(",CUSTOMER_GROUP_ID=" + String.valueOf(CUSTOMER_GROUP_ID));
			sb.append(",CUSTOMER_GROUP=" + CUSTOMER_GROUP);
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(Customer_typeStruct other) {

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

				Customer_typeStruct Customer_type = new Customer_typeStruct();

				/**
				 * [tAdvancedHash_Customer_type begin ] start
				 */

				ok_Hash.put("tAdvancedHash_Customer_type", false);
				start_Hash.put("tAdvancedHash_Customer_type", System.currentTimeMillis());

				currentComponent = "tAdvancedHash_Customer_type";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "Customer_type");
				}

				int tos_count_tAdvancedHash_Customer_type = 0;

				// connection name:Customer_type
				// source node:tDBInput_2 - inputs:(after_tDBInput_1)
				// outputs:(Customer_type,Customer_type) | target
				// node:tAdvancedHash_Customer_type - inputs:(Customer_type) outputs:()
				// linked node: tMap_1 - inputs:(Customer,Customer_type) outputs:(customer_dim)

				org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_Customer_type = org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.ALL_ROWS;

				org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<Customer_typeStruct> tHash_Lookup_Customer_type = org.talend.designer.components.lookup.memory.AdvancedMemoryLookup
						.<Customer_typeStruct>getLookup(matchingModeEnum_Customer_type);

				globalMap.put("tHash_Lookup_Customer_type", tHash_Lookup_Customer_type);

				/**
				 * [tAdvancedHash_Customer_type begin ] stop
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

				String dbquery_tDBInput_2 = "select * from sysobjects ";

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
							Customer_type.CUSTOMER_TYPE_ID = 0;
						} else {

							Customer_type.CUSTOMER_TYPE_ID = rs_tDBInput_2.getDouble(1);
							if (rs_tDBInput_2.wasNull()) {
								throw new RuntimeException("Null value in non-Nullable column");
							}
						}
						if (colQtyInRs_tDBInput_2 < 2) {
							Customer_type.CUSTOMER_TYPE = null;
						} else {

							Customer_type.CUSTOMER_TYPE = routines.system.JDBCUtil.getString(rs_tDBInput_2, 2, false);
						}
						if (colQtyInRs_tDBInput_2 < 3) {
							Customer_type.CUSTOMER_GROUP_ID = 0;
						} else {

							Customer_type.CUSTOMER_GROUP_ID = rs_tDBInput_2.getDouble(3);
							if (rs_tDBInput_2.wasNull()) {
								throw new RuntimeException("Null value in non-Nullable column");
							}
						}
						if (colQtyInRs_tDBInput_2 < 4) {
							Customer_type.CUSTOMER_GROUP = null;
						} else {

							Customer_type.CUSTOMER_GROUP = routines.system.JDBCUtil.getString(rs_tDBInput_2, 4, false);
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
						 * [tAdvancedHash_Customer_type main ] start
						 */

						currentComponent = "tAdvancedHash_Customer_type";

						if (execStat) {
							runStat.updateStatOnConnection(iterateId, 1, 1

									, "Customer_type"

							);
						}

						Customer_typeStruct Customer_type_HashRow = new Customer_typeStruct();

						Customer_type_HashRow.CUSTOMER_TYPE_ID = Customer_type.CUSTOMER_TYPE_ID;

						Customer_type_HashRow.CUSTOMER_TYPE = Customer_type.CUSTOMER_TYPE;

						Customer_type_HashRow.CUSTOMER_GROUP_ID = Customer_type.CUSTOMER_GROUP_ID;

						Customer_type_HashRow.CUSTOMER_GROUP = Customer_type.CUSTOMER_GROUP;

						tHash_Lookup_Customer_type.put(Customer_type_HashRow);

						tos_count_tAdvancedHash_Customer_type++;

						/**
						 * [tAdvancedHash_Customer_type main ] stop
						 */

						/**
						 * [tAdvancedHash_Customer_type process_data_begin ] start
						 */

						currentComponent = "tAdvancedHash_Customer_type";

						/**
						 * [tAdvancedHash_Customer_type process_data_begin ] stop
						 */

						/**
						 * [tAdvancedHash_Customer_type process_data_end ] start
						 */

						currentComponent = "tAdvancedHash_Customer_type";

						/**
						 * [tAdvancedHash_Customer_type process_data_end ] stop
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
				 * [tAdvancedHash_Customer_type end ] start
				 */

				currentComponent = "tAdvancedHash_Customer_type";

				tHash_Lookup_Customer_type.endPut();

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "Customer_type");
				}

				ok_Hash.put("tAdvancedHash_Customer_type", true);
				end_Hash.put("tAdvancedHash_Customer_type", System.currentTimeMillis());

				/**
				 * [tAdvancedHash_Customer_type end ] stop
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
				 * [tAdvancedHash_Customer_type finally ] start
				 */

				currentComponent = "tAdvancedHash_Customer_type";

				/**
				 * [tAdvancedHash_Customer_type finally ] stop
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
		final Job01_Customer_Dim Job01_Customer_DimClass = new Job01_Customer_Dim();

		int exitCode = Job01_Customer_DimClass.runJobInTOS(args);

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
			java.io.InputStream inContext = Job01_Customer_Dim.class.getClassLoader()
					.getResourceAsStream("projetdatav1/job01_customer_dim_0_1/contexts/" + contextStr + ".properties");
			if (inContext == null) {
				inContext = Job01_Customer_Dim.class.getClassLoader()
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
					(endUsedMemory - startUsedMemory) + " bytes memory increase when running : Job01_Customer_Dim");
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
 * 123305 characters generated by Talend Open Studio for Data Integration on the
 * 24 janvier 2022 à 09:25:14 CET
 ************************************************************************************************/
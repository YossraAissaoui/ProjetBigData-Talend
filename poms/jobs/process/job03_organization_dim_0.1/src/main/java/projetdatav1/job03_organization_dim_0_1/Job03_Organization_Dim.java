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

package projetdatav1.job03_organization_dim_0_1;

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
 * Job: Job03_Organization_Dim Purpose: <br>
 * Description: <br>
 * 
 * @author user@talend.com
 * @version 8.0.1.20211109_1610
 * @status
 */
public class Job03_Organization_Dim implements TalendJob {

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
	private final String jobName = "Job03_Organization_Dim";
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
					Job03_Organization_Dim.this.exception = e;
				}
			}
			if (!(e instanceof TalendException)) {
				try {
					for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
						if (m.getName().compareTo(currentComponent + "_error") == 0) {
							m.invoke(Job03_Organization_Dim.this, new Object[] { e, currentComponent, globalMap });
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

	public void tFileInputExcel_1_error(Exception exception, String errorComponent,
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

	public void tAdvancedHash_row5_error(Exception exception, String errorComponent,
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

	public void tDBInput_1_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public static class Output_Organization_DimStruct
			implements routines.system.IPersistableRow<Output_Organization_DimStruct> {
		final static byte[] commonByteArrayLock_PROJETDATAV1_Job03_Organization_Dim = new byte[0];
		static byte[] commonByteArray_PROJETDATAV1_Job03_Organization_Dim = new byte[0];
		protected static final int DEFAULT_HASHCODE = 1;
		protected static final int PRIME = 31;
		protected int hashCode = DEFAULT_HASHCODE;
		public boolean hashCodeDirty = true;

		public String loopKey;

		public Double Employee_ID;

		public Double getEmployee_ID() {
			return this.Employee_ID;
		}

		public String Employee_Country;

		public String getEmployee_Country() {
			return this.Employee_Country;
		}

		public String Company;

		public String getCompany() {
			return this.Company;
		}

		public String Department;

		public String getDepartment() {
			return this.Department;
		}

		public String Section;

		public String getSection() {
			return this.Section;
		}

		public String Org_Group;

		public String getOrg_Group() {
			return this.Org_Group;
		}

		public String Job_Title;

		public String getJob_Title() {
			return this.Job_Title;
		}

		public String Employee_Name;

		public String getEmployee_Name() {
			return this.Employee_Name;
		}

		public Character Employee_Gender;

		public Character getEmployee_Gender() {
			return this.Employee_Gender;
		}

		public String Salary;

		public String getSalary() {
			return this.Salary;
		}

		public java.util.Date Employee_Birth_Date;

		public java.util.Date getEmployee_Birth_Date() {
			return this.Employee_Birth_Date;
		}

		public java.util.Date Employee_Hire_Date;

		public java.util.Date getEmployee_Hire_Date() {
			return this.Employee_Hire_Date;
		}

		public java.util.Date Employee_Term_Date;

		public java.util.Date getEmployee_Term_Date() {
			return this.Employee_Term_Date;
		}

		@Override
		public int hashCode() {
			if (this.hashCodeDirty) {
				final int prime = PRIME;
				int result = DEFAULT_HASHCODE;

				result = prime * result + ((this.Employee_ID == null) ? 0 : this.Employee_ID.hashCode());

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
			final Output_Organization_DimStruct other = (Output_Organization_DimStruct) obj;

			if (this.Employee_ID == null) {
				if (other.Employee_ID != null)
					return false;

			} else if (!this.Employee_ID.equals(other.Employee_ID))

				return false;

			return true;
		}

		public void copyDataTo(Output_Organization_DimStruct other) {

			other.Employee_ID = this.Employee_ID;
			other.Employee_Country = this.Employee_Country;
			other.Company = this.Company;
			other.Department = this.Department;
			other.Section = this.Section;
			other.Org_Group = this.Org_Group;
			other.Job_Title = this.Job_Title;
			other.Employee_Name = this.Employee_Name;
			other.Employee_Gender = this.Employee_Gender;
			other.Salary = this.Salary;
			other.Employee_Birth_Date = this.Employee_Birth_Date;
			other.Employee_Hire_Date = this.Employee_Hire_Date;
			other.Employee_Term_Date = this.Employee_Term_Date;

		}

		public void copyKeysDataTo(Output_Organization_DimStruct other) {

			other.Employee_ID = this.Employee_ID;

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_PROJETDATAV1_Job03_Organization_Dim.length) {
					if (length < 1024 && commonByteArray_PROJETDATAV1_Job03_Organization_Dim.length == 0) {
						commonByteArray_PROJETDATAV1_Job03_Organization_Dim = new byte[1024];
					} else {
						commonByteArray_PROJETDATAV1_Job03_Organization_Dim = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_PROJETDATAV1_Job03_Organization_Dim, 0, length);
				strReturn = new String(commonByteArray_PROJETDATAV1_Job03_Organization_Dim, 0, length, utf8Charset);
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
				if (length > commonByteArray_PROJETDATAV1_Job03_Organization_Dim.length) {
					if (length < 1024 && commonByteArray_PROJETDATAV1_Job03_Organization_Dim.length == 0) {
						commonByteArray_PROJETDATAV1_Job03_Organization_Dim = new byte[1024];
					} else {
						commonByteArray_PROJETDATAV1_Job03_Organization_Dim = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_PROJETDATAV1_Job03_Organization_Dim, 0, length);
				strReturn = new String(commonByteArray_PROJETDATAV1_Job03_Organization_Dim, 0, length, utf8Charset);
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

			synchronized (commonByteArrayLock_PROJETDATAV1_Job03_Organization_Dim) {

				try {

					int length = 0;

					length = dis.readByte();
					if (length == -1) {
						this.Employee_ID = null;
					} else {
						this.Employee_ID = dis.readDouble();
					}

					this.Employee_Country = readString(dis);

					this.Company = readString(dis);

					this.Department = readString(dis);

					this.Section = readString(dis);

					this.Org_Group = readString(dis);

					this.Job_Title = readString(dis);

					this.Employee_Name = readString(dis);

					length = dis.readByte();
					if (length == -1) {
						this.Employee_Gender = null;
					} else {
						this.Employee_Gender = dis.readChar();
					}

					this.Salary = readString(dis);

					this.Employee_Birth_Date = readDate(dis);

					this.Employee_Hire_Date = readDate(dis);

					this.Employee_Term_Date = readDate(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_PROJETDATAV1_Job03_Organization_Dim) {

				try {

					int length = 0;

					length = dis.readByte();
					if (length == -1) {
						this.Employee_ID = null;
					} else {
						this.Employee_ID = dis.readDouble();
					}

					this.Employee_Country = readString(dis);

					this.Company = readString(dis);

					this.Department = readString(dis);

					this.Section = readString(dis);

					this.Org_Group = readString(dis);

					this.Job_Title = readString(dis);

					this.Employee_Name = readString(dis);

					length = dis.readByte();
					if (length == -1) {
						this.Employee_Gender = null;
					} else {
						this.Employee_Gender = dis.readChar();
					}

					this.Salary = readString(dis);

					this.Employee_Birth_Date = readDate(dis);

					this.Employee_Hire_Date = readDate(dis);

					this.Employee_Term_Date = readDate(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// Double

				if (this.Employee_ID == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this.Employee_ID);
				}

				// String

				writeString(this.Employee_Country, dos);

				// String

				writeString(this.Company, dos);

				// String

				writeString(this.Department, dos);

				// String

				writeString(this.Section, dos);

				// String

				writeString(this.Org_Group, dos);

				// String

				writeString(this.Job_Title, dos);

				// String

				writeString(this.Employee_Name, dos);

				// Character

				if (this.Employee_Gender == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeChar(this.Employee_Gender);
				}

				// String

				writeString(this.Salary, dos);

				// java.util.Date

				writeDate(this.Employee_Birth_Date, dos);

				// java.util.Date

				writeDate(this.Employee_Hire_Date, dos);

				// java.util.Date

				writeDate(this.Employee_Term_Date, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// Double

				if (this.Employee_ID == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this.Employee_ID);
				}

				// String

				writeString(this.Employee_Country, dos);

				// String

				writeString(this.Company, dos);

				// String

				writeString(this.Department, dos);

				// String

				writeString(this.Section, dos);

				// String

				writeString(this.Org_Group, dos);

				// String

				writeString(this.Job_Title, dos);

				// String

				writeString(this.Employee_Name, dos);

				// Character

				if (this.Employee_Gender == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeChar(this.Employee_Gender);
				}

				// String

				writeString(this.Salary, dos);

				// java.util.Date

				writeDate(this.Employee_Birth_Date, dos);

				// java.util.Date

				writeDate(this.Employee_Hire_Date, dos);

				// java.util.Date

				writeDate(this.Employee_Term_Date, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("Employee_ID=" + String.valueOf(Employee_ID));
			sb.append(",Employee_Country=" + Employee_Country);
			sb.append(",Company=" + Company);
			sb.append(",Department=" + Department);
			sb.append(",Section=" + Section);
			sb.append(",Org_Group=" + Org_Group);
			sb.append(",Job_Title=" + Job_Title);
			sb.append(",Employee_Name=" + Employee_Name);
			sb.append(",Employee_Gender=" + String.valueOf(Employee_Gender));
			sb.append(",Salary=" + Salary);
			sb.append(",Employee_Birth_Date=" + String.valueOf(Employee_Birth_Date));
			sb.append(",Employee_Hire_Date=" + String.valueOf(Employee_Hire_Date));
			sb.append(",Employee_Term_Date=" + String.valueOf(Employee_Term_Date));
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(Output_Organization_DimStruct other) {

			int returnValue = -1;

			returnValue = checkNullsAndCompare(this.Employee_ID, other.Employee_ID);
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
		final static byte[] commonByteArrayLock_PROJETDATAV1_Job03_Organization_Dim = new byte[0];
		static byte[] commonByteArray_PROJETDATAV1_Job03_Organization_Dim = new byte[0];

		public Double EMPLOYEE_ID;

		public Double getEMPLOYEE_ID() {
			return this.EMPLOYEE_ID;
		}

		public String ORG_NAME;

		public String getORG_NAME() {
			return this.ORG_NAME;
		}

		public String COUNTRY;

		public String getCOUNTRY() {
			return this.COUNTRY;
		}

		public Double ORG_LEVEL;

		public Double getORG_LEVEL() {
			return this.ORG_LEVEL;
		}

		public java.util.Date START_DATE;

		public java.util.Date getSTART_DATE() {
			return this.START_DATE;
		}

		public java.util.Date END_DATE;

		public java.util.Date getEND_DATE() {
			return this.END_DATE;
		}

		public Double ORG_REF_ID;

		public Double getORG_REF_ID() {
			return this.ORG_REF_ID;
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_PROJETDATAV1_Job03_Organization_Dim.length) {
					if (length < 1024 && commonByteArray_PROJETDATAV1_Job03_Organization_Dim.length == 0) {
						commonByteArray_PROJETDATAV1_Job03_Organization_Dim = new byte[1024];
					} else {
						commonByteArray_PROJETDATAV1_Job03_Organization_Dim = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_PROJETDATAV1_Job03_Organization_Dim, 0, length);
				strReturn = new String(commonByteArray_PROJETDATAV1_Job03_Organization_Dim, 0, length, utf8Charset);
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
				if (length > commonByteArray_PROJETDATAV1_Job03_Organization_Dim.length) {
					if (length < 1024 && commonByteArray_PROJETDATAV1_Job03_Organization_Dim.length == 0) {
						commonByteArray_PROJETDATAV1_Job03_Organization_Dim = new byte[1024];
					} else {
						commonByteArray_PROJETDATAV1_Job03_Organization_Dim = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_PROJETDATAV1_Job03_Organization_Dim, 0, length);
				strReturn = new String(commonByteArray_PROJETDATAV1_Job03_Organization_Dim, 0, length, utf8Charset);
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

			synchronized (commonByteArrayLock_PROJETDATAV1_Job03_Organization_Dim) {

				try {

					int length = 0;

					length = dis.readByte();
					if (length == -1) {
						this.EMPLOYEE_ID = null;
					} else {
						this.EMPLOYEE_ID = dis.readDouble();
					}

					this.ORG_NAME = readString(dis);

					this.COUNTRY = readString(dis);

					length = dis.readByte();
					if (length == -1) {
						this.ORG_LEVEL = null;
					} else {
						this.ORG_LEVEL = dis.readDouble();
					}

					this.START_DATE = readDate(dis);

					this.END_DATE = readDate(dis);

					length = dis.readByte();
					if (length == -1) {
						this.ORG_REF_ID = null;
					} else {
						this.ORG_REF_ID = dis.readDouble();
					}

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_PROJETDATAV1_Job03_Organization_Dim) {

				try {

					int length = 0;

					length = dis.readByte();
					if (length == -1) {
						this.EMPLOYEE_ID = null;
					} else {
						this.EMPLOYEE_ID = dis.readDouble();
					}

					this.ORG_NAME = readString(dis);

					this.COUNTRY = readString(dis);

					length = dis.readByte();
					if (length == -1) {
						this.ORG_LEVEL = null;
					} else {
						this.ORG_LEVEL = dis.readDouble();
					}

					this.START_DATE = readDate(dis);

					this.END_DATE = readDate(dis);

					length = dis.readByte();
					if (length == -1) {
						this.ORG_REF_ID = null;
					} else {
						this.ORG_REF_ID = dis.readDouble();
					}

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// Double

				if (this.EMPLOYEE_ID == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this.EMPLOYEE_ID);
				}

				// String

				writeString(this.ORG_NAME, dos);

				// String

				writeString(this.COUNTRY, dos);

				// Double

				if (this.ORG_LEVEL == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this.ORG_LEVEL);
				}

				// java.util.Date

				writeDate(this.START_DATE, dos);

				// java.util.Date

				writeDate(this.END_DATE, dos);

				// Double

				if (this.ORG_REF_ID == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this.ORG_REF_ID);
				}

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// Double

				if (this.EMPLOYEE_ID == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this.EMPLOYEE_ID);
				}

				// String

				writeString(this.ORG_NAME, dos);

				// String

				writeString(this.COUNTRY, dos);

				// Double

				if (this.ORG_LEVEL == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this.ORG_LEVEL);
				}

				// java.util.Date

				writeDate(this.START_DATE, dos);

				// java.util.Date

				writeDate(this.END_DATE, dos);

				// Double

				if (this.ORG_REF_ID == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this.ORG_REF_ID);
				}

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("EMPLOYEE_ID=" + String.valueOf(EMPLOYEE_ID));
			sb.append(",ORG_NAME=" + ORG_NAME);
			sb.append(",COUNTRY=" + COUNTRY);
			sb.append(",ORG_LEVEL=" + String.valueOf(ORG_LEVEL));
			sb.append(",START_DATE=" + String.valueOf(START_DATE));
			sb.append(",END_DATE=" + String.valueOf(END_DATE));
			sb.append(",ORG_REF_ID=" + String.valueOf(ORG_REF_ID));
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
		final static byte[] commonByteArrayLock_PROJETDATAV1_Job03_Organization_Dim = new byte[0];
		static byte[] commonByteArray_PROJETDATAV1_Job03_Organization_Dim = new byte[0];
		protected static final int DEFAULT_HASHCODE = 1;
		protected static final int PRIME = 31;
		protected int hashCode = DEFAULT_HASHCODE;
		public boolean hashCodeDirty = true;

		public String loopKey;

		public Double EMPLOYEE_ID;

		public Double getEMPLOYEE_ID() {
			return this.EMPLOYEE_ID;
		}

		public String ORG_NAME;

		public String getORG_NAME() {
			return this.ORG_NAME;
		}

		public String COUNTRY;

		public String getCOUNTRY() {
			return this.COUNTRY;
		}

		public Double ORG_LEVEL;

		public Double getORG_LEVEL() {
			return this.ORG_LEVEL;
		}

		public java.util.Date START_DATE;

		public java.util.Date getSTART_DATE() {
			return this.START_DATE;
		}

		public java.util.Date END_DATE;

		public java.util.Date getEND_DATE() {
			return this.END_DATE;
		}

		public Double ORG_REF_ID;

		public Double getORG_REF_ID() {
			return this.ORG_REF_ID;
		}

		@Override
		public int hashCode() {
			if (this.hashCodeDirty) {
				final int prime = PRIME;
				int result = DEFAULT_HASHCODE;

				result = prime * result + ((this.EMPLOYEE_ID == null) ? 0 : this.EMPLOYEE_ID.hashCode());

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

			if (this.EMPLOYEE_ID == null) {
				if (other.EMPLOYEE_ID != null)
					return false;

			} else if (!this.EMPLOYEE_ID.equals(other.EMPLOYEE_ID))

				return false;

			return true;
		}

		public void copyDataTo(after_tDBInput_1Struct other) {

			other.EMPLOYEE_ID = this.EMPLOYEE_ID;
			other.ORG_NAME = this.ORG_NAME;
			other.COUNTRY = this.COUNTRY;
			other.ORG_LEVEL = this.ORG_LEVEL;
			other.START_DATE = this.START_DATE;
			other.END_DATE = this.END_DATE;
			other.ORG_REF_ID = this.ORG_REF_ID;

		}

		public void copyKeysDataTo(after_tDBInput_1Struct other) {

			other.EMPLOYEE_ID = this.EMPLOYEE_ID;

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_PROJETDATAV1_Job03_Organization_Dim.length) {
					if (length < 1024 && commonByteArray_PROJETDATAV1_Job03_Organization_Dim.length == 0) {
						commonByteArray_PROJETDATAV1_Job03_Organization_Dim = new byte[1024];
					} else {
						commonByteArray_PROJETDATAV1_Job03_Organization_Dim = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_PROJETDATAV1_Job03_Organization_Dim, 0, length);
				strReturn = new String(commonByteArray_PROJETDATAV1_Job03_Organization_Dim, 0, length, utf8Charset);
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
				if (length > commonByteArray_PROJETDATAV1_Job03_Organization_Dim.length) {
					if (length < 1024 && commonByteArray_PROJETDATAV1_Job03_Organization_Dim.length == 0) {
						commonByteArray_PROJETDATAV1_Job03_Organization_Dim = new byte[1024];
					} else {
						commonByteArray_PROJETDATAV1_Job03_Organization_Dim = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_PROJETDATAV1_Job03_Organization_Dim, 0, length);
				strReturn = new String(commonByteArray_PROJETDATAV1_Job03_Organization_Dim, 0, length, utf8Charset);
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

			synchronized (commonByteArrayLock_PROJETDATAV1_Job03_Organization_Dim) {

				try {

					int length = 0;

					length = dis.readByte();
					if (length == -1) {
						this.EMPLOYEE_ID = null;
					} else {
						this.EMPLOYEE_ID = dis.readDouble();
					}

					this.ORG_NAME = readString(dis);

					this.COUNTRY = readString(dis);

					length = dis.readByte();
					if (length == -1) {
						this.ORG_LEVEL = null;
					} else {
						this.ORG_LEVEL = dis.readDouble();
					}

					this.START_DATE = readDate(dis);

					this.END_DATE = readDate(dis);

					length = dis.readByte();
					if (length == -1) {
						this.ORG_REF_ID = null;
					} else {
						this.ORG_REF_ID = dis.readDouble();
					}

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_PROJETDATAV1_Job03_Organization_Dim) {

				try {

					int length = 0;

					length = dis.readByte();
					if (length == -1) {
						this.EMPLOYEE_ID = null;
					} else {
						this.EMPLOYEE_ID = dis.readDouble();
					}

					this.ORG_NAME = readString(dis);

					this.COUNTRY = readString(dis);

					length = dis.readByte();
					if (length == -1) {
						this.ORG_LEVEL = null;
					} else {
						this.ORG_LEVEL = dis.readDouble();
					}

					this.START_DATE = readDate(dis);

					this.END_DATE = readDate(dis);

					length = dis.readByte();
					if (length == -1) {
						this.ORG_REF_ID = null;
					} else {
						this.ORG_REF_ID = dis.readDouble();
					}

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// Double

				if (this.EMPLOYEE_ID == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this.EMPLOYEE_ID);
				}

				// String

				writeString(this.ORG_NAME, dos);

				// String

				writeString(this.COUNTRY, dos);

				// Double

				if (this.ORG_LEVEL == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this.ORG_LEVEL);
				}

				// java.util.Date

				writeDate(this.START_DATE, dos);

				// java.util.Date

				writeDate(this.END_DATE, dos);

				// Double

				if (this.ORG_REF_ID == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this.ORG_REF_ID);
				}

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// Double

				if (this.EMPLOYEE_ID == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this.EMPLOYEE_ID);
				}

				// String

				writeString(this.ORG_NAME, dos);

				// String

				writeString(this.COUNTRY, dos);

				// Double

				if (this.ORG_LEVEL == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this.ORG_LEVEL);
				}

				// java.util.Date

				writeDate(this.START_DATE, dos);

				// java.util.Date

				writeDate(this.END_DATE, dos);

				// Double

				if (this.ORG_REF_ID == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this.ORG_REF_ID);
				}

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("EMPLOYEE_ID=" + String.valueOf(EMPLOYEE_ID));
			sb.append(",ORG_NAME=" + ORG_NAME);
			sb.append(",COUNTRY=" + COUNTRY);
			sb.append(",ORG_LEVEL=" + String.valueOf(ORG_LEVEL));
			sb.append(",START_DATE=" + String.valueOf(START_DATE));
			sb.append(",END_DATE=" + String.valueOf(END_DATE));
			sb.append(",ORG_REF_ID=" + String.valueOf(ORG_REF_ID));
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(after_tDBInput_1Struct other) {

			int returnValue = -1;

			returnValue = checkNullsAndCompare(this.EMPLOYEE_ID, other.EMPLOYEE_ID);
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
				tFileInputExcel_1Process(globalMap);

				row1Struct row1 = new row1Struct();
				Output_Organization_DimStruct Output_Organization_Dim = new Output_Organization_DimStruct();

				/**
				 * [tDBOutput_1 begin ] start
				 */

				ok_Hash.put("tDBOutput_1", false);
				start_Hash.put("tDBOutput_1", System.currentTimeMillis());

				currentComponent = "tDBOutput_1";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "Output_Organization_Dim");
				}

				int tos_count_tDBOutput_1 = 0;

				int updateKeyCount_tDBOutput_1 = 1;
				if (updateKeyCount_tDBOutput_1 < 1) {
					throw new RuntimeException("For update, Schema must have a key");
				} else if (updateKeyCount_tDBOutput_1 == 13 && true) {
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
						"enc:routine.encryption.key.v1:/HSPllIvklDvAMLhUa2YfU7CjxbCnRuVqmEtwJKNwKz0lQ9n/boo6m8=");

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
					tableName_tDBOutput_1 = ("Organization_Dim");
				} else {
					tableName_tDBOutput_1 = dbschema_tDBOutput_1 + "." + ("Organization_Dim");
				}
				try (java.sql.Statement stmtCreate_tDBOutput_1 = conn_tDBOutput_1.createStatement()) {
					stmtCreate_tDBOutput_1.execute("CREATE TABLE " + tableName_tDBOutput_1
							+ "(Employee_ID DOUBLE(64,0)  ,Employee_Country VARCHAR(2)  ,Company VARCHAR(40)  ,Department VARCHAR(40)  ,Section VARCHAR(40)  ,Org_Group VARCHAR(40)  ,Job_Title VARCHAR2(23)  ,Employee_Name VARCHAR(40)  ,Employee_Gender CHAR(6)  ,Salary VARCHAR2(6)  ,Employee_Birth_Date DATE ,Employee_Hire_Date DATE ,Employee_Term_Date DATE ,primary key(Employee_ID))");
				}
				java.sql.PreparedStatement pstmt_tDBOutput_1 = conn_tDBOutput_1
						.prepareStatement("SELECT COUNT(1) FROM " + tableName_tDBOutput_1 + " WHERE Employee_ID = ?");
				resourceMap.put("pstmt_tDBOutput_1", pstmt_tDBOutput_1);
				String insert_tDBOutput_1 = "INSERT INTO " + tableName_tDBOutput_1
						+ " (Employee_ID,Employee_Country,Company,Department,Section,Org_Group,Job_Title,Employee_Name,Employee_Gender,Salary,Employee_Birth_Date,Employee_Hire_Date,Employee_Term_Date) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
				java.sql.PreparedStatement pstmtInsert_tDBOutput_1 = conn_tDBOutput_1
						.prepareStatement(insert_tDBOutput_1);
				resourceMap.put("pstmtInsert_tDBOutput_1", pstmtInsert_tDBOutput_1);
				String update_tDBOutput_1 = "UPDATE " + tableName_tDBOutput_1
						+ " SET Employee_Country = ?,Company = ?,Department = ?,Section = ?,Org_Group = ?,Job_Title = ?,Employee_Name = ?,Employee_Gender = ?,Salary = ?,Employee_Birth_Date = ?,Employee_Hire_Date = ?,Employee_Term_Date = ? WHERE Employee_ID = ?";
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

				row2Struct row2HashKey = new row2Struct();
				row2Struct row2Default = new row2Struct();

				org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row3Struct> tHash_Lookup_row3 = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row3Struct>) ((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row3Struct>) globalMap
						.get("tHash_Lookup_row3"));

				row3Struct row3HashKey = new row3Struct();
				row3Struct row3Default = new row3Struct();

				org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row4Struct> tHash_Lookup_row4 = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row4Struct>) ((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row4Struct>) globalMap
						.get("tHash_Lookup_row4"));

				row4Struct row4HashKey = new row4Struct();
				row4Struct row4Default = new row4Struct();

				org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row5Struct> tHash_Lookup_row5 = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row5Struct>) ((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row5Struct>) globalMap
						.get("tHash_Lookup_row5"));

				row5Struct row5HashKey = new row5Struct();
				row5Struct row5Default = new row5Struct();

				org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row6Struct> tHash_Lookup_row6 = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row6Struct>) ((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row6Struct>) globalMap
						.get("tHash_Lookup_row6"));

				row6Struct row6HashKey = new row6Struct();
				row6Struct row6Default = new row6Struct();
// ###############################        

// ###############################
// # Vars initialization
				class Var__tMap_1__Struct {
				}
				Var__tMap_1__Struct Var__tMap_1 = new Var__tMap_1__Struct();
// ###############################

// ###############################
// # Outputs initialization
				Output_Organization_DimStruct Output_Organization_Dim_tmp = new Output_Organization_DimStruct();
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

				String dbquery_tDBInput_1 = "SELECT \n  ORGANIZATION.EMPLOYEE_ID, \n  ORGANIZATION.ORG_NAME, \n  ORGANIZATION.COUNTRY, \n  ORGANIZATION.ORG_LEVEL, \n  OR"
						+ "GANIZATION.START_DATE, \n  ORGANIZATION.END_DATE, \n  ORGANIZATION.ORG_REF_ID\nFROM ORGANIZATION";

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
							row1.EMPLOYEE_ID = null;
						} else {

							row1.EMPLOYEE_ID = rs_tDBInput_1.getDouble(1);
							if (rs_tDBInput_1.wasNull()) {
								row1.EMPLOYEE_ID = null;
							}
						}
						if (colQtyInRs_tDBInput_1 < 2) {
							row1.ORG_NAME = null;
						} else {

							row1.ORG_NAME = routines.system.JDBCUtil.getString(rs_tDBInput_1, 2, false);
						}
						if (colQtyInRs_tDBInput_1 < 3) {
							row1.COUNTRY = null;
						} else {

							row1.COUNTRY = routines.system.JDBCUtil.getString(rs_tDBInput_1, 3, false);
						}
						if (colQtyInRs_tDBInput_1 < 4) {
							row1.ORG_LEVEL = null;
						} else {

							row1.ORG_LEVEL = rs_tDBInput_1.getDouble(4);
							if (rs_tDBInput_1.wasNull()) {
								row1.ORG_LEVEL = null;
							}
						}
						if (colQtyInRs_tDBInput_1 < 5) {
							row1.START_DATE = null;
						} else {

							java.sql.Timestamp timestamp_tDBInput_1 = rs_tDBInput_1.getTimestamp(5);
							if (timestamp_tDBInput_1 != null) {
								row1.START_DATE = new java.util.Date(timestamp_tDBInput_1.getTime());
							} else {
								row1.START_DATE = null;
							}
						}
						if (colQtyInRs_tDBInput_1 < 6) {
							row1.END_DATE = null;
						} else {

							java.sql.Timestamp timestamp_tDBInput_1 = rs_tDBInput_1.getTimestamp(6);
							if (timestamp_tDBInput_1 != null) {
								row1.END_DATE = new java.util.Date(timestamp_tDBInput_1.getTime());
							} else {
								row1.END_DATE = null;
							}
						}
						if (colQtyInRs_tDBInput_1 < 7) {
							row1.ORG_REF_ID = null;
						} else {

							row1.ORG_REF_ID = rs_tDBInput_1.getDouble(7);
							if (rs_tDBInput_1.wasNull()) {
								row1.ORG_REF_ID = null;
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

							hasCasePrimitiveKeyWithNull_tMap_1 = false;

							row2HashKey.EMPLOYEE_ID = row1.ORG_REF_ID;

							row2HashKey.hashCodeDirty = true;

							tHash_Lookup_row2.lookup(row2HashKey);

							if (!tHash_Lookup_row2.hasNext()) { // G_TM_M_090

								rejectedInnerJoin_tMap_1 = true;

							} // G_TM_M_090

						} // G_TM_M_020

						if (tHash_Lookup_row2 != null && tHash_Lookup_row2.getCount(row2HashKey) > 1) { // G 071

							// System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'row2'
							// and it contains more one result from keys : row2.EMPLOYEE_ID = '" +
							// row2HashKey.EMPLOYEE_ID + "'");
						} // G 071

						row2Struct row2 = null;

						row2Struct fromLookup_row2 = null;
						row2 = row2Default;

						if (tHash_Lookup_row2 != null && tHash_Lookup_row2.hasNext()) { // G 099

							fromLookup_row2 = tHash_Lookup_row2.next();

						} // G 099

						if (fromLookup_row2 != null) {
							row2 = fromLookup_row2;
						}

						///////////////////////////////////////////////
						// Starting Lookup Table "row3"
						///////////////////////////////////////////////

						boolean forceLooprow3 = false;

						row3Struct row3ObjectFromLookup = null;

						if (!rejectedInnerJoin_tMap_1) { // G_TM_M_020

							hasCasePrimitiveKeyWithNull_tMap_1 = false;

							row3HashKey.EMPLOYEE_ID = row2.ORG_REF_ID;

							row3HashKey.hashCodeDirty = true;

							tHash_Lookup_row3.lookup(row3HashKey);

							if (!tHash_Lookup_row3.hasNext()) { // G_TM_M_090

								rejectedInnerJoin_tMap_1 = true;

							} // G_TM_M_090

						} // G_TM_M_020

						if (tHash_Lookup_row3 != null && tHash_Lookup_row3.getCount(row3HashKey) > 1) { // G 071

							// System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'row3'
							// and it contains more one result from keys : row3.EMPLOYEE_ID = '" +
							// row3HashKey.EMPLOYEE_ID + "'");
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

							hasCasePrimitiveKeyWithNull_tMap_1 = false;

							row4HashKey.EMPLOYEE_ID = row3.ORG_REF_ID;

							row4HashKey.hashCodeDirty = true;

							tHash_Lookup_row4.lookup(row4HashKey);

							if (!tHash_Lookup_row4.hasNext()) { // G_TM_M_090

								rejectedInnerJoin_tMap_1 = true;

							} // G_TM_M_090

						} // G_TM_M_020

						if (tHash_Lookup_row4 != null && tHash_Lookup_row4.getCount(row4HashKey) > 1) { // G 071

							// System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'row4'
							// and it contains more one result from keys : row4.EMPLOYEE_ID = '" +
							// row4HashKey.EMPLOYEE_ID + "'");
						} // G 071

						row4Struct row4 = null;

						row4Struct fromLookup_row4 = null;
						row4 = row4Default;

						if (tHash_Lookup_row4 != null && tHash_Lookup_row4.hasNext()) { // G 099

							fromLookup_row4 = tHash_Lookup_row4.next();

						} // G 099

						if (fromLookup_row4 != null) {
							row4 = fromLookup_row4;
						}

						///////////////////////////////////////////////
						// Starting Lookup Table "row5"
						///////////////////////////////////////////////

						boolean forceLooprow5 = false;

						row5Struct row5ObjectFromLookup = null;

						if (!rejectedInnerJoin_tMap_1) { // G_TM_M_020

							hasCasePrimitiveKeyWithNull_tMap_1 = false;

							row5HashKey.EMPLOYEE_ID = row4.ORG_REF_ID;

							row5HashKey.hashCodeDirty = true;

							tHash_Lookup_row5.lookup(row5HashKey);

							if (!tHash_Lookup_row5.hasNext()) { // G_TM_M_090

								rejectedInnerJoin_tMap_1 = true;

							} // G_TM_M_090

						} // G_TM_M_020

						if (tHash_Lookup_row5 != null && tHash_Lookup_row5.getCount(row5HashKey) > 1) { // G 071

							// System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'row5'
							// and it contains more one result from keys : row5.EMPLOYEE_ID = '" +
							// row5HashKey.EMPLOYEE_ID + "'");
						} // G 071

						row5Struct row5 = null;

						row5Struct fromLookup_row5 = null;
						row5 = row5Default;

						if (tHash_Lookup_row5 != null && tHash_Lookup_row5.hasNext()) { // G 099

							fromLookup_row5 = tHash_Lookup_row5.next();

						} // G 099

						if (fromLookup_row5 != null) {
							row5 = fromLookup_row5;
						}

						///////////////////////////////////////////////
						// Starting Lookup Table "row6"
						///////////////////////////////////////////////

						boolean forceLooprow6 = false;

						row6Struct row6ObjectFromLookup = null;

						if (!rejectedInnerJoin_tMap_1) { // G_TM_M_020

							hasCasePrimitiveKeyWithNull_tMap_1 = false;

							row6HashKey.Employee_ID = row1.EMPLOYEE_ID;

							row6HashKey.hashCodeDirty = true;

							tHash_Lookup_row6.lookup(row6HashKey);

						} // G_TM_M_020

						if (tHash_Lookup_row6 != null && tHash_Lookup_row6.getCount(row6HashKey) > 1) { // G 071

							// System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'row6'
							// and it contains more one result from keys : row6.Employee_ID = '" +
							// row6HashKey.Employee_ID + "'");
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

						// ###############################
						{ // start of Var scope

							// ###############################
							// # Vars tables

							Var__tMap_1__Struct Var = Var__tMap_1;// ###############################
							// ###############################
							// # Output tables

							Output_Organization_Dim = null;

							if (!rejectedInnerJoin_tMap_1) {

// # Output table : 'Output_Organization_Dim'
								Output_Organization_Dim_tmp.Employee_ID = row1.EMPLOYEE_ID;
								Output_Organization_Dim_tmp.Employee_Country = row1.COUNTRY;
								Output_Organization_Dim_tmp.Company = row5.ORG_NAME;
								Output_Organization_Dim_tmp.Department = row4.ORG_NAME;
								Output_Organization_Dim_tmp.Section = row3.ORG_NAME;
								Output_Organization_Dim_tmp.Org_Group = row2.ORG_NAME;
								Output_Organization_Dim_tmp.Job_Title = row6.Job_Title;
								Output_Organization_Dim_tmp.Employee_Name = row1.ORG_NAME;
								Output_Organization_Dim_tmp.Employee_Gender = row6.Gender;
								Output_Organization_Dim_tmp.Salary = row6.Salary;
								Output_Organization_Dim_tmp.Employee_Birth_Date = row6.Birth_Date;
								Output_Organization_Dim_tmp.Employee_Hire_Date = row6.Emp_Hire_Date;
								Output_Organization_Dim_tmp.Employee_Term_Date = row6.Emp_Term_Date;
								Output_Organization_Dim = Output_Organization_Dim_tmp;
							} // closing inner join bracket (2)
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
// Start of branch "Output_Organization_Dim"
						if (Output_Organization_Dim != null) {

							/**
							 * [tDBOutput_1 main ] start
							 */

							currentComponent = "tDBOutput_1";

							if (execStat) {
								runStat.updateStatOnConnection(iterateId, 1, 1

										, "Output_Organization_Dim"

								);
							}

							whetherReject_tDBOutput_1 = false;
							if (Output_Organization_Dim.Employee_ID == null) {
								pstmt_tDBOutput_1.setNull(1, java.sql.Types.DOUBLE);
							} else {
								pstmt_tDBOutput_1.setDouble(1, Output_Organization_Dim.Employee_ID);
							}

							int checkCount_tDBOutput_1 = -1;
							try (java.sql.ResultSet rs_tDBOutput_1 = pstmt_tDBOutput_1.executeQuery()) {
								while (rs_tDBOutput_1.next()) {
									checkCount_tDBOutput_1 = rs_tDBOutput_1.getInt(1);
								}
							}
							if (checkCount_tDBOutput_1 > 0) {
								if (Output_Organization_Dim.Employee_Country == null) {
									pstmtUpdate_tDBOutput_1.setNull(1, java.sql.Types.VARCHAR);
								} else {
									pstmtUpdate_tDBOutput_1.setString(1, Output_Organization_Dim.Employee_Country);
								}

								if (Output_Organization_Dim.Company == null) {
									pstmtUpdate_tDBOutput_1.setNull(2, java.sql.Types.VARCHAR);
								} else {
									pstmtUpdate_tDBOutput_1.setString(2, Output_Organization_Dim.Company);
								}

								if (Output_Organization_Dim.Department == null) {
									pstmtUpdate_tDBOutput_1.setNull(3, java.sql.Types.VARCHAR);
								} else {
									pstmtUpdate_tDBOutput_1.setString(3, Output_Organization_Dim.Department);
								}

								if (Output_Organization_Dim.Section == null) {
									pstmtUpdate_tDBOutput_1.setNull(4, java.sql.Types.VARCHAR);
								} else {
									pstmtUpdate_tDBOutput_1.setString(4, Output_Organization_Dim.Section);
								}

								if (Output_Organization_Dim.Org_Group == null) {
									pstmtUpdate_tDBOutput_1.setNull(5, java.sql.Types.VARCHAR);
								} else {
									pstmtUpdate_tDBOutput_1.setString(5, Output_Organization_Dim.Org_Group);
								}

								if (Output_Organization_Dim.Job_Title == null) {
									pstmtUpdate_tDBOutput_1.setNull(6, java.sql.Types.VARCHAR);
								} else {
									pstmtUpdate_tDBOutput_1.setString(6, Output_Organization_Dim.Job_Title);
								}

								if (Output_Organization_Dim.Employee_Name == null) {
									pstmtUpdate_tDBOutput_1.setNull(7, java.sql.Types.VARCHAR);
								} else {
									pstmtUpdate_tDBOutput_1.setString(7, Output_Organization_Dim.Employee_Name);
								}

								if (Output_Organization_Dim.Employee_Gender == null) {
									pstmtUpdate_tDBOutput_1.setNull(8, java.sql.Types.CHAR);
								} else {
									if (Output_Organization_Dim.Employee_Gender == null) {
										pstmtUpdate_tDBOutput_1.setNull(8, java.sql.Types.CHAR);
									} else if (Output_Organization_Dim.Employee_Gender == ' ') {
										pstmtUpdate_tDBOutput_1.setString(8, "");
									} else {
										pstmtUpdate_tDBOutput_1.setString(8,
												String.valueOf(Output_Organization_Dim.Employee_Gender));
									}
								}

								if (Output_Organization_Dim.Salary == null) {
									pstmtUpdate_tDBOutput_1.setNull(9, java.sql.Types.VARCHAR);
								} else {
									pstmtUpdate_tDBOutput_1.setString(9, Output_Organization_Dim.Salary);
								}

								if (Output_Organization_Dim.Employee_Birth_Date != null) {
									pstmtUpdate_tDBOutput_1.setTimestamp(10, new java.sql.Timestamp(
											Output_Organization_Dim.Employee_Birth_Date.getTime()));
								} else {
									pstmtUpdate_tDBOutput_1.setNull(10, java.sql.Types.DATE);
								}

								if (Output_Organization_Dim.Employee_Hire_Date != null) {
									pstmtUpdate_tDBOutput_1.setTimestamp(11, new java.sql.Timestamp(
											Output_Organization_Dim.Employee_Hire_Date.getTime()));
								} else {
									pstmtUpdate_tDBOutput_1.setNull(11, java.sql.Types.DATE);
								}

								if (Output_Organization_Dim.Employee_Term_Date != null) {
									pstmtUpdate_tDBOutput_1.setTimestamp(12, new java.sql.Timestamp(
											Output_Organization_Dim.Employee_Term_Date.getTime()));
								} else {
									pstmtUpdate_tDBOutput_1.setNull(12, java.sql.Types.DATE);
								}

								if (Output_Organization_Dim.Employee_ID == null) {
									pstmtUpdate_tDBOutput_1.setNull(13 + count_tDBOutput_1, java.sql.Types.DOUBLE);
								} else {
									pstmtUpdate_tDBOutput_1.setDouble(13 + count_tDBOutput_1,
											Output_Organization_Dim.Employee_ID);
								}

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
								if (Output_Organization_Dim.Employee_ID == null) {
									pstmtInsert_tDBOutput_1.setNull(1, java.sql.Types.DOUBLE);
								} else {
									pstmtInsert_tDBOutput_1.setDouble(1, Output_Organization_Dim.Employee_ID);
								}

								if (Output_Organization_Dim.Employee_Country == null) {
									pstmtInsert_tDBOutput_1.setNull(2, java.sql.Types.VARCHAR);
								} else {
									pstmtInsert_tDBOutput_1.setString(2, Output_Organization_Dim.Employee_Country);
								}

								if (Output_Organization_Dim.Company == null) {
									pstmtInsert_tDBOutput_1.setNull(3, java.sql.Types.VARCHAR);
								} else {
									pstmtInsert_tDBOutput_1.setString(3, Output_Organization_Dim.Company);
								}

								if (Output_Organization_Dim.Department == null) {
									pstmtInsert_tDBOutput_1.setNull(4, java.sql.Types.VARCHAR);
								} else {
									pstmtInsert_tDBOutput_1.setString(4, Output_Organization_Dim.Department);
								}

								if (Output_Organization_Dim.Section == null) {
									pstmtInsert_tDBOutput_1.setNull(5, java.sql.Types.VARCHAR);
								} else {
									pstmtInsert_tDBOutput_1.setString(5, Output_Organization_Dim.Section);
								}

								if (Output_Organization_Dim.Org_Group == null) {
									pstmtInsert_tDBOutput_1.setNull(6, java.sql.Types.VARCHAR);
								} else {
									pstmtInsert_tDBOutput_1.setString(6, Output_Organization_Dim.Org_Group);
								}

								if (Output_Organization_Dim.Job_Title == null) {
									pstmtInsert_tDBOutput_1.setNull(7, java.sql.Types.VARCHAR);
								} else {
									pstmtInsert_tDBOutput_1.setString(7, Output_Organization_Dim.Job_Title);
								}

								if (Output_Organization_Dim.Employee_Name == null) {
									pstmtInsert_tDBOutput_1.setNull(8, java.sql.Types.VARCHAR);
								} else {
									pstmtInsert_tDBOutput_1.setString(8, Output_Organization_Dim.Employee_Name);
								}

								if (Output_Organization_Dim.Employee_Gender == null) {
									pstmtInsert_tDBOutput_1.setNull(9, java.sql.Types.CHAR);
								} else {
									if (Output_Organization_Dim.Employee_Gender == null) {
										pstmtInsert_tDBOutput_1.setNull(9, java.sql.Types.CHAR);
									} else if (Output_Organization_Dim.Employee_Gender == ' ') {
										pstmtInsert_tDBOutput_1.setString(9, "");
									} else {
										pstmtInsert_tDBOutput_1.setString(9,
												String.valueOf(Output_Organization_Dim.Employee_Gender));
									}
								}

								if (Output_Organization_Dim.Salary == null) {
									pstmtInsert_tDBOutput_1.setNull(10, java.sql.Types.VARCHAR);
								} else {
									pstmtInsert_tDBOutput_1.setString(10, Output_Organization_Dim.Salary);
								}

								if (Output_Organization_Dim.Employee_Birth_Date != null) {
									pstmtInsert_tDBOutput_1.setTimestamp(11, new java.sql.Timestamp(
											Output_Organization_Dim.Employee_Birth_Date.getTime()));
								} else {
									pstmtInsert_tDBOutput_1.setNull(11, java.sql.Types.DATE);
								}

								if (Output_Organization_Dim.Employee_Hire_Date != null) {
									pstmtInsert_tDBOutput_1.setTimestamp(12, new java.sql.Timestamp(
											Output_Organization_Dim.Employee_Hire_Date.getTime()));
								} else {
									pstmtInsert_tDBOutput_1.setNull(12, java.sql.Types.DATE);
								}

								if (Output_Organization_Dim.Employee_Term_Date != null) {
									pstmtInsert_tDBOutput_1.setTimestamp(13, new java.sql.Timestamp(
											Output_Organization_Dim.Employee_Term_Date.getTime()));
								} else {
									pstmtInsert_tDBOutput_1.setNull(13, java.sql.Types.DATE);
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

						} // End of branch "Output_Organization_Dim"

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

				if (tHash_Lookup_row5 != null) {
					tHash_Lookup_row5.endGet();
				}
				globalMap.remove("tHash_Lookup_row5");

				if (tHash_Lookup_row6 != null) {
					tHash_Lookup_row6.endGet();
				}
				globalMap.remove("tHash_Lookup_row6");

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
					runStat.updateStat(resourceMap, iterateId, 2, 0, "Output_Organization_Dim");
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
			globalMap.remove("tHash_Lookup_row5");

			// free memory for "tMap_1"
			globalMap.remove("tHash_Lookup_row6");

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

	public static class row2Struct implements routines.system.IPersistableComparableLookupRow<row2Struct> {
		final static byte[] commonByteArrayLock_PROJETDATAV1_Job03_Organization_Dim = new byte[0];
		static byte[] commonByteArray_PROJETDATAV1_Job03_Organization_Dim = new byte[0];
		protected static final int DEFAULT_HASHCODE = 1;
		protected static final int PRIME = 31;
		protected int hashCode = DEFAULT_HASHCODE;
		public boolean hashCodeDirty = true;

		public String loopKey;

		public Double EMPLOYEE_ID;

		public Double getEMPLOYEE_ID() {
			return this.EMPLOYEE_ID;
		}

		public String ORG_NAME;

		public String getORG_NAME() {
			return this.ORG_NAME;
		}

		public String COUNTRY;

		public String getCOUNTRY() {
			return this.COUNTRY;
		}

		public Double ORG_LEVEL;

		public Double getORG_LEVEL() {
			return this.ORG_LEVEL;
		}

		public java.util.Date START_DATE;

		public java.util.Date getSTART_DATE() {
			return this.START_DATE;
		}

		public java.util.Date END_DATE;

		public java.util.Date getEND_DATE() {
			return this.END_DATE;
		}

		public Double ORG_REF_ID;

		public Double getORG_REF_ID() {
			return this.ORG_REF_ID;
		}

		@Override
		public int hashCode() {
			if (this.hashCodeDirty) {
				final int prime = PRIME;
				int result = DEFAULT_HASHCODE;

				result = prime * result + ((this.EMPLOYEE_ID == null) ? 0 : this.EMPLOYEE_ID.hashCode());

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
			final row2Struct other = (row2Struct) obj;

			if (this.EMPLOYEE_ID == null) {
				if (other.EMPLOYEE_ID != null)
					return false;

			} else if (!this.EMPLOYEE_ID.equals(other.EMPLOYEE_ID))

				return false;

			return true;
		}

		public void copyDataTo(row2Struct other) {

			other.EMPLOYEE_ID = this.EMPLOYEE_ID;
			other.ORG_NAME = this.ORG_NAME;
			other.COUNTRY = this.COUNTRY;
			other.ORG_LEVEL = this.ORG_LEVEL;
			other.START_DATE = this.START_DATE;
			other.END_DATE = this.END_DATE;
			other.ORG_REF_ID = this.ORG_REF_ID;

		}

		public void copyKeysDataTo(row2Struct other) {

			other.EMPLOYEE_ID = this.EMPLOYEE_ID;

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

		private java.util.Date readDate(DataInputStream dis, ObjectInputStream ois) throws IOException {
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

		private java.util.Date readDate(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller)
				throws IOException {
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

		private void writeDate(java.util.Date date1, DataOutputStream dos, ObjectOutputStream oos) throws IOException {
			if (date1 == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeLong(date1.getTime());
			}
		}

		private void writeDate(java.util.Date date1, DataOutputStream dos, org.jboss.marshalling.Marshaller marshaller)
				throws IOException {
			if (date1 == null) {
				marshaller.writeByte(-1);
			} else {
				marshaller.writeByte(0);
				marshaller.writeLong(date1.getTime());
			}
		}

		public void readKeysData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_PROJETDATAV1_Job03_Organization_Dim) {

				try {

					int length = 0;

					length = dis.readByte();
					if (length == -1) {
						this.EMPLOYEE_ID = null;
					} else {
						this.EMPLOYEE_ID = dis.readDouble();
					}

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_PROJETDATAV1_Job03_Organization_Dim) {

				try {

					int length = 0;

					length = dis.readByte();
					if (length == -1) {
						this.EMPLOYEE_ID = null;
					} else {
						this.EMPLOYEE_ID = dis.readDouble();
					}

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeKeysData(ObjectOutputStream dos) {
			try {

				// Double

				if (this.EMPLOYEE_ID == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this.EMPLOYEE_ID);
				}

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
			try {

				// Double

				if (this.EMPLOYEE_ID == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this.EMPLOYEE_ID);
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

				this.ORG_NAME = readString(dis, ois);

				this.COUNTRY = readString(dis, ois);

				length = dis.readByte();
				if (length == -1) {
					this.ORG_LEVEL = null;
				} else {
					this.ORG_LEVEL = dis.readDouble();
				}

				this.START_DATE = readDate(dis, ois);

				this.END_DATE = readDate(dis, ois);

				length = dis.readByte();
				if (length == -1) {
					this.ORG_REF_ID = null;
				} else {
					this.ORG_REF_ID = dis.readDouble();
				}

			} catch (IOException e) {
				throw new RuntimeException(e);

			}

		}

		public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
			try {
				int length = 0;

				this.ORG_NAME = readString(dis, objectIn);

				this.COUNTRY = readString(dis, objectIn);

				length = objectIn.readByte();
				if (length == -1) {
					this.ORG_LEVEL = null;
				} else {
					this.ORG_LEVEL = objectIn.readDouble();
				}

				this.START_DATE = readDate(dis, objectIn);

				this.END_DATE = readDate(dis, objectIn);

				length = objectIn.readByte();
				if (length == -1) {
					this.ORG_REF_ID = null;
				} else {
					this.ORG_REF_ID = objectIn.readDouble();
				}

			} catch (IOException e) {
				throw new RuntimeException(e);

			}

		}

		/**
		 * Return a byte array which represents Values data.
		 */
		public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
			try {

				writeString(this.ORG_NAME, dos, oos);

				writeString(this.COUNTRY, dos, oos);

				if (this.ORG_LEVEL == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this.ORG_LEVEL);
				}

				writeDate(this.START_DATE, dos, oos);

				writeDate(this.END_DATE, dos, oos);

				if (this.ORG_REF_ID == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this.ORG_REF_ID);
				}

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut) {
			try {

				writeString(this.ORG_NAME, dos, objectOut);

				writeString(this.COUNTRY, dos, objectOut);

				if (this.ORG_LEVEL == null) {
					objectOut.writeByte(-1);
				} else {
					objectOut.writeByte(0);
					objectOut.writeDouble(this.ORG_LEVEL);
				}

				writeDate(this.START_DATE, dos, objectOut);

				writeDate(this.END_DATE, dos, objectOut);

				if (this.ORG_REF_ID == null) {
					objectOut.writeByte(-1);
				} else {
					objectOut.writeByte(0);
					objectOut.writeDouble(this.ORG_REF_ID);
				}

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
			sb.append("EMPLOYEE_ID=" + String.valueOf(EMPLOYEE_ID));
			sb.append(",ORG_NAME=" + ORG_NAME);
			sb.append(",COUNTRY=" + COUNTRY);
			sb.append(",ORG_LEVEL=" + String.valueOf(ORG_LEVEL));
			sb.append(",START_DATE=" + String.valueOf(START_DATE));
			sb.append(",END_DATE=" + String.valueOf(END_DATE));
			sb.append(",ORG_REF_ID=" + String.valueOf(ORG_REF_ID));
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row2Struct other) {

			int returnValue = -1;

			returnValue = checkNullsAndCompare(this.EMPLOYEE_ID, other.EMPLOYEE_ID);
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
				// linked node: tMap_1 - inputs:(row1,row2,row3,row4,row5,row6)
				// outputs:(Output_Organization_Dim)

				org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_row2 = org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.UNIQUE_MATCH;

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

				String dbquery_tDBInput_2 = "SELECT \n  ORGANIZATION.EMPLOYEE_ID, \n  ORGANIZATION.ORG_NAME, \n  ORGANIZATION.COUNTRY, \n  ORGANIZATION.ORG_LEVEL, \n  OR"
						+ "GANIZATION.START_DATE, \n  ORGANIZATION.END_DATE, \n  ORGANIZATION.ORG_REF_ID\nFROM ORGANIZATION";

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
							row2.EMPLOYEE_ID = null;
						} else {

							row2.EMPLOYEE_ID = rs_tDBInput_2.getDouble(1);
							if (rs_tDBInput_2.wasNull()) {
								row2.EMPLOYEE_ID = null;
							}
						}
						if (colQtyInRs_tDBInput_2 < 2) {
							row2.ORG_NAME = null;
						} else {

							row2.ORG_NAME = routines.system.JDBCUtil.getString(rs_tDBInput_2, 2, false);
						}
						if (colQtyInRs_tDBInput_2 < 3) {
							row2.COUNTRY = null;
						} else {

							row2.COUNTRY = routines.system.JDBCUtil.getString(rs_tDBInput_2, 3, false);
						}
						if (colQtyInRs_tDBInput_2 < 4) {
							row2.ORG_LEVEL = null;
						} else {

							row2.ORG_LEVEL = rs_tDBInput_2.getDouble(4);
							if (rs_tDBInput_2.wasNull()) {
								row2.ORG_LEVEL = null;
							}
						}
						if (colQtyInRs_tDBInput_2 < 5) {
							row2.START_DATE = null;
						} else {

							java.sql.Timestamp timestamp_tDBInput_2 = rs_tDBInput_2.getTimestamp(5);
							if (timestamp_tDBInput_2 != null) {
								row2.START_DATE = new java.util.Date(timestamp_tDBInput_2.getTime());
							} else {
								row2.START_DATE = null;
							}
						}
						if (colQtyInRs_tDBInput_2 < 6) {
							row2.END_DATE = null;
						} else {

							java.sql.Timestamp timestamp_tDBInput_2 = rs_tDBInput_2.getTimestamp(6);
							if (timestamp_tDBInput_2 != null) {
								row2.END_DATE = new java.util.Date(timestamp_tDBInput_2.getTime());
							} else {
								row2.END_DATE = null;
							}
						}
						if (colQtyInRs_tDBInput_2 < 7) {
							row2.ORG_REF_ID = null;
						} else {

							row2.ORG_REF_ID = rs_tDBInput_2.getDouble(7);
							if (rs_tDBInput_2.wasNull()) {
								row2.ORG_REF_ID = null;
							}
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

						row2_HashRow.EMPLOYEE_ID = row2.EMPLOYEE_ID;

						row2_HashRow.ORG_NAME = row2.ORG_NAME;

						row2_HashRow.COUNTRY = row2.COUNTRY;

						row2_HashRow.ORG_LEVEL = row2.ORG_LEVEL;

						row2_HashRow.START_DATE = row2.START_DATE;

						row2_HashRow.END_DATE = row2.END_DATE;

						row2_HashRow.ORG_REF_ID = row2.ORG_REF_ID;

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
		final static byte[] commonByteArrayLock_PROJETDATAV1_Job03_Organization_Dim = new byte[0];
		static byte[] commonByteArray_PROJETDATAV1_Job03_Organization_Dim = new byte[0];
		protected static final int DEFAULT_HASHCODE = 1;
		protected static final int PRIME = 31;
		protected int hashCode = DEFAULT_HASHCODE;
		public boolean hashCodeDirty = true;

		public String loopKey;

		public Double EMPLOYEE_ID;

		public Double getEMPLOYEE_ID() {
			return this.EMPLOYEE_ID;
		}

		public String ORG_NAME;

		public String getORG_NAME() {
			return this.ORG_NAME;
		}

		public String COUNTRY;

		public String getCOUNTRY() {
			return this.COUNTRY;
		}

		public Double ORG_LEVEL;

		public Double getORG_LEVEL() {
			return this.ORG_LEVEL;
		}

		public java.util.Date START_DATE;

		public java.util.Date getSTART_DATE() {
			return this.START_DATE;
		}

		public java.util.Date END_DATE;

		public java.util.Date getEND_DATE() {
			return this.END_DATE;
		}

		public Double ORG_REF_ID;

		public Double getORG_REF_ID() {
			return this.ORG_REF_ID;
		}

		@Override
		public int hashCode() {
			if (this.hashCodeDirty) {
				final int prime = PRIME;
				int result = DEFAULT_HASHCODE;

				result = prime * result + ((this.EMPLOYEE_ID == null) ? 0 : this.EMPLOYEE_ID.hashCode());

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

			if (this.EMPLOYEE_ID == null) {
				if (other.EMPLOYEE_ID != null)
					return false;

			} else if (!this.EMPLOYEE_ID.equals(other.EMPLOYEE_ID))

				return false;

			return true;
		}

		public void copyDataTo(row3Struct other) {

			other.EMPLOYEE_ID = this.EMPLOYEE_ID;
			other.ORG_NAME = this.ORG_NAME;
			other.COUNTRY = this.COUNTRY;
			other.ORG_LEVEL = this.ORG_LEVEL;
			other.START_DATE = this.START_DATE;
			other.END_DATE = this.END_DATE;
			other.ORG_REF_ID = this.ORG_REF_ID;

		}

		public void copyKeysDataTo(row3Struct other) {

			other.EMPLOYEE_ID = this.EMPLOYEE_ID;

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

		private java.util.Date readDate(DataInputStream dis, ObjectInputStream ois) throws IOException {
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

		private java.util.Date readDate(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller)
				throws IOException {
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

		private void writeDate(java.util.Date date1, DataOutputStream dos, ObjectOutputStream oos) throws IOException {
			if (date1 == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeLong(date1.getTime());
			}
		}

		private void writeDate(java.util.Date date1, DataOutputStream dos, org.jboss.marshalling.Marshaller marshaller)
				throws IOException {
			if (date1 == null) {
				marshaller.writeByte(-1);
			} else {
				marshaller.writeByte(0);
				marshaller.writeLong(date1.getTime());
			}
		}

		public void readKeysData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_PROJETDATAV1_Job03_Organization_Dim) {

				try {

					int length = 0;

					length = dis.readByte();
					if (length == -1) {
						this.EMPLOYEE_ID = null;
					} else {
						this.EMPLOYEE_ID = dis.readDouble();
					}

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_PROJETDATAV1_Job03_Organization_Dim) {

				try {

					int length = 0;

					length = dis.readByte();
					if (length == -1) {
						this.EMPLOYEE_ID = null;
					} else {
						this.EMPLOYEE_ID = dis.readDouble();
					}

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeKeysData(ObjectOutputStream dos) {
			try {

				// Double

				if (this.EMPLOYEE_ID == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this.EMPLOYEE_ID);
				}

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
			try {

				// Double

				if (this.EMPLOYEE_ID == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this.EMPLOYEE_ID);
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

				this.ORG_NAME = readString(dis, ois);

				this.COUNTRY = readString(dis, ois);

				length = dis.readByte();
				if (length == -1) {
					this.ORG_LEVEL = null;
				} else {
					this.ORG_LEVEL = dis.readDouble();
				}

				this.START_DATE = readDate(dis, ois);

				this.END_DATE = readDate(dis, ois);

				length = dis.readByte();
				if (length == -1) {
					this.ORG_REF_ID = null;
				} else {
					this.ORG_REF_ID = dis.readDouble();
				}

			} catch (IOException e) {
				throw new RuntimeException(e);

			}

		}

		public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
			try {
				int length = 0;

				this.ORG_NAME = readString(dis, objectIn);

				this.COUNTRY = readString(dis, objectIn);

				length = objectIn.readByte();
				if (length == -1) {
					this.ORG_LEVEL = null;
				} else {
					this.ORG_LEVEL = objectIn.readDouble();
				}

				this.START_DATE = readDate(dis, objectIn);

				this.END_DATE = readDate(dis, objectIn);

				length = objectIn.readByte();
				if (length == -1) {
					this.ORG_REF_ID = null;
				} else {
					this.ORG_REF_ID = objectIn.readDouble();
				}

			} catch (IOException e) {
				throw new RuntimeException(e);

			}

		}

		/**
		 * Return a byte array which represents Values data.
		 */
		public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
			try {

				writeString(this.ORG_NAME, dos, oos);

				writeString(this.COUNTRY, dos, oos);

				if (this.ORG_LEVEL == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this.ORG_LEVEL);
				}

				writeDate(this.START_DATE, dos, oos);

				writeDate(this.END_DATE, dos, oos);

				if (this.ORG_REF_ID == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this.ORG_REF_ID);
				}

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut) {
			try {

				writeString(this.ORG_NAME, dos, objectOut);

				writeString(this.COUNTRY, dos, objectOut);

				if (this.ORG_LEVEL == null) {
					objectOut.writeByte(-1);
				} else {
					objectOut.writeByte(0);
					objectOut.writeDouble(this.ORG_LEVEL);
				}

				writeDate(this.START_DATE, dos, objectOut);

				writeDate(this.END_DATE, dos, objectOut);

				if (this.ORG_REF_ID == null) {
					objectOut.writeByte(-1);
				} else {
					objectOut.writeByte(0);
					objectOut.writeDouble(this.ORG_REF_ID);
				}

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
			sb.append("EMPLOYEE_ID=" + String.valueOf(EMPLOYEE_ID));
			sb.append(",ORG_NAME=" + ORG_NAME);
			sb.append(",COUNTRY=" + COUNTRY);
			sb.append(",ORG_LEVEL=" + String.valueOf(ORG_LEVEL));
			sb.append(",START_DATE=" + String.valueOf(START_DATE));
			sb.append(",END_DATE=" + String.valueOf(END_DATE));
			sb.append(",ORG_REF_ID=" + String.valueOf(ORG_REF_ID));
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row3Struct other) {

			int returnValue = -1;

			returnValue = checkNullsAndCompare(this.EMPLOYEE_ID, other.EMPLOYEE_ID);
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
				// linked node: tMap_1 - inputs:(row1,row2,row3,row4,row5,row6)
				// outputs:(Output_Organization_Dim)

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

				String dbquery_tDBInput_3 = "SELECT \n  ORGANIZATION.EMPLOYEE_ID, \n  ORGANIZATION.ORG_NAME, \n  ORGANIZATION.COUNTRY, \n  ORGANIZATION.ORG_LEVEL, \n  OR"
						+ "GANIZATION.START_DATE, \n  ORGANIZATION.END_DATE, \n  ORGANIZATION.ORG_REF_ID\nFROM ORGANIZATION";

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
							row3.EMPLOYEE_ID = null;
						} else {

							row3.EMPLOYEE_ID = rs_tDBInput_3.getDouble(1);
							if (rs_tDBInput_3.wasNull()) {
								row3.EMPLOYEE_ID = null;
							}
						}
						if (colQtyInRs_tDBInput_3 < 2) {
							row3.ORG_NAME = null;
						} else {

							row3.ORG_NAME = routines.system.JDBCUtil.getString(rs_tDBInput_3, 2, false);
						}
						if (colQtyInRs_tDBInput_3 < 3) {
							row3.COUNTRY = null;
						} else {

							row3.COUNTRY = routines.system.JDBCUtil.getString(rs_tDBInput_3, 3, false);
						}
						if (colQtyInRs_tDBInput_3 < 4) {
							row3.ORG_LEVEL = null;
						} else {

							row3.ORG_LEVEL = rs_tDBInput_3.getDouble(4);
							if (rs_tDBInput_3.wasNull()) {
								row3.ORG_LEVEL = null;
							}
						}
						if (colQtyInRs_tDBInput_3 < 5) {
							row3.START_DATE = null;
						} else {

							java.sql.Timestamp timestamp_tDBInput_3 = rs_tDBInput_3.getTimestamp(5);
							if (timestamp_tDBInput_3 != null) {
								row3.START_DATE = new java.util.Date(timestamp_tDBInput_3.getTime());
							} else {
								row3.START_DATE = null;
							}
						}
						if (colQtyInRs_tDBInput_3 < 6) {
							row3.END_DATE = null;
						} else {

							java.sql.Timestamp timestamp_tDBInput_3 = rs_tDBInput_3.getTimestamp(6);
							if (timestamp_tDBInput_3 != null) {
								row3.END_DATE = new java.util.Date(timestamp_tDBInput_3.getTime());
							} else {
								row3.END_DATE = null;
							}
						}
						if (colQtyInRs_tDBInput_3 < 7) {
							row3.ORG_REF_ID = null;
						} else {

							row3.ORG_REF_ID = rs_tDBInput_3.getDouble(7);
							if (rs_tDBInput_3.wasNull()) {
								row3.ORG_REF_ID = null;
							}
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

						row3_HashRow.EMPLOYEE_ID = row3.EMPLOYEE_ID;

						row3_HashRow.ORG_NAME = row3.ORG_NAME;

						row3_HashRow.COUNTRY = row3.COUNTRY;

						row3_HashRow.ORG_LEVEL = row3.ORG_LEVEL;

						row3_HashRow.START_DATE = row3.START_DATE;

						row3_HashRow.END_DATE = row3.END_DATE;

						row3_HashRow.ORG_REF_ID = row3.ORG_REF_ID;

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

	public static class row4Struct implements routines.system.IPersistableComparableLookupRow<row4Struct> {
		final static byte[] commonByteArrayLock_PROJETDATAV1_Job03_Organization_Dim = new byte[0];
		static byte[] commonByteArray_PROJETDATAV1_Job03_Organization_Dim = new byte[0];
		protected static final int DEFAULT_HASHCODE = 1;
		protected static final int PRIME = 31;
		protected int hashCode = DEFAULT_HASHCODE;
		public boolean hashCodeDirty = true;

		public String loopKey;

		public Double EMPLOYEE_ID;

		public Double getEMPLOYEE_ID() {
			return this.EMPLOYEE_ID;
		}

		public String ORG_NAME;

		public String getORG_NAME() {
			return this.ORG_NAME;
		}

		public String COUNTRY;

		public String getCOUNTRY() {
			return this.COUNTRY;
		}

		public Double ORG_LEVEL;

		public Double getORG_LEVEL() {
			return this.ORG_LEVEL;
		}

		public java.util.Date START_DATE;

		public java.util.Date getSTART_DATE() {
			return this.START_DATE;
		}

		public java.util.Date END_DATE;

		public java.util.Date getEND_DATE() {
			return this.END_DATE;
		}

		public Double ORG_REF_ID;

		public Double getORG_REF_ID() {
			return this.ORG_REF_ID;
		}

		@Override
		public int hashCode() {
			if (this.hashCodeDirty) {
				final int prime = PRIME;
				int result = DEFAULT_HASHCODE;

				result = prime * result + ((this.EMPLOYEE_ID == null) ? 0 : this.EMPLOYEE_ID.hashCode());

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
			final row4Struct other = (row4Struct) obj;

			if (this.EMPLOYEE_ID == null) {
				if (other.EMPLOYEE_ID != null)
					return false;

			} else if (!this.EMPLOYEE_ID.equals(other.EMPLOYEE_ID))

				return false;

			return true;
		}

		public void copyDataTo(row4Struct other) {

			other.EMPLOYEE_ID = this.EMPLOYEE_ID;
			other.ORG_NAME = this.ORG_NAME;
			other.COUNTRY = this.COUNTRY;
			other.ORG_LEVEL = this.ORG_LEVEL;
			other.START_DATE = this.START_DATE;
			other.END_DATE = this.END_DATE;
			other.ORG_REF_ID = this.ORG_REF_ID;

		}

		public void copyKeysDataTo(row4Struct other) {

			other.EMPLOYEE_ID = this.EMPLOYEE_ID;

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

		private java.util.Date readDate(DataInputStream dis, ObjectInputStream ois) throws IOException {
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

		private java.util.Date readDate(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller)
				throws IOException {
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

		private void writeDate(java.util.Date date1, DataOutputStream dos, ObjectOutputStream oos) throws IOException {
			if (date1 == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeLong(date1.getTime());
			}
		}

		private void writeDate(java.util.Date date1, DataOutputStream dos, org.jboss.marshalling.Marshaller marshaller)
				throws IOException {
			if (date1 == null) {
				marshaller.writeByte(-1);
			} else {
				marshaller.writeByte(0);
				marshaller.writeLong(date1.getTime());
			}
		}

		public void readKeysData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_PROJETDATAV1_Job03_Organization_Dim) {

				try {

					int length = 0;

					length = dis.readByte();
					if (length == -1) {
						this.EMPLOYEE_ID = null;
					} else {
						this.EMPLOYEE_ID = dis.readDouble();
					}

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_PROJETDATAV1_Job03_Organization_Dim) {

				try {

					int length = 0;

					length = dis.readByte();
					if (length == -1) {
						this.EMPLOYEE_ID = null;
					} else {
						this.EMPLOYEE_ID = dis.readDouble();
					}

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeKeysData(ObjectOutputStream dos) {
			try {

				// Double

				if (this.EMPLOYEE_ID == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this.EMPLOYEE_ID);
				}

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
			try {

				// Double

				if (this.EMPLOYEE_ID == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this.EMPLOYEE_ID);
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

				this.ORG_NAME = readString(dis, ois);

				this.COUNTRY = readString(dis, ois);

				length = dis.readByte();
				if (length == -1) {
					this.ORG_LEVEL = null;
				} else {
					this.ORG_LEVEL = dis.readDouble();
				}

				this.START_DATE = readDate(dis, ois);

				this.END_DATE = readDate(dis, ois);

				length = dis.readByte();
				if (length == -1) {
					this.ORG_REF_ID = null;
				} else {
					this.ORG_REF_ID = dis.readDouble();
				}

			} catch (IOException e) {
				throw new RuntimeException(e);

			}

		}

		public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
			try {
				int length = 0;

				this.ORG_NAME = readString(dis, objectIn);

				this.COUNTRY = readString(dis, objectIn);

				length = objectIn.readByte();
				if (length == -1) {
					this.ORG_LEVEL = null;
				} else {
					this.ORG_LEVEL = objectIn.readDouble();
				}

				this.START_DATE = readDate(dis, objectIn);

				this.END_DATE = readDate(dis, objectIn);

				length = objectIn.readByte();
				if (length == -1) {
					this.ORG_REF_ID = null;
				} else {
					this.ORG_REF_ID = objectIn.readDouble();
				}

			} catch (IOException e) {
				throw new RuntimeException(e);

			}

		}

		/**
		 * Return a byte array which represents Values data.
		 */
		public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
			try {

				writeString(this.ORG_NAME, dos, oos);

				writeString(this.COUNTRY, dos, oos);

				if (this.ORG_LEVEL == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this.ORG_LEVEL);
				}

				writeDate(this.START_DATE, dos, oos);

				writeDate(this.END_DATE, dos, oos);

				if (this.ORG_REF_ID == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this.ORG_REF_ID);
				}

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut) {
			try {

				writeString(this.ORG_NAME, dos, objectOut);

				writeString(this.COUNTRY, dos, objectOut);

				if (this.ORG_LEVEL == null) {
					objectOut.writeByte(-1);
				} else {
					objectOut.writeByte(0);
					objectOut.writeDouble(this.ORG_LEVEL);
				}

				writeDate(this.START_DATE, dos, objectOut);

				writeDate(this.END_DATE, dos, objectOut);

				if (this.ORG_REF_ID == null) {
					objectOut.writeByte(-1);
				} else {
					objectOut.writeByte(0);
					objectOut.writeDouble(this.ORG_REF_ID);
				}

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
			sb.append("EMPLOYEE_ID=" + String.valueOf(EMPLOYEE_ID));
			sb.append(",ORG_NAME=" + ORG_NAME);
			sb.append(",COUNTRY=" + COUNTRY);
			sb.append(",ORG_LEVEL=" + String.valueOf(ORG_LEVEL));
			sb.append(",START_DATE=" + String.valueOf(START_DATE));
			sb.append(",END_DATE=" + String.valueOf(END_DATE));
			sb.append(",ORG_REF_ID=" + String.valueOf(ORG_REF_ID));
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row4Struct other) {

			int returnValue = -1;

			returnValue = checkNullsAndCompare(this.EMPLOYEE_ID, other.EMPLOYEE_ID);
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
				// linked node: tMap_1 - inputs:(row1,row2,row3,row4,row5,row6)
				// outputs:(Output_Organization_Dim)

				org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_row4 = org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.UNIQUE_MATCH;

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

				String dbquery_tDBInput_4 = "SELECT \n  ORGANIZATION.EMPLOYEE_ID, \n  ORGANIZATION.ORG_NAME, \n  ORGANIZATION.COUNTRY, \n  ORGANIZATION.ORG_LEVEL, \n  OR"
						+ "GANIZATION.START_DATE, \n  ORGANIZATION.END_DATE, \n  ORGANIZATION.ORG_REF_ID\nFROM ORGANIZATION";

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
							row4.EMPLOYEE_ID = null;
						} else {

							row4.EMPLOYEE_ID = rs_tDBInput_4.getDouble(1);
							if (rs_tDBInput_4.wasNull()) {
								row4.EMPLOYEE_ID = null;
							}
						}
						if (colQtyInRs_tDBInput_4 < 2) {
							row4.ORG_NAME = null;
						} else {

							row4.ORG_NAME = routines.system.JDBCUtil.getString(rs_tDBInput_4, 2, false);
						}
						if (colQtyInRs_tDBInput_4 < 3) {
							row4.COUNTRY = null;
						} else {

							row4.COUNTRY = routines.system.JDBCUtil.getString(rs_tDBInput_4, 3, false);
						}
						if (colQtyInRs_tDBInput_4 < 4) {
							row4.ORG_LEVEL = null;
						} else {

							row4.ORG_LEVEL = rs_tDBInput_4.getDouble(4);
							if (rs_tDBInput_4.wasNull()) {
								row4.ORG_LEVEL = null;
							}
						}
						if (colQtyInRs_tDBInput_4 < 5) {
							row4.START_DATE = null;
						} else {

							java.sql.Timestamp timestamp_tDBInput_4 = rs_tDBInput_4.getTimestamp(5);
							if (timestamp_tDBInput_4 != null) {
								row4.START_DATE = new java.util.Date(timestamp_tDBInput_4.getTime());
							} else {
								row4.START_DATE = null;
							}
						}
						if (colQtyInRs_tDBInput_4 < 6) {
							row4.END_DATE = null;
						} else {

							java.sql.Timestamp timestamp_tDBInput_4 = rs_tDBInput_4.getTimestamp(6);
							if (timestamp_tDBInput_4 != null) {
								row4.END_DATE = new java.util.Date(timestamp_tDBInput_4.getTime());
							} else {
								row4.END_DATE = null;
							}
						}
						if (colQtyInRs_tDBInput_4 < 7) {
							row4.ORG_REF_ID = null;
						} else {

							row4.ORG_REF_ID = rs_tDBInput_4.getDouble(7);
							if (rs_tDBInput_4.wasNull()) {
								row4.ORG_REF_ID = null;
							}
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

						row4_HashRow.EMPLOYEE_ID = row4.EMPLOYEE_ID;

						row4_HashRow.ORG_NAME = row4.ORG_NAME;

						row4_HashRow.COUNTRY = row4.COUNTRY;

						row4_HashRow.ORG_LEVEL = row4.ORG_LEVEL;

						row4_HashRow.START_DATE = row4.START_DATE;

						row4_HashRow.END_DATE = row4.END_DATE;

						row4_HashRow.ORG_REF_ID = row4.ORG_REF_ID;

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

	public static class row5Struct implements routines.system.IPersistableComparableLookupRow<row5Struct> {
		final static byte[] commonByteArrayLock_PROJETDATAV1_Job03_Organization_Dim = new byte[0];
		static byte[] commonByteArray_PROJETDATAV1_Job03_Organization_Dim = new byte[0];
		protected static final int DEFAULT_HASHCODE = 1;
		protected static final int PRIME = 31;
		protected int hashCode = DEFAULT_HASHCODE;
		public boolean hashCodeDirty = true;

		public String loopKey;

		public Double EMPLOYEE_ID;

		public Double getEMPLOYEE_ID() {
			return this.EMPLOYEE_ID;
		}

		public String ORG_NAME;

		public String getORG_NAME() {
			return this.ORG_NAME;
		}

		public String COUNTRY;

		public String getCOUNTRY() {
			return this.COUNTRY;
		}

		public Double ORG_LEVEL;

		public Double getORG_LEVEL() {
			return this.ORG_LEVEL;
		}

		public java.util.Date START_DATE;

		public java.util.Date getSTART_DATE() {
			return this.START_DATE;
		}

		public java.util.Date END_DATE;

		public java.util.Date getEND_DATE() {
			return this.END_DATE;
		}

		public Double ORG_REF_ID;

		public Double getORG_REF_ID() {
			return this.ORG_REF_ID;
		}

		@Override
		public int hashCode() {
			if (this.hashCodeDirty) {
				final int prime = PRIME;
				int result = DEFAULT_HASHCODE;

				result = prime * result + ((this.EMPLOYEE_ID == null) ? 0 : this.EMPLOYEE_ID.hashCode());

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
			final row5Struct other = (row5Struct) obj;

			if (this.EMPLOYEE_ID == null) {
				if (other.EMPLOYEE_ID != null)
					return false;

			} else if (!this.EMPLOYEE_ID.equals(other.EMPLOYEE_ID))

				return false;

			return true;
		}

		public void copyDataTo(row5Struct other) {

			other.EMPLOYEE_ID = this.EMPLOYEE_ID;
			other.ORG_NAME = this.ORG_NAME;
			other.COUNTRY = this.COUNTRY;
			other.ORG_LEVEL = this.ORG_LEVEL;
			other.START_DATE = this.START_DATE;
			other.END_DATE = this.END_DATE;
			other.ORG_REF_ID = this.ORG_REF_ID;

		}

		public void copyKeysDataTo(row5Struct other) {

			other.EMPLOYEE_ID = this.EMPLOYEE_ID;

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

		private java.util.Date readDate(DataInputStream dis, ObjectInputStream ois) throws IOException {
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

		private java.util.Date readDate(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller)
				throws IOException {
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

		private void writeDate(java.util.Date date1, DataOutputStream dos, ObjectOutputStream oos) throws IOException {
			if (date1 == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeLong(date1.getTime());
			}
		}

		private void writeDate(java.util.Date date1, DataOutputStream dos, org.jboss.marshalling.Marshaller marshaller)
				throws IOException {
			if (date1 == null) {
				marshaller.writeByte(-1);
			} else {
				marshaller.writeByte(0);
				marshaller.writeLong(date1.getTime());
			}
		}

		public void readKeysData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_PROJETDATAV1_Job03_Organization_Dim) {

				try {

					int length = 0;

					length = dis.readByte();
					if (length == -1) {
						this.EMPLOYEE_ID = null;
					} else {
						this.EMPLOYEE_ID = dis.readDouble();
					}

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_PROJETDATAV1_Job03_Organization_Dim) {

				try {

					int length = 0;

					length = dis.readByte();
					if (length == -1) {
						this.EMPLOYEE_ID = null;
					} else {
						this.EMPLOYEE_ID = dis.readDouble();
					}

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeKeysData(ObjectOutputStream dos) {
			try {

				// Double

				if (this.EMPLOYEE_ID == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this.EMPLOYEE_ID);
				}

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
			try {

				// Double

				if (this.EMPLOYEE_ID == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this.EMPLOYEE_ID);
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

				this.ORG_NAME = readString(dis, ois);

				this.COUNTRY = readString(dis, ois);

				length = dis.readByte();
				if (length == -1) {
					this.ORG_LEVEL = null;
				} else {
					this.ORG_LEVEL = dis.readDouble();
				}

				this.START_DATE = readDate(dis, ois);

				this.END_DATE = readDate(dis, ois);

				length = dis.readByte();
				if (length == -1) {
					this.ORG_REF_ID = null;
				} else {
					this.ORG_REF_ID = dis.readDouble();
				}

			} catch (IOException e) {
				throw new RuntimeException(e);

			}

		}

		public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
			try {
				int length = 0;

				this.ORG_NAME = readString(dis, objectIn);

				this.COUNTRY = readString(dis, objectIn);

				length = objectIn.readByte();
				if (length == -1) {
					this.ORG_LEVEL = null;
				} else {
					this.ORG_LEVEL = objectIn.readDouble();
				}

				this.START_DATE = readDate(dis, objectIn);

				this.END_DATE = readDate(dis, objectIn);

				length = objectIn.readByte();
				if (length == -1) {
					this.ORG_REF_ID = null;
				} else {
					this.ORG_REF_ID = objectIn.readDouble();
				}

			} catch (IOException e) {
				throw new RuntimeException(e);

			}

		}

		/**
		 * Return a byte array which represents Values data.
		 */
		public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
			try {

				writeString(this.ORG_NAME, dos, oos);

				writeString(this.COUNTRY, dos, oos);

				if (this.ORG_LEVEL == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this.ORG_LEVEL);
				}

				writeDate(this.START_DATE, dos, oos);

				writeDate(this.END_DATE, dos, oos);

				if (this.ORG_REF_ID == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this.ORG_REF_ID);
				}

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut) {
			try {

				writeString(this.ORG_NAME, dos, objectOut);

				writeString(this.COUNTRY, dos, objectOut);

				if (this.ORG_LEVEL == null) {
					objectOut.writeByte(-1);
				} else {
					objectOut.writeByte(0);
					objectOut.writeDouble(this.ORG_LEVEL);
				}

				writeDate(this.START_DATE, dos, objectOut);

				writeDate(this.END_DATE, dos, objectOut);

				if (this.ORG_REF_ID == null) {
					objectOut.writeByte(-1);
				} else {
					objectOut.writeByte(0);
					objectOut.writeDouble(this.ORG_REF_ID);
				}

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
			sb.append("EMPLOYEE_ID=" + String.valueOf(EMPLOYEE_ID));
			sb.append(",ORG_NAME=" + ORG_NAME);
			sb.append(",COUNTRY=" + COUNTRY);
			sb.append(",ORG_LEVEL=" + String.valueOf(ORG_LEVEL));
			sb.append(",START_DATE=" + String.valueOf(START_DATE));
			sb.append(",END_DATE=" + String.valueOf(END_DATE));
			sb.append(",ORG_REF_ID=" + String.valueOf(ORG_REF_ID));
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row5Struct other) {

			int returnValue = -1;

			returnValue = checkNullsAndCompare(this.EMPLOYEE_ID, other.EMPLOYEE_ID);
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

				row5Struct row5 = new row5Struct();

				/**
				 * [tAdvancedHash_row5 begin ] start
				 */

				ok_Hash.put("tAdvancedHash_row5", false);
				start_Hash.put("tAdvancedHash_row5", System.currentTimeMillis());

				currentComponent = "tAdvancedHash_row5";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row5");
				}

				int tos_count_tAdvancedHash_row5 = 0;

				// connection name:row5
				// source node:tDBInput_5 - inputs:(after_tDBInput_1) outputs:(row5,row5) |
				// target node:tAdvancedHash_row5 - inputs:(row5) outputs:()
				// linked node: tMap_1 - inputs:(row1,row2,row3,row4,row5,row6)
				// outputs:(Output_Organization_Dim)

				org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_row5 = org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.UNIQUE_MATCH;

				org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row5Struct> tHash_Lookup_row5 = org.talend.designer.components.lookup.memory.AdvancedMemoryLookup
						.<row5Struct>getLookup(matchingModeEnum_row5);

				globalMap.put("tHash_Lookup_row5", tHash_Lookup_row5);

				/**
				 * [tAdvancedHash_row5 begin ] stop
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

				String dbquery_tDBInput_5 = "SELECT \n  ORGANIZATION.EMPLOYEE_ID, \n  ORGANIZATION.ORG_NAME, \n  ORGANIZATION.COUNTRY, \n  ORGANIZATION.ORG_LEVEL, \n  OR"
						+ "GANIZATION.START_DATE, \n  ORGANIZATION.END_DATE, \n  ORGANIZATION.ORG_REF_ID\nFROM ORGANIZATION";

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
							row5.EMPLOYEE_ID = null;
						} else {

							row5.EMPLOYEE_ID = rs_tDBInput_5.getDouble(1);
							if (rs_tDBInput_5.wasNull()) {
								row5.EMPLOYEE_ID = null;
							}
						}
						if (colQtyInRs_tDBInput_5 < 2) {
							row5.ORG_NAME = null;
						} else {

							row5.ORG_NAME = routines.system.JDBCUtil.getString(rs_tDBInput_5, 2, false);
						}
						if (colQtyInRs_tDBInput_5 < 3) {
							row5.COUNTRY = null;
						} else {

							row5.COUNTRY = routines.system.JDBCUtil.getString(rs_tDBInput_5, 3, false);
						}
						if (colQtyInRs_tDBInput_5 < 4) {
							row5.ORG_LEVEL = null;
						} else {

							row5.ORG_LEVEL = rs_tDBInput_5.getDouble(4);
							if (rs_tDBInput_5.wasNull()) {
								row5.ORG_LEVEL = null;
							}
						}
						if (colQtyInRs_tDBInput_5 < 5) {
							row5.START_DATE = null;
						} else {

							java.sql.Timestamp timestamp_tDBInput_5 = rs_tDBInput_5.getTimestamp(5);
							if (timestamp_tDBInput_5 != null) {
								row5.START_DATE = new java.util.Date(timestamp_tDBInput_5.getTime());
							} else {
								row5.START_DATE = null;
							}
						}
						if (colQtyInRs_tDBInput_5 < 6) {
							row5.END_DATE = null;
						} else {

							java.sql.Timestamp timestamp_tDBInput_5 = rs_tDBInput_5.getTimestamp(6);
							if (timestamp_tDBInput_5 != null) {
								row5.END_DATE = new java.util.Date(timestamp_tDBInput_5.getTime());
							} else {
								row5.END_DATE = null;
							}
						}
						if (colQtyInRs_tDBInput_5 < 7) {
							row5.ORG_REF_ID = null;
						} else {

							row5.ORG_REF_ID = rs_tDBInput_5.getDouble(7);
							if (rs_tDBInput_5.wasNull()) {
								row5.ORG_REF_ID = null;
							}
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
						 * [tAdvancedHash_row5 main ] start
						 */

						currentComponent = "tAdvancedHash_row5";

						if (execStat) {
							runStat.updateStatOnConnection(iterateId, 1, 1

									, "row5"

							);
						}

						row5Struct row5_HashRow = new row5Struct();

						row5_HashRow.EMPLOYEE_ID = row5.EMPLOYEE_ID;

						row5_HashRow.ORG_NAME = row5.ORG_NAME;

						row5_HashRow.COUNTRY = row5.COUNTRY;

						row5_HashRow.ORG_LEVEL = row5.ORG_LEVEL;

						row5_HashRow.START_DATE = row5.START_DATE;

						row5_HashRow.END_DATE = row5.END_DATE;

						row5_HashRow.ORG_REF_ID = row5.ORG_REF_ID;

						tHash_Lookup_row5.put(row5_HashRow);

						tos_count_tAdvancedHash_row5++;

						/**
						 * [tAdvancedHash_row5 main ] stop
						 */

						/**
						 * [tAdvancedHash_row5 process_data_begin ] start
						 */

						currentComponent = "tAdvancedHash_row5";

						/**
						 * [tAdvancedHash_row5 process_data_begin ] stop
						 */

						/**
						 * [tAdvancedHash_row5 process_data_end ] start
						 */

						currentComponent = "tAdvancedHash_row5";

						/**
						 * [tAdvancedHash_row5 process_data_end ] stop
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
				 * [tAdvancedHash_row5 end ] start
				 */

				currentComponent = "tAdvancedHash_row5";

				tHash_Lookup_row5.endPut();

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "row5");
				}

				ok_Hash.put("tAdvancedHash_row5", true);
				end_Hash.put("tAdvancedHash_row5", System.currentTimeMillis());

				/**
				 * [tAdvancedHash_row5 end ] stop
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
				 * [tAdvancedHash_row5 finally ] start
				 */

				currentComponent = "tAdvancedHash_row5";

				/**
				 * [tAdvancedHash_row5 finally ] stop
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

	public static class row6Struct implements routines.system.IPersistableComparableLookupRow<row6Struct> {
		final static byte[] commonByteArrayLock_PROJETDATAV1_Job03_Organization_Dim = new byte[0];
		static byte[] commonByteArray_PROJETDATAV1_Job03_Organization_Dim = new byte[0];
		protected static final int DEFAULT_HASHCODE = 1;
		protected static final int PRIME = 31;
		protected int hashCode = DEFAULT_HASHCODE;
		public boolean hashCodeDirty = true;

		public String loopKey;

		public Double Employee_ID;

		public Double getEmployee_ID() {
			return this.Employee_ID;
		}

		public String Start_Date;

		public String getStart_Date() {
			return this.Start_Date;
		}

		public String End_Date;

		public String getEnd_Date() {
			return this.End_Date;
		}

		public String Job_Title;

		public String getJob_Title() {
			return this.Job_Title;
		}

		public String Salary;

		public String getSalary() {
			return this.Salary;
		}

		public Character Gender;

		public Character getGender() {
			return this.Gender;
		}

		public java.util.Date Birth_Date;

		public java.util.Date getBirth_Date() {
			return this.Birth_Date;
		}

		public java.util.Date Emp_Hire_Date;

		public java.util.Date getEmp_Hire_Date() {
			return this.Emp_Hire_Date;
		}

		public java.util.Date Emp_Term_Date;

		public java.util.Date getEmp_Term_Date() {
			return this.Emp_Term_Date;
		}

		public String Manager_ID;

		public String getManager_ID() {
			return this.Manager_ID;
		}

		@Override
		public int hashCode() {
			if (this.hashCodeDirty) {
				final int prime = PRIME;
				int result = DEFAULT_HASHCODE;

				result = prime * result + ((this.Employee_ID == null) ? 0 : this.Employee_ID.hashCode());

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

			if (this.Employee_ID == null) {
				if (other.Employee_ID != null)
					return false;

			} else if (!this.Employee_ID.equals(other.Employee_ID))

				return false;

			return true;
		}

		public void copyDataTo(row6Struct other) {

			other.Employee_ID = this.Employee_ID;
			other.Start_Date = this.Start_Date;
			other.End_Date = this.End_Date;
			other.Job_Title = this.Job_Title;
			other.Salary = this.Salary;
			other.Gender = this.Gender;
			other.Birth_Date = this.Birth_Date;
			other.Emp_Hire_Date = this.Emp_Hire_Date;
			other.Emp_Term_Date = this.Emp_Term_Date;
			other.Manager_ID = this.Manager_ID;

		}

		public void copyKeysDataTo(row6Struct other) {

			other.Employee_ID = this.Employee_ID;

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

		private java.util.Date readDate(DataInputStream dis, ObjectInputStream ois) throws IOException {
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

		private java.util.Date readDate(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller)
				throws IOException {
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

		private void writeDate(java.util.Date date1, DataOutputStream dos, ObjectOutputStream oos) throws IOException {
			if (date1 == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeLong(date1.getTime());
			}
		}

		private void writeDate(java.util.Date date1, DataOutputStream dos, org.jboss.marshalling.Marshaller marshaller)
				throws IOException {
			if (date1 == null) {
				marshaller.writeByte(-1);
			} else {
				marshaller.writeByte(0);
				marshaller.writeLong(date1.getTime());
			}
		}

		public void readKeysData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_PROJETDATAV1_Job03_Organization_Dim) {

				try {

					int length = 0;

					length = dis.readByte();
					if (length == -1) {
						this.Employee_ID = null;
					} else {
						this.Employee_ID = dis.readDouble();
					}

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_PROJETDATAV1_Job03_Organization_Dim) {

				try {

					int length = 0;

					length = dis.readByte();
					if (length == -1) {
						this.Employee_ID = null;
					} else {
						this.Employee_ID = dis.readDouble();
					}

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeKeysData(ObjectOutputStream dos) {
			try {

				// Double

				if (this.Employee_ID == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this.Employee_ID);
				}

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
			try {

				// Double

				if (this.Employee_ID == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this.Employee_ID);
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

				this.Start_Date = readString(dis, ois);

				this.End_Date = readString(dis, ois);

				this.Job_Title = readString(dis, ois);

				this.Salary = readString(dis, ois);

				length = dis.readByte();
				if (length == -1) {
					this.Gender = null;
				} else {
					this.Gender = dis.readChar();
				}

				this.Birth_Date = readDate(dis, ois);

				this.Emp_Hire_Date = readDate(dis, ois);

				this.Emp_Term_Date = readDate(dis, ois);

				this.Manager_ID = readString(dis, ois);

			} catch (IOException e) {
				throw new RuntimeException(e);

			}

		}

		public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
			try {
				int length = 0;

				this.Start_Date = readString(dis, objectIn);

				this.End_Date = readString(dis, objectIn);

				this.Job_Title = readString(dis, objectIn);

				this.Salary = readString(dis, objectIn);

				length = objectIn.readByte();
				if (length == -1) {
					this.Gender = null;
				} else {
					this.Gender = objectIn.readChar();
				}

				this.Birth_Date = readDate(dis, objectIn);

				this.Emp_Hire_Date = readDate(dis, objectIn);

				this.Emp_Term_Date = readDate(dis, objectIn);

				this.Manager_ID = readString(dis, objectIn);

			} catch (IOException e) {
				throw new RuntimeException(e);

			}

		}

		/**
		 * Return a byte array which represents Values data.
		 */
		public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
			try {

				writeString(this.Start_Date, dos, oos);

				writeString(this.End_Date, dos, oos);

				writeString(this.Job_Title, dos, oos);

				writeString(this.Salary, dos, oos);

				if (this.Gender == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeChar(this.Gender);
				}

				writeDate(this.Birth_Date, dos, oos);

				writeDate(this.Emp_Hire_Date, dos, oos);

				writeDate(this.Emp_Term_Date, dos, oos);

				writeString(this.Manager_ID, dos, oos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut) {
			try {

				writeString(this.Start_Date, dos, objectOut);

				writeString(this.End_Date, dos, objectOut);

				writeString(this.Job_Title, dos, objectOut);

				writeString(this.Salary, dos, objectOut);

				if (this.Gender == null) {
					objectOut.writeByte(-1);
				} else {
					objectOut.writeByte(0);
					objectOut.writeChar(this.Gender);
				}

				writeDate(this.Birth_Date, dos, objectOut);

				writeDate(this.Emp_Hire_Date, dos, objectOut);

				writeDate(this.Emp_Term_Date, dos, objectOut);

				writeString(this.Manager_ID, dos, objectOut);

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
			sb.append("Employee_ID=" + String.valueOf(Employee_ID));
			sb.append(",Start_Date=" + Start_Date);
			sb.append(",End_Date=" + End_Date);
			sb.append(",Job_Title=" + Job_Title);
			sb.append(",Salary=" + Salary);
			sb.append(",Gender=" + String.valueOf(Gender));
			sb.append(",Birth_Date=" + String.valueOf(Birth_Date));
			sb.append(",Emp_Hire_Date=" + String.valueOf(Emp_Hire_Date));
			sb.append(",Emp_Term_Date=" + String.valueOf(Emp_Term_Date));
			sb.append(",Manager_ID=" + Manager_ID);
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row6Struct other) {

			int returnValue = -1;

			returnValue = checkNullsAndCompare(this.Employee_ID, other.Employee_ID);
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

	public void tFileInputExcel_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tFileInputExcel_1_SUBPROCESS_STATE", 0);

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
				// source node:tFileInputExcel_1 - inputs:(after_tDBInput_1) outputs:(row6,row6)
				// | target node:tAdvancedHash_row6 - inputs:(row6) outputs:()
				// linked node: tMap_1 - inputs:(row1,row2,row3,row4,row5,row6)
				// outputs:(Output_Organization_Dim)

				org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_row6 = org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.UNIQUE_MATCH;

				org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row6Struct> tHash_Lookup_row6 = org.talend.designer.components.lookup.memory.AdvancedMemoryLookup
						.<row6Struct>getLookup(matchingModeEnum_row6);

				globalMap.put("tHash_Lookup_row6", tHash_Lookup_row6);

				/**
				 * [tAdvancedHash_row6 begin ] stop
				 */

				/**
				 * [tFileInputExcel_1 begin ] start
				 */

				ok_Hash.put("tFileInputExcel_1", false);
				start_Hash.put("tFileInputExcel_1", System.currentTimeMillis());

				currentComponent = "tFileInputExcel_1";

				int tos_count_tFileInputExcel_1 = 0;

				class RegexUtil_tFileInputExcel_1 {

					public java.util.List<jxl.Sheet> getSheets(jxl.Workbook workbook, String oneSheetName,
							boolean useRegex) {

						java.util.List<jxl.Sheet> list = new java.util.ArrayList<jxl.Sheet>();

						if (useRegex) {// this part process the regex issue

							jxl.Sheet[] sheets = workbook.getSheets();
							java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(oneSheetName);
							for (int i = 0; i < sheets.length; i++) {
								String sheetName = sheets[i].getName();
								java.util.regex.Matcher matcher = pattern.matcher(sheetName);
								if (matcher.matches()) {
									jxl.Sheet sheet = workbook.getSheet(sheetName);
									if (sheet != null) {
										list.add(sheet);
									}
								}
							}

						} else {
							jxl.Sheet sheet = workbook.getSheet(oneSheetName);
							if (sheet != null) {
								list.add(sheet);
							}

						}

						return list;
					}

					public java.util.List<jxl.Sheet> getSheets(jxl.Workbook workbook, int index, boolean useRegex) {
						java.util.List<jxl.Sheet> list = new java.util.ArrayList<jxl.Sheet>();
						jxl.Sheet sheet = workbook.getSheet(index);
						if (sheet != null) {
							list.add(sheet);
						}
						return list;
					}

				}

				RegexUtil_tFileInputExcel_1 regexUtil_tFileInputExcel_1 = new RegexUtil_tFileInputExcel_1();
				final jxl.WorkbookSettings workbookSettings_tFileInputExcel_1 = new jxl.WorkbookSettings();
				workbookSettings_tFileInputExcel_1.setDrawingsDisabled(true);
				workbookSettings_tFileInputExcel_1.setEncoding("UTF-8");

				Object source_tFileInputExcel_1 = "C:/Users/wiemh/Desktop/projetData_Nous/staff.xls";
				final jxl.Workbook workbook_tFileInputExcel_1;

				java.io.InputStream toClose_tFileInputExcel_1 = null;
				java.io.BufferedInputStream buffIStreamtFileInputExcel_1 = null;
				try {
					if (source_tFileInputExcel_1 instanceof java.io.InputStream) {
						toClose_tFileInputExcel_1 = (java.io.InputStream) source_tFileInputExcel_1;
						buffIStreamtFileInputExcel_1 = new java.io.BufferedInputStream(toClose_tFileInputExcel_1);
						workbook_tFileInputExcel_1 = jxl.Workbook.getWorkbook(buffIStreamtFileInputExcel_1,
								workbookSettings_tFileInputExcel_1);
					} else if (source_tFileInputExcel_1 instanceof String) {
						toClose_tFileInputExcel_1 = new java.io.FileInputStream(source_tFileInputExcel_1.toString());
						buffIStreamtFileInputExcel_1 = new java.io.BufferedInputStream(toClose_tFileInputExcel_1);
						workbook_tFileInputExcel_1 = jxl.Workbook.getWorkbook(buffIStreamtFileInputExcel_1,
								workbookSettings_tFileInputExcel_1);
					} else {
						workbook_tFileInputExcel_1 = null;
						throw new java.lang.Exception(
								"The data source should be specified as Inputstream or File Path!");
					}
				} finally {
					try {
						if (buffIStreamtFileInputExcel_1 != null) {
							buffIStreamtFileInputExcel_1.close();
						}
					} catch (Exception e) {
						globalMap.put("tFileInputExcel_1_ERROR_MESSAGE", e.getMessage());
					}
				}
				try {
					java.util.List<jxl.Sheet> sheetList_tFileInputExcel_1 = java.util.Arrays.<jxl.Sheet>asList(
							workbook_tFileInputExcel_1.getSheets());
					if (sheetList_tFileInputExcel_1.size() <= 0) {
						throw new RuntimeException("Special sheets not exist!");
					}

					java.util.List<jxl.Sheet> sheet_FilterNullList_tFileInputExcel_1 = new java.util.ArrayList<jxl.Sheet>();
					for (jxl.Sheet sheet_FilterNull_tFileInputExcel_1 : sheetList_tFileInputExcel_1) {
						if (sheet_FilterNull_tFileInputExcel_1.getRows() > 0) {
							sheet_FilterNullList_tFileInputExcel_1.add(sheet_FilterNull_tFileInputExcel_1);
						}
					}
					sheetList_tFileInputExcel_1 = sheet_FilterNullList_tFileInputExcel_1;
					if (sheetList_tFileInputExcel_1.size() > 0) {
						int nb_line_tFileInputExcel_1 = 0;

						int begin_line_tFileInputExcel_1 = 0;

						int footer_input_tFileInputExcel_1 = 0;

						int end_line_tFileInputExcel_1 = 0;
						for (jxl.Sheet sheet_tFileInputExcel_1 : sheetList_tFileInputExcel_1) {
							end_line_tFileInputExcel_1 += sheet_tFileInputExcel_1.getRows();
						}
						end_line_tFileInputExcel_1 -= footer_input_tFileInputExcel_1;
						int limit_tFileInputExcel_1 = -1;
						int start_column_tFileInputExcel_1 = 1 - 1;
						int end_column_tFileInputExcel_1 = sheetList_tFileInputExcel_1.get(0).getColumns();
						jxl.Cell[] row_tFileInputExcel_1 = null;
						jxl.Sheet sheet_tFileInputExcel_1 = sheetList_tFileInputExcel_1.get(0);
						int rowCount_tFileInputExcel_1 = 0;
						int sheetIndex_tFileInputExcel_1 = 0;
						int currentRows_tFileInputExcel_1 = sheetList_tFileInputExcel_1.get(0).getRows();

						// for the number format
						java.text.DecimalFormat df_tFileInputExcel_1 = new java.text.DecimalFormat(
								"#.####################################");
						char separatorChar_tFileInputExcel_1 = df_tFileInputExcel_1.getDecimalFormatSymbols()
								.getDecimalSeparator();

						for (int i_tFileInputExcel_1 = begin_line_tFileInputExcel_1; i_tFileInputExcel_1 < end_line_tFileInputExcel_1; i_tFileInputExcel_1++) {

							int emptyColumnCount_tFileInputExcel_1 = 0;

							if (limit_tFileInputExcel_1 != -1 && nb_line_tFileInputExcel_1 >= limit_tFileInputExcel_1) {
								break;
							}

							while (i_tFileInputExcel_1 >= rowCount_tFileInputExcel_1 + currentRows_tFileInputExcel_1) {
								rowCount_tFileInputExcel_1 += currentRows_tFileInputExcel_1;
								sheet_tFileInputExcel_1 = sheetList_tFileInputExcel_1
										.get(++sheetIndex_tFileInputExcel_1);
								currentRows_tFileInputExcel_1 = sheet_tFileInputExcel_1.getRows();
							}
							if (rowCount_tFileInputExcel_1 <= i_tFileInputExcel_1) {
								row_tFileInputExcel_1 = sheet_tFileInputExcel_1
										.getRow(i_tFileInputExcel_1 - rowCount_tFileInputExcel_1);
							}
							globalMap.put("tFileInputExcel_1_CURRENT_SHEET", sheet_tFileInputExcel_1.getName());
							row6 = null;
							row6 = null;
							int tempRowLength_tFileInputExcel_1 = 10;

							int columnIndex_tFileInputExcel_1 = 0;

//
//end%>

							String[] temp_row_tFileInputExcel_1 = new String[tempRowLength_tFileInputExcel_1];
							int actual_end_column_tFileInputExcel_1 = end_column_tFileInputExcel_1 > row_tFileInputExcel_1.length
									? row_tFileInputExcel_1.length
									: end_column_tFileInputExcel_1;

							java.util.TimeZone zone_tFileInputExcel_1 = java.util.TimeZone.getTimeZone("GMT");
							java.text.SimpleDateFormat sdf_tFileInputExcel_1 = new java.text.SimpleDateFormat(
									"dd-MM-yyyy");
							sdf_tFileInputExcel_1.setTimeZone(zone_tFileInputExcel_1);

							for (int i = 0; i < tempRowLength_tFileInputExcel_1; i++) {

								if (i + start_column_tFileInputExcel_1 < actual_end_column_tFileInputExcel_1) {

									jxl.Cell cell_tFileInputExcel_1 = row_tFileInputExcel_1[i
											+ start_column_tFileInputExcel_1];
									temp_row_tFileInputExcel_1[i] = cell_tFileInputExcel_1.getContents();

								} else {
									temp_row_tFileInputExcel_1[i] = "";
								}
							}

							boolean whetherReject_tFileInputExcel_1 = false;
							row6 = new row6Struct();
							int curColNum_tFileInputExcel_1 = -1;
							String curColName_tFileInputExcel_1 = "";
							try {
								columnIndex_tFileInputExcel_1 = 0;

								if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].length() > 0) {
									curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
											+ start_column_tFileInputExcel_1 + 1;
									curColName_tFileInputExcel_1 = "Employee_ID";
									row6.Employee_ID = ParserUtils
											.parseTo_Double(temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1]);
								} else {
									row6.Employee_ID = null;
									emptyColumnCount_tFileInputExcel_1++;
								}
								columnIndex_tFileInputExcel_1 = 1;

								if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].length() > 0) {
									curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
											+ start_column_tFileInputExcel_1 + 1;
									curColName_tFileInputExcel_1 = "Start_Date";
									row6.Start_Date = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1];
								} else {
									row6.Start_Date = null;
									emptyColumnCount_tFileInputExcel_1++;
								}
								columnIndex_tFileInputExcel_1 = 2;

								if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].length() > 0) {
									curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
											+ start_column_tFileInputExcel_1 + 1;
									curColName_tFileInputExcel_1 = "End_Date";
									row6.End_Date = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1];
								} else {
									row6.End_Date = null;
									emptyColumnCount_tFileInputExcel_1++;
								}
								columnIndex_tFileInputExcel_1 = 3;

								if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].length() > 0) {
									curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
											+ start_column_tFileInputExcel_1 + 1;
									curColName_tFileInputExcel_1 = "Job_Title";
									row6.Job_Title = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1];
								} else {
									row6.Job_Title = null;
									emptyColumnCount_tFileInputExcel_1++;
								}
								columnIndex_tFileInputExcel_1 = 4;

								if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].length() > 0) {
									curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
											+ start_column_tFileInputExcel_1 + 1;
									curColName_tFileInputExcel_1 = "Salary";
									row6.Salary = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1];
								} else {
									row6.Salary = null;
									emptyColumnCount_tFileInputExcel_1++;
								}
								columnIndex_tFileInputExcel_1 = 5;

								if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].length() > 0) {
									curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
											+ start_column_tFileInputExcel_1 + 1;
									curColName_tFileInputExcel_1 = "Gender";
									row6.Gender = ParserUtils.parseTo_Character(
											temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1]);
								} else {
									row6.Gender = null;
									emptyColumnCount_tFileInputExcel_1++;
								}
								columnIndex_tFileInputExcel_1 = 6;

								if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].length() > 0) {
									curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
											+ start_column_tFileInputExcel_1 + 1;
									curColName_tFileInputExcel_1 = "Birth_Date";
									if (6 < actual_end_column_tFileInputExcel_1) {
										try {
											java.util.Date dateGMT_tFileInputExcel_1 = ((jxl.DateCell) row_tFileInputExcel_1[columnIndex_tFileInputExcel_1
													+ start_column_tFileInputExcel_1]).getDate();
											row6.Birth_Date = new java.util.Date(dateGMT_tFileInputExcel_1.getTime()
													- java.util.TimeZone.getDefault()
															.getOffset(dateGMT_tFileInputExcel_1.getTime()));
										} catch (java.lang.Exception e) {
											globalMap.put("tFileInputExcel_1_ERROR_MESSAGE", e.getMessage());

											throw new RuntimeException("The cell format is not Date in ( Row. "
													+ (nb_line_tFileInputExcel_1 + 1) + " and ColumnNum. "
													+ curColNum_tFileInputExcel_1 + " )");
										}
									}
								} else {
									row6.Birth_Date = null;
									emptyColumnCount_tFileInputExcel_1++;
								}
								columnIndex_tFileInputExcel_1 = 7;

								if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].length() > 0) {
									curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
											+ start_column_tFileInputExcel_1 + 1;
									curColName_tFileInputExcel_1 = "Emp_Hire_Date";
									if (7 < actual_end_column_tFileInputExcel_1) {
										try {
											java.util.Date dateGMT_tFileInputExcel_1 = ((jxl.DateCell) row_tFileInputExcel_1[columnIndex_tFileInputExcel_1
													+ start_column_tFileInputExcel_1]).getDate();
											row6.Emp_Hire_Date = new java.util.Date(dateGMT_tFileInputExcel_1.getTime()
													- java.util.TimeZone.getDefault()
															.getOffset(dateGMT_tFileInputExcel_1.getTime()));
										} catch (java.lang.Exception e) {
											globalMap.put("tFileInputExcel_1_ERROR_MESSAGE", e.getMessage());

											throw new RuntimeException("The cell format is not Date in ( Row. "
													+ (nb_line_tFileInputExcel_1 + 1) + " and ColumnNum. "
													+ curColNum_tFileInputExcel_1 + " )");
										}
									}
								} else {
									row6.Emp_Hire_Date = null;
									emptyColumnCount_tFileInputExcel_1++;
								}
								columnIndex_tFileInputExcel_1 = 8;

								if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].length() > 0) {
									curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
											+ start_column_tFileInputExcel_1 + 1;
									curColName_tFileInputExcel_1 = "Emp_Term_Date";
									if (8 < actual_end_column_tFileInputExcel_1) {
										try {
											java.util.Date dateGMT_tFileInputExcel_1 = ((jxl.DateCell) row_tFileInputExcel_1[columnIndex_tFileInputExcel_1
													+ start_column_tFileInputExcel_1]).getDate();
											row6.Emp_Term_Date = new java.util.Date(dateGMT_tFileInputExcel_1.getTime()
													- java.util.TimeZone.getDefault()
															.getOffset(dateGMT_tFileInputExcel_1.getTime()));
										} catch (java.lang.Exception e) {
											globalMap.put("tFileInputExcel_1_ERROR_MESSAGE", e.getMessage());

											throw new RuntimeException("The cell format is not Date in ( Row. "
													+ (nb_line_tFileInputExcel_1 + 1) + " and ColumnNum. "
													+ curColNum_tFileInputExcel_1 + " )");
										}
									}
								} else {
									row6.Emp_Term_Date = null;
									emptyColumnCount_tFileInputExcel_1++;
								}
								columnIndex_tFileInputExcel_1 = 9;

								if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].length() > 0) {
									curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
											+ start_column_tFileInputExcel_1 + 1;
									curColName_tFileInputExcel_1 = "Manager_ID";
									row6.Manager_ID = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1];
								} else {
									row6.Manager_ID = null;
									emptyColumnCount_tFileInputExcel_1++;
								}

								nb_line_tFileInputExcel_1++;

							} catch (java.lang.Exception e) {
								globalMap.put("tFileInputExcel_1_ERROR_MESSAGE", e.getMessage());
								whetherReject_tFileInputExcel_1 = true;
								System.err.println(e.getMessage());
								row6 = null;
							}

							/**
							 * [tFileInputExcel_1 begin ] stop
							 */

							/**
							 * [tFileInputExcel_1 main ] start
							 */

							currentComponent = "tFileInputExcel_1";

							tos_count_tFileInputExcel_1++;

							/**
							 * [tFileInputExcel_1 main ] stop
							 */

							/**
							 * [tFileInputExcel_1 process_data_begin ] start
							 */

							currentComponent = "tFileInputExcel_1";

							/**
							 * [tFileInputExcel_1 process_data_begin ] stop
							 */
// Start of branch "row6"
							if (row6 != null) {

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

								row6_HashRow.Employee_ID = row6.Employee_ID;

								row6_HashRow.Start_Date = row6.Start_Date;

								row6_HashRow.End_Date = row6.End_Date;

								row6_HashRow.Job_Title = row6.Job_Title;

								row6_HashRow.Salary = row6.Salary;

								row6_HashRow.Gender = row6.Gender;

								row6_HashRow.Birth_Date = row6.Birth_Date;

								row6_HashRow.Emp_Hire_Date = row6.Emp_Hire_Date;

								row6_HashRow.Emp_Term_Date = row6.Emp_Term_Date;

								row6_HashRow.Manager_ID = row6.Manager_ID;

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

							} // End of branch "row6"

							/**
							 * [tFileInputExcel_1 process_data_end ] start
							 */

							currentComponent = "tFileInputExcel_1";

							/**
							 * [tFileInputExcel_1 process_data_end ] stop
							 */

							/**
							 * [tFileInputExcel_1 end ] start
							 */

							currentComponent = "tFileInputExcel_1";

						}

						globalMap.put("tFileInputExcel_1_NB_LINE", nb_line_tFileInputExcel_1);

					}

				} finally {

					if (!(source_tFileInputExcel_1 instanceof java.io.InputStream)) {
						workbook_tFileInputExcel_1.close();
					}

				}

				ok_Hash.put("tFileInputExcel_1", true);
				end_Hash.put("tFileInputExcel_1", System.currentTimeMillis());

				/**
				 * [tFileInputExcel_1 end ] stop
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
				 * [tFileInputExcel_1 finally ] start
				 */

				currentComponent = "tFileInputExcel_1";

				/**
				 * [tFileInputExcel_1 finally ] stop
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

		globalMap.put("tFileInputExcel_1_SUBPROCESS_STATE", 1);
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
		final Job03_Organization_Dim Job03_Organization_DimClass = new Job03_Organization_Dim();

		int exitCode = Job03_Organization_DimClass.runJobInTOS(args);

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
			java.io.InputStream inContext = Job03_Organization_Dim.class.getClassLoader().getResourceAsStream(
					"projetdatav1/job03_organization_dim_0_1/contexts/" + contextStr + ".properties");
			if (inContext == null) {
				inContext = Job03_Organization_Dim.class.getClassLoader()
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
					(endUsedMemory - startUsedMemory) + " bytes memory increase when running : Job03_Organization_Dim");
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
 * 242798 characters generated by Talend Open Studio for Data Integration on the
 * 24 janvier 2022 à 01:52:12 CET
 ************************************************************************************************/
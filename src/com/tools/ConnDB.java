package com.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnDB {
    //�����߸���Ա����
	public Connection conn=null;//���ݿ����Ӷ���
	public Statement stmt=null;//Statement��������ִ��SQL���
	public ResultSet rs =null;//���������
	public static String dbClassName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    public static String dbUrl = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=db_shop";
    public static String dbUser="sa";//��¼SQL Server���û���
    public static String dbPwd="";
			
    /**
	 * ���ܣ����������ݿ������
	 * 
	 * @return
	 */
	public static Connection getConnection() {
		Connection conn = null;						// �������ݿ����Ӷ���
		try {											// ��׽�쳣
			Class.forName(dbClassName).newInstance();	// װ�����ݿ�����
             // ��ȡ���ݿ����Ӷ���
			conn = DriverManager.getConnection(dbUrl, dbUser, dbPwd); 
		} catch (Exception e) {						// �����쳣
			e.printStackTrace();						// ����쳣��Ϣ
		}
		if (conn == null) {
			System.err.println("DbConnectionManager.getConnection():" 
                     + dbClassName + "\r\n :" + dbUrl + "\r\n "
					+ dbUser + "/" + dbPwd);			// ���������Ϣ���������
		}
		return conn; 									// �������ݿ����Ӷ���
	}
	/**
	 * ���ܣ���������
	 * 
	 * @param sql
	 * @return
	 */
	public int executeUpdate(String sql) {
		int result = 0;							// �������ݵļ�¼����
		try {// ��׽�쳣
			conn = getConnection();				// ��ȡ���ݿ�����
			// ��������ִ��SQL����Statement����
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			result = stmt.executeUpdate(sql);		// ִ��SQL���
		} catch (SQLException ex) {				// �����쳣
			result = 0;							// ָ���������ݵļ�¼����Ϊ0����ʾû�и�������
			ex.printStackTrace();					// ����쳣��Ϣ
		}
		try {									// ��׽�쳣
			stmt.close();						// �ر�����ִ��SQL����Statement����
		} catch (SQLException ex1) {				// �����쳣
			ex1.printStackTrace();				// ����쳣��Ϣ
		}
		return result;							// ���ظ������ݵļ�¼����
	}
	/**
	 * ���ܣ�����ָ����SQL����ѯ����
	 * 
	 * @param sql
	 * @return
	 */
	public ResultSet executeQuery(String sql) {
		try {									// ��׽�쳣
			conn = getConnection();				// ��ȡ���ݿ�����
			// ��������ִ��SQL����Statement����
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = stmt.executeQuery(sql);			// ִ��SQL���
		} catch (SQLException ex) {				// �����쳣
			ex.printStackTrace();					// ����쳣��Ϣ
		}
		return rs;								// ���ز�ѯ���
	}
	/**
	 * ���ܣ��ر����ݿ�����
	 */
	public void close() {
		try { 									// ��׽�쳣
			if (rs != null) {
				rs.close();						// �رս��������
			}
			if (stmt != null) {
				stmt.close(); 					// �ر�Statement����
			}
			if (conn != null) {
				conn.close(); 					// �ر����ݿ����Ӷ���
			}
		} catch (Exception e) {					// �����쳣
			e.printStackTrace(System.err);		// ����쳣��Ϣ
		}
	}
	/**
	 * ���ܣ��������ݿ������Ƿ�ɹ�
	 * @param args
	 */
	public static void main(String[] args) {
		if (getConnection() != null) {			//�����ȡ�����ݿ�����
			System.out.print("���ݿ����ӳɹ���");
		}
	}
	
}
